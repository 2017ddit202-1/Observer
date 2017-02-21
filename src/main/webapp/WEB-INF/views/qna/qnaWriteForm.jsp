<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/qna.css"
	rel="stylesheet">

<script>
	function write_go(){
		document.formm.action = "<%=request.getContextPath()%>/qna/qnaWrite";
		document.formm.submit();
	}

	
	function list_go(){
		document.formm.action = "<%=request.getContextPath()%>/qna/qnaList";
		document.formm.submit();
	}
</script>


</head>
<body>


	<br>
	<br>
	<div style="text-align: center;">
		<h2>QnA 글쓰기</h2>
		<h4>ARTICLE WRITE</h4>
	</div>
	<br>
	<br>
	<br>


	<form id="formm" name="formm" method="post">
		<table style="width: 1000px;" align="center">
			<tr id="article_write_tr">
				<td style="background-color: #e4eaf2; width: 80px;">제목</td>
				<td><input type="text" name="subject"
					style="width: 528px; border: none; outline: none;"></td>
				<td style="background-color: #e4eaf2; width: 80px;">아이디</td>
				<td><input type="text" name="id"
					style="width: 300px; border: none; outline: none; text-align: center;"
					value="${loginUser}"></td>
			</tr>
			<tr id="article_write_tr">
				<td style="background-color: #e4eaf2; width: 80px;">내용</td>
				<td><textarea name="content"
						style="border: 0; overflow-y: hidden; background: clear; resize: none; width: 528px; height: 400px; outline: none;"></textarea>
				</td>
				<td></td>
				<td></td>
			</tr>

		</table>
		<div style="text-align: center;">
			<hr style="border: solid 1px #c3ced9; width: 1000px;">
			<input type="submit" value="글 등록" onclick="write_go()"> <input
				type="reset" value="취소" onclick="list_go()">
		</div>

	</form>

</body>
</html>