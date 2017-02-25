<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
<h1>회원등록 화면 입니다.</h1>

<button type="button" onclick="allcheckBox()">전체선택</button>
<button type="button" onclick="allcheckBoxDelete()">전체해제</button>
<button type="button" onclick="invalidAccept_go()">그룹등록</button>

<div class="container">
	<form id="formm" name="formm" method="post">
		<table class="table table-hover" style="width: 1000px;" align="center"
			id="groupTable">
			<thead>
				<tr id="group_tr">
					<td style="width: 79px;">번호</td>
					<td>아이디</td>
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