<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>


	<%--静态包含，替换base标签，css样式，jQuery文件--%>
	<%@include file="/pages/comm/head.jsp"%>


	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">结算</span>

		<%--静态包含替换公共的页面，替换了登录成功后的菜单--%>
		<%@ include file="/pages/comm/login_success_menu.jsp"%>
		
	</div>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为${sessionScope.orderId}</h1>
		
	
	</div>


	<%--静态包含，替换页脚--%>
	<%@include file="/pages/comm/foot.jsp"%>

</body>
</html>