<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html lang="zh-CN">
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<title>文件上传</title>
</head>

<body>
	<jsp:include page="../common/title.jsp"></jsp:include>	
<body>
	<form action="${pageContext.request.contextPath}/sjl22/uploadFileAction.action" enctype="multipart/form-data" method="post" class="form-inline">
		<div class="form-group">
			<label>上传文件</label>
			<input type="file" name="file1" id="file1" class="form-control" placeholder="请选择需要上传的文件."><br /> 
		</div>
			<div class="form-group">
			<input type="submit" value="提交" onclick="showdiv('上传中请等待 。。。')" class="form-control">
		</div>
	</form>
</body>

</body>
</html>