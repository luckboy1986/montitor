/**
 * Copyright (C), 2018,  有限公司
 * FileName: MyFliter
 * Author:   zhaomlb
 * Date:     2018/11/21 15:53
 * Description:
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/21    15:53           版本号              描述
 */

import javax.servlet.*;
import java.io.IOException;

/**
 * 〈功能描述:〉
 *
 * @author zhaomlb
 * @create 2018/11/21
 * @since 1.0.0
 */
public class MyFliter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
 