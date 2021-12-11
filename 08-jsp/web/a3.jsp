<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/20
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--  <% 代码脚本 %>  --%>

    <%--代码脚本：if语句--%>
    <%
        int a = 11;
        if(a == 12){
            System.out.println("刘博贼jb帅");
        }else{
            System.out.println("刘博更加帅了");
        }
    %>

    <%--代码脚本，for循环语句--%>
   <%--
   <%
        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }
    %>
    --%>
    <%--代码脚本可以由多个代码脚本块组合成一个完整的java语句--%>
    <%
        for(int i = 0; i < 5; i++){
    %>
    <%
            System.out.println(i);
        }
    %>

   <%--由于代码脚本被翻译为java文件中是在_jspService()方法中的，所以_jspService()方法内的代码都可以写在代码脚本中--%>
    <%
        String username = request.getParameter("username");
        System.out.println("用户名为：" + username);
    %> <br/>


    <%--代码脚本还可以和表达式脚本连用--%>
    <%
        for(int j = 0; j < 3; j++){

    %>
            <%=j%> <br/>
    <%
        }
    %>

    <table>
        <%
            for(int c = 0; c < 5; c++){
        %>
        <tr>
            <td>第<%=c%>行</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
