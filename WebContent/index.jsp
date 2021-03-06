<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到极简博客</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
</head>
<body class="clear-f">

	<div class="top_nav clear-f">
		<div class="logo">
			<img src="img/logo.png" alt="logo" />
		</div>
		<div class="welcome">欢迎来到极简博客</div>
	</div>
	<div class="main clear-f">
		<div class="col-5 font clear-f">
			<img src="img/font.png" alt="极简博客" />
		</div>
		<div class="clear-f col-5">
			<div id="container" class="container clear-f" style="float: left;">
				<div class="tip clear-f">
					<div class="login_tip center">
						<a href="javascript:;" id="login_tip" onclick="swap_login()">登陆</a>
					</div>
					<div class="register_tip center">
						<a href="javascript:;" id="register_tip" onclick="swap_register()">注册</a>
					</div>
				</div>


				<!-- 登陆div -->
				<div id="login" class="login clear-f">
					<form action="LoginServlet" method="post">
						<div class="item clear-f">
							<input type="text" class="col-8 input_info" placeholder="用户名"
								name="username" />
						</div>
						<div class="item clear-f">
							<input type="password" class="col-8 input_info" placeholder="密码"
								name="password" />
						</div>
						<div class="item clear-f">
							<div class="tip_yan">
								<img id="vCode" onclick="setVCode(this);" alt="验证码">
							</div>
							<input type="text" class="input_yan" name="validate" />
						</div>
						<span id="errorcode"></span>
						<div class="clear-f">
							<input type="submit" value="登陆" class="col-5 submit_buttion" />
							<input type="reset" value="重置" class="col-5 submit_buttion" />
						</div>
					</form>
				</div>

				<!-- 注册div -->
				<div id="register" class="register clear-f">
					<form action="RegisterServlet"  onsubmit="return thissubmit();" method="post">
						<div class="item">
							<input type="text" class="input_info2" placeholder="用户名"
								name="username" id="username" onKeyUp="notnull()"/>
								<span id="spname" class="input_info2 item"></span>
						</div>
						<div class="item">
							<input type="password" class="input_info2" placeholder="密码"
								id="password" name="password"  onKeyUp="notnull()"/>
								<span id="sppwd" class="input_info2 item"></span>
						</div>
						<div class="item">
							<input type="password" class="input_info2" placeholder="验证密码"
								id="password2" onKeyUp="check()"/>
							<span id="sp" class="input_info2 item"></span>
						</div>
						<div class="item">
							<select name="gender" class="select_gender" name="gender">
								<option value="man">男</option>
								<option value="women">女</option>
							</select> <input type="text" placeholder="年龄" />
						</div>
						<div class="item">
							<input type="text" class="input_info2" placeholder="手机号"
								name="telephone" />
						</div>
						<div class="item">
							<input type="text" class="input_info2" placeholder="邮箱"
								name="email" />
						</div>
						<input type="submit" value="注册" class="submit_buttion" /> <input
							type="reset" value="重置" class="submit_buttion" />
					</form>

				</div>

				<div class="register"></div>
			</div>
		</div>
	</div>
	<div class="footer center">
		<a href="#">关于我 </a>&nbsp;|&nbsp; <a href="#">联系我 </a>&nbsp;|&nbsp; <a
			href="#">帮助 </a>&nbsp;|&nbsp; <span style="color: #AAA;">
			@jssd www.lovelybaobao.cn </span>
	</div>

	<script type="text/javascript">
		window.onload = setVCode();
		window.onload = notnull();
		
		function thissubmit() {
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			if (!check() || username == null || password == null || username.replace(/(^\s*)|(\s*$)/g, "").length ==0 || password.replace(/(^\s*)|(\s*$)/g, "").length == 0)
			{
			    alert('不能为空');
			    return false;
			} else {
				return true;
			} 
		};
		
		function check() {
			var pd1 = document.getElementById("password").value;
			var pd2 = document.getElementById("password2").value;
			var sp = document.getElementById("sp");
			if(pd1 != pd2) {
				sp.style.color="#ff0000";
				sp.style.padding="0";
				sp.innerHTML = "错误";
				return false;
			} else {
				sp.innerHTML = "";
				return true;
			}
		};

		function notnull() {
			var name = document.getElementById("username").value;
			var spname = document.getElementById("spname");
			if(name == "") {
				spname.style.color="#ff0000";
				spname.style.padding="0";
				spname.innerHTML = "不可为空";
			} else {
				spname.innerHTML = "";
			}
			
			var password = document.getElementById("password").value;
			var sppwd = document.getElementById("sppwd");
			if(password == "") {
				sppwd.style.color="#ff0000";
				sppwd.style.padding="0";
				sppwd.innerHTML = "不可为空";
			} else {
				sppwd.innerHTML = "";
			}
		}
		
	</script>

</body>
</html>
