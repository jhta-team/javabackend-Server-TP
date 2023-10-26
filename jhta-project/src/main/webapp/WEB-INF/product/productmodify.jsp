<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h2 class="pb-2 border-bottom">상품 수정</h2>
	<form class="needs-validation" action="../product/modify-process?pdtId=${Product.pdtId }" method="post" enctype="multipart/form-data" novalidate>
		<div class="top d-flex">
			<div class="top left p-2">
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">					
						<label for="pdtName" class="form-label">상품이름</label> 
						<input type="text" class="form-control" id="pdtName" placeholder="" name="pdtName" required 
						value="${Product.pdtName }" />
						<div class="invalid-feedback">이름 입력은 필수입니다</div>
					</div>
				</div>

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtCty" class="form-label">상품카테고리</label> 
						<select class="form-select" aria-label="Default select example" name="pdtCty" required>
							<option value="${Product.pdtCty }">${Product.pdtCty }</option>
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
						<label for="pdtPrice" class="form-label">상품가격</label> <input type="number" min="0" class="form-control" id="pdtPrice" placeholder="" name="pdtPrice" required="required"
						value="${Product.pdtPrice }" />
						<div class="invalid-feedback">숫자만 쓸 수 있습니다</div>
					</div>
				</div>	

				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtColor" class="form-label">상품색상</label> <select class="form-select" aria-label="Default select example" name="pdtColor">
							<option value="${Product.pdtColor }">${Product.pdtColor }</option>
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
					<label for="pdtCount" class="form-label">상품 수량 입력</label><br>
					<div class="col-10 d-flex" >						
						<label for="pdtCount" class="form-label">S</label>
						<input type="number" min="0" class="form-control" id="pdtCountS" placeholder="" name="pdtCountS" required="required" value="${productSizeDto.pdtCountS }" />
						<label for="pdtCount" class="form-label">M</label>
						<input type="number" min="0" class="form-control" id="pdtCountM" placeholder="" name="pdtCountM" required="required" value="${productSizeDto.pdtCountM }"/>
						<label for="pdtCount" class="form-label">L</label>
						<input type="number" min="0" class="form-control" id="pdtCountL" placeholder="" name="pdtCountL" required="required" value="${productSizeDto.pdtCountL }" />
						<label for="pdtCount" class="form-label">XL</label>
						<input type="number" min="0" class="form-control" id="pdtCountXL" placeholder="" name="pdtCountXL" required="required" value="${productSizeDto.pdtCountXL }"/>
					</div>
					<div class="invalid-feedback">숫자만 쓸 수 있습니다</div>
				</div>
				
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtState" class="form-label">상품상태(1:진열),(0:매진)</label> 
						<input type="number" min="0" max="1" class="form-control" id="pdtState" placeholder="" name="pdtState" required="required" value="${Product.pdtState }" />
						<div class="invalid-feedback">숫자만 쓸 수 있습니다</div>
					</div>
				</div>
								
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtThum" class="form-label">상품썸네일 수정</label> <input type="file" class="form-control" id="pdtThum" placeholder="png,jpg,gif" name="pdtThum" accept="image/gif, image/jpeg, image/png, image/jpg" required="required"
						value="${Product.pdtThum }" />
						<div class="invalid-feedback">썸네일 등록은 필수 입니다</div>
					</div>
				</div>
								
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtImage" class="form-label">상품 이미지 수정 (이전 업로드된 이미지는 삭제됨)</label> <input type="file" class="form-control" id="pdtImage" placeholder="" name="pdtImage" accept="image/gif, image/jpeg, image/png, image/jpg" multiple  />
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
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-5">
						<label class="form-label">기존 썸네일</label>
						<div class="prethum">
							<img src="${pageContext.request.contextPath }/upload/${Product.pdtThum}" height="300" />
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
					<a href="../product/delete?pdtId=${Product.pdtId }" class="btn btn-sm btn-outline-secondary mb-5">상품삭제</a>
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
									`<img src="\${e.target.result}" height="300">` );
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
        input.setCustomValidity(""); // 유효성 메시지를 지우기
        $(input).removeClass("is-invalid");
        $(input).removeClass("form-control:vaild");
        

	}else {        
        $(input).addClass("is-invalid");        
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


document.addEventListener('DOMContentLoaded', function() {
    const pdtCountInput = document.getElementById('pdtCount');
    const pdtStateInput = document.getElementById('pdtState');

    // pdtCount 입력 필드의 변화 감지
    pdtCountInput.addEventListener('input', function() {
        const pdtCountValue = parseInt(pdtCountInput.value, 10);

        // 상품 수량이 0일 경우 상품 상태를 0으로 설정
        if (pdtCountValue === 0) {
            pdtStateInput.value = 0;
        }
    });
});


const forms = document.querySelectorAll('.needs-validation')
//전체 유효성 검사
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