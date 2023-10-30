<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h2 class="pb-2 border-bottom">상품 상세</h2>
	<form class="" action="../cart/insert" method="post">
	<input type="hidden" value="${detailDto.pdtId }" name="pdtId"/>
	<div class="top d-flex">
		<div class="top left p-2">
			<p>썸네일</p>
			<img src="${pageContext.request.contextPath }/upload/${detailDto.pdtThum }" width="100%">
			<div class="image_box d-flex">
				<c:choose>
					<c:when test="${!imageDto.img1.equals('null')}">
						<div class="image_detail p-2">
							<img class="image1" width="100" src="${pageContext.request.contextPath}/upload/${imageDto.img1}">
							<p>상품 이미지1: ${imageDto.img1}</p>
						</div>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test="${!imageDto.img2.equals('null')}">
						<div class="image_detail p-2">
							<img class="image2" width="100" src="${pageContext.request.contextPath}/upload/${imageDto.img2}">
							<p>상품 이미지2: ${imageDto.img2}</p>
						</div>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test="${!imageDto.img3.equals('null')}">
						<div class="image_detail p-2">
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
			</div>
			<div class="color pb-3">
				<label for="colorSelect">선택 가능 색상:</label> <select id="colorSelect" name="selectedColor">
					<option value="red">빨강</option>
					<option value="green">초록</option>
					<option value="blue">파랑</option>
					<option value="yellow">노랑</option>
				</select>
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
					<label for="quantity" class="form-label">상품수량</label> <input type="number" min="0" class="form-control" id="quantity" placeholder="" name="quantity" required="required" />
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
	function addToCart() {
		const quantity = document.getElementById("quantity").value;
		const inventory = document.getElementById("pdtSize").value;
		console.log(inventory);
		const productID = "${Product.pdtId}";
		console.log(productID);
		if (quantity <= inventory) {
			const url = "../cart/list?pdtId=" + productID + "&quantity="
					+ quantity;
			window.location.href = url;
		} else {
			alert("사이즈 최대 수량을 넘었습니다");
		}
	}
</script>
<%@ include file="../include/footer.jsp"%>