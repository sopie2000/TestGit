<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<script type="text/javascript" >

$(document).ready(function(){});

/* 페이징 조회 */
function goPage(pageNo) {
    $("#curPageNo").val(pageNo);
    $("#listForm").attr("action","./sampleList.do").submit();
}

function goSearch() {
	$("#listForm").attr("action","./sampleList.do").submit();
}

/* 엑셀다운로드 */
function excelDownload() {
	lodingTimeOut("${contextPath }");
    $("#lodingDiv").show();
	$("#listForm").attr("action","./sampleExcelDown.do");
	$("#listForm").submit();
}
/* 초기화 */
function init() {
	$(".searchClear").val("");
	$("#searchFild option:eq(0)").attr("selected", "selected");
}

/* 상세보기*/
function goDetail(idx) {
	$("#IDX").val(idx);
	$("#method").val("update");
    $("#listForm").attr("action","./sampleForm.do").submit();
}

/* 글쓰기 */
function goWrite() {
	$("#method").val("insert");
    $("#listForm").attr("action","./sampleForm.do").submit();
}

</script>

<form name="listForm" id="listForm" method="get" >
	<input type="hidden" name="curPageNo" id="curPageNo" value="${commonMap.curPageNo }" />
	<input type="hidden" name="method" id="method">
	<input type="hidden" name="type" id="type" value="${commonMap.type}">
	<input type="hidden" name="IDX" id="IDX">
	<input type="hidden" name="IDX_LIST" id="IDX_LIST">
		
		<div class="adm_title_area mg0">
			<h3><c:out value="${typeInfoMap.title}" /></h3>
		</div>
				
		<div class="table_wrap">
			<div class="admin_sh">
				<ul class="sh_list">
					<li>
						<!-- 달력 -->
						<div class="date_pick">
							<label for="from">
								등록일  : <input type="text" id="START_DATE" name="START_DATE"   class="ip01 searchClear" value="<c:out value="${commonMap.START_DATE}" />" style="width:100px;ime-mode:disabled;" maxlength="10" />
									<img src="${contextPath }/images/lb_date.png" alt="날짜 선택" class="ml5" level="1" onclick="getCalenda('START_DATE')" />
							</label> ~
							<label for="to">
									<input type="text" id="END_DATE" name="END_DATE" class="ip01 searchClear" value="<c:out value="${commonMap.END_DATE}" />" style="width:100px;ime-mode:disabled;" maxlength="10" />
									<img src="${contextPath }/images/lb_date.png" alt="날짜 선택" class="ml5" level="1" onclick="getCalenda('END_DATE')" />
							</label>
										
							<select name="searchFild" id="searchFild" class="sel01" style="width: 100px;margin-left: 30px;" >
	                        	<option value="TITLE" ${commonMap.searchFild == "TITLE" ?  "selected" : "" } >제목</option>
	                            <option value="CONTENT" ${commonMap.searchFild == "CONTENT" ?  "selected" : "" }>내용</option>
	                            <option value="ALL" ${commonMap.searchFild == "ALL" ?  "selected" : "" }>전체</option>
							</select>
										
							<input type="text" name="searchText" id="searchText" value="<c:out value="${commonMap.searchText }" />" class="ip01 searchClear" style="width: 300px;" />
							
							<button type="button" class="hgbtn grey01 btn_sh"  onclick="javascript:goSearch();">검색</button>
							<button type="button" class="hgbtn grey02 btn_sh"  onclick="javascript:init();">초기화</button>
							
						</div>
						<!-- //달력 -->
					</li>
				</ul>
			</div>

			<table cellpadding="0" cellspacing="0" border="0" class="adm_type01" summary="" style="width:100%;">
				<caption>Sample List1</caption>
					<colgroup>
						<col width="30" />
						<col width="50" />
						<col width="200" />
						<col width="70" />
						<col width="100" />
						<col width="70" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">구분</th>
							<th scope="col">제목</th>
							<th scope="col">아이디</th>
							<th scope="col">등록일</th>
						</tr>
					</thead>

					<tbody>
					
						<c:choose>
							<c:when test="${fn:length(sampleList) ==0 }">
								<tr>
									<td class="bln" colspan="6" align="center">조회된 데이터가 없습니다.</td>
								</tr>
					       	</c:when>
					        <c:otherwise>
					        	<c:forEach items="${sampleList}" var="sampleList" varStatus="status">
									<tr>
										<td>
											<c:if test='${sampleList.DELETE_YN != "Y" }'>
												<c:out value="${totalCount-((commonMap.curPageNo-1)*commonMap.rowSize)-status.count+1}" />
											</c:if>
										</td>
											
										<td><c:out value="${sampleList.TERMS_TYPE}" /></td>
										<td class="tal">
											<a href="javascript:goDetail(${sampleList.IDX });" class="txt"><c:out value="${sampleList.TITLE }" /></a>
										</td>
										<td><c:out value="${sampleList.REG_ID}" /></td>
										<td><fmt:formatDate value="${sampleList.REG_DATE }" pattern="YYYY-MM-dd" /></td>
									</tr>
					            </c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
			</table>
					
 			<div class="pagenate">
				<%@ include file="/WEB-INF/jsp/common/include/pagination.jsp" %>
			</div>
					
			<div class="ta_btn_area">
				<button type="submit" class="hgbtn grey01 fr" onclick="javascript:goWrite();" >등록</button>
				<button type="button" class="hgbtn grey02 fl" onclick="javascript:excelDownload();">엑셀저장</button>
			</div>
		</div>
</form>