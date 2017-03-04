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
#detail_table_tr{
height: 50px;
border-top: 1px solid #c3ced9;
border-bottom: 1px solid #c3ced9;
text-align: center;
}
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
<%-- 					 <sec:authorize access="hasRole('ROLE_SUPER')">
							<li><a href="#">관리</a></li>
						</sec:authorize>
						
					3	hasRole()         ==        1개
						hasAnyRole        ==        2개
						isAuthenticated() ==        모두
 --%>


</head>
<body>
<br><br>
<div id="page-wrapper3" class="in">

<br> <br>
	<div style="text-align: center;">
		<h2>QnA 상세보기</h2>
		<h4> QnA Detail</h4>
		각종 안내, 서비스 또는 OBSERVER의 소식 버전안내 등의 정보를 확인할 수 있습니다.
	</div>
	<br><br><br>
	

	
<form id="formm" name="formm" method="post">
<table style="width: 1000px;" align="center">

<tr id="detail_table_tr">
<td style="background-color: #e4eaf2; width: 90px; border-top: 1px solid #c3ced9;">제목</td>
<td><input type="text" name="qna_subject" value="${qnaVO.qna_subject}" style="border: none; outline: none; width: 300px; text-align:center;"></td>
<td></td>
<td></td>
</tr>

<tr id="detail_table_tr">
<td style="background-color: #e4eaf2; border-top: 1px solid #c3ced9;">작성자</td>
<td>${qnaVO.qna_id}</td>


<td style="background-color: #e4eaf2; width: 90px; border-top: 1px solid #c3ced9;">등록일</td>
<td style="border-top: 1px solid #c3ced9;"><fmt:formatDate value="${qnaVO.qna_date}" type="date" /></td>
</tr>


</table>
<div style="text-align: center;">
<textarea name="qna_content" style="border:0; overflow-y:hidden; background:clear; resize: none; width: 1000px; height: 200px; outline: none;">${qnaVO.qna_content}</textarea>
</div>

<!-- // -->




		<table style="width: 1000px;" align="center">
				<c:if test="${qansVO.qans_qseq != null }">
					<tr id="detail_table_tr">
						<td style="background-color: #e4eaf2; border-top: 1px solid #c3ced9; width: 90px;">답변 내용</td>
						<td><div id="sss">${qansVO.qans_content}</div></td>
					</tr>
				</c:if>
		</table>
		<br>


		<!--  -->
		<div class="container" id="hiddenDiv" style="display: none">
			<form>
				<div class="form-group">
				
				<table style="width: 1000px;" align="center">
					<tr id="detail_table_tr">
						<td style="background-color: #e4eaf2; border-top: 1px solid #c3ced9; width: 90px;">답변 내용</td>
						<td><textarea rows="10" cols="100" name="textArea"
						placeholder="답변 내용 작성하기" style="width: 901px; border:0; overflow-y:hidden; background:clear; resize: none; height: 200px; outline: none;"></textarea></td>
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
<br>
		<div id="buttons" style="text-align: center;">
			<input type="button" class="btn btn-default" value="목록보기" class="submit" onclick="list_go()">
			<c:choose>
				<c:when test="${loginUserVO.mem_id eq qnaVO.qna_id}">
				<input type="button" class="btn btn-default" value="수정" class="submit"
				onclick="modify_go()">
					<input type="button" class="btn btn-default" value="삭제" class="submit"
						onclick="delete_go()">
				</c:when>
				<c:when
					test="${loginUserVO.mem_group_lice eq qnaWriterVO.mem_group_lice}">
							
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPER')">
						<input type="button" class="btn btn-default" value="답변하기" id="forget">
					</sec:authorize>
				</c:when>
				
				
				<c:when
					test="${loginUserVO.mem_id == 'SUADMIN1'}">
							
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPER')">
						<input type="button" value="답변하기" id="forget" class="btn btn-default">
					</sec:authorize>
				</c:when>
			</c:choose>
			</div>


	
	</form>
</div>


<!-- ///////////////////////////////////////////////////////////////////////////////// -->


	<script>
	function modify_go(){
		document.formm.method = "POST";
		document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaModify?qna_seq="+"${qnaVO.qseq}";
		document.formm.submit();
	}
	
	function list_go(){
		document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaList?qna_seq="+"${qnaVO.qseq}";
		document.formm.submit();
		
	}
	
	function update_go(){
		document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaUpdate?qna_seq="+"${qnaVO.qseq}";
		document.formm.submit();
	}
	
	function delete_go(){
		alert('게시글을 삭제합니다.');
		document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaDelete?qna_seq="+"${qnaVO.qseq}";
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
			       	url : "<%=request.getContextPath()%>/qna/qAnswer",
			       	type : "post",
			       	dataType:'text',
			       	data : ({
			       		content:$("textarea[name=textArea]").val(),
			       		seqNum:${param.qna_qseq} }),
			       	success:function(data){
			       		document.getElementById("sss").innerHTML = data;
			       		$('#hiddenDiv2').show();
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