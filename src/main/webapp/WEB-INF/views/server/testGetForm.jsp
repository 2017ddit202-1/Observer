<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<form action="<%=request.getContextPath() %>/server/serverMain" method="GET" >
    <input type="text" name="ip" /><br/>
    <input type="text" name="hostName" /><br/>
    <input type="submit" value="GET전송"/>
</form>
<script>
	
</script>

</body>
</html>