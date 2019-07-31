package filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于请求转发给date.jsp页面
 * 2019.07.30
 */
public class ForwardServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException,IOException{
        request.getRequestDispatcher("/date.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)throws ServletException, IOException {
        doGet(request,response);
    }
}
