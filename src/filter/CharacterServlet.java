package filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于获取用户输出的请求参数，并将参数输出到控制台
 * 2019.08.02
 */
public class CharacterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("password"));
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)throws ServletException, IOException {
        doGet(request,response);
    }
}
