<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<%=request.getContextPath()%>/resources/js/summary.js"></script>
<meta charset="UTF-8">
<style>
   .chart{
      width: 30%;
       height: 335px;
       display: inline-block;
       margin-left: 10%;
   }
   #summaryTb{
          width: 15%;
             margin-left: 9%;
   }
   #page-wrapper6{
      text-align:center;
       position: inherit;
       margin: 0 0 0 250px;
       padding: 65px 30px;
        box-shadow: 5px 5px 5px lightgray;
        border-radius: 10px; 
       padding: 0 15px;
       background-color: white;
       margin-left: 2%;
       width: 630px;
       height: 305px;
       margin-bottom: 1.5%;
}
#container{
margin-left:8%;
}
#loader {
   position: absolute; 
   left: 50%; 
   top: 50%; 
   z-index: 1; 
   width: 150px; 
   height: 150px; 
   margin: -75px 0 0 -75px; 
}
</style>
<article>

   <h1>요약 페이지</h1>
   <form id="formm" name="formm">
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
   </form>
<div id="serverInfo"></div>
<div id="container"></div>
</article>