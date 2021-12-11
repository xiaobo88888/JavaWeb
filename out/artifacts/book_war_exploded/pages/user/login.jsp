<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>

<title>尚硅谷会员登录页面</title>

	<%--静态包含，替换base标签，css样式，jQuery文件--%>
	<%@include file="/pages/comm/head.jsp"%>

	<script type="text/javascript">

		$(function(){

		})

	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
									<%--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
									${ empty requestScope.msg ? "请输入用户名和密码" : requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method = "post">
									
									<%--添加隐藏域信息，用于Servlet程序接收判断是登录还是注册页面--%>
									<input type="hidden" name = "action" value = "login">
									
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" 
										   <%--回显用户名信息--%>
											<%--value = "<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
											value = "${requestScope.username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		<%--静态包含，替换页脚--%>
		<%@include file="/pages/comm/foot.jsp"%>

</body>
</html>