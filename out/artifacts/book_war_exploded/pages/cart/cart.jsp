<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	
	<%--静态包含，替换base标签，css样式，jQuery文件--%>
	<%@include file="/pages/comm/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			//给【删除】按钮绑定单击事件
			$("a.deleteItem").click(function(){
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗")
			})
			
			//给清空购物车绑定单击事件
			$("#clearCart").click(function(){
				return confirm("你确定要清空购物车吗?");
			})
			
			//给输入框绑定onchange内容改变事件
			$(".updateCount").change(function(){
				//获取商品名称
				var name = $(this).parent().parent().find("td:first").text();
				//获取商品数量
				var count = this.value;
				//获取商品编号
				var id = $(this).attr("bookId");
				//提示用户是否修改
				if(confirm("你确定要将【" + name + "】商品数量修改为：" + count + "吗")){
					//如果修改，则
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count=" + count + "&id=" + id;
				}else{
					//如果不修改，则将数量改为原数量
					//defaultValue属性是表单项Dom对象的属性，它表示默认的value值
					this.value = this.defaultValue;
				}
			})
		})
	</script>


</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>

		<%--静态包含替换公共的页面，替换了登录成功后的菜单--%>
		<%@ include file="/pages/comm/login_success_menu.jsp"%>

	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<%--如果购物车为空，则显示这些信息--%>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5">
						<a href="index.jsp">亲，当前购物车为空，快跟小伙伴们去浏览商品吧</a> 
					</td>
					
				</tr>
			</c:if>
			<%--如果购物车非空，则显示这些信息--%>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var = "entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input class = "updateCount" 
								   style = "width: 40px" type="text" 
								   value = "${entry.value.count}"
								   bookId = "${entry.value.id}"
							>
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td>
							<a class = "deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			
			
		</table>
		
		<%--如果购物车非空才输出下面的内容--%>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id = "clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	
	</div>


	<%--静态包含，替换页脚--%>
	<%@include file="/pages/comm/foot.jsp"%>

</body>
</html>