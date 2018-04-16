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

<script type="text/javascript">
	<!-- 
	/*
	private int totalCount;//总数
    private int pageSize=10;//每页显示数量
    private int currpageNum;//当前页
    private int pageCount;//总页数
    private int prePage;//上一页
    private int nextPage;//下一页
    private boolean hasPrePage;//是否有上一页
    private boolean hasNextPage;//是否有下一页
    private int firstPage;//第一页
    private int lastPage;//最后一页
    private int currentcount;//当前从第多少条数据开始显示
	*/
 -->
	function page(i) {
			var pageSize = $("#select1").val();
			undefined == pageSize?pageSize=10:pageSize;
	 		
	 		var paramType = $("#selectType").val();
	 		var parameter = $("#parameter").val();
	 			
	 		var url = "<%=basePath%>sjl22/findPage.action?"
				+"currpageNum="+i+
				"&pageSize="+pageSize;	
				
			if("请选择"!=paramType && ""!=parameter){
		 		url = url+"&paramType="+paramType+
		 		"&parameter="+parameter;
			}
			window.location.href=url;
	}
	
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="<%=basePath%>">添加</a></li>
		<li role="presentation" class="active"><a href="#">查询</a></li>
	</ul>

	<nav aria-label="Page navigation">
		<ul class="pagination">
			<li><a aria-label="Previous" <c:if test="${page.hasPrePage}"> onclick="page(${page.prePage});"</c:if> >
					<span aria-hidden="true">&laquo;</span>
			</a></li>

			<c:forEach var="i" begin="1" end="${page.pageCount}">
				<li
					<c:if test="${i == page.currpageNum}">
						class="active"
					</c:if>><a
					onclick="page(${i});">${i}</a></li>
			</c:forEach>

			<li><a aria-label="Next" <c:if test="${page.hasNextPage}"> onclick="page(${page.nextPage});"</c:if> >
					<span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>

	总计${page.totalCount!=null?page.totalCount:0}行 &nbsp;&nbsp;
	
	<select id="select1" name="select1" onchange="page(1);"> 
		<option value="1" <c:if test="${page.pageSize==1}"> selected</c:if> />1行
		<option value="3" <c:if test="${page.pageSize==3}"> selected</c:if> />3行
		<option value="10" <c:if test="${page.pageSize==10}"> selected</c:if> />10行
		<option value="100" <c:if test="${page.pageSize==100}"> selected</c:if> />100行
	</select>

	 <select id="selectType" name="selectType">
	 	<option/>请选择
	 	<option value="s_command" <c:if test="${'s_command'.equals(paramType)}"> selected</c:if> />命令
	 	<option value="s_update_user" <c:if test="${'s_update_user'.equals(paramType)}"> selected</c:if> />操作用户
	 </select>
	 <input type="text" id="parameter" name="parameter" value="${parameter}"/>
	 <input type="button" value="搜索" onclick="page(1);">
			
	<table
		class="table table-striped table-bordered table-hover table-condensed"
		style="TABLE-LAYOUT:fixed">
		<thead>
			<tr align="center">
				<td
					style="width:5%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>*</strong></em>
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
		<tbody id="tbody1">
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