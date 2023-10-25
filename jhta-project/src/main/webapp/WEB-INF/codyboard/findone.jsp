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
						class="btn btn-primary mx-1">답글달기</a>
						${likeCount } 
						<button id="btncbLike">좋아요</button>
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
						<div class="cbCommentBox">
							<tr>
								<th>${cbComment.userID }</th>
								<th>댓글번호 ===>>> ${cbComment.no }</th>
								<td colspan="3" class="content">${cbComment.comment }</td>
								<td colspan="3" class="content">${cbComment.regDate }</td>
								<input type="hidden" value="${cbComment.no }">
								<input type="hidden">
								<td colspan="3" class="content"><button class="btnCommentUpdate">수정하기</button></td>
								<td colspan="3" class="content"><button class="btnCommentDelete">삭제</button></td>
								
							</tr>

							<!-- <a class="btn btn-primary mx-3" name="btnReplyComment"  id="btnReplyComment">대댓글달기</a> -->

						</div>
						<c:forEach items="${reply }" var="reply" varStatus="status">
						<c:set var="cbCommentNo" value="${cbComment.no }"/>
						<c:if test="${reply.cbCommentNo eq cbCommentNo }">
							<div class="cbCommentdiv">
								<tr>
									<th>${reply.replyUserID }</th>
									<td colspan="3" class="content">${reply.reply }</td>
									<td colspan="3" class="content">${reply.regDate }</td>
									<input type="hidden" value="${reply.no }">
									<input type="hidden" placeholder="${reply.replyUserID }님 ${reply.reply}를 수정하시겠습니까?">
									<td colspan="3" class="content"><button class="btnReplyUpdate">수정하기</button></td>
									<td colspan="3" class="content"><button class="btnReplyDelete">삭제</button></td>
									
								</tr>
							</div>
						</c:if>
						</c:forEach>
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
	$(".replyBox .cbCommentBox .btnCommentUpdate").on("click", function(){
				const cbCommentNo = $(this).prev().prev().val()
				const cbCommentUpdate = $(this).prev().val();
				console.log(cbCommentNo)
				$(this).prev().prop("type", "text")
				if(cbCommentUpdate.length>0){
					$.ajax({
						url:"../cbcomment/update?cbCommentNo=" + cbCommentNo + "&cbCommentUpdate=" + cbCommentUpdate
					})
					
				}
				
				
				return false;
		})
		
	$(".replyBox .cbCommentBox .btnCommentDelete").on("click", function(){
			const cbCommentNo = $(this).prev().prev().prev().val()
			console.log(cbCommentNo)
			if(cbCommentNo != null){
				$.ajax({
					url:"../cbcomment/delete?cbCommentNo=" + cbCommentNo		
				
				})
			}
		})
	

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

	
	
	$(".replyBox .cbCommentdiv .btnReplyUpdate").on("click", function() {
		const replyNo = $(this).prev().prev().val()
		const replyUpdate = $(this).prev().val();
		$(this).prev().prop("type", "text")
		console.log(replyUpdate)
		console.log($(this).prev().prev().val())
		if(replyUpdate.length > 0){
			$.ajax({
					url:"../cbreply/update?replyNo=" + replyNo + "&replyUpdate=" + replyUpdate
				
				})
			}
		return false
		
		})
	$(".replyBox .cbCommentdiv .btnReplyDelete").on("click", function(){
		const replyNo = $(this).prev().prev().prev().val()
		console.log(replyNo);
		if(replyNo != null){
			$.ajax({
					url:"../cbreply/delete?replyNo=" + replyNo
					
				})
			
		}
		return false;
		})
		
	
	$("#btncbLike").on("click", function(){
		const userID = "mok555"
		const cbNo = ${codyBoard.no}
		console.log(cbNo)
		$.ajax({
			url:"../cblike/cblike?userID=" + userID + "&cbNo=" + cbNo
		
			})
			
		return false;
		
		})
	
	
	
	
</script>
<%@ include file="../include/footer.jsp"%>







