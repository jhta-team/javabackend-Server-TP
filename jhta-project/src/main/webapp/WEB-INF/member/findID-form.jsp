<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<main class="form-signin w-100 m-auto">
 <form class="row g-3" action="../member/findID-process" method="post">
  <div class="col-auto">
    <label for="email" >이메일</label>
    <input type="email" class="form-control" id="email" 
              placeholder="e-mail" name="email" />
                <div class="invalid-feedback" id="invalid-feedbackEmail">글자 써보기</div>
  </div>
  <div class="col-auto">
   	<label for="userName" class="form-label">이름</label>
              	<input type="text" class="form-control" 
              	id="userName" placeholder="user name" name="userName" />
              	<div class="invalid-feedback" id="invalid-feedbackName">글자 써보기</div>
              	</div>
  <div class="col-auto">
    <button type="submit" class="btn btn-primary mb-3" id="findID">아이디 찾기</button>
  </div>
  <div class="col-auto">
    <a href="javascript:history.back();" class="btn btn-secondary">취소</a>
  </div>
</form>
</main>
<script type="text/javascript">
function badWordCheck(){
	  reset_alert_count();
	  let compareText = $("#userName").val();
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
function nameReplace(){
	  let text = $("#userName").val().trim();
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
	  let nickname01 =$("#userName").val().trim();
	  if(badWordRegex.test(nickname01)  ){
			return true;
		}
		
	 		return false;
}

function userNameCheck(){
		let userNameRegex = /^[가-힣]{3,6}$/;
		//  한글 3~6자리 
		
		let username =$("#userName").val().trim();
		if(userNameRegex.test(username)  ){
			return true;
		}
		
	 		return false;
	  }
function emailCheck(){
	let emailPattern = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	let email = $("#email").val().trim();
	if(emailPattern.test(email)){
		
		return true;
	}
	$("#email").focus();
	return false;
}
$("#findID").on("click",function(){
	if(!emailCheck()){
		alert("이메일 형식에 맞지않습니다.")
		$("#email").val("");
		$("#email").focus();
		$("#invalid-feedbackEmail").show();
		$("#invalid-feedbackEmail").text("이메일을 입력해주세요");
		return false;
	}else if($("#userName").val().trim()==""){
		$("#userName").val("");
        $("#userName").focus();
        $("#invalid-feedbackName").show();
        $("#invalid-feedbackName").text("이름을 입력해주세요");
        return false; 
	}else if(!userNameCheck()){
		$("#userName").val("");
        $("#userName").focus();
        return false; 
	}else if(badWordCheck()){
		$("#userName").val("");
        $("#userName").focus();
        return false; 
	}
});
$("#email").on("keyup",function(){
	  if(emailCheck()){
		  $("#invalid-feedbackEmail").hide();
	  }
})
 $("#userName").on("keyup",function(){
	 if(badWordCheck()){
		 $("#userName").val(nameReplace())
	 }else{
		 if(badWord()){
 			  $("#invalid-feedbackName").show();
 	          $("#invalid-feedbackName").text("비속어는 안됩니다.");
		 }else{		 
    	  		if(userNameCheck()){
    	  		$("#invalid-feedbackName").hide();   		  
    	  		}else{
    		  	$("#invalid-feedbackName").show(); 
    		  	$("#invalid-feedbackName").text("3~6자리 한글만 작성하세요"); 
    	  		}
		 }
	 }
	 
      })
 
</script>
<%@include file="../include/footer.jsp" %>