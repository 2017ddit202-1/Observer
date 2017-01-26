<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


	<br> <br>
	<div id="contract">
		<h2>공지사항</h2>
		<h4>My Page</h4>
	</div>
<form>
	<table border=1>
		<tr>
			<th>게시글번호</th>
			<th>아이디</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록날짜</th>
		</tr>
		<%-- <c:forEach items="${articleList}" var="articleVO">
	<tr>
	 <th>${articleVO.noar_seq}</th>
	 <th>${articleVO.noar_id}</th>  
	 <th><a href="detailArticle?noar_seq=${articleVO.noar_seq}">${articleVO.noar_subject}</a></th>
	 <th>${articleVO.noar_content}</th>
	 <th>${articleVO.noar_date}</th>
	</tr>
	</c:forEach> --%>
		<c:choose>
				<c:when test="${qnaListSize<=0}">
						<tr>
							<td width="100%" colspan="5" align="center" height="23">
								There are no registered qna.</td>
						</tr>
					</c:when>
				<c:otherwise>
			<c:forEach items="${articleList}" var="articleVO">
				<tr>
						<th>${articleVO.noar_seq}</th>
						<th>${loginUser}</th> <!-- //////////articleVO.noar_id -->
						<th><a href="detailArticle?noar_seq=${articleVO.noar_seq}">${articleVO.noar_subject}</a></th>
						<th>${articleVO.noar_content}</th>
						<th>${articleVO.noar_date}</th>
					</tr>
			</c:forEach>
			<tr>
				<td colspan="6" style="text-align: center;">${paging}</td>
			</tr>

		</c:otherwise>
		</c:choose>
		<!--  -->
		</table>
	


	</form>



	<sec:authorize access="hasRole('ROLE_SUPER')">
		<button type="button" onclick="location.href='articleWrite' ">글쓰기</button>
	</sec:authorize> 




