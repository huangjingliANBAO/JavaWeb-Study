package ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * 该Servlet显示所有可购买的图书列表
 * 2019.07.20
 */
public class ListBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException {
       response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Collection<Book> books = BookDB.getAll();
        out.write("本站提供的图书有：<br>" );
        for (Book book : books){
            String url = "/JavaWeb/PurchaseServlet?id=" + book.getId();
            out.write(book.getName() + "<a href='" + url + "'>点击购买</a><br>");
        }
    }
}
