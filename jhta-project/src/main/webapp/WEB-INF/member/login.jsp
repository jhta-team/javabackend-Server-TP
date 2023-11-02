<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<main class="form-signin w-100 m-auto">
  <form action="../member/login-process" method="post">
    <h1 class="h3 mb-3 fw-normal">로그인</h1>
    <div class="form-floating">
      <input type="hidden" id="adminNumber" name="adminNumber">
      <input type="text" class="form-control" id="userID" placeholder="ID" name="userID" value="${cookie.cookieID.value }">
       
      <label for="userID">ID</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="userPW" placeholder="Password" name="userPW">
      <label for="userPW">Password</label>
    </div>
    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" name="check" value="1" id="check" 
       <c:if test="${cookie.cookieID.value !=null}">checked</c:if>>
       
      <label class="form-check-label" for="flexCheckDefault">
        Remember me
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
    <div class="d-flex justify-content-center w-100 py-2">
    <a class="btn btn-primary form-label findid px-3" href="../member/findID">아이디 찾기</a>
    <a class=" btn btn-primary form-label findpw px-3" href="../member/findPW">비밀번호 찾기</a>
    </div>
    
    <div class="login_util">
			<div>아직 회원이 아니신가요?</div>
			<div>지금 회원가입을 하시면<br>다양하고 특별한 혜택이 준비되어 있습니다.</div>
			<div ><a href="../member/insert">회원가입</a></div>
		</div>
		
    <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
  </form>
</main>
<%@include file="../include/footer.jsp" %>