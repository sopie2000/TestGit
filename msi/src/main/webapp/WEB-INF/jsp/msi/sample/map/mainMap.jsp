<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<script type="text/javascript" >

$(document).ready(function(){});

function goMap(type) {
	if (type == 1) {
		$("#listForm").attr("action","/sample/map/googleMap.do");
	} else if (type == 2) {
		$("#listForm").attr("action","/sample/map/naverMap.do");
	} else if (type == 9) {
		$("#listForm").attr("action","/sample/sampleMain.do");
	}
	$("#listForm").submit();
}

</script>

<form name="listForm" id="listForm" method="get">
	<div class="adm_title_area mg0">
		<h3><span id="header_title">Map Api 테스트</span></h3>
	</div>
	
	<div class="ta_btn_area">
		<button type="button" class="hgbtn grey02 fl mr10" onclick="javascript:goMap(1);">Google Map</button>&nbsp;&nbsp;
		<button type="button" class="hgbtn grey02 fl" onclick="javascript:goMap(2);">Naver Map</button>&nbsp;&nbsp;
	</div>
	
	
	<button type="button" class="hgbtn grey02 fl mr10" onclick="javascript:goMap('9');">메인</button>&nbsp;&nbsp;
</form>			