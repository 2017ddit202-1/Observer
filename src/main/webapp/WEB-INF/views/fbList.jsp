<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	<br> <br>
	<div id="contract">
		<h2>자유게시판</h2>
	</div>
<form name="search" method="post">
	<div>
		<select name="keyField" size="1" id="keyField">
			<option value="fb_sub">제목</option>
			<option value="fb_con">내용</option>
			<option value="fb_id">작성자</option>
		</select> <input type="text" name="keyWord" id="keyWord"
			placeholder="Search...">
		<button type="button" id="searchBtn" class="searchBtn" onclick="search_go()">
			<i class="fa fa-search"></i>
		</button>
	</div>
</form>
<br>
<form name="writeForm" method="post">
	<table border=1>
		<tr>
			<th>게시글번호</th>
			<th>아이디</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${fbListSize<=0}">
				<tr>
					<td width="100%" colspan="5" align="center" height="23">
 								There are no registered qna.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${fbList}" var="fbList">
					<tr>
						<th>${fbList.fb_seq}</th>
						<th>${fbList.fb_id}</th>
						<th><a href="<%=request.getContextPath() %>/fb/fbDetail?fb_seq=${fbList.fb_seq}">${fbList.fb_subject}</a></th>
						<th>${fbList.fb_content}</th>
						<th>${fbList.fb_date}</th>
						<th>${fbList.fb_cnt}</th>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" style="text-align: center;">${paging}</td>
				</tr>
				
			</c:otherwise>
		</c:choose>
	</table>	
	</form>

	<sec:authorize access="isAuthenticated()">
		<button type="button" onclick="fbWrite_go() ">글쓰기</button>
		<button type="button" onclick="fbList_go() ">목록보기</button>
	</sec:authorize> 

<script>
	function fbWrite_go(){
		document.writeForm.action = "<%=request.getContextPath()%>/fb/fbWriteForm";
		document.writeForm.submit();
	}
	function search_go(){
		
// 		if (document.search.keyWord.value == "") {
// 	        alert("검색어를 입력하세요.");
// 	        document.search.keyWord.focus();
// 	        return;
// 	    }
		
		document.search.action="<%=request.getContextPath()%>/fb/fbSearch";
		document.search.submit();
	}
	function fbList_go(){
		document.writeForm.action = "<%=request.getContextPath()%>/fb/fbList";
		document.writeForm.submit();
	}
	
</script>



