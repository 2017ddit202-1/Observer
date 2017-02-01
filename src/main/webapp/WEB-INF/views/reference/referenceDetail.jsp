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

<form id="formm" name="formm">
  <input type="text" id="reli_subject" value="${referenceVO.reli_subject}">
  <input type="text" id="reli_content" value="">
  <input type="text" id="reli_file_nm" value="">
  <input type="text" id="reli_date" value="">

	<button type="button" onclick="location.href='<%=request.getContextPath()%>/rf/referenceWrite' ">수정하기</button>

</form>
