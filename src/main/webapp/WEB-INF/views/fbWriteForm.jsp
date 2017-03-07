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

<style>
#article_write_tr{
height: 50px;
border-top: 1px solid #c3ced9;
border-bottom: 1px solid #c3ced9;
text-align: center;
}

#page-wrapper3 {
    position: inherit;
    margin: 0 0 0 250px;
    padding: 65px 30px;
     box-shadow: 5px 5px 5px lightgray;
     border-radius: 10px; 
   
} 
#page-wrapper3 {
    padding: 0 15px;
    min-height: 568px;
    background-color: white;
    margin-left: 10%;
    width: 79%;
   height: 860px;
}
</style>

</head>
<body>
<br><br>
	
	
	<div id="page-wrapper3" class="in">


<br> <br>
	<div style="text-align: center;">
		<h2>자유게시판 작성하기</h2>
	</div>
	<br><br><br>




<form id="formm" name="formm" method="post" action="qnaWrite">
<table style="width: 1000px;" align="center">
<tr id="article_write_tr">
<td style="background-color: #e4eaf2; width: 80px;">제목</td>
<td><input type="text" name="subject" style="width: 528px; border: none; outline: none;"></td>
<td style="background-color: #e4eaf2; width: 80px;">작성자</td>
<td><input type="text" name="noar_id" style="width: 300px; border: none; outline: none; text-align:center;" value="${loginUser}"></td>
</tr>
<tr id="article_write_tr">
<td style="background-color: #e4eaf2; width: 80px;">내용</td>
<td>
<textarea name="content" style="border:0; overflow-y:hidden; background:clear; resize: none; width:528px; height: 400px; outline: none;"></textarea>
</td>
<td></td>
<td></td>
</tr>

</table>

<div style="text-align: center;">
<hr style="border: solid 1px #c3ced9; width: 1000px;">
 <input type="button"  value="작성"  onclick="write_go()" class="btn btn-default"> 
 <button type="button" id="btnContactUs" onclick="history.go(-1);" class="btn btn-default">취소</button>
</div>	

</form>
</div>

<%-- <h1>자유게시판 작성하기</h1>
<form name="formm" method="post" 
		action="qnaWrite">
			<fieldset>	
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
		</form> --%>

</body>
</html>