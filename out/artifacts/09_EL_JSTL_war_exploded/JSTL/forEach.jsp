<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="sun.swing.BakedArrayList" %>
<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/23
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 1px red solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px red solid;
        }
    </style>
</head>
<body>
    <%--遍历1-10，并输出--%>
    <table border="1">
        <c:forEach begin="1" end="10" var="i">
            <tr>
                <td><h3/>第${i}行</td>
            </tr>
        </c:forEach>
    </table>
    <hr/>

    <%--
        遍历Object数组
            items表示遍历的数据源（遍历的集合）
            var 表示当前遍历到的数组
    --%>
    <%
        request.setAttribute("arr", new String[]{"11111", "22222", "33333"});
    %>
    <c:forEach items="${requestScope.arr}" var = "item">
        ${item}<br/>
    </c:forEach>
    <hr/>

    <%--
        遍历Map集合
    --%>
    <%
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        /*map集合的一种遍历方法是为
        * for(Map.Entry<String, Object> entry : map.entrySet()){

        }
        * */

        request.setAttribute("map", map);
    %>
    <c:forEach items="${requestScope.map}" var = "entry">
        <h1/>${entry.key} = ${entry.value} <br/>
    </c:forEach>
    <hr/>

    <%--
        遍历List集合，集合中存放Student类
    --%>
    <%
        List<Student> list = new ArrayList<>();
        
        for(int i = 1; i <= 10; i++){
            list.add(new Student(i, "username" + i, "password" + i, 18 + i, "phone" + i));
        }
        
        request.setAttribute("list", list);
    %>
    <table>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
        </tr>
        <%--
            begin表示遍历的开始索引
            end表示遍历的结束索引
            step属性表示每次遍历的步长值，意为for循环中每次增加多少（默认为1）
                例：for(int i = 0; i < 10; i++)这里步长为1
            varStatus 属性表示当前遍历到的数据的状态
        --%>
        <c:forEach begin="1" end="7" step="2" varStatus="status" items="${requestScope.list}" var = "stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${status.current}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
