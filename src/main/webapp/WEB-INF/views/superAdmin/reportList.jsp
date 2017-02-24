<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link href="<%=request.getContextPath()%>/resources/css/modal2.css"rel="stylesheet">
<body>
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

<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
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
<script src="<%=request.getContextPath()%>/resources/js/report.js"></script>
</body>