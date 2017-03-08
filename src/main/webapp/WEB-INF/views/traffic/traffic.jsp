<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="<%=request.getContextPath()%>/resources/css/cpu.css"rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/traffic.js"></script>
</head>
<body onload="myFunction()" style="margin:0;">
   <br /><br /><br /><br /><br /><br />
   <br /><br /><br /><br /><br /><br />
   <form id="formm" name="formm">
   <div id="btnHo">
   <br>
      <input type="button" id="btnZxc" class="btn btn-default" value="30분" onclick="vv()">
      <input type="button" id="btntotal" class="btn btn-default" value="1시간" onclick="ss()">
      </div>
      <div id="loader"><img id="lodingImg" src="<%=request.getContextPath() %>/resources/img/loader.gif"></div>
        <div id="page-wrapper00" class="in">
     	<table>
     		<tr>
     			<th id="card">네트워크 카드</th>
     		</tr>
     		<tr>
     			<td id="net"></td>
     		</tr>	
     	</table>
     </div>	
      <div id="page-wrapper88" class="in">
     <div id="container"></div>
     </div>
     <div id="page-wrapper99" class="in">
     <div id="container2"></div>
     </div>
   </form>
</body>
</html>