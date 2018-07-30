<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html lang="zh-CN">
	<head>
		<jsp:include page="../common/common.jsp"></jsp:include>
		<title>主页</title>
		<script type="text/javascript">

			$(function(){
				var i = 0;
				
				for(i=0; i<=100; i++){
					setTimeout("setState("+i+")",i*50);
				}
			});
			
			window.onload = function(){
				
			}
			
			function setState(d){
				document.getElementById("d1").style.width = d+'%';
				document.getElementById("d1").innerHTML = d+'%';
			}
		</script>
	</head>

	<body>
		<jsp:include page="../common/title.jsp"></jsp:include>	
		
		<div class="progress">
		  <div id="d1" class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
		    <span class="sr-only">0% Complete</span>
		  </div>
		</div>
		
		<!-- 
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-off"></span>
		</button>			
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-user"></span>
		</button>			
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-tasks"></span>
		</button>	
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-flag"></span>
		</button>	
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-hdd"></span>
		</button>	
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-folder-open"></span>
		</button>	
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-cloud"></span>
		</button>	
		 -->
	</body>
</html>