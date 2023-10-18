<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
 <div class="container">
    	<%-- <h1>${pageContext.request.contextPath }</h1>
    	<h1>${request.contextPath }</h1> --%>
      <form action="../member/insert-process" method="post" class="" 
      name="member" id="joinform" enctype="multipart/form-data">  <!-- <form  -->
      								<!--방식은 post, 이미지나 파일을 받기 위해서 -->
        <div class="row d-flex justify-content-center mt-5">
          <div class="col-6">
            <div class="mb-3">
              <label for="userID" class="form-label">ID</label>
              <input type="text" class="form-control" id="userID" placeholder="user id" name="userID" />
              <button class="btn btn-primary" id="btnIDCheck">아이디 중복 확인</button>
            </div>
          </div>
        </div>
        </form>
        </div>
        <script>
        $("#btnIDCheck").on("click", function(){
      	  $.ajax({
      		  url:"../member/idCheck",
      				  data:{userID:$("#userID").val()},
      				  //method:"get",
      				  success : function(data){
      					  console.log(data);
      					  console.log("success");
      					  if(data.count>0){
      						  alert("쓸 수 없는 아이디입니다.");
      						  $("#userID").val("");
      						  $("#userID").focus();
      					  }else{
      						  const useID = confirm("쓸 수 있는 아이디입니다. 사용하시겠습니까?");
      						  //confirm() return boolean
      					  	if(useID){
      					  		$("#userID").attr("readonly",false);
      					  		isIDCheck = true;
      					  						//readonly ,true 읽기전용, 수정불가
      					  						//readonly ,false 읽기전용, 수정가능
      					  	}
      					  }
      				  },
      				  complete : function(data){
      					  console.log(data);
      				  }
      	  });
      	  return false;
        });
        </script> 
<%@include file="../include/footer.jsp" %>

