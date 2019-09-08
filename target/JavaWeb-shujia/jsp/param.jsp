<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-07-27
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/../src/main/webapp/jsp/param.jsp">
    num1:<input type="text" name="num1"><br>
    num2:<input type="text" name="num"><br>
    num3:<input type="text" name="num"><br>
    <input type="submit" value="提交">&nbsp;&nbsp;
    <input type="submit" value="重置"><
    <hr>
    num1:${param.num1}<br>
    num2:${paramValues.num[0]}<br>
    num3:${paramValues.num[1]}<br>
</form>
</body>
</html>
