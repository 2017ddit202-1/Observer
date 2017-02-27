<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<br>
<br>
<br>



<table align="center">
<tr>
<td style="width: 700px; background-color: #ebebeb; height: 30px;">  &nbsp;&nbsp;&nbsp;<i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;&nbsp;   SUPER ADMIN</td>
<td style="width: 300px; background-color: #c1c1c1; color: white; font-weight: bold; text-align: right;"> 관리자 페이지 >>&nbsp;&nbsp;&nbsp;</td>
</tr>
</table>
<br><br>

<div>

           <!-- 회원관리 -->
          <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div style="font-size: 24px;" class="huge">총 회원 ${memberCnt }명</div>
                                    <div>총 회원명 수</div>
                                </div>
                            </div>
                        </div>
                        <a href="<%=request.getContextPath()%>/superAdmin/authorityMemberList">
                            <div class="panel-footer">
                                <span class="pull-left">회원관리</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div> 
                
                
                <!-- 권한요청관리 -->
                    <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div style="font-size: 24px;" class="huge">총 권한 요청 ${memberCnt }명</div>
                                    <div>권한 요청 건 수 </div>
                                </div>
                            </div>
                        </div>
                        <a href="<%=request.getContextPath()%>/superAdmin/authorityList">
                            <div class="panel-footer">
                                <span class="pull-left">권한요청관리</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div> 
                
                
                <!-- 보고서 -->
                    <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                   <!--  <i class="fa fa-support fa-5x"></i> -->
                                    <i class="fa fa-area-chart fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">13</div>
                                    <div>Support Tickets!</div>
                                </div>
                            </div>
                        </div>
                        <a href="<%=request.getContextPath()%>/superAdmin/reportList">
                            <div class="panel-footer">
                                <span class="pull-left">보고서</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div> 
                </div>

