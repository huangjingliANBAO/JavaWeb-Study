package ServletDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 读取Web应用下的资源文件
 * 2019.07.12
 */
public class ServletContextTest4 extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = this.getServletContext();
        //获取文件绝对路径
        String path = context.getRealPath("WEB-INF/classes/itcast.properties");
        FileInputStream in = new FileInputStream(path);
        Properties pros = new Properties();
        pros.load(in);
        out.println("Company=" + pros.getProperty("Company") + "<br/>");
        out.println("Address=" + pros.getProperty("Address") + "<br/>");
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
