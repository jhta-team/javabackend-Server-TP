<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<h2 class="mb-5 mt-5">구독 결제 </h2>

 <body>
<form name="sampleForm" id="sampleForm">
    
    
</form>

  
	<!-- <input type="text" id="amount"> -->
    <button id="getToken">토큰</button>
    <!-- 결제하기 버튼 생성 -->
  </body>
 <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <script>
     $("#getToken").on("click",function(){
    	 $.ajax({
    		 type:'post',
    		 url:"https://api.iamport.kr/users/getToken",
    		 data: {
    			 imp_key : "0624432526912208",
    			 imp_secret : "4d1d9f754a0136d2f683f25ad7bef6897ef04890a17d2c0a2678183f1a8b7e50d665373e33c64ff7"
    		 },
    		 error: function(xhr, status, error){
    			 console.log("여기에 떨어진다....")
 				alert(error);
 			},
 			success : function(res){
 				const accessTokne = res.response.access_token;
 				console.log(res.response.access_token);
 				$.ajax({
 					url:""
 				})
 			}
    	 })
     })
      
    </script>
    
   
    
  
 
<%@ include file="../include/footer.jsp" %>