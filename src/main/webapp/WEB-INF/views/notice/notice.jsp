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
	<h1>알림내역</h1>
	<table border="1">
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
	</table>
</body>
</html>
