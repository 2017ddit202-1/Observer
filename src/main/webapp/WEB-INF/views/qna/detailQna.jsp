<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


<%-- 					 <sec:authorize access="hasRole('ROLE_SUPER')">
							<li><a href="#">관리</a></li>
						</sec:authorize>
						
					3	hasRole()         ==        1개
						hasAnyRole        ==        2개
						isAuthenticated() ==        모두
 --%>


</head>
<body>
<h1>detail page</h1>
 <h2> 1:1 고객 게시판 </h2>
      <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>    
    <form name="formm" method="post">
    <table id="notice">
      <tr>
              <th>제목</th>
              <td>${qnaVO.qna_subject}</td>
      </tr>
      작성자 : ${qnaVO.qna_id}
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${qnaVO.qna_date}" type="date"/></td>
      </tr>
      <tr>
        <th>질문내용</th>
        <td>${qnaVO.qna_content} .${qnaVO.qna_id}, ${loginUserVO.mem_id}
      </tr>
    <!--  -->
      <tr>
        <th>답변 내용</th>
        <td><div id="sss">  </div></td>
      </tr>
      
      <!--  --> 
    </table>
    
<!--  -->
	<div class="container" id="hiddenDiv" style="display: none">
         <form>
            <div class="form-group">
               <label for="email">답변내용:</label> 
            <!--    <input type="textarea"
                  class="form-control" id="email" placeholder="Enter answer">
             -->
             <textarea rows="10" cols="100" name="email" placeholder="Enter answer"></textarea>
            </div>
            <button type="button" id="btn" class="btn btn-default btn-block" onclick="qAnswer_go()">
               답변등록</button>
         </form>
      </div>
<!--  -->

    <div class="clear"></div>
    
     <div id="buttons" style="float:right">
     <input type="button"  value="목록보기"   class="submit"  onclick="list_go()">
      <c:choose>
      <c:when test="${loginUserVO.mem_id eq qnaVO.qna_id}"> 
      <input type="button"  value="수정"   class="submit"  onclick="list_go()"> 
      <input type="button"  value="삭제"   class="submit"  onclick="list_go()">
      </c:when> 
	  <c:when test="${loginUserVO.mem_group_lice eq qnaWriterVO.mem_group_lice}"> 
     <sec:authorize access="hasRole('ROLE_ADMIN')"> 
      <input type="button"  value="답변하기" id="forget" > 
      </sec:authorize>
    	</c:when>
    </c:choose>
      
    
       
      </div>
    </form>
<script>
	function list_go(){
		document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaList?qna_seq="+"${qnaVO.qseq}";
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
			       		content:$("textarea[name=email]").val(),
			       		seqNum:${param.qna_qseq}
			       	}),
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