<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="<%=request.getContextPath()%>/resources/css/cpu.css"rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/disk.js"></script>
</head>
<body onload="myFunction()" style="margin:0;">
   <br /><br /><br /><br /><br /><br />
   <br /><br /><br /><br /><br /><br />
   <form id="formm" name="formm">
   <div id="btnHo1">
   <br>
       <input type="button" id="btnZxc" class="btn btn-default" value="30분" onclick="vv()">
      <input type="button" id="btntotal" class="btn btn-default" value="1시간" onclick="ss()">
      </div>
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
      
     <div id="trafficNet">
     	<table id="diskTb">
     		<tr>
     			<th id="card">Disk</th>
     		</tr>
     		<c:forEach var="driList" items="${nmList}">
     			<tr>
     				<td><input type="button" value="${driList.disk_nm}" class="hhh">&nbsp;
     					<input type="hidden" name="${driList.disk_nm}" value="${driList.disk_nm}">
     				</td>
     			</tr>
     		</c:forEach>
     		<c:forEach var="pcntList" items="${pcntList}" varStatus="status">
     								<div>${pcntList.disk_pcnt} %</div>
     					</c:forEach>
     		
     		
     	</table> 
     </div>
     <div id="page-wrapper10" class="in">
     <div id="container3"></div>
     </div>
     <div id="page-wrapper11" class="in">
     <div id="container"></div>
     </div>
     <div id="page-wrapper12" class="in">
     <div id="container2"></div>
     </div>
   </form>
 <script>
 function qq(aa){
	 clearInterval(inter);
	 clearInterval(inter2);
	 clearInterval(inter3);
	 ww(aa);
	 inter3 = setInterval(function(){ww(aa);} ,5000);
 }
 function ww(aa){
		$.ajax({
			url : "<%=request.getContextPath()%>/disk/driCBtnList",
			type : "post",
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify({
				"aa" : aa
			}),
			success : function(data) {
				$("#loader").hide();
				$("#btnZxc").show();
				$("#btntotal").show();
				HighCharts(data);
				HighCharts2(data);
				HighCharts3(data);
			}

		});
 }
	 
 
 $('.hhh').on('click', function() {
	 var aa = $(this).val();
	 qq(aa);
	});
 </script>  
</body>
</html>