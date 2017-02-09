<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/sockjs-0.3.min.js"></script>

	<script type="text/javascript">

	$(document).ready(function() {
		 conn(); 
		/*  $('#enterBtn').on('click', function() {
			conn();
		});  */
		$('#sendBtn').click(function() { send(); });
	})

	/* 	"http://192.168.202.139:8181/${pageContext.request.contextPath}/server/serverMain"	 */	
			/* http://192.168.202.139:8181/obs/server */
	
		var socket;
	function conn() {
		obsocket = new SockJS(
				"http://localhost:8181${pageContext.request.contextPath}/server/serverMain"
				);
		
		obsocket.send;
		obsocket.onmessage = m;
	
	
	}
	
observer = setInterval(function(){
		send();
	},3000);

function serverstop(){
	 alert("정지");
	 clearInterval(observer);
 }
	
	
	
	function send() {
 		/* alert("send"); */
		var msg = $("#content").val();
		 obsocket.send(msg); 
		 m(e); 
			
	}
	
	function m(evt){
		alert('바보멍충아');
	}


</script>

</head>
<body>
<h1>server page</h1>


	id <input type="text" id="name">
	content <input type="text" id="content" value="${test}">
	
	<!-- <input type = "button" id="enterBtn" value="연결"> -->
	<input type = "button" id="enterBtn" value="추가">
	<input type = "button" id="startBtn" value="메세지보내기" onclick="m()">
	
	<input type = "button" id="sendBtn" value="Servertop" onclick="serverstop()" >
	

</body>
</html>