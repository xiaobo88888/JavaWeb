<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key", "value");
    %>
    表达式脚本输出key值：<%=request.getAttribute("key")%> <br/>
    EL表达式输出key值：${key}  <br/>

    <%--如果为null则输出空串--%>
    表达式脚本输出key值：<%=request.getAttribute("key1")==null?"":request.getAttribute("key1")%> <br/>
    EL表达式输出key值：${key1}  <br/>
</body>
</html>
