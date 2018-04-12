<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<li role="presentation" class="active"><a href="#">查询</a></li>
	</ul>

	<nav aria-label="Page navigation">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>

	<table
		class="table table-striped table-bordered table-hover table-condensed"
		style="TABLE-LAYOUT:fixed">
		<thead>
			<tr align="center">
				<td
					style="width:5%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>序号</strong></em>
						</h1></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>命令</strong></em>
						</h1></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>请求</strong></em>
						</h1></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>响应</strong></em>
						</h1></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>描述</strong></em>
						</h1></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>修改时间</strong></em>
						</h1></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>修改用户</strong></em>
						</h1></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${objs}" var="obj">
				<tr align="center">
					<td
						style="width:5%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"
						title="${obj.sId}"><small><small><em>${obj.sId}</em></small></small></td>
					<td
						style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"
						title="${obj.sCommand}"><small><em>${obj.sCommand}</em></small></td>
					<td
						style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"
						title="${obj.sRequest}"><small><em>${obj.sRequest}</em></small></td>
					<td
						style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"
						title="${obj.sResponse}"><small><em>${obj.sResponse}</em></small></td>
					<td
						style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"
						title="${obj.sDescribe}"><small><em>${obj.sDescribe}</em></small></td>
					<td
						style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"
						title="<fmt:formatDate value='${obj.sUpdateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"><small><em><fmt:formatDate
									value='${obj.sUpdateTime}' pattern='yyyy-MM-dd HH:mm:ss' /></em></small></td>
					<td
						style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"
						title="${obj.sUpdateUser}"><small><em>${obj.sUpdateUser}</em></small></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>