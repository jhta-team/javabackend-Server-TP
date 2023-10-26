<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h2 class="pb-2 border-bottom">상품 등록</h2>
	<form class="needs-validation" action="../product/insert-process" method="post" enctype="multipart/form-data"  novalidate>
		<div class="top d-flex">
			<div class="top left p-2">
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtName" class="form-label">상품이름</label> 
						<input type="text" class="form-control" id="pdtName" placeholder="" name="pdtName" required />
						<div class="invalid-feedback">이름 입력은 필수입니다</div>
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtCty" class="form-label">상품카테고리</label> 
						<select class="form-select" aria-label="Default select example" name="pdtCty" required>
							<option value="">카테고리를 선택하세요</option>
							<option value="outer">Outer</option>
							<option value="top">Top</option>
							<option value="bottom">Bottom</option>
							<option value="none">None</option>							
						</select>						
						<div class="invalid-feedback">카테고리를 선택하세요</div>
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtPrice" class="form-label">상품가격</label> <input type="number" min="0" class="form-control" id="pdtPrice" placeholder="" name="pdtPrice" required="required" />
						<div class="invalid-feedback">숫자만 쓸 수 있습니다</div>
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtColor" class="form-label">상품색상</label> <select class="form-select" aria-label="Default select example" name="pdtColor">
							<option value="">색상을 선택하세요</option>
							<option value="black">Black</option>
							<option value="white">White</option>
							<option value="red">Red</option>
							<option value="green">Green</option>
							<option value="blue">Blue</option>
							<option value="none">None</option>
						</select>
					</div>
				</div>


				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtCount" class="form-label">상품수량</label> <input type="number" min="0" class="form-control" id="pdtCount" placeholder="" name="pdtCount" required="required" />
						<div class="invalid-feedback">숫자만 쓸 수 있습니다</div>
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtThum" class="form-label">상품썸네일</label> <input type="file" class="form-control" id="pdtThum" placeholder="png,jpg,gif" name="pdtThum" accept="image/gif, image/jpeg, image/png, image/jpg" required="required" />
						<div class="invalid-feedback">썸네일 등록은 필수 입니다</div>
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtImage" class="form-label">상품 이미지 추가(최대3개)</label> <input type="file" class="form-control" id="pdtImage" placeholder="" name="pdtImage" accept="image/gif, image/jpeg, image/png, image/jpg" multiple  />
						<div class="invalid-feedback">이미지는 최대 3개까지 가능합니다</div>
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
			</div>
		</div>
		<div class="bottop">
			<div class="row d-flex justify-content-left p-2 mb-2">
				<div class="col">
					<label for="pdtContent" class="form-label">상품내용</label>
					<textarea class="form-control" id="pdtContent" name="pdtContent" rows="8"></textarea>
				</div>
			</div>

			<div class="mt-5 mb-5 d-flex justify-content-center">
				<div class="">
					<button type="submit" class="btn btn-sm btn-outline-secondary mb-5" id="btnSubmit" onclick="uploadFiles()">상품등록</button>
					<button type="reset" class="btn btn-sm btn-outline-secondary mb-5">취소</button>
				</div>
			</div>
		</div>
	</form>
</div>
<script src="https://cdn.ckeditor.com/ckeditor5/39.0.2/classic/ckeditor.js"></script>
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

	/* 파일 이미지 여러개 추가 실시간 */

	$("#pdtImage").on("change", function(e){
		const input = document.getElementById('pdtImage');
		const files = input.files;
		console.log(files.length);
		if (files.length < 4 ) {
	        input.setCustomValidity(""); // 유효성 메시지를 지웁니다.
	        $(input).removeClass("is-invalid");  
		}else {
	        $(input).addClass('is-invalid');
	        
		} 
	});

	
	function uploadFiles() {
		const input = document.getElementById('pdtImage');
		const files = input.files;
		console.log(files.length);
		if (files.length > 0 && files.length < 4 ) {
			const formData = new FormData();
			for (let i = 0; i < files.length; i++) {
				formData.append(i, files[i]);
				console.log(formData);
			}
		}
	}

	const price = document.getElementById('pdtPrice');
	// 상품가격 유효성 검사 +,- 입력 방지
	price.onkeydown = function(e) {
		if (!((e.keyCode > 95 && e.keyCode < 106)
				|| (e.keyCode > 47 && e.keyCode < 58) || e.keyCode == 8)) {
			return false;
		}
	}
	//ckeditor
	ClassicEditor
	.create( document.querySelector( "#pdtContent" ),{
		ckfinder:{
			uploadUrl:"../product/imgupload",success:function(response){
				console.log(response)
			}
		}, 
	})
	.catch( error => {
	    console.error( error );
	});


	$.ajax({url:"../product/imgupload",success:function(response) {
		console.log(response)
	}})
	
	
	
	//validation 
	const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')
	    }, false)
	  })
</script>
<%@ include file="../include/footer.jsp"%>