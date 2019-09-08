<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-07-28
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
使用绝对路径构造URL：<br>
<c:url var="myURL"
value="http://localhost:8080/JavaWeb/test.jsp">
</c:url>
<a href="${myURL}">test.jsp</a><br>
使用相对路径构造URL：<br>
<c:url var="myURL"
value="test.jsp"/>
<a href="${myURL}">test.jsp</a>
</body>
</html>
