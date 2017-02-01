<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>update page</h1>

	 <form name="formm" method="post">
    <table id="notice">
      <tr>
              <th>제목</th>
              <td>${qnaVO.qna_subject}</td> 
              
              작성자 : <td>${qnaVO.qna_id}</td> 
              
      </tr>
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${qnaVO.qna_date}" type="date"/></td>
      </tr>
      <tr>
        <th>질문내용</th>
        <td>${qnaVO.qna_content} 
      </tr>
      <tr>
        <th>답변 내용</th>
          
      </tr>
    </table>
    <div class="clear"></div>
     <div id="buttons" style="float:right">
      <input type="button"  value="수정"     class="submit"  onclick="location.href='/qna/qnaList.do'"> 
      <input type="button"  value="취소"  class="cancel"  onclick="location.href='/main/index.do'">  
      </div>
    </form>
	



</body>
</html>