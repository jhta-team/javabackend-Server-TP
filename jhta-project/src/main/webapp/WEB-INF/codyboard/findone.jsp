<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
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
							<td colspan="3" class="content">${codyBoard.content }
								${codyBoard.images }</td>
						</tr>
					</tbody>
				</table>
				<div>
					<img src="/upload/${codyBoard.images }" alt="mdo">
				</div>

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
						${prevBoard.title} </a>
				</div>
				<div>
					<span>다음글 ${cbComment[0].no }</span> <a
						href="../board/view?no=${nextBoard.no}&num=${nextBoard.num}">
						${nextBoard.title} </a>
				</div>



				<div class="d-flex justify-content-center mt-5">
					<!-- loggedID null 이 아니고 loggedID 랑 board.id랑 같으면 -->
					<!-- 				목록을 눌렀을때 뒤로 가는 방법을 찾아보자 뒤에 page번호 값을 줘서 다시 돌아가는 방법이나 바로 전 페이지로 가는방법 찾아보 -->
					<a href="../codyboard/page-nation" class="btn btn-primary">목록</a> <a
						href="../board/reply?regroup=${viewBoard.regroup }&relevel=${viewBoard.relevel}&restep=${viewBoard.restep}"
						class="btn btn-primary mx-1">답글달기</a> <a
						href="../board/delete?no=${viewBoard.no }"
						class="btn btn-primary mx-1">좋아요</a>
					<!-- 여기는 로그인한 사람만 볼수있게 -->
					<a href="../codyboard/update?no=${codyBoard.no}"
						class="btn btn-primary mx-1">수정</a> <a
						href="../codyboard/delete?no=${codyBoard.no}"
						class="btn btn-danger mx-1">삭제</a>
				</div>

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">댓글</label>
					<input type="" class="form-control" placeholder="" name="cbComment"
						id="cbComment"> <a class="btn btn-primary mx-1"
						id="btnComment">댓글달기</a>
				</div>
				<c:forEach items="${cbComment}" var="cbComment" varStatus="status">
					<div class="replyBox">
						<div>
							<tr>
								<th>${cbComment.userID }</th>
								<td colspan="3" class="content">${cbComment.comment }</td>
								<td colspan="3" class="content">${cbComment.regDate }</td>
							</tr>

							<!-- <a class="btn btn-primary mx-3" name="btnReplyComment"  id="btnReplyComment">대댓글달기</a> -->

						</div>
						<div class="cbCommentdiv">
							<tr>
								<th>대댓글id</th>
								<td colspan="3" class="content">내용</td>
								<td colspan="3" class="content">${cbComment.no }</td>
								
							</tr>
						</div>
						<input type="hidden" class="cbCommentNo" name="cbCommentNo"
									id="cbCommentNo" value="${cbComment.no }">
						<input type="hidden" class="cbReply" name="cbReply" id="cbReply">
						<input type="hidden" name="cbReplyCount" id="cbReplyCount"
							value="${status.count }">
						<button class="btn btn-primary" id="btnSubmit">대댓글달기
							${status.count }</button>
					</div>
				</c:forEach>


			</div>
		</div>
	</div>
</div>
<script>
	$("#btnComment")
			.on(
					"click",
					function() {
						const cbCommentValue = $("#cbComment").val();
						console.log(cbCommentValue);
						if (cbCommentValue.length > 0) {
							$
									.ajax({
										url : "../cbcomment/insert?userID=${codyBoard.userID }&comment="
												+ cbCommentValue
												+ "&codyBoardNo=${codyBoard.no}",
									/* data:{
										userID:${codyBoard.userID},
										comment:cbCommentValue,
										codyBoardNo:${codyBoard.no}					
									}, */
									/* success:function(response) {
										console.log("리스폰스 ==>" + response);
										console.log("리스폰스오케 =>>> " + response.isOk);
										if(response.isOk) {
											
										}
									} */
									})
						} else {
							alert("공란입니다 입려해주세요");
						}

						//location.href="../cbcomment/insert?userID=${codyBoard.userID }&comment="+cbCommentValue+"&codyBoardNo=${codyBoard.no}"
						return false;
					})
	//for(let i =1; i <= $("#cbReplyCount").val(); i++){

	$(".replyBox").each(function(idx,item) {
		console.log(item,"===",idx);
		$(item).find("#btnSubmit").on("click",function() {
			console.log($(this).prev().val());			
			/* console.log("댓글번호" + $(".replyBox .cbCommentdiv").siblings(".cbCommentNo").val()) */
			console.log("댓글번호" + $(this).prev().prev().prev().val());
			
			$(this).siblings($(".cbReply")).prop("type", "");
			$(this).prev().prop("type", "hidden");
			$(this).prev().prev().prev().prop("type", "hidden");
			const reply = $(this).prev().prev().val();
			const cbCommentNo =  $(this).prev().prev().prev().val();
			console.log(${codyBoard.no} + "123123123");
			/* $(this).parent().append("<h1>emfdjrkdTffds</h1>") */
			if(reply.length > 0){
			$.ajax({
				url: "../cbreply/insert?replyUserID=mok111&reply=" + reply + "&codyBoardNo=${codyBoard.no}&cbCommentNo=" + 	cbCommentNo
			})
			}
			
			return false;
		})
	})
	
</script>
<%@ include file="../include/footer.jsp"%>







