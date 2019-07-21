package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制台获取请求参数
 * 2019.07.14
 */
public class RequestParamsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        //设置request对象的解码方式
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名：" + name);
        System.out.println("密  码：" + password);
        //获取参数名为“hobby”的值
        String[] hobbys = request.getParameterValues("hobby");
        System.out.println("爱好");
        for (int i = 0; i < hobbys.length; i++){
            System.out.println(hobbys[i] + ",");
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
