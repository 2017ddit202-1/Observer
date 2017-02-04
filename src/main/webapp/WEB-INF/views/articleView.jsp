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
	<h2>공지사항</h2>
	<h4>Article</h4>
</div>

<form action="<%=request.getContextPath()%>/article/articleSearch"
	name="search" method="post">

	<!-- //size="1"->1개만선택가능 -->
	<select name="keyField" size="1">
		<option value="noar_seq">게시글번호</option>
		<option value="noar_subject">제목</option>
		<option value="noar_content">내용</option>
	</select> <input type="text" size="16" name="keyWord" id="keyWord"> <input
		type="button" value="검색" onClick="check()"> <input
		type="hidden" name="page" value="0">
	</td>

</form>

<br>
<form>
	<table border=1>
		<tr>
			<th>게시글번호</th>
			<th>아이디</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록날짜</th>
			<th>조회수</th>
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
			<c:when test="${!empty articleSearch }">
				<c:forEach items="${articleSearch}" var="articleVO">
					<tr>
						<th>${articleVO.noar_seq}</th>
						<th>${loginUser}</th>
						<!-- //////////articleVO.noar_id -->
						<th><a href="detailArticle?noar_seq=${articleVO.noar_seq}">${articleVO.noar_subject}</a></th>
						<th>${articleVO.noar_content}</th>
						<th>${articleVO.noar_date}</th>
						<th>${articleVO.noar_cnt }</th>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" style="text-align: center;">${paging}</td>
				</tr>
			</c:when>


			<c:otherwise>
			<c:forEach items="${articleList}" var="articleVO">
					<tr>
						<th>${articleVO.noar_seq}</th>
						<th>${loginUser}</th>
						<!-- //////////articleVO.noar_id -->
						<th><a href="detailArticle?noar_seq=${articleVO.noar_seq}">${articleVO.noar_subject}</a></th>
						<th>${articleVO.noar_content}</th>
						<th>${articleVO.noar_date}</th>
						<th>${articleVO.noar_cnt }</th>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" style="text-align: center;">${paging}</td>
				</tr>
			
			</c:otherwise>
			
			
		</c:choose>
		
		</table>

		<%-- <c:choose>
			<c:when test="${qnaListSize<=0}">
				<tr>
					<td width="100%" colspan="5" align="center" height="23">There
						are no registered qna.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${articleList}" var="articleVO">
					<tr>
						<th>${articleVO.noar_seq}</th>
						<th>${loginUser}</th>
						<!-- //////////articleVO.noar_id -->
						<th><a href="detailArticle?noar_seq=${articleVO.noar_seq}">${articleVO.noar_subject}</a></th>
						<th>${articleVO.noar_content}</th>
						<th>${articleVO.noar_date}</th>
						<th>${articleVO.noar_cnt }</th>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" style="text-align: center;">${paging}</td>
				</tr>

			</c:otherwise>
		</c:choose> --%>

	



</form>

<sec:authorize access="hasRole('ROLE_SUPER')">
	<button type="button" onclick="location.href='articleWrite' ">글쓰기</button>
</sec:authorize>


<script>
function check() {
	
	if (document.search.keyWord.value == "") {
        alert("검색어를 입력하세요.");
        document.search.keyWord.focus();
        return;
    }
	
    document.search.action = "<%=request.getContextPath()%>/article/articleSearch";
	document.search.submit();
}

<%-- function list_go(){
	document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaList?qna_seq="+"${qnaVO.qseq}";
	document.formm.submit();
	
}
 --%>

</script>



