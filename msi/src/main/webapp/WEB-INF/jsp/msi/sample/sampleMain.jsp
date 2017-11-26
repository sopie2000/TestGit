<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<script type="text/javascript" >

$(document).ready(function(){});

/* 엑셀다운로드 */
function excelDownload() {
	lodingTimeOut("${contextPath }");
    $("#lodingDiv").show();
	$("#listForm").attr("action","./list/sampleExcelDown.do");
	$("#listForm").submit();
}

function goList(num, type) {
	
	if (num == 1) {
		$("#type").val(type);
		$("#listForm").attr("action","./list/sampleList.do");
	}else if (num == 2) {
		$("#listForm").attr("action","./map/mainMap.do");
	}
	
	$("#listForm").submit();
}

</script>

<form name="listForm" id="listForm" method="get" >
	<input type="hidden" id="type" name="type" />
	
	<!-- main_container -->
	<div id="main_container">
		<div id="contents">
			<!-- section1 -->
			<div class="ta_btn_area">
				<button type="button" class="hgbtn grey02 fl mr10" onclick="javascript:goList(1,'1001');">게시판</button>
				<button type="button" class="hgbtn grey02" onclick="javascript:goList(2);">지도</button>
				<!-- <button type="button" class="hgbtn grey02" onclick="">트리</button>
				<button type="button" class="hgbtn grey02" onclick="">pdf</button>
				<button type="button" class="hgbtn grey02" onclick="">jqgrid</button>
				<button type="button" class="hgbtn grey02" onclick="">email</button>
				<button type="button" class="hgbtn grey02" onclick="">일정</button>
				<button type="button" class="hgbtn grey02" onclick="">안드로이드 PUSH</button> -->
			</div>			
		</div>
	</div>
</form>