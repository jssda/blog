<%@page import="pers.jssd.blog.bean.Blog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%
	Blog blog = (Blog)request.getAttribute("blog");
%>
		<title>
			<%=blog.getTitle() %>
		</title>
	</head>

	<body style="background-color: #454545; padding: 25px 80px;">
		<div style="color: #000000; background-color: #F5F5DC; padding: 0 50px;">
			<br />
			<br />
			<h1 style="text-align: center;"><%=blog.getTitle() %></h1>
			<div style="font-size: 13px; color: #aaa; text-align: right;">发布于
				<%=blog.getCreateTime().toString() %> |
				<%=blog.getVisitCount() %>阅读人次</div>
			<br /><br />
			<hr />
			<div>
				<pre style="font-size: 20px;">
				<%=blog.getContent() %>
				</pre>
			</div>
		</div>

	</body>

</html>