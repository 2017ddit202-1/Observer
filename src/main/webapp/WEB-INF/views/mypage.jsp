<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>



<br>
<br>


<div id="page-wrapper3">
<div class="container">
 
 <div class="media" style="margin-top: 4%;">
    <div class="media-left">
   <img src="<%=request.getContextPath()%>/resources/img/pay-per-click.png" class="media-object" style="width:60px;margin-left: 39%;">
    </div>
    <div class="media-body">
      <h4 class="media-heading" style="margin-left: 3%; margin-top: 14.5px;"><strong>MY PAGE</strong></h4>
      <p style="margin-left: 3%;">OBSERVER 회원의 정보를 관리하고, 권한 신청 / 회원 탈퇴를 할 수 있습니다.</p>
    </div>
  </div>
  <hr>
</div>

<br><br>





<!-- <style>
table {
    border: 2px solid white;
     height: 400px;
     margin: auto;
     text-align: center;
}

tr, td {
    border: 1px solid white;
    padding: 20px;
}
a{font-weight: bold;}
a:link {text-decoration: none; color: #333333;}
a:visited {text-decoration: none; color: #333333;}
a:active {text-decoration: none; color: #333333;}
a:hover {text-decoration: underline; color: red;}
</style>
 -->
 
 <style>
 table{
 width: 800px;
 text-align: center;
 margin: auto;
 } 
 
 #mypage_tr{
 border-top: 2px solid #a8a8a8;
 border-bottom: 2px solid #a8a8a8;
 height: 200px;
 }
 
 #mypage_td{
 border-right: 1px solid #ededed;
 }
 
  #mypage_td2{
 text-align: left;
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

<div style="margin-left: 18%; margin-top: -2%;">
&nbsp;안녕하세요! &nbsp; <span style="color: #6a91ba; font-weight: bold;">${loginUser }</span>님의 &nbsp; MyPage입니다.
</div>

<table>
<tr id="mypage_tr">
 <td id="mypage_td"><img src="<%=request.getContextPath()%>/resources/img/mypage_1.jpg"></td>
 <td id="mypage_td2" data-toggle="modal" data-target="#myModal1">
 
  <div style="cursor:pointer; font-size: 18px; font-weight: bold;">&nbsp;&nbsp;&nbsp;권한신청<br>&nbsp;&nbsp;&nbsp;<span style="font-size: 15px; color: #a3a3a3">권한을 신청하고, 승인여부를 확인할 수 있는 메뉴입니다.</span></div>
  
  </td>
 <!-- 권한신청모달 -->
   <div class="container" style="width: 200px;">

      <!-- Modal -->
      <div class="modal fade" id="myModal1" role="dialog">
         <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content" style="margin-top: 50%;">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">권한신청</h4>
               </div>
               <div class="modal-body" style="text-align: center;">

                  <!-- //////////////내용//////////////// -->

                  <c:choose>
                     <c:when test="${authority.atrt_admin_accept eq 'n'}">
                        <p>권한요청이 진행중입니다.</p>
                     </c:when>

                     <c:otherwise>

                        <p>현재 나의 권한은<span style="color: #6a91ba; font-weight: bold;">${positionList.posl_pos}</span>입니다.</p>


                        <c:choose>
                           <c:when test="${positionList.posl_pos eq 'ROLE_USER'}">

                              <p><span style="color: #6a91ba; font-weight: bold;">ADMIN</span>으로 변경합니다.</p>

                           </c:when>
                           <c:otherwise>
                              <p><span style="color: #6a91ba; font-weight: bold;">USER</span>로 변경합니다.</p>

                           </c:otherwise>

                        </c:choose>

                 <form name=formm>
                        <button class="btn btn-primary btn-sm" type="button" id="authorityBtn" onclick="autority_go()">신청하기</button>
                 </form>

                        <!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> 아작스-->

                        <script>
 function autority_go(){
	alert('신청하기 alert');
   document.formm.action="<%=request.getContextPath()%>/atrt/authorityReq";
   document.formm.submit();   
} 

</script>

                     </c:otherwise>

                  </c:choose>


               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
               </div>
            </div>

         </div>
      </div>

   </div>
 
 </tr>
 
 
 
<tr id="mypage_tr" onclick="document.location='<%=request.getContextPath()%>/user/update'">
 <td id="mypage_td"><img src="<%=request.getContextPath()%>/resources/img/mypage_2.jpg"></td>
 <td id="mypage_td2"><div style="cursor:pointer; font-size: 18px; font-weight: bold;">회원수정</div><div style="cursor:pointer;">회원가입 시 등록하셨던 정보를 수정/조회하실 수 있습니다.</div></td>
</tr>


<tr id="mypage_tr">
 <td id="mypage_td"><img src="<%=request.getContextPath()%>/resources/img/mypage_3.jpg"></td>
 <td id="mypage_td2" data-toggle="modal" data-target="#myModal"><div style="cursor:pointer; font-size: 18px; font-weight: bold;">회원탈퇴</div><div style="cursor:pointer;">한번 탈퇴하시면, 재가입이 불가합니다.</div></td>


<!-- 회원탈퇴모달 -->

   <div class="container" style="width: 200px;">


      <!-- Modal -->
      <div class="modal fade" id="myModal" role="dialog">
         <div class="modal-dialog">

            <!-- Modal content-->
             <div class="modal-content" style="margin-top: 50%;">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">회원탈퇴</h4>
               </div>
               <div class="modal-body">



                  <!-- //////////////내용//////////////// -->

                  <form id="formmm" name="formmm" method="post">
                     ID:<input type="text" id="mem_id" name="mem_id"
                        value="${loginUser}"><br> 
                        PWD:<input type="password" id="mem_pwd" name="mem_pwd"><br><br>
                     <button class="btn btn-primary btn-sm" type="button" id="DeleteBtn">탈퇴하기</button>
                    
                     <br> <span id="resultId"></span>
                     <!-- //데이터를 입력받기위한 스판태그 -->
                  </form>

  
                  <script src="http://code.jquery.com/jquery-latest.min.js"></script>

                  <script>
<%-- function memberDelete(){
   document.formm.action="<%=request.getContextPath()%>/user/memberDelete";
   document.formm.submit();   
}  --%>

$(function(){
   $('#DeleteBtn').click(function(){
	 /*   var id = $('#mem_id').val();
	   alert(id); */
      $.ajax({
         url : "<%=request.getContextPath()%>/user/memberDelete",
         type : "post",
         data : $('#formmm input').serialize(),
          success:function(data){
            if(data=="0"){ //일치하지 않으면
               $('#resultId').text('비밀번호가 일치하지 않습니다.')
            }else{
               alert('탈퇴완료되었습니다.')
               location.href="<%=request.getContextPath()%>/index";
            }
         },
         error:function(request,status,error){
             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
      });
      
   });
});



</script>

               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
               </div>
            </div>

         </div>
      </div>

   </div>


</tr>


</table>






</div>


















<%-- 

<table>
  <tr> 
    <td onmouseover="this.style.background='#fffff3'" 
          onmouseout="this.style.background='#ffffff'"  
bgColor=#ffffff align="center"> 
<img src="<%=request.getContextPath()%>/resources/img/contract.png">


<!-- 권한신청모달 -->
   <div class="container" style="width: 200px;">

      <a data-toggle="modal" data-target="#myModal1">권한신청</a>

      <!-- Modal -->
      <div class="modal fade" id="myModal1" role="dialog">
         <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">권한신청</h4>
               </div>
               <div class="modal-body">

                  <!-- //////////////내용//////////////// -->

                  <c:choose>
                     <c:when test="${authority.atrt_admin_accept eq 'n'}">
                        <p>권한요청이 진행중입니다.</p>
                     </c:when>

                     <c:otherwise>

                        <p>현재 나의 권한은${positionList.posl_pos}입니다.</p>


                        <c:choose>
                           <c:when test="${positionList.posl_pos eq 'ROLE_USER'}">

                              <p>ADMIN으로 변경합니다.</p>

                           </c:when>
                           <c:otherwise>
                              <p>USER로 변경합니다.</p>

                           </c:otherwise>

                        </c:choose>

                        <button type="button" id="authorityBtn" onclick="autority_go()">신청하기</button>


                        <!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> 아작스-->

                        <script>
 function autority_go(){
	alert('신청하기 alert');
   document.formm.action="<%=request.getContextPath()%>/atrt/authorityReq";
   document.formm.submit();   
} 

</script>

                     </c:otherwise>

                  </c:choose>


               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
               </div>
            </div>

         </div>
      </div>

   </div>
</td>

   <td style="background-color: #f7f7f7" align="center" width="200px"><p style="font-size: 16px; font-weight: bold; color: #919191" >회원탈퇴</p><p style="color: #b5b5b5; font-size: 11px;"> 아래의 회원탈퇴 버튼을 누르면 회원 탈퇴처리</p><img src="<%=request.getContextPath()%>/resources/img/down-arrow.png"></td>

 <td onmouseover="this.style.background='#fffff6'" 
          onmouseout="this.style.background='#ffffff'" width="200px"
bgColor=#ffffff align="center" ><img src="<%=request.getContextPath()%>/resources/img/id-card.png"><br><font size="2"><a href="<%=request.getContextPath()%>/user/update">회원수정</a></font></td>
  </tr>
  
    <tr> 
    <td style="background-color: #f7f7f7" width="200px"></td>

   <td onmouseover="this.style.background='#fffff6'" 
          onmouseout="this.style.background='#ffffff'"  
bgColor=#ffffff align="center">
<img src="<%=request.getContextPath()%>/resources/img/id-card.png">
<!-- 회원탈퇴모달 -->

   <div class="container" style="width: 200px;">

      <a data-toggle="modal" data-target="#myModal">회원탈퇴</a>

      <!-- Modal -->
      <div class="modal fade" id="myModal" role="dialog">
         <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">회원탈퇴</h4>
               </div>
               <div class="modal-body">



                  <!-- //////////////내용//////////////// -->

                  <form id="formm" name="formm" method="post">
                     ID:<input type="text" id="mem_id" name="mem_id"
                        value="${loginUser}"><br> PWD:<input
                        type="password" id="mem_pwd" name="mem_pwd"><br>
                     <button type="button" id="DeleteBtn" onclick="memberDelete()">탈퇴하기</button>
                     <br> <span id="resultId"></span>
                     <!-- //데이터를 입력받기위한 스판태그 -->
                  </form>


                  <script src="http://code.jquery.com/jquery-latest.min.js"></script>

                  <script>
function memberDelete(){
   document.formm.action="<%=request.getContextPath()%>/user/memberDelete";
   document.formm.submit();   
}

$(function(){
   $('#DeleteBtn').click(function(){
      $.ajax({
         url : "<%=request.getContextPath()%>/user/memberDelete",
         type : "post",
         data : $('#formm input').serialize(),
          success:function(data){
            if(data=="0"){ //일치하지 않으면
               $('#resultId').text('비밀번호가 일치하지 않습니다.')
            }else{
               alert('탈퇴완료되었습니다.')
               location.href="<%=request.getContextPath()%>/index";
            }
         },
      });
      
   });
});



</script>

               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
               </div>
            </div>

         </div>
      </div>

   </div></td>

 <td style="background-color: #f7f7f7" width="200px"></td>
  </tr>
  
  
</table> --%>

</body>