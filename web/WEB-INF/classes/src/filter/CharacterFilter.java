package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 用于拦截用户的请求访问，实现统一全站编码的功能
 * 2019.08.02
 */
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /**
         * 拦截所有的请求 解决全站中文乱码
         * 指定request和response的编码
         */
        request.setCharacterEncoding("utf-8");//只对消息体有效
        response.setContentType("text/html;charset=utf-8");
        //对request进行包装
        CharacterRequest characterRequest = new CharacterRequest(request);
        filterChain.doFilter(characterRequest,response);
    }
    @Override
    public void destroy() {
    }
}

/**
 * 通过HttpServletRequestWrapper类对HttpServletRequest类进行包装，
 * 通过重写getParameter()方法
 * 类设置GET方式提交参数的编码。
 */
class CharacterRequest extends HttpServletRequestWrapper{
private HttpServletRequest request;
    public CharacterRequest(HttpServletRequest request) {
        super(request);
        this.request=request;
    }
    public String getParameter(String name){
        //调用被包装对象的getParameter（）方法，获得请求参数
        String value = super.getParameter(name);
       if (value == null)
           return null;
        //判断请求方式
        String method = super.getMethod();
        if ("get".equalsIgnoreCase(method)){
            try{
                value = new String(value.getBytes("iso-8859-1"),"utf-8");
            }catch (UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }
        }
        //解决乱码的返回结果
        return value;
    }
}