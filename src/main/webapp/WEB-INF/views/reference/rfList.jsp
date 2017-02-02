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
	<h2>자료실</h2>
	<h4>Reference</h4>
</div>
<form>
	<table border=1>
		<tr>
			<th>게시글번호</th>
			<th>아이디</th>
			<th>제목</th>
			<th>파일이름</th>
			<th>등록날짜</th>
		</tr>
		
		
		<c:forEach items="${referenceList}" var="referenceVO">
		<tr>
		<th> ${referenceVO.reli_seq}</th>
		<th> ${referenceVO.mem_id}</th>
		<th> ${referenceVO.reli_subject}</th>
		<th> ${referenceVO.reli_file_nm}</th>
		<th> ${referenceVO.reli_date}</th>
		</tr>
		</c:forEach>
		
		

	</table>
	<button type="button" onclick="location.href='<%=request.getContextPath()%>/rf/referenceWrite' ">글쓰기</button>
</form>


