<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/include/defaultHeader.jsp" %>
<body>
	
	<!-- wrap -->
	<div id="wrap">
	
		<!-- 헤더 -->
		<div id="header">
       		<tiles:insertAttribute name="gnb" />
       	</div>
		<!-- //헤더 -->
	
		<!-- 컨테이너 -->
		<div id="container">
       		<tiles:insertAttribute name="lnb" />
			<!-- 컨텐츠 -->
			<div id="contents">
	        	<tiles:insertAttribute name="body" />
	        </div>
		</div>
		<!-- //컨테이너 -->
	 
	</div>
	<!-- //wrap -->
	<iframe id="hidden_frame" name="hidden_frame" style="display:none" > </iframe>
	
<div id='lodingDiv'  style='display:none;position:absolute;z-Index:9999;top:'><img src="${contextPath }/_sitemgr/images/progress.gif" /></div>
 <script>
$("#lodingDiv").attr("style","display:none;position:absolute;z-Index:9999;top:"+(document.body.clientHeight/2-50)+"px;left:"+(document.body.clientWidth/2-50)+"px");
</script>	
</body>	 
</html>	