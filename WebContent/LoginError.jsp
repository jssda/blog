<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3;url=index.jsp">
<title>出错啦</title>
</head>
<body>
	<%
		int count = (int) request.getAttribute("errorCode");
		if(count == 0) {
	%>
		<p>验证码输入错误</p>
	<%
		} else if(count == 1){
	%>
		<p>用户密码错误</p>
	<%
		}
	%>
	<p id="clock" name="clock">3秒后返回主页面</p>
	<a id="link" name="link" href="${pageContext.request.contextPath}/index.jsp">立即返回</a>
	<script type="text/javascript">
		window.onload = (function() {
			var time = 3;
			var p = document.getElementById("clock");
			var set = setInterval(function() {
				time--;
				p.innerHTML = time + "秒后返回主页面";
				if (time === 0) {
					p.innerHTML = "";
					clearInterval(set);
				}
			}, 1000);
		})()
	</script>
</body>
</html>