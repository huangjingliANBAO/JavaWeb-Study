package filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 学习Filter链
 * 2019.07.31
 */
public class Filter02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        out.write("this Filter02 Before<br/>");
        filterChain.doFilter(servletRequest,servletResponse);
        out.write("<br/>this Filter02 After<br/>");
    }

    @Override
    public void destroy() {

    }
}
