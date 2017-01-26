<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<article>
	<br> <br>
	<div id="contract">
		<h2>공지사항 상세보기</h2>
		<h4> ARTICLE WRITE</h4>
	</div>
	<form id="formm" name="formm" method="post">
	아이디:<input type="text" name="noar_id" value="${articleVO.noar_id}"><br>
	제목:<input type="text" name="noar_subject" value="${articleVO.noar_subject}"><br>
	내용:<textarea rows="5" cols="30" name="noar_content" >${articleVO.noar_content}</textarea><br>
	 <input type="hidden" name="noar_seq" value="${articleVO.noar_seq}"> 
	 
	 <%-- 					 <sec:authorize access="hasRole('ROLE_SUPER')">
							<li><a href="#">관리</a></li>
						</sec:authorize>
						
					3	hasRole()         ==        1개
						hasAnyRole        ==        2개
						isAuthenticated() ==        모두
 --%>
	
	 <button type="button" id="btnContactUs" onclick="history.go(-1);">확인</button>
	
	<sec:authorize access="hasRole('ROLE_SUPER')">
      <button type="button" id="btnContactUs" onclick="go_articleWrite()">수정하기</button>
	<button type="button" id="btnContactUs" onclick="go_articleDelete()">삭제하기</button>

       </sec:authorize>

		</form>
	
</article>

<script>
function go_articleWrite(){
	document.formm.action = "<%=request.getContextPath()%>/article/articleUpdate";
    document.formm.submit();
}
function go_articleDelete(){
	document.formm.action = "<%=request.getContextPath()%>/article/articleDelete";
    document.formm.submit();
    
    
}
</script>
