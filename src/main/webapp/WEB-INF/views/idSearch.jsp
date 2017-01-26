<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"rel="stylesheet">
	
    <!-- Custom CSS -->
    
    <link href="<%=request.getContextPath()%>/resources/css"rel="stylesheet">


    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
<script>
  $(function(){
	  $('.modal-footer').on('click', '#id-modal', function(e){
		  e.preventDefault();
		// $("#myModal").modal('hide');
		//  $("#myModal2").modal('show');
		$('.modal-footer').empty();
		$('.modal-footer').append("<input type='button' name='idsearch' class='id idmodal-submit' value='찾기'>");
	  });
  })
  

</script>
	

</head>
<body>
	 <br>
	 	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Log in</h4>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="mem_id" name = "mem_id" placeholder="Login">
							<label for="uLogin" class="input-group-addon glyphicon glyphicon-user"></label>
						</div>
					</div> <!-- /.form-group -->

					<div class="form-group">
						<div class="input-group">
							<input type="password" class="form-control" id="mem_pwd" name ="mem_pwd" placeholder="Password">
							<label for="uPassword" class="input-group-addon glyphicon glyphicon-lock"></label>
						</div><!--  /.input-group -->
					</div><!--  /.form-group -->
				</form>

			</div> <!-- /.modal-body -->

			<div class="modal-footer">
				<input type="button" name="login" class="login loginmodal-submit"
								value="Login" onclick="login_go()">
				<div class="login-help">
					<br> <a href="#" data-toggle="modal" data-target="#id-modal">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<a href="#">PASSWORD 찾기</a>
				</div>				
								

			</div> <!-- /.modal-footer -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
	 
	 
<!-- 	<div class="Id-help">
		<a href="">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<a href="#">PASSWORD
			찾기</a>
		<div class="modal fade" id="id-modal" tabindex="-1" role="dialogId"
			aria-labelledby="idModalLabel" aria-hidden="true"
			style="display: none;">
			<div class="modal-dialogId">
				<div class="loginmodal-containerId">
					<h1>I D 찾기</h1>
					<br>
					<form>
						<div class="modal-body">
							<input type="text" name="mem_id" placeholder="I D"> <br>
										<br> <input type="password" name="mem_pwd"
											placeholder="Password"><br> 
											<input type="button" name="id" class="id idmodal-submit" value="id">

							<input type="text" name="mem_nm" placeholder="Name"> <input
								type="text" name="mem_email" placeholder="E-Mail">
						</div>
						<div class="modal-footer">
							<input type="button" name="idsearch" class="id idmodal-submit"
								value="찾기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div> -->
	
	
	
</body>
</html>