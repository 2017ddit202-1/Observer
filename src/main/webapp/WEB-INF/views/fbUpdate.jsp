<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<article>
	<br> <br>
	<div id="contract">
		<h2>자유게시판 수정하기</h2>
		<h4> FreeBoard WRITE</h4>
	</div>
	<form id="formm" name="formm" method="post">
	아이디:<input type="text" name="fb_id" value="${fb.fb_id}"><br>
	제목:<input type="text" name="fb_subject" value="${fb.fb_subject}"><br>
	내용:<textarea rows="5" cols="30" name="fb_content" >${fb.fb_content}</textarea><br>
	 <input type="hidden" name="noar_seq" value="${fb.fb_seq}"> 

<!-- 	<button type="button" id="btnContactUs" onclick="go_articleWrite()">확인</button> -->
<!-- 	<button type="button" id="btnContactUs" onclick="hidtory.go(-1)">취소하기</button> -->
	</form>
	
</article>


<%-- <script>
function go_articleWrite(){
	document.formm.action = "<%=request.getContextPath()%>/article/articleWrite";
    document.formm.submit();
}
</script>
 --%>