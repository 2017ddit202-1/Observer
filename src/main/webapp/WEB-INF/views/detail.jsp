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
	position: absolute;
	top: 250px;
	left: 480px;
	text-align: center;
}


#dd{
width:300px;
float:left;
background-color: #f7f7f7;
margin-top: 2%;
}
#maindiv{
width:100%;
margin-left:28%;

}

#maindiv1{
width:100%;
margin-left:20%;

}

#detail_css{
float: left;

}
#detail_css_1{
float: left;
margin-top: 2%;
}

</style>



<div class="image_text">
	<img src="<%=request.getContextPath()%>/resources/img/mainDetail.png" alt="Chania" style="height: 550px; width: 100%;">
	<div class="text_img">
		<p style="font-size: 70px; color: white; font-weight: bold">성능 모니터링</p>
		<p style="font-size: 30px; color: white;">CPU, Memory, Disk, Traffic등 서버 성능을 나타내는 지표들을 모디터링 합니다.</p>
		<button type="button" class="btn">다운로드</button>
		<button class="button" style="vertical-align: middle">
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

<div id="dd" style="padding-left:1%;">
<img src="<%=request.getContextPath()%>/resources/img/detail2.jpg">
<h2>All-In-One모니터링</h2>
<p>서버 자원 모니터링을 비롯하여 프로세스 모니터링, 로그 모니터링, 데이터베이스 모니터링 다양한 모니터링 기능을 OBSERVER SMS 하나로 이용할 수 있습니다.</p>
</div>

<div id="dd" style="padding-left:1%;">
<img src="<%=request.getContextPath()%>/resources/img/detail3.jpg">
<h2>All-In-One모니터링</h2>
<p>서버 자원 모니터링을 비롯하여 프로세스 모니터링, 로그 모니터링, 데이터베이스 모니터링 다양한 모니터링 기능을 OBSERVER SMS 하나로 이용할 수 있습니다.</p>
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
<p>고객의 서비스를 고객보다 잘 아는 APM 하루종일 화면만</p><p> 바라보는 APM과는 다릅니다.</p>

</div>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<!-- ////////////////////////////////////////////////////////////////// -->

<div style="background-color: #2b2b2b; height: 250px;">
<p style="color: white; font-size: 30px;">사용자의 목적에 맞춰 특화된 모니터링을 이용해보세요.</p>
<button>다운로드</button>
</div>





