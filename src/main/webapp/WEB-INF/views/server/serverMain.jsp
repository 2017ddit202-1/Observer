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

function test_go(){
	document.formm.action = "<%=request.getContextPath()%>"+ "/server/testForm";
	document.formm.submit();
}

var sock = null;
$(document).ready(function() {
	alert('${map.ip}');
	alert('${map.host}');
	
	
	/* var i = ${data};
	alert(i); */
	/* "http://"+document.domain+":8181/server/serverMain" */
	  //ip적고 포트번호 맞추고 실행하면 됨 
	/* 		  "${pageContext.request.contextPath}/server/serverMain" */  
	  /*/socket/echo-ws */
	 /*  http://192.168.202.140:8181/${pageContext.request.contextPath}/chat" */
	  /* alert('${pageContext.request.contextPath}');  */
	   sock = new SockJS("http://"+document.domain+":8181/observer/server/serverMain"); 
// 	 sock = new WebSocket("ws://"+document.domain+":8181/observer/server/serverMain");
	  
	  function createSock(sock){
		  sock2 = sock;
		  return sock2;
	  }
		
	  
	  
	  $('#addlist').click(function(){
		  sock1 = createSock(sock);
		  sock1.send("@");		
		 	  
	  });
	  
	 /* sock.onmessage = function(evt){
		  $("#chatMessage").append(evt.data + "<br/>");
	  } */
	
	  sock.onclose= function(){
		  sock.send("퇴장");
	  }
	
	  $("#sendMessage").click(function(){
		/* if($("#message").val() !=""){
			sock.send($("#message").val());
			$("#chatMessage").append("나->" + $("#message").val()+"<br/>");
			$("message").val("");
		} */
	  });
	  

	  
   
     
 

});


</script>

</head>
<body>
<h1>server page</h1>


   <h1>채팅페이지</h1>
 <input type="text" id="message" value="${clientIP}"/>
 <input type="button" id="sendMessage" value="메세지보내기"/>
 <input type="button" id="addlist" value="추가"/>
<h1>${map.ip }</h1>
<h1>${map.host }</h1>

<hr>

 <h1>ip : ${classip}</h1>
 <h1>hostName : ${classHost}</h1>
  
 
 
 
 <form action="<%=request.getContextPath() %>/test/authority" method="GET" >
   <input type="submit" value="testtest"/>
</form>
 
 <div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>
 
 <!-- //////////////////////////////////////////////////////////////// -->

<%-- <a href="<%=request.getContextPath()%>/server/testForm">테스트get</a> --%>
<form name="formm" method="GET"></form>
<input type="button"  value="testGET" onclick="test_go()"/>

<c:if test="${!empty userOK}">
  <script> alert('${column}');</script>
</c:if>

</body>
</html>
