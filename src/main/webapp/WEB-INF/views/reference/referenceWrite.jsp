<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#article_write_tr{
height: 50px;
border-top: 1px solid #c3ced9;
border-bottom: 1px solid #c3ced9;
text-align: center;
}
</style>



</head>

<script>


</script>

<body>


	<br> <br>
	<div style="text-align: center;">
		<h2>자료실 글쓰기</h2>
	</div>
	<br><br><br>
	
	
	
	
	<form id="formm" name="formm" method="post" action="<%=request.getContextPath()%>/rf/referenceFileUpload"
      enctype="multipart/form-data">
<table style="width: 1000px;" align="center">
<tr id="article_write_tr">
<td style="background-color: #e4eaf2; width: 80px;">제목</td>
<td><input type="text" name="reli_subject" style="width: 528px; border: none; outline: none;"></td>
<td style="background-color: #e4eaf2; width: 80px;">아이디</td>
<td><input type="text" name="mem_id" style="width: 300px; border: none; outline: none; text-align:center;" value="${loginUser}"></td>
</tr>

<tr id="article_write_tr">
<td style="background-color: #e4eaf2; width: 80px;">내용</td>
<td>
<textarea name="reli_content" style="border:0; overflow-y:hidden; background:clear; resize: none; width:528px; height: 400px; outline: none;"></textarea>
</td>
<td></td>
<td></td>
</tr>

<tr id="article_write_tr">
<td style="background-color: #e4eaf2; width: 80px;">파일</td>
<td> <input type="file" name="uploadfile" required="required"></td>
<td></td>
<td></td>
</tr>


</table>

<div style="text-align: center;">
<hr style="border: solid 1px #c3ced9; width: 1000px;">
<button type="submit">글쓰기</button>
<button type="button" id="btnContactUs" onclick="history.go(-1);">취소</button>

</div>	

</form>
	


   <!-- //enctype 속성은 인코딩 타입(encoding type)을 지정한다. 
이 속성에 의해 브라우저는 입력된 데이터를 서버로 보낼 때 어떤 타입으로 인코딩해야 
하는지 알 수 있는데 인코딩 타입은 다음과 같이 세 가지 중 하나를 지정한다. -->

<%--    <form id="formm" name="formm" method="post" action="<%=request.getContextPath()%>/rf/referenceFileUpload"
      enctype="multipart/form-data">
    아이디:<input type="text" name="mem_id" required="required" value="${loginUser}"><br>
      제목:<input type="text" name="reli_subject" required="required" placeholder="제목"><br>
    내용:<textarea rows="20" cols="40" name="reli_content" required="required" placeholder="내용"></textarea><br>
      파일:<input type="file" name="uploadfile" required="required"><br>
            
   <button type="submit">글쓰기</button>
   <button type="button" id="btnContactUs" onclick="history.go(-1);">취소</button>
    </form> --%>
</body>
</html>



