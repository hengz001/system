<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
	<title>home</title>
	<jsp:include page="/WEB-INF/page/jsp/common.jsp"></jsp:include>
		<script type="text/javascript">
	
		$(function(){
			$("#div1" ).css("display", "none"); 
			
			$('#dg').datagrid('getPager').pagination({
				beforePageText:'第',
				afterPageText:'页-共{pages}页',
				displayMsg:'显示{from}-{to}条记录 共  {total}条记录'
			});
		});
		
		function newUser(){
			//alert("newUser");
		
			$('#id').attr("value","");
			$('#flag').attr("value","");
			$('#datetime').attr("value","");
			$('#command').attr("value","");
			$('#request').attr("value","");
			$('#response').attr("value","");
			$('#user').attr("value","");
			$('#note').attr("value","");
			var date = new Date();
			$('#datetime').datetimebox('setValue', formatDate(date));

			$('#dlg').dialog('open');
		}
		
		function editUser(){
			//alert("editUser");
			var index  = $("#dg").datagrid("getSelected");
			if(null==index){
				alert("请选中一行记录。");
				return;
			}
			
			$.post({
				url:"${pageContext.request.contextPath }/cmd/updatePage.do?id="+index.id,
				success:function(d){
					//alert("success."+d);
					var obj = eval('('+d+')');
					var date = formatDate(obj.datetime);
					
					$('#id').attr("value",obj.id);
					$('#flag').attr("value",obj.flag);
					$('#datetime').attr("value",date);
					$('#command').attr("value",obj.command);
					$('#request').attr("value",obj.request);
					$('#response').attr("value",obj.response);
					$('#user').attr("value",obj.user);
					$('#note').attr("value",obj.note);
					$('#datetime').datetimebox('setValue', date);

					$('#dlg').dialog('open');
				},
				error:function(){
					alert("error!");
				}
			});
		}
		
		function destroyUser(){
			//alert("destroyUser");
			var index  = $("#dg").datagrid("getSelected");
			if(null==index){
				alert("请选中一行记录。");
				return;
			}
			
			if(!window.confirm("数据删除不可恢复！ 确认删除么?")){
	    		return ;
	    	}
			
			$.post({
				url:"${pageContext.request.contextPath }/cmd/delete.do?id="+index.id,
				success:function(d){
					alert("已删除"+d+"条记录");
					$('#dg').datagrid('load');
				},
				error:function(){
					alert("error!");
				}
			});
		}
	
		function saveUser(){
			//alert("saveUser");
			$.post({
				url: "${pageContext.request.contextPath }/cmd/addOrUpdate.do",
				data: $("#fm").serialize(),
				success:function(d){
				//	alert("successfully.");
					$('#dg').datagrid('load');
				},
				error:function(e){
					alert("error!");
				}
			});
			$('#dlg').dialog('close');
		}
		
		function select(value,name){
			$('#dg').datagrid('load',{
				name:name,
				value:value
			});	   	 	
	    }
	    
	    function uploadDataFile(){
			var formData = new FormData();
			formData.append("file",document.getElementById("file").files[0]);
			
			$('#dataDlg').dialog('close');
			showdiv('批量添加中...');
			$.ajax({
				url: "${pageContext.request.contextPath}/cmd/uploadDataFile.do",
				type: "post",
				data: formData,
				contentType: false,
				processData: false,
				success: function(e){
					closediv();
					$('#dg').datagrid('load');
					if(Number(1)!=1){
						alert("操作失败! "+e);
					}else{
						alert("操作成功.");
					}
				},
				error: function(e){
					closediv();
					alert("操作失败! "+e);
				}
			});
		}
		
		function batchAdd(){
			$('#dataDlg').dialog('open');
		}
	</script>
	
</head>
<body>
	
	<table id="dg" title="" class="easyui-datagrid" fit="true"
		url="${pageContext.request.contextPath }/cmd/searchPage.do"
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
			<th checkbox="true" field="id" width="10" sortable="true">ID</th>
			<th field="request" width="40" sortable="true">命令</th>
			<th field="response" width="40" sortable="true">响应</th>
			<th field="datetime" formatter="formatDate" width="10" sortable="true">更新时间</th>
			<!-- 
			<th field="command" width="50" sortable="true">命令</th>
			<th field="user" width="50" sortable="true">用户</th>
			<th field="note" width="50" sortable="true">描述</th>
			<th field="flag" width="20" sortable="true">状态</th>
			 -->
		</tr>
	</thead>
	</table>
	
	<div id="toolbar">
		<input class="easyui-searchbox" style="width:300px" data-options="searcher:select,prompt:'请输入需要查询数据',menu:'#mm'" />
		<div id="mm" style="width:150px">
			 <div data-options="name:'all',iconCls:'icon-ok'">请选择</div>
		    <div data-options="name:'id'">ID</div>
		    <div data-options="name:'command'">命令</div>
		    <div data-options="name:'request'">请求</div>
		    <div data-options="name:'response'">响应</div>
		    <div data-options="name:'note'">描述</div>
		    <div data-options="name:'user'">用户</div>
		    <div data-options="name:'flag'">标识</div>
		    <div data-options="name:'datetime'">时间</div>
		</div>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="batchAdd()">批量添加</a>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" title="窗口"  modal="true">
		<div class="ftitle">信息:</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>命令:</label>
				<input name="command" id="command">
			</div>
			<div class="fitem">
				<label>请求:</label>
				<input name="request" id="request">
			</div>
			<div class="fitem">
				<label>响应:</label>
				<input name="response" id="response">
			</div>
			<div class="fitem">
				<label>用户:</label>
				<input name="user" id="user">
			</div>
			<div class="fitem">
				<label>描述:</label>
				<input name="note" id="note">
			</div>
			
			<div id="div1">
				<div class="fitem">
					<label>标识:</label>
					<input name="id" id="id">
				</div>
				<div class="fitem">
					<label>时间:</label>
					<input name="datetime" id="datetime" class="easyui-datetimebox">
				</div>
					<div class="fitem">
					<label>状态:</label>
					<input name="flag" id="flag">
				</div>
			</div>
			
		</form>
	</div>	
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
	
	<div id="dataDlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dataDlg-buttons" title="批量添加"  modal="true">
		<form id="dataDlgForm" action="#" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>
						<input type="file" id="file" name="file" style="height:20px;">
					</td>
					<td>
						<a id="btn" onclick="uploadDataFile()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="height:20px;">批量添加</a>
					</td>
				</tr>
			</table>	
		</form>
		<div id="dataDlg-buttons">
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dataDlg').dialog('close')">Cancel</a>
		</div>	
	</div>
	

</body>
</html>
