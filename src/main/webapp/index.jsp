<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
<form id="formm" name="formm" method="get">


<h1>안녕</h1>
</body>

<script>
window.onload = function(){
	document.formm.action = "<%=request.getContextPath()%>/index";
    document.formm.submit();
}
</script>



</html>


