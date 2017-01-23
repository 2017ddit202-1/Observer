<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article>
	<br> <br>
	<div id="contract">
		<h2>회원가입</h2>
		<h4>Join Us</h4>
	</div>
	
	<form action="" method="post"><br/>
	ID: <input type="text" name="id"><input type="button" value="중복 체크" onclick="idcheck()"><br/>
	PW1: <input type="password" name="pw"><br/>
	PW2: <input type="password" name="pw2"><br/>
	NAME: <input type="text" name="name"><br/>
	E-MAIL: <input type="text" name="email"><br/>
	PHONE: <input type="text" name="phone"><br/>
	
	<button type="submit" id="btnContactUs" onclick="go_save()">계정생성</button>
	<button type="submit" id="btnContactUs" onclick="history.go(-1);">취소</button>
	
	</form>


</article>

<!-- 아이디  /아이디중복확인
패스워드
패스워드 확인
이름
이메일
전화번호

이용약관 동의
개인정보정책에동의

계정생성하기 -->