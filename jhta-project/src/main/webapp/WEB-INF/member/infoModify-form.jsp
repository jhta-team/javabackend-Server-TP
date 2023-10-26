<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

    <div class="container">
      <form action="../member/infoModifyUpdate" method="post" class="" name="member"
         enctype="multipart/form-data">
            <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="profile" class="form-label">Profile</label>
              <input type="file" class="form-control" id="profile" name="profile" 
              placeholder="png jpg" name="profile" value="${infoModifyMember.profile }" />     
            </div>
             	 <div class="preview">
             	 <img  src="/javabackend-Server-TP${pageContext.request.contextPath}/upload/${infoModifyMember.profile}">
             	 </div>
          		</div>
          </div>
        <div class="row d-flex justify-content-center mt-5">
          <div class="col-6">
            <div class="mb-3">
            	<label for="userID" class="form-label">아이디</label>
              <input type="text" class="form-control" id="userID" 
              placeholder="user ID" name="userID" value="${loggedID}" readonly/>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userPW" class="form-label">password</label>
              <input type="password" class="form-control" id="userPW" placeholder="user password" name="userPW" 
              value="${infoModifyMember.userPW}" readonly/>
               <button class="btn btn-primary" id="btnPasswordCheck">비밀번호 변경</button>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userName" class="form-label">이름</label>
              <input type="text" class="form-control" id="userName" 
              placeholder="user name" name="userName" value="${infoModifyMember.userName }" />
            </div>
          </div>
        </div>
          <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="nickName" class="form-label">닉네임</label>
              <input type="text" class="form-control" id="nickName" 
              placeholder="user nickName" name="nickName" value="${infoModifyMember.nickName }" readonly/>
              <button id="btnNickName" class="btn btn-primary">닉네임 변경</button>
              <button id="btnNickNameCheck" class="btn btn-primary" disabled>닉네임 중복확인</button>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="postCode" class="form-label">postCode</label>
              <input type="text" class="form-control" id="postCode" 
              placeholder="post code" name="postCode" value="${infoModifyMember.postCode }"/>
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
              <input type="text" class="form-control" id="address" 
              name="address" placeholder="address" value="${infoModifyMember.address }"/>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="detailAddress" class="form-label">Detail Address</label>
              <input type="text" class="form-control" id="detailAddress" placeholder="detail address" name="detailAddress"
              value="${infoModifyMember.detailAddress }" />
            </div>
          </div>
        </div>
           <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="email" class="form-label">이메일</label>
              <input type="email" class="form-control" id="email" 
              name="email" placeholder="email" value="${infoModifyMember.email }"/>
              <div class="invalid-feedback" id="invalid-feedbackEmail">글자 써보기</div>
            </div>
          </div>
        </div>
          <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="mobile" class="form-label">통신사</label>
              
				<select id="mobile" class="form-control" name="mobileTelcom" >
    				<option id="telcom" value="untitled">통신사 선택</option> 
    				<option id="telcom" value="LG" <c:if test="${infoModifyMember.mobileTelcom eq 'LG' }"> selected</c:if>>LGU+</option>
    				<option id="telcom" value="SKT"<c:if test="${infoModifyMember.mobileTelcom eq 'SKT' }"> selected</c:if>>SKT</option>
    				<option id="telcom" value="KT" <c:if test="${infoModifyMember.mobileTelcom eq 'KT' }"> selected</c:if>>KT</option>
    				<option id="telcom" value="alLG" <c:if test="${infoModifyMember.mobileTelcom eq 'alLG' }"> selected</c:if>>알뜰폰 LG</option>
    				<option id="telcom" value="alSKT" <c:if test="${infoModifyMember.mobileTelcom eq 'alSKT' }"> selected</c:if>>알뜰폰 SKT</option>
    				<option id="telcom" value="alKT" <c:if test="${infoModifyMember.mobileTelcom eq 'alKT' }"> selected</c:if>>알뜰폰 KT</option>
				</select>        
              
            </div>
          </div>
        </div>
          <div class="row d-flex justify-content-center">
          <div class="col-6">
           <div class="mb-3">
              <label for="tel" class="form-label">전화 번호</label>
              <div class="d-flex flex-row mb-3 gap-1" id="tel">
              <input type="text" maxlength="3" class="form-control tel01" id="tel01" placeholder="tel" name="tel01" value="${tel01 }" />
              <h2>-</h2>
              <input type="text" maxlength="4" class="form-control tel01" id="tel02" name="tel02" value="${tel02 }"/>
              <h2>-</h2>
              <input type="text" maxlength="4" class="form-control tel01" id="tel03" name="tel03" value="${tel03 }"/>
              </div>
            <div class="invalid-feedback" id="invalid-feedbackTel">글자 써보기</div> 
            </div>
          </div>
        </div>
        <div class="mt-5 mb-5 d-flex justify-content-center">
          <div class="">
            <button type="submit" class="btn btn-primary" id="btnSubmit">정보변경</button>
            <a href="javascript:history.back();" class="btn btn-secondary">취소</a>
          </div>
        </div>
      </form>
    </div>

    <script> 
    $("#btnSubmit").on("click", function(){
    	const check = confirm("정보 변경하시겠습니까?")
    	if(check){
    		return true;
    	}else{
    		return false;
    	}
    })
    //비밀번호 변경 확인
    $("#btnPasswordCheck").on("click",function(){
    	const userpw = confirm("비밀번호를 변경하시겠습니까?")
    	if(userpw){
    		$("#userPW").attr("readonly",false);
    		$("#userPW").val("");
    		$("#userPW").focus();
    	}
    	return false;
    })
    //글을 작성할 때 이메일 형식 맞는지 확인 
     function emailCheck(){
    	    	let emailPattern = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
    	    	let email = $("#email").val().trim();
    	    	if(emailPattern.test(email)){
    	    		return true;
    	    	}
    	    	$("#email").focus();
    	    	return false;
    	    }
    $("#email").on("keyup",function(){
    	if(!emailCheck()){
    		$(".invalid-feedback").show();
    		$(".invalid-feedback").text("이메일 형식에 맞지 않습니다.");
    	}else{
    		$(".invalid-feedback").hide();
    		$(".invalid-feedback").text("");
    	}
    })
    
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
      
      //닉네임 변경확인-------------------------------------//
      $("#btnNickName").on("click",function(){
    	  const nickName = confirm("닉네임을 변경하시겠습니까?")
    	  if(nickName){
    		  $("#nickName").attr("readonly",false);
        	  $("#nickName").focus();
        	  $("#btnNickNameCheck").attr("disabled",false)
    	  }
    	  return false;
      });
      //  닉네임 중복확인
      $("#btnNickNameCheck").on("click", function(){
    	  $.ajax({
    		  url:"../member/nickNameCheck",
    		  data:{nickName:$("#nickName").val()},
    		  success : function(data){
    			  console.log(data);
    			  if(data.count>0){
    				  alert("닉네임이 그대로입니다.");
    				  $("#nickName").val();
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
    </script>
<%@ include file="../include/footer.jsp" %>