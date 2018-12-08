<%@ page language="java" import="java.util.*, pers.jssd.blog.bean.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>极简博客</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<style type="text/css">
	.editblog {
		float: right;
		padding: 200px 30px;
	}
	
	.editblog > a {
		margin: 30px;
	}
</style>

<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

	<%
		//List<Blog> list = (List<Blog>)request.getAttribute("blogList");
		List<Type> typeList = (List<Type>) request.getAttribute("typeList");
	%>

	<div class="side-bar">
		<div class="header">
			<a href="/blog/UserManageServlet" class="logo"><%=request.getAttribute("name")%></a>
			<div class="intro"><%=request.getAttribute("introduction")%></div>
		</div>
		<div class="tag-list">
			<p class="item">搜索类型</p>
			<form action="/blog/MainServlet" method="get">
				<input type="text" class="item" name="type" /> <input type="submit"
					class="item" value="搜索" />
			</form>
			<br /> <a href="/blog/MainServlet#" class="item">所有类型</a>
			<%
				for (int i = 0; i < typeList.size(); i++) {
			%>
			<a href="javascript:;" class="item" id="type" name="type"
				onclick="typeSerch(this)"><%=typeList.get(i).getType()%></a>
			<%
				}
			%>
		</div>
	</div>
	<div class="main" style="float: left;">
		<jsp:include page="/bloglist.jsp"></jsp:include>
		<!--<%@include file="/bloglist.jsp" %>-->
	</div>
	<div class="editblog">
		<a href="writeblog.jsp">写文章</a>
		<a href="MyBlogServlet">我的文章</a>
	</div>

	<script type="text/javascript">
		function typeSerch(t) {
			var type = t.innerHTML;
			t.href = "/blog/MainServlet?type=" + type;
		}
		

	</script>

</body>
</html>