/**
 * Copyright (C), 2018,  有限公司
 * FileName: MySessionListener
 * Author:   zhaomlb
 * Date:     2018/11/20 20:28
 * Description:
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/20    20:28           版本号              描述
 */

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 〈功能描述:〉
 *
 * @author zhaomlb
 * @create 2018/11/20
 * @since 1.0.0
 */
public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        OnlineCounter.rize();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        OnlineCounter.reduce();
    }
}
 