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

	/* "http://"+document.domain+":8181/server/serverMain" */
	  //ip적고 포트번호 맞추고 실행하면 됨 
	/* 		  "${pageContext.request.contextPath}/server/serverMain" */  
	  /*/socket/echo-ws */
	 /*  http://192.168.202.140:8181/${pageContext.request.contextPath}/chat" */
	  /* alert('${pageContext.request.contextPath}');  */

	  sock = new SockJS("http://"+document.domain+":8181/observer/server/serverMain");
	 
	  sock.onopen = function(){
		  sock.send("@");
		
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


</script>

</head>
<body>
<h1>server page</h1>


   <h1>채팅페이지</h1>
 <input type="text" id="message" value="${clientIP}"/>
 <input type="button" id="sendMessage" value="메세지보내기"/>
 
 <div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>
 
 <!-- //////////////////////////////////////////////////////////////// -->




<c:if test="${!empty userOK}">
  <script> alert('${column}');</script>
</c:if>

</body>
</html>
