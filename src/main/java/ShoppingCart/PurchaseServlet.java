package ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 将所有购买的图书添加到购物车
 * 2019.07.20
 */
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws ServletException, IOException {
        //获取用户购买的商品
        String id  = request.getParameter("id");
        if (id == null){
            //如果id为null，重定向到ListBookServlet页面
            String url = "/JavaWeb/ListBookServlet";
            response.sendRedirect(url);
            return;
        }
        Book book = BookDB.getBook(id);
        //创建或者获得用户的Session对象
        HttpSession session = request.getSession();
        //从Session对象中获得用户的购物车
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null){
            //首次购买，为用户创建一个购物车（List集合模拟购物车）
            cart = new ArrayList<Book>();
            //将购物车存入Session对象
            session.setAttribute("cart",cart);
        }
        //将商品放入购物车
        cart.add(book);
        //创建Cookie存放Session的标识号
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("/JavaWeb");
        response.addCookie(cookie);
        //重定向到购物车页面
        String url = "/JavaWeb/CartServlet";
        response.sendRedirect(url);
    }
}
