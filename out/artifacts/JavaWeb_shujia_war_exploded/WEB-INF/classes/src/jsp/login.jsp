<%--
  Created by IntelliJ IDEA.
  User: 黄敬理
  Date: 2019-08-01
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>用户登录</title>
</head>
<center><h3>用户登录</h3></center>
<body style="text-align: center;">
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    <table border="1" width="600px" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td height="30" align="center">用户名：</td>
            <td>
                &nbsp;&nbsp;
                <input type="text" name="username">${errerMsg}
            </td>
        </tr>
        <tr>
            <td height="30" align="center">密 &nbsp; 码：</td>
            <td>
                &nbsp;&nbsp;
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td height="35" align="center">自动登录时间</td>
            <td><input type="radio" name="autologin" value="${60*60*24*31}">一个月
                <input type="radio" name="autologin" value="${60*60*24*31*3}">三个月
                <input type="radio" name="autologin" value="${60*60*24*31*6}">半年
                <input type="radio" name="autologin" value="${60*60*24*31*12}">一年
            </td>
        </tr>
        <tr>
            <td height="30" colspan="2" align="center">
                <input type="submit" value="登录">
                &nbsp; &nbsp; &nbsp; &nbsp;
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
