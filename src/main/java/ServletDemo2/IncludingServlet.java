package ServletDemo2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 请求包含 既包含IncludingServlet的数据，也包含IncludeServlet的数据
 * 2019.07.17
 */
public class IncludingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        //设置字符编码集
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("IncludeServlet? pl=abc");
        out.println("before including" + "<br>");
        rd.include(request,response);
        out.println("after including" + "<br>");
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
