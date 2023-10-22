<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
	<div class="container">
		<h2 class="mb-5 mt-5">코디 게시</h2>
		<table class="table list">
		  <thead>
		    <tr>
		      <th scope="col">no</th>
		      <th scope="col">title</th>
		      <th scope="col">date</th>
		      <th scope="col">hit</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${codyBoardList }" var="codyBoard" varStatus="status">
		    <tr>
		      <td>${codyBoard.no }</td>
		      <td>
		      
		      	<a href="../codyboard/findone?no=${codyBoard.no}">${codyBoard.title }</a>
		      </td>
		      <td>${codyBoard.regDate }</td>
		      <td>${codyBoard.hit }</td>		      
		    </tr>
		    </c:forEach>
		    
		  </tbody>
		</table>
		
		<form action="../board/list" >
			<input type="text" name="keyword">
			<select name="category">
				<option value="writer">작성자</option>
				<option value=""></option>
				<option value="">작성자</option>
				
			</select>
		</form>
		
		<div class="d-flex justify-content-center mt- mb-5">
			<c:forEach var="i" begin="1" end="${codyBoardPage }">
				<p><a href="../codyboard/page-nation?page=${i}" class="link-danger">${i}</a></p>
			</c:forEach>
		</div>
			
		<div class="d-flex justify-content-center mt-3 mb-3">
			<a href="../board/write" class="btn btn-primary">글쓰기</a>
		</div>
	</div>
	
	
<%@ include file="../include/footer.jsp" %>







    