<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>


<style>
#article_write_tr{
height: 50px;
border-top: 1px solid #c3ced9;
border-bottom: 1px solid #c3ced9;
text-align: center;
}
</style>
<script>
function go_adminWrite() {
	document.formm.action="<%=request.getContextPath()%>/admin/adminWrite";
	document.formm.submit();
	
}
</script>


</head>
<body>
	<br> <br>
	<div style="text-align: center;">
		<h2>ADMIN 글쓰기</h2>
	</div>
	<br><br><br>
	
	<form id="formm" name="formm" method="post">
	<table style="width: 1000px; " align="center">
	<tr id="article_write_tr">
	<td style="background-color: #e4eaf2; width: 80px;">제목</td>
	<td><input type="text" name="ad_subject" style="width: 300px; border: none; outline: none;"></td>
	<td style="background-color: #e4eaf2; width: 80px;">작성자</td>
	<td><input type="text" name="ad_id" value="${loginUser }" style="width: 300px; border: none; outline: none;"></td>
	</tr>
	
<tr id="article_write_tr">
<td style="background-color: #e4eaf2; width: 80px;">내용</td>
<td>
<textarea name="ad_content" style="border:0; overflow-y:hidden; background:clear; resize: none; width:300px; height: 400px; outline: none;"></textarea>
</td>
<td></td>
<td></td>
</tr>
</table>

<div style="text-align: center;">
<hr style="border: solid 1px #c3ced9; width: 1000px;">
<button type="button" id="btnContactUs" onclick="go_adminWrite()">글쓰기</button>
<button type="button" id="btnContactUs" onclick="history.go(-1);">취소</button>

</div>	

</form>
	
</body>
</html>