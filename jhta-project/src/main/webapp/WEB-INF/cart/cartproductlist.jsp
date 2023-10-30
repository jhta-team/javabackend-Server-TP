<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<h1>장바구니</h1>

<c:if test="${empty cart}">
	<p>장바구니가 비어있습니다.</p>
</c:if>
<h2>장바구니 이름 : eic2021의 장바구니</h2>
<div class="table d-flex justify-content-center">
	<table border="1">
		<tr>
			<th width="200">장바구니 상품 번호</th>
			<th width="400">상품썸네일</th>
			<th width="200">상품명</th>
			<th width="200">사이즈</th>
			<th width="200">가격</th>
			<th width="200">수량</th>
			<th width="200">삭제</th>
		</tr>
		<c:forEach items="${CartProductDto }" var="Dto">
			<tr>
				<td>장바구니 상품 번호 : ${Dto.cartItemId }</td>
				<td><img width="400" height="300" src="${pageContext.request.contextPath }/upload/${Dto.pdtThum}"></td>
				<td>상품명 : ${Dto.pdtName }</td>
				<td>사이즈 : ${Dto.pickSize}</td>
				<td>가격 : ${Dto.pdtPrice}</td>
				<td>수량 : ${Dto.quantity}</td>
				<td><button onclick="deleteItem()">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</div>
<p>총 금액: 얼마일까?</p>

<form action="" method="post">
	<input type="submit" value="결제하기">
</form>
<script>
function deleteItem() {
	$.ajax({url:"../cart/delete",success:function(response) {
				

	}})

</script>
<c:if test="${not empty cart}">
</c:if>
<%@ include file="../include/footer.jsp"%>