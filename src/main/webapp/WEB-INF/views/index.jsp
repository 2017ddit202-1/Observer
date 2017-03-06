<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
	<link href="<%=request.getContextPath()%>/resources/css/index.css"rel="stylesheet">
    <title>main</title>
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
				<div class="carousel-inner" role="listbox" style="height: 670px;">
					<div class="item active">
						<div class="image_text">
							<img src="<%=request.getContextPath()%>/resources/img/main1.png"
								alt="Chania" style="height: 670px; width: 100%;">
							<div class="text_img">
							
								<p style="font-size: 70px; color: white; font-weight: bold">Monitoring
									makes easy</p>
								<p style="font-size: 26px; color: white;">강력한 모니터링 툴
									OBSERVER을 무료로 이용하세요.</p>
								<button class="button" style="vertical-align: middle"; onclick="location.href='<%=request.getContextPath()%>/join'">
									<span>회원가입 </span>  
								</button>
								<button class="button" id="btnDetail"
									style="vertical-align: middle" onclick="location.href='<%=request.getContextPath()%>/detail'">
									<span>자세히보기 </span>
								</button>
								
							</div>
						</div>
					</div>
					<div class="item">
						<div class="image_text">
							<img src="<%=request.getContextPath()%>/resources/img/main2.png"
								alt="Chania" style="height: 670px; width: 100%;">
							<div class="text_img">
								<p style="font-size: 70px; color: white; font-weight: bold">All-in-One
									Monitoring</p>
								<p style="font-size: 26px; color: white;">다양하고 혁신적인 모니터링 기능을
									OBSERVER 로 사용할 수 있습니다.</p>
								<button class="button" style="vertical-align: middle"; onclick="location.href='file/installer'";>
									<span>다운로드 </span>
								</button>
								<button class="button" id="btnDetail"
									style="vertical-align: middle" onclick="location.href='<%=request.getContextPath()%>/detail'">
									<span>자세히보기 </span>
								</button>
							</div>
						</div>
					</div>

					<div class="item">
						<div class="image_text">
							<img src="<%=request.getContextPath()%>/resources/img/main3.png"
								alt="Chania" style="height: 670px; width: 100%;">
							<div class="text_img">
								<p style="font-size: 70px; color: white; font-weight: bold">OBSERVER
									SMS</p>
								<p style="font-size: 26px; color: white;">　　　다양한 관점의 분석을 통한
									인사이트를 제공합니다.　　　</p>
								<button class="button" style="vertical-align: middle" onclick="location.href='file/menu'">
									<span>Menual 다운로드 </span>
								</button>
								<button class="button" id="btnDetail"
									style="vertical-align: middle" onclick="location.href='<%=request.getContextPath()%>/detail'">
									<span>자세히보기 </span>
								</button>
							</div>
						</div>
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

<br><br><br><br>
    <!-- Page Content -->

   <a  name="services"></a>
    <div class="content-section-a" style="background-color: #f8f8f8; height: 449px;
    margin-top: -4%; border-bottom: 1px solid #e7e7e7;">

        <div class="container">
            <div class="row" style="margin-top: 4.5%;">
                <div class="col-lg-5 col-sm-6">
                    <hr> 
                    <div class="clearfix"></div>
                    <h2 class="section-heading">Monitoring made easy<br><br>강력한 모니터링 툴 OBSERVER를 무료로 이용하세요.</h2><br>
                   <a href="<%=request.getContextPath() %>/join" class="btn btn-default btn-lg"><i class="fa fa-child" aria-hidden="true"></i> <span class="network-name">회원가입</span></a>
                     
                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <img class="img-responsive" src="<%=request.getContextPath()%>/resources/img/Monitoring3.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-a -->

    <div class="content-section-b" style="margin-top: 2%;">

        <div class="container">

            <div class="row">
                <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">OBSERVER SMS<br><br>다양한 관점의 분석을 통한 인사이트를 제공합니다.</h2><br>
                    <a href="<%=request.getContextPath() %>/detail" class="btn btn-default btn-lg"><i class="fa fa-plus-circle" aria-hidden="true"></i> <span class="network-name">자세히 보기</span></a>
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
    <div class="content-section-a" style="background-color: #f8f8f8; margin-top: 8px; border-bottom: 1px solid #e7e7e7; border-top:1px solid #e7e7e7;">

        <div class="container">
            <div class="row" style="margin-top: 4.5%;">
                <div class="col-lg-5 col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">All-in-One모니터링<br><br>다양하고 혁신적인 모니터링 기능을 OBSERVER 로 사용할 수 있습니다.</h2><br>
                   <a href="file/installer" class="btn btn-default btn-lg"><i class="fa fa-chevron-circle-down" aria-hidden="true"></i> <span class="network-name">다운로드</span></a>
                     
                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <img class="img-responsive" src="<%=request.getContextPath()%>/resources/img/Monitoring5.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-a -->



   <div class="content-section-b">

      <div class="container">

         <div class="row" style="margin-top: 4%;">
            <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
               <hr class="section-heading-spacer">
               <div class="clearfix"></div>
               <h2 class="section-heading">
                  OBSERVER SMS<br>
                  <br>다양한 관점의 분석을 통한 인사이트를 제공합니다.
               </h2>
               <br> <a href="file/menu" class="btn btn-default btn-lg"><i class="fa fa-thumb-tack" aria-hidden="true"></i> <span class="network-name">메뉴얼
                     다운로드</span></a>
            </div>
            <div class="col-lg-5 col-sm-pull-6  col-sm-6">
               <img class="img-responsive"
                  src="<%=request.getContextPath()%>/resources/img/Monitoring4.png"
                  alt="">
            </div>
         </div>

      </div>
   </div>
<br/><br/><br/><br/><br/><br/>
</html>

