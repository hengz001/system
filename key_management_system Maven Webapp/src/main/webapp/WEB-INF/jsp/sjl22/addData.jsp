<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="zh-CN">
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<title>添加命令</title>
</head>
<body>

	<jsp:include page="../common/title.jsp"></jsp:include>	

	<form action="${pageContext.request.contextPath}/sjl22/add.action" method="post" class="">
		
		<div class="input-group">
			<span class="input-group-addon">命令</span>
			<input type="text" class="form-control" id="sRequest" name="sRequest" placeholder="NC">
		</div>
		<br>
		
		<div class="input-group">
			<span class="input-group-addon">返回</span> 
			<input type="text" class="form-control" id="sResponse" name="sResponse" placeholder="ND...">
		</div>
		<br>
				
		<div class="input-group">
			<span class="input-group-addon">描述</span>
			<input type="text" class="form-control" id="sDescribe" name="sDescribe" placeholder="描述">
		</div>
		<br>
				
		<div class="input-group">
			<span class="input-group-addon">用户</span>
			<input type="text" class="form-control" id="sUpdateUser" name="sUpdateUser" placeholder="hengz">
		</div>
		<br>
				
		<p align="center">
			<button type="submit" class="btn btn-primary">提交</button>
		</p>
	</form>
</body>
</html>