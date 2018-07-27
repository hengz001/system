<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="zh-CN">
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<title>批量添加</title>
</head>

<body>
	<jsp:include page="../common/title.jsp"></jsp:include>	
<body>
	<form action="${pageContext.request.contextPath}/sjl22/upload.action" enctype="multipart/form-data" method="post" class="form-inline">
		<div class="form-group">
		<label>上传用户</label>：
		<input type="text" name="username" class="form-control" placeholder="批量写入命令"><br /> 
		</div>
		<div class="form-group">
		<label>上传文件</label>
		<input type="file" name="file1" id="file1"><br /> 
		</div>
		<div class="form-group">
		<input type="submit" value="提交" class="form-control">
		</div>
	</form>
</body>

</body>
</html>