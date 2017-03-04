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
<style>
#side-menu li a{
color:#888;
}
#side-menu li a:hover{
background-color: #1f2123;
border-left:5px solid #07C758;
color: white;
}
#side-menu li a:FOCUS {
background-color: #1f2123;
}
#page-wrapper{
bottom:0 !important;
height:auto !important;
}
</style>
<html>
<!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.min.js"></script>
   
    <script src="<%=request.getContextPath()%>/resources/alert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/alert/dist/sweetalert.css">


<title>OBSERVER<decorator:title /></title>
<decorator:head />

<head>
<script>
   var wsocket;

   $(document).ready(function() {
	   var s = location.href;
	 
      wsocket = new SockJS("http://"+document.domain+":8181/observer/test/authority");
      wsocket.onopen;
      wsocket.onmessage = function appendMessage(msg) {
         
      swal("member leave!", msg.data,"success"),
    	   
      $('.confirm').click(function(){
    	  
    	  if(s=="http://"+document.domain+":8181/observer/atrt/authorityReq?" || s=="http://"+document.domain+":8181/observer/user/mypage"){
    		  window.location.href="<%=request.getContextPath()%>/user/mypage";
  		} 
         <%--  window.location.href = "<%=request.getContextPath()%>/index"; --%>
    });
      
      
      
      }
      
      
      
   });
   
</script>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
      <!-- HighChart -->
    <script src="<%=request.getContextPath()%>/resources/js/highcharts.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/exporting.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/grid-light.js"></script>

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; position:fixed; width:100%;">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <script>
                </script>
                <a class="navbar-brand" href="<%=request.getContextPath()%>/server/serverMain"><i class="fa fa-heartbeat" aria-hidden="true"></i>&nbsp;OBSERVER</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
      
       
                <!-- /.dropdown -->
                
                     <sec:authorize access="isAuthenticated()">
                           <span>${sessionScope.loginUser }님 어서오세요.</span>
                        </sec:authorize>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
       
                </li>
                
                <sec:authorize access="hasAnyRole('ROLE_USER,ROLE_ADMIN')">
                         <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" href="<%=request.getContextPath()%>/user/mypage">
                    <%-- <a class="dropdown-toggle" data-toggle="dropdown" href="<%=request.getContextPath()%>/user/mypage"> --%>
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                <ul class="dropdown-menu dropdown-user">
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 회원정보 수정</a>
                        </li>
                    </ul>
                    
                        <ul class="dropdown-menu dropdown-user">
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 권한요청</a>
                        </li>
                    </ul>
                        <ul class="dropdown-menu dropdown-user">
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 회원탈퇴</a>
                        </li>
         </ul> 
                </li>
                </sec:authorize>

                <!-- /.dropdown -->
                    <sec:authorize access="hasRole('ROLE_SUPER')">
                <li class="dropdown">      
                    <a class="dropdown-toggle" href="<%=request.getContextPath()%>/superAdmin/management">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                      </sec:authorize>
                    
                    <!-- <ul class="dropdown-menu dropdown-user"> -->
                        <!-- <li class="divider"></li> -->
                        <%-- <sec:authorize access="isAuthenticated()">
                           <span>${sessionScope.loginUser }님 어서오세요.</span>
                        </sec:authorize> --%>
                        
                        
                     <%--    <sec:authorize access="hasRole('ROLE_SUPER')">
                     <li><a href="<%=request.getContextPath()%>/superAdmin/management">관리</a></li>
                  </sec:authorize> --%>
                  <sec:authorize access="isAuthenticated()">
                             <li><a href="<%=request.getContextPath()%>/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                        </sec:authorize>
                    <!-- </ul> -->
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse" style="padding-bottom:339%; background-color: #2b2e30;">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                     
                        <li>
                            <a href="<%=request.getContextPath()%>/server/serverMain"><i class="fa fa-bar-chart-o fa-fw"></i> SERVER<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                
                                <li>
                                    <a href="<%=request.getContextPath()%>/server/serverMain">-전체목록</a>
                                </li>
                                <c:if test="${summaryMenu == 1 }">
                                <li>
                                    <a href="<%=request.getContextPath()%>/server/summary?summaryMenu=1">&nbsp;- 요약정보</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/cpu/cpuMain">&nbsp;- CPU</a>
                                </li>
                         <li>
                                    <a href="<%=request.getContextPath()%>/memory/memoryMain">&nbsp;- 메모리</a>
                                </li>   
                            
                                  <li>
                                    <a href="<%=request.getContextPath()%>/disk/diskMain">&nbsp;- 디스크</a>
                                </li>
                                  <li>
                                    <a href="<%=request.getContextPath()%>/traffic/trafficMain">&nbsp;- 트래픽</a>
                                </li>
                            </c:if>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/notice/noticeList"><i class="fa fa-edit fa-fw"></i> 알림내역</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> 게시판<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                         
                                    <a href="<%=request.getContextPath()%>/article/articleView">공지사항</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/qna/qnaList"> Q&A 게시판</a>
                                </li>
                                
                                <sec:authorize access="hasAnyRole('ROLE_SUPER', 'ROLE_ADMIN')">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/adminQnaList"> 관리자 Q&A 게시판</a>
                                </li>
                                </sec:authorize>
                                
                                
                                
                                <li>
                                    <a href="<%=request.getContextPath()%>/fb/fbList">자유게시판</a> 
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/rf/rfList">자료실</a>  
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <!--SeungBack start  -->
                       
                        <sec:authorize access="hasRole('ROLE_ADMIN')">   
                         <c:if test="${loginUserVO.mem_group_lice ne '1'}">            
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> 그룹관리<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                         
                                    <a href="<%=request.getContextPath()%>/group/meminvalid">그룹초대</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/group/groupList"> 그룹 회원 관리</a>
                                </li>
                           
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                       </c:if>
                         </sec:authorize>
                          
                       <!--SeungBack end  -->
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
         <div id="page-wrapper">
               <decorator:body />
         </div>



   <footer>
      <div class="container" style="text-align: center; background-color: #f7f7f7; margin-left:13.1111%; width:86.6%; ">
      
         
          
               <p>Copyright © 2017 OBSERVER Labs Inc. All rights reserved.</p>
              
             
                  <a href="https://bootstrapmade.com/">회사소개</a>  &nbsp;&nbsp;|&nbsp;&nbsp;
                  <a href="https://bootstrapmade.com/">이용약관</a>  &nbsp;&nbsp;|&nbsp;&nbsp;
                  <a href="https://bootstrapmade.com/">개인정보보호정책</a>  &nbsp;&nbsp;|&nbsp;&nbsp;
                  <a href="https://bootstrapmade.com/">사용자 메뉴얼</a> 
                  <br/><br/>

      </div>
   </footer>



   
    <%-- <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script> --%>
<!--     jQuery -->
<%--     <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script> --%>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/raphael/raphael.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/vendor/morrisjs/morris.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>
    
    <!--  websocket -->
   <script type="text/javascript"
   src="<%=request.getContextPath()%>/resources/js/sockjs-0.3.min.js"></script>





   

   
</head>
</html>
