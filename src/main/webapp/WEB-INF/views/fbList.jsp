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

#page-wrapper3 {
    position: inherit;
    margin: 0 0 0 250px;
    padding: 65px 30px;
     box-shadow: 5px 5px 5px lightgray;
     border-radius: 10px; 
   
} 
#page-wrapper3 {
    padding: 0 15px;
    min-height: 568px;
    background-color: white;
    margin-left: 10%;
    width: 79%;
    height: 870px;
}
#DeleteBtn:hover {
	background-color: #789c99;
	border-color: #789c99;
}

#DeleteBtn {
	background-color: #87adab
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
	
	
	<br><br>
	<div id="page-wrapper3" class="in">	
	
	<div class="container">
  <ul class="nav nav-tabs" style="margin-top: 3%;">
    <li class="active" style="color: #7a7a7a;"><a href="#" style="background-color: #f7f7f7;
    margin-left: 9%; text-align: center; width: 100%;">FREE BOARD</a></li>
   
  </ul>
  <br>
 
 <div class="media">
    <div class="media-left">
   <img src="<%=request.getContextPath()%>/resources/img/search.png" class="media-object" style="width:60px;margin-left: 39%;">
    </div>
    <div class="media-body">
      <h4 class="media-heading" style="margin-left: 3%; margin-top: 1%;"><strong>자유게시판</strong></h4>
      <p style="margin-left: 3%;">자유롭게 의견을 게시하고, 참여자 상호간에 의견을 공유할 수 있는 공간입니다.</p>
    </div>
  </div>
  <hr>
</div>

<br><br>
	

	
	
		<!-- 서치 -->
	<div style="width: 1000px; float: right; text-align: center;">
		<form name="search" method="post" style="margin-left: 24%;">

			<select name="keyField" size="1" style="height: 22px; margin-top: 2px;" id="keyField">
				<option value="fb_sub">제목</option>
			    <option value="fb_con">내용</option>
			    <option value="fb_id">작성자</option>
			</select> <input type="text" size="16" name="keyWord" id="keyWord"
				style="height: 24px;">

			<!-- <button id="searchBtn" class="button button2" onClick="search_go()">검색</button> -->
			
			
			<button class="btn btn-primary btn-sm" type="button" id="DeleteBtn" onClick="search_go()"
												style="border-color: #87adab; width: 64px;">검색</button>
			
			
			<input type="hidden" name="page" value="0">
		</form>
	</div>
	<br>
	<br>
	<br>

	<!-- /서치 -->
	
	

	
	<div class="container">
	<i class="fa fa-comments-o" aria-hidden="true"></i>
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
		<button type="button" class="btn btn-default" onclick="fbWrite_go() ">글쓰기</button>
		<!-- <button type="button" onclick="fbList_go() ">목록보기</button> -->
	</sec:authorize> 
	</div>

</div>



