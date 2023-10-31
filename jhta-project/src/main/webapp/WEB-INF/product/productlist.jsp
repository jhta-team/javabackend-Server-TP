<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<h2 class="pb-2 border-bottom">상품 게시판</h2>
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		<c:forEach items="${ProductList }" var="Product">
			<c:choose>
				<c:when test="${Product.pdtState ne 2 }">
					<div class="col">
						<div class="card shadow-sm">
							<a href="../product/detail?pdtId=${Product.pdtId }"> <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="${pageContext.request.contextPath }/upload/${Product.pdtThum}"></a>
							<div class="card-body">
								<p class="card-text">
									<font style="vertical-align: inherit;">${Product.pdtName }</font>
								</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='../product/detail?pdtId=${Product.pdtId }'">
											<font style="vertical-align: inherit;"><font style="vertical-align: inherit;">상세보기</font></font>
										</button>
										<button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='../product/modify?pdtId=${Product.pdtId }'">
											<font style="vertical-align: inherit;"><font style="vertical-align: inherit;">수정하기</font></font>
										</button>
									</div>
									<small class="text-body-secondary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">가격 : ${Product.pdtPrice }원</font></font></small>
								</div>
							</div>
						</div>
					</div>
				</c:when>
			</c:choose>
		</c:forEach>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>