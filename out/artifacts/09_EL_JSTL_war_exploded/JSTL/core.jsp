<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/23
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        <c:set />
            作用：set标签可以往域中保存数据

            域对象.setAttribute(key, value)

            scope 属性设置保存到哪个域
                page 表示PageContext域 （默认值）
                request 表示Request域
                session 表示Session域
                application 表示ServletContext域
            var 属性设置key是多少
            value 属性设置value是多少
    --%>
    保存之前：${requestScope.abc} <br/>
    <c:set scope="request" var = "abc" value = "abcValue"/>
    保存之后：${requestScope.abc} <br/>

    <hr/>

    <%--
        <c:if></c:if>
        if标签用来做if判断
        test属性表示判断的条件（使用EL表达式输出）

        但是该标签没有if-else的写法，要么就只能写两个if标签
    --%>
    <c:if test="${12 == 12}">
        <h1/>刘博帅比
    </c:if>

    <hr/>

    <%--
        <c:choose><c:when><c:otherwise>标签
        作用：多路判断，和switch..case...default很像
            但是这个只要符合了某个条件就不会判断其他条件了

        choose标签表示开始选择判断
        when标签表示每一种判断情况
            test属性表示当前这种判断情况的值
        otherwise标签表示剩下的情况


        该标签使用时需要注意的点：
            1.不要使用HTML注释，要使用jsp注释
            2.when标签的父标签一定要是choose标签
    --%>
    <%
        request.setAttribute("height", "173");
    %>
    <c:choose>
        <c:when test="${requestScope.height > 190}">
            <h2/>小巨人<br/>
        </c:when>
        <c:when test="${requestScope.height > 180}">
            <h2/>很高<br/>
        </c:when>
        <c:when test="${requestScope.height > 170}">
            <h2/>不错，是帅哥<br/>
        </c:when>
        <c:otherwise>
            <h2/>也还行吧<br/>
        </c:otherwise>
    </c:choose>
</body>
</html>
