<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width:650px;
        }
    </style>
</head>
<body>
    <%--在jsp页面上输出九九乘法表--%>
    <h1 align="center">九九乘法口诀表</h1>
    <table align="center">
    <%for (int i = 1; i <= 9; i++) {%>
        <tr>
            <%for (int j = 1; j <= i; j++){%>
            <td>
                <%=j + "X" + i + "=" + i * j%>
            </td>
            <%}%>
            <br/>
        </tr>
    <%}%>
    </table>
</body>
</html>
