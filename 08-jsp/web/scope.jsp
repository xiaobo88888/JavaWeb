<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/20
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope.jsp页面</h1>

    <%
        //往四个域对象中存入数据
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
    pageContext 域是否有值：<%=pageContext.getAttribute("key")%> <br/>
    request 域是否有值：<%=request.getAttribute("key")%> <br/>
    session 域是否有值：<%=session.getAttribute("key")%> <br/>
    application 域是否有值：<%=application.getAttribute("key")%> <br/>

    <%--<%
        //现在跳转到另一个页面中
        request.getRequestDispatcher("/scope2.jsp").forward(request, response);
    %>--%>

    <%--
        <jsp:forward page=""></jsp:forward>是请求转发标签
            page属性设置请求转发的路径，地址中第一个斜杠 /  表示为：http://ip:port/工程路径/    映射到代码的Web目录
    --%>
    <jsp:forward page="/scope2.jsp"></jsp:forward>
</body>
</html>
