<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-07-27
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
使用JSP
名称：<%=request.getAttribute("username")%><br>
地址：<%=request.getAttribute("address")%><br>
<hr>
使用EL表达式<br>
名称：${username}<br>
地址：${address}<br>
</body>
</html>
