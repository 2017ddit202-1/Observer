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
	</div>

</html>


