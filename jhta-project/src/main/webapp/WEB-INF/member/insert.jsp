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
              <button class="btn btn-primary" id="btnIDCheck">아이디 중복 확인</button>
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
              <input type="text" class="form-control" id="userName" placeholder="user name" name="userName" />
            </div>
          </div>
        </div>
          <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="nickName" class="form-label">NickName</label>
              <input type="text" class="form-control" id="nickName" placeholder="nick name" name="nickName" />
			   <button class="btn btn-primary" id="btnNickNameCheck">닉네임 중복확인</button>            
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userName" class="form-label">Gender</label>
              <div class="" >
               <label for="userName" class="form-label">남자</label>
               <input type="radio" name="gender" value="1"/>
               <label for="userName" class="form-label">여자</label>
               <input type="radio" name="gender" value="2"/>
              </div>             
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="postCode" class="form-label">ZipCode</label>
              <input type="text" class="form-control" id="postCode" placeholder="post code" name="postCode" />
              <div>
                <button class="btn btn-primary mt-3" id="btnPostcode">우편번호 확인</button>
              </div>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="address" class="form-label">Address</label>
              <input type="text" class="form-control" id="address" name="address" placeholder="address" />
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="detailAddress" class="form-label">Detail Address</label>
              <input type="text" class="form-control" id="detailAddress" placeholder="detail address" name="detailAddress" />
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
            </div>
            <div class="mb-3">
            <input type="text" id="checkNum" class="form-control" placeholder="인증번호" name="checkNum" 
            disabled>
            <button id="btnCheck" class="btn btn-primary mt-3 btnCheck">인증번호 확인</button>
            </div>
          </div>
        </div>
        
        
         <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="mobile" class="form-label">통신사</label>
				<select id="mobile" class="form-control" name="mobileTelcom">
    				<option  id="telcom"value="untitled" selected>통신사 선택</option> 
    				<option id="telcom" value="LG">LGU+</option>
    				<option id="telcom" value="SKT">SKT</option>
    				<option id="telcom" value="KT" >KT</option>
    				<option id="telcom" value="alLG" >알뜰폰 LG</option>
    				<option id="telcom" value="alSKT" >알뜰폰 SKT</option>
    				<option id="telcom" value="alKT" >알뜰폰 KT</option>
				</select>        
            </div>
          </div>
        </div>
           <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="tel" class="form-label">전화 번호</label>
              <input type="text" class="form-control" id="tel" placeholder="tel" name="tel" />
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="profile" class="form-label">profile</label>
              <input type="file" class="form-control" id="profile" placeholder="png,jpg"
               name="profile" accept=".jpg,.png,.gif,.jpeg" />
            </div>
            <div class="preview"></div>
          </div>
        </div>
       
        <div class="mt-5 mb-5 d-flex justify-content-center">
          <div class="">
            <button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
            <button type="submit" class="btn btn-primary" id="btnSubmitAjax">Ajax회원가입</button>
            <button type="reset" class="btn btn-secondary">취소</button>
          </div>
        </div>
      </form>
    </div>

    <script> 
    	let isIDCheck=false;
    	let isNickNameCheck=false;
  		var emailCode = "";
  		
    	  function emailCheck(){
    	    	let emailPattern = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
    	    	let email = $("#email").val().trim();
    	    	if(emailPattern.test(email)){
    	    		return true;
    	    	}
    	    	alert("이메일 형식에 맞지않습니다.")
    	    	$("#email").focus();
    	    	return false;
    	    }
    	    $("#sendEmail").on("click",function(){
    	    	if(!emailCheck()){
    	    		return false;
    	    	}
    	    	console.log("dsa");
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
    			   } 
    		   }
    		   return false;
    	   }) 
    	   
      $("#btnSubmit").on("click", function (e) {   //document.querySelector
        if ($("#userID").val().trim() === "") {    // val: value, trim : 공백
          $("#userID").val("");
          $("#userID").focus();
          $("#invalid-feedbackID").show();
          $("#invalid-feedbackID").text("아이디를 입력해주세요");
          
        } if ($("#userPW").val().trim() === "") {
          alert("password는 필수입력 사항입니다.");
          $("#userPW").val("");
          $("#userPW").focus();
          $("#invalid-feedbackPW01").show();
          $("#invalid-feedbackPW01").text("비밀번호를 입력해주세요");
        
        } if ($("#userPW02").val().trim() === "") {
          alert("password 확인");
          $("#userPW02").val("");
          $("#userPW02").focus();
          $("#invalid-feedbackPW02").show();
          $("#invalid-feedbackPW02").text("비밀번호를 입력해주세요");
          return false;
        }else if ($("#userName").val().trim() === "") {
            $("#userPW02").val("");
            $("#userPW02").focus();
            $(".invalid-feedback").show();
            $(".invalid-feedback").text("이름을 입력해주세요");
            return false;          
        }else if(!isIDCheck){
        	 alert("아이디 중복 체크해주세요");
        	 return false;
        }else if(!isNickNameCheck){
       	 	alert("닉네임 중복 체크해주세요");
    	 	return false;
    }
      });
      $("#userID").on("keyup" , function(){
    	  $(".invalid-feedback").hide();
          $(".invalid-feedback").text(""); 
      })
      $("#userPW").on("keyup" , function(){
    	  $(".invalid-feedback").hide();
          $(".invalid-feedback").text(""); 
      })
      $("#userPW02").on("keyup", function () {    //id는 # , class는 .
        if ($("#userPW").val() !== $("#userPW02").val()) {
          $("#invalid-feedbackPW02").show();
          $("#invalid-feedbackPW02").text("password가 맞지 않습니다.");
        } else {
          $("#invalid-feedbackPW02").hide();
          $("#invalid-feedbackPW02").text(""); 
        }
      });
    
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
    				  const nickName = confirm("사용가능한 닉네입니다.")
    				  if(nickName){
    					  $("#nickName").attr("readonly",false);
    					  isNickNameCheck = true;
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
    		  $(".preview").html(`<img src="\${e.target.result}">`);
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
      $("#btnSubmitAjax").on("click",function(){
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
      });
    </script>
<%@ include file="../include/footer.jsp" %>