package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现网页定时刷新
 * 2019.07.13
 */
public class RefreshServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException,IOException{
        //2秒后刷新并跳转到指定网页
        response.setHeader("Refresh","2;URL=http://www.itcast.cn");
        /**
         * 每隔3秒定时刷新当前页面
         * response.setHeader("Refresh","3");
         * response.getWriter().println(new java.util.Date());
         */
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
