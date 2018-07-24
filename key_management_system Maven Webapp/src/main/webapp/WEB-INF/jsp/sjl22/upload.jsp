<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="zh-CN">
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<title>批量添加</title>
</head>

<body>
	<jsp:include page="../common/title.jsp"></jsp:include>	

	<h1>批量写入命令</h1>
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