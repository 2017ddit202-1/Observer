<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="<%=request.getContextPath()%>/resources/css/cpu.css"rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/cpu.js"></script>
</head>
<body onload="myFunction()" style="margin:0;">
   <br /><br /><br /><br /><br /><br />
   <br /><br /><br /><br /><br /><br />
   <form id="formm" name="formm">
   	<div id="btnHo">
      <input type="button" id="btnZxc" class="btn btn-default" value="30분" onclick="vv()">
      <input type="button" id="btntotal" class="btn btn-default" value="1시간" onclick="ss()">
     </div> 
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
      <div id="page-wrapper8" class="in">
     <div id="container"></div>
      </div>
     <div id="page-wrapper9" class="in">
     <div id="container2"></div>
      </div>
     <div id="page-wrapper0" class="in">
     <div id="container3"></div>
      </div>
     
   </form>
</body>
</html>