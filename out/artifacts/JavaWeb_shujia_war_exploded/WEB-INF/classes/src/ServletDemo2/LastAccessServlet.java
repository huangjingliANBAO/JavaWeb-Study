package ServletDemo2;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用Cookie会话技术，显示用户上次访问时间
 * 2019.07.18
 */
public class LastAccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String lastAccessTime = null;
        //获取所有的cookie，并将这些cookie存放在数组中
        Cookie[] cookies = request.getCookies();
        //遍历cookies数组
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAccess".equals(cookies[i].getName())) {
                //如果cookie的名称为lastAccess，则获取该cookie的值
                lastAccessTime = cookies[i].getValue();
                break;
            }
        }
        //判断是否存在名称为lastAccess的cookie
        if (lastAccessTime == null) {
            response.getWriter().print("你是首次访问本站！！！");
        } else {
            response.getWriter().print("你上次访问的时间是：" + lastAccessTime);
        }
        //创建cookie，将当前时间作为cookie的值发送给客户端
        String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        Cookie cookie = new Cookie("lastAccess", currentTime);
        //cookie的有效时间设置为1小时
        cookie.setMaxAge(60*60);
        //发送cookie
        response.addCookie(cookie);
    }

    public void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
