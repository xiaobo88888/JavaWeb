<%@ page import="bean.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 15779172334
  Date: 2021/10/21
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setId(666);
        person.setPhones(new String[]{"1111111", "2222222", "3333333"});

        List<String> list = new ArrayList<>();
        list.add("南昌");
        list.add("北京");
        list.add("安福");
        person.setCities(list);

        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        person.setMap(map);

        pageContext.setAttribute("person", person);
    %>

    <%--EL表达式输出值是去找对应的get方法，例如假如要输出age值，只要有getAge()方法即可输出，而不需要age这个属性--%>
    输出整个person对象：${person} <br/>
    输出person对象的id属性：${person.id} <br/>
    输出person对象中的phones：${person.phones} <br/>
    输出person对象中的phones中的元素值：${person.phones[1]} <br/>
    输出person对象中的cities值：${person.cities} <br/>
    输出person对象中的cities中的元素值：${person.cities[0]} <br/>
    输出person对象中的map值：${person.map} <br/>
    输出person对象中的map中的元素值：${person.map.key1} <br/>
</body>
</html>
