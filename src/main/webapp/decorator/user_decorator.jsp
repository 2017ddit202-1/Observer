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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
   <!--  ////////////////////////////////네브바 -->


 <!-- Navigation -->
      <!-- Navigation -->
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
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
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
                        	<span>${loginUser }님 어서오세요.</span>
                        </sec:authorize>
                        
                        
                        <sec:authorize access="hasRole('ROLE_SUPER')">
							<li><a href="#">관리</a></li>
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
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> SERVER<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">-요약</a>
                                </li>
                                <li>
                                    <a href="morris.html">-CPU</a>
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
                                    <a href="panels-wells.html">공지사항</a>
                                </li>
                                <li>
                                    <a href="buttons.html">QnA</a>
                                </li>
                                <li>
                                    <a href="notifications.html">자유게시판</a> 
                                </li>
                                <li>
                                    <a href="typography.html">자료실</a>
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