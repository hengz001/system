<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="zh-CN">
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<title>文件上传</title>
</head>

<body>
	<jsp:include page="../common/title.jsp"></jsp:include>	

	<h1>请选择需要上传的文件.</h1>
<body>
	<form
		action="${pageContext.request.contextPath}/sjl22/uploadFileAction.action" enctype="multipart/form-data" method="post">
		上传文件：<input type="file" name="file1" id="file1"><br /> 
		<input type="submit" value="提交" onclick="showdiv('上传中请等待 。。。')">
	</form>
</body>

</body>
</html>