<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script>
	function write_go(){
		document.formm.action = "<%=request.getContextPath()%>/fb/fbWrite";
		document.formm.submit();
	}

</script>


</head>
<body>
<br><br><br><br><br><br><br><br>

<h1>자유게시판 작성하기</h1>
<form name="formm" method="post" 
		action="qnaWrite">
			<fieldset>	
				<legend>Q&A</legend>
				작성자 : ${loginUser}<br /><br />		
			    <label>제목</label>
			    <input type="text" name="subject"  size="64" ><br>
			    
				<label>질문내용</label>
			    <textarea rows="8" cols="65" name="content"></textarea><br>
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="button"  value="작성"  onclick="write_go()"> 
			<input type="reset"   value="취소"     class="cancel">
		  </div>
		</form>

</body>
</html>