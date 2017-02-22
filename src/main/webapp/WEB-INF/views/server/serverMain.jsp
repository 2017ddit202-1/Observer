<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/sockjs-0.3.min.js"></script>
<script type="text/javascript">

function addlist_go(ip){
	//alert("qqqqqq");
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
	<h1>server page</h1>


	<h1>전체목록</h1>
	<input type="text" id="message" value="${clientIP}" />
	<input type="button" id="sendMessage" value="메세지보내기" />
	

	<%--  ${map} 에 앞부분에 sessionScope 생략가능하기 때문에 생략했음. --%>





<form id="formm" name="formm" method="post">
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
