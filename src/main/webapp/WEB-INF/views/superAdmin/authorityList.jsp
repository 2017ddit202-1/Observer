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
<%-- function authorityAccept_go(){
	document.formm.action = "<%=request.getContextPath()%>/superAdmin/authorityAccept";
	document.formm.submit();
	} --%>
	var wsocket;
	
	function authorityAccept_go(){
		document.formm.action = "<%=request.getContextPath()%>/test/authority";
		
		
		

		var chklen = document.formm.mem_id.length; //폼의 전체길이
		
		for(i=0; i<chklen; i++){
			if(document.formm.mem_id[i].checked==true){
				alert(mem_id[i].value);
				var message = {};
				message.id = mem_id[i].value;
				wsocket.send(JSON.stringify(message));
			
			}
		}
		
		
		
		
		
		/*  for(i=0; i<chklen; i++){
			    if(document.formm.mem_id[i].checked == true){
			       count++;
			    }
			  }

		// 체크박스 갯수만큼 for 문을 돌려 체크된 넘의 value값을 가져온다.
		 for(i=0; i<chklen; i++){ 
		    if(document.formm.mem_id[i].checked == true){ //0번째부터 전체 길이
		    	
		    	if(count==1){
		    		id += document.formm.mem_id[i].value;
		    	}else if(count==0){
		    		
		    	}else{
		    		 if(count==totalCNT){ 
				        	id += document.formm.mem_id[i].value;
				        }else{
				        	id += document.formm.mem_id[i].value;
					        id += ',';
					        totalCNT++;
				       }	     
		    	}
		    }
		  } 
		 var message = {};
			message.id = id;
			message.authority = id;
			wsocket.send(JSON.stringify(message)); */
		
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