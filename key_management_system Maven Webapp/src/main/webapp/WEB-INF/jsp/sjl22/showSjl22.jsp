<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html lang="zh-CN">
<head>
<jsp:include page="../common/common.jsp"></jsp:include>
<title>命令详情</title>
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
	 			
	 		var url = "${pageContext.request.contextPath}/sjl22/findPage.action?"
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
	<jsp:include page="../common/title.jsp"></jsp:include>	
	
	<nav aria-label="Page navigation">
		<ul class="pagination">
			<li>
			<a aria-label="Previous" <c:if test="${page.hasPrePage}"> onclick="page(${page.prePage});"</c:if> >
					<span aria-hidden="true">&laquo;</span>
			</a>
			</li>

			<c:forEach var="i" begin="1" end="${page.pageCount}">
				<c:if test="${page.currpageNum-i<5 && i< page.currpageNum + 5}">
						<li <c:if test="${i == page.currpageNum}">class="active"</c:if> >
							<a onclick="page(${i});">
								<c:if test="${i<10}">0</c:if>${i}
							</a>
						</li>
				</c:if>
			</c:forEach>


			<li><a aria-label="Next" <c:if test="${page.hasNextPage}"> onclick="page(${page.nextPage});"</c:if> >
					<span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>

	<form class="form-inline">
		<label>count: ${page.totalCount!=null?page.totalCount:0} &nbsp;  </label>

		<select id="select1" name="select1" onchange="page(1);" class="form-control"> 
			<c:choose>
				<c:when test="${page.pageSize==1}">
					<option value="1" selected>1行</option>
				</c:when>
				<c:otherwise>
					<option value="1">1行</option>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageSize==3}">
					<option value="3" selected>3行</option>
				</c:when>
				<c:otherwise>
					<option value="1">3行</option>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageSize==10}">
					<option value="10" selected>10行</option>
				</c:when>
				<c:otherwise>
					<option value="10">10行</option>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageSize==100}">
					<option value="100" selected>100行</option>
				</c:when>
				<c:otherwise>
					<option value="100">100行</option>
				</c:otherwise>
			</c:choose>
		</select>
	
		 <select id="selectType" name="selectType" class="form-control">
		 	<option>请选择</option>
	 		<c:choose>
				<c:when test="${'s_command' eq paramType}">
					<option value="s_command" selected>命令</option>			
				</c:when>
				<c:otherwise>
					<option value="s_command">命令</option>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${'s_update_user'eq paramType}">
				 	<option value="s_update_user" selected>操作用户</option>
				</c:when>
				<c:otherwise>
				 	<option value="s_update_user">操作用户</option>
				</c:otherwise>
			</c:choose>
		 </select>
	 
		<div class="form-group">
			<input type="text" id="parameter" name="parameter" value="${parameter}" class="form-control">
		</div>
		<button onclick="page(1);" type="button" class="btn btn-primary">
		  <span>搜索</span>
		</button>
	</form>

	<!-- 
	 <input type="text" id="parameter" name="parameter" value="${parameter}"/>
	 <input type="button" value="搜索" onclick="page(1);">
	 -->
			
	<table
		class="table table-striped table-bordered table-hover table-condensed"
		style="TABLE-LAYOUT:fixed">
		<thead>
			<tr >
				<td
					style="width:5%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>*</strong></em>
						</h5></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>命令</strong></em>
						</h5></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>请求</strong></em>
						</h5></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>响应</strong></em>
						</h5></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>描述</strong></em>
						</h5></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>修改时间</strong></em>
						</h5></td>
				<td
					style="width:15%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis"><h5>
						<em><strong>修改用户</strong></em>
						</h5></td>
			</tr>
		</thead>
		<tbody id="tbody1">
			<c:forEach items="${objs}" var="obj">
				<tr >
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