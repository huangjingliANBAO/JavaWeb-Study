package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 发送响应消息体
 * 用getOutputStream()方法
 * 2019.07.13
 */
public class PrintServletTest extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException,IOException{
        String data = "Hello World";
        //获取字节输出流对象
        OutputStream out = response.getOutputStream();
        out.write(data.getBytes());
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
