<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    脚页信息 <br/>
    <%--动态包含可以在被包含的jsp文件中接收参数--%>
    <%= request.getParameter("username")%>
</body>
</html>
