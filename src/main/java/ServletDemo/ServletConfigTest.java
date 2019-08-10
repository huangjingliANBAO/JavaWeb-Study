package ServletDemo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试ServletConfig接口
 * 2019.07.12
 */
public class ServletConfigTest extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //获得ServletConfig对象
        ServletConfig config = this.getServletConfig();
        //获得参数名为encoding对应的参数值
        String param = config.getInitParameter("encoding");
        out.println("encoding=" + param);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException,IOException{
        this.doGet(request,response);
    }
}
