<%--
  Created by IntelliJ IDEA.
  User: �ƾ���
  Date: 2019-08-13
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="GBK" language="java"
import="mvc.UserBean" %>
<html>
<head>
    <title>��¼�ɹ�</title>
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
<div id="welcome">��ϲ�㣬��¼�ɹ�</div>
    <hr/>
    <div>�����Ϣ</div>
</div>
<div>
    <ul>
        <li>�������${userBean.name}</li>
        <li>�������${userBean.email}</li>
    </ul>
</div>
</body>
</html>
