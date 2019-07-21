package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现请求重定向
 * 2019.07.13
 */
public class LoginServlet1 extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        //用HttpServletRequest对象的getParameter()方法获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //假设用户名和密码为：123和000
        if (("123").equals(username)&&("000").equals(password)){
            //如果用户名和密码正确，重定向到welcome.html
            response.sendRedirect("/welcome.html");
        }else {
            //如果用户名和密码错误，重定向到login.html
            response.sendRedirect("/login.html");
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        doGet(request,response);
    }
}
