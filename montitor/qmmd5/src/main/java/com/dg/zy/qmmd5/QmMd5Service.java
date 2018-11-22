/**
 * Copyright (C), 2018,  智云有限公司
 * FileName: QmMd5Service
 * Author:   zhaomlb
 * Date:     2018/11/5 17:31
 * Description: MD5加密--奇门suanfa
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/5    17:31           版本号              描述
 */
package com.dg.zy.qmmd5;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能描述:MD5加密--奇门suanfa〉
 *
 * @author zhaomlb
 * @create 2018/11/5
 * @since 1.0.0
 */
public class QmMd5Service {
    private static final String URL = "http://localhost:8365/QMReceive.aspx";//"http://172.16.1.89/QMWeb/QMReceive.aspx";
    private static final String METHOD = "taobao.qimen.deliveryorder.create";
    private static final String FORMAT = "xml";
    private static final String APPKEY = "23075458";
    private static final String SECRETKEY = "54b1328683f2cdbdc412eb86bef7505a";

    private static final String V = "2.0";
    private static final String SIGNMETHOD = "md5";
    private static final String CUSTOMERID = "YKa";


    private static final String xml = "<request><deliveryOrder><deliveryOrderCode>1</deliveryOrderCode><preDeliveryOrderCode/><preDeliveryOrderId/><orderType>QTCK</orderType><warehouseCode>B400</warehouseCode><orderFlag/><sourcePlatformCode>TB</sourcePlatformCode><sourcePlatformName>Test淘宝</sourcePlatformName><createTime>2018-09-18 12:51:21</createTime><placeOrderTime>2018-09-18 08:14:42</placeOrderTime><payTime>2018-09-18 08:04:36</payTime><payNo>2018091822001122430514585794</payNo><operatorName>刘琼</operatorName><operateTime>2018-09-18 12:51:21</operateTime><shopNick>CandyMoyo膜玉旗舰店</shopNick><sellerNick/><buyerNick>夜已深1978</buyerNick><totalAmount>79</totalAmount><itemAmount>79</itemAmount><discountAmount>0</discountAmount><freight>0</freight><logisticsCode>ZTO</logisticsCode><logisticsName>WB中通</logisticsName><expressCode/><senderInfo><company>CandyMoyo膜玉旗舰店</company><name>李明</name><zipCode/><tel>13120566080</tel><mobile>13120566080</mobile><email/><countryCode>CN</countryCode><province>上海</province><city>上海市</city><town>浦东新区</town><area>浦东新区</area><detailAddress>11</detailAddress></senderInfo><receiverInfo><company/><name>刘佳</name><zipCode>046011</zipCode><tel/><mobile>15935510131</mobile><idType/><idNumber/><email/><countryCode>CN</countryCode><province>山西省</province><city>长治市</city><area>城区</area><town>城区</town><detailAddress>山西省长治市城区长治市南街演武南巷房建公司家属楼四单元三楼西户</detailAddress></receiverInfo><isUrgency>N</isUrgency><invoiceFlag>N</invoiceFlag><buyerMessage/><sellerMessage/><remark/></deliveryOrder><orderLines><orderLine><orderLineNo>1</orderLineNo><sourceOrderCode>221613837390373202</sourceOrderCode><subSourceOrderCode/><ownerCode>YKa</ownerCode><itemCode>101004011</itemCode><itemName>膜玉双色防水气垫染眉液CMQM02双色棕</itemName><itemId>1737880644</itemId><inventoryType>ZP</inventoryType><planQty>1</planQty><actualPrice>79.00</actualPrice></orderLine></orderLines></request>";

    public static void main(String[] args) {

        String posturl = getsign(xml);
        String result2;
        try {
            result2 = Send(posturl, xml);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        }
    }


    public static String getsign(String body) {
        StringBuilder url = new StringBuilder();
        url.append(URL).append("?");
        url.append("app_key=").append(APPKEY).append("&");
        url.append("method=").append(METHOD).append("&");
        url.append("timestamp=1&");
        url.append("format=").append(FORMAT).append("&");
        url.append("v=").append(V).append("&");
        url.append("sign_method=").append(SIGNMETHOD).append("&");

        url.append("customerId=").append(CUSTOMERID).append("&");
        //  return sign(url.toString(), body, SECRETKEY);

       return url.append("sign=").append(sign(url.toString(), body, SECRETKEY)).toString();

    }

    private static String sign(String url, String body, String secretKey) {

        Map<String, String> params = getParamsFromUrl(url);

        // 1. 第一步，确保参数已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 2. 第二步，把所有参数名和参数值拼接在一起(包含body体)
        String joinedParams = joinRequestParams(params, body, secretKey, keys);


        // 3. 第三步，使用加密算法进行加密（目前仅支持md5算法）
        String signMethod = params.get("sign_method");
        byte[] abstractMesaage = digest(joinedParams);
        // 4. 把二进制转换成大写的十六进制
        String sign = byte2Hex(abstractMesaage);
        return sign;

    }

    private static Map<String, String> getParamsFromUrl(String url) {
        Map<String, String> requestParams = new HashMap<String, String>();
        try {
            String fullUrl = URLDecoder.decode(url, "UTF-8");
            String[] urls = fullUrl.split("\\?");
            if (urls.length == 2) {
                String[] paramArray = urls[1].split("&");
                for (String param : paramArray) {
                    String[] params = param.split("=");
                    if (params.length == 2) {
                        requestParams.put(params[0], params[1]);
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            // TODO
        }
        return requestParams;
    }

    private static String byte2Hex(byte[] bytes) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int j = bytes.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (byte byte0 : bytes) {
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    private static byte[] digest(String message) {
        try {
            MessageDigest md5Instance = MessageDigest.getInstance("MD5");
            md5Instance.update(message.getBytes("UTF-8"));
            return md5Instance.digest();
        } catch (UnsupportedEncodingException e) {
            //TODO
            return null;
        } catch (NoSuchAlgorithmException e) {
            //TODO
            return null;
        }
    }

    private static String joinRequestParams(Map<String, String> params, String body, String secretKey, String[] sortedKes) {
        StringBuilder sb = new StringBuilder(secretKey); // 前面加上secretKey

        for (String key : sortedKes) {
            if ("sign".equals(key)) {
                continue; // 签名时不计算sign本身
            } else {
                String value = params.get(key);
                if (isNotEmpty(key) && isNotEmpty(value)) {
                    sb.append(key).append(value);
                }
            }
        }
        sb.append(body); // 拼接body体
        sb.append(secretKey); // 最后加上secretKey
        return sb.toString();
    }

    private static boolean isNotEmpty(String s) {
        return null != s && !"".equals(s);
    }


    public static String Send(String urlwithpar, String Input) throws IOException, HttpException {


        // 转发消息
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpRequest = new HttpPost(urlwithpar);

        RequestConfig requestConfig = RequestConfig.custom().build();//设置请求和传输超时时间
        httpRequest.setConfig(requestConfig);
        HttpEntity entity = new StringEntity(Input, "utf-8");
        httpRequest.setEntity(entity);
        HttpResponse response;
        Integer httpcode = -1;
        try {
            response = client.execute(httpRequest);
            httpcode = response.getStatusLine().getStatusCode();
            if (httpcode == 200) {
                String resEntityStr = EntityUtils.toString(response.getEntity());
                return resEntityStr;
            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        } finally {
            httpRequest.releaseConnection();
            client.close();
        }

        return null;
    }


}
 