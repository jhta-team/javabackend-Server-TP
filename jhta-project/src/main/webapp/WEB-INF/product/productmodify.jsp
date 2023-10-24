<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h2 class="pb-2 border-bottom">상품 수정</h2>
	<form action="../product/modify-process" method="post" enctype="multipart/form-data">
		<div class="top d-flex">
			<div class="top left p-2">
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtId" class="form-label"><input type="hidden" name="pdtId" value="${Product.pdtId }"></label>
						<label for="pdtName" class="form-label">상품이름 (필수)</label> <input type="text" class="form-control" id="pdtName" placeholder="" name="pdtName" required="required"
						value="${Product.pdtName }" />
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtCty" class="form-label">상품카테고리</label> <input type="text" class="form-control" id="pdtCty" placeholder="" name="pdtCty" list="datalistOptions"
						value="${Product.pdtCty }" />
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtPrice" class="form-label">상품가격 (필수)</label> <input type="number" class="form-control" id="pdtPrice" placeholder="" name="pdtPrice" required="required"
						value="${Product.pdtPrice }" />
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtColor" class="form-label">상품색상</label> <input type="text" class="form-control" id="pdtColor" placeholder="" name="pdtColor"
						value="${Product.pdtColor }" />
					</div>
				</div>


				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtCount" class="form-label">상품수량 (필수)</label> <input type="number" class="form-control" id="pdtCount" placeholder="" name="pdtCount" required="required"
						value="${Product.pdtCount }" />
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtThum" class="form-label">상품썸네일 수정</label> <input type="file" class="form-control" id="pdtThum" placeholder="png,jpg,gif" name="pdtThum" accept="image/gif, image/jpeg, image/png, image/jpg" required="required"
						value="${Product.pdtThum }" />
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtImage" class="form-label">상품 이미지 수정 (이전 업로드된 이미지는 삭제됨)</label> <input type="file" class="form-control" id="pdtImage" placeholder="이미지 추가는 메인이미지를 포함 4개까지 가능" name="pdtImage" accept="image/gif, image/jpeg, image/png, image/jpg" multiple />
					</div>
				</div>
			</div>

			<div class="top right p-2">
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-5">
						<label class="form-label">미리보기</label>
						<div class="preview"></div>
					</div>
				</div>
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-5">
						<label class="form-label">기존 썸네일</label>
						<div class="prethum">
							<img src="${pageContext.request.contextPath }/upload/${Product.pdtThum}" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="bottop">
			<div class="row d-flex justify-content-left p-2 mb-2">
				<div class="col">
					<label for="pdtContent" class="form-label">상품내용</label>
					<textarea class="form-control" id="pdtContent" name="pdtContent" rows="8" >${Product.pdtContent }</textarea>
				</div>
			</div>
			
			<div class="mt-5 mb-5 d-flex justify-content-center">
				<div class="">
					<button type="submit" class="btn btn-sm btn-outline-secondary mb-5" id="btnSubmit" onclick="uploadFiles()">상품수정</button>
					<button type="reset" class="btn btn-sm btn-outline-secondary mb-5">취소</button>
				</div>
			</div>
		</div>
	</form>
</div>

<script>
	/* 썸네일 미리보기 */
	$("#pdtThum")
			.on(
					"change",
					function(e) {
						const file = e.target.files[0];
						console.log(e.target.files);
						console.log(file.name);
						const ext = file.name.substring(file.name
								.lastIndexOf(".") + 1);
						console.log(ext);
						if (!(ext === "png" || ext === "jpg" || ext === "gif" || ext === "jpeg")) {
							alert("png,jpg,gif,jpeg만 쓸 수 있습니다.");
							$("#profile").val("");
							return false;
						} else {
							const reader = new FileReader();
							reader.onload = function(e) {
								$(".preview").html(
										`<img src="\${e.target.result}">`);
							}
							reader.readAsDataURL(file);
						}
					});

	/* 파일 이미지 여러개 추가 */
	function uploadFiles() {
		const input = document.getElementById('pdtImage');
		const files = input.files;

		if (files.length > 0) {
			const formData = new FormData();
			for (let i = 0; i < files.length; i++) {
				formData.append(i, files[i]);
				console.log(formData);
			}
		}
	}
</script>
<%@ include file="../include/footer.jsp"%>