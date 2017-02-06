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
		
		<div id = "test"></div>
		<div id="answer"></div>
		작성자 : ${loginUser}	<br/><br/>
		<textarea rows="8" cols="65" name="fbAns_content" id ="fbAns_content"></textarea><br>
			    <input type="hidden" name="fb_fbseq" value="${fb_seq}" id="fb_fbseq">
<%-- 			    <input type="hidden" name="fbAns_seq" value="${ }" --%>
						
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
function fbAnsCancle_go(){
	
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
				var fullDate = year + '-' + month + '-' + day;
				var fbAnsList = '<div id = "'+data[i].fbans_seq+'">ID : '
							  + data[i].fbans_id
							  + '&nbsp;&nbsp;&nbsp/&nbsp;&nbsp;&nbsp;'
							  + '<span id="'+data[i].fbans_seq+'span">'
							  + fullDate
							  + '</span>'
							  + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
							  + '<a href="" id="'
							  + data[i].fbans_seq
							  + '"class="nn" name="nn">수정</a>'
							  + '&nbsp;&nbsp;&nbsp;'
							  + '<a href="" id="'
							  + data[i].fbans_seq
							  + '"class="mm" name="mm">삭제</a>'
							  + '<div class="'
							  + data[i].fbans_seq
							  + '">'
							  + data[i].fbans_content
							  +'</div></div><br>';
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
						var fullDate = year + '-' + month + '-' + day;
						var fbAnsList = '<div id = "'+data[i].fbans_seq+'">ID : '
										  + data[i].fbans_id
										  + '&nbsp;&nbsp;&nbsp/&nbsp;&nbsp;&nbsp;' 
										  + fullDate
										  + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
										  + '<a href="" id="'
										  + data[i].fbans_seq
										  + '"class="nn" name="nn">수정</a>'
										  + '&nbsp;&nbsp;&nbsp;'
										  + '<a href="" id="'
										  + data[i].fbans_seq
										  + '"class="mm" name="mm">삭제</a>'
										  + '<div class="'
										  + data[i].fbans_seq
										  + '">'
										  + data[i].fbans_content
										  +'</div></div><br>';
									  
									  
						$('div #answer').append(fbAnsList);	
					})
				}
			});
	});
	
	$(document).on('click','.mm',function(e){
		e.preventDefault();
		var result = $(this).attr('id');
		$.ajax({
			url:"<%=request.getContextPath()%>/fbAns/fbAnsDelete",
			data: {"result" : result},
			dataType:'json',
			type:'post',
			success:function(fbMap){
				fbAnsMap = jQuery.map(fbMap , function(a){
					return a;
				})
				$('#'+fbAnsMap).remove();
			}
		});
	});
	
	$(document).on('click','.nn',function(e){
		e.preventDefault();
		var result = $(this).attr('id');
		var reContent = document.getElementsByClassName(result);
		$.ajax({
			url:"<%=request.getContextPath()%>/fbAns/fbAnsUpdateForm",
			data:{'result':result},
			dataType:'json',
			type:'post',
			success:function(fbMap){
				fbAnsMap = jQuery.map(fbMap , function(a){
					return a;
				})
				$('.'+fbAnsMap).html(
					'<textarea id="fbAnsUp" name="fbAnsUp">'
					+ reContent[0].innerHTML
					+'</textarea>'
					+'<button type="button" id="'+result+'" class="fbAnsModify">확인</button>'
					+'<button type="button" id="'+result+'" class="fbAnsCancle">취소</button>'
				);
			}
		});
	})
	$(document).on('click','.fbAnsModify',function(e){
		e.preventDefault();
		var result = $(this).attr('id');
		var fbAnsUp = $('#fbAnsUp').val();
		var data = {'fbAnsUp':fbAnsUp,'result':result};
		$.ajax({
			url:"<%=request.getContextPath()%>/fbAns/fbAnsUpdate",
			data: data,
			type:'post',
			success:function(fbAnsUp){
				var date = new Date(fbAnsUp.fbans_date);
				var year = date.getFullYear();
				var month = (1 + date.getMonth());
				month = month >= 10 ? month : '0' + month;
				var day = date.getDate();
				day = day >= 10? day:'0'+day;
				var fullDate = year + '-' + month + '-' + day;
				
				$('#fbAnsUp').val('');
				$('.'+fbAnsMap).empty();
				$('#'+result+'span').text(fullDate);
				
				$('.'+fbAnsMap).html(
					fbAnsUp.fbans_content		
				);
			}
		})
	})
	
	$(document).on('click','.fbAnsCancle',function(e){
		e.preventDefault();
		var fbAnsCancle = $('#fbAnsUp').val();
		$('.'+fbAnsMap).empty();
		$('.'+fbAnsMap).html(fbAnsCancle);
	})
	
	
</script>


