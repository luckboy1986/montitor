/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: JdbcTest
 * Author:   zhaomlb
 * Date:     2018/11/14 23:50
 * Description: JDBC测试
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/14    23:50           版本号              描述
 */

import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonString;
import com.mysql.cj.xdevapi.JsonValue;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 〈功能描述:JDBC测试〉
 *
 * @author zhaomlb
 * @create 2018/11/14
 * @since 1.0.0
 */


public class JdbcTest {

    final static String url = "jdbc:mysql://10.0.2.120:3306/k3_wms0827?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false&serverTimezone=Hongkong";
    final static String user = "root";
    final static String psd = "Mysql1234^";

    private String partner_id;

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    @Test
    public void test1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, psd);
            PreparedStatement pre = con.prepareStatement("select  * from ba_area ");
            ResultSet rst = pre.executeQuery();
            System.out.println(rst.getClass().getName());

            int count = rst.getMetaData().getColumnCount();
            while (rst.next()) {


                String name = rst.getMetaData().getColumnName(2);

                Class clz =this.getClass();
                Object ob = clz.getConstructor().newInstance();
                Field f = clz.getDeclaredField(name);
                f.setAccessible(true);
                f.set(ob, rst.getString(name));
                JSONObject jsonObject = (JSONObject) JSONObject.toJSON(ob);
                System.out.println(jsonObject.toJSONString());

               /* System.out.println(rst.getString("id"));
                System.out.println(rst.getString("partner_id"));
                System.out.println(rst.getString("area_id"));
                System.out.println(rst.getString("area_name"));*/
            }

            rst.close();
            pre.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 