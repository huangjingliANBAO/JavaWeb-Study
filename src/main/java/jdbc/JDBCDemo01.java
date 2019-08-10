package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *使用PreparedStatement对象对数据库进行插入数据的操作
 * 2019.08.06
 */
public class JDBCDemo01 {
    public static void main(String[] args)throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            //加载数据库驱动
         Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "root";
            //创建应用程序与数据库连接的Connection对象
            conn = DriverManager.getConnection(url,username,password);
            //执行的sql语句
            String sql = "INSERT INTO user(name,password)" + "VALUES(?,?)";
            //创建执行sql语句的PreparedStatement对象
            pstm = conn.prepareStatement(sql);
            //为sql语句中的参数赋值
            pstm.setString(1,"fsdafds");
            pstm.setString(2,"123456");
            //执行sql
            pstm.executeUpdate();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if (pstm != null){
                try{
                    pstm.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                pstm = null;
            }
            if (conn != null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
