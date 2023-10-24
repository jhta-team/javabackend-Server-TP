<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<main class="form-signin w-100 m-auto">
 <form class="row g-3" action="../member/infoModify-process" method="post">
  <div class="col-auto">
    <label for="userID" >아이디</label>
    <input type="text" readonly class="form-control-plaintext" name="userID" id="userID" value="${loggedID}">
  </div>
  <div class="col-auto">
    <label for="inputPassword2" >Password</label>
    <input type="password" class="form-control" id="userPW" name="userPW" placeholder="Password">
  </div>
  <div class="col-auto">
    <button type="submit" class="btn btn-primary mb-3">비밀번호 확인</button>
  </div>
  <div class="col-auto">
    <a href="javascript:history.back();" class="btn btn-secondary">취소</a>
  </div>
</form>
</main>
<%@include file="../include/footer.jsp" %>