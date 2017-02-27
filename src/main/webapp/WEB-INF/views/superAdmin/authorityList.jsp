<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  	<script>

	var wsocket;
	
	function authorityAccept_go(){
		
		document.formm.action = "<%=request.getContextPath()%>/superAdmin/authorityList";

		var chklen = document.formm.mem_id.length;
		
		if(chklen==undefined){
			chklen=1;
		}//폼의 전체길이
		alert(chklen);
		if(chklen != 1){

		for(i=0; i<chklen; i++){
			if(document.formm.mem_id[i].checked==true && chklen!=1){ //체크한 값이 있으면
			 alert(mem_id[i].value); 
				var message = {};
				message.id = mem_id[i].value;  //->제이슨 형태로 {id: 체크한 곳의 아이디값}
				wsocket.send(JSON.stringify(message));
				// wsocket.send ==> 소켓 인터셉터 거쳐서 핸들러로 가는데..send가 있어야만 핸들러의 handleTextMessage()가 실행
			}
		}
		}else if(chklen==1){
			alert(document.formm.mem_id.value);
			var message = {};
			message.id = document.formm.mem_id.value;
			wsocket.send(JSON.stringify(message));
			alert('ffff');
		}

		document.formm.submit();
		}
	
	
	
	function authorityAcceptNO_go(){
		document.formm.action = "<%=request.getContextPath()%>/superAdmin/authorityAcceptNO";
		document.formm.submit();
	}
	
	
	function allcheckBox() {
		$("input[name=mem_id]").prop("checked", true);

	}
	function allcheckBoxDelete() {
		$("input[name=mem_id]").prop("checked", false);

	}
</script>
  
  
</head>
<body>


<br>
<br>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">SUPER ADMIN</a></li>
    <li><a href="<%=request.getContextPath()%>/superAdmin/authorityMemberList">회원관리</a></li>
    <li><a href="<%=request.getContextPath()%>/superAdmin/authorityList">권한요청관리</a></li>
    <li><a href="<%=request.getContextPath()%>/superAdmin/reportList">보고서</a></li>
  </ul>
  <br>
  <p><strong>Notice:</strong> OBSERVER의 회원관리, 회원의 권한신청을 관리 할 수 있습니다. </p>
</div><br><br>


<!-- <button type="button" onclick="allcheckBox()">전체선택</button>
<button type="button" onclick="allcheckBoxDelete()">전체해제</button>
<button type="button" onclick="authorityAccept_go()">수락</button>
<button type="button" onclick="authorityAcceptNO_go()">거절</button>
 -->

<div class="container">
  <button type="button" onclick="allcheckBox()" class="btn btn-default"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;전체선택</button>
  <button type="button" onclick="allcheckBoxDelete()" class="btn btn-default"><i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;전체해제</button>
   <div class="btn-group">
    <button type="button" onclick="authorityAccept_go()" class="btn btn-primary" >&nbsp;&nbsp;수락&nbsp;&nbsp;</button>
    <button type="button" onclick="authorityAcceptNO_go()" class="btn btn-primary" >&nbsp;&nbsp;거절&nbsp;&nbsp;</button>
  </div>
</div>



<div class="container">
<form id="formm" name="formm" method="post">
<table id="memberList" class="table table-striped">
			<thead>
				<tr>
				<th>선택</th>
				<th>아이디</th>
				<th>현재권한</th>
				<th>요청권한</th>
				<th>신청날짜</th>
				
				</tr>
			</thead>
			<tbody>
							<c:forEach items="${su_authorityList }" var="Vw_AuthorityVO">
				<tr>
					<td><input type="checkbox" name="mem_id" id="mem_id"
						value="${Vw_AuthorityVO.atrt_id }"></td>
					<td>${Vw_AuthorityVO.atrt_id }</td>
					<td>${Vw_AuthorityVO.posl_pos }</td>
					<td><c:choose>

							<c:when test="${Vw_AuthorityVO.posl_pos eq'ROLE_USER'}">
       ADMIN으로 권한신청
    </c:when>

							<c:otherwise>
        USER로 권한신청
    </c:otherwise>

						</c:choose></td>
					<td><fmt:formatDate value="${Vw_AuthorityVO.atrt_date }"
										pattern="yyyy-MM-dd" /></td>
					
				
					
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</form>
</div> 



<%--  <thead>
	<form id="formm" name="formm" method="post">
		<table border=1>
			<tr>
				<th>선택</th>
				<th>아이디</th>
				<th>현재권한</th>
				<th>요청권한</th>
				<th>신청날짜</th>
				<th>수락여부</th>

			</tr>

			<c:forEach items="${su_authorityList }" var="Vw_AuthorityVO">
				<tr>
					<th><input type="checkbox" name="mem_id" id="mem_id"
						value="${Vw_AuthorityVO.atrt_id }"></th>
					<th>${Vw_AuthorityVO.atrt_id }</th>
					<th>${Vw_AuthorityVO.posl_pos }</th>
					<th><c:choose>

							<c:when test="${Vw_AuthorityVO.posl_pos eq'ROLE_USER'}">
       ADMIN으로 권한신청
    </c:when>

							<c:otherwise>
        USER로 권한신청
    </c:otherwise>

						</c:choose></th>
					<th>${Vw_AuthorityVO.atrt_date }</th>
					<th>수락여부</th>
				</tr>
			</c:forEach>



		</table>
	</form>

</thead>  --%>
</body>

	<%--  <form action="<%=request.getContextPath() %>/test/authority" method="GET" >
   <input type="submit" value="testtest"/>
</form>

<button type="button" onclick="authorityAccept_go()">수락</button> --%>


