<%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    表达式运算 <br/>
    ${12 == 12} 或 ${12 eq 12} <br/>
    ${12 != 12} 或 ${12 ne 12} <br/>
    ${12 < 12} 或 ${12 lt 12} <br/>
    ${12 > 12} 或 ${12 gt 12} <br/>
    ${12 <= 12} 或 ${12 le 12} <br/>
    ${12 >= 12} 或 ${12 ge 12} <br/>
    <hr/>

    逻辑运算 <br/>
    ${12 == 12 && 11 == 11} 或 ${12 == 12 and 11 == 11} <br/>
    ${12 == 12 || 11 == 11} 或 ${12 == 12 or 11 == 11} <br/>
    ${! true} 或 ${not true} <br/>
    <hr/>

    算数运算：<br/>
    ${12 + 12} <br/>
    ${12 - 10} <br/>
    ${12 * 12} <br/>
    <%--注意除法，由于可能有浮点型，所以EL将所有的除法都转成了浮点型，所以即使这里整除，答案也是1.0--%>
    ${12 / 12} 或 ${12 div 12} <br/>
    ${18 % 12} 或 ${18 mod 12} <br/>
</body>
</html>
