<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div class="container">
<table class="table striped">
  <tbody>
  <c:choose>
  <c:when test="${not empty infoMember.profile || infoMember.profile!=null}">
  	 <tr>
      <th scope="row">프로필</th>
      <td><img src="/javabackend-Server-TP${pageContext.request.contextPath}/upload/${infoMember.profile }" class="profile"></td>    			
    </tr>
  </c:when>
  <c:otherwise>
  	<tr>
      <th scope="row">프로필</th>
      <td><img src="../upload/user.png" class="profile"></td>    			
    </tr>
  </c:otherwise>
  </c:choose>
  <tr>
   <th scope="row">등급</th>
      <td>
      <c:if test="${infoMember.adminNumber ==0 }"><img src="../upload/normal.png">일반</c:if>
      <c:if test="${infoMember.adminNumber ==2 }"><img src="../upload/silver.png">실버</c:if>
      <c:if test="${infoMember.adminNumber ==3 }"><img src="../upload/gold.png">골드</c:if>
      <c:if test="${infoMember.adminNumber ==4 }"><img src="../upload/platinum.png">플레티넘</c:if>
      <c:if test="${infoMember.adminNumber ==5 }"><img src="../upload/diamond.png">다이아몬드</c:if>
      <c:if test="${infoMember.adminNumber ==1 }"><p>관리자</p> </c:if>
      </td> 
    </tr>
    <tr>
      <th scope="row">아이디</th>
      <td>${infoMember.userID}</td> 
    </tr>
    <tr>
      <th scope="row">비밀번호</th>
      <td>${passwordBlur}</td>  
    </tr>
    <tr>
      <th scope="row">이름</th>
      <td colspan="2">${loggedName}</td>
    </tr>
    <tr>
      <th scope="row">닉네임</th>
      <td colspan="2">${infoMember.nickName}</td>
    </tr>
      <tr>
      <th scope="row">postcode</th>
      <td colspan="2">${infoMember.postCode}</td>
    </tr>
      <tr>
      <th scope="row">address</th>
      <td colspan="2">${infoMember.address} / ${infoMember.detailAddress }</td>
    </tr>
    <tr>
      <th scope="row">이메일</th>
      <td colspan="2">${infoMember.email}</td>
    </tr>
    <tr>
      <th scope="row">전화번호</th>
      <td colspan="2">${infoMember.mobileTelcom} / ${infoMember.tel}</td>
    </tr>
  </tbody>
</table>
<div class=""d-flex justify-content-center>
	<a href="../member/delete" class="btn btn-primary">회원탈퇴</a>
	<a href="../member/infoModify" class="btn btn-secondary">정보수정</a>
</div>
   </div>
<%@ include file="../include/footer.jsp" %>