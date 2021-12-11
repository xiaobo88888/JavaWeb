<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //1.值为null的时候为空
        request.setAttribute("emptyNull", null);
        //2.值为空串的时候
        request.setAttribute("emptyStr", "");
        //3.值是Object类型数组，长度为0时
        request.setAttribute("emptyObject", new Object[]{});
        //4.List集合，元素个数为0
        request.setAttribute("emptyList", new ArrayList<String>());
        //5.Map集合，元素个数为0
        request.setAttribute("emptyMap", new HashMap<String, Object>());
    %>
    ${empty emptyNull} <br/>
    ${empty emptyStr} <br/>
    ${empty emptyObject} <br/>
    ${empty emptyList} <br/>
    ${empty emptyMap} <br/>
    <hr/>

    三元运算 <br/>
    ${12 == 2 ? "刘博好帅" : "刘博确实帅"}
</body>
</html>
