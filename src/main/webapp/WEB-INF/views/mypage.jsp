<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


	<!-- ///////////////////////////////////////////////////////////////////////////////// -->


	<br>
	<br>
	<div id="contract">
		<h2>마이페이지</h2>
		<h4>My Page</h4>
	</div>

	<tr>
		<a href="<%=request.getContextPath()%>/user/update">회원수정</a>
	</tr>
	<br>





	<!-- 권한신청모달 -->
	<div class="container">

		<button type="button" data-toggle="modal" data-target="#myModal">권한신청</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">권한신청</h4>
					</div>
					<div class="modal-body">



						<!-- //////////////내용//////////////// -->

						<p>현재 나의 권한은${positionList.posl_pos}입니다.</p>


						<c:choose>
							<c:when test="${positionList.posl_pos eq 'ROLE_USER'}">

								<p>ADMIN으로 변경합니다.</p>

							</c:when>
							<c:otherwise>
								<p>USER로 변경합니다.</p>

							</c:otherwise>

						</c:choose>
						
						<button type="button" id="authorityBtn" onclick="autority_go()">신청하기</button>


						<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> 아작스-->

						<script>
 function autority_go(){
	document.formm.action="<%=request.getContextPath()%>/atrt/authorityReq";
	document.formm.submit();	
} 

<%-- $(function(){ 아작스
	$('#DeleteBtn').click(function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/user/memberDelete",
			type : "post",
			data : $('#formm input').serialize(),
			 success:function(data){
				if(data=="0"){ //일치하지 않으면
					$('#resultId').text('비밀번호가 일치하지 않습니다.')
				}else{
					alert('탈퇴완료되었습니다.')
					location.href="<%=request.getContextPath()%>/index";
				}
			},
		});
		
	});
}); --%>



</script>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

	</div>






	<!-- 회원탈퇴모달 -->

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
							ID:<input type="text" id="mem_id" name="mem_id"
								value="${loginUser}"><br> PWD:<input
								type="password" id="mem_pwd" name="mem_pwd"><br>
							<button type="button" id="DeleteBtn" onclick="memberDelete()">탈퇴하기</button>
							<br> <span id="resultId"></span>
							<!-- //데이터를 입력받기위한 스판태그 -->
						</form>


						<script src="http://code.jquery.com/jquery-latest.min.js"></script>

						<script>
<%-- function memberDelete(){
	document.formm.action="<%=request.getContextPath()%>/user/memberDelete";
	document.formm.submit();	
} --%>

$(function(){
	$('#DeleteBtn').click(function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/user/memberDelete",
			type : "post",
			data : $('#formm input').serialize(),
			 success:function(data){
				if(data=="0"){ //일치하지 않으면
					$('#resultId').text('비밀번호가 일치하지 않습니다.')
				}else{
					alert('탈퇴완료되었습니다.')
					location.href="<%=request.getContextPath()%>/index";
				}
			},
		});
		
	});
});



</script>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

	</div>

</body>