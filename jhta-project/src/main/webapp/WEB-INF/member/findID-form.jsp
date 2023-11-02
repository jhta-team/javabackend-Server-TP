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
	}
});
$("#email").on("keyup",function(){
	  if(emailCheck()){
		  $("#invalid-feedbackEmail").hide();
	  }
})

</script>
<%@include file="../include/footer.jsp" %>