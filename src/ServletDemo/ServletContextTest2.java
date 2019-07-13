package ServletDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现多个Servlet对象共享数据
 * 2019.07.12
 */
public class ServletContextTest2 extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException,IOException{
        ServletContext context = this.getServletContext();
        //通过setAttribute()方法设置属性值
        context.setAttribute("data","this servlet save data");
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }

}
