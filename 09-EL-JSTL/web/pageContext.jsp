<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        request.getScheme()获取请求的协议
        request.getServerName()获取请求的服务器ip或域名
        request.getServerPort()获取请求的服务器端口号
        request.getContextPath()获取当前工程路径
        request.getMethod()获取请求的方法
        request.getRemoteHost()获取客户端ip地址
        session.getId()获取会话的ip编号(唯一标识)
    --%>

    <%--为了简化代码，其实可以将resquest放入pageContext域中--%>
    <%
        pageContext.setAttribute("req", request);
    %>

    1.协议：jsp表达式脚本 <%=request.getScheme()%> <br/>
           EL表达式 ${pageContext.request.scheme} <br/>
            EL表达式简化：${req.scheme} <br/>


    2.服务器ip:jsp表达式脚本 <%=request.getServerName()%> <br/>
                EL表达式 ${pageContext.request.serverName} <br/>


    3.服务器端口：jsp表达式脚本 <%=request.getServerPort()%> <br/>
                EL表达式 ${pageContext.request.serverPort} <br/>

    4.获取工程路径：jsp表达式脚本 <%=request.getContextPath()%> <br/>
                EL表达式 ${pageContext.request.contextPath} <br/>

    5.获取请求方法：jsp表达式脚本 <%=request.getMethod()%> <br/>
                EL表达式 ${pageContext.request.method} <br/>

    6.获取客户端ip地址：jsp表达式脚本 <%=request.getRemoteHost()%> <br/>
                EL表达式 ${pageContext.request.remoteHost} <br/>

    7.获取会话的ip编号：jsp表达式脚本 <%=session.getId()%> <br/>
                EL表达式 ${pageContext.session.id} <br/>
</body>
</html>
