<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-08-13
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="GBK" language="java"
import="mvc.UserBean" %>
<html>
<head>
    <title>登录成功</title>
</head>
<style type="text/css">
    #main{
        width: 500px;
        height: auto;
    }
    #main div{
        width: 200px;
        height: auto;
    }
    ul{
        padding-top: 1px;
        padding-left: 1px;
        list-style: none;
    }
</style>
<body>
<%
    if (session.getAttribute("userBean") == null){

%>
<jsp:forward page="/jsp/register.jsp"/>
<%
    return;
    }
%>
<div id="main">
<div id="welcome">恭喜你，登录成功</div>
    <hr/>
    <div>你的信息</div>
</div>
<div>
    <ul>
        <li>你的姓名${userBean.name}</li>
        <li>你的邮箱${userBean.email}</li>
    </ul>
</div>
</body>
</html>
