<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script>
function writeForm_go(){
	
	document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaWriteForm";
	document.formm.submit();
	}
</script>



</head>
<body>
	<h2>Q&A게시판</h2>

	<form name="formm" method="post">
		<table border='1'>
			<tr>
				<th>게시글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록날짜</th>
				<th>답변여부</th>
				
			</tr>
			<br>
			<br>
			
			<!-- ////////////////////////////////////////////////////////////// -->
			<c:choose>
				<c:when test="${qnaListSize<=0}">
						<tr>
							<td width="100%" colspan="5" align="center" height="23">
								There are no registered qna.</td>
						</tr>
					</c:when>
			<c:otherwise>
			<c:forEach items="${qnaList}" var="qnaVO">
				<tr>
					<td>${qnaVO.qseq}</td>
					<td>${qnaVO.qna_id}</td>
					<%-- <a href="detailArticle?noar_seq=${articleVO.noar_seq}"> --%>
					<td><a href="detailQna?qna_qseq=${qnaVO.qseq}">${qnaVO.qna_subject}</a></td>
					<td><fmt:formatDate value="${qnaVO.qna_date}" pattern="yyyy-MM-dd"/></td>
					
					<c:choose>			
					<c:when test="${qnaVO.qna_check == 1 }">
					<td>답변완료</td>
					</c:when>
					 <c:otherwise>
					 	<td>답변진행중</td>
					 </c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align: center;">${paging}</td>
			</tr>

		</c:otherwise>
		</c:choose>
		<!--  -->
		</table>
		<input type="submit" value="질문하기" onclick="writeForm_go()" />


	</form>




</body>
</html>

