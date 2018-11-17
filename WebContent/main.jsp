<%@ page language="java" import="java.util.*, pers.jssd.blog.bean.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>极简博客</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

	<%
		List<Blog> list = (List<Blog>)request.getAttribute("blogList");
		List<Type> typeList = (List<Type>) request.getAttribute("typeList");
	%>

	<div class="side-bar">
		<div class="header">
			<a href="#" class="logo"><%=request.getAttribute("name") %></a>
			<div class="intro"><%=request.getAttribute("introduction") %></div>
		</div>
		<div class="tag-list">
			<p class="item"> 搜索类型 </p>
			<form action="/blog/MainServlet" method="get">
				<input type="text" class="item" name="type"/>
				<input type="submit" class="item" value="搜索"/>
			</form>
			<br />
			<%
			//System.out.println(typeList.size());
			
			//if(num > 10)	num = 10;
			for(int i = 0; i < typeList.size(); i ++) { %>
				<a href="javascript:;" class="item" id="type" name="type" onclick="typeSerch(this)"><%=typeList.get(i).getType() %></a>
			<%} %>
		</div>
	</div>
	<div class="main">
		<div class="edit-list">
		</div>
		<div class="article-list">
			<%
			int blogNum = list.size();
			if(blogNum == 0) {
			%>
				<p>没有文章</p>
			<%
			} else {
				for(int i = 0; i < list.size(); i ++) { %>
				<div class="item">
					<a href="article.html" class="title"><%=list.get(i).getTitle() %></a>
					<div class="status">发布于<%=list.get(i).getCreateTime().toString() %> | 
					<%=list.get(i).getVisitCount() %>阅读人次</div>
					<div class="content"><pre><%=list.get(i).getInfo() %></pre></div>
				</div>
			<%	}
			}%>

		</div>
	</div>

	<script type="text/javascript">
		function typeSerch(t) {
			var type = t.innerHTML;
			t.href = "/blog/MainServlet?type=" + type;
		}
	</script>

</body>
</html>