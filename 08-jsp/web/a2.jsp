<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/20
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        private static Map<String, Object> map = new HashMap<String, Object>();

        static {
            map.put("aaa", "bbb");
            map.put("ddd", "ccc");
        }
    %>
    <%--  <%=表达式脚本%>  --%>

    <%--输出整形--%>
    <%=
        12
    %> <br/>

    <%--输出浮点型--%>
    <%=
        12.12
    %> <br/>

    <%--输出字符串--%>
    <%=
        "我是字符串"
    %> <br/>

    <%--输出对象--%>
    <%=
        map
    %> <br/>


    <%--_jspService() 方法中的对象都可以使用--%>
    <%=
        request.getParameter("username")
    %>
</body>
</html>
