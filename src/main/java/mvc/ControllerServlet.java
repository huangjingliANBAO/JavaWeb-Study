package mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理用户请求
 * 2019.08.13
 */
public class ControllerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException{
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)throws ServletException,IOException{
        response.setHeader("Content-type","text/html;charset=GBK");
        response.setCharacterEncoding("GBK");
        //获取用户注册时表单提交的用户参数信息
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        //将获取的参数封装到表单registerFromBean
        RegisterFormBean formBean = new RegisterFormBean();
        formBean.setName(name);
        formBean.setPassword(password);
        formBean.setPassword2(password2);
        formBean.setEmail(email);
        //验证参数
        if (!formBean.validate()){
            request.setAttribute("formBean",formBean);
            request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
            return;
        }
        //将数据封装到UserBean
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setPassword(password);
        userBean.setEmail(email);

        boolean b = DBUtil.getInstance().insertUser(userBean);
        if (!b){
            request.setAttribute("DBMes","你注册的用户已存在");
            request.setAttribute("formBean",formBean);
            request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
            return;
        }
        response.getWriter().println("恭喜你注册成功，3秒钟自动跳转");
        request.getSession().setAttribute("userBean",userBean);
        response.setHeader("refresh","3;url=/jsp/loginSuccess.jsp");
    }
}
