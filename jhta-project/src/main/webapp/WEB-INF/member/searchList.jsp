<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<div class="container-fluid">
<table class="table">
  <thead class="table-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">신규 회원</th>
      <th scope="col">방문회원</th>
      <th scope="col">총회원</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>${insertCount}명</td>
      <td>${loginCount}명</td>
      <td>${memberCount}명</td>
    </tr>
  </tbody>
</table>
<button class="btn btn-dark btnBalckList" onclick="location.href='../member/blackList'">블랙리스트관리</button>

<form action="../member/deleteAll">
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
      <th scope="col">등급</th>
      <th scope="col">블랙</th>
      <th scope="col">삭제</th>
      <th scope="col"><input type="checkbox" id="checkAll" ></th>
    </tr>
  </thead>
  <tbody>
  		<c:forEach items="${memberList }" var="member" varStatus="status">
    <tr>
      <th scope="row">${status.index}</th>
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
      <select class="btn btn-secondary level" name="level" >
      <option value="un,${member.no}">회원등급</option>
      <option value="si,${member.no}">실버</option>
      <option value="go,${member.no}">골드</option>
      <option value="pl,${member.no}">플레티넘</option>
      <option value="di,${member.no}">다이아</option>
      <option value="ad,${member.no}">관리자</option>
      </select> 
      </td>
      <td><button class="btn btn-dark btnBlack" data-no="${member.no}">블랙</button> </td>
      <td><button class="btn btn-danger btnDelete" data-no="${member.no}">삭제</button></td>  
      												<!--data-no  사용자 지정 데이터 특성
      												    특정 클래스를 부여할 수 있음-->
      <td><input type="checkbox" name="removecheck" class="check" value="${member.no}"></td>
      			<!--체크박스 타입은 데이터 넘어갈때 name=value로 넘어갑니다.  -->
    </tr>
    </c:forEach>
  </tbody>
</table>
<button class="btn btn-dark btnBlackAll" id="btnBlackAll">블랙</button>
 <select class="btn btn-secondary btnLevel" name="allLevel">
      <option value="unlevel" selected>회원등급</option>
      <option value="silver">실버</option>
      <option value="gold">골드</option>
      <option value="ple">플레티넘</option>
      <option value="diamond">다이아</option>
      <option value="admin">관리자</option>
      </select> 
<button class="btn btn-danger" id="btnall" >삭제</button>
<button class="btn btn-primary" onclick="location.href='../member/list'">전체</button>
</form>
<form action="../member/searchList">
				<select class="btn btn-primary btnSearch" name="search" >
					<option value="userName">이름</option>
					<option value="nickName">닉네임</option>
					<option value="userID">아이디</option>
					<option value="level">등급</option>
					<option value="all">전체</option>
				</select>
				<span class="serachLevel">
				<input class="serachword" type="text" name="searchword">
				<input type="hidden" name="length" value=" ${fn:length(memberList)}">
				</span>
				<button>검색</button>
</form>
 
<nav aria-label="Page navigation example">
  	<ul class="pagination justify-content-center">
     			<li class="page-item">
     				 <a class="page-link" href="../member/searchList?search=${search }&searchword=${searchword }&page=${intpage -1 }" aria-label="Previous">
      				  <span aria-hidden="true">&laquo;</span>
      				</a>
    			</li>
    			
    			<c:forEach var="i" begin="${startpage }" end="${endpage }" step="1">
    			<c:choose>
    			<c:when test="${i==intpage }">
    			<li class="page-item">
    			<a class="page-link active" href="../member/searchList?search=${search }&searchword=${searchword }&page=${i }">${i }</a>
    			</li>    
    			</c:when>
    			<c:otherwise>
    			<li class="page-item">
    			<a class="page-link " href="../member/searchList?search=${search }&searchword=${searchword }&page=${i}">${i }</a>
    			</li>    
    			</c:otherwise>
    			</c:choose>
    						
    			</c:forEach>
    			
    			<li class="page-item">
      			<a class="page-link" href="../member/searchList?search=${search }&searchword=${searchword }&page=${intpage +1 }" aria-label="Next">
        		<span aria-hidden="true">&raquo;</span>
     			 </a>
    			</li>
  </ul>
</nav>
</div>

<script>
	$(".btnSearch").on("change",function(){
		if($(".btnSearch").val()=="level"){
			$(".serachword").attr("type","hidden");
			$(".serachLevel").html(`<select class=" btnLevel" name="searchword">
					  <option value="0">일반</option>
					  <option value="2">실버</option>
				      <option value="3">골드</option>
				      <option value="4">플레티넘</option>
				      <option value="5">다이아</option>
				      <option value="1">관리자</option>
				      </select> `)
		}else{
			$(".serachLevel").html(`<input class="serachword" type="text" name="searchword">`)
		}
	})
	// 삭제기능
	$(".btnDelete").on("click",function(){
		$.ajax({
			url:"../member/delete-process02",
			data:{no:$(this).data("no")},
			success:function(data){
 				console.log(data);
 				if(data.isDelete){
 					alert("삭제되었습니다.")
 					location.reload();
 				}else{
 					alert("오류입니다.")
 				}
 			},
 			fail:function(){	
 			}	
		})
		return false;
	})
	// 회원등급 조정 기능
	$(".level").on("change",function(){
		$.ajax({
			url:"../member/level",
			data:{level:$(this).val()},
			success:function(data){
 				console.log(data);
 				if(data.isLevel){
 					alert("변경되었습니다.")
 					location.reload();
 				}else{
 					alert("오류입니다.")
 				}
 			},
 			fail:function(){	
 			}
		});
		return false;
	})
	//회원등급 일괄 처리
	$(".btnLevel").on("change",function(){
		let arrayLevelCheck =[];
		$("input:checkbox[name=removecheck]:checked").each(function(){
			arrayLevelCheck.push($(this).val());
		})
		$.ajax({
			url:"../member/levelAll",
			traditional: true,   //ajax 배열 넘기기 옵션
			data:{no:arrayLevelCheck,
				  level:$(this).val()},
			success:function(data){	
				if(data.isLevel){
 					alert("변경되었습니다.")
 					location.reload();
 				}else{
 					alert("오류입니다.")
 				} 
			},
			fail:function(){
				
			}
		})
		return false;
	})
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
				ad:"6"},
			success:function(data){	
				if(data.isBalck){
 					alert("블랙입니다.")
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
 				  ad:"6"},
 			success:function(data){
 				console.log(data);
 				if(data.isBalck){
 					alert("블랙입니다.")
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
 	//체크박스 전체 선택 및 해체 기능
	$("#checkAll").on("change",function(){
		if($("#checkAll").is(":checked")){
		 $(".check").prop("checked",true)	;		
		}else{
	     $(".check").prop("checked",false);
		}
	})
</script>
<%@ include file="../include/footer.jsp" %>