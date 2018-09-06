<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
	<title>管理系统</title>
	<jsp:include page="/WEB-INF/page/jsp/common.jsp"></jsp:include>
	
	<script type="text/javascript">

		$(function(){
			showdiv('加载中...');
		});
		
		window.onload = function(){
			closediv();
		}
		
		function showcontent(title,url){
			showdiv('加载中...');
			if(false == $('#tt').tabs('exists',title)){
				var content = '<iframe id="iframe1" src="'+url+'" style="width:99%;height:99%;"></iframe>';
				
				$('#tt').tabs('add',{
				    title:title,
				    content:content,
				    closable:true
				});	
			}			
			$('#tt').tabs('select',title);
			closediv();
		}
	</script>

</head>


<body>

	<div class="easyui-layout" fit="true" modal="true">
		<div region="west" split="true" title="菜单" style="width:150px;">
			<p style="padding:5px;margin:0;"></p>
			<ul>
				<li><a href="javascript:void(0)" 
					onclick="showcontent('命令查询','${pageContext.request.contextPath}/cmd/home.do')">命令查询</a></li>
				<br>
					
				<li><a href="javascript:void(0)" 
					onclick="showcontent('文件操作','${pageContext.request.contextPath}/file/uploadPage.do')">文件操作</a></li>
				<br>
				
				<li><a href="javascript:void(0)" onclick="showcontent('#','#')">待定2</a></li>
				<br>
				
				<li><a href="javascript:void(0)" onclick="showcontent('#','#')">待定3</a></li>
				<br>
			</ul>
		</div>
		<div id="content" region="center" title="管理系统" style="padding:0.1px;">
			<div id="tt" class="easyui-tabs" fit="true"></div>
		</div>
	</div>


</body>
</html>
