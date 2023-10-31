<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<h2 class="mb-5 mt-5">구독 결제 </h2>


 <body>
  <select id="amount">
  <option value="">선택하세요.</option>
  	<c:forEach items="${subscribeKind }" var="subscribe" varStatus="staus">
    <option value="${subscribe.price }" id="subcribeMonth">${subscribe.month } (${subscribe.price }원)</option>
    </c:forEach>
</select> 
	<!-- <input type="text" id="amount"> -->
    <button onclick="requestPay()">결제하기</button>
    <!-- 결제하기 버튼 생성 -->
  </body>
 <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <script>
      var IMP = window.IMP;
     
      IMP.init("");
      let amount=0;
       let month = "";
    	  $("#amount").change(function(){
    		amount = $(this).val();
    		console.log(amount)
    		if(amount == 100) month = "15일 구독";
    		else if(amount == 200) month = "30일 구독";
    		else if(amount == 300) month = "60일 구독";
    		else if(amount == 400) month = "90일 구독";
    		
    	  })
      
      function requestPay() {
        IMP.request_pay(
          {
            pg: "html5_inicis",
            pay_method: "card",
            name: month,
            amount: amount,
            buyer_email: "Iamport@chai.finance",
            buyer_name: "mok119",
            buyer_tel: "010-1234-5678",
            buyer_addr: "서울특별시 강남구 삼성동",
            buyer_postcode: "123-456",
          },
          function (rsp) {
        	  if(rsp.success){
        		  //결제성공시 토큰발급
    			 const imp_uid = rsp.imp_uid
        		  $.ajax({ 
        	     		 type:'post',
        	     		 url:"",
        	     		 data: {
        	     			 imp_key : "",
        	     			 imp_secret : ""
        	     		 },
        	     		 error: function(xhr, status, error){
        	     			 console.log("여기에 떨어진다....")
        	  				alert(error);
        	  			},
        	  			success : function(res){ //결제 토큰발급 성공시
        	  				const accessTokne = res.response.access_token;
        	  				console.log("엑세스토큰=====>>>>" + accessTokne);
        	  				 $.ajax({
        	  					type:'get',
        	  					url: "https://api.iamport.kr/payments/" + imp_uid,
        	  					headers: {'authorization' : "Bearer " + accessTokne},
        	  					error: function(e){
        	  						console.log("결제 내역 조회 오류")
        	  						console.log(e)
        	  					},
        	  					success: function(res){
        	  						console.log(res);
        	  						console.log("결제 내역 조회 성공!!!")
        	  						$.ajax({
							    		  type:'post',
							    		  url:"../subscribe/payment-process",
							    		  data:{
							    			  userID: res.response.buyer_name,
							    			  price: res.response.amount,
							    			  imp_uid: res.response.imp_uid,
							    			  product: res.response.name,
							    			  status: res.response.status
							    		  },
							    		  error: function(e){
			        	  						console.log("결제 내역 조회 오류")
			        	  						 $.ajax({
					        	  					type:'get',
					        	  					url: "https://api.iamport.kr/payments/" + imp_uid,
					        	  					headers: {'authorization' : "Bearer " + accessTokne},
					        	  					error: function(e){
					        	  						console.log("결제 내역 조회 오류")
					        	  					},
					        	  					success: function(res){
					        	  						console.log("결제내역이 있다.")
					        	  						console.log(res)
					        	  						$.ajax({
					        	  							type:'post',
					        	  							url:"https://api.iamport.kr/payments/cancel",
					        	  							data:{
					        	  								imp_uid: res.response.imp_uid,
					        	  								merchant_uid: res.response.merchant_uid
					        	  							},
					        	  							headers: {'authorization' : "Bearer " + accessTokne},
					        	  							success: function(res){
					        	  								console.log(res)
					        	  							},
					        	  							error: function(e){
					        	  								console.log("에러입니다 삐삐")
					        	  							}
					        	  							
					        	  						})
					        	  					}
			        	  							
			        	  						})
			        	  						
			        	  					},success: function(res){
			        	  						console.log(res)
			        	  					}
							    	  })
        	  					}
        	  				 })	
        	  				
        	  			}
        	     	 }) 
        	  }
        	  
        	  console.log(rsp)
            console.log("asdasdas===>" + rsp.paid)
          }
        );
      }
    	  
    	  
    	 
    </script>
    
   
    
  
 
<%@ include file="../include/footer.jsp" %>