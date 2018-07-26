<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<script type="text/javascript">
		$(function(){
			switch('${flag}'){
				case "主页":
					$("#li0").addClass("active");
					break;
				case "添加":
					$("#li1").addClass("active");
					break;
				case "查询":
					$("#li2").addClass("active");
					break;
				case "读取":
					$("#li3").addClass("active");
					break;
				case "上传":
					$("#li4").addClass("active");
					break;
				case "下载":
					$("#li5").addClass("active");
					break;
				default:
					$("#li0").addClass("active");
					break;
			}
		});
	</script>

</head>

<nav class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> KMS </a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li id="li0">
					<a href="${pageContext.request.contextPath}/sjl22/home.action">主页</a></li>
				<li id="li1">
					<a href="${pageContext.request.contextPath}/sjl22/addData.action">添加</a></li>
				<li id="li2">
					<a href="${pageContext.request.contextPath}/sjl22/show.action">查询</a></li>
				<li id="li3">
					<a href="${pageContext.request.contextPath}/sjl22/file.action">读取</a></li>
				<li id="li4">
					<a href="${pageContext.request.contextPath}/sjl22/uploadFile.action">上传</a></li>
				<li id="li5">
					<a href="${pageContext.request.contextPath}/sjl22/downloadFile.action">下载</a></li>
			</ul>
		</div>
	</div>
</nav>
</html>
