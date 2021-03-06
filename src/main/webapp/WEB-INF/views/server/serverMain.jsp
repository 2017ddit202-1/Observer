<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/sockjs-0.3.min.js"></script>
<script type="text/javascript">



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
				
				
				sock = new SockJS("http://" + document.domain + ":8181/observer/server/serverMain");

				function createSock(sock) {
					sock2 = sock;
					return sock2;
				}

				$('#addlist').click(function() {
					sock1 = createSock(sock);

					sock1.send("${map}");

				});

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
			
				
				
				
 			  var bulhwi = setInterval(function(){
 				$('#mm').load("serverMain #mm"); 
 			},10000); 

				
			 	$('.server_ip').on("click", function(){
			 		if($(this).is(":checked")){
						clearInterval(bulhwi);
						bulhwi=null;
					}else{
						if(bulhwi==null){
							bulhwi = setInterval(function(){
								$('#mm').load("serverMain #mm");
							},10000);
								
						}
					}
			});  
				
			 	
	});
 			
			
</script>
 <style>
	#page-wrapper3 {
    position: inherit;
    margin: 0 0 0 250px;
    padding: 65px 30px;
     box-shadow: 5px 5px 5px lightgray;
     border-radius: 10px; 
   
} 
#page-wrapper3 {
    padding: 0 15px;
    min-height: 568px;
    background-color: white;
    margin-left: 10%;
    width: 79%;
    height: 870px;
}



</style> 


</head>
<body>


<br>
<div id="page-wrapper3">
<br>
  <ul class="nav nav-tabs" style="margin-top: 3%;">
    <li class="active"><a href="#">SERVER</a></li>
   
  </ul>
  <br>
 
 <div class="media">
    <div class="media-left">
   <img src="<%=request.getContextPath()%>/resources/img/settings.png" class="media-object" style="width:60px;margin-left: 39%;">
    </div>
    <div class="media-body">
      <h4 class="media-heading" style="margin-left: 3%; margin-top: 1%;"><strong>SERVER 목록</strong></h4>
      <p style="margin-left: 3%;">동일한 라이센스를 가지고 있는 SERVER의 목록을 보여줍니다.</p>
    </div>
  </div>
  <hr>



	
	<c:choose>
		<c:when test="${loginUserPosl eq 'ROLE_USER' }">
			
			<div class="container" style="margin-left: 5%;">
  
	  <span class="label label-success">&nbsp&nbsp</span> 정상
	  <span class="label label-warning">&nbsp&nbsp</span> 경고
	  <span class="label label-danger">&nbsp&nbsp</span> 위험
	  <span class="label" style="background-color: black">&nbsp&nbsp</span> 정지
  <br><br>  
  
</div>
	<table id="mm" class="table table-striped">
       		<tr id="mm_tr">
				<td >위험도</td>
				<td>HOST NAME</td>
				<td>IP ADDRESS</td>
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
						<td><span class="label" style="background-color: black; ">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></td>
					</c:when>
					<c:otherwise>
					 <c:choose>
	            		<c:when test="${cputest <= 50.0}">
	            			<td> <span class="label label-success">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></td>
	            		</c:when>
	            		<c:when test="${cputest <=80.0}">
	            			<td><span class="label label-warning">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></td>
	            		</c:when>
	            		<c:when test="${cputest <=100.0}">
	            			<td> <span class="label label-danger">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></td>
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
				  <td>
				  	<c:set var="mom" value="${i.value.memory_total }" />
					<fmt:parseNumber  value="${mom}" pattern="###.###" var="memoryTest"/>
				  
				   <c:choose>
            		<c:when test="${ memoryTest<= 50.0}">
            			<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:   ${i.value.memory_total }%">
      							  ${i.value.memory_total }
    					</div>
            		</c:when>
            		<c:when test="${memoryTest <=80.0}">
            			<div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width:   ${i.value.memory_total }%">
      							  ${i.value.memory_total }
    					</div>
            		</c:when>
            		<c:otherwise>
            			<div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:   ${i.value.memory_total }%">
      							  ${i.value.memory_total }
    					</div>
            		</c:otherwise>
            	</c:choose>
				  ${i.value.memory_total }
				  </td>
			 	</tr>
             </c:forEach>
      </table>
						
		</c:when>	
		
		<c:when test="${loginUserPosl eq 'ROLE_ADMIN' }">
	
<div class="container" style="margin-left: 5%;">
  <span class="label label-success">&nbsp&nbsp</span> 정상
  <span class="label label-warning">&nbsp&nbsp</span> 경고
  <span class="label label-danger">&nbsp&nbsp</span> 위험
  <span class="label" style="background-color: black">&nbsp&nbsp</span> 정지
</div>
<form id="formm" name="formm" method="post">
<div style="margin-left: 83%;">
 <button type="button" class="btn btn-info btn-sm" style="font-size:13px; padding:3px 5px;" onclick="serverStop()">정지</button>
 <button type="button" class="btn btn-info btn-sm" style="font-size:13px; padding:3px 5px;" onclick="serverRemove()">해제</button>
 <button type="button" class="btn btn-info btn-sm" style="font-size:13px; padding:3px 5px;" onclick="serverStart()">시작</button>
 <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal" style="font-size:13px; padding:3px 5px;"  data-backdrop="static" data-keyboard="false" onclick="ssss()" >추가</button>
</div>
<br>
    
    <table id="mm"  class="table table-striped">
    		
       		<tr id="mm_tr">
       			<td>선택</td>
       			<td id="td1">위험도</td>
				<td>HOST NAME</td>
				<td>IP ADDRESS</td>
				<td>OS VERSION</td>
				<td>CPU 사용량(%)</td>
				<td>MEMORY 사용량(%)</td>
			</tr>
			
         <c:forEach items="${serverMap}" var="i" varStatus="a">
         	  
          		  <tr>
            			<td><input type="checkbox" name="server_ip" class="server_ip" id='server_ip' value="${i.value.server_ip}"></td>
            		<c:set var="test" value="${i.value.cpu_total_pcnt}" />
					<fmt:parseNumber  value="${test}" pattern="###.###" var="cputest"/>
			<td>
			
				<c:choose>
					<c:when test="${i.value.server_saveyn eq '0'}">
						<span class="label" style="background-color: black;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					</c:when>
					<c:otherwise>
					 <c:choose>
					 	<c:when test="${cputest == null}">
					 		<b>loading...</b>
					 	</c:when>
	            		<c:when test="${cputest <= 50.0}">
	            			 <span class="label label-success">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
	            		</c:when>
	            		<c:when test="${cputest <=80.0}">
	            			<span class="label label-warning">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
	            		</c:when>
	            		<c:when test="${cputest <=100.0}">
	            			 <span class="label label-danger">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
	            		</c:when>
	           		</c:choose>
           		</c:otherwise> 
           		
            	</c:choose>
            	</td>
				  <td>${i.value.server_host }</td>
             	  <td><a href="<%=request.getContextPath()%>/server/summary?summaryMenu=1&ip=${i.value.server_ip}">${i.value.server_ip}</a></td>
             	  <td>${i.value.server_os_name}</td>
            	  <td>
            	  	  <c:choose>
            		<c:when test="${cputest <= 50.0}">
            			<div id="testDiv" class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%; color:black;">
      							 <b>${i.value.cpu_total_pcnt}(%)</b>
    					</div>
    					
            		</c:when>
            		<c:when test="${cputest <=80.0}">
            			<div id="testDiv" class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%; color:black;">
      							 <b>${i.value.cpu_total_pcnt}(%)</b>
    					</div>
            		</c:when>
            		<c:otherwise>
            			<div id="testDiv" class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%; color:black;">
      							 <b>${i.value.cpu_total_pcnt}(%)</b>
    					</div>
            		</c:otherwise>
            	</c:choose>
            	 
            	  <div id="testDiv"></div>
            	  </td>
				  <td>
				  	<c:set var="mom" value="${i.value.memory_total }" />
					<fmt:parseNumber  value="${mom}" pattern="###.###" var="memoryTest"/>
				  
				   <c:choose>
            		<c:when test="${ memoryTest<= 50.0}">
            			<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:${i.value.memory_total }%; color:black;">
      							 <b>${i.value.memory_total }(%)</b>
    					</div>
            		</c:when>
            		<c:when test="${memoryTest <=80.0}">
            			<div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width:${i.value.memory_total }%; color:black;">
      							  <b>${i.value.memory_total }(%)</b>
    					</div>
            		</c:when>
            		<c:otherwise>
            			<div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:${i.value.memory_total }%; color:black;">
      							  <b>${i.value.memory_total }(%)</b>
    					</div>
    					
            		</c:otherwise>
            	</c:choose>
				
				  </td>
			 	</tr>
             </c:forEach>
      </table>
      
 </form>
 </c:when>
<c:otherwise>
	<div class="container" style="margin-left: 5%;">
  	<span class="label label-success">&nbsp&nbsp</span> 정상
  	<span class="label label-warning">&nbsp&nbsp</span> 경고
      <span class="label label-danger">&nbsp&nbsp</span> 위험
	  <span class="label" style="background-color: black">&nbsp&nbsp</span> 정지
	</div>
	
	<form id="formm" name="formm" method="post">
		<table id="mm"  class="table table-striped">
			<tr>
				<td id="td1">위험도</td>
				<td>HOST NAME</td>
				<td>IP ADDRESS</td>
				<td>OS VERSION</td>
				<td>CPU 사용량(%)</td>
				<td>MEMORY 사용량(%)</td>
			</tr>
			<c:forEach items="${serverMapSuper}" var="i" varStatus="a">
				<tr>
				<c:set var="test" value="${i.value.cpu_total_pcnt}" />
					<fmt:parseNumber  value="${test}" pattern="###.###" var="cputest"/>
						
					<c:choose>
					<c:when test="${i.value.server_saveyn eq '0'}">
						<td><span class="label" style="background-color: black; ">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></td>
					</c:when>
					<c:otherwise>
					 <c:choose>
	            		<c:when test="${cputest <= 50.0}">
	            			<td> <span class="label label-success">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></td>
	            		</c:when>
	            		<c:when test="${cputest <=80.0}">
	            			<td><span class="label label-warning">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></td>
	            		</c:when>
	            		<c:when test="${cputest <=100.0}">
	            			<td> <span class="label label-danger">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></td>
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
            			<div id="testDiv" class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%; color:black;">
      							 <b>${i.value.cpu_total_pcnt}(%)</b>
    					</div>
    					
            		</c:when>
            		<c:when test="${cputest <=80.0}">
            			<div id="testDiv" class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%; color:black;">
      							 <b>${i.value.cpu_total_pcnt}(%)</b>
    					</div>
            		</c:when>
            		<c:otherwise>
            			<div id="testDiv" class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: ${i.value.cpu_total_pcnt}%; color:black;">
      							 <b>${i.value.cpu_total_pcnt}(%)</b>
    					</div>
            		</c:otherwise>
            	</c:choose>
            	 
            	  <div id="testDiv"></div>
            	  </td>
				  <td>
				  	<c:set var="mom" value="${i.value.memory_total }" />
					<fmt:parseNumber  value="${mom}" pattern="###.###" var="memoryTest"/>
				  
				   <c:choose>
            		<c:when test="${ memoryTest<= 50.0}">
            			<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:${i.value.memory_total }%; color:black;">
      							 <b>${i.value.memory_total }(%)</b>
    					</div>
            		</c:when>
            		<c:when test="${memoryTest <=80.0}">
            			<div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width:${i.value.memory_total }%; color:black;">
      							  <b>${i.value.memory_total }(%)</b>
    					</div>
            		</c:when>
            		<c:otherwise>
            			<div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:${i.value.memory_total }%; color:black;">
      							  <b>${i.value.memory_total }(%)</b>
    					</div>
            		</c:otherwise>
            	</c:choose>
				
				  </td>
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
        <form id="formm" name=" " method="POST">
      <table class="table table-hover table-bordered">
       		<thead style="background-color: #e4eaf2">
       		<tr>
				<th>IP</th>
				<th>HOST NAME</th>
				<th>OS 버전</th>
				<th>OS 종류</th>
				<th>선택</th>
				
			</tr>
			</thead>
         <c:forEach items="${map}" var="i">
         <c:if test="${i.value.saveyn eq '0' }">
         <tbody>
            <tr >
                  <td>${i.key }</td>
             	  <td>${i.value.hostName }</td>
             	  <td>${i.value.os_version }</td>
             	  <td>${i.value.os_name }</td>
             	<td><input type="button" class="btn btn-success btn-xs" id="addlist" value="등록" onclick="addlist_go('${i.key }')"/></td>
             </tr>
         </tbody>
          </c:if>
             </c:forEach>
      </table>
   </form>
  </div>
</div>
</div>
</div></div>

	



	<div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>

	<script>
		$(function(){
			var a = '${serverMap}';
			$.each(a,function(i){
				alert(a.i);
			})
		})
	</script>	

	<c:if test="${!empty userOK}">
		<script>
			 /* alert('${column}');  */
			
			  swal("고객님의 권한신청이", "${column}","success");  
		</script>
	</c:if>

</div>


</body>
</html>
