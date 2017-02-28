<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script>
	function go_update(){
		
		document.formm.action = "<%=request.getContextPath()%>/user/update";
	    document.formm.submit();
	}
	
	function go_mypage(){
		
		document.formm.action = "<%=request.getContextPath()%>/user/mypage";
	    document.formm.submit();
	}
	
	</script> 
	
	<style>
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
    height: 700px;
}
</style>
	<br> <br>
	
	<div id="page-wrapper3" class="in">
	<div style="text-align: center;">

	<br><br><br>

<div style="margin-left: -63%;">회원정보 변경</div>
<table align="center" style="width: 1000px; background-color: #f6f7f2; height: 100px;">
<tr>
<td style="border-top: 2px solid #dbdbdb; text-align: left; color: #777873">&nbsp;&nbsp;회원정보 수정을 원하시면 아래의 내용들을 해당 정보의 수정입력을 부탁드립니다.<br>
&nbsp;&nbsp;OBSERVER는 회원님의 개인정보를 신중하게 보호하려 노력하고 있으면 회원님의 동의 없이는 기재하신 회원정보가 누락되지 않습니다. <br>
&nbsp;&nbsp;자세한 내용은 [개인정보취급방침]에서 확인하세요!
</td>
</tr>
</table>
<br>



<form id="formm" name="formm" method="post">
<table align="center" style="width: 800px; text-align: center;">
<tr style="height: 40px;">
<td style="background-color: #f7f7f7; border-top: 2px solid #525252;">ID:</td>
<td style="border-top: 2px solid #525252;"><input style="margin-left: -44%" type="text" name="mem_id" readonly="readonly" value="${loginUser.mem_id}">&nbsp;&nbsp;*아이디는 변경 불가합니다.</td>
</tr>

<tr style="height: 40px;">
<td style="background-color: #ebebeb; border-top: 1px solid #cccccc;">PASSWORD:</td>
<td style="border-top: 1px solid #cccccc;"><input style="margin-left: -30.3%" type="text" name="mem_pwd" value="${loginUser.mem_pwd}">&nbsp;&nbsp;*영문 숫자만 사용할 수 있습니다.(6~15자)</td>
</tr>

<tr style="height: 40px;">
<td style="background-color: #f7f7f7; border-top: 1px solid #cccccc;">NAME:</td>
<td style="border-top: 1px solid #cccccc;"><input style="margin-left: -70.5%" type="text" name="mem_nm" value="${loginUser.mem_nm}"></td>
</tr>

<tr style="height: 40px;">
<td style="background-color: #ebebeb; border-top: 1px solid #cccccc;">E-MAIL:</td>
<td style="border-top: 1px solid #cccccc;"><input  style="margin-left: -70.5%" type="text" name="mem_email" value="${loginUser.mem_email}"></td>
</tr>

<tr style="height: 40px; ">
<td style="background-color: #f7f7f7; border-top: 1px solid #cccccc; border-bottom: 1px solid #cccccc;">PHONE:</td>
<td style="border-top: 1px solid #cccccc; border-bottom: 1px solid #cccccc;"><input style="margin-left: -70.5%" type="text" name="mem_phone" value="${loginUser.mem_phone}"></td>
</tr>
</table>

<br>
 <input id="btnContactUs" class="btn btn-default" type="button" value="수정" class="submit" onclick="go_update(this.form)">
	<!--  <input type="button" value="뒤로가기" class="submit" onclick="history.go(-1);"> -->
	 <input id="btnContactUs" class="btn btn-default" type="button" value="뒤로가기" class="submit" onclick="go_mypage()"> 
</form>
</div>
</div>









	
