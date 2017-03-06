<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<style>
.image_text {
	position: relative;
	float: none;
}

.image_text .text_img {
	/* position: absolute;
	top: 250px;
	left: 480px;
	text-align: center; */
	position: absolute;
    right: 15%;
    bottom: 20px;
    left: 15%;
    z-index: 10;
    padding-top: 20px;
    padding-bottom: 41px;
    color: #fff;
    text-align: center;
    text-shadow: 0 1px 2px rgba(0, 0, 0, 0.6);
}


#dd{
width:300px;
float:left;
background-color: #f7f7f7;
margin-top: 2%;
}
#maindiv{
width:72%;
margin-left:28%;

}

#maindiv1{
width:72%;
margin-left:20%;

}

#detail_css{
float: left;

}
#detail_css_1{
float: left;
margin-top: 5%;
}



.button {
  display: inline-block;
  border-radius: 45px;
  background-color: #3f3f3f;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 18px;
  padding: 1.5%;
  width: 14%;
  transition: all 0.5s;
  cursor: pointer;
  margin: 3%;
  font-weight: bold;
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
/*   right: -20px; */
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
#btnDetail{
	background-color:rgba(00,00,00,0.1);
	border:1px solid white;
}

</style>



<div class="image_text">
	<img src="<%=request.getContextPath()%>/resources/img/mainDetail.png" alt="Chania" style="height: 550px; width: 100%;">
	<div class="text_img">
		<p style="font-size: 70px; color: white; font-weight: bold; margin-top: -6%;">성능 모니터링</p>
		<p style="font-size: 30px; color: white;">CPU, Memory, Disk, Traffic등 서버 성능을 나타내는 지표들을 모디터링 합니다.</p>
			<button class="button" id="btnDetail"
									style="vertical-align: middle"; onclick="location.href='file/installer'";>
									<span>다운로드 </span>
								</button>
								
		
	</div>
</div>


<div style="background-color: #f7f7f7; height: 320px;">
<div style="height: 250px;" id="maindiv">


<div id="dd">
<img src="<%=request.getContextPath()%>/resources/img/detail1.jpg">
<h2>All-In-One모니터링</h2>
<p>서버 자원 모니터링을 비롯하여 프로세스 모니터링, 로그 모니터링, 데이터베이스 모니터링 다양한 모니터링 기능을 OBSERVER SMS 하나로 이용할 수 있습니다.</p>
</div>

<div id="dd" style="padding-left:2%;">
<img src="<%=request.getContextPath()%>/resources/img/detail2.jpg">
<h2>다양한 대시보드</h2>
<p>사용 목적에 따라 실시간 통합 관제, 자원 사용량, 서버 가용성을 판단할 수 있는 대시보드를 제공합니다.</p>
</div>

<div id="dd" style="padding-left:2%;">
<img src="<%=request.getContextPath()%>/resources/img/detail3.jpg">
<h2>짧은도입기간</h2>
<p>한달 이상 소요되던 기존 모니터링 서비스 도입 기간이 5분이내로 단축됩니다. 옵저버 SMS로 모니터링 도입에 들어가는 초기 비용을 절감하고 다량의 서버를 빠르게 관리할 수 있습니다.</p>
</div>

</div>
</div>

<br><br><br><br>


<!-- ////////////////////////////////////////////////////////////////// -->
<div id="maindiv1">
<div id="detail_css">
<img src="<%=request.getContextPath()%>/resources/img/detail4.png">
</div>
<div id="detail_css_1">
<p style="font-size: 35px;">다양한 관점의 분석을</p> <p style="font-size: 35px;"> 통한 <span style="color: #5970c2">인사이트</span></p><br>
<p style="font-size: 15px;">고객의 서비스를 고객보다 잘 아는 APM 하루종일</p><p> 화면만 바라보는 APM과는 다릅니다.</p>

</div>
</div>


<!-- ////////////////////////////////////////////////////////////////// -->

<div style="background-color: #2b2b2b; height: 250px; margin-top: 25%;  text-align: center;">
<p style="color: white; font-size: 30px; padding-top: 4%;">사용자의 목적에 맞춰 특화된 모니터링을 이용해보세요.</p>
<button onclick="location.href='<%=request.getContextPath()%>/join'";  class="button" style="vertical-align: middle;width: 13%;margin-top: 1%;height: 22%;padding-top: 0.8%;";><span>회원가입 </span></button>

</div>





