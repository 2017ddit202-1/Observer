<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>main</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"rel="stylesheet">
	
    <!-- Custom CSS -->
    
    <link href="<%=request.getContextPath()%>/resources/css"rel="stylesheet">


    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
		
<script>
   function get_msg(message){
	  alert('라라라라라라안되');
      var move = '70px';
      jQuery('#message').text(message);
      jQuery('#message').animate({
         top : '+=' + move
      }, 'slow',function(){
         jQuery('#message').delay(1000).animate({
            top : '-=' + move
         }, 'slow');
      });
   }
   <c:if test="${error =='true'}">
   jQuery(function(){
      get_msg("로그인 실패하였습니다.")
   });
   </c:if>
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
         }
      });
   }

</script>
		
		
</head>

<body>

  

<br><br><br><br>
    <!-- Header -->
    <a name="about"></a>
    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>Landing Page</h1>
                        <h3>A Template by Start Bootstrap</h3>
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">
                            <li>
                                <a href="https://twitter.com/SBootstrap" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                            </li>
                            <li>
                                <a href="https://github.com/IronSummitMedia/startbootstrap" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>
                            </li>
                            <li>
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-linkedin fa-fw"></i> <span class="network-name">Linkedin</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.intro-header -->

    <!-- Page Content -->

	<a  name="services"></a>
    <div class="content-section-a">

        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">Monitoring made easy<br><br>강력한 모니터링 툴 옵져버를 무료로 이용하세요</h2><br>
						 <a href="<%=request.getContextPath() %>/join" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">회원가입</span></a>
                     
                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <img class="img-responsive" src="<%=request.getContextPath()%>/resources/img/Monitoring.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-a -->

    <div class="content-section-b">

        <div class="container">

            <div class="row">
                <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">Observer SMS<br><br>다양한 관점의 분석을 통한 인사이트를 제공합니다.</h2><br>
                    <a href="<%=request.getContextPath() %>/detail" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">자세히 보기</span></a>
                </div>
                <div class="col-lg-5 col-sm-pull-6  col-sm-6">
                    <img class="img-responsive" src="<%=request.getContextPath()%>/resources/img/Monitoring2.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-b -->

    <	<a  name="services"></a>
    <div class="content-section-a">

        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">All-in-One모니터링<br><br>다양하고 혁신적인 모니터링 기능을 옵져버 하나로 사용할 수 있습니다</h2><br>
						 <a href="file/installer" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">다운로드</span></a>
                     
                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <img class="img-responsive" src="<%=request.getContextPath()%>/resources/img/Monitoring.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-a -->



	<div class="content-section-b">

		<div class="container">

			<div class="row">
				<div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
					<hr class="section-heading-spacer">
					<div class="clearfix"></div>
					<h2 class="section-heading">
						Observer SMS<br>
						<br>다양한 관점의 분석을 통한 인사이트를 제공합니다.
					</h2>
					<br> <a href="file/menu" class="btn btn-default btn-lg"><i
						class="fa fa-twitter fa-fw"></i> <span class="network-name">메뉴얼
							다운로드</span></a>
				</div>
				<div class="col-lg-5 col-sm-pull-6  col-sm-6">
					<img class="img-responsive"
						src="<%=request.getContextPath()%>/resources/img/Monitoring2.png"
						alt="">
				</div>
			</div>

		</div>
		<!-- /.container -->
		<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="display: none;">
			<div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Login to Your Account</h1>
					<br>
					<form action="loginList">
						<input type="text" name="mem_id" placeholder="I D"> <br>
						<br> <input type="password" name="mem_pwd"
							placeholder="Password"><br><br> <input type="button"
							name="login" class="login loginmodal-submit" value="Login"
							onclick="login_go()">
						<!-- <input type="submit" name="login" class="login loginmodal-submit"
							value="Login"> -->
							
						<div class = "login-help">
						<br>                                                                                                                                                                                                                         
						<a href="<%=request.getContextPath()%>/idSearch" data-toggle="modal" data-target="#id-modal">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<a
							href="#">PASSWORD 찾기</a>
						</div>	
					</form>
				</div>
			</div>
		</div>
	</div>



	<!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

</body>



</html>


