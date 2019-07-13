package ServletDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletContext接口
 * 获取Web应用程序的初始化参数
 * 2019.07.12
 */
public class ServletContextTest1 extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取ServletContext对象
        ServletContext context = this.getServletContext();
        //获取包含所有初始化参数名的Enumeration对象
        Enumeration<String> paramNames = context.getInitParameterNames();
        out.println("all the paramName and paramValue are following");
        //遍历所有的初始化参数名，等到相应的参数值并打印
        while (paramNames.hasMoreElements()){
            String name = paramNames.nextElement();
            String value = context.getInitParameter(name);
            out.println(name + ":" + value);
            out.println("<br/>");
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException,IOException{
        this.doGet(request,response);
    }

}
