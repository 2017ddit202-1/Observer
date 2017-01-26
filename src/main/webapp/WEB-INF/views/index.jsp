<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>main</title>
		
<script>
   function get_msg(message){
      var move = '70px';
      jQuery('#test').text(message);
   }
   <c:if test="${error =='true'}">
   jQuery(function(){
      get_msg("로그인 실패하였습니다. 정확히 입력해주세요.")
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
         };
      });
   };

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
	<!-- 	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="display: none;">
			<div class="modal-dialog">
				<div class="loginmodal-container">
					<div class="modal-header">
						<h1>Login to Your Account</h1>
						<br>
					</div>
					<form action="loginList">
						<div class="modal-body">
							<input type="text" name="mem_id" placeholder="I D"> <br>
							<br> <input type="password" name="mem_pwd"
								placeholder="Password"><br>
							<br>
						</div>
							<input type="button" name="login" class="login loginmodal-submit"
								value="Login" onclick="login_go()">
							<input type="submit" name="login" class="login loginmodal-submit"
							value="Login">

						<div class="modal-footer">
							<div class="login-help">
								<br> <a href="#" data-toggle="modal"
									data-target="#id-modal">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<a
									href="#">PASSWORD 찾기</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div> -->
		
		<!-- 로그인화면 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4 class="modal-title" id="myModalLabel">Log in</h4>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="mem_id" name = "mem_id" placeholder="I D">
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
				<div id="test"></div> 
			<div class="modal-footer"><br><br>
				<input type="button" name="login" class="login loginmodal-submit"
								value="Login" onclick="login_go()">
					<br>
					<a href="" data-toggle="modal" target="#myModal2" id="modal2">I D </a>
					&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<a href="#" data-toggle="modal" target="#myModal3" id="modal3">PASSWORD 찾기</a>
			</div> <!-- /.modal-footer -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<!-- 로그인 화면 ID 찾기 모달 -->
 	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" id="cancle1">×</button>
				<a href="" data-toggle="modal" target="#myModal5" id="modal5">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;
				<a href="" data-toggle="modal" target="#myModal4" id="modal4">PASSWORD 찾기</a>			
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="mem_nm" name = "mem_nm" placeholder="UserName">
							<label for="uLogin" class="input-group-addon glyphicon glyphicon-user"></label>
						</div>
					</div> <!-- /.form-group -->

					<div class="form-group">
						<div class="input-group">
							<input type="password" class="form-control" id="mem_email" name ="mem_email" placeholder="Email">
							<label for="uPassword" class="input-group-addon glyphicon glyphicon-lock"></label>
						</div><!--  /.input-group -->
					</div><!--  /.form-group -->
				</form>

			</div> <!-- /.modal-body -->

			<div class="modal-footer">
				<input type="button" name="search" class="login loginmodal-submit"
								value="찾기" onclick="searchId_go()">
			</div> <!-- /.modal-footer -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 로그인 화면 Password 찾기 모달 -->
 	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" id="cancle2">×</button>
				<a href="" data-toggle="modal" target="#myModal5" id="modal5">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;
				<a href="" data-toggle="modal" target="#myModal4" id="modal4">PASSWORD 찾기</a>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="mem_id" name = "mem_id" placeholder="I D">
							<label for="uLogin" class="input-group-addon glyphicon glyphicon-user"></label>
						</div>
					</div> <!-- /.form-group -->

					<div class="form-group">
						<div class="input-group">
							<input type="password" class="form-control" id="mem_email" name ="mem_email" placeholder="Email">
							<label for="uPassword" class="input-group-addon glyphicon glyphicon-lock"></label>
						</div><!--  /.input-group -->
					</div><!--  /.form-group -->
				</form>

			</div> <!-- /.modal-body -->

			<div class="modal-footer">
				<input type="button" name="search" class="login loginmodal-submit"
								value="찾기" onclick="searchPwd_go()">
			</div> <!-- /.modal-footer -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- ID -> Password 찾기 -->
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" id="cancle3">×</button>
				<a href="" data-toggle="modal" target="#myModal5" id="modal5">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;
				<a href="" data-toggle="modal" target="#myModal4" id="modal4">PASSWORD 찾기</a>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="mem_id" name = "mem_id" placeholder="I D">
							<label for="uLogin" class="input-group-addon glyphicon glyphicon-user"></label>
						</div>
					</div> <!-- /.form-group -->

					<div class="form-group">
						<div class="input-group">
							<input type="password" class="form-control" id="mem_email" name ="mem_email" placeholder="Email">
							<label for="uPassword" class="input-group-addon glyphicon glyphicon-lock"></label>
						</div>
					</div>
				</form>

			</div>

			<div class="modal-footer">
				<input type="button" name="search" class="login loginmodal-submit"
								value="찾기" onclick="searchPwd_go()">
			</div> <!-- /.modal-footer -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Password -> ID -->
<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" id="cancle4">×</button>
				<a href="" data-toggle="modal" target="#myModal5" id="modal5">I D </a>&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;
				<a href="" data-toggle="modal" target="#myModal4" id="modal4">PASSWORD 찾기</a>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="mem_id" name = "mem_id" placeholder="I D">
							<label for="uLogin" class="input-group-addon glyphicon glyphicon-user"></label>
						</div>
					</div> <!-- /.form-group -->

					<div class="form-group">
						<div class="input-group">
							<input type="password" class="form-control" id="mem_email" name ="mem_email" placeholder="Email">
							<label for="uPassword" class="input-group-addon glyphicon glyphicon-lock"></label>
						</div>
					</div>
				</form>

			</div>

			<div class="modal-footer">
				<input type="button" name="search" class="login loginmodal-submit"
								value="찾기" onclick="searchPwd_go()">
			</div> <!-- /.modal-footer -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

	</div>


  <script> 
  
  	var login = "<form role='form'>"+
					"<div class='form-group'>"+
						"<div class='input-group'>"+
							"<input type='text' class='form-control' id='mem_id' name = 'mem_id' placeholder='I D'>"+
							"<label for='uLogin' class='input-group-addon glyphicon glyphicon-user'></label>"+
						"</div>"+
					"</div>" +
					"<div class='form-group'>"+
						"<div class='input-group'>"+
							"<input type='password' class='form-control' id='mem_pwd' name ='mem_pwd' placeholder='Password'>"+
							"<label for='uPassword' class='input-group-addon glyphicon glyphicon-lock'></label>"+
						"</div>"+
					"</div>"+
				"</form>";
  
  
  
   $(function(){
		  $('.modal-footer').on('click', '#modal2', function(e){
			  e.preventDefault();
			$("#myModal").modal('hide');
			 $("#myModal2").modal('show');
// 			$('.modal-body').empty();
// 			$('.modal-body').append("<input type='text' value='이름'>");
		  });
		 
	  });
   $(function(){
	  $('.modal-footer').on('click' , '#modal3',function(e){
		  e.preventDefault();
		  $("#myModal").modal('hide');
		  $("#myModal3").modal('show');
	  });
   });
   
   /* ID 찾기에서 --> Password 찾기 */
   $(function(){
	   $('.modal-header').on('click' , '#modal4',function(e){
		  e.preventDefault();
		  $('.modal-body').empty();
		  $('.modal-body'). html(
				  "<form role='form'>"+
					"<div class='form-group'>"+
						"<div class='input-group'>"+
							"<input type='text' class='form-control' id='mem_id' name = 'mem_id' placeholder='I D'>"+
								"<label for='uLogin' class='input-group-addon glyphicon glyphicon-user'></label>"+
						"</div>"+
					"</div>" +
					"<div class='form-group'>"+
						"<div class='input-group'>"+
							"<input type='password' class='form-control' id='mem_email' name ='mem_email' placeholder='Email'>"+
							"<label for='uPassword' class='input-group-addon glyphicon glyphicon-lock'></label>"+
						"</div>"+
					"</div>"+
				"</form>");
	  });
   });
   
   /* Password --> ID */
   $(function(){
	   $('.modal-header').on('click' , '#modal5',function(e){
		   e.preventDefault();
			  $('.modal-body').empty();
			  $('.modal-body').html(
				  "<form role='form'>"+
					"<div class='form-group'>"+
						"<div class='input-group'>"+
							"<input type='text' class='form-control' id='mem_nm' name = 'mem_nm' placeholder='UserName'>"+
								"<label for='uLogin' class='input-group-addon glyphicon glyphicon-user'></label>"+
						"</div>"+
					"</div>" +
					"<div class='form-group'>"+
						"<div class='input-group'>"+
							"<input type='password' class='form-control' id='mem_email' name ='mem_email' placeholder='Email'>"+
							"<label for='uPassword' class='input-group-addon glyphicon glyphicon-lock'></label>"+
						"</div>"+
					"</div>"+
				"</form>");
	  });
   });
   
   
   
	</script>

</html>


