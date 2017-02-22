<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style>
#detail_table_tr{
height: 50px;
border-top: 1px solid #c3ced9;
border-bottom: 1px solid #c3ced9;
text-align: center;
}
</style>


<br> <br>
	<div style="text-align: center;">
		<h2>자료 상세보기</h2>
	</div>
	<br><br><br>
	
	<form id="formm" name="formm" enctype="multipart/form-data" method="post">
<table style="width: 1000px;" align="center">

<tr id="detail_table_tr">
<td style="background-color: #e4eaf2; width: 90px; border-top: 1px solid #c3ced9;">제목</td>
<td><input type="text" name="reli_subject" value="${referenceVO.reli_subject}" style="border: none; outline: none; width: 500px; text-align:center;"></td>
<td></td>
<td></td>
</tr>

<tr id="detail_table_tr">
<td style="background-color: #e4eaf2; border-top: 1px solid #c3ced9;">파일명</td>

<td><input type="text" name="reli_file_nm1" value="${referenceVO.reli_file_nm}" style="border: none; outline: none; width: 500px; text-align:center;"></td>


<td style="background-color: #e4eaf2; width: 90px; border-top: 1px solid #c3ced9;">파일크기</td>
<td style="border-top: 1px solid #c3ced9;"><input type="text" name="reli_size" value="${referenceVO.reli_size }" style="border: none; outline: none; width: 60px; text-align:center; "></td>
</tr>


</table>
<div style="text-align: center;">
<textarea name="reli_content" style="border:0; overflow-y:hidden; background:clear; resize: none; width: 1000px; height: 400px; outline: none;">${referenceVO.reli_content}</textarea>
<hr style="border: solid 1px #c3ced9; width: 1000px;">
</div>	


	<input type="hidden" name="reli_seq" value="${referenceVO.reli_seq}">
	<input type="hidden" name="reli_stored_filenm" value="${referenceVO.reli_stored_filenm}">
	
	
	
	<sec:authorize access="hasRole('ROLE_SUPER')">
		<table style="width: 1000px;" align="center">
	    <tr id="detail_table_tr">
          <td style="background-color: #e4eaf2; border-top: 1px solid #c3ced9; width: 90px;">파일명</td>
          <td><input type="file"name="uploadfile" id="uploadfile"></td>
		</table>
		<br>
		</sec:authorize>

		
		
<div style="text-align: center;">

	<sec:authorize access="hasRole('ROLE_SUPER')">
	<button type="button" onclick="referenceUpDate_go()">수정하기</button>
	</sec:authorize>
	

	<sec:authorize access="hasRole('ROLE_SUPER')">
	<button type="button" onclick="referenceDelete_go()">삭제하기</button>
	</sec:authorize>


      
     <a href="<%=request.getContextPath() %>/filee/${referenceVO.reli_seq}"> 
     	<button type="button">다운로드하기</button></a> 
     
     <button type="button" onclick="history.go(-1)">취소</button>
</div>

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

