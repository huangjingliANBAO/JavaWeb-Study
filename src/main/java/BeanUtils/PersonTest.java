package BeanUtils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 学习BeanUtils类
 * 2019.07.26
 */
public class PersonTest {
    public static void main(String[] args)throws Exception {
         Person p = new Person();
         //使用BeanUtils为属性取值
        BeanUtils.setProperty(p,"name","四方会谈");
        BeanUtils.setProperty(p,"address","南京");
        //使用BeanUtils获取属性值
        String name = BeanUtils.getProperty(p,"name");
        String address = BeanUtils.getProperty(p,"address");
        System.out.println("我们的名字是" + name + "  我们在" + address);
        //创建Map集合，用于存放属性及其属性值
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","四方会谈");
        map.put("address","南京");
        //使用populate()方法为对象的属性赋值
        BeanUtils.populate(p,map);
        System.out.println("姓名：" +p.getName() + ",地址：" + p.getAddress());
    }
}
