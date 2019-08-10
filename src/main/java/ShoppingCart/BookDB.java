package ShoppingCart;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 创建数据库模拟类
 * 2019.07.20
 */
public class BookDB {
    private static Map<String,Book> books = new LinkedHashMap<String, Book>();
    static {
        books.put("1",new Book("1","JavaWeb开发"));
        books.put("2",new Book("2","安卓开发"));
        books.put("3",new Book("3","大数据开发"));
        books.put("4",new Book("4","C++算法"));
    }
    //获取所有的图书
    public static Collection<Book> getAll(){
        return books.values();
    }
    //根据指定id获取图书
    public static Book getBook(String id){
        return books.get(id);
    }
}
