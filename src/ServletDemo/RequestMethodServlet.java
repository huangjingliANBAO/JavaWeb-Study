package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试doGet()和doPost()方法
 * 2019.07.11
 */
public class RequestMethodServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write("this is doGet method");
    }
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write("this is doPost method");
    }
}
