<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>update page</h1>

	<form name="formm" method="post">

		<table id="notice">

			<tr>
				<th>제목</th>
				<td><input type=text name= "qna_subject" value="${qnaVO.qna_subject}"></td>
				
				
			</tr>
			<tr>
				<th>작성자 : </th>
				<td>${qnaVO.qna_id }</td>
				
				<th>등록일 : </th>
				<td><fmt:formatDate  value="${qnaVO.qna_date}" type="date" /></td>
			</tr>
			<tr>
				<td>질문내용</td>
				<td><textarea rows="10" cols="100" name="qna_content"
						placeholder="Enter answer">${qnaVO.qna_content}</textarea></td>
			</tr>
			<tr>
				<th>답변 내용</th>
				
			</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="수정" class="submit"
				onclick="modify_go()">
			<input	type="button" value="취소" class="cancel"
				onclick="location.href='/main/index.do'">
		</div>
	</form>
 
<script>
	function modify_go(){
		document.formm.method = "POST";
		document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaModify?qna_seq="+"${qnaVO.qseq}";
		document.formm.submit();
	}


</script>


</body>
</html>