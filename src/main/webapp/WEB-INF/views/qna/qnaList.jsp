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

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=request.getContextPath()%>/resources/css/qna.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
	<script>

	function serachQna_go(){
		document.formm.action = "<%=request.getContextPath()%>"+ "/qna/qnaList";
		document.formm.submit();
	}
</script>

<style>
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
   height: 860px;
}
</style>
</head>


<body>

<br><br>

<div id="page-wrapper3" class="in">

<div class="container">
  <ul class="nav nav-tabs" style="margin-top: 3%;">
    <li class="active" style="color: #7a7a7a;"><a href="#" style="background-color: #f7f7f7;
    margin-left: 9%; text-align: center; width: 100%;">QNA</a></li>
   
  </ul>
  <br>
 
 <div class="media">
    <div class="media-left">
   <img src="<%=request.getContextPath()%>/resources/img/analysis.png" class="media-object" style="width:60px;margin-left: 39%;">
    </div>
    <div class="media-body">
      <h4 class="media-heading" style="margin-left: 3%; margin-top: 1%;"><strong>QnA게시판</strong></h4>
      <p style="margin-left: 3%;">고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</p>
    </div>
  </div>
  <hr>
</div>

<br><br>


	
<!-- 	 <form name="formm" method="post">
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
	
	 -->
	
		<div style="width: 1000px; float: right; text-align: center;">
		<form name="formm" method="post">

			<select name="keyField" size="1" style="height: 22px;">
				 <option value="qna_seq">게시글번호</option>
      			 <option value="qna_seq">제목</option>
   				 <option value="qna_seq">내용</option>
                 <option value="qna_seq">작성자</option>
			</select> 
			<input type="text" size="16" name="key" style="height: 24px;">

			<!-- <button class="button button2" onClick="serachQna_go()">검색</button> -->
			
			<input type="button" class="btn btn-default" value="Search" onClick="serachQna_go()">
		</form>
	</div>
	<br>
	<br>
	<br>
	
	
	
	

	
	
	
	<div class="container">
		<i class="fa fa-question" aria-hidden="true"></i> 총 게시글은
		[${qnaListSize }]개 입니다.
		<table class="table table-hover" style="width: 1000px;" align="center"
			id="articleTable">
			<thead>
				<tr id="article_tr">
					<td style="width: 79px;">번호</td>
					<td>작성자</td>
					<td style="width: 353px;">제목</td>
					<td style="width: 137px;">등록날짜</td>
					<td style="width: 200px;">답변여부</td>
				</tr>
			</thead>

			<tbody>
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
									<c:when
										test="${loginUser eq qnaVO.qna_id || mempos.posl_pos eq 'ROLE_ADMIN'}">
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
			</tbody>
		</table>
	</div>
	<div style="text-align: center;">
		<button type="button" class="btn btn-default" onclick="location.href='<%=request.getContextPath()%>/qna/qnaWriteForm' ">글쓰기</button>
	</div>
	</div>

</body>
</html>

