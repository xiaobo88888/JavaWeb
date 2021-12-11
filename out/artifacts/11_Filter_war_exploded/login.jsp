<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/11/21
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是登录页面 login.jsp页面<br/>
    <form action="http://localhost:8080/11_Filter/loginServlet" method="get">
        <input type="text" name = "username"/>  <br/>
        <input type="text" name = "password"/>  <br/>
        <input type="submit"/>  <br/>
    </form>
</body>
</html>
