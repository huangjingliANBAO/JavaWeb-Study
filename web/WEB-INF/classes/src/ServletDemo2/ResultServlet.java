package ServletDemo2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 请求转发-ResultServlet接收RequestForwardServlet的数据
 * 2019.07.17
 */
public class ResultServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取PrintWriter对象用于输出信息
        PrintWriter out = response.getWriter();
        //获取request请求对象中保存的数据
        String company = (String) request.getAttribute("company");
        if (company != null){
            out.println("公司名称：" + company + "<br>");
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
