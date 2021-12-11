<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    获取请求参数username的值：${param.username} <br/>
    获取请求参数password的值：${param.password} <br/>
    <hr/>

    获取请求参数username的第二个值：${paramValues.username[1]} <br/>
    获取请求参数password的第一个值：${paramValues.password[0]} <br/>
    <hr/>

    <%--注意这里要用中括号，因为key值有特殊字符--%>
    获取请求头的User-Agent的值：${header["User-Agent"]} <br/>
    获取请求头的Connection的值：${header.Connection} <br/>
    获取请求头的User-Agent的第一个值：${headerValues["User-Agent"][0]} <br/>
    <hr/>

    获取cookie对象的地址：${cookie} <br/>
    获取cookie对象的JSESSIONID的值：${cookie.JSESSIONID} <br/>
    <%--调用cookie对象的getName()方法--%>
    获取cookie对象的名称：${cookie.JSESSIONID.name} <br/>
    <%--调用cookie对象的getValue()方法--%>
    获取cookie对象的值：${cookie.JSESSIONID.value} <br/>
    <hr/>

    获取&lt;context-param&gt;的值：${initParam} <br/>
    获取&lt;context-param&gt;中的username值：${initParam.username} <br/>
    获取&lt;context-param&gt;中的url值：${initParam.url} <br/>
</body>
</html>
