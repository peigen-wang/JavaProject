package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author peigen
 */
@WebFilter(filterName = "CharacterFilter", urlPatterns = "*", initParams = {
        @WebInitParam(name = "encoding", value = "UTF-8")
})
public class CharacterFilter implements Filter {
    String encoding = null;

    @Override
    public void destroy() {
        encoding = null;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (encoding != null) {
            req.setCharacterEncoding(encoding);
            resp.setContentType("text/html;charset=" + encoding + ";pageEncoding=" + encoding);
        }

        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }

}
