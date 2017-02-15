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

<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.min.js"></script>


<title>OBSERVER<decorator:title /></title>
<decorator:head />

<head>

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
    
    <!-- FunsionCharts -->
    <script src="<%=request.getContextPath()%>/resources/js/fusioncharts.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/fusioncharts.charts.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/fusioncharts.theme.fint.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/fusioncharts.widgets.js"></script>

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">OBSERVER</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
      
       
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
       
                </li>
                
                
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
                <%-- <sec:authorize access="isAuthenticated()">
							<li><a href="#">관리</a></li>
					</sec:authorize> --%>
                <!-- /.dropdown -->
                <li class="dropdown">      
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <!-- <ul class="dropdown-menu dropdown-user"> -->
                        <!-- <li class="divider"></li> -->
                        <sec:authorize access="isAuthenticated()">
                        	<span>${sessionScope.loginUser }님 어서오세요.</span>
                        </sec:authorize>
                        
                        
                        <sec:authorize access="hasRole('ROLE_SUPER')">
							<li><a href="<%=request.getContextPath()%>/superAdmin/management">관리</a></li>
						</sec:authorize>
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
                <div class="sidebar-nav navbar-collapse">
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
                                
                                <li>
                                    <a href="flot.html">-요약</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/cpu/cpuMain">-CPU</a>
                                </li>
                                  <li>
                                    <a href="morris.html">-메모리</a>
                                </li>
                                  <li>
                                    <a href="morris.html">-프로세스</a>
                                </li>
                                  <li>
                                    <a href="morris.html">-디스크</a>
                                </li>
                                  <li>
                                    <a href="morris.html">-트래픽</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-edit fa-fw"></i> 알림내역</a>
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
                                    <a href="<%=request.getContextPath()%>/qna/adminQnaList"> 관리자 Q&A 게시판</a>
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
                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
         <div id="page-wrapper">
         		<decorator:body />
         </div>



	
    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

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





	

   
</head>


</html>
