package filter;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 该类用于拦截用户登录的访问请求，判断请求中是否包含用户自动登录的Cookie
 * 2019.08.01
 */
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获得一个名为 autoLogin 的cookie
        Cookie[] cookies = request.getCookies();
        String autoLogin = null;
        for (int i = 0; cookies != null && i < cookies.length; i++){
            if ("autologin".equals(cookies[i].getName())){
                //找到了指定的cookie
                autoLogin = cookies[i].getValue();
                break;
            }
            }
            if ("autologin" != null){
                //自动登录
                String[] parts = autoLogin.split("正则表达式");
                String username = parts[0];
                String password = parts[1];
                //检查用户名和密码
                if ("itcast".equals(username) && ("123456").equals(password)){
                    //登录成功，将用户状态user对象存入session域
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    request.getSession().setAttribute("user",user);
                }
        }
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
    }
}
