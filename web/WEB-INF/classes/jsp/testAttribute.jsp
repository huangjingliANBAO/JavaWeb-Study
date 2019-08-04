<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-08-04
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>这是一个测试对象属性信息监听器的页面</h3>
<%
    pageContext.getServletContext().setAttribute("username","soft1841");
    pageContext.getServletContext().setAttribute("username","soft1842");
    pageContext.getServletContext().removeAttribute("username");
    session.setAttribute("username", "soft1841");
    session.setAttribute("username", "soft1842");
    session.removeAttribute("username");
    request.setAttribute("username", "soft1841");
    request.setAttribute("username", "soft1842");
    request.removeAttribute("username");
%>
</body>
</html>
