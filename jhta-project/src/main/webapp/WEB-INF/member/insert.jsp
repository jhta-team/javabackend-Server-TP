<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    <div class="container">
    	<%-- <h1>${pageContext.request.contextPath }</h1>
    	<h1>${request.contextPath }</h1> --%>
      <form action="../member/insert-process" method="post" class="" 
      name="member" id="joinform" enctype="multipart/form-data">  <!-- <form  -->
      								<!--방식은 post, 이미지나 파일을 받기 위해서 -->
        <div class="row d-flex justify-content-center mt-5">
          <div class="col-6">
            <div class="mb-3">
              <label for="userID" class="form-label">ID</label>
              <input type="text" class="form-control" id="userID" placeholder="user id" name="userID" />
              <button class="btn btn-primary" id="btnIDCheck" disabled>아이디 중복 확인</button>
              <div class="invalid-feedback" id="invalid-feedbackID">글자 써보기</div>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userPW" class="form-label">password</label>
              <input type="password" class="form-control" id="userPW" placeholder="user password" name="userPW" />
              <div class="invalid-feedback" id="invalid-feedbackPW01">글자 써보기</div>
               <button class="btn btn-primary" id="btnShowPassword">비밀번호 보기</button>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userPW02" class="form-label">password Confirm</label>
              <input type="password" class="form-control" id="userPW02" placeholder="user password" />
              <div class="invalid-feedback" id="invalid-feedbackPW02">글자 써보기</div>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              	<label for="userName" class="form-label">Name</label>
              	<input type="text" class="form-control" id="userName" 
              	maxlength="4" placeholder="user name" name="userName" />
			  	<div class="invalid-feedback" id="invalid-feedbackName">글자 써보기</div>            
            </div>
          </div>
        </div>
          <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="nickName" class="form-label">NickName</label>
              <input type="text" class="form-control" id="nickName" 
              placeholder="nick name" maxlength="5" name="nickName" />
			   <button class="btn btn-primary" id="btnNickNameCheck">닉네임 중복확인</button>
			   <div class="invalid-feedback" id="invalid-feedbackNickName">글자 써보기</div>            
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="gender" class="form-label">Gender</label>
              <div class="" >
               <label for="gender" class="form-label">남자</label>
               <input type="radio" name="gender" class="gender" id="gender" value="1"/>
               <label for="gender" class="form-label">여자</label>
               <input type="radio" name="gender" class="gender" id="gender" value="2"/>
               <div class="invalid-feedback" id="invalid-feedbackGender">글자 써보기</div>
              </div>             
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="postCode" class="form-label">우편번호</label>
              <input type="text" class="form-control" id="postCode" placeholder="post code" name="postCode" />
              <div>
                <button class="btn btn-primary mt-3" id="btnPostcode">우편번호 확인</button>
              </div>
              <div class="invalid-feedback" id="invalid-feedbackPost">글자 써보기</div>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="address" class="form-label">주소</label>
              <input type="text" class="form-control" id="address" name="address" placeholder="address" />
              <div class="invalid-feedback" id="invalid-feedbackAddress">글자 써보기</div>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="detailAddress" class="form-label">상세 주소</label>
              <input type="text" class="form-control" id="detailAddress" placeholder="detail address" name="detailAddress" />
              <div class="invalid-feedback" id="invalid-feedbackDetail">글자 써보기</div>
            </div>
          </div>
        </div>
        
         <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="email" class="form-label">이메일</label>
              <input type="email" class="form-control" id="email" 
              placeholder="e-mail" name="email" />
              <button id="sendEmail" class="btn btn-primary mt-3 sendEmail">인증메일 보내기</button>
               <div class="invalid-feedback" id="invalid-feedbackEmail">글자 써보기</div>
            </div>
            <div class="mb-3">
            <input type="text" id="checkNum" class="form-control" placeholder="인증번호" name="checkNum" 
            disabled>
            <button id="btnCheck" class="btn btn-primary mt-3 btnCheck">인증번호 확인</button>
            <div class="invalid-feedback" id="invalid-feedbackcheckNum">글자 써보기</div>
            </div>
          </div>
        </div>
       
        
         <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="mobile" class="form-label">통신사</label>
				<select id="mobile" class="form-control" name="mobileTelcom">
    				<option id="telcom" value="untitled" selected>통신사 선택</option> 
    				<option id="telcom" value="LG">LGU+</option>
    				<option id="telcom" value="SKT">SKT</option>
    				<option id="telcom" value="KT" >KT</option>
    				<option id="telcom" value="alLG" >알뜰폰 LG</option>
    				<option id="telcom" value="alSKT" >알뜰폰 SKT</option>
    				<option id="telcom" value="alKT" >알뜰폰 KT</option>
				</select>
				<div class="invalid-feedback" id="invalid-feedbackMobile">글자 써보기</div>        
            </div>
          </div>
        </div>
           <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="tel" class="form-label">전화 번호</label>
              <div class="d-flex flex-row mb-3 gap-1" id="tel">
              <input type="text" maxlength="3" class="form-control tel01" id="tel01" placeholder="tel" name="tel01" />
              <h2>-</h2>
              <input type="text" maxlength="4" class="form-control tel01" id="tel02" name="tel02" />
              <h2>-</h2>
              <input type="text" maxlength="4" class="form-control tel01" id="tel03" name="tel03" />
              </div>
            <div class="invalid-feedback" id="invalid-feedbackTel">글자 써보기</div> 
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="profile" class="form-label">프로필</label>
              <input type="file" class="form-control" id="profile" placeholder="png,jpg"
               name="profile" accept=".jpg,.png,.gif,.jpeg" />
            </div>
            <div class="preview"></div>
          </div>
        </div>
       
        <div class="mt-5 mb-5 d-flex justify-content-center">
          <div class="">
            <button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
            <button type="reset" class="btn btn-secondary">취소</button>
          </div>
        </div>
      </form>
    </div>

    <script> 
    	let isIDCheck=false;
    	let isNickNameCheck=false;
    	let isEmailCheck=false;
    	let isPhoneCheck=false;
    	let isPassWordCheck=false;
    	let isNickNameFormCheck=false;
  		var emailCode = "";
  	  
    	  function emailCheck(){
    	    	let emailPattern = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
    	    	let email = $("#email").val().trim();
    	    	if(emailPattern.test(email)){
    	    		
    	    		return true;
    	    	}
    	    	$("#email").focus();
    	    	return false;
    	    }
    	    $("#sendEmail").on("click",function(){
    	    	if(!emailCheck()){
    	    		alert("이메일 형식에 맞지않습니다.")
    	    		return false;
    	    	}
    	    $.ajax({
    	    	url:"../member/sendEmail",
    	    	type:"POST",
    	    	data:{email:$("#email").val()},
    	    	success:function(data){
    	    		console.log("data : " + data.checkNum);
    	    		$("#checkNum").attr('disabled',false)
    	    		emailCode = data.checkNum;
    	    		alert("인증번호가 발송되었습니다.");
    	    	}
    	    });		
    	    	return false;
    	    })
    	   $("#btnCheck").on("click",function(){
    		   if($("#checkNum").val() != emailCode){
    			   alert("인증번호가 다릅니다. 다시 입력해주세요");
    			   $("#checkNum").val("");
    			   $("#checkNum").focus();
    		   }else{
    			   if($("#checkNum").val()==""){
    				   alert("공란입니다. 이메일 인증을 받으세요");
    				   $("#checkNum").focus();
    			   }else{
    				   alert("인증번호 확인 되었습니다.");
        			   $("#checkNum").attr("readonly",true);
        			   isEmailCheck=true;
    			   } 
    		   }
    		   return false;
    	   }) 
    	   //회원가입 클릭시 
      $("#btnSubmit").on("click", function (e) {   //document.querySelector
        if ($("#userID").val().trim() === "") {    // val: value, trim : 공백
          $("#userID").val("");
          $("#userID").focus();
          $("#invalid-feedbackID").show();
          $("#invalid-feedbackID").text("아이디를 입력해주세요");
          return false;
        }else if ($("#userPW").val().trim() === "") {
          alert("password는 필수입력 사항입니다.");
          $("#userPW").val("");
          $("#userPW").focus();
          $("#invalid-feedbackPW01").show();
          $("#invalid-feedbackPW01").text("비밀번호를 입력해주세요");
          return false;
        }else if ($("#userPW02").val().trim() === "") {
          alert("password 확인");
          $("#userPW02").val("");
          $("#userPW02").focus();
          $("#invalid-feedbackPW02").show();
          $("#invalid-feedbackPW02").text("비밀번호를 입력해주세요");
          return false;
        }else if ($("#userName").val().trim() === "") {
            $("#userName").val("");
            $("#userName").focus();
            $("#invalid-feedbackName").show();
            $("#invalid-feedbackName").text("이름을 입력해주세요");
            return false;          
        }else if ($("#nickName").val().trim() === "") {
            $("#nickName").val("");
            $("#nickName").focus();
            $("#invalid-feedbackNickName").show();
            $("#invalid-feedbackNickName").text("닉네임을 입력해주세요");
            return false;          
        }else if($("input[name='gender']:checked").val()!= 1 && $("input[name='gender']:checked").val()!= 2 ){
        	$("#gender").focus();
        	$("#invalid-feedbackGender").show();
            $("#invalid-feedbackGender").text("성별을 선택해주세요");
            return false;  
        }else if ($("#postCode").val().trim() === "") {
            $("#postCode").val("");
            $("#postCode").focus();
            $("#invalid-feedbackPost").show();
            $("#invalid-feedbackPost").text("우편번호 입력해주세요");
            return false;          
        }else if ($("#address").val().trim() === "") {
            $("#address").val("");
            $("#address").focus();
            $("#invalid-feedbackAddress").show();
            $("#invalid-feedbackAddress").text("주소를 입력해주세요");
            return false;          
        }else if ($("#detailAddress").val().trim() === "") {
            $("#detailAddress").val("");
            $("#detailAddress").focus();
            $("#invalid-feedbackDetail").show();
            $("#invalid-feedbackDetail").text("상세 주소를 입력해주세요");
            return false;          
        }else if ($("#email").val().trim() === "") {
            $("#email").val("");
            $("#email").focus();
            $("#invalid-feedbackEmail").show();
            $("#invalid-feedbackEmail").text("이메일을 입력해주세요");
            return false;          
        }else if (!emailCheck()) {
            $("#email").focus();
            $("#invalid-feedbackEmail").show();
            $("#invalid-feedbackEmail").text("이메일을 입력해주세요");
            return false;
        }else if ($("#checkNum").val().trim() === "") {
            $("#checkNum").val("");
            $("#checkNum").focus();
            $("#invalid-feedbackcheckNum").show();
            $("#invalid-feedbackcheckNum").text("인증번호를 입력해주세요");
            return false;          
        }else if ($("#mobile").val().trim() == "untitled") {
            $("#mobile").focus();
            $("#invalid-feedbackMobile").show();
            $("#invalid-feedbackMobile").text("통신사를 선택해주세요");
            return false;          
        }else if(!isPhoneCheck){
       	 alert("핸드폰 번호 확인해주세요");
    	 return false;
    	}else if(!isEmailCheck){
       	 alert("인증번호 확인을 해주세요");
    	 return false;
    	}else if(!isIDCheck){
        	 alert("아이디 중복 체크해주세요");
        	 return false;
        }else if(!isPassWordCheck){
       	 alert("비밀번호 확인해주세요");
    	 return false;
    }else if(!isNickNameCheck){
       	 	alert("닉네임 중복 체크해주세요");
    	 	return false;
    }else if(!isNickNameFormCheck){
       	 alert("닉네임 형식이 맞지 않습니다.");
    	 return false;
    }
      });
    	    
    	//  아이디 5자리 이상의 정규화
   	  function IDcheck(){
   		let IDRegex = /^[a-z][a-z0-9_.]{4,19}$/;
   		let userid =$("#userID").val().trim();
   		if(IDRegex.test(userid)){
   			return true;
   		}
   	 		return false;
   	  }
      $("#userID").on("keyup" , function(){
    	  if(IDcheck()){
    		  $("#invalid-feedbackID").hide();
    		  $("#btnIDCheck").attr("disabled",false);
    	  }else{
    		  $("#invalid-feedbackID").show(); 
    		  $("#invalid-feedbackID").text("아이디 형식에 맞지 않습니다.");
    		  $("#btnIDCheck").attr("disabled",true);
    		  
    	  }
    	  
      })
      $("#userID").on("click" , function(){
    	  if(IDcheck()){
    		  $("#invalid-feedbackID").hide(); }
    	  else{
    	  $("#invalid-feedbackID").show(); 
		  $("#invalid-feedbackID").text("최소 다섯자리이상의 아이디가 필요합니다.");     		  
    	  }
    	  return false;
      })
      // 비밀번호 정규화
       function PassWordcheck(){
   		let PWRegex = /^(?=.*[a-z])(?=.*\d)(?=.*[@#$!%^&*?])[A-Za-z\d@#$!%^&*?]{8,16}$/;
   		//  소문자와 특수문자는 필요하고 8자리이상인 비밀번호
   		let userpw =$("#userPW").val().trim();
   		if(PWRegex.test(userpw)){
   			return true;
   		}
   	 		return false;
   	  }
      $("#userPW").on("keyup" , function(){
    	  if(PassWordcheck()){
    		  $("#invalid-feedbackPW01").hide();
    		  isPassWordCheck= true;
    	  }else{
    		  $("#invalid-feedbackPW01").show();
    		  $("#invalid-feedbackPW01").text("8~16자리며 특수문자와 숫자가 적어도 하나 이상 포함되어야 합니다.");
    	  }
    	  
      })
      $("#userPW02").on("keyup", function () {    //id는 # , class는 .
        if ($("#userPW").val() !== $("#userPW02").val()) {
          $("#invalid-feedbackPW02").show();
          $("#invalid-feedbackPW02").text("password가 맞지 않습니다.");
        } else {
          $("#invalid-feedbackPW02").hide(); 
        }
      });
      $("#userName").on("keyup",function(){
    	  if(userNameCheck()){
    	  $("#invalid-feedbackName").hide();   		  
    	  }else{
    		  $("#invalid-feedbackName").show(); 
    		  $("#invalid-feedbackName").text("3~6자리 한글만 작성하세요"); 
    	  }
      })
       //  나쁜말 체크
      function badWordCheck(){
    	  reset_alert_count();
    	  let compareText = $("#nickName").val();
    	  for(let i =0; i<swear_words_arr.length; i++){
    		  for(let j =0;j<compareText.length; j++){
    			  if(swear_words_arr[i] == compareText.substring(j,(j+swear_words_arr[i].length)).toLowerCase()){
    				  swear_alert_arr[swear_alert_count] = compareText.substring(j, (j + swear_words_arr[i].length));
    		            swear_alert_count++;
    		            return true;
    			  }
    		  }
    	  }
    	  var alert_text = "";
    	   for (var k = 1; k <= swear_alert_count; k++) {
    	      alert_text += "\\n" + "(" + k + ")  " + swear_alert_arr[k - 1];
    	   }
    	   return false;
      }
      //나쁜말 "*"로 대체한다.
      function nickNameReplace(){
    	  let text = $("#nickName").val().trim();
    	  let replacesub = "*";
    	  for(let i =0;i<text.length;i++){
    		  let sub = replacesub.repeat(text.length)
    		  text = text.replace(text,sub)
    	  }
    	  return text;
      }
      //나쁜말 대체된 *을 포함하면 리턴값으로 true를 가진다.
      function badWord(){
    	  let badWordRegex = /^(?=.*[*])[가-힣@#$!%^&*?]{1,18}$/;
    	  let nickname01 =$("#nickName").val().trim();
    	  if(badWordRegex.test(nickname01)  ){
     			return true;
     		}
     		
     	 		return false;
      }
       function nickNameCheck(){
   		let nickNameRegex = /^[가-힣]{3,6}$/;
   		//  소문자와 특수문자는 필요하고 8자리이상인 비밀번호
   		
   		let nickname =$("#nickName").val().trim();
   		if(nickNameRegex.test(nickname)  ){
   			return true;
   		}
   		
   	 		return false;
   	  }
       function userNameCheck(){
      		let userNameRegex = /^[가-힣]{3,6}$/;
      		//  소문자와 특수문자는 필요하고 8자리이상인 비밀번호
      		
      		let username =$("#userName").val().trim();
      		if(userNameRegex.test(username)  ){
      			return true;
      		}
      		
      	 		return false;
      	  }
      $("#nickName").on("keyup",function(){
    	 if(badWordCheck()){
             $("#nickName").val(nickNameReplace())
    	 }else{
    		 if(badWord()){
      			  $("#invalid-feedbackNickName").show();
      	          $("#invalid-feedbackNickName").text("비속어는 안됩니다.");
    		 }else{		 
    	  			if(nickNameCheck()){
    		  		$("#invalid-feedbackNickName").hide();
    		  		isNickNameFormCheck=true;
    	  			}else{
    		  		$("#invalid-feedbackNickName").show();
              		$("#invalid-feedbackNickName").text("닉네임은 3~5 한글만 가능합니다.");  
    	  			}
    		 	}
    	 	}
      })
      
      $("input[name='gender']").on("change",function(){
    	  if($("input[name='gender']:checked").val()==1 || $("input[name='gender']:checked").val()==2)
    	  $(".invalid-feedback").hide();
      })
      $("#detailAddress").on("keyup",function(){
    	  $("#invalid-feedbackDetail").hide();
      })
      $("#email").on("keyup",function(){
    	  if(emailCheck()){
    		  $("#invalid-feedbackEmail").hide();
    	  }
      })
	 
      $("#mobile").on("change",function(){
    	  if($("#mobile").val()!="untitled"){
    		 $(".invalid-feedback").hide();
    	  }
      })
     
      //핸드폰 정규식을 이용한 형식체크
      function phoneCheck(){
    	  let phonRegex01 = /^01([0|1|6|7|8|9])$/;
    	  let phonRegex02 = /^([0-9]{3,4})$/;
    	  let phonRegex03 = /^([0-9]{4})$/;
    	  let tel01 =$("#tel01").val().trim();
    	  let tel02 =$("#tel02").val().trim();
    	  let tel03 =$("#tel03").val().trim();
    	  if(phonRegex01.test(tel01) && phonRegex02.test(tel02) && phonRegex03.test(tel03)){
    		  return true;
    	  }
    	  return false;
      };
      $("#tel01").on("keyup",function(){
    	  if(phoneCheck()){
    		  $("#invalid-feedbackTel").hide();
    		  isPhoneCheck=true;
    	  }else{
    		  $("#invalid-feedbackTel").show();
    		  $("#invalid-feedbackTel").text("핸드폰번호를 입력해주세요")
    	  }
      })
      $("#tel02").on("keyup",function(){
    	  if(phoneCheck()){
    		  $("#invalid-feedbackTel").hide();
    		  isPhoneCheck=true;
    	  }else{
    		  $("#invalid-feedbackTel").show();
    		  $("#invalid-feedbackTel").text("핸드폰번호를 입력해주세요.")
    	  }
      })
      $("#tel03").on("keyup",function(){
    	  if(phoneCheck()){
    		  $("#invalid-feedbackTel").hide();
    		  isPhoneCheck=true;
    	  }else{
    		  $("#invalid-feedbackTel").show();
    		  $("#invalid-feedbackTel").text("핸드폰번호를 입력해주세요.")
    	  }
      })
    	
    
      $("#btnIDCheck").on("click", function(){
    	  $.ajax({
    		  url:"../member/idCheck",
    				  data:{userID:$("#userID").val()},
    				  //method:"get",
    				  success : function(data){
    						  if(data.count>0){
        						  alert("쓸 수 없는 아이디입니다.");
        						  $("#userID").val("");
        						  $("#userID").focus();
        					  }else{
        						  if($("#userID").val()!=""){
        						  const useID = confirm("쓸 수 있는 아이디입니다. 사용하시겠습니까?");        							  
        						  if(useID){
          					  		$("#userID").attr("readonly",false);
          					  		$("#btnIDCheck").attr("disabled",true);
          					  		isIDCheck = true;
          					  		}
        						  }else{
        							  alert("공란입니다. 다시입력해주세여");
        							  $("#userID").focus();
        						  }
        					  } 
    				  },
    				  complete : function(data){
    				  }
    	  });
    	  return false;
      });
      $("#btnNickNameCheck").on("click", function(){
    	  $.ajax({
    		  url:"../member/nickNameCheck",
    		  data:{nickName:$("#nickName").val()},
    		  success : function(data){
    			  console.log(data);
    			  if(data.count>0){
    				  alert("중복된 닉네임입니다.");
    				  $("#nickName").val("");
    				  $("#nickName").focus();
    			  }else{
    				  if($("#nickName").val()!=""){
    					  if(badWordCheck()){
    						  alert("비속어입니다. 이쁜말해주세요");
    						  $("#nickName").focus();
    						  $("#nickName").val("");
    					  }else{
    						  if(!nickNameCheck()){
    							  alert("닉네임 형식에 맞춰주세요");
        						  $("#nickName").focus();
        						  $("#nickName").val("");
    						  }else{  
    				  		const nickName = confirm("사용가능한 닉네입니다.")
    				 		 if(nickName){
    					     $("#nickName").attr("readonly",false);
    					     isNickNameCheck = true;
    				  			}
    						 }
    						  
    					  }
    			  		}else{
					  		alert("공란입니다 입려해주세요");
					  		$("#nickName").focus();
				  		}    		  
    		 		 }
    		  }
    	  });
    	  return false;
      })
      $("#btnShowPassword").on("click", function(){
    	  if($("#userPW").attr("type")==="password"){   //attr() 속성 값을 가져오거나 변경할 때
    		  $("#userPW").attr("type","text"); 
    		  $("#btnShowPassword").text("비밀번호 감추기");
    	  } else{
    		  $("#userPW").attr("type","password");
    		  $("#btnShowPassword").text("비밀번호 보기");
    	  }
    	  return false;
      });
      //이미지 미리보기
      $("#profile").on("change",function(e){
    	  const file = e.target.files[0];
    	  console.log(e.target.files);
    	  console.log(file.name);
    	  const ext = file.name.substring(file.name.lastIndexOf(".")+1);
    	  console.log(ext);
    	  if(!(ext==="png"||ext==="jpg"||ext==="gif")){
    		  alert("이미지 형식이 맞지 않습니다.");
    		  $("#profile").val("");
    		  return false;
    	  }
    	  const reader = new FileReader();
    	  reader.onload = function(e){
    		  $(".preview").html(`<img class="imgForm" src="\${e.target.result}">`);
    	  }
    	  reader.readAsDataURL(file);
      });
      // 우편주소 
      function postcode() {
        new daum.Postcode({
          oncomplete: function (data) {
         
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            const roadAddr = data.roadAddress; // 도로명 주소 변수
            const extraRoadAddr = ""; // 참고 항목 변수

          
            document.querySelector("#postCode").value = data.zonecode;
            document.querySelector("#address").value = roadAddr;
            
          },
        }).open();
      }

      $("#btnPostcode").on("click", function () {
        postcode();
        return false;
      });
      $("#postCode").on("click",function(){
    	  $("#invalid-feedbackPost").hide();
    	  postcode();
          return false; 
      })
       $("#address").on("click",function(){
    	  postcode();
          return false; 
      })
     $(".form-control").on("keyup", function() { 
    	 if (event.getModifierState("CapsLock")) {
    		 alert("Caps Lock이 켜져있습니다."); 
    		 $(this).val("");
    		  }
     });
     /*  $("#btnSubmitAjax").on("click",function(){
      	$.ajax({
      		url:"../member/insert-member-process.jsp",
      		data: $("#joinform").serialize(),// form 안에 있는 모든 데이터 값을 한번에 보낼 수 있는 장점이 있다.
      		         //serialize()중요함       //무조건 알아 두자!! 
      		success:function(response) {
      			alert("가입하셨습니다");
      			$(location).attr("href","../member/login.jsp"); //location을 이용한 주소이동
      			// == location.href="../member/login.jsp"
      			
      		},
      		fail:function(){
      			alert("서버오류입니다");
      			history.back();
      		}
      	});
      	return false;
      }); */
    </script>
<%@ include file="../include/footer.jsp" %>