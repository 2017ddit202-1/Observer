<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
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
    height: 700px;
}
</style>


</head>
<body>

<br>
<br>


<div id="page-wrapper3" class="in">
<div class="container">
  <ul class="nav nav-tabs" style="margin-top: 3%;">
    <li class="active"><a href="#">ADMIN</a></li>
    <li><a href="<%=request.getContextPath()%>/group/meminvalid">그룹초대</a></li>
    <li><a href="<%=request.getContextPath()%>/group/groupList">그룹관리</a></li>
  </ul>
  <br>
 
 <div class="media">
    <div class="media-left">
   <img src="<%=request.getContextPath()%>/resources/img/target.png" class="media-object" style="width:60px;margin-left: 39%;">
    </div>
    <div class="media-body">
      <h4 class="media-heading" style="margin-left: 3%; margin-top: 1%;"><strong>그룹초대</strong></h4>
      <p style="margin-left: 3%;">ADMIN이 회원을 그룹에 초대하고, 관리할 수 있습니다.</p>
    </div>
  </div>
  <hr>
</div>

<br><br>


<div class="container">
  <button type="button"onclick="allcheckBox()" class="btn btn-default"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;전체선택</button>
  <button type="button" onclick="allcheckBoxDelete()" class="btn btn-default"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;전체해제</button>
   <div class="btn-group">
    <button type="button" onclick="invalidAccept_go()" class="btn btn-primary" >&nbsp;&nbsp;그룹등록&nbsp;&nbsp;</button>
  </div>
</div>






<div class="container">
<form id="formm" name="formm" method="post">
<table id="memberList" class="table table-striped">
			<thead>
				<tr id="group_tr">
					<td style="width: 79px;">번호</td>
					<td style="width: 300px;">아이디</td>
					<td>메일</td>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${LiceList}" var="memList" varStatus="status">
					<tr>
						<th><input type="checkbox" name="mem_id" id="mem_id"
						value="${memList.mem_id }"></th>
						<td>${memList.mem_id}</td>
						<td>${memList.mem_email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</form>
</div>

</div>
<script>
	function invalidAccept_go(){

		
		var chklen = document.formm.mem_id.length;
		var member="";
		var count=0;
		if(chklen==undefined){
			chklen=1;
		}//폼의 전체길이
		if(chklen != 1){

		for(i=0; i<chklen; i++){
			if(document.formm.mem_id[i].checked==true && chklen!=1){ //체크한 값이 있으면
				if(count==0){
					member = member + mem_id[i].value;
					count++;
				}else{
					member = member +','+mem_id[i].value;
				}
				
			}
		}
		}else if(chklen==1){
			member = document.formm.mem_id.value;
		}
		
		document.formm.action = "<%=request.getContextPath()%>/group/memList?member="+member;
		document.formm.submit();
	}
	
	
	function allcheckBox() {
		$("input[name=mem_id]").prop("checked", true);

	}
	function allcheckBoxDelete() {
		$("input[name=mem_id]").prop("checked", false);
	}
</script>

</body>

</html>