<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<div class="container-fluid">
<button class="btn btn-primary btnBalckList" onclick="location.href='../member/list'">일반회원관리</button>
<form action="../member/delete-all">
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">아이디</th>
      <th scope="col">이름(닉네임)</th>
      <th scope="col">비밀번호</th>
      <th scope="col">주소</th>
      <th scope="col">전호번호</th>
      <th scope="col">이메일</th>
      <th scope="col">가입날짜</th>
      <th scope="col">구매한 금액</th>
      <th scope="col">수정</th>
      <th scope="col">블랙</th>
      <th scope="col">삭제</th>
      <th scope="col"><input type="checkbox" id="checkAll" ></th>
    </tr>
  </thead>
  <tbody>
  		<c:forEach items="${blackList }" var="member" varStatus="status">
    <tr>
      <th scope="row">${status.index+1}</th>
      <c:choose>
      <c:when test="${member.adminNumber ==1 }">
      <td>관리자</td>
      </c:when>
      <c:otherwise>
      <c:if test="${member.adminNumber ==0 }"><td>${member.userID}<br>(일반)</td></c:if>
      <c:if test="${member.adminNumber ==2 }"><td>${member.userID}<br>(실버)</td></c:if>
      <c:if test="${member.adminNumber ==3 }"><td>${member.userID}<br>(골드)</td></c:if>
      <c:if test="${member.adminNumber ==4 }"><td>${member.userID}<br>(플레)</td></c:if>
      <c:if test="${member.adminNumber ==5 }"><td>${member.userID}<br>(다이아)</td></c:if>
      <c:if test="${member.adminNumber ==6 }"><td>${member.userID}<br>블랙회원</td></c:if>     
      </c:otherwise>
      </c:choose>
      <td>${member.userName}(${member.nickName })</td>
      <td>${member.userPW} </td>
      <td>${member.address} / ${member.postCode}</td>
      <td>${member.tel }</td>
      <td>${member.email}</td>
      <td>${member.redate}</td>
      <td>0</td>
      <td>
      <select class="form-control level" >
      <option value="unlevel">회원등급</option>
      <option value="silver">실버</option>
      <option value="gold">골드</option>
      <option value="ple">플레티넘</option>
      <option value="diamond">다이아</option>
      </select> 
      </td>
      <td><button class="btn btn-dark btnBlack" data-no="${member.no}">해제</button> </td>
      <td><button class="btn btn-danger btnDelete" data-no="">삭제</button></td>  
      												<!--data-no  사용자 지정 데이터 특성
      												    특정 클래스를 부여할 수 있음-->
      <td><input type="checkbox" name="removecheck" class="check" value="${member.no}"></td>
      			<!--체크박스 타입은 데이터 넘어갈때 name=value로 넘어갑니다.  -->
    </tr>
    </c:forEach>
  </tbody>
</table>
<button class="btn btn-primary btnBlackAll" id="btnBlackAll">해제</button>
 <select class="btn btn-secondary level" >
      <option value="unlevel" selected>회원등급</option>
      <option value="silver">실버</option>
      <option value="gold">골드</option>
      <option value="ple">플레티넘</option>
      <option value="diamond">다이아</option>
      </select> 
<button class="btn btn-danger" id="btnall">삭제</button>
</form>
<button class="btn btn-primary btnBalckList" onclick="location.href='../member/list'">일반회원관리</button>
</div>
<script>
//전체 선택 후 블랙  ajax 처리
$(".btnBlackAll").on("click",function(){
	let arrayCheck = [];
	$("input:checkbox[name=removecheck]:checked").each(function(){
		arrayCheck.push($(this).val());
	})
	console.log(arrayCheck)	;
	$.ajax({
		url:"../member/blackAll",
		traditional: true,   //ajax 배열 넘기기 옵션
		data:{check:arrayCheck,
			  ad:"0"},
		success:function(data){	
			if(data.isBalck){
					alert("블랙해제되었습니다.")
					location.reload();
				}else{
					alert("오류입니다.")
				} 
		},
		fail:function(){
			
		}
		
	});
	return false;
});
$(".btnBlack").on("click",function(){
		const $parent = $(this).parent().parent();
		console.log($parent)
		$.ajax({
			url:"../member/black",
			data:{no:$(this).data("no"),
				  ad:"0"},
			success:function(data){
				console.log(data);
				if(data.isBalck){
					alert("블랙해제되었습니다..")
					location.reload();
				}else{
					alert("오류입니다.")
				}
			},
			fail:function(){	
			}
		});
		return false;
	});

</script>
<%@ include file="../include/footer.jsp" %>