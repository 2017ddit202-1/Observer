<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<style>
#detail_table_tr{
height: 50px;
border-top: 1px solid #c3ced9;
border-bottom: 1px solid #c3ced9;
text-align: center;
}
</style>

<script>
function go_articleWrite(){
	document.formm.action = "<%=request.getContextPath()%>/article/articleUpdate";
    document.formm.submit();
}
function go_articleDelete(){
	document.formm.action = "<%=request.getContextPath()%>/article/articleDelete";
    document.formm.submit();

}
function articleList_go(){
	
	document.formm.action = "<%=request.getContextPath()%>/article/articleView";
    document.formm.submit();
}
</script>

	<br> <br>
	<div style="text-align: center;">
		<h2>공지사항 상세보기</h2>
		<h4> ARTICLE WRITE</h4>
		각종 안내, 서비스 또는 OBSERVER의 소식 버전안내 등의 정보를 확인할 수 있습니다.
	</div>
	<br><br><br>
	
<form id="formm" name="formm" method="post">
<table style="width: 1000px;" align="center">

<tr id="detail_table_tr">
<td style="background-color: #e4eaf2; width: 90px; border-top: 1px solid #c3ced9;">제목</td>
<td><input type="text" name="noar_subject" value="${articleVO.noar_subject}" style="border: none; outline: none; width: 500px; text-align:center;"></td>
<td></td>
<td></td>
</tr>

<tr id="detail_table_tr">
<td style="background-color: #e4eaf2; border-top: 1px solid #c3ced9;">등록일</td>

<td><fmt:formatDate value="${articleVO.noar_date}" pattern="yyyy-MM-dd" /></td>


<td style="background-color: #e4eaf2; width: 90px; border-top: 1px solid #c3ced9;">번호</td>
<td style="border-top: 1px solid #c3ced9;"><input type="text" name="noar_seq" value="${articleVO.noar_seq}" style="border: none; outline: none; width: 60px; text-align:center; "></td>
</tr>


</table>
<div style="text-align: center;">
<textarea name="noar_content" style="border:0; overflow-y:hidden; background:clear; resize: none; width: 1000px; height: 400px; outline: none;">${articleVO.noar_content}</textarea>
<hr style="border: solid 1px #c3ced9; width: 1000px;">
</div>	
	
<%-- 	<form id="formm" name="formm" method="post">
	아이디:<input type="text" name="noar_id" value="${articleVO.noar_id}"><br>
	제목:<input type="text" name="noar_subject" value="${articleVO.noar_subject}"><br>
	내용:<textarea rows="5" cols="30" name="noar_content" >${articleVO.noar_content}</textarea><br>
	 <input type="hidden" name="noar_seq" value="${articleVO.noar_seq}"> 
	 
	 					 <sec:authorize access="hasRole('ROLE_SUPER')">
							<li><a href="#">관리</a></li>
						</sec:authorize>
						
					3	hasRole()         ==        1개
						hasAnyRole        ==        2개
						isAuthenticated() ==        모두
 --%>
 
 
 <div style="text-align: center;">
	
	 <button type="button" id="btnContactUs" onclick="articleList_go();">목록</button>
	
	<sec:authorize access="hasRole('ROLE_SUPER')">
      <button type="button" id="btnContactUs" onclick="go_articleWrite()">수정하기</button>
	  <button type="button" id="btnContactUs" onclick="go_articleDelete()">삭제하기</button>

    </sec:authorize>
       </div>

		</form> 
	



