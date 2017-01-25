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
	
<%-- 	<script>
		$(function(){
			$('#id-modal').click(function(){
				$.ajax({
					url:"<%=request.getContextPath()%>/idSearch",
					type:'POST',
					success:function(data){
						
					}
				})
			});
		});
	
	</script> --%>
	

</head>
<body>
	 <br>
					<div class="Id-help">
						<a href="">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<a href="#">PASSWORD 찾기</a>
						<div class="modal fade" id="id-modal" tabindex="-1"
							role="dialogId" aria-labelledby="idModalLabel" aria-hidden="true"
							style="display: none;">
							<div class="modal-dialogId">
								<div class="loginmodal-containerId">
									<h1>I D 찾기</h1>
									<br>
									<form>
										<!-- <input type="text" name="mem_id" placeholder="I D"> <br>
										<br> <input type="password" name="mem_pwd"
											placeholder="Password"><br> 
											<input type="button" name="id" class="id idmodal-submit" value="id"> -->
											
										<input type = "text" name = "mem_nm" placeholder="Name">
										<input type = "text" name = "mem_email" placeholder="E-Mail">
										<input type = "button" name= "idsearch" class="id idmodal-submit" value="찾기"> 	
											
									</form>	 
								</div>
							</div>		
						</div>
					</div>	 
</body>
</html>