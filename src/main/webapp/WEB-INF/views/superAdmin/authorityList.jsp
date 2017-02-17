<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br>
<br>
<br>
<br>
<h1>권한리스트입니다.</h1>
<button type="button" onclick="allcheckBox()">전체선택</button>
<button type="button" onclick="allcheckBoxDelete()">전체해제</button>
<button type="button" onclick="authorityAccept_go()">수락</button>
<button type="button" onclick="authorityAcceptNO_go()">거절</button>




<thead>
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
<thead>


	<%--  <form action="<%=request.getContextPath() %>/test/authority" method="GET" >
   <input type="submit" value="testtest"/>
</form>

<button type="button" onclick="authorityAccept_go()">수락</button> --%>


	<script>

	var wsocket;
	
	function authorityAccept_go(){
		
		document.formm.action = "<%=request.getContextPath()%>/test/authority";

		var chklen = document.formm.mem_id.length; //폼의 전체길이
		
		for(i=0; i<chklen; i++){
			if(document.formm.mem_id[i].checked==true){ //체크한 값이 있으면
				/* alert(mem_id[i].value); */
				var message = {};
				message.id = mem_id[i].value;  //->제이슨 형태로 {id: 체크한 곳의 아이디값}
				wsocket.send(JSON.stringify(message));
				// wsocket.send ==> 소켓 인터셉터 거쳐서 핸들러로 가는데..send가 있어야만 핸들러의 handleTextMessage()가 실행
			}
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