<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<jsp:include page="../common/common.jsp"></jsp:include>
	<title>文件下载</title>
</head>

  
  <body>
  	<jsp:include page="../common/title.jsp"></jsp:include>	
	 
	<table class="table table-striped table-bordered table-hover table-condensed" style="TABLE-LAYOUT:fixed">
		<thead>
			<tr>
				<td style="width:80%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis">文件信息</td>
				<td style="width:20%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis">点击下载</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${fileNames}" var="fileName">
				<tr>
					<td style="width:80%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis">${fileName}</td>
					<td style="width:20%;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis">
						<a href="${pageContext.request.contextPath}/sjl22/downloadFileAction.action?fileName=${fileName}">Download</a>
					</td>
				</tr>		
			</c:forEach>
		</tbody>
	</table>
  </body>
</html>
