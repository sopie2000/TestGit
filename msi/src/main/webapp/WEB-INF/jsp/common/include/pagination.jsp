<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 페이징 긑 -->
<div class="page">
	<c:if test="${ pagination != null}">
		<c:if test="${ pagination.totalPageCnt > pagination.pageSize }">
		    <c:choose>
		        <c:when test="${pagination.firstPageNo > pagination.pageSize}">
		           <a href="javascript:goPage('1');" title="맨처음페이지" class="page_btn first">&lt;&lt;</a> 
		           <a href="javascript:goPage('${pagination.firstPageNo-1}');" title="이전리스트" class="page_btn prev">&lt;</a>
		        </c:when>
		        <c:otherwise>
		           <a href="javascript:goPage('1');" title="맨처음페이지" class="page_btn first">&lt;&lt;</a> 
		           <a href="javascript:goPage('1');" title="이전리스트" class="page_btn prev">&lt;</a>
		        </c:otherwise>
		    </c:choose>
		</c:if>
		<c:forEach var="pageNo" begin="${pagination.firstPageNo}" end="${pagination.lastPageNo}" step="1">
		     <c:choose>
		        <c:when test="${pageNo == pagination.curPageNo}">
		           <span class="page_num"><a class="on">${pageNo}</a></span> 
		        </c:when>
		        <c:otherwise>
		           <span class="page_num"><a href="javascript:goPage('${pageNo}');">${pageNo} </a></span>
		        </c:otherwise>
		    </c:choose>
		</c:forEach>
		<c:if test="${ pagination.totalPageCnt > pagination.pageSize }">
		    <c:choose>
		        <c:when test="${pagination.lastPageNo < pagination.totalPageCnt}">
		           <a href="javascript:goPage('${pagination.firstPageNo+pagination.pageSize}');" title="다음리스트" class="page_btn next">&gt;</a> 
		           <a href="javascript:goPage('${pagination.totalPageCnt}');" title="맨 끝페이지" class="page_btn end">&gt;&gt;</a>
		        </c:when>
		        <c:otherwise>
		           <a href="javascript:goPage('${pagination.totalPageCnt}');" title="다음리스트" class="page_btn next">&gt;</a> 
		           <a href="javascript:goPage('${pagination.totalPageCnt}');" title="맨 끝페이지" class="page_btn end">&gt;&gt;</a>
		        </c:otherwise>
		    </c:choose>
		</c:if>
	</c:if>
</div>
<!-- //페이징 -->