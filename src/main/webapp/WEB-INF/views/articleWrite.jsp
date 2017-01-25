<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<article>
	<br> <br>
	<div id="contract">
		<h2>공지사항 글쓰기</h2>
		<h4> ARTICLE WRITE</h4>
	</div>
	<form id="formm" name="formm" method="post">
	아이디:<input type="text" name="noar_id"><br>
	제목:<input type="text" name="noar_subject"><br>
	내용:<textarea rows="5" cols="30" name="noar_content"></textarea><br>
	

	<button type="button" id="btnContactUs" onclick="go_articleWrite()">글쓰기</button>
	<button type="button" id="btnContactUs" onclick="history.go(-1);">취소</button>
	</form>
	
</article>

<script>
function go_articleWrite(){
	document.formm.action = "<%=request.getContextPath()%>/article/articleWrite";
    document.formm.submit();
}
</script>

