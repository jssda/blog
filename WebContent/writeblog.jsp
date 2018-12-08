<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
			* {
				margin: 0;
			}
			
			.clear-f:after,
			.clear-f:before {
				content: " ";
				display: block;
				clear: both;
			}
			
			.float-left {
				float: left;
			}
			
			.float-right {
				float: right;
			}
			
			body {
				background-color: #454545;
			}
			
			.body {
				/*background-color: #888;*/
				background-color: #A07E5A;
				margin: 30px 150px;
				padding: 50px 100px;
				border: double black 5px;
			}
			
			.body>h2 {
				text-align: center;
				padding-bottom: 30px;
			}
			
			.body>input,
			.body>textarea {
				padding: 10px;
				display: block;
				background-color: #E8EAED;
			}
			
			.body>input {
				margin: 20px 30px;
				height: 30px;
				width: 420px;
			}
			
			.body>textarea {
				font-size: 25px;
			}
			
			.body .textinfo {
				resize: none;
				margin-top: 30px;
				margin-bottom: 20px;
				display: inline-block;
				width: 1030px;
				height: 300px;
			}
			
			.body .textcontent {
				resize: none;
				margin-top: 30px;
				display: inline-block;
				width: 1030px;
				height: 1000px;
			}
		</style>
		<title>写我的博客</title>
	</head>

	<body>

		<form action="WriteBlogServlet" method="post">
			<div class="body clear-f">
				<h2>欢迎发布自己的博客</h2>

				<input type="text" class="texttitle float-left" name="title" placeholder="请输入文章标题" />
				<input type="text" class="texttype float-right" name="type" placeholder="文章类型" />
				<textarea name="textinfo" class="textinfo" onfocus="clearText(this);"  onkeydown="tab(this);">文章简介</textarea>
				<textarea name="textcontent" class="textcontent" onfocus="clearText(this);"  onkeydown="tab(this);">文章内容</textarea>

				<div class="footer">
					<input type="submit" name="save" id="save" value="发布" />
					<button onclick="quit();">退出</button>
				</div>
			</div>
		</form>

		<script type="text/javascript">
			function quit() {
				window.history.back(-1);
			}

			function clearText(focus) {
				focus.innerHTML = "";
				focus.style.fontSize = "20px";
			}

			function putText(element) {
				if(element.name == "textinfo") {
					element.innerHTML = "文章简介";
				} else if(element.name == "textcontent") {
					element.innerHTML = "文章内容";
				}
			}

			function tab(element) {
				if(event.keyCode == 9) {
					element.value = element.value + "	"; // 跳几格由你自已决定
					event.returnValue = false;
				}
			}
		</script>

	</body>

</html>