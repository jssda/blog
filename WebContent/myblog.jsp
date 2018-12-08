<%@ page import="java.util.*, pers.jssd.blog.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>Insert title here</title>

<style type="text/css">
	.editblog {
		float: left;
		padding: 200px 30px;
	}
	
	.editblog > a {
		margin: 30px;
	}
</style>

</head>
<body>
	<%
		List<Type> typeList = (List<Type>) request.getAttribute("typeList");
	%>
	<div class="side-bar">
		<div class="tag-list">
			<p class="item">搜索类型</p>
			<form action="/blog/MainServlet" method="get">
				<input type="text" class="item" name="type" /> <input type="submit"
					class="item" value="搜索" />
			</form>
			<br /> <a href="/blog/MyBlogServlet#" class="item">所有类型</a>
			<%
				for (int i = 0; i < typeList.size(); i++) {
			%>
			<a href="javascript:;" class="item" id="type" name="type"
				onclick="typeSerch(this)"><%=typeList.get(i).getType()%>
			</a>
			<%
				}
			%>
		</div>
	</div>
	<div class="main" style="float: left;">
		<%
			//List<Blog> list = (List<Blog>)request.getAttribute("blogList");
			PageBean<Blog> pageBean = (PageBean<Blog>) request.getAttribute("pageBean");
			int currPage = pageBean.getCurrpage();
			List<Blog> list = pageBean.getList();
		%>

		<div class="article-list">
			<%
				int blogNum = list.size();
				if (blogNum == 0) {
			%>
			<p>没有文章</p>
			<%
				} else {
					for (int i = 0; i < list.size(); i++) {
			%>
			<div class="item">
				<a href="/blog/ViewBlogServlet?title=<%=list.get(i).getTitle()%>"
					class="title"><%=list.get(i).getTitle()%></a>
				<div class="status">
					发布于<%=list.get(i).getCreateTime().toString()%>
					|
					<%=list.get(i).getVisitCount()%>阅读人次 | 类别<%=list.get(i).getType() %>
				</div>
				<div class="content">
					<pre><%=list.get(i).getInfo()%></pre>
				</div>
			</div>
			<%
				}
					}
			%>

		</div>
		<div style="text-align: center; color: blanchedalmond;">
			<a href="javascript:;" id="pre" onclick="fun_pre();">前一页</a>
			&nbsp;&nbsp;当前第<%=pageBean.getCurrpage()%>页 &nbsp;&nbsp;<a
				href="javascript:;" id="next" onclick="fun_next();">后一页</a>
			&nbsp;&nbsp;跳转到第几页&nbsp;&nbsp;共<%=pageBean.getCount()%>页
		</div>
	</div>
	<div class="editblog">
		<a href="/blog/MainServlet">返回</a>
	</div>
	<script type="text/javascript">
		function typeSerch(t) {
			var type = t.innerHTML;
			t.href = "/blog/MyBlogServlet?type=" + type;
		};
		
		function fun_next() {
			var next = document.getElementById("next");
			next.href = "/blog/MyBlogServlet?type=<%=request.getParameter("type")%>&currPage=<%=currPage + 1%>"; 
		};
		
		function fun_pre() {
			var pre = document.getElementById("pre");
			<%if (currPage > 1) {%>
			<%String str_type = null;
				if (request.getParameter("type").equals("c++")) {
					str_type = "c%2B%2B";
				} else {
					str_type = request.getParameter("type");
				}
				String url = "/blog/MyBlogServlet?type=" + str_type + "&currPage=" + (currPage - 1);%>
			pre.href = "<%=url%>";
			<%} else {%>
			pre.href = "/blog/MyBlogServlet?type=<%=request.getParameter("type")%>&currPage=<%=currPage%>";
			<%}%>
		}
	</script>
</body>

</html>