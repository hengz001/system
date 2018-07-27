<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="zh-CN">
	<head>
		<jsp:include page="../common/common.jsp"></jsp:include>
		<title>交互</title>
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
				
				$.post('${pageContext.request.contextPath}'+"/sjl22/interactiveAction.action",
					{ip:ip,port:port,inValue:inValue},
					function(data){
						var d = eval('('+data+')');
						recv = d.recv;
						recvHex = d.recvHex;
						check();
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
		<jsp:include page="../common/title.jsp"></jsp:include>	
		
		<form action="#" class="form-inline">
			<div class="form-group">
				<label>IP</label>
				<input id="ip" type="text" class="form-control" placeholder="格式 192.168.1.100" value="192.168.1.203">
			</div>
			 
			<div class="form-group">
				<label>PORT</label>
				<input id="port" type="text" class="form-control" placeholder="格式  8000" value="8000">
			</div>
		</form>
		
		<div class="form-group">
			<label>输入</label>
			<textarea id="inValue" class="form-control" rows="3">NC</textarea>
		</div>
		
		<div class="form-group">
			<label>输出</label>
			<textarea readonly id="outValue" class="form-control" rows="3"></textarea>
		</div>
		
		<label class="checkbox-inline"> 
			  <input onchange="check()"  id="hexShow" type="checkbox">十六进制显示
		</label>
		
		<div class="form-group" align="center">
			<button type="button" class="btn btn-default btn-lg" onclick="submit()">提交</button>
		</div>
		
	</body>		
</html>