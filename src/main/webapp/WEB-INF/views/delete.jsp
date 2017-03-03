<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article>
	<br> <br>
	<div id="contract">
		<h2>회원탈퇴</h2>
		<h4>My Page</h4>
	</div>
	
	<form id="formm" name="formm" method="post">
	PWD:<input type="password" id="mem_pwd">
	 <input type="button" value="계정탈퇴하기" class="submit" onclick="go_delete(this.form)">
	</form>
	
	</article>
	
	<script>
	function go_delete(){
		document.formm.action = "<%=request.getContextPath()%>/user/deletee";
	    document.formm.submit();
	}
	</script>