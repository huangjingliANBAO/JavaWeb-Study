package EL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * myjsp.jsp的数据
 * 2019.07.27
 */
public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        request.setAttribute("username","四方会谈");
        request.setAttribute("address","南京");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/myjsp.jsp");
        dispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)throws ServletException, IOException {
        doGet(request,response);
    }
}
