<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/sockjs-0.3.min.js"></script>
<script type="text/javascript">

/* function checkBox() {
	$("input[name=server_id]").prop("checked", true);

} */

function serverStop(ip){
	alert('전송정지합니다.');
	 var chklen = document.formm.server_ip.length;
	 var count=0;
	 var ipArray = "";
	 if(chklen == undefined){
		 chklen = 1;
	 }
	 if(chklen != 1){
		 for(i=0; i<chklen; i++){
			 if(document.formm.server_ip[i].checked == true && chklen != 1){
				 if(count == 0){
					 ipArray = ipArray + server_ip[i].value;
					 count++;
				 }else{
					 ipArray = ipArray +','+ server_ip[i].value;
				 }
			 }
		 }
	 }else if(chklen == 1){
		 ipArray = document.formm.server_ip.value;
	 }
	 alert(ipArray);
	document.formm.action = "<%=request.getContextPath()%>"+"/server/serverStop?ipArray="+ipArray; 
	document.formm.submit();

}

 function serverStart(ip){
	 var chklen = document.formm.server_ip.length;
	 var count=0;
	 var ipArray = "";
	 if(chklen == undefined){
		 chklen = 1;
	 }
	 if(chklen != 1){
		 for(i=0; i<chklen; i++){
			 if(document.formm.server_ip[i].checked == true && chklen != 1){
				 if(count == 0){
					 ipArray = ipArray + server_ip[i].value;
					 count++;
				 }else{
					 ipArray = ipArray +','+ server_ip[i].value;
				 }
			 }
		 }
	 }else if(chklen == 1){
		 ipArray = document.formm.server_ip.value;
	 }
	 alert(ipArray);
	document.formm.action = "<%=request.getContextPath()%>"+"/server/serverStart?ipArray="+ipArray;
	document.formm.submit();
}
 
function serverRemove(ip){
	 var chklen = document.formm.server_ip.length;
	 var count=0;
	 var ipArray = "";
	 if(chklen == undefined){
		 chklen = 1;
	 }
	 if(chklen != 1){
		 for(i=0; i<chklen; i++){
			 if(document.formm.server_ip[i].checked == true && chklen != 1){
				 if(count == 0){
					 ipArray = ipArray + server_ip[i].value;
					 count++;
				 }else{
					 ipArray = ipArray +','+ server_ip[i].value;
				 }
			 }
		 }
	 }else if(chklen == 1){
		 ipArray = document.formm.server_ip.value;
	 }
	 alert(ipArray);
	document.formm.action = "<%=request.getContextPath()%>"+"/server/serverRemove?ipArray="+ipArray;
	document.formm.submit();
}


 
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
			
		 	/* 	function refresh(){
		               location.reload();
		            }
		          tid = setInterval(refresh,3000);  
					 */
		          
/* 		        	$("button").click(function(){
		        	 	$("#testDiv").load("serverMap"); 
		          });
 */		          
		         
 			setInterval(function(){
 				$('#mm').load("serverMain #mm");
 			},3000);
			});
 
	

</script>


</head>
<body>
	<c:choose>
		<c:when test="${loginUserPosl eq 'ROLE_USER' }">
			<h1>user page</h1>
			<div class="container">
  
	  <span class="label label-success">&nbsp&nbsp</span> 정상
	  <span class="label label-warning">&nbsp&nbsp</span> 경고
	  <span class="label label-danger">&nbsp&nbsp</span> 위험
	  <span class="label" style="background-color: black">&nbsp&nbsp</span> 정지
  <br><br>  
  
</div>
	<table border=1 id="mm">
       		<tr>
				<td>위험도</td>
				<td>Host Nmae</td>
				<td>IP</td>
				<td>OS VERSION</td>
				<td>CPU 사용량(%)</td>
				<td>MEMORY 사용량(%)</td>
			</tr>
         <c:forEach items="${serverMap}" var="i">
              <tr>
           <c:set var="test" value="${i.value.cpu_total_pcnt}" />
					<fmt:parseNumber  value="${test}" pattern="###.###" var="cputest"/>
				<c:choose>
					<c:when test="${i.value.server_saveyn eq '0'}">
						<td style="background-color: black;"></td>
					</c:when>
					<c:otherwise>
					 <c:choose>
	            		<c:when test="${cputest <= 50.0}">
	            			<td style="background-color: green;"></td>
	            		</c:when>
	            		<c:when test="${cputest <=80.0}">
	            			<td style="background-color: yellow;"></td>
	            		</c:when>
	            		<c:when test="${cputest <=100.0}">
	            			<td style="background-color: red;"></td>
	            		</c:when>
	           		</c:choose>
	           		</c:otherwise>
            	</c:choose>
				  <td>${i.value.server_host }</td>
             	  <td><a href="<%=request.getContextPath()%>/server/summary?summaryMenu=1&ip=${i.value.server_ip}">${i.value.server_ip}</a></td>
             	  <td>${i.value.server_os_name}</td>
            	  <td>
            	  	  <c:choose>
            		<c:when test="${cputest <= 50.0}">
            			<div id="testDiv" class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%">
      							 ${i.value.cpu_total_pcnt}
    					</div>
    					
            		</c:when>
            		<c:when test="${cputest <=80.0}">
            			<div id="testDiv" class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%">
      							 ${i.value.cpu_total_pcnt}
    					</div>
            		</c:when>
            		<c:otherwise>
            			<div id="testDiv" class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%">
      							 ${i.value.cpu_total_pcnt}
    					</div>
            		</c:otherwise>
            	</c:choose>
            	  ${i.value.cpu_total_pcnt}
            	  <div id="testDiv"></div>
            	  </td>
				  <td>${i.value.memory_total }</td>
			 	</tr>
             </c:forEach>
      </table>
						
		</c:when>
		<c:otherwise>
	<h1>전체목록</h1>
		<div class="container">
  <span class="label label-success">&nbsp&nbsp</span> 정상
  <span class="label label-warning">&nbsp&nbsp</span> 경고
  <span class="label label-danger">&nbsp&nbsp</span> 위험
  <span class="label" style="background-color: black">&nbsp&nbsp</span> 정지
  
  <br><br>  
  	</div>
<form id="formm" name="formm" method="post">
 <button type="button" class="btn btn-info btn-sm" style="font-size:13px; padding:3px 5px; margin:auto auto auto 423px;" onclick="serverStop()">정지</button>
 <button type="button" class="btn btn-info btn-sm" style="font-size:13px; padding:3px 5px;" onclick="serverRemove()">해제</button>
 <button type="button" class="btn btn-info btn-sm" style="font-size:13px; padding:3px 5px;" onclick="serverStart()">시작</button>
 <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal" style="font-size:13px; padding:3px 5px;"  data-backdrop="static" data-keyboard="false" onclick="ssss()" >추가</button>
 
      <table border=1 id="mm">
       		<tr>
       			<td>선택</td>
       			<td>위험도</td>
				<td>Host Name</td>
				<td>IP</td>
				<td>OS VERSION</td>
				<td>CPU 사용량(%)</td>
				<td>MEMORY 사용량(%)</td>
			</tr>
         <c:forEach items="${serverMap}" var="i">
            <tr>
            	<th><input type="checkbox" name="server_ip" id="server_ip" value="${i.value.server_ip}"></th>
					<c:set var="test" value="${i.value.cpu_total_pcnt}" />
					<fmt:parseNumber  value="${test}" pattern="###.###" var="cputest"/>
			
				<c:choose>
					<c:when test="${i.value.server_saveyn eq '0'}">
						<td style="background-color: black;"></td>
					</c:when>
					<c:otherwise>
					 <c:choose>
	            		<c:when test="${cputest <= 50.0}">
	            			<td style="background-color: green;"></td>
	            		</c:when>
	            		<c:when test="${cputest <=80.0}">
	            			<td style="background-color: yellow;"></td>
	            		</c:when>
	            		<c:when test="${cputest <=100.0}">
	            			<td style="background-color: red;"></td>
	            		</c:when>
	           		</c:choose>
	           		</c:otherwise>
            	</c:choose>
				
				  <td>${i.value.server_host }</td>
             	  <td><a href="<%=request.getContextPath()%>/server/summary?summaryMenu=1&ip=${i.value.server_ip}">${i.value.server_ip}</a></td>
             	  <td>${i.value.server_os_name}</td>
            	  <td>
            
            	   <c:choose>
            		<c:when test="${cputest <= 50.0}">
            			<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%">
      							 ${i.value.cpu_total_pcnt}
    					</div>
            		</c:when>
            		<c:when test="${cputest <=80.0}">
            			<div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%">
      							 ${i.value.cpu_total_pcnt}
    					</div>
            		</c:when>
            		<c:otherwise>
            			<div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%">
      							 ${i.value.cpu_total_pcnt}
    					</div>
            		</c:otherwise>
            	</c:choose>
            	  ${i.value.cpu_total_pcnt}
            	  </td>
				  <td>${i.value.memory_total }</td>
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
         <c:if test="${i.value.saveyn eq '0' }">
            <tr>
                <td>  ${i.key }</td>
             	  <td>${i.value.hostName }</td>
             	  <td>${i.value.os_version }</td>
             	  <td>${i.value.os_name }</td>
             	 <%--  <input type = "hidden" id="${i.key }" name="${i.key }" value="${i.key }"/> --%>
					<td><input type="button" id="addlist" value="등록" onclick="addlist_go('${i.key }')"/></td>
               </tr>
               </c:if>
             </c:forEach>
      </table>
   </form>
        </div>
</div></div></div></div>


	<div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>

	

	<c:if test="${!empty userOK}">
		<script>
			alert('${column}');
		</script>
	</c:if>

</body>
</html>