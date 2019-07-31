package filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 学习Filter链
 * 2019.07.31
 */
public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        out.write("this Filter01<br>");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
