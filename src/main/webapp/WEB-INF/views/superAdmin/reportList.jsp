<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link href="<%=request.getContextPath()%>/resources/css/modal2.css"rel="stylesheet">


<body>
<style>
#page-wrapper3 {
    position: inherit;
    margin: 0 0 0 250px;
    padding: 65px 30px;
     box-shadow: 5px 5px 5px lightgray;
     border-radius: 10px; 
   
} 
#page-wrapper3 {
    padding: 0 15px;
    min-height: 568px;
    background-color: white;
    margin-left: 10%;
    width: 79%;
   height: 860px;
}
</style>
<br>
<br>
<div id="page-wrapper3" class="in">
<br><br>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">SUPER ADMIN</a></li>
    <li><a href="<%=request.getContextPath()%>/superAdmin/authorityMemberList">회원관리</a></li>
    <li><a href="<%=request.getContextPath()%>/superAdmin/authorityList">권한요청관리</a></li>
    <li><a href="<%=request.getContextPath()%>/superAdmin/reportList">보고서</a></li>
  </ul>
  <br>
  <p><strong>Notice:</strong> OBSERVER의 회원관리, 회원의 권한신청을 관리 할 수 있습니다. </p>
</div><br><br>



<div class="container">

	     <table class="table table-striped table-bordered">
  <thead>
    <tr>
      <th>Admin ID</th>
      <th>비고</th>
    </tr>
  </thead>
<c:forEach var="adList" items="${plList}" varStatus="status">
  <tbody>
    <!-- iteração -->
    <tr>
      <td>${adList.mem_id }<input type="hidden" name="${adList.server_ip}" value="${adList.mem_email}"></td>
      <td><button data-pedido="1321" data-toggle="modal" data-target="#myModal"  class="btn btn-primary hhh" id="${adList.server_ip }"><i class="glyphicon glyphicon-plus"></i></button></td>
    </tr>
    <!-- fim iteração-->
  </tbody>
 </c:forEach> 
</table>
</div>

<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content" style="margin-top: 50%;">
      <div class="modal-header">
        <h2 class="modal-title">보고서</h2>
      </div>
      <div class="modal-body">
      <span id="zone2"></span><span id="zoneRe">로 전송하시겠습니까?</span>
     
      <div hidden="hidden" id="zone"></div>
        <p></p>
        <div class="row">
            <div class="col-12-xs text-center">
                <input type="button" class="btn btn-success btn-md" id="reportYes" value="Yes">
                <input type="button" class="btn btn-danger btn-md" id="reportNo" class="close" data-dismiss="modal" value="No">
                 <input type="button" class="btn btn-danger" id="reportNoo" class="close" data-dismiss="modal" style="display:none;" value="확인">
            </div>
        </div>
      </div>
   
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</div>
<script src="<%=request.getContextPath()%>/resources/js/report.js"></script>
<style>
#page-wrapper3 {
    position: inherit;
    margin: 0 0 0 250px;
    padding: 65px 30px;
     box-shadow: 5px 5px 5px lightgray;
     border-radius: 10px; 
   
} 
#page-wrapper3 {
    padding: 0 15px;
    min-height: 568px;
    background-color: white;
    margin-left: 10%;
    width: 79%;
   height: 860px;
}
</style>

</body>

