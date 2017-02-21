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

	  <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    
    <!-- Modal js -->
	<script src="<%=request.getContextPath()%>/resources/js/modal.js"></script>
	<!-- Main Decorator js -->
	<script src="<%=request.getContextPath()%>/resources/js/main_decorator.js"></script>

    <!-- Bootstrap Core CSS -->
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/css/modal.css"rel="stylesheet">
	
	<!-- Main Decorator CSS -->
	<link href="<%=request.getContextPath()%>/resources/css/main_decorator.css"rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css"rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
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
                <a class="navbar-brand topnav" href="<%=request.getContextPath() %>/" id="mainTitle"><h2>
                <img id="logo" src = "<%=request.getContextPath()%>/resources/img/observer1.png" style="width:7%;float:left">&nbsp;OBSERVER</h2></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
				 <li style="background-color: #2b52c6;">
                        <a href="" data-toggle="modal" data-target="#login-modal" id="modal1" data-backdrop="static" data-keyboard="false" >LOG IN</a>
                    </li>
				<li style="background-color: #000000;"><a href="<%=request.getContextPath()%>/join" id="sign1">SIGN UP</a></li>
			</ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	<div class="modal-dialog" >
			<div class="modal-content">
				<div class="modal-header" align="center">
					<img class="img-rounded" id="img_logo" src="<%=request.getContextPath()%>/resources/img/observer1.png">
					<button type="button"  id="aaa" class="close" data-dismiss="modal" aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			 		</button>
				</div>
                
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                    <!-- Begin # Login Form -->
                    <form id="login-form" role="form">
		                <div class="modal-body">
               			 <h4><span id="loginSpan">로그인</span></h4>
		                    <b><span id="loginFail"></span></b> 
				    		<input id="mem_id" name="mem_id" class="form-control" type="text" placeholder="I D" required>
				    		<input id="mem_pwd" name="mem_pwd" class="form-control" type="password" placeholder="Password" required>
                            <div class="checkbox">
                            </div>
        		    	</div>
				        <div class="modal-footer" style="padding-top:8%;">
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
    	    		        <h4><span id="pwdSpan">Password 찾기</span></h4>
    	    		        <b><span id="resultPwd"></span></b>
    	    		    	<input id="pwd_id" name="mem_id" class="form-control" type="text" placeholder="I D" required>
		    				<input id="pwd_email" name="mem_email" class="form-control" type="text" placeholder="E-Mail" required     style="margin-bottom: 10.1%;">
            			</div>
		    		    <div class="modal-footer" style="padding-top: 1.9%;">
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
            		        <h4><span id="loginSpan">ID 찾기</span></h4>
            		        <b><span id = "resultId"></span></b>
		    				<input id="mem_nm" name = "mem_nm" class="form-control" type="text" placeholder="Username">
                            <input id="mem_email" name = "mem_email" class="form-control" type="text" placeholder="E-Mail">
            			</div>
		    		    <div class="modal-footer" id="foot">
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
	<decorator:body />
</head>
</html>
