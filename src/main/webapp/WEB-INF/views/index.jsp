<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>
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
		
<style>
#carouselMain{
width:100%;
}
.carousel-inner img{
margin-top:5%;
background-color: black;
}
#carouselMain{
padding:0%;
}

</style>		

</head>

<body>

  

<br><br><br><br>
    <!-- Header -->
    <div class="intro-header">
        <div class="container" id="carouselMain">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox" style="height:670px;">
					<div class="item active">
						<img src="<%=request.getContextPath()%>/resources/img/Monitoring.png" alt="Chania" width="1583" height="485">
					</div>
					<div class="item">
						<img src="<%=request.getContextPath()%>/resources/img/Monitoring2.png" alt="Chania" width="1583" height="485">
					</div>

					<div class="item">
						<img src="<%=request.getContextPath()%>/resources/img/ipad.png" alt="Flower" width="1583" height="485">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
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
                    <img class="img-responsive" src="<%=request.getContextPath()%>/resources/img/Monitoring3.png" alt="">
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

    <a  name="services"></a>
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
                    <img class="img-responsive" src="<%=request.getContextPath()%>/resources/img/Monitoring3.png" alt="">
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


