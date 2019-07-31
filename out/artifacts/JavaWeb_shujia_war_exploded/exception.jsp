<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-07-24
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int a = 1;
    int b = 0;
%>
<%--此处会产生异常--%>
输出结果为: <%=(a / b)%>
</body>
</html>
