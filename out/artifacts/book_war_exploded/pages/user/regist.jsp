<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>
		
		<%--静态包含，替换base标签，css样式，jQuery文件--%>
		<%@include file="/pages/comm/head.jsp"%>
		
		<script type="text/javascript">

			//页面加载完成之后
			$(function(){
				//用户名失去焦点后就验证用户名是否可用
				$("#username").blur(function () {
					//获取输入框的内容
					var username = this.value;
					
					//
					$.getJSON("http://localhost:8080/book/userServlet", "action=ajaxExitsUsername&username=" + username, function(data){
						if(data.exitsUsername){
							$("span.errorMsg").text("用户名已存在");
						}else{
							$("span.errorMsg").text("用户名可用！");
						}
					})
				})
				
				
				//给验证码绑定单机事件，点击就刷新验证码
				$("#code_img").click(function(){
					//这个this指代验证码的dom对象，它的src路径可读可写
					//所以这里是给src重新赋值，让其重新去请求一次验证码，就达到了刷新的要求
					//因为某些浏览器是有缓存的，所以如果请求的路径一致的话，得到的结果一致，所以就会导致刷新不了
					//这里在请求路径后面添加参数，让参数永远不相同即可
					this.src = "${basePath}kaptcha.jpg?=" + new Date();
				});
				
				
				//给注册绑定点击事件
				$("#sub_btn").click(function(){
					//验证用户名，必须由字母，数字，下划线组成，并且长度为5-12位
					//1.先得到输入框中的内容
					var usernameText = $("#username").val();
					//2.创建正则表达式
					var usernamePatt = /^\w{5,12}$/;
					//3.使用test方法验证
					if(!usernamePatt.test(usernameText)){
						//4.提示用户错误
						$("span.errorMsg").text("用户名不合法");

						return false;
					}

					//验证密码：必须由字母，数字，下划线组成，并且长度为5-12位
					//1.先得到输入框中的内容
					var passwordText = $("#password").val();
					//2.创建正则表达式
					var passwordPatt = /^\w{5,12}$/;
					//3.使用test方法验证
					if(!passwordPatt.test(passwordText)){
						//4.提示用户错误
						$("span.errorMsg").text("密码不合法");

						return false;
					}

					//验证确认密码：和密码相同
					//1.获取确认密码
					var repwdText = $("#repwd").val();
					//2.和密码相比较
					if(repwdText != passwordText){
						//3.提示用户
						$("span.errorMsg").text("确认密码和密码不一致");

						return false;
					}
					//邮箱验证：xxxxx@xxx.com
					//1.获取邮箱输入框内容
					var emailText = $("#email").val();
					//2.创建正则表达式
					var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
					//3.用test方和和输入框内容作比较
					if(!emailPatt.test(emailText)){
						//4.提示用户
						$("span.errorMsg").text("邮箱不合法");

						return false;
					}

					//验证码验证：由于当前未学服务器，所以只需要验证不为空即可
					//1.获取验证码的内容
					var codeText = $("#code").val();
					//2.去除验证码内容的前后空格
					var codeText = $.trim(codeText);
					//3.验证不是为空
					if(codeText == null || codeText == ""){
						//4.提示用户
						$("span.errorMsg").text("验证码不能为空");

						return false;
					}
					//如果合法了，就去掉提示信息
					$("span.errorMsg").text("");
				});
			});


		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif"/>
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%--<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">

									<%--添加隐藏域信息，用于Servlet程序接收判断是登录还是注册页面--%>
									<input type="hidden" name = "action" value = "regist"/>
										
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username" 
										   <%--输入错误后，将用户名回显--%>
										   <%--value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
											value = ${requestScope.username}
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email" 
										   <%--输入错误后，将邮箱回显--%>
										   <%--value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
											value = ${requestScope.email}
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name = "code" style="width: 100px;" id="code"/>
									<img id = "code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 100px; height: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
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