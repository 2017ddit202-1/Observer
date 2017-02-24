<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link href="<%=request.getContextPath()%>/resources/css/modal2.css"rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/report.js"></script>

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
      <td>${adList.mem_id }<input type="hidden" id ="${adList.mem_email}" class="${adList.server_ip }"></td>
      <td><button data-pedido="1321" data-toggle="modal" data-target="#myModal"  class="btn btn-primary hhh" id="${adList.mem_email }"><i class="glyphicon glyphicon-plus"></i></button></td>
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
      <span id="zone"></span> 로 전송하시겠습니까?
      <div hidden="hideen" id="zone2"></div>
        <p></p>
        <div class="row">
            <div class="col-12-xs text-center">
                <button class="btn btn-success btn-md" id="reportYes">Yes</button>
                <button class="btn btn-danger btn-md" id="reportNo">No</button>
            </div>
        </div>
      </div>
   
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
	$('.hhh').on('click',function(){
		var a =$(this).attr('id');
		var b = $('input[id="'+a+'"]').attr('class');
		$('#zone').text(a);
		$('#zone2').text(b);
	});
	$('#reportYes').on('click',function(){
		//이메일
		var email = $('#zone').text();
		// 아이디
		var ip = $('#zone2').text();
		var data = {"email":email,"ip":ip};
		$.ajax({
			url : "<%=request.getContextPath()%>/superAdmin/reportGo",
			type:'post',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType:'text',
			success:function(resultEmail){
				$('#zone').html(resultEmail);
			}
		});
	});
	
</script>

</body>
