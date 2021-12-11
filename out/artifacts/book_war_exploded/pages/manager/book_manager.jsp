<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>


	<%--静态包含，替换base标签，css样式，jQuery文件--%>
	<%@include file="/pages/comm/head.jsp"%>
	<script type="text/javascript">
		$(function(){
			//给删除的a变迁绑定单击事件
			$("a.deleteClass").click(function(){
				/**
				 * confirm是提示框函数
				 * 参数是提示的内容
				 * 它有两个按钮，一个是确定，一个是取消
				 * 返回true表示点击确定，返回false表示点击取消
				 */
				//这里直接return就好了，因为return false会阻止元素默认行为==>不提交请求
				
				//在事件的function函数中有一个this对象，这个对象反映当前正在响应事件的dom对象
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗");
			})
		})
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

		<%--静态包含替换manager模块的菜单--%>
		<%@include file="/pages/comm/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>	
			<c:forEach items="${requestScope.page.items}" var = "book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<%--这里的修改也是如此，传递当前页数，如果最后一页的所有数据全部被删除，总页数会减少，而传递的页数比总页数大，则会置为总页数--%>
					<td><a class = "deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>

		<%--分页条使用静态包含--%>
		<%@include file="/pages/comm/page_nav.jsp"%>
		
	</div>


	<%--静态包含，替换页脚--%>
	<%@include file="/pages/comm/foot.jsp"%>

</body>
</html>