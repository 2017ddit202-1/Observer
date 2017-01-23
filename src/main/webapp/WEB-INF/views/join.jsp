<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<article>
	<br> <br>
	<div id="contract">
		<h2>회원가입</h2>
		<h4>Join Us</h4>
	</div>
	
	<form id="formm" name="formm" method="post"><br/>
	ID: <input type="text" name="mem_id"><input type="button" value="중복 체크" onclick="idcheck()"><br/>
	PW1: <input type="password" name="mem_pwd"><br/>
	PW2: <input type="password" name="mem_pwd2"><br/>
	NAME: <input type="text" name="mem_nm"><br/>
	E-MAIL: <input type="text" name="mem_email"><br/>
	PHONE: <input type="text" name="mem_phone"><br/>
	
	<input type="checkbox" name="check" value="동의">이용약관에 동의합니다.(필수)<a href="#">[ 이용약관보기 ]</a><br>
	<input type="checkbox" name="check" value="비동의">개인정보 보호정책에 동의합니다.(필수)<a href="#">[ 개인정보 보호정책 보기 ]</a><br>
	
	<button type="submit" id="btnContactUs" onclick="go_save()">계정생성</button>
	<button type="submit" id="btnContactUs" onclick="history.go(-1);">취소</button>
	
	
	
	</form>


</article>



<script>
function go_save(){
	document.formm.action = "join";
    document.formm.submit();
}

function idcheck(){
	if(document.formm.mem_id.value==""){
		alert('아이디를 입력하여 주십시오.');
		document.formm.mem_id.focus();
		return;
	}
	var url = "idCheckForm?mem_id=" + document.formm.mem_id.value;
	window.open(url, "_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=200");
	
}
</script>








