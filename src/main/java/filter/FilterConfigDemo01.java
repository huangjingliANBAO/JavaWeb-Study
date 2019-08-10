package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 学习FilterConfig
 * 2019.07.31
 */
public class FilterConfigDemo01 implements Filter {
    private String characterEncoding;
    FilterConfig fc;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取FilterConfig对象
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      //输出参数信息
        characterEncoding = fc.getInitParameter("encoding");
        System.out.println("encoding初始参数的值为：" + characterEncoding);
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
