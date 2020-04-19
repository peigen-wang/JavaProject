package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author peigen
 */
@WebFilter(filterName = "MyFirstFilter",urlPatterns = "/MyFirstFilter")
public class MyFirstFilter implements Filter {
    @Override
    public void destroy() {
        //释放资源
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //过滤处理
        count++;
        HttpServletRequest request = (HttpServletRequest) req;
        ServletContext context = request.getSession().getServletContext();
        context.setAttribute("count",count);
        chain.doFilter(req, resp);
    }

    private int count;

    @Override
    public void init(FilterConfig config) throws ServletException {
        //初始化处理
        String param = config.getInitParameter("count");
        count = Integer.valueOf(param);
    }

}
