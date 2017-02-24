<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/sockjs-0.3.min.js"></script>
<script type="text/javascript">

function addlist_go(ip){
	alert("추가되었습니다."); 
	document.formm.action = "<%=request.getContextPath()%>"	+ "/server/serverHandling?currentIp="+ip;
	document.formm.submit();
}



function test_go(){
	document.formm.action = "<%=request.getContextPath()%>"+"/server/testForm";
		document.formm.submit();
	}

	var sock = null;
	$(document).ready(
			function() {

				
				sock = new SockJS("http://" + document.domain
						+ ":8181/observer/server/serverMain");

				function createSock(sock) {
					sock2 = sock;
					return sock2;
				}

				$('#addlist').click(function() {
					sock1 = createSock(sock);

					sock1.send("${map}");

				});

				/* sock.onmessage = function(evt){
				  $("#chatMessage").append(evt.data + "<br/>");
				 } */

				sock.onclose = function() {
					sock.send("퇴장");
				}

				$("#sendMessage").click(
						function() {
							if ($("#message").val() != "") {
								sock.send($("#message").val());
								$("#chatMessage").append(
										"나->" + $("#message").val() + "<br/>");
								$("message").val("");
							}
						});

			});
	
	

</script>


</head>
<body>
	<c:choose>
		<c:when test="${loginUserPosl eq 'ROLE_USER' }">
			<h1>user page</h1>
		
		</c:when>
		<c:otherwise>
	

	<h1>server page</h1>


	<h1>전체목록</h1>
	<input type="text" id="message" value="${clientIP}" />
	<input type="button" id="sendMessage" value="메세지보내기" />
	

	<%--  ${map} 에 앞부분에 sessionScope 생략가능하기 때문에 생략했음. --%>





<form id="formm" name="formm" method="post">
 <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal" style="font-size:13px; padding:3px 5px; margin:1% auto 1% 20.5%;">추가</button>

      <table border=1>
       		<tr>
				<td>hostName</td>
				<td>OS 버전</td>
				<td>ip</td>
				<td>OS 종류</td>
				<td>server_os_support</td>
				
			</tr>
         <c:forEach items="${serverList}" var="i">
            <tr>
                <td>  ${i.server_host }</td>
             	  <td>${i.server_os_version }</td>
             	  <td>${i.server_ip}</td>
             	  <td>${i.server_os_name }</td>
             	  <td>${i.server_os_support }</td>
             	</tr>
             </c:forEach>
      </table>
   </form>
   </c:otherwise>
</c:choose>

 


<div class="container">
 
  <!-- Trigger the modal with a button -->

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">서버추가</h4>
        </div>
        <div class="modal-body">
        리스트자리
        <form id="formm" name=" " method="post">
      <table border=1>
       		<tr>
				<td>ip</td>
				<td>hostName</td>
				<td>OS 버전</td>
				<td>OS 종류</td>
			</tr>
         <c:forEach items="${map}" var="i">
            <tr>
                <td>  ${i.key }</td>
             	  <td>${i.value.hostName }</td>
             	  <td>${i.value.os_version }</td>
             	  <td>${i.value.os_name }</td>
             	  <input type = "hidden" id="${i.key }" name="${i.key }" value="${i.key }"/>
					<td><input type="button" id="addlist" value="등록" onclick="addlist_go('${i.key }')"/></td>
               </tr>
             </c:forEach>
      </table>
   </form>
        
        
        </div>


</div></div></div></div>


	<div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>

	<!-- //////////////////////////////////////////////////////////////// -->

	<%-- <a href="<%=request.getContextPath()%>/server/testForm">테스트get</a> --%>
	

	<c:if test="${!empty userOK}">
		<script>
			alert('${column}');
		</script>
	</c:if>

</body>
</html>
