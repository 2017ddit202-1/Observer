<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>


<body>
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
    height: 870px;
}

#article_tr td {
	background-color: #e4eaf2;
	border-top: 1px solid #c3ced9;
	border-bottom: 1px solid #ffffff;
	height: 50px;
	padding-top: 1.5%;
	text-align: center;
}



</style> 

<br>
<div id="page-wrapper3">
<br>

  <ul class="nav nav-tabs" style="margin-top: 3%;">
    <li class="active"><a href="#">NOTICE</a></li>
   
  </ul>
  <br>
 
 <div class="media">
    <div class="media-left">
   <img src="<%=request.getContextPath()%>/resources/img/promotion.png" class="media-object" style="width:60px;margin-left: 39%;">
    </div>
    <div class="media-body">
      <h4 class="media-heading" style="margin-left: 3%; margin-top: 1%;"><strong>알림내역</strong></h4>
      <p style="margin-left: 3%;">SERVER의 CPU, 메모리의 과다사용 내역을 실시간으로 안내해주는 서비스.</p>
    </div>
  </div>
  <hr>
<br>


<table class="table table-hover" style="width: 100%;" align="center"
			id="articleTable">
			<thead>
			
		<tr id="article_tr">
			<td style="width: 79px;">번호</td>
			<td>호스트명</td>
			<td>I P</td>
			<td>위험도</td>
			<td>위험 내용</td>
			<td>발생시간</td>
		</tr>
				
			</thead>
			
			
			
			
			
			
			
			<tbody>
			<c:forEach var="noticeList" items="${noticeList}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${noticeList.notice_server_nm}</td>
			<td>${noticeList.notice_ip}</td>
			<td>${noticeList.notice_dng_lv}</td>
			<td>${noticeList.notice_content}</td>
			<td>${noticeList.notice_date}</td>
			
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6" style="text-align: center;">${paging}</td>
		</tr>
	
			</tbody>
			</table>
			
			
			
			
			
			
			
			
			
			
			
			<!-- ///////////////////////////////////////////// -->
			
			
			



	<%-- <table border="1">
		<tr>
			<th>번호</th>
			<th>호스트명</th>
			<th>I P</th>
			<th>위험도</th>
			<th>위험 내용</th>
			<th>발생시간</th>
		</tr>
		<c:forEach var="noticeList" items="${noticeList}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${noticeList.notice_server_nm}</td>
			<td>${noticeList.notice_ip}</td>
			<td>${noticeList.notice_dng_lv}</td>
			<td>${noticeList.notice_content}</td>
			<td>${noticeList.notice_date}</td>
			
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6" style="text-align: center;">${paging}</td>
		</tr>
	</table> --%>
	</div>
</body>
</html>
