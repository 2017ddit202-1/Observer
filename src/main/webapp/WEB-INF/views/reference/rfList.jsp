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
#articleTable tr:hover{
background-color: #337ab5;
}
#paging:hover{
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
   height: 860px;
}
</style>

<br><br>
<div id="page-wrapper3" class="in">

<div class="container">
  <ul class="nav nav-tabs" style="margin-top: 3%;">
    <li class="active" style="color: #7a7a7a;"><a href="#" style="background-color: #f7f7f7;
    margin-left: 9%; text-align: center; width: 100%;">REFERENCE</a></li>
   
  </ul>
  <br>
   <div class="media">
    <div class="media-left">
   <img src="<%=request.getContextPath()%>/resources/img/attach.png" class="media-object" style="width:60px;margin-left: 39%;">
    </div>
    <div class="media-body">
      <h4 class="media-heading" style="margin-left: 3%; margin-top: 1%;"><strong>자료실</strong></h4>
      <p style="margin-left: 3%;">
			OBSERVER의 다양한 자료와 정보를 제공해드립니다.</p>
    </div>
  </div>
  <hr>
</div>
<br><br>



	<br>
	<br>
	
	
	<div class="container">
	<i class="fa fa-file-text-o" aria-hidden="true"></i>
	총 게시글은 [${qnaListSize }]개 입니다.
		<table class="table table-hover" style="width: 1000px;" align="center"
			id="articleTable">
			<thead>
				<tr id="article_tr">
					<td style="width: 79px;">번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>파일이름</td>
					<td>파일크기</td>
					<td style="width: 150px; text-align: center;">등록날짜</td>
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
						<c:forEach items="${referenceList}" var="referenceVO">
							<tr>
							   <td>${referenceVO.reli_seq}</td>
                               <td><a href="referenceDetail?reli_seq=${referenceVO.reli_seq}"> ${referenceVO.reli_subject} </a></td>
                               <td>${referenceVO.reli_content}</td>
                               <td>${referenceVO.reli_file_nm}</td>
                               <td>${referenceVO.reli_size}</td>
                               <td><fmt:formatDate value="${referenceVO.reli_date}"
										pattern="yyyy-MM-dd" /></td>
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
      <button type="button" class="btn btn-default" onclick="location.href='<%=request.getContextPath()%>/rf/referenceWrite' ">글쓰기</button>
   </sec:authorize>
   </div>
	</div>
	
	
	<!-- ////////////////////////////////////// -->





