<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container" id="custom-cards">
	<h2 class="pb-2 border-bottom">상품 게시판</h2>
	<div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
		<c:forEach items="${ProductList }" var="Product">
			<div class="col">
				<div
					class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg">
					<div
						class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
						<h3 class="mb-4 display-6 lh-1 fw-bold">${Product.pdtName }</h3>
						<a href="../product/detail?id=${Product.id }">
						<img src="${pageContext.request.contextPath }/upload/${Product.pdtThum}">
						</a>
						<ul class="d-flex list-unstyled mt-2">
							<li class="me-auto"><small>${Product.pdtCty }</small></li>
							<li class="d-flex align-items-center me-3"><small>가격</small>
							</li>
							<li class="d-flex align-items-center"><small>${Product.pdtPrice }원</small>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>