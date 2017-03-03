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



	<br>
	<br>


	<div id="page-wrapper3">
		<div class="container">

			<div class="media" style="margin-top: 4%;">
				<div class="media-left">
					<img
						src="<%=request.getContextPath()%>/resources/img/pay-per-click.png"
						class="media-object" style="width: 60px; margin-left: 39%;">
				</div>
				<div class="media-body">
					<h4 class="media-heading"
						style="margin-left: 3%; margin-top: 14.5px;">
						<strong>MY PAGE</strong>
					</h4>
					<p style="margin-left: 3%;">OBSERVER 회원의 정보를 관리하고, 권한 신청 / 회원
						탈퇴를 할 수 있습니다.</p>
				</div>
			</div>
			<hr>
		</div>

		<br>
		<br>





		<!-- <style>
table {
    border: 2px solid white;
     height: 400px;
     margin: auto;
     text-align: center;
}

tr, td {
    border: 1px solid white;
    padding: 20px;
}
a{font-weight: bold;}
a:link {text-decoration: none; color: #333333;}
a:visited {text-decoration: none; color: #333333;}
a:active {text-decoration: none; color: #333333;}
a:hover {text-decoration: underline; color: red;}
</style>
 -->

		<style>
table {
	width: 800px;
	text-align: center;
	margin: auto;
}

#mypage_tr {
	border-top: 2px solid #a8a8a8;
	border-bottom: 2px solid #a8a8a8;
	height: 200px;
}

#mypage_td {
	border-right: 1px solid #ededed;
}

#mypage_td2 {
	text-align: left;
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

#DeleteBtn:hover {
	background-color: #789c99;
	border-color: #789c99;
}

#DeleteBtn {
	background-color: #87adab
}
</style>

		<div style="margin-left: 22%; margin-top: -2%;">
			&nbsp;안녕하세요! &nbsp; <span style="color: #6a91ba; font-weight: bold;">${loginUser }</span>님의
			&nbsp; MyPage입니다.
		</div>

		<table>
			<tr id="mypage_tr">
				<td id="mypage_td"><img
					src="<%=request.getContextPath()%>/resources/img/mypage_1.jpg"></td>
				<td id="mypage_td2" data-toggle="modal" data-target="#myModal1">

					<div style="cursor: pointer; font-size: 18px; font-weight: bold;">
						&nbsp;&nbsp;&nbsp;권한신청<br>&nbsp;&nbsp;&nbsp;<span
							style="font-size: 15px; color: #a3a3a3">권한을 신청하고, 승인여부를
							확인할 수 있는 메뉴입니다.</span>
					</div>

				</td>
				<!-- 권한신청모달 -->
				<div class="container" style="width: 200px;">

					<!-- Modal -->
					<div class="modal fade" id="myModal1" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content" style="margin-top: 50%;">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<!-- <h4 class="modal-title" style="color:  #787878; ">관리 권한을 <span style="color: #f77852">신청</span>해주세요</h4>  -->
								</div>
								<div class="modal-body" style="text-align: center;">

									<!-- //////////////내용//////////////// -->

									<c:choose>
										<c:when test="${authority.atrt_admin_accept eq 'n'}">
											<img src="<%=request.getContextPath()%>/resources/img/ok.jpg">
											<p style="font-size: 20px; color: #787878;">권한요청이 진행중입니다!</p>
											<p style="color: #aaaaaa;">Permission request in
												progress.</p>
										</c:when>

										<c:otherwise>


											<!-- Left-aligned media object -->
											<div class="media">
												<div class="media-left">
													<img
														src="<%=request.getContextPath()%>/resources/img/authority.png"
														class="media-object"
														style="width: 60px; margin-left: 97%;">
												</div>
												<div class="media-body">
													<h4 class="media-heading"
														style="margin-left: -45%; margin-top: 2%; color: #787878">관리
														권한 신청</h4>
													<p style="color: #787878">신청자 정보를 확인한 후 관리 권한을 부여해
														드립니다.</p>
												</div>
											</div>
											<hr style="margin-top: 2%;">






											<p>
												현재 나의 권한은&nbsp;<span
													style="color: #265e78; font-size: 15px;">&nbsp;${positionList.posl_pos}&nbsp;</span>&nbsp;입니다.
											</p>


											<c:choose>
												<c:when test="${positionList.posl_pos eq 'ROLE_USER'}">

													<p>
														<span style="color: #265e78; font-size: 15x;">&nbsp;[
															ADMIN ]&nbsp;</span>으로 권한을 변경합니다.
													</p>

												</c:when>
												<c:otherwise>
													<p>
														<span style="color: #265e78; font-size: 15px;">&nbsp;[
															USER ]&nbsp;</span>로 권한을 변경합니다.
													</p>

												</c:otherwise>

											</c:choose>

											<form name=formm>
												<button class="btn btn-primary btn-sm" type="button"
													id="authorityBtn" onclick="autority_go()">신청하기</button>
											</form>

											<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> 아작스-->

											<script>
 function autority_go(){
   document.formm.action="<%=request.getContextPath()%>/atrt/authorityReq";
   document.formm.submit();   
} 

</script>

										</c:otherwise>

									</c:choose>


								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>

				</div>

			</tr>



			<tr id="mypage_tr" onclick="document.location='<%=request.getContextPath()%>/user/update'">
				<td id="mypage_td"><img src="<%=request.getContextPath()%>/resources/img/mypage_2.jpg"></td>
				<td id="mypage_td2"><div style="cursor: pointer; font-size: 18px; font-weight: bold;">회원수정</div>
					<div style="cursor: pointer;">회원가입 시 등록하셨던 정보를 수정/조회하실 수 있습니다.</div></td>
			</tr>


			<tr id="mypage_tr">
				<td id="mypage_td"><img
					src="<%=request.getContextPath()%>/resources/img/mypage_3.jpg"></td>
				<td id="mypage_td2" data-toggle="modal" data-target="#myModal"><div
						style="cursor: pointer; font-size: 18px; font-weight: bold;">회원탈퇴</div>
					<div style="cursor: pointer;">한번 탈퇴하시면, 재가입이 불가합니다.</div></td>


				<!-- 회원탈퇴모달 -->

				<div class="container" style="width: 200px;">


					<!-- Modal -->
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content" style="margin-top: 50%;">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<!-- <h4 class="modal-title">회원탈퇴</h4> -->
								</div>
								<div class="modal-body">



									<!-- //////////////내용//////////////// -->



									<div style="text-align: center;">

										<img src="<%=request.getContextPath()%>/resources/img/ok.jpg">
										<p style="color: #787878;">회원탈퇴를 진행하기 위해 본인 확인이 필요합니다.</p>

										<form id="formmm" name="formmm" method="post">
											<input type="text" id="mem_id" name="mem_id" value="${loginUser}"> 
											<input type="password" id="mem_pwd" name="mem_pwd" placeholder="Password를 입력해 주세요!"
												style="margin-top: 7px; margin-left: 5.5px;"> <br>
											<button class="btn btn-primary btn-sm" type="button" id="DeleteBtn" 
												style="margin-top: 2%; border-color: #87adab;">탈퇴하기</button>
											<br><br> <span id="resultId" style="color:#e06969 "></span>
										</form>
									</div>


<style>
input[type=password] {
	background: url(../img/keyIcon.png) 12px 11px no-repeat,
		linear-gradient(to bottom, #f7f7f8 0%, #ffffff 100%);
	border-radius: 3px;
	border: none;
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2) inset, 0 -1px 0
		rgba(0, 0, 0, 0.05) inset;
	transition: all 0.2s linear;
	font-family: "Helvetica Neue", sans-serif;
	font-size: 13px;
	color: #222222;
	position: relative;
	height: 36px;
	width: 300px;
	padding-left: 30px;
	&::
	-webkit-input-placeholder
	{
	color
	:
	#999999;
}

&
:-moz-placeholder {
	color: #999999;
}

&
:focus {
	box-shadow: 0 1px 0 #2392F3 inset, 0 -1px 0 #2392F3 inset, 1px 0 0
		#2392F3 inset, -1px 0 0 #2392F3 inset, 0 0 4px rgba(35, 146, 243, 0.5);
	outline: none;
	background: url(../img/keyIcon.png) 12px 11px no-repeat, #FFF;
}

}
input[type=text] {
	background: url(../img/keyIcon.png) 12px 11px no-repeat,
		linear-gradient(to bottom, #f7f7f8 0%, #ffffff 100%);
	border-radius: 3px;
	border: none;
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2) inset, 0 -1px 0
		rgba(0, 0, 0, 0.05) inset;
	transition: all 0.2s linear;
	font-family: "Helvetica Neue", sans-serif;
	font-size: 13px;
	color: #222222;
	position: relative;
	height: 36px;
	width: 300px;
	padding-left: 30px;
	&::
	-webkit-input-placeholder
	{
	color
	:
	#999999;
}

&
:-moz-placeholder {
	color: #999999;
}

&
:focus {
	box-shadow: 0 1px 0 #2392F3 inset, 0 -1px 0 #2392F3 inset, 1px 0 0
		#2392F3 inset, -1px 0 0 #2392F3 inset, 0 0 4px rgba(35, 146, 243, 0.5);
	outline: none;
	background: url(../img/keyIcon.png) 12px 11px no-repeat, #FFF;
}
}
</style>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>


<script>

$(function(){
   $('#DeleteBtn').click(function(){
      $.ajax({
         url : "<%=request.getContextPath()%>/user/memberDelete",
         type : "post",
         data : $('#formmm').serialize(),
          success:function(data){
            if(data=="0"){ //일치하지 않으면
               $('#resultId').text('*비밀번호가 일치하지 않습니다.');
            }else{
            
               
               swal("member leave!", "회원탈퇴가 완료되었습니다.","success"), 
       
               $('.confirm').click(function(){
                   window.location.href = "<%=request.getContextPath()%>/index";
             });
               
               
          }
                       
         },
         error:function(request,status,error){
             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
             
            }
      });
      
   });
});



</script>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>

				</div>


			</tr>


		</table>


	</div>
</body>