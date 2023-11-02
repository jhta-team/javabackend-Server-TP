<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<main class="form-signin w-100 m-auto">
 <form class="row g-3" action="../member/findPW-process" method="post">
  <div class="col-auto">
   		<label for="userID" class="form-label">ID</label>
        <input type="text" class="form-control" id="userID" placeholder="user id" name="userID" />
  </div>
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
    <button type="submit" class="btn btn-primary mb-3" id="findID">비밀번호 찾기</button>
  </div>
  <div class="col-auto">
    <a href="javascript:history.back();" class="btn btn-secondary">취소</a>
  </div>
</form>
</main>

<%@include file="../include/footer.jsp" %>