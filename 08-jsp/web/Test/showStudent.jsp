<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 1px red solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px red solid;
        }
    </style>
</head>
<body>
    <%
        List<User> userList =(List<User>)request.getAttribute("studentList");
    %>

    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
    <%for (User user : userList) {%>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getAge()%></td>
            <td><%=user.getPhone()%></td>
            <td><%="删除 修改"%></td>
        </tr>
    <%}%>
    </table>
</body>
</html>
