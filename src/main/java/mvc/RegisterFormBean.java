package mvc;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装注册表单信息
 * 2019.08.11
 */
public class RegisterFormBean {
    private String name;
    private String password;
    private String password2;
    private String email;
    //定义成员变量errors，用于封装表单验证时的错误信息
    private Map<String,String> errors = new HashMap<String, String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean validate(){
        boolean flag = true;
        if (name == null || name.trim().equals("")){
            errors.put("name","请输入姓名");
            flag = false;
        }
        if (password == null || password.trim().equals("")){
            errors.put("password","请输入密码");
            flag = false;
        }else if (password.length() > 12 || password.length() < 6){
            errors.put("password","请输入6-12个字符");
            flag = false;
        }
        if (password != null && !password.equals(password2)){
            errors.put("password2","两次输入的密码不匹配。");
            flag = false;
        }
        if (email == null || email.trim().equals("")){
            errors.put("email","请输入邮箱");
            flag = false;
        }else if (!email.matches("[a-zA-Z0-9_-] + @[a-zA-Z0-9_-] + (\\.[a-zA-Z0-9_-]+)+")){
            errors.put("email","邮箱格式错误");
            flag = false;
        }
        return flag;
    }
    //向map集合errors中添加错误信息
    public void setErrorMsg(String err,String errMsg){
        if ((err != null) && (errMsg != null)){
            errors.put(err,errMsg);
        }
    }
    //获取errors集合
    public Map<String,String> getErrors(){
        return errors;
    }
}
