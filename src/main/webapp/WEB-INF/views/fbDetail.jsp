<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<article>
	<br> <br>
	<div id="contract">
		<h2>자유게시판 상세보기</h2>
		<h4> FreeBoard WRITE</h4>
	</div>
	<form id="formm" name="formm" method="post">
	아이디:<input type="text" name="fb_id" value="${fbVO.fb_id}"><br>
	제목:<input type="text" name="fb_subject" value="${fbVO.fb_subject}"><br>
	내용:<textarea rows="5" cols="30" name="fb_content" >${fbVO.fb_content}</textarea><br>
	 <input type="hidden" name="fb_seq" value="${fbVO.fb_seq}"> 
	 
	 
	 <button type="button" id="btnContactUs" onclick="history.go(-1);">뒤로가기</button>
	
      <button type="button" id="btnContactUs" onclick="go_fbWrite()">수정하기</button>
	<button type="button" id="btnContactUs" onclick="go_fbDelete()">삭제하기</button>


		</form>
	
</article>

<script>
function go_fbWrite(){
	document.formm.action = "<%=request.getContextPath()%>/fb/fbUpdate";
    document.formm.submit();
}
function go_fbDelete(){
	document.formm.action = "<%=request.getContextPath()%>/fb/fbDelete";
    document.formm.submit();
    
    
}
</script>
