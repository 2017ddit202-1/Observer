<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
#article_write_tr{
height: 50px;
border-top: 1px solid #c3ced9;
border-bottom: 1px solid #c3ced9;
text-align: center;
}
</style>

	<br> <br>
	
	<div style="height: 1000px;">
	
	<div style="text-align: center;">
		<h2>공지사항 글쓰기</h2>
		<h4> ARTICLE WRITE</h4>
	</div>
	<br><br><br>
	
	
<form id="formm" name="formm" method="post">
<table style="width: 1000px;" align="center">
<tr id="article_write_tr">
<td style="background-color: #e4eaf2; width: 80px;">제목</td>
<td><input type="text" name="noar_subject" style="width: 528px; border: none; outline: none;"></td>
<td style="background-color: #e4eaf2; width: 80px;">아이디</td>
<td><input type="text" name="noar_id" style="width: 300px; border: none; outline: none; text-align:center;" value="${loginUser}"></td>
</tr>
<tr id="article_write_tr">
<td style="background-color: #e4eaf2; width: 80px;">내용</td>
<td>
<textarea name="noar_content" style="border:0; overflow-y:hidden; background:clear; resize: none; width:528px; height: 400px; outline: none;"></textarea>
</td>
<td></td>
<td></td>
</tr>

</table>

<div style="text-align: center;">
<hr style="border: solid 1px #c3ced9; width: 1000px;">
<button type="button" id="btnContactUs" class="btn btn-default" onclick="go_articleWrite()">글쓰기</button>
<button type="button" id="btnContactUs" class="btn btn-default" onclick="history.go(-1);">취소</button>

</div>	

</form>

</div>


<script>
function go_articleWrite(){
	document.formm.action = "<%=request.getContextPath()%>/article/articleWrite";
    document.formm.submit();
}
</script>

