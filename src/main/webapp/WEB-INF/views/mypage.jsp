<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <article>
	<br> <br>
	<div id="contract">
		<h2>마이페이지</h2>
		<h4>My Page</h4>
	</div>
	<table>
	<tr><a href="<%=request.getContextPath()%>/user/update">회원수정</a></tr><br>
	<tr><a href="#">권한신청</a></tr><br>
	<tr><a href="<%=request.getContextPath()%>/user/deletee">회원탈퇴</a></tr><br>
	</table>
	
	
	
	
	</article>