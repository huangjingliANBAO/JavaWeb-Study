package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 实现ServletContextAttributeListener, HttpSessionAttributeListener,ServletRequestAttributeListener 接口
 * 并实现这些接口中的所有方法
 * 2019.08.04
 */
public class MyAttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener,
        ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        System.out.println("ServletContext添加属性：" + name + "="
                + servletContextAttributeEvent.getServletContext().getAttribute(name));
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        System.out.println("ServletContext移除属性：" + name);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        System.out.println("ServletContext替换属性：" + name + "="
                + servletContextAttributeEvent.getServletContext().getAttribute(name));
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        System.out.println("ServletRequest添加属性：" + name + "="
                + servletRequestAttributeEvent.getServletRequest().getAttribute(name));
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        System.out.println("ServletRequest移除属性:" + name);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        System.out.println("ServletRequest替换属性：" + name + "="
                + servletRequestAttributeEvent.getServletRequest().getAttribute(name));
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        System.out.println("HttpSession添加属性：" + name + "="
                + httpSessionBindingEvent.getSession().getAttribute(name));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        System.out.println("HttpSession移除属性：" + name);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        System.out.println("HttpSession替换属性：" + name + "="
                + httpSessionBindingEvent.getSession().getAttribute(name));
    }
}
