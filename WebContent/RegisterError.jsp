<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3;url=index.jsp">
<title>注册出错</title>
</head>
<body>
	<%
		int count = (int) request.getAttribute("errorCode");
		if(count == 1) {
	%>
		<p>用户名已存在</p>
	<%
		} else {
	%>
		<p>注册失败, 请检查输入</p>
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