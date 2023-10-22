<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.1.min.js"></script>
<script src="../js/bootstrap.bundle.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="../css/layout.css">

</head>
<body>
<header class="p-3 text-bg-dark">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
          <li><a href="../product/list" class="nav-link px-2 text-white">상품게시판</a></li>
          <li><a href="../product/insert" class="nav-link px-2 text-white">상품등록</a></li>
          <li><a href="../codyboard/insert" class="nav-link px-2 text-white">코디등록</a></li>
          <li><a href="../codyboard/page-nation" class="nav-link px-2 text-white">코디게시판보기</a></li>
          <li><a href="#" class="nav-link px-2 text-white">About</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
        </form>
		<c:choose>
		<c:when test="${loggedName ==null }">
			<div class="text-end">
         	 <button type="button" class="btn btn-outline-light me-2" onclick="location.href='../member/login'">Login</button>
         	 <button type="button" class="btn btn-warning" onclick="location.href='../member/insert'" >Sign-up</button>
        	</div>
		</c:when>
		<c:otherwise>
			<div class="text-end">
         	 <button type="button" class="btn btn-outline-light me-2" onclick="location.href='../member/info'">${loggedName}</button>
         	 <button type="button" class="btn btn-warning" onclick="location.href='../member/logout'" >Logout</button>
        	</div>
		</c:otherwise>
		</c:choose>
      
      </div>
    </div>
  </header>
  <main class="main">
  
  
  
  
  
  
  
  