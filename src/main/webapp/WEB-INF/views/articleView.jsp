<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html lang="en">

<head>

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

#articleTable tr:hover {
	background-color: #d5dae2;
}

#paging:hover {
	background-color: white;
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

	
	<br>
	<br>
	

<div id="page-wrapper3" class="in">	

<div class="container">
  <ul class="nav nav-tabs" style="margin-top: 3%;">
    <li class="active" style="color: #7a7a7a;"><a href="#" style="background-color: #f7f7f7;
    margin-left: 9%; text-align: center; width: 100%;">NOTICE</a></li>
   
  </ul>
  <br>
 
 <div class="media">
    <div class="media-left">
   <img src="<%=request.getContextPath()%>/resources/img/promotion.png" class="media-object" style="width:60px;margin-left: 39%;">
    </div>
    <div class="media-body">
      <h4 class="media-heading" style="margin-left: 3%; margin-top: 1%;"><strong>공지사항</strong></h4>
      <p style="margin-left: 3%;">각종 안내, 서비스 또는
			OBSERVER의 소식 버전안내 등의 정보를 확인할 수 있습니다.</p>
    </div>
  </div>
  <hr>
</div>

<br><br>



	<!-- 서치 -->
	<div style="width: 1000px; float: right; text-align: center;">
		<form action="<%=request.getContextPath()%>/article/articleSearch"
			name="search" method="post" style="margin-left: 21%;">

			<!-- //size="1"->1개만선택가능 -->
			<select name="keyField" size="1" style="height: 22px; margin-top: 2px;">
				<option value="noar_seq">게시글번호</option>
				<option value="noar_subject">제목</option>
				<option value="noar_content">내용</option>
			</select> <input type="text" size="16" name="keyWord" id="keyWord"
				style="height: 24px;">

			<!-- <button class="button button2" onClick="check()">검색</button> -->
			
			<button class="btn btn-primary btn-sm" type="button" id="DeleteBtn" onclick="check()"
												style="border-color: #87adab; width: 64px;">검색</button>
			
			
			<!-- <input type="button" class="btn btn-default" value="Search" onclick="check()"> -->
			
			<input type="hidden" name="page" value="0">
		</form>
	</div>
	<br>
	<br>
	<br>

	<!-- /서치 -->



	<div class="container">
		<i class="fa fa-bullhorn" aria-hidden="true"></i>&nbsp;총 게시글은[${qnaListSize}]개 입니다.
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
									<c:choose>
           <c:when test="${fn:length(articleVO.noar_subject) > 25}">
            <td><a href="detailArticle?noar_seq=${articleVO.noar_seq}"> <c:out value="${fn:substring(articleVO.noar_subject,0,25)}"/>....</a>
            <c:if test="${articleVO.noar_icon eq 1}">
										<img src="<%=request.getContextPath()%>/resources/img/new_icon.gif">
									</c:if>
  
            </td>
           
           </c:when>
           <c:otherwise>
           <td> <a href="detailArticle?noar_seq=${articleVO.noar_seq}"><c:out value="${articleVO.noar_subject}"/></a>
           <c:if test="${articleVO.noar_icon eq 1}">
										<img
											src="<%=request.getContextPath()%>/resources/img/new_icon.gif">
									</c:if>
           
           </td>
           </c:otherwise> 
          </c:choose>
          
          
          
          
								<c:choose>
           <c:when test="${fn:length(articleVO.noar_content) > 14}">
            <td> <c:out value="${fn:substring(articleVO.noar_content,0,13)}"/>....</td>
           
           </c:when>
           <c:otherwise>
           <td> <c:out value="${articleVO.noar_content}"/></td>
           </c:otherwise> 
          </c:choose>

								<td><fmt:formatDate value="${articleVO.noar_date}"
										pattern="yyyy-MM-dd" /></td>
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
								<td>${articleVO.noar_seq}</td>
								<td>${loginUser}</td>
								
						<c:choose>
           <c:when test="${fn:length(articleVO.noar_subject) > 25}">
            <td><a href="detailArticle?noar_seq=${articleVO.noar_seq}"> <c:out value="${fn:substring(articleVO.noar_subject,0,25)}"/>....</a>
            <c:if test="${articleVO.noar_icon eq 1}">
										<img src="<%=request.getContextPath()%>/resources/img/new_icon.gif">
									</c:if>
            
            </td>
           
           </c:when>
           <c:otherwise>
           <td> <a href="detailArticle?noar_seq=${articleVO.noar_seq}"><c:out value="${articleVO.noar_subject}"/></a>
           <c:if test="${articleVO.noar_icon eq 1}">
										<img
											src="<%=request.getContextPath()%>/resources/img/new_icon.gif">
									</c:if>
           
           </td>
           </c:otherwise> 
          </c:choose>
								
								
								
							 <%-- <th><a href="detailArticle?noar_seq=${articleVO.noar_seq}">${articleVO.noar_subject}</a> 
									<c:if test="${articleVO.noar_icon eq 1}">
										<img
											src="<%=request.getContextPath()%>/resources/img/new_icon.gif">
									</c:if></th> --%>
									
									
									<c:choose>
           <c:when test="${fn:length(articleVO.noar_content) > 14}">
            <td> <c:out value="${fn:substring(articleVO.noar_content,0,13)}"/>....</td>
           
           </c:when>
           <c:otherwise>
           <td> <c:out value="${articleVO.noar_content}"/></td>
           </c:otherwise> 
          </c:choose>


		
									
								<%-- <th>${articleVO.noar_content}</th> --%>
								<td><fmt:formatDate value="${articleVO.noar_date}"
										pattern="yyyy-MM-dd" /></td>
								<td>${articleVO.noar_cnt }</td>
							</tr>
						</c:forEach>
						<tr>
							<td id="paging" colspan="6" style="text-align: center;">${paging}</td>
						</tr>
					</c:otherwise>


				</c:choose>
			</tbody>
		</table>
	</div>

	<div style="text-align: center;">
		<sec:authorize access="hasRole('ROLE_SUPER')">
			<button type="button" class="btn btn-default" onclick="location.href='articleWrite' ">글쓰기</button>
		</sec:authorize>
	</div>
	</div>
	
</body>