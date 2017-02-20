<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<html lang="en">

<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




<style type="text/css">
#article_tr td {
	background-color: #e4eaf2;
	border-top: 1px solid #c3ced9;
	border-bottom: 1px solid #ffffff;
	height: 50px;
	padding-top:1.5%;
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

.button2 {background-color: #337ab5;} /* Blue */





</style>

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
</script>



</head>

<body>

	<div style="background-color: #337ab5; width: 100%; height: 50px; padding: 0; "></div><br>
<div style="font-size: 30px; width: 800px; text-align: center;">
<img src="<%=request.getContextPath()%>/resources/img/arrow.png">공지사항
</div>

	<br>
	<br>


	<!-- 서치 -->
	<div style="width: 1000px; float: right; text-align: center;">
	<form action="<%=request.getContextPath()%>/article/articleSearch"
		name="search" method="post">

		<!-- //size="1"->1개만선택가능 -->
		<select name="keyField" size="1" style="height: 22px;">
			<option value="noar_seq">게시글번호</option>
			<option value="noar_subject">제목</option>
			<option value="noar_content">내용</option>
		</select> <input type="text" size="16" name="keyWord" id="keyWord" style="height: 24px;"> 
		<!-- <input type="button" value="검색" onClick="check()" class="">  -->
		
		<button class="button button2" onClick="check()">검색</button>
		<input type="hidden" name="page" value="0">
	</form>
	</div>
	<br><br><br><br>

	<!-- /서치 -->



	<div class="container">
		<table class="table table-hover" style="width: 1000px;" align="center"
			id="articleTable">
			<thead>
				<tr id="article_tr">
					<td style="width: 79px;">번호</td>
					<td>아이디</td>
					<td>제목</td>
					<td>내용</td>
					<td>등록날짜</td>
					<td style="width: 87px; text-align: center;">조회수</td>
				</tr>
			</thead>



			<tbody>
				<c:choose>
					<c:when test="${!empty articleSearch }">
						<c:forEach items="${articleSearch}" var="articleVO">
							<tr id="article_tr2" style="text-align: center">
								<td>${articleVO.noar_seq}</td>
								<td>${loginUser}</td>
								<td><a href="detailArticle?noar_seq=${articleVO.noar_seq}">${articleVO.noar_subject}</a></td>
								<td>${articleVO.noar_content}</td>
								<td>${articleVO.noar_date}</td>
								<td>${articleVO.noar_cnt }</td>
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
								<td><fmt:formatDate value="${articleVO.noar_date}"
										pattern="yyyy-MM-dd" /></td>
								<th>${articleVO.noar_cnt }</th>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6" style="text-align: center;">${paging}</td>
						</tr>
					</c:otherwise>


				</c:choose>
			</tbody>
			</table>
	</div>

</body>




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