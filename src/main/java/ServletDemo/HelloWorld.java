package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 实现第一个Servlet程序
 * 2019.07.10
 */
public class HelloWorld extends HttpServlet {
    private String message;

    /**
     * 容器在创建好Servlet对象后，就会调用init（）方法。
     * 该方法接受一个ServletConfig类型的参数，
     * Servlet容器通过这个参数向Servlet传递初始化配置信息
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        message = "Hello world, Servlet I am JingliHuang";
    }

    /**
     * doGet()方法用于处理GET类型的HTTP请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html");
        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    /**
     * destroy()方法负责释放Servlet对象占用的资源。
     * 当服务器关闭或者Servlet对象移除时，
     * Servlet对象会被销毁，Servlet容器会调用destroy()方法
     */
    @Override
    public void destroy() {
        super.destroy();
    }
}
