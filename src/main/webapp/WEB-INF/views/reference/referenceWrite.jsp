<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script>

<%-- function go_reference(){
	alert('여기여기');
	document.formm.action = "<%=request.getContextPath()%>/rf/referenceFileUpload";
    document.formm.submit();
    
} --%>
</script>
<body>
	<!-- //enctype 속성은 인코딩 타입(encoding type)을 지정한다. 
이 속성에 의해 브라우저는 입력된 데이터를 서버로 보낼 때 어떤 타입으로 인코딩해야 
하는지 알 수 있는데 인코딩 타입은 다음과 같이 세 가지 중 하나를 지정한다. -->

	<form id="formm" name="formm" method="post" action="<%=request.getContextPath()%>/rf/referenceFileUpload"
		enctype="multipart/form-data">
    아이디:<input type="text" name="mem_id" required="required" placeholder="아이디"><br>
      제목:<input type="text" name="reli_subject" required="required" placeholder="제목"><br>
	 내용:<textarea rows="20" cols="40" name="reli_content" required="required" placeholder="내용"></textarea><br>
      파일:<input type="file" name="uploadfile" required="required"><br>
				
	<button type="submit">글쓰기</button>
	<button type="button" id="btnContactUs" onclick="history.go(-1);">취소</button>
    </form>
</body>
</html>




