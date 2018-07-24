<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="zh-CN">
<head>
	<jsp:include page="WEB-INF/jsp/common/common.jsp"></jsp:include>
	<title>添加命令</title>
</head>
<body>

	<jsp:include page="WEB-INF/jsp/common/title.jsp"></jsp:include>	

	<form action="sjl22/add.action" method="post">
		<div class="form-group">
			<label for="sRequest">命令</label> <input type="text"
				class="form-control" id="sRequest" name="sRequest" placeholder="NC">
		</div>
		<div class="form-group">
			<label for="sResponse">返回</label> <input type="text"
				class="form-control" id="sResponse" name="sResponse" placeholder="ND...">
		</div>
		<div class="form-group">
			<label for="sDescribe">描述</label> <input type="text"
				class="form-control" id="sDescribe" name="sDescribe" placeholder="描述">
		</div>
		<div class="form-group">
			<label for="api_update_user">操作用户</label> <input type="text"
				class="form-control" id="sUpdateUser" name="sUpdateUser" placeholder="hengz">
		</div>
		<p class="text-right">
			<button type="submit" class="btn btn-default">提交</button>
		</p>
	</form>
</body>
</html>