<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key", "pageContext");
        pageContext.setAttribute("a.a.a", "pageContext2");

        request.setAttribute("key", "request");

        session.setAttribute("key", "session");

        application.setAttribute("key", "application");
    %>

    ${pageScope.key} <br/>
    ${pageScope["a.a.a"]} <br/>

    ${requestScope.key} <br/>

    ${sessionScope.key} <br/>

    ${applicationScope.key} <br/>
</body>
</html>
