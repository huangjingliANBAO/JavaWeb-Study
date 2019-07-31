<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-07-23
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP声明语句</title>
</head>
<%!
    int a = 100,b = 200;//定义变量
%>
<%!
    public String print(){//定义方法
        String str = "四方会谈";
        return str;
    }
%>
<body>
<%
    out.println(a + b);//输出两个变量的和
%>
<br>
<%
    out.println(print());//调用print()方法
%>
</body>
</html>
