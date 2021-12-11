<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>


	<%--静态包含，替换base标签，css样式，jQuery文件--%>
	<%@include file="/pages/comm/head.jsp"%>


	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			
			<%--静态包含替换manager模块的菜单--%>
			<%@include file="/pages/comm/manager_menu.jsp"%>
			
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="get">
				<%--由于添加和修改都是同一个页面，所以这里的方法还要判断是添加还是修改
				这里通过request域中是否有图书信息来判断--%>
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="action" value="${empty requestScope.book ? "add" : "update" }"/>
				<input type="hidden" name="id" value="${requestScope.book.id}"/>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>


		<%--静态包含，替换页脚--%>
		<%@include file="/pages/comm/foot.jsp"%>

</body>
</html>