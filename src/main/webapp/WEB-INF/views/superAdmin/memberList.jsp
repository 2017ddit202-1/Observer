<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
<br>
<br>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">SUPER ADMIN</a></li>
    <li><a href="#">회원관리</a></li>
    <li><a href="#">권한요청관리</a></li>
    <li><a href="#">보고서</a></li>
  </ul>
  <br>
  <p><strong>Notice:</strong> OBSERVER의 회원관리, 회원의 권한신청을 관리 할 수 있습니다. </p>
</div>




<div class="container">
		<h3 class="text-center">MEMBER LIST</h3>

		<form class="form-inline" id="memberSearch" name="searchform"
			method="get" style="margin-left: 69%;">
			<div class="form-group">
				<label for="pwd">ID :</label> <input type="text"
					class="form-control" id="memberName" name="memberName">
			</div>
			<input type="button" class="btn btn-default" value="Search" onclick="adminSearch()">
		</form><br><br>



<div class="container">
  <span class="label label-default">총회원수</span>
  <span class="label label-danger">탈퇴회원</span>
  <span class="label label-success">USER</span>
  <span class="label label-info">ADMIN</span>
</div>




		<table id="memberList" class="table table-striped">
			<thead>
				<tr>
					<th>Enabled</th>
					<th>ID</th>
					<th>Name</th>
					<th>Position</th>
					<th>Email</th>
					<th>Phone</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${memberListSize<=0}">
						<tr>
							<td width="100%" colspan="5" align="center" height="23">
								There are no registered members.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${memberList}" var="memberVO">
							<c:if test="${memberVO.mem_id ne 'SUADMIN1'}">
							<tr data-toggle="modal" data-target="#myModal">
							
									<c:choose>
										<c:when test='${memberVO.enabled=="1"}'>
											<td class="enabled">가능</td>
										</c:when>
										<c:otherwise>
											<td class="enabled">불가능</td>
										</c:otherwise>
									</c:choose>
								<td class="id">${memberVO.mem_id}</td>
								<td class="name">${memberVO.mem_nm}</td>
								<c:choose>
										<c:when test='${memberVO.posl_pos=="ROLE_USER"}'>
											<td class="position">ROLE_USER</td>
										</c:when>
										<c:otherwise>
											<td class="position">ROLE_ADMIN</td>
										</c:otherwise>
								</c:choose>							
								<td class="email">${memberVO.mem_email}</td>
								<td class="phone">${memberVO.mem_phone}</td>
								<td class="pwd" style="display: none">${memberVO.mem_pwd}</td>
								<td class="indate" style="display: none">${memberVO.mem_date}</td>
								<td class="useyn" style="display: none">${memberVO.enabled}</td>
								<td class="lice" style="display: none">${memberVO.mem_group_lice}</td>
							</tr>
							</c:if>
						</c:forEach>
						<tr>
							<td colspan="6" style="text-align: center;">${paging}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg" >
				<div class="modal-content" style="width:500px;">
					<form action="" id="updateInfoAdmin" name="updateInfoAdmin">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Edit member info</h4>
						</div>
						<div class="modal-body">

							<table>
								<tr>
									<td><label>User ID</label></td>
									<td><input type="text" class="form-control" id="editId"
										name="editId" readonly="readonly"></td>
									<td></td>
								</tr>

								<tr>
									<td><label for="password">Password</label></td>
									<td><input type="password" class="form-control" name="editPwd"
										id="editPwd" placeholder="" required=""></td>
								</tr>



								<tr>
									<td><label for="name">Name</label></td>
									<td><input type="text" class="form-control"
										name="editName" id="editName" placeholder="" required=""></td>
								</tr>

								<tr>
									<td><label for="email">Email</label></td>
									<td><input type="text" class="form-control"
										name="editEmail" id="editEmail" placeholder="" required=""></td>
								</tr>

								<tr>
									<td><label for="editPhone">PhoneNumber</label></td>
									<td><input type="text" class="form-control"
										name="editPhone" id="editPhone" placeholder="" required=""></td>
								</tr>
								
								<tr>
									<td><label>LICENSE</label></td>
									<td><input type="text" class="form-control"
										name="editlice" id="editlice" placeholder="" required=""></td>
								</tr>
								
								<tr>
									<td><label>ENABLED</label></td>
									<td>
									<input type="radio" class="" name="editUseyn" id="editUseyn" value="y"> 가능<br />
									<input type="radio" class="" name="editUseyn" id="editUseyn" value="n"> 불가능<br />
									</td>
								</tr>
								
								<tr>
									<td><label>POSITION</label></td>
									<td><input type="radio" class=""
										name="editPosition" id="editPosition" value="ROLE_USER">유저<br /> <input
										type="radio" class="" name="editPosition"
										id="editPosition" value="ROLE_ADMIN"> 관리자<br /></td>
								</tr>

								<tr>
									<td><label for="editIndate">Indate</label></td>
									<td><input type="text" class="form-control"
										name="editIndate" id="editIndate" placeholder="" required=""
										readonly="readonly"></td>
								</tr>

							
							</table>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								onclick="go_adminUpdate(this.form)">Update</button>
							<!-- <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
 -->						<button type="button" class="btn btn-danger" onclick="modalclose()">Close</button>		
 					</div>
					</form>
				</div>
			</div>
		</div>

	</div>

<script>
$(document).ready(function() {
		/* $('[data-toggle="tooltip"]').tooltip({
			placement : 'bottom'
		}); */

		
		$('#memberList tbody').on( 'click', 'tr', function () {
	        //alert($(this).closest('tr').children('td.name').text());
	        var id = $(this).closest('tr').children('td.id').text();
	        var name = $(this).closest('tr').children('td.name').text();
	        var email = $(this).closest('tr').children('td.email').text();
	        var phone = $(this).closest('tr').children('td.phone').text();
	        var pwd = $(this).closest('tr').children('td.pwd').text();
	        var indate = $(this).closest('tr').children('td.indate').text();
	        var useyn = $(this).closest('tr').children('td.useyn').text();
	        var lice = $(this).closest('tr').children('td.lice').text();
	        var position = $(this).closest('tr').children('td.position').text();
	       
	        
	        $('#editId').val(id);
	        $('#editName').val(name);
	        $('#editEmail').val(email);
	        $('#editPhone').val(phone);
	        $('#editPwd').val(pwd);
	        $('#editIndate').val(indate);
	        $('#editlice').val(lice);     		 
	        
	        if(useyn=='1'){ 
	        	$("input:radio[name='editUseyn']:radio[value='y']").attr("checked",true);
	        }
	        else { 
	        	$("input:radio[name='editUseyn']:radio[value='n']").attr("checked",true);
	        }
	        
	        if(position=='ROLE_USER'){ 
	        	$("input:radio[name='editPosition']:radio[value='ROLE_USER']").attr("checked",true);
	        }
	        else { 
	        	$("input:radio[name='editPosition']:radio[value='ROLE_ADMIN']").attr("checked",true);
	        }
	       
	        
	        //$('#editUseyn').val(useyn);
	        //$('#editPosition').val(position);
	    } ); 
	});

	
	function go_adminUpdate(form){
		/* alert("5");
		//var form = $('#updateInfoAdmin')
		alert(form); */
		form.action="adminUpdatemember";
		form.method="post";
		form.submit();
	}
	
	function modalclose(){
		location.reload();
	}
	
	function adminSearch(){
		var keyword = $('#memberName').val();
		location.href = "<%=request.getContextPath()%>/superAdmin/authorityMemberList?key="+keyword;
	}
</script>

</body>
</html>