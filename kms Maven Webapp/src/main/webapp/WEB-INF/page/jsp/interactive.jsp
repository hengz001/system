<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
	<title>管理系统</title>
	<jsp:include page="/WEB-INF/page/jsp/common.jsp"></jsp:include>
	
	<script type="text/javascript">
		var recv;
		var recvHex;
	
		function submit(){
			var ip;
			var port;
			var inValue;
			
			ip = $("#ip").val();
			port = $("#port").val();
			inValue = $("#inValue").val();
			
			$("#outValue").val("");
			showdiv('读取中...');
			$.post("${pageContext.request.contextPath}/cmd/interactiveAction.do",
				{ip:ip,port:port,inValue:inValue},
				function(data){
					var d = eval('('+data+')');
					recv = d.recv;
					recvHex = d.recvHex;
					check();
					closediv();
				}
			);
		}
		
		function check(){
			if($("#hexShow").get(0).checked){
				$("#outValue").val(recvHex);
			}else{
				$("#outValue").val(recv);
			}
		}
	</script>
</head>

<body>
	<form action="#">
		<div>
			<label>IP</label>
			&nbsp;&nbsp;&nbsp;&nbsp;	
			<input class="easyui-textbox" id="ip" type="text"  value="192.168.1.203">
		</div>
		 
		<div >
			<label>PORT</label>
			<input class="easyui-textbox" id="port" type="text"   value="8000">
		</div>
	</form>
	
	<div >
		<label>输入</label>
		<textarea id="inValue"  rows="10" cols="60">NC</textarea>
	</div>
	
	<div >
		<label>输出</label>
		<textarea id="outValue"  rows="10" cols="60"></textarea>
	</div>
	
	<label > 
		  <input onchange="check()"  id="hexShow" type="checkbox">十六进制显示
	</label>
	
	<div  align="center">
		<button type="button" class="easyui-linkbutton" onclick="submit()">提交</button>
	</div>
	
</body>		
</html>
