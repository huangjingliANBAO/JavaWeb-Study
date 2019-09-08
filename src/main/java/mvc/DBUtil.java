package mvc;

import java.util.HashMap;

/**
 * 模拟数据库
 * 2019.08.11
 */
public class DBUtil {
    private static DBUtil instance = new DBUtil();
    private HashMap<String,UserBean> users = new HashMap<String, UserBean>();
    private DBUtil(){
        UserBean user1 = new UserBean();
        user1.setName("mvc");
        user1.setPassword("123456789");
        user1.setEmail("fsadgsdag@qq.com");
        users.put("mvc",user1);

        UserBean user2 = new UserBean();
        user1.setName("jdbc");
        user1.setPassword("12345678900");
        user1.setEmail("fsasgsdag@qq.com");
        users.put("jdbc",user2);
    }
    public static DBUtil getInstance(){
        return instance;
    }
    //获取数据库的数据
    public UserBean getUser(String userName){
        UserBean user = users.get(userName);
        return user;
    }
    //向数据库插入数据
    public  boolean insertUser(UserBean user){
        if (user == null){
            return false;
        }
        String userName = user.getName();
        if (users.get(userName) != null){
            return false;
        }
        users.put(userName,user);
        return true;
    }
}
