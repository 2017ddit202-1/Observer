<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script>
function writeForm_go(){
	document.formm.action = "<%=request.getContextPath()%>"	+ "/qna/qnaWriteForm";
		document.formm.submit();
	}
	
	
	function serachQna_go(){
		document.formm.action = "<%=request.getContextPath()%>"	+ "/qna/qnaList";
		document.formm.submit();
		
	}
	
</script>
</head>
<body>


<br>
<br>
	<h2>Q&A게시판</h2>

	<form name="formm" method="post">
		<div>
		<select name="keyField" size="1">
		<option value="qna_seq">게시글번호</option>
		<option value="qna_seq">제목</option>
		<option value="qna_seq">내용</option>
		<option value="qna_seq">작성자</option>
	</select> 
			<input type="text" name="key" placeholder="Search...">
			<button  type="button" onclick="serachQna_go()">
				<i class="fa fa-search"></i>
			</button>
		</div>
		<table border='1'>
			<tr>
				<th>게시글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록날짜</th>
				<th>답변여부</th>

			</tr>
			

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
							
					
					<c:choose>
					<c:when test="${loginUser eq qnaVO.qna_id || mempos.posl_pos eq 'ROLE_ADMIN'}">
						<td><a href="detailQna?qna_qseq=${qnaVO.qseq}">${qnaVO.qna_subject}</a></td>
				</c:when>
					<c:otherwise>
							<td>${qnaVO.qna_subject}</td>
					</c:otherwise>
					
					</c:choose>
							
							
							<td><fmt:formatDate value="${qnaVO.qna_date}"
									pattern="yyyy-MM-dd" /></td>

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

