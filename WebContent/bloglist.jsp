<%@page import="com.sun.media.jfxmedia.track.Track.Encoding"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*, pers.jssd.blog.bean.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//List<Blog> list = (List<Blog>)request.getAttribute("blogList");
	PageBean<Blog> pageBean = (PageBean<Blog>) request.getAttribute("pageBean");
	int currPage = pageBean.getCurrpage();
	List<Blog> list = pageBean.getList();
%>

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
			<a href="/blog/ViewBlogServlet?title=<%=list.get(i).getTitle() %>" class="title"><%=list.get(i).getTitle() %></a>
			<div class="status">发布于<%=list.get(i).getCreateTime().toString() %> |
			<%=list.get(i).getVisitCount() %>阅读人次</div>
			<div class="content"><pre><%=list.get(i).getInfo() %></pre></div>
		</div>
	<%	}
	}%>

</div>
<div style="text-align: center; color: blanchedalmond;">
	<a href="javascript:;" id="pre" onclick="fun_pre();">前一页</a> 
	&nbsp;&nbsp;当前第<%=pageBean.getCurrpage() %>页
	&nbsp;&nbsp;<a href="javascript:;" id="next" onclick="fun_next();">后一页</a>
	&nbsp;&nbsp;跳转到第几页&nbsp;&nbsp;共<%=pageBean.getCount() %>页
</div>

<script type="text/javascript">
	
	function fun_next() {
		var next = document.getElementById("next");
		next.href = "/blog/MainServlet?type=<%=request.getParameter("type") %>&currPage=<%=currPage + 1 %>"; 
	}
	
	function fun_pre() {
		var pre = document.getElementById("pre");
		<% if(currPage > 1) { %>
		<% 
			String str_type = null;
			if(request.getParameter("type").equals("c++")) {
				str_type = "c%2B%2B";
			} else {
				str_type = request.getParameter("type");
			}
			String url = "/blog/MainServlet?type=" + str_type + "&currPage=" + (currPage - 1);
		%>
			pre.href = <%=url %>;
		<% } else {%>
			pre.href = "/blog/MainServlet?type=<%=request.getParameter("type") %>&currPage=<%=currPage %>"
		<% } %>	
	}
	
</script>