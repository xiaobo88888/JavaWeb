<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String, Object> map = new HashMap<>();
        map.put("a.a.a", "aaavalue");
        map.put("b+b+b", "bbbvalue");
        map.put("c==c!=c", "cccvalue");

        pageContext.setAttribute("map", map);
    %>

    ${map} <br/>

    <%--使用中括号可以输出map集合中key含有特殊字符的值--%>
    <%--${map.a.a.a} <br/>--%>
    ${map["a.a.a"]} <br/>

    <%--${map.b+b+b} <br/>--%>
    ${map["b+b+b"]} <br/>

    <%--${map.c==c!=c} <br/>--%>
    ${map["c==c!=c"]} <br/>
</body>
</html>
