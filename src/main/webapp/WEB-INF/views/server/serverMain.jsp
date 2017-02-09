<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/sockjs-0.3.min.js"></script>
<script type="text/javascript">


var sock = null;
$(document).ready(function() {
	  alert('안냥');
	  
	  //ip적고 포트번호 맞추고 실행하면 됨 
	  
	  
	 /*  "http://192.168.202.140:8181/${pageContext.request.contextPath}/chat" */
	  sock = new SockJS("http://192.168.0.3:8111/${pageContext.request.contextPath}/server/serverMain");
	  alert('${pageContext.request.contextPath}');
	  sock.onopen = function(){
		  sock.send("반가워");
		  alert('안냥1');
	  }
	 
	  sock.onmessage = function(evt){
		  $("#chatMessage").append(evt.data + "<br/>");
	  }
	
	  sock.onclose= function(){
		  sock.send("퇴장");
	  }
	
	  $("#sendMessage").click(function(){
		if($("#message").val() !=""){
			sock.send($("#message").val());
			$("#chatMessage").append("나->" + $("#message").val()+"<br/>");
			$("message").val("");
		}
	  })
	  
});

	/* 	"http://192.168.202.139:8181/${pageContext.request.contextPath}/server/serverMain"	 */	
			/* http://192.168.202.139:8181/obs/server */
	
	

</script>

</head>
<body>
<h1>server page</h1>


	<h1>채팅페이지</h1>
 <input type="text" id="message"/>
 <input type="button" id="sendMessage" value="메세지보내기"/>
 <div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>

</body>
</html>