<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<c:choose>
	<c:when test="${loggedMember.adminNumber eq 1}">
		<div class="container">
			<h2 class="pb-2 border-bottom">상품 게시판</h2>
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
				<c:forEach items="${ProductList }" var="Product">
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
				</c:forEach>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="container">
			<h2 class="pb-2 border-bottom">상품 게시판</h2>
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
				<c:forEach items="${ProductList }" var="Product">
					<c:choose>
						<c:when test="${Product.pdtState eq 1 }">
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
	</c:otherwise>
</c:choose>
<div class="d-flex justify-content-center m-5">
	<div class="pagenation mx-3">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center ">
				<li class="page-item"><a class="page-link" href="../product/list?page=${intpage -1 }" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach var="i" begin="${startpage }" end="${endpage }">
					<c:choose>
						<c:when test="${i==intpage }">
							<li class="page-item"><a class="page-link active" href="../product/list?page=${i }">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link " href="../product/list?page=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="../product/list?page=${intpage +1 }" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
	<div class="searchBox mx-3">
		<form action="../product/search">
			<select class="btn btn-sm btn-outline-secondary btnSearch" name="category">
				<option value="all">전체</option>
				<option value="pdtName">상품이름</option>
				<option value="pdtCty">카테고리</option>
				<option value="pdtColor">상품색상</option>
				<option value="pdtPrice">상품가격</option>
			</select> <span class="serachLevel"> <input class="keyword btn btn-sm btn-outline-secondary" type="text" name="keyword">
			</span>
			<button class="btn btn-sm btn-outline-secondary">
			<font style="vertical-align: inherit;"><font style="vertical-align: inherit;">검색</font></font></button>
		</form>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>