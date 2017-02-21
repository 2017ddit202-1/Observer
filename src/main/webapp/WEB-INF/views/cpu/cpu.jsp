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
      <input type="button" id="btnZxc" class="btnZxc" value="30분" onclick="vv()">
      <input type="button" id="btntotal" class="btnAsd" value="1시간" onclick="ss()">
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
      <table border="1">
      <tr><th><div id="container"></div></th></tr>
      </table>
      <table border="1">
      <tr><th><div id="container2"></div></th></tr>
      </table>
       <table border="1">
      <tr><th><div id="container3"></div></th></tr>
      </table>
   </form>
</body>
</html>