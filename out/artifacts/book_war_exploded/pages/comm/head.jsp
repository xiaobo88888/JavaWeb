<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/11/3
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--动态设置base标签的地址--%>
<%
    String basePath = request.getScheme()//获取协议
            + "://"
            + request.getServerName()//获取ip地址
            + ":"
            + request.getServerPort()//获取端口号
            + request.getContextPath()//获取工程路径
            + "/";
    
    
    pageContext.setAttribute("basePath", basePath);
%>
<!-- base标签路径默认写到工程名 -->
<base href="<%=basePath%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>