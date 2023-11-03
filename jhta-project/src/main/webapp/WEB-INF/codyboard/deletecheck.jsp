<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<table class="table">
<input type="hidden" value="${codyBoardNo }">
<input type="hidden" value="${image }">
					<colgroup>
						<col style="width: 15%">
						<col style="width: 35%">
						<col style="width: 15%">
						<col style="width: 35%">
					</colgroup>
					<tbody id="tobody">
						<tr>
							<th>userID</th>
						</tr>
						<tr>
							<th>전화번호</th>
							<th id="phonenum">01097758809</th>
						</tr>
						<tr>
							<th><button id="checknumreceive">인증번호받기</button></th>
							<th><input type="text" id="checknum"></th>
							<th><input type="" id="token" val=""></th>
							<th><button id="checknumcheck">인증번호확인</button></th>
						</tr>
						
					</tbody>
				</table>

<%@ include file="../include/footer.jsp"%>
<script>
	let token = ""
	$("#checknumreceive").on("click", function(){
		const appkey = "";
		const secretKey = "";
		token = String(Math.floor(Math.random() * 1000000)).padStart(6,"0")
		console.log("토큰===>>>" + token)
		const phoneNum = $("#phonenum").text()
		console.log(phoneNum)
				let data = {
				body : "인증번호는[" + token + "]입니다.",
				sendNo : "01097758809",
				recipientList : [
			        {
			            "internationalRecipientNo": "01097758809"
			        }
			    ]
			}
		$.ajax({
			type:'post',
			url: "https://api-sms.cloud.toast.com/sms/v3.0/appKeys/" + appkey + "/sender/sms",
			headers: {
				"Content-Type": "application/json;charset=UTF-8",
				"X-Secret-Key": secretKey
			},
			data: JSON.stringify(data),
			/* data */
			error:function(e){
				console.log(e)
			},
			success: function(res){
				console.log(res)
				let inputToken = $("#token").val(token)
				alert("인증번호가 발송되었습니다. 확인해주세요.")
				$("#checknumreceive").text("인증번호 재발급")
				
				
			}
		})
		
	})
	
	$("#checknumcheck").on("click", function(){
		
		let checkToken = $("#checknum").val()
		console.log(token + "========" + checkToken)
	/* 	if(token == checkToken){
			alert("인증성공!!!") */
			
			$.ajax({
				
				url: '../codyboard/delete-process',
				data:{
					codyBoardNo : ${codyBoardNo}
				},
				success:function(res){
					alert("게시글 삭제 성공")
					location.href = "../codyboard/page-nation"
				},
				error: function(e){
					alert("게시글 삭제 실패")
				}
			})
			
		/* }else{
			alert("인증실패!!!")
		} */
	})
	
	
</script>