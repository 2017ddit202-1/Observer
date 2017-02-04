<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>





<article>
	<br> <br>
	<div id="contract">
		<h2>자유게시판 상세보기</h2>
		<h4> FreeBoard WRITE</h4>
	</div>
	<form id="formm" name="formm" method="post">
	아이디:<input type="text" name="fb_id" value="${fbVO.fb_id}"><br>
	제목:<input type="text" name="fb_subject" value="${fbVO.fb_subject}"><br>
	내용:<textarea rows="5" cols="30" name="fb_content" id="fb_content">${fbVO.fb_content}</textarea><br>
	 <input type="hidden" name="fb_fbseq" value="${fbVO.fb_seq}" id="fb_fbseq">


		<button type="button" id="btnContactUs" onclick="fbList_go()">뒤로가기</button>
		<button type="button" id="btnContactUs" onclick="go_fbWrite()">수정하기</button>
		<button type="button" id="btnContactUs" onclick="go_fbDelete()">삭제하기</button>
		<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
		
		
		<div id="answer"></div>
		작성자 : ${loginUser}	<br/><br/>
		<textarea rows="8" cols="65" name="fbAns_content" id ="fbAns_content"></textarea><br>
			    <input type="hidden" name="fb_fbseq" value="${fb_seq}" id="fb_fbseq">
						
		<button type="button" id="btnFbAnswer" name="btnFbAnswer">댓글쓰기</button>


	</form>
	
</article>

<script>

function fbAnsWirteForm(){
	document.formm.action = "<%=request.getContextPath()%>/fbAns/fbAnsWriteForm";
	document.formm.submit();
}


function fbList_go(){
	document.formm.action = "<%=request.getContextPath()%>/fb/fbList";
	document.formm.submit();
}

function go_fbWrite(){
	document.formm.action = "<%=request.getContextPath()%>/fb/fbUpdate";
    document.formm.submit();
}
function go_fbDelete(){
	document.formm.action = "<%=request.getContextPath()%>/fb/fbDelete";
    document.formm.submit();
    
    
}
</script>

<script>
$(document).ready(function() {
	var fb_fbseq = $('#fb_fbseq').val();
	var data = {'fb_fbseq':fb_fbseq};
	$.ajax({
		url:'<%=request.getContextPath()%>/fbAns/fbAnsList',
		contentType:'application/json',
		dataType:'json',
		data:JSON.stringify(data),
		type:'post',
		success : function(data){
			$.each(data,function(i){
				var date = new Date(data[i].fbans_date)
				var year = date.getFullYear();
				var month = (1 + date.getMonth());
				month = month >= 10 ? month : '0' + month;
				var day = date.getDate();
				day = day >= 10? day:'0'+day;
				var fullDate = year + '년' + month + '월' + day + '일';
				var fbAnsList = '<div>ID : '
							  + data[i].fbans_id
							  + ' / ' + '작성날짜 : '
							  + fullDate + '<div> ->'
							  + data[i].fbans_content
							  +'</div></div><br><br>';
				$('div #answer').append(fbAnsList);			  
							  
			})
		}
	});
});
	$('#btnFbAnswer').on('click',function(){
		var fb_fbseq = $('#fb_fbseq').val();
		var fbAns_content = $('#fbAns_content').val();
		var data = {'fb_fbseq':fb_fbseq,'fbAns_content':fbAns_content};
			$.ajax({
				url:'<%=request.getContextPath()%>/fbAns/fbAnsWrite',
				data:JSON.stringify(data),
				type:'post',
				contentType:'application/json',
				success:function(data){
					 $('#fbAns_content').val('');
                     $('div #answer').empty();
					$.each(data,function(i){
						var date = new Date(data[i].fbans_date)
						var year = date.getFullYear();
						var month = (1 + date.getMonth());
						month = month >= 10 ? month : '0' + month;
						var day = date.getDate();
						day = day >= 10? day:'0'+day;
						var fullDate = year + '년' + month + '월' + day + '일';
						var fbAnsList = '<div>ID : '
									  + data[i].fbans_id
									  + ' / ' + '작성날짜 : '
									  + fullDate + '<div> ->'
									  + data[i].fbans_content
									  +'</div></div><br><br>';
						$('div #answer').append(fbAnsList);	
					})
				}
			});
	});
</script>

