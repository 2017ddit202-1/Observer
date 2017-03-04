<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	<style type="text/css">

#article_tr td {
	background-color: #e4eaf2;
	border-top: 1px solid #c3ced9;
	border-bottom: 1px solid #ffffff;
	height: 50px;
	padding-top: 1.5%;
	text-align: center;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 1px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	height: 28px;
}

.button2 {
	background-color: #337ab5;
} 

</style>


<script>
	function fbWrite_go(){
		document.writeForm.action = "<%=request.getContextPath()%>/fb/fbWriteForm";
		document.writeForm.submit();
	}
	function search_go(){
		document.search.action="<%=request.getContextPath()%>/fb/fbSearch";
		document.search.submit();
	}
	function fbList_go(){
		document.writeForm.action = "<%=request.getContextPath()%>/fb/fbList";
		document.writeForm.submit();
	}
	
</script>
	
	
	<br><br><br>

	<div style="font-size: 30px; width: 1000px; text-align: left; margin-left: 242px;">
		<img src="<%=request.getContextPath()%>/resources/img/arrow.png">자유게시판 
	<span style="font-size: 15px; color: #7c7c7c">각종 안내, 서비스 또는 OBSERVER의 소식 버전안내 등의 정보를 확인할 수 있습니다.</span>
	
	</div>

	<br>
	<br>
	
	
	
	
		<!-- 서치 -->
	<div style="width: 1000px; float: right; text-align: center;">
		<form name="search" method="post">

			<select name="keyField" size="1" style="height: 22px;" id="keyField">
				<option value="fb_sub">제목</option>
			    <option value="fb_con">내용</option>
			    <option value="fb_id">작성자</option>
			</select> <input type="text" size="16" name="keyWord" id="keyWord"
				style="height: 24px;">

			<button id="searchBtn" class="button button2" onClick="search_go()">검색</button>
			<input type="hidden" name="page" value="0">
		</form>
	</div>
	<br>
	<br>
	<br>

	<!-- /서치 -->
	
	

	
	<div class="container">
	<i class="fa fa-bullhorn" aria-hidden="true"></i>
	총 게시글은 [${qnaListSize }]개 입니다.
	<form id="writeForm" name="writeForm">
		<table class="table table-hover" style="width: 1000px;" align="center"
			id="articleTable">
			<thead>
				<tr id="article_tr">
					<td style="width: 79px;">번호</td>
					<td>아이디</td>
					<td>제목</td>
					<td>내용</td>
					<td>작성일</td>
					<td style="width: 87px; text-align: center;">조회수</td>
				</tr>
			</thead>
	
	
<tbody>
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
						<td>${fbList.fb_seq}</td>
						<td>${fbList.fb_id}</td>
						<td><a href="<%=request.getContextPath() %>/fb/fbDetail?fb_seq=${fbList.fb_seq}&tpage=${tpage}">${fbList.fb_subject}</a></td>
						<td>${fbList.fb_content}</td>
						<td><fmt:formatDate value="${fbList.fb_date}" pattern="yyyy-mm-dd"/></td>
						<td>${fbList.fb_cnt}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" style="text-align: center;">${paging}</td>
				</tr>
				
			</c:otherwise>
		</c:choose>
			</tbody>
		</table>
		</form>
	</div>
	
	


<div style="text-align: center;">
	<sec:authorize access="isAuthenticated()">
		<button type="button" onclick="fbWrite_go() ">글쓰기</button>
		<!-- <button type="button" onclick="fbList_go() ">목록보기</button> -->
	</sec:authorize> 
	</div>





