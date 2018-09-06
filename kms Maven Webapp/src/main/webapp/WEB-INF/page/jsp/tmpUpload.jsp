<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
	<title>home</title>
	<jsp:include page="/WEB-INF/page/jsp/common.jsp"></jsp:include>
		<script type="text/javascript">
	
		$(function(){
			$('#fileDg').datagrid('getPager').pagination({
				beforePageText:'第',
				afterPageText:'页-共{pages}页',
				displayMsg:'显示{from}-{to}条记录 共  {total}条记录'
			});
		});
	
		function newUpload(){
			//alert("newUpload");
			$('#fileDlg').dialog('open');
		}
		
		function uploadFile(){
			showdiv('上传中...');
			var formData = new FormData();
			formData.append("file",document.getElementById("file").files[0]);
			$.ajax({
				url: "${pageContext.request.contextPath}/file/uploadFile.do",
				type: "post",
				data: formData,
				contentType: false,
				processData: false,
				success: function(e){
					closediv();
					$('#fileDg').datagrid('load');
					if(Number(1)!=1){
						alert("上传失败! "+e);
					}else{
						alert("上传成功.");
					}
				},
				error: function(e){
					closediv();
					alert("上传失败! "+e);
				}
			});
		}
		
		function downloadFile(){
			//alert("destroyUser");
			var index  = $("#fileDg").datagrid("getSelected");
			if(null==index){
				alert("请选中一行记录。");
				return;
			}
			url = "${pageContext.request.contextPath }/file/downloadFile.do?id="+index.id,
			//alert(url);
			window.location.href = url;
		}
		
		function destroyUser(){
			//alert("destroyUser");
			var index  = $("#fileDg").datagrid("getSelected");
			if(null==index){
				alert("请选中一行记录。");
				return;
			}
			
			if(!window.confirm("数据删除不可恢复！ 确认删除么?")){
	    		return ;
	    	}
	    	
   			$.post({
				url:"${pageContext.request.contextPath }/file/delete.do?id="+index.id,
				success:function(d){
					alert("已删除"+d+"条记录");
					$('#fileDg').datagrid('load');
				},
				error:function(){
					alert("error!");
				}
			});
		}
		
		function select(value,name){
			$('#fileDg').datagrid('load',{
				name:name,
				value:value
			});	   	 	
	    }
	</script>
	
</head>
<body>
	
	<table id="fileDg" title="" class="easyui-datagrid" fit="true"
		url="${pageContext.request.contextPath }/file/searchPage.do"
		toolbar="#toolbar" 
		pagination="true" 
		rownumbers="true" 
		fitColumns="true" 
		singleSelect="true" 
		modal="true" 
		autoRowHeight="false"
		nowrap="true"
		striped="true">
		<thead>
			<tr>
				<th checkbox="true" field="id" width="30" sortable="true">ID</th>
				<th field="name" width="60" sortable="true">文件名</th>
				<th field="url" width="60" sortable="true">URL</th>
				<th field="user" width="20" sortable="true">用户</th>
				<th field="comments" width="20" sortable="true">备注</th>
				<th field="uploadFileDate" formatter="formatDate" width="60" sortable="true">上传时间</th>
				<th field="downloadFileDate" formatter="formatDate" width="60" sortable="true">下载时间</th>
				<th field="flag" width="20" sortable="true">状态</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<input class="easyui-searchbox" style="width:300px" data-options="searcher:select,prompt:'请输入需要查询数据',menu:'#mm'" />
		<div id="mm" style="width:150px">
			 <div data-options="name:'all',iconCls:'icon-ok'">请选择</div>
		    <div data-options="name:'id'">ID</div>
		    <div data-options="name:'name'">文件名</div>
		    <div data-options="name:'url'">URL</div>
		    <div data-options="name:'user'">用户</div>
		    <div data-options="name:'comments'">备注</div>
		    <div data-options="name:'upload_file_date'">上传时间</div>
		    <div data-options="name:'download_file_date'">下载时间</div>
		    <div data-options="name:'flag'">标识</div>
		</div>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
			onclick="newUpload()">上传文件</a>
		<a id="downloadButton" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
			onclick="downloadFile()">下载文件</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			 onclick="destroyUser()">删除文件</a>
	</div>
	
	<div id="fileDlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" title="上传文件"  modal="true">
		<form id="uploadFile1" action="#" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>
						<input type="file" id="file" name="file" style="height:20px;">
					</td>
					<td>
						<a id="btn" onclick="uploadFile()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="height:20px;">上传</a>
					</td>
				</tr>
			</table>	
		</form>
	</div>	
	
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#fileDlg').dialog('close')">Cancel</a>
	</div>

</body>
</html>
