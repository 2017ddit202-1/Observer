   function go_save() {
   
      if (document.formm.mem_id.value == "") {
          alert("아이디를 입력하여 주세요.");
          document.formm.mem_id.focus();
        } else if (document.formm.mem_id.value != document.formm.mem_id.value) {
          alert("중복확인을 클릭하여 주세요.");
          document.formm.mem_id.focus();
        } else if (document.formm.mem_pwd.value == "") {
          alert("비밀번호를 입력해 주세요.");
          document.formm.mem_pwd.focus();
        } else if (document.formm.mem_pwd.value != document.formm.mem_pwd2.value) {
          alert("비밀번호가 일치하지 않습니다.");
          document.formm.mem_pwd2.focus();
        } else if (document.formm.mem_nm.value == "") {
          alert("이름을 입력해 주세요.");
          document.formm.mem_name.focus();
        } else if (document.formm.mem_email.value == "") {
          alert("이메일을 입력해 주세요.");
          document.formm.mem_email.focus();
        }else if (document.formm.mem_phone.value == "") {
        	alert("핸드폰번호를 입력해 주세요");
        	document.formm.mem_phone.focus();
        }else if(document.formm.check1.checked==false ||document.formm.check2.checked==false){
           alert("약관에 동의해 주세요.");
        } 
        else {
          document.formm.action = "join";
          document.formm.submit();
        }
      
   }

   function idcheck() {
      if (document.formm.mem_id.value == "") {
         alert('아이디를 입력하여 주십시오.');
         document.formm.mem_id.focus();
         return;
      }
      var url = "idCheckForm?mem_id=" + document.formm.mem_id.value;
      window
            .open(url, "_blank_1",
                  "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=200");

   }
   
   
   
   function checkDepulicateId() {
	 
	   
		$.ajax({
 
					url : "joinKeyUp",
					type : "post",
					data : $("#formm").serialize(),
					success : function(data) {
			
						if (data == "Exit") {
							document.getElementById("idCheck").innerHTML = "* 이미 회원이 존재합니다.";
						} else {
							if ($("#fn").val().length < 6) {
								document.getElementById("idCheck").innerHTML = "* 아이디를 6자 이상 입력해주세요.";
							} else if($("#fn").val().length >8){
								document.getElementById("idCheck").innerHTML = "* 아이디를 8자 이하로 입력해주세요.";
							}else {
								document.getElementById("idCheck").innerHTML = "";
							}
						}
					},
					error : function(error) {

					}
				});
	}
   
   function nameCheck(){
	   
		   var input = $("#id_mem").val();
		   alert(input);
	   
	   alert('탄다요');
	   /*var nameCheck = document.getElementsByName('mem_nm')[0].value;*/
	 /*  var input = $("#mem_nm").value();

	  
	   alert(input);*/
	   
	   if(nameCheck.length < 3){
		   document.getElementById("nameCheck").innerHTML = "* 아이디를 6자 이상 입력해주세요.";
	   }
   }

   

