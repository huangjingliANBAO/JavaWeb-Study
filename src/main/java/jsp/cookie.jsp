<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-07-27
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Cookie对象的信息:<br>
${cookie.userName}<br>
Cookie对象的名称和值：<br>
${cookie.userName.name}=${cookie.userName.value}
<% response.addCookie(new Cookie("userName","itcast"));%>
</body>
</html>
