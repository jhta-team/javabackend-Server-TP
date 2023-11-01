<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h2 class="pb-2 border-bottom">상품 상세</h2>
	<form class="" action="../cart/insert" method="post">
		<input type="hidden" value="${detailDto.pdtId }" name="pdtId" />
		<div class="top d-flex">
			<div class="top left p-2">
				<p>썸네일</p>
				<img id="thumbnailImage" src="${pageContext.request.contextPath }/upload/${detailDto.pdtThum }" width="100%">
				<div class="image_box d-flex">
					<c:choose>
						<c:when test="${!imageDto.img1.equals('null')}">
							<div class="image_detail p-2" onclick="changeThumbnailImage('${pageContext.request.contextPath}/upload/${imageDto.img1}')">
								<img class="image1" width="100" src="${pageContext.request.contextPath}/upload/${imageDto.img1}">
								<p>상품 이미지1: ${imageDto.img1}</p>
							</div>
						</c:when>
					</c:choose>

					<c:choose>
						<c:when test="${!imageDto.img2.equals('null')}">
							<div class="image_detail p-2" onclick="changeThumbnailImage('${pageContext.request.contextPath}/upload/${imageDto.img2}')">
								<img class="image2" width="100" src="${pageContext.request.contextPath}/upload/${imageDto.img2}">
								<p>상품 이미지2: ${imageDto.img2}</p>
							</div>
						</c:when>
					</c:choose>

					<c:choose>
						<c:when test="${!imageDto.img3.equals('null')}">
							<div class="image_detail p-2" onclick="changeThumbnailImage('${pageContext.request.contextPath}/upload/${imageDto.img3}')">
								<img class="image3" width="100" src="${pageContext.request.contextPath}/upload/${imageDto.img3}">
								<p>상품 이미지3: ${imageDto.img3}</p>
							</div>
						</c:when>
					</c:choose>
				</div>
			</div>
			<div class="top right p-2">
				<div class="detail_info">
					<p>상품ID: ${detailDto.pdtId}</p>
					<p>상품이름: ${detailDto.pdtName}</p>
					<p>카테고리: ${detailDto.pdtCty}</p>
					<p>가격: ${detailDto.pdtPrice}</p>
					<p>진열상태: ${detailDto.pdtState}</p>
					<p>등록날짜: ${detailDto.pdtDate}</p>
					<p>수정날짜: ${detailDto.pdtModDate}</p>
					<p>상품색상: ${detailDto.pdtColor}</p>
				</div>
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="pdtSize" class="form-label">상품사이즈</label> <select class="form-select" id="pdtSize" aria-label="Default select example" name="pdtSize" required="required">
							<option value="">사이즈를 선택하세요</option>
							<c:choose>
								<c:when test="${productSizeDto.pdtCountS ne 0 }">
									<option value="S">S : ${productSizeDto.pdtCountS }</option>

								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${productSizeDto.pdtCountM ne 0 }">
									<option value="M">M : ${productSizeDto.pdtCountM }</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${productSizeDto.pdtCountL ne 0 }">
									<option value="L">L : ${productSizeDto.pdtCountL }</option>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${productSizeDto.pdtCountXL ne 0 }">
									<option value="XL">XL : ${productSizeDto.pdtCountXL }</option>
								</c:when>
							</c:choose>
						</select>
						<div class="invalid-feedback">사이즈 선택은 필수</div>
					</div>
				</div>
				<div class="row d-flex justify-content-left mb-2">
					<div class="col-10">
						<label for="quantity" class="form-label">상품수량</label> <input type="number" min="1" class="form-control" id="quantity" placeholder="" name="quantity" required="required" />
						<div class="invalid-feedback">숫자만 쓸 수 있습니다</div>
					</div>
				</div>
				<div class="buttons pb-3">
					<button type="submit" id="btnSubmit">장바구니 담기</button>
				</div>
			</div>
		</div>
	</form>
	<div class="main-img pt-3">
		<h2 class="pb-2 border-bottom">상품 내용</h2>
		<p>${detailDto.pdtContent }</p>
	</div>
</div>
<script>
$("#quantity").on("input", function(e){
    const quantity = document.getElementById("quantity").value;
    const size = document.getElementById("pdtSize").value; // select에서 선택된 사이즈 
    console.log(size); // 수정: "inventory" 대신 "size"를 사용
    let count = 0; // 사이즈별 수량이 담긴 변수 선언 및 초기화
    switch (size) {
        case "S":
            count = ${productSizeDto.pdtCountS};
            break;
        case "M":
            count = ${productSizeDto.pdtCountM};
            break;
        case "L":
            count = ${productSizeDto.pdtCountL};
            break;
        case "XL":
            count = ${productSizeDto.pdtCountXL};
            break;
        default:
        	count = 0;
    }
    if(quantity > count){
    	alert("재고가 부족합니다.")
    	document.getElementById("quantity").value = "1";
    }
});
//썸네일 하단 이미지 클릭시 선택한 이미지로 변경 
function changeThumbnailImage(newImageSrc) {
	const thumbnailImage = document.getElementById("thumbnailImage");
	thumbnailImage.src = newImageSrc;
}	
</script>
<%@ include file="../include/footer.jsp"%>