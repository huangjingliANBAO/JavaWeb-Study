package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取请求行消息
 * 2019.07.14
 */
public class RequestLineServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求行的相关信息
        out.println("getMethod:" + request.getMethod() + "<br>");
        out.println("getRequestURI:" + request.getRequestURI() + "<br>");
        out.println("getQueryString:" + request.getQueryString() + "<br>");
        out.println("getProtocol:" + request.getProtocol() + "<br>") ;
        out.println("getContextPath:" + request.getContextPath() + "<br>");
        out.println("getPathInfo:" + request.getPathInfo() + "<br>");
        out.println("getPathTranslated:" + request.getPathTranslated() + "<br>");
        out.println("getServletPath" + request.getServletPath() + "<br>");
        out.println("getRemoteAddr:" + request.getRemoteAddr() + "<br>");
        out.println("getRemoteHost:" + request.getRemoteHost() + "<br>");
        out.println("getRemotePort:" +request.getRemotePort() + "<br>");
        out.println("getLocalName:" + request.getLocalName() + "<br>");
        out.println("getLocalPort:" + request.getLocalPort() + "<br>");
        out.println("getServletName:" + request.getServerName() + "<br>");
        out.println("getServletPort:" + request.getServerPort() + "<br>");
        out.println("getScheme:" + request.getScheme() + "<br>");
        out.println("getRequestURL" + request.getRequestURL() + "<br>");
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request,response);
    }
}
