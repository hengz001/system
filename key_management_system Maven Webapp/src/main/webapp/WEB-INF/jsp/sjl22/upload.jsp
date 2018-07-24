<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="zh-CN">
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<title>KMS1.0</title>
</head>

<body>
	<jsp:include page="../common/title.jsp"></jsp:include>	

	<h1>Hello GMN.</h1>
<body>
	<form
		action="${pageContext.request.contextPath}/sjl22/upload.action" enctype="multipart/form-data" method="post">
		上传用户：<input type="text" name="username"><br /> 
		上传文件：<input type="file" name="file1" id="file1"><br /> 
		<input type="submit" value="提交">
	</form>
</body>

</body>
</html>