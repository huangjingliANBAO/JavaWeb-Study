package filter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * 该类用于处理用户的登录请求
 * 2019.08.01
 */
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        //获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //检查用户名和密码
        if ("itcast".equals(username) && "123456".equals(password)){
            //登录成功
            //将用户状态user对象存入session域
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            //发送自动登录的Cookie
            String autoLogin = request.getParameter("autologin");
            if (autoLogin != null){
                //注意cookie的密码要加密
                Cookie cookie = new Cookie("autologin",username + "正则表达式" + password);
                cookie.setMaxAge(Integer.parseInt(autoLogin));
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            //跳转至首页
            response.sendRedirect(request.getContextPath() + "/index02.jsp");
        }else {
            request.setAttribute("errerMsg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)throws ServletException, IOException {
        doGet(request,response);
    }
}
