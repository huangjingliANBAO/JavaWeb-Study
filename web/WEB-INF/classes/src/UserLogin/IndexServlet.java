package UserLogin;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 判断用户是否已经登录，获取了保存用户信息的Session对象
 * 2019.07.21
 */
public class IndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        //创建或者获取保存用户信息的Session对象
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            response.getWriter().print("您还没有登录，请<a href='/JavaWeb/html/login.html'>登录</a>");
        }else {
            response.getWriter().print("您已登录，欢饮你，" + user.getUsername() + "!");
            response.getWriter().print("<a href='/JavaWeb/LogoutServlet'>退出</a>");
            //创建Cookie存放Session的标识号
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60*30);
            cookie.setPath("/JavaWeb");
            response.addCookie(cookie);
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
