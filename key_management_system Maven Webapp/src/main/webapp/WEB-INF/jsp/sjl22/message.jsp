<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- <title>Key Management Syste 1.0</title> -->
<title>KMS1.0</title>
<!-- Bootstrap -->
<link href="<%=basePath%>bootstrap-3.3.7/css/bootstrap.css"
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="<%=basePath%>bootstrap-3.3.7/js/bootstrap.js"></script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="<%=basePath%>">添加</a></li>
		<li role="presentation"><a href="<%=basePath%>sjl22/show.action">查询</a></li>
		<li role="presentation"><a href="<%=basePath%>sjl22/file.action">读取文件</a></li>
	</ul>
<body>
	<h1>${message }</h1>
</body>

</body>
</html>