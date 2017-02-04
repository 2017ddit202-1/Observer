<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<br>
<br>
<div id="contract">
	<h2>자료 상세보기</h2>
	<h4>Reference Detail</h4>
</div>

<form id="formm" name="formm" enctype="multipart/form-data" method="post">
	제목:<input type="text" name="reli_subject" id="reli_subject" value="${referenceVO.reli_subject}"><br> 
	내용:<textarea rows="20" cols="40" name="reli_content">${referenceVO.reli_content}</textarea><br>
	파일크기:<input type="text" name="reli_size" id="reli_size" value="${referenceVO.reli_size }"><br>
	파일명:<input type="text" name="reli_file_nm1" value="${referenceVO.reli_file_nm}"><br>
		
		<sec:authorize access="hasRole('ROLE_SUPER')">
		<input type="file"name="uploadfile" id="uploadfile"><br>
		</sec:authorize>
	<%-- 날짜:<inputtype="text" name="reli_date" value="${referenceVO.reli_date}"><br> --%>
	<input type="hidden" name="reli_seq" value="${referenceVO.reli_seq}">
	<input type="hidden" name="reli_stored_filenm" value="${referenceVO.reli_stored_filenm}">

	

	<sec:authorize access="hasRole('ROLE_SUPER')">
	<button type="button" onclick="referenceUpDate_go()">수정하기</button>
	</sec:authorize>
	

	<sec:authorize access="hasRole('ROLE_SUPER')">
	<button type="button" onclick="referenceDelete_go()">삭제하기</button>
	</sec:authorize>


      
     <a href="<%=request.getContextPath() %>/filee/${referenceVO.reli_seq}"> 
     	<button type="button">다운로드하기</button></a> 
     
     <button type="button" onclick="history.go(-1)">취소</button>

</form>

<script>
function referenceUpDate_go(){
	document.formm.action="<%=request.getContextPath() %>/rf/referenceDetail";
	document.formm.submit();
	
}
function referenceDelete_go(){
	document.formm.action="<%=request.getContextPath() %>/rf/referenceDelete";
	document.formm.submit();
}
</script>

