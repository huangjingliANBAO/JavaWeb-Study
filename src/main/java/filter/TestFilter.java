package filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用于拦截TestServlet类
 * 2019.07.29
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //过滤器对象在初始化时调用，可以配置一些初始化参数
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
    //用于拦截用户的请求，如果和当前过滤器的拦截路径匹配，该方法会被调用
        PrintWriter out = servletResponse.getWriter();
        out.write("Hello MyFilter");
    }

    @Override
    public void destroy() {
        //过滤器对象在销毁时自动调用，释放资源
    }
}
