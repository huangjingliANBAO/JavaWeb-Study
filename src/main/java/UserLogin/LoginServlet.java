package UserLogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户登录界面
 * 2019.07.21
 */
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("check_code");
        String savedCode = (String) request.getSession().getAttribute("check_code");
        PrintWriter pw = response.getWriter();
        //假设正确的用户名 是itcast 密码是123
        if (("itcast").equals(username) && ("123").equals(password) && checkCode.equals(savedCode)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/JavaWeb/IndexServlet");
        }else if (checkCode.equals(savedCode)){
            pw.print("用户名或密码错误，登录失败！");
        }else {
            pw.print("验证码错误");
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
