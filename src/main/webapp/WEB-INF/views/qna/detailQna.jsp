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

<script>
	function list_go(){
		document.formm.action = "<%=request.getContextPath()%>" + "/qna/qnaList";
		document.formm.submit();
		
	}

</script>


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
              <td>${qnaVO.subject}</td>
               
      </tr>
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
      </tr>
      <tr>
        <th>질문내용</th>
        <td>${qnaVO.content} 
      </tr>
      <tr>
        <th>답변 내용</th>
        <td>${qnaVO.reply}  
      </tr>
    </table>
    <div class="clear"></div>
     <div id="buttons" style="float:right">
     	 <sec:authorize access="hasRole('ROLE_SUPER')">
      <input type="button"  value="목록보기"     class="submit"  onclick="list_go()"> 
       </sec:authorize>
      </div>
    </form>

</body>
</html>