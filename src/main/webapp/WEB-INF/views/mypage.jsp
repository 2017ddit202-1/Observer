<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<!-- ///////////////////////////////////////////////////////////////////////////////// -->


	<br> <br>
	<div id="contract">
		<h2>마이페이지</h2>
		<h4>My Page</h4>
	</div>
	<table>
	<tr><a href="<%=request.getContextPath()%>/user/update">회원수정</a></tr><br>
	<tr><a href="#">권한신청</a></tr><br>
	</table>

	
	<%-- <tr><a href="<%=request.getContextPath()%>/user/deletee">회원탈퇴</a></tr><br> --%>
	
	<div class="container">
  
  
  
  <button type="button" data-toggle="modal" data-target="#myModal">회원탈퇴</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">회원탈퇴</h4>
        </div>
        <div class="modal-body">
        <!-- //////////////내용//////////////// -->
        
        <form id="formm" name="formm" method="post">
        ID:<input type="text" id="mem_id" name="mem_id" value="${loginUser}"><br>
        PWD:<input type="password" id="mem_pwd" name="mem_pwd"><br>
        <button type="button" id="btnContactUs" onclick="memberDelete()">탈퇴하기</button>
        </form>
        
 <script>
function memberDelete(){
	document.formm.action="<%=request.getContextPath()%>/user/memberDelete";
	document.formm.submit();	
}



</script>
        
        
        <!-- //////////////내용//////////////// -->
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</body>




	
	
	
	
	
	

	
	



	