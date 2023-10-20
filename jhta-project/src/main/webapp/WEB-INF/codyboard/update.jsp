<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div class="container">
	<form action="../codyboard/update-process" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${codyBoard.no }">
	<input type="hidden" name="userID" value="${codyBoard.userID }">
	<h2>코디 게시판 수정</h2>
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">제목</label>
		  <input type="" class="form-control" id="codyBoardTitle" placeholder="제목을 작성해주세요." name="codyBoardTitle" value="${codyBoard.title}">
		</div>
		    <div class="mb-3">
		      <label for="disabledSelect" class="form-label">스타일 종류 선택</label>
		      <select id="disabledSelect" class="form-select" name="codyCategory">
		      <c:choose>
		      	<c:when test="${codyBoard.categoryID == '10' }">
		        <option value=10>스트릿</option>
		        <option value=11>캐쥬얼</option>
		        <option value=12>댄디</option>
		        <option value=13>고프코어</option>
		       </c:when>
		       <c:when test="${codyBoard.categoryID == '11' }">
		        <option value=11>캐쥬얼</option>
		        <option value=10>스트릿</option>
		        <option value=12>댄디</option>
		        <option value=13>고프코어</option>
		      </c:when>
		      <c:when test="${codyBoard.categoryID == '12' }">
		        <option value=12>댄디</option>
		        <option value=10>스트릿</option>
		        <option value=11>캐쥬얼</option>
		        <option value=13>고프코어</option>
		       </c:when>
		       <c:when test="${codyBoard.categoryID == '13' }">
		        <option value=13>고프코어</option>
		        <option value=10>스트릿</option>
		        <option value=11>캐쥬얼</option>
		        <option value=12>댄디</option>
		        </c:when>
		      </c:choose>
		       
		      </select>
		    </div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
		  <input type="" class="form-control" id="codyBoardContent" placeholder="제목을 작성해주세요." name="codyBoardContent" value="${codyBoard.content }">
		</div>
		
		<div class="mb-3">
		  <label for="formFileDisabled" class="form-label">코디사진</label>
		  <input class="form-control" type="file" id="codyImage" name="codyImage" placeholder="png,jpg" accept="image/gif, image/jpeg, image/png, image/jpg" value="/Users/junghunmok/Desktop/upload/${codyBoard.images} ">
		</div>
		<div>
			<img src="/upload/${codyBoard.images }" id="prevCodyImage" width="200">
			<input type="hidden" name="prevCodyImage" value="${codyBoard.images }">
		</div>
		
		<div class="mt-5 mb-5 d-flex justify-content-center">
				<div class="">
					<button type="submit" class="btn btn-primary" id="btnSubmit">글수정</button>
					<button type="reset" class="btn btn-secondary">취소</button>
				</div>
			</div>
	</form>
</div>
<<script>
/* $("#profile").on("change",function(e){
				const file = e.target.files[0];
				console.log(e.target.files);
				console.log(file.name);
				const ext = file.name.substring(file.name.lastIndexOf(".")+1);
				console.log(ext);
				if(!(ext==="png" || ext==="jpg" || ext==="gif")) {
					alert("png,jpg,gif만 쓸 수 있습니다.");
					$("#profile").val("");
					return false;
				} else {
					const reader = new FileReader();
					reader.onload = function(e) {
						$(".preview").html(`<img src="\${e.target.result}">`);
					}
					reader.readAsDataURL(file);
				}
		   }); */
/* $(document).ready(function(){
	$("#btnSubmit").click(function(){
		console.log($("#codyBoardTitle").val().length)
		console.log($("#codyBoardContent").val().length)
		if($("#codyBoardTitle").val().length==0 || $("#codyBoardContent").val().length==0 || $("#codyImage").val().length==0){
			console.log("여기가 맞나여 ??")
			console.log($("#codyimage").val())
			alert("게시글의 빈공간이 있습니다.")
			return false
		}
	});
}); */
</script> 
<%@ include file="../include/footer.jsp" %>