<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<div class="container">
		<h2 class="mb-5 mt-5">코디게시판</h2>
		<!-- write-process에 매핑되는 controller가 있어야함. -->
		<div class="container">
	<div class="row d-flex justify-content-center">
		<div class="col-10">
			<h2 class="mb-5 mt-5">코디보기</h2>
			<table class="table">
				<colgroup>
					<col style="width: 15%">
					<col style="width: 35%">
					<col style="width: 15%">
					<col style="width: 35%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><c:out value="${codyBoard.title }"></c:out></td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td colspan="3">${codyBoard.userID }</td>
						<th>좋아요</th>
						
					</tr>
					<tr>
						<th>날짜</th>
						<td>${codyBoard.regDate }</td>
						<th>조회수</th>
						<td>${codyBoard.hit }</td>
						
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3" class="content">${codyBoard.content } ${codyBoard.images }</td>
					</tr>
				</tbody>
			</table>
			
			<div>
				<span>이전글</span>
				<%-- <c:choose>
					<c:when test="${prevBoard.available > 0 }">
						<a href="../board/view?no=${prevBoard.no}&num=${prevBoard.num}">
							${prevBoard.title}
						</a>
					</c:when>
					<c:otherwise>
						<a href="../board/view?no=${prevBoard.no}&num=${prevBoard.num}">
							삭제된 글입니다.
						</a>
					</c:otherwise>
				</c:choose> --%>
				<a href="../board/view?no=${prevBoard.no}&num=${prevBoard.num}">
							${prevBoard.title}
						</a>
			</div>
			<div>
				<span>다음글</span>
				<a href="../board/view?no=${nextBoard.no}&num=${nextBoard.num}">
					${nextBoard.title}
				</a>
			</div>
			
			
			
			<div class="d-flex justify-content-center mt-5">
				<!-- loggedID null 이 아니고 loggedID 랑 board.id랑 같으면 -->
<!-- 				목록을 눌렀을때 뒤로 가는 방법을 찾아보자 뒤에 page번호 값을 줘서 다시 돌아가는 방법이나 바로 전 페이지로 가는방법 찾아보 --> 
				<a href="../codyboard/page-nation" class="btn btn-primary">목록</a>
				<a href="../board/reply?regroup=${viewBoard.regroup }&relevel=${viewBoard.relevel}&restep=${viewBoard.restep}" class="btn btn-primary mx-1">답글달기</a>
				<a href="../board/delete?no=${viewBoard.no }" class="btn btn-primary mx-1">좋아요</a>
				<!-- 여기는 로그인한 사람만 볼수있게 -->
				<a href="../codyboard/update?no=${codyBoard.no}" class="btn btn-primary mx-1">수정</a>
				<a href="../codyboard/delete?no=${codyBoard.no}" class="btn btn-danger mx-1">삭제</a>
			</div>

		</div>
	</div>
</div>
	</div>
	
<%@ include file="../include/footer.jsp" %>







    