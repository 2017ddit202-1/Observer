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
background-color: black;
}
#carouselMain{
padding:0%;
}


.image_text{
position: relative;
float: none;
}
.image_text .text_img{
position: absolute;
top: 250px;
left: 480px; 
text-align:center;
}







.btn {
    background-color: #2b52c6;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    width: 150px;
    height: 40px;
}
















.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #2b52c6;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 18px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
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
               
               
               
               <div class="image_text">
                  <img src="<%=request.getContextPath()%>/resources/img/main1.png" alt="Chania" style="height:670px; width: 100%;">
                   <div class="text_img">
                   <p style="font-size: 70px; color: white; font-weight: bold">Monitoring makes easy</p><p style="font-size: 30px; color: white;">강력한 모니터링 툴 OBSERVER을 무료로 이용하세요!</p>
                   <button type="button" class="btn">다운로드</button>
                   <button class="button" style="vertical-align:middle"><span>다운로드 </span></button>
                   </div>
               </div>
               
               
               
               
                  <img src="<%=request.getContextPath()%>/resources/img/main1.png" alt="Chania" style="height:670px; width: 100%;">
               </div>
               <div class="item">
                  <img src="<%=request.getContextPath()%>/resources/img/main2.png" alt="Chania" style="height:670px; width: 100%;">
               </div>

               <div class="item">
                  <img src="<%=request.getContextPath()%>/resources/img/main3.png" alt="Flower" style="height:670px; width: 100%;">
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
                    <img class="img-responsive" src="<%=request.getContextPath()%>/resources/img/Monitoring5.png" alt="">
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
                  src="<%=request.getContextPath()%>/resources/img/Monitoring4.png"
                  alt="">
            </div>
         </div>

      </div>
   </div>

</html>

