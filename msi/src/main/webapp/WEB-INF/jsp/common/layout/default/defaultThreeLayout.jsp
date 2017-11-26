<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/include/frontHeader.jsp" %>
 <body>
	<div id="wrap">
	 
		 <!-- 상단시작 -->
		 <div id="Gnb">
	        	<tiles:insertAttribute name="gnb" />
		 </div>
		 <!-- 상단끝 -->
		 
		 <!-- 중단시작 -->
		 <div id="container"  style="height: 800px;">
		    <!-- 컨텐츠시작 -->
			<div id="contents2">
				<tiles:insertAttribute name="body" />
			</div>
			  <!-- 컨텐츠끝 -->
		 </div>
		 <!-- 중단끝 -->
		 
		 <!-- 하단시작 -->
	     <tiles:insertAttribute name="footer" />
		 <!-- 하단끝 -->
	 
	</div>
 </body>
</html>