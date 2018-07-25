<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
</head>

	<ul class="nav nav-tabs">
		<li role="presentation"><a href="${pageContext.request.contextPath}">添加</a></li>
		<li role="presentation"><a href="${pageContext.request.contextPath}/sjl22/show.action">查询</a></li>
		<li role="presentation"><a href="${pageContext.request.contextPath}/sjl22/file.action">读取</a></li>
		<li role="presentation"><a href="${pageContext.request.contextPath}/sjl22/uploadFile.action">上传</a></li>
		<li role="presentation"><a href="${pageContext.request.contextPath}/sjl22/downloadFile.action">下载</a></li>
	</ul>
</html>
