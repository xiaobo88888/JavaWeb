<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息 <br/>
    主体信息 <br/>

    <%--
        <%@include file=""%> 就是静态包含
            file属性指定你要包含的页面路径

            地址中第一个斜杠 /  表示为：http://ip:port/工程路径/    映射到代码的Web目录
     --%>
    <%@include file="/includeMain/footer.jsp"%>
</body>
</html>
