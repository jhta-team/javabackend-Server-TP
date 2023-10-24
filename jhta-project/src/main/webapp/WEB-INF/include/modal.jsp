<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>    
<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModal" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">나는 모달</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div> -->
      <div class="modal-body">
        <%-- ${param.msg } --%>
        ${modalState.msg }
      </div>
      <div class="modal-footer">
      <c:choose>
      <c:when test="${param.modalCheck == '1'}"> <!--업데이트시 모달창으로 변경여부 확인 -->
       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href='../member/info'">확인</button>
       <a  class="btn btn-primary"  href="javascript:history.back();">취소</a>
      </c:when>
      <c:otherwise>
      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
      </c:otherwise>
      </c:choose>
       
      
      
      </div>
    </div>
  </div>
</div>	