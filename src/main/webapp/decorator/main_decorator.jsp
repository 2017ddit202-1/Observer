<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<!DOCTYPE html>
<html>
<title>OBSERVER<decorator:title /></title>
<decorator:head />

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">




    <title>Landing Page - Start Bootstrap Theme</title>


    <!-- Bootstrap Core CSS -->
    
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/css/modal.css"rel="stylesheet">
	
    <!-- Custom CSS -->
    
    <%-- <link href="<%=request.getContextPath()%>/resources/css/landing-page.css"rel="stylesheet"> --%>


    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css"rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


 <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="<%=request.getContextPath() %>/">Observer</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#about">About</a>
                    </li>
 
				 <li>
                        <a href="" data-toggle="modal" data-target="#login-modal" id="modal1" data-backdrop="static" data-keyboard="false" >Login</a>
                    </li>
				<!-- <li>
					<button class="btn btn-primary" data-toggle="modal"
						data-target="#myModal">Log in</button>
				</li> -->
				<li><a href="<%=request.getContextPath()%>/join">Sign Up</a></li>
			</ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" align="center">
					<img class="img-circle" id="img_logo" src="http://bootsnipp.com/img/logo.jpg">
					<button type="button"  id="aaa" class="close" data-dismiss="modal" aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
				</div>
                
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                
                    <!-- Begin # Login Form -->
                    <form id="login-form" role="form">
		                <div class="modal-body">
		                        <span>로그인</span> 
				    		<input id="mem_id" name="mem_id" class="form-control" type="text" placeholder="I D" required>
				    		<input id="mem_pwd" name="mem_pwd" class="form-control" type="password" placeholder="Password" required>
                            <div class="checkbox">
                            </div>
        		    	</div>
				        <div class="modal-footer">
                            <div>
                                <button type="button" class="btn btn-primary btn-lg btn-block" name="login" value="login" onclick="login_go()">Login</button>
                            </div>
				    	    <div>
                                <button id="login_register_btn" type="button" class="btn btn-link">I D</button> / 
                                <button id="login_lost_btn" type="button" class="btn btn-link">Password</button>
                            </div>
				        </div>
                    </form>
                    <!-- End # Login Form -->
                    
                    <!-- Begin | Lost Password Form -->
                    <form id="lost-form" style="display:none;">
    	    		    <div class="modal-body">
    	    		        <span>Password 찾기</span><span id="resultPwd"></span>
    	    		    	<input id="mem_id" name="mem_id" class="form-control" type="text" placeholder="I D" required>
		    				<input id="mem_email" name="mem_email" class="form-control" type="text" placeholder="E-Mail" required>
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="button" class="btn btn-primary btn-lg btn-block" id ="pwdBtn">Send</button>
                            </div>
                            <div>
                                <button id="lost_register_btn" type="button" class="btn btn-link">I D 찾기</button>
                                <button id="lost_login_btn" type="button" class="btn btn-link">Log In</button>
                            </div>
		    		    </div>
                    </form>
                    <!-- End | Lost Password Form -->
                    
                    <!-- Begin | Lost ID Form -->
                    <form id="register-form" name="idForm" style="display:none;">
            		    <div class="modal-body">
            		        <span>I D 찾기</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "resultId"></span>
		    				<input id="mem_nm" name = "mem_nm" class="form-control" type="text" placeholder="Username">
                            <input id="mem_email" name = "mem_email" class="form-control" type="text" placeholder="E-Mail">
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="button" id = "idBtn"class="btn btn-primary btn-lg btn-block">Send</button>
                            </div>
                            <div>
                                <button id="register_login_btn" type="button" class="btn btn-link">Log In</button>
                                <button id="register_lost_btn" type="button" class="btn btn-link">Password 찾기</button>
                            </div>
		    		    </div>
                    </form>  
                    <!-- End | Lost ID Form -->
                    
                </div>
                <!-- End # DIV Form -->
                
			</div>
		</div>
	</div>
    <!-- END # MODAL LOGIN -->
    
    
    
    

    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

	<!-- Modal js -->
	<script src="<%=request.getContextPath()%>/resources/js/modal.js"></script>




	<decorator:body />

   
</head>
<%-- <script type="text/javascript">
	function login_go(form){
		form.action = "<%=request.getContextPath()%>/user/login";
		form.method = "POST";
		form.submit();
	}
</script> --%>
<script>
function login_go(){
    $.ajax({
       url : 'loginList',
       data : $('form input').serialize(),
       type : 'POST',
       dataType : 'json',
       beforeSend : function(xhr){
          xhr.setRequestHeader("Accept","application/json");
       }
    }).done(function(body){
       var message=body.response.message;
       var error=body.response.error;
       var returl=body.response.returl;
       if(error)
          get_msg(message);
       if(error==false){
          if(returl=='')
             returl = '<c:url value="/user/mypage" />';
          location.href = returl;
       };
    });
 };
 </script>
 <script>
 $(function(){
	 $('#idBtn').click(function(){
		 
		$.ajax({
			url : "<%=request.getContextPath()%>/idFind",
			type : "post",
			data : $('#register-form input').serialize(),
			success:function(data){
				$('#resultId').text(data);
				$('#mem_nm').val("");
				$('#register-form #mem_email').val("");
			},
		});
	 });
 });

 $(function(){
	$('#pwdBtn').click(function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/pwdFind",
			type : "post",
			data : $('#lost-form input').serialize(),
			success:function(resultEmail){
				$('#resultPwd').text(resultEmail);
				$('#mem_id').val("");
				$('#lost-form #mem_email').val("");
			},
		});
	}); 
 });
 
 
 
</script>

 
</html>
