/**
 * Copyright (C), 2018,  有限公司
 * FileName: MvcHandleInterceptor
 * Author:   zhaomlb
 * Date:     2018/11/21 19:59
 * Description:
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/21    19:59           版本号              描述
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 〈功能描述:〉 
 *
 * @author zhaomlb
 * @create 2018/11/21
 * @since 1.0.0
 */
public class MvcHandleInterceptor extends HandlerInterceptorAdapter {
    public MvcHandleInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
 