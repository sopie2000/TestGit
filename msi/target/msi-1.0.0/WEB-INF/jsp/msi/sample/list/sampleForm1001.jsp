<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>

<!-- 에디터 -->
<script type="text/javascript" language="javascript" src="${contextPath }/ckeditor/ckeditor.js"></script>
<script type="text/javascript" >

var oFORM = null;
$(document).ready(function() {
	oFORM = document.writeForm;
	/**에디터*/
	CKEDITOR.replace('CONTENT', {
		filebrowserImageUploadUrl: '${contextPath }/common/editImgUpload.do'
	});
});

/* 검색  */
function goSearch() {
	$("#writeForm").attr("action","./sampleList.do").submit();
}

/* 글쓰기 */
function goSave() {
	/**에디터*/
	var str = CKEDITOR.instances.CONTENT.getData();
	$("#CONTENT").val(str);
		
    if ( !checkForm(document.writeForm)) {
    	return;
    }
    
    $('#writeForm').attr("target","hidden_frame");
    $('#writeForm').attr("action","./sampleSave.do").submit();
}

function callHiddenFrame(callbackCode){
	alert(1);
	
	if (callbackCode=="success") {
		alert("정상적으로 저장되었습니다.");
		$('#writeForm').attr('target','_self');
		$('#writeForm').attr('encoding','application/x-www-form-urlencoded');
		$('#writeForm').attr('action','./sampleList.do');
		$('#writeForm').submit();
	} else if (callbackCode=="deleteSuccess") {
		alert("정상적으로 삭제되었습니다.");
		$('#writeForm').attr('target','_self');
		$('#writeForm').attr('encoding','application/x-www-form-urlencoded');
		$('#writeForm').attr('action','./sampleList.do');
		$('#writeForm').submit();
	} else {
		alert("저장중 에러가 발생하였습니다.");
	}
}
</script>

<form name="writeForm" id="writeForm" method="post" enctype="multipart/form-data" >
	<input type="hidden" name="curPageNo" id="curPageNo" value="${commonMap.curPageNo }" />
	<input type="hidden" name="IDX" id="IDX" value="${commonMap.IDX }">
	<input type="hidden" name="method" id="method" value="${commonMap.method }">
	<input type="hidden" name="type" id="type" value="${commonMap.type }">
	
		<div class="adm_title_area mg0">
			<h3><span id="header_title">${typeInfoMap.title }</span></h3>
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
						<th scope="row" colspan="2" class="bln">*제목</th>
						<td class="tal" colspan="3">
							<input type="text" name="TITLE" id="TITLE" class="ip01" style="width:100%;" msg="제목" value='<c:out value="${sampleDetail.TITLE }" escapeXml="true"/>' />
						</td>
					</tr>
					<tr>
						<th scope="row" colspan="2" class="bln">*내용</th>
						<td class="tal" colspan="3">
							<!-- 내용 출력 -->
							<div class="editor_txt">
								<p>
									<TABLE style="width:100%">
										<TR>
											<TD>
												<textarea id="CONTENT" name="CONTENT" style="width:100%; height:600px;"  type="TEXTAREA" msg="내용" ><c:out value="${sampleDetail.CONTENT }" escapeXml="false"/></textarea>
											</TD>
										</TR>
									</TABLE>
								</p>
							</div>
							<!-- //내용 출력 -->
						</td>
					</tr>
				</tbody>
			</table>
					
			<div class="ta_btn_area">
				<button type="button" class="hgbtn grey02 fl mr10" onclick="javascript:goSearch();">목록</button>&nbsp;&nbsp;
				<button type="button" class="hgbtn grey01 fr" onclick="javascript:goSave();">저장</button>
			</div>
		</div>
</form>			