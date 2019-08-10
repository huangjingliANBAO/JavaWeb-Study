package UserLogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当用户单击退出时，该类会将Session对象的用户信息移除，并跳转到IndexServlet页面
 * 2019.07.21
 */
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        //将Session对象中的User对象移除
        request.getSession().removeAttribute("user");
        response.sendRedirect("/JavaWeb/IndexServlet");
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
