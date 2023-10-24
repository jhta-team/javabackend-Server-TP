<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<main class="form-signin w-100 m-auto">
  <form action="../member/login-process" method="post">
    <h1 class="h3 mb-3 fw-normal">로그인</h1>
    <div class="form-floating">
      <input type="text" class="form-control" id="userID" placeholder="ID" name="userID">
      <label for="userID">ID</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="userPW" placeholder="Password" name="userPW">
      <label for="userPW">Password</label>
    </div>
    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" name="check" value="1" id="flexCheckDefault">
      <label class="form-check-label" for="flexCheckDefault">
        Remember me
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
  </form>
</main>
<%@include file="../include/footer.jsp" %>