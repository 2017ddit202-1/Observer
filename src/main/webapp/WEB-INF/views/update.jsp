<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<article>
	<br> <br>
	<div id="contract">
		<h2>회원정보 수정</h2>
		<h4>Member Info Edit</h4>
	</div>
	<form id="formm" name="formm" method="post">
	
	
	
	ID: <input type="text" name="mem_id" readonly="readonly" value="${loginUser.mem_id}"><br /> 
	PW1:<input type="text" name="mem_pwd" value="${loginUser.mem_pwd}"><br /> 
	NAME: <input type="text" name="mem_nm" value="${loginUser.mem_nm}"><br /> 
	E-MAIL: <input type="text" name="mem_email" value="${loginUser.mem_email}"><br /> 
	PHONE: <input type="text" name="mem_phone" value="${loginUser.mem_phone}"><br />
	
	 <input type="button" value="수정" class="submit" onclick="go_update(this.form)">
	 <input type="button" value="뒤로가기" class="submit" onclick="history.go(-1);">
	</form>
	
	</article>
	
	<script>
	function go_update(){
		document.formm.action = "<%=request.getContextPath()%>/user/update";
	    document.formm.submit();
	}
	
	</script>