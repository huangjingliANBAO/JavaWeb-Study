<%--
  Created by IntelliJ IDEA.
  User: �ƾ���
  Date: 2019-08-12
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="GBK" language="java" %>
<html>
<head>
    <title>�û�ע��</title>
    <style type="text/css">
        h3{
            margin-left: 100px;
        }
        #outer{
            width: 750px;
        }
        div{
            height: 20px;
            margin-bottom: 10px;
        }
        span{
            color: aqua;
        }
        .ch{
            width: 80px;
            text-align: right;
            float: left;
        }
        .ip{
            width: 500px;
            float: left;
        }
        .ip>input{
            margin-right: 20px;
        }
        #bt{
            margin-left: 50px;
        }
        #bt>input{
            margin-right: 30px;
        }

    </style>
</head>
<body>
<form action="/JavaWeb/ControllerServlet" method="post">
    <h3>�û�ע��</h3>
    <div id="outer">
        <div>
            <div class="ch">����</div>
            <div class="ip">
                <input type="text" name="name" value="${formBean.name}"/>
                <span>${formBean.errors.name}${DBMes}</span>
            </div>
        </div>
        <div>
            <div class="ch">����</div>
            <div class="ip">
                <input type="text" name="password" >
                <span>${formBean.errors.password}</span>
            </div>
        </div>
        <div>
            <div class="ch">ȷ������</div>
            <div class="ip">
                <input type="text" name="password2">
                <span>${formBean.errors.password2}</span>
            </div>
        </div>
        <div>
            <div class="ch">����</div>
            <div class="ip">
                <input type="text" name="email" value="${formBean.email}">
                <span>${formBean.errors.email}</span>
            </div>
        </div>
        <div id="bt">
            <input type="reset" value="����">
            <input type="submit" value="ע��">
        </div>
    </div>
</form>

</body>
</html>
