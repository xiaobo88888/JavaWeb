<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/20
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         errorPage="/errror500.jsp"
         language="java" %>
<!--
    errorPage表示错误后自动跳转去的路径
    这个路径一般都是已斜杠打头，表示请求的地址为：http://localhost:8080/工程路径/
    映射到代码的Web目录
-->
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是b.jsp页面内容
    <%
        int i = 12 / 0;
    %>
</body>
</html>
