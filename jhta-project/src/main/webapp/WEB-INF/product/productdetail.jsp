<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h2>상품 상세</h2>
	<div class="content d-flex">
		<div class="thum m-3">
			<p>썸네일</p>
			<img
				src="${pageContext.request.contextPath }/upload/${detailDto.pdtThum }">
		</div>
		<div class="detail m-3">
			<div class="detail-info">
			<p>상품ID: ${detailDto.pdtId}</p>
			<p>상품이름: ${detailDto.pdtName}</p>
			<p>카테고리: ${detailDto.pdtCty}</p>
			<p>가격: ${detailDto.pdtPrice}</p>
			<p>진열상태: ${detailDto.pdtState}</p>
			<p>등록날짜: ${detailDto.pdtDate}</p>
			<p>수정날짜: ${detailDto.pdtModDate}</p>
			</div>
			<div class="color pb-3">
				<label for="colorSelect">선택 가능 색상:</label>
					<select id="colorSelect" name="selectedColor">
					<option value="red">빨강</option>
					<option value="green">초록</option>
					<option value="blue">파랑</option>
					<option value="yellow">노랑</option>
				</select>
			</div>
			<div class="buttons pb-3">
				<button>주문하기</button>
				<button>장바구니</button>
			</div>
			<p>상품설명: </p>
			<p> ${detailDto.pdtContent }</p>
		</div>
	</div>
	<div class="main-img pt-3">
		<h2>상품 이미지</h2>
		<div>
			<img alt="" src="">
			<p>상품 메인 이미지 : ${imageDto.imgMain }</p>
		</div>
		<div>
			<img alt="" src="">
			<p>상품 이미지1 : ${imageDto.img1 }</p>
		</div>
		<div>
			<img alt="" src="">
			<p>상품 이미지2: ${imageDto.img2 }</p>
		</div>
		<div>
			<img alt="" src="">
			<p>상품 이미지3 : ${imageDto.img3 }</p>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>