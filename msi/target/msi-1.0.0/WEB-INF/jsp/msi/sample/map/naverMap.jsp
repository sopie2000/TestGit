<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=yzIq0shpbVcSEaBytmXU"></script>
<script>

$(document).ready(function() {
	
	var mapOptions = {
		    center: new naver.maps.LatLng(37.3595704, 127.105399),
		    zoom: 10
		}
	
	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(37.3595704, 127.105399),
	    zoom: 10
	});
	
});


function goMap() {
	$("#frm").attr("action","./mainMap.do");
	$("#frm").submit();
}
</script>

<form name="frm" id="frm" method="post" enctype="multipart/form-data" >
		<div class="adm_title_area mg0">
			<h3><span id="header_title">Naver Map Test(작업예정)</span></h3>
		</div>

		<div class="table_wrap">
			<table cellpadding="0" cellspacing="0" border="0" class="adm_type01" summary="" style="width:100%;">
				<caption></caption>
				<colgroup>
					<col width="50" />
					<col width="150" />
					<col width="" />
					<col width="100" />
					<col width="150" />
				</colgroup>

				<tbody>
					<tr>
						<th scope="row" colspan="2" class="bln">주소</th>
						<td class="tal" colspan="3">
							<input type="text" id="address" name="address" readonly="readonly" value="" style="width:100%;" />
						</td>
					</tr>
					<tr>
						<th scope="row" colspan="2" class="bln">지도</th>
						<td class="tal" colspan="3">
							<div id="map" style="width:100%;height:400px;"></div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="ta_btn_area">
				<button type="button" class="hgbtn grey02 fl mr10" onclick="javascript:goMap();">목록</button>&nbsp;&nbsp;
				<button type="button" class="hgbtn grey02 fl" onclick="">초기화</button>&nbsp;&nbsp;
			</div>
		</div>
</form>			