	$('.hhh').on('click',function(){
		var a =$(this).attr('id');				
		var b = $('input[name="'+a+'"]').val();		
		$('#zone').text(a);
		$('#zone2').text(b);
	});
	$('#reportYes').on('click',function(){
		//아이디
		var ip = $('#zone').text();
		// 이메일		
		var email = $('#zone2').text();
		// ip & email Map으로 만듬
		var data = {"email":email,"ip":ip};
		$.ajax({
			url : "reportGo",
			type:'post',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType:'text',
			success:function(resultEmail){
				$('#zoneRe').hide();
				$('#zone2').html(resultEmail);
				$('#reportNoo').show();
				$('#reportNo').hide();
				$('#reportYes').hide();
			}
		});
	});
	
	$(function(){
		$('#reportNoo').on('click',function(){
			$.ajax({
				url:"reportList",
				type:'post',
				success:function(){
					$('#zoneRe').show();
					$('#reportNoo').hide();
					$('#reportNo').show();
					$('#reportYes').show();
				}
			});
		});
	});
	
