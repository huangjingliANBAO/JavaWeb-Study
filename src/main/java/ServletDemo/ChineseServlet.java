package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 解决中文输出乱码问题
 * 2019.07.13
 */
public class ChineseServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException,IOException{
        //设置字符编码
        response.setContentType("text/html;charset=utf-8");
        String data = "中国";
        PrintWriter out = response.getWriter();
        out.println(data);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
