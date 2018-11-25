<%@page import="pers.jssd.blog.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		User user = (User) request.getAttribute("user");
	%>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户管理</title>
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<!--<link rel="stylesheet" type="text/css" href="css/userManage.css"/>-->
		<style type="text/css">
			* {
				margin: 0;
			}
			
			.float-left {
				float: left;
			}
			
			.float-right {
				float: right;
			}
			
			.clear-f:after,
			.clear-f:before {
				content: " ";
				display: block;
				clear: both;
			}
			
			.mainbox {
				border: solid black 3px;
				background: antiquewhite;
				margin: 100px 320px;
			}
			
			.mainbox .title {
				font-size: 35px;
				padding: 30px 50px;
			}
			
			.mainbox .body {
				padding: 30px 30px;
				border: groove bisque 4px;
			}
			
			.mainbox .body .value {
				width: 400px;
			}
			
			.mainbox .body .key .item,
			.mainbox .body .signature .item {
				font-size: 25px;
				padding: 10px 0px;
				padding-left: 30px;
				padding-right: 10px;
				width: 120px;
			}
			
			.mainbox .body .value .item {
				height: 28px;
				margin: 10px 30px;
				width: 300px;
			}
			
			.mainbox .body .signature>textarea {
				resize: none;
				width: 13em;
				height: 12em;
			}
			
			.mainbox .body .save {
				padding: 10px 0;
			}
			
			.mainbox .body .save>input {
				margin: 0 10px;
				width: 80px;
				height: 30px;
			}
		</style>
	</head>

	<body style="background-color: #454545;">
		<div class="mainbox clear-f">
			<h2 class="title">个人资料:</h2>
			<hr />
			<div class="body clear-f">
				<div class="key float-left">
					<div class="item">姓名:</div>
					<div class="item">密码:</div>
					<div class="item">性别:</div>
					<div class="item">年龄:</div>
					<div class="item">手机号:</div>
					<div class="item">邮箱:</div>
				</div>
				<form action="/blog/UserServlet" method="post">
					<div class="value float-left">
						<input type="text" class="item" name="name" value=<%=user.getName() %> />
						<input type="text" class="item" name="password" value=<%=user.getPassword() %> />
						<input type="text" class="item" name="gender" value=<%=user.getGender() %> />
						<input type="text" class="item" name="age" value=<%=user.getAge() %> />
						<input type="text" class="item" name="telephone" value=<%=user.getTelephone() %> />
						<input type="text" class="item" name="email" value=<%=user.getEmail() %> />
					</div>

					<div class="signature float-left">
						<div class="item">自我介绍:</div>
						<textarea name="introduction" rows="10" cols="23">
							<%=user.getIntroduction() %>
						</textarea>
					</div>

					<div class="save float-left">
						<input type="reset" value="重置"/>
						<input type="submit" value="保存"/>
					</div>
				</form>
			</div>
		</div>
	</body>

</html>