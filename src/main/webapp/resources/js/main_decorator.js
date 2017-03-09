function get_msg(message){
	jQuery('#loginFail').text(message);
}

function login_go(){
    $.ajax({
       url : 'loginList',
       data : $('form input').serialize(),
       type : 'POST',
       dataType : 'json',
       beforeSend : function(xhr){
          xhr.setRequestHeader("Accept","application/json");
       }
    }).done(function(body){
       var message=body.response.message;
       var error=body.response.error;
       var returl=body.response.returl;
       if(error)
          get_msg(message);
       	  $('#login-form #mem_id').val("");
       	  $('#login-form #mem_pwd').val("");
       if(error==false){
          if(returl=='')
//             returl = '<c:url value="/server/serverMain" />';
        	returl = 'server/serverMain';
          location.href = returl;
       };
    });
 };
 
 $(function(){
	 $('#idBtn').click(function(){
		$.ajax({
			url : "idFind",
			type : "post",
			data : $('#register-form input').serialize(),
			success:function(data){
				$('#resultId').html('<span style="color:black;">'+data+'</span>');
				$('#register-form #mem_nm').val("");
				$('#register-form #mem_email').val("");
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	 });
 });

 $(function(){
	$('#pwdBtn').click(function(){
		$.ajax({
			url : 'pwdFind',
			type : "post",
			data : $('#lost-form input').serialize(),
			success:function(resultEmail){
				$('#resultPwd').text(resultEmail);
				$('#lost-form #mem_id').val("");
				$('#lost-form #mem_email').val("");
			},
		});
	}); 
 });
 
 $('.btn-link').click(function(){
	 $('#loginFail').empty();
	 $('#resultPwd').empty();
	 $('#resultId').empty();
	 $('#login-form #mem_id').val("");
     $('#login-form #mem_pwd').val("");
 });
 
 
