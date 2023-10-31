<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<h2>구독 내역</h2>

<table class="table list">
	<thead>
		<tr>
			<th scope="col">구매한 구독권</th>
			<th scope="col">가격</th>
			<th scope="col">구매한날짜</th>
		</tr>
	</thead>

	<c:forEach items="${subscribePaymentList }" var="subscribePayment"
		varStatus="status">
			<tr  class="paymentList">
				<td id="product">${subscribePayment.product }</td>
				<td id="price">${subscribePayment.price }</td>
				<td id="regDate">${subscribePayment.regDate }</td>
				<td class="button"><input class="vl" type=text
					value="${subscribePayment.imp_uid} ">
					<button id="refund" class="refund">환불받기</button></td>
			</tr>
	</c:forEach>



</table>
<%@ include file="../include/footer.jsp"%>
<script>
	$(".paymentList").each(function(idx, item) {
		console.log(item, " ===", idx);
		$(item).find(".refund").on("click", function() {
			const imp_uid = $(this).prev().val();
			/* const yseOrNo = alert("환불받으실껀가요??") */
			if (!confirm("환불하시겠습니까??")) {
            
            console.log("취소")
        } else {
           	console.log("환불한다.")
           	$.ajax({
           		type:'post',
           		url:"https://api.iamport.kr/users/getToken",
           		data:{
           			imp_key : "",
	     			imp_secret : ""
           		},
           		error: function(error){
           			console.log(error)
           			alert(error)
           		},
           		success: function(res){
           			console.log(res)
           			const token = res.response.access_token
           			console.log(token)
           			$.ajax({
           				type:'get',
           				url:"https://api.iamport.kr/payments/"+ imp_uid,
           				headers:{"authorization" : "Bearer " + token},
           				error: function(error){
           					console.log("토큰발급실패")
           					console.log(error)
           				},
           				success: function(res){
           					console.log(res)
           					try{
           					$.ajax({
           						type:'post',
           						url:"https://api.iamport.kr/payments/cancel",
           						data:{
           							imp_uid : imp_uid
           						},
           						headers:{"authorization" : "Bearer " + token},
           						error: function(error){
           							console.log(error)
           						},
           						success: function(res){
           							if(res.code == 1){
           								alert("이미 환불되었습니다.");
           							}else{
           								$.ajax({
           									type:'post',
           									url:"../subscribe/payment-cancel",
           									data: {
           										userID: res.response.buyer_name,
           										price: res.response.cancel_amount,
           										imp_uid: res.response.imp_uid,
           										product: res.response.name,
           										status: res.response.status
           									},
           									error: function(e){
           										console.log(e)
           										console.log("실패!!!")
           										console.log("실패!!!")
           									},
           									success: function(res){
           										console.log("성공!!!!!")
           										alert("환불되었습니다.");
           										console.log("성공!!!!!")
           										
           									}
           								})
           							}
           							
           						
           						}
           					})
           					}catch(err){
           						console.log(err)
           					}
           				}
           			})
           		}
           	})
        }

		})
	})
	/* 	$("#refund").on("click", function(){
	 const aaa = document.getElementById("product").innerText
	 console.log(aaa)
	 }) */
</script>