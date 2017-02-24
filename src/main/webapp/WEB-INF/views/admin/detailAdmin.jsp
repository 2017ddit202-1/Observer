<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<style>
#detail_table_tr {
	height: 50px;
	border-top: 1px solid #c3ced9;
	border-bottom: 1px solid #c3ced9;
	text-align: center;
}
</style>



</head>
<body>

	<br>
	<br>
	<div style="text-align: center;">
		<h2>Admin 상세보기</h2>
		<h4>Admin Detail</h4>
		각종 안내, 서비스 또는 OBSERVER의 소식 버전안내 등의 정보를 확인할 수 있습니다.
	</div>
	<br>
	<br>
	<br>



	<form id="formm" name="formm" method="post">
		<table style="width: 1000px;" align="center">

			<tr id="detail_table_tr">
				<td
					style="background-color: #e4eaf2; width: 90px; border-top: 1px solid #c3ced9;">제목</td>
				<td><input type="text" name="ad_subject"
					value="${adminVO.ad_subject}"
					style="border: none; outline: none; width: 300px; text-align: center;"></td>
				<td></td>
				<td></td>
			</tr>

			<tr id="detail_table_tr">
				<td
					style="background-color: #e4eaf2; border-top: 1px solid #c3ced9;">작성자</td>
				<td>${adminVO.ad_id}</td>


				<td
					style="background-color: #e4eaf2; width: 90px; border-top: 1px solid #c3ced9;">등록일</td>
				<td style="border-top: 1px solid #c3ced9;"><fmt:formatDate
						value="${adminVO.ad_date}" type="date" /></td>
			</tr>


		</table>
		<div style="text-align: center;">
			<textarea name="ad_content"
				style="border: 0; overflow-y: hidden; background: clear; resize: none; width: 1000px; height: 200px; outline: none;">${adminVO.ad_content}</textarea>
		</div>

		<!-- // -->


		<!-- 댓글이 있으면 테이블이 보여짐 -->
		<table style="width: 1000px;" align="center">
			<c:if test="${adminVO.ad_nswer != ' ' }">
				<tr id="detail_table_tr">
					<td
						style="background-color: #e4eaf2; border-top: 1px solid #c3ced9; width: 90px;">답변
						내용</td>
					<td><div id="sss">${adminVO.ad_nswer}</div></td>
				</tr>
			</c:if>
		</table>
		<br>








		<!-- 답변하기 클릭 했을때!! -->
		<div class="container" id="hiddenDiv" style="display: none">
			<form>
				<div class="form-group">

					<table style="width: 1000px;" align="center">
						<tr id="detail_table_tr">
							<td
								style="background-color: #e4eaf2; border-top: 1px solid #c3ced9; width: 90px;">답변
								내용</td>
							<td><textarea rows="10" cols="100" name="email"
									placeholder="답변 내용 작성하기"
									style="width: 901px; border: 0; overflow-y: hidden; background: clear; resize: none; height: 200px; outline: none;"></textarea></td>
						</tr>
					</table>


				</div>

				<button type="button" id="btn" class="btn btn-default btn-block"
					onclick="qAnswer_go()">답변등록</button>
			</form>
		</div>
		<!--  -->

		<div class="clear"></div>



		<hr style="border: solid 1px #c3ced9; width: 1000px;">



		<div id="buttons" style="text-align: center;">
			<input type="button" value="목록보기" class="submit"
				onclick="adminlist_go()">
			<c:choose>
				<c:when test="${loginUserVO.mem_id eq adminVO.ad_id}">
					<input type="button" value="수정" class="submit"
						onclick="updateAdmin_go()">
					<input type="button" value="삭제" class="submit"
						onclick="deleteAdmin_go()">
				</c:when>
			</c:choose>
			<sec:authorize access="hasRole('ROLE_SUPER')">
				<input type="button" value="답변하기" id="forget">
			</sec:authorize>
			</div>


			</table>
	</form>


	<script>
	function updateAdmin_go(){
		document.formm.method = "POST";
		document.formm.action = "<%=request.getContextPath()%>" + "/admin/updateAdmin?admin_seq="+"${adminVO.admin_seq}";
		document.formm.submit();
	}
	
	function adminlist_go(){
		document.formm.action = "<%=request.getContextPath()%>" + "/admin/adminQnaList";
		document.formm.submit();
		
	}
	
	function update_go(){
		document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaUpdate?qna_seq="+"${qnaVO.qseq}";
		document.formm.submit();
	}
	
	function deleteAdmin_go(){
		alert('게시글을 삭제합니다.');
		document.formm.action = "<%=request.getContextPath()%>" + "/admin/deleteAdmin?admin_seq="+"${adminVO.admin_seq}";
		document.formm.submit();
	}
	

	    $(document).ready(function() {
		      $('#forget').click(function() {
		          $("#hiddenDiv").show();
		         })
			});
	///////////////////////////////////////
	   
	     $(function(){
		   
		$('#btn').click(function(){
		
			   $.ajax({
			       	url : "<%=request.getContextPath()%>/admin/nswerAdmin",
			       	type : "post",
			       	dataType:'text',
			       	data : ({
			       		content:$("textarea[name=email]").val(),
			       		 seqNum:${param.admin_seq}  }),
			       	success:function(data){
			       		document.getElementById("sss").innerHTML = data;
			       	}
			       	
			});
	   });
	   });
	   	 
 function qAnswer_go(){
	 $('#btn').click(function() {
         $("#hiddenDiv").hide();
         
        }) 
 }
	
</script>

</body>
</html>