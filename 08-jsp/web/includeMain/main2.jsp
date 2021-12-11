<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 0:21
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
        <jsp:include page=""></jsp:include>     就是动态包含
        page属性是指定你要包含的jsp页面路径
        动态包含也可以像静态包含一样，把被包含的内容执行输出到包含的位置

        还可以传递参数
     --%>
    <jsp:include page="/includeMain/footer.jsp">
        <jsp:param name="username" value="liubo"/>
    </jsp:include>
</body>
</html>
