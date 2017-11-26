function popUpCalendar( ) {
	$(document).find(".datepicker").removeClass('hasDatepicker').datepicker({ 
		  showOn: "focus", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
		  nextText: '다음 달', // next 아이콘의 툴팁.
		  prevText: '이전 달', // prev 아이콘의 툴팁.
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
		  currentText: '이번달' , // 오늘 날짜로 이동하는 버튼 패널
		  closeText: '확인',  // 닫기 버튼 패널
		  showAnim: "slide", //애니메이션을 적용한다.
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		  dayNamesMin: ['일','월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] ,
	      dateFormat: 'yy-mm-dd' 

	 });
} 

//다건 캘린더 적용.
function dynamicCalenda(number) {
	
	$(document).find("#ST_DATE_" + number).removeClass('hasDatepicker').datepicker({ 
		  showOn: "focus", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
		  nextText: '다음 달', // next 아이콘의 툴팁.
		  prevText: '이전 달', // prev 아이콘의 툴팁.
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
		  currentText: '이번달' , // 오늘 날짜로 이동하는 버튼 패널
		  closeText: '확인',  // 닫기 버튼 패널
		  showAnim: "slide", //애니메이션을 적용한다.
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		  dayNamesMin: ['일','월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] ,
	      dateFormat: 'yy-mm-dd' ,
		      onClose: function ( selectedDate ) {
		    	  $( "#ED_DATE_"+ number).datepicker("option", "minDate",selectedDate );
		    	  $(this).change();
		      },
		      onSelect: function (selectedDate, inst){
		    	  $( "#ED_DATE_"+ number).datepicker("option", "minDate",selectedDate );
		    	  $(this).change();
	    	  }
		 }).on("change", function(){
			 var date = $( "#ED_DATE_"+number).datepicker().val();
			 $( "#ST_DATE_"+number).datepicker("option", "maxDate",date );
		 });
	
	$(document).find("#ED_DATE_" + number).removeClass('hasDatepicker').datepicker({ 
		  showOn: "focus", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
		  nextText: '다음 달', // next 아이콘의 툴팁.
		  prevText: '이전 달', // prev 아이콘의 툴팁.
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
		  currentText: '이번달' , // 오늘 날짜로 이동하는 버튼 패널
		  closeText: '확인',  // 닫기 버튼 패널
		  showAnim: "slide", //애니메이션을 적용한다.
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		  dayNamesMin: ['일','월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] ,
	      dateFormat: 'yy-mm-dd', 
		      onClose: function ( selectedDate ) {
		    	  $("#ST_DATE_" + number).datepicker("option", "maxDate",selectedDate );
		    	  $(this).change();
		      },
		      onSelect: function (selectedDate, inst){
		    	  $("#ST_DATE_" + number).datepicker("option", "maxDate",selectedDate );
		    	  $(this).change();
	    	  }
		 }).on("change", function(){
			 var date = $("#ST_DATE_" +number).datepicker().val();
			 $( "#ED_DATE_"+number ).datepicker("option", "minDate",date );
			  
		 });
	
	$("#ST_DATE_" + number).datepicker().change();
	$("#ED_DATE_" + number).datepicker().change();
}

$(document).ready(function(){

    $( '.datepicker' ).datepicker( {
		  showOn: "focus", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
		  nextText: '다음 달', // next 아이콘의 툴팁.
		  prevText: '이전 달', // prev 아이콘의 툴팁.
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
		  currentText: '이번달' , // 오늘 날짜로 이동하는 버튼 패널
		  closeText: '확인',  // 닫기 버튼 패널
		  showAnim: "slide", //애니메이션을 적용한다.
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		  dayNamesMin: ['일','월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] ,
	      dateFormat: 'yy-mm-dd' 
	 });
    
    $( "#START_DATE").datepicker( {
		  showOn: "focus", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
		  nextText: '다음 달', // next 아이콘의 툴팁.
		  prevText: '이전 달', // prev 아이콘의 툴팁.
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
		  currentText: '이번달' , // 오늘 날짜로 이동하는 버튼 패널
		  closeText: '확인',  // 닫기 버튼 패널
		  showAnim: "slide", //애니메이션을 적용한다.
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		  dayNamesMin: ['일','월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] ,
	      dateFormat: 'yy-mm-dd' ,
	      onClose: function ( selectedDate ) {
	    	  $( '#END_DATE' ).datepicker("option", "minDate",selectedDate );
	    	  $(this).change();
	      },
	      onSelect: function (selectedDate, inst){
	    	  $( '#END_DATE' ).datepicker("option", "minDate",selectedDate );
	    	  $(this).change();
    	  }
	 }).on("change", function(){
		 var date = $( '#END_DATE' ).datepicker().val();
		 $( '#START_DATE' ).datepicker("option", "maxDate",date );
	 });
    
    $( "#END_DATE").datepicker( {
		  showOn: "focus", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
		  nextText: '다음 달', // next 아이콘의 툴팁.
		  prevText: '이전 달', // prev 아이콘의 툴팁.
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
		  currentText: '이번달' , // 오늘 날짜로 이동하는 버튼 패널
		  closeText: '확인',  // 닫기 버튼 패널
		  showAnim: "slide", //애니메이션을 적용한다.
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		  dayNamesMin: ['일','월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] ,
	      dateFormat: 'yy-mm-dd' ,
	      onClose: function ( selectedDate ) {
	    	  $( '#START_DATE' ).datepicker("option", "maxDate",selectedDate );
	    	  $(this).change();
	      },
	      onSelect: function (selectedDate, inst){
	    	  $( '#START_DATE' ).datepicker("option", "maxDate",selectedDate );
	    	  $(this).change();
    	  }
	 }).on("change", function(){
		 var date = $( '#START_DATE' ).datepicker().val();
		 $( '#END_DATE' ).datepicker("option", "minDate",date );
		  
	 });
    
    $( '.dateYyyymmdd' ).datepicker( {
		  showOn: "focus", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
		  nextText: '다음 달', // next 아이콘의 툴팁.
		  prevText: '이전 달', // prev 아이콘의 툴팁.
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
		  currentText: '이번달' , // 오늘 날짜로 이동하는 버튼 패널
		  closeText: '확인',  // 닫기 버튼 패널
		  showAnim: "slide", //애니메이션을 적용한다.
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		  dayNamesMin: ['일','월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] ,
	      dateFormat: 'yymmdd' 
	 });
    
});

/* 
 * ---------------------------------------------------------------------------------------------
 * 달력이미지 datepicker 활성화 
 * @param calendaId   	캘린더ID
 * ---------------------------------------------------------------------------------------------
 */
function getCalenda(calendaId) {
	$('#' + calendaId).datepicker('show');
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 공통 div 닫기
 * ---------------------------------------------------------------------------------------------
 */
function hiddenDivClose() {

	$("#hiddenDiv").html("");
	$("#hiddenDiv").hide();
}

/* 
 * ---------------------------------------------------------------------------------------------
 * checkbox 전체선택/해제 
 * @param chkAllNm 전체 checkbox name
 * @param chkNm checkbox name
 * ---------------------------------------------------------------------------------------------
 */
function checkAll(chkAllNm, chkNm) {
	
	var chkAll = $("input:checkbox[name=" + chkAllNm + "]");
	var chk = $("input:checkbox[name=" + chkNm + "]");
	
	if(chkAll.is(":checked")== true){
		 chk.each(
				  function() {
					  $(this).prop('checked', true);
				  }		 
		 );
	} else {
	       chk.each(
	                  function() {
	                	  $(this).prop('checked', false);
	                  }      
	         );
	}
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 엔터키 방지
 * @param obj Jquery object
 * ---------------------------------------------------------------------------------------------
 */
function preventEnterKey(obj) {
	//엔터키 submit 방지
	obj.keypress(function(event) {
		  if ( event.which == 13 ) {
		     event.preventDefault();
		   }
	});
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 백그라운드 어둡게 처리하기
 * ---------------------------------------------------------------------------------------------
 */
function dimming() {
	
	$("body").append("<div id='dimmer'></div>");
	$("#dimmer").css("position", 'absolute');
	$("#dimmer").css("top", 0);
	$("#dimmer").css("left", 0);
	$("#dimmer").css("width", '100%');
	$("#dimmer").css("height", $(document).height());
	$("#dimmer").css("background", '#000000');
	$("#dimmer").css("opacity", '0.4');
	$("#dimmer").css("z-index", '10');
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 수자에 콤마(,) 추가 예) 123.format()
 * ---------------------------------------------------------------------------------------------
 */
Number.prototype.format = function(){
    if(this==0) return 0;
 
    var reg = /(^[+-]?\d+)(\d{3})/;
    var n = (this + '');
 
    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');
 
    return n;
};
 
/* 
 * ---------------------------------------------------------------------------------------------
 * 문자에 콤마(,) 추가 예) '123'.format()
 * ---------------------------------------------------------------------------------------------
 */
String.prototype.format = function(){
    var num = parseFloat(this);
    if( isNaN(num) ) return "";
 
    return num.format();
};

/* 
 * ---------------------------------------------------------------------------------------------
 * 콤마(,) 제거하기
 * ---------------------------------------------------------------------------------------------
 */
function removeCommas(str) {
	return str.replace(/[^\d\.\-\ ]/g, '');
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 특정 ID의 element 가 여러 개인 경우 자신의 element가 몇 번째인지 가져오기
 * @param id 엘리먼트 ID
 * @param idx 인덱스
 * @param idx 값
 * ---------------------------------------------------------------------------------------------
 */
function getIndexFromElements(id, el) {
	return $("#"+id).index(el);
}


/* 
 * ---------------------------------------------------------------------------------------------
 * 선택된 체크박스 갯수 조회
 * @param nm 엘리먼트 Name
 * ---------------------------------------------------------------------------------------------
 */
function getCheckCnt(nm) {
	
	var cnt = 0;
	try {
		cnt = $("input:checkbox[name=" + nm + "]:checked").length;
	} catch(e){
		cnt = 0;
	}
	
    return cnt;
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 특정 ID의 element 가 여러 개인 경우 index 번째의 element value 가져오기
 * @param id 엘리먼트 ID
 * @param idx 인덱스
 * ---------------------------------------------------------------------------------------------
 */
function getValueFromElements(id, idx) {
	
	var val = "";
	
	$("#" + id).each(function(index) {
         if(index == idx)  val = $(this).val();
    }); // end of each
    
    return val;
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 특정 ID의 element 가 여러 개인 경우 element value Array를 가져오기
 * @param id 엘리먼트 ID
 * ---------------------------------------------------------------------------------------------
 */
function getValueArrayFromElements(id) {
	
	var values = [];
	
	$("#" + id).each(function(index) {
		values.push($(this).val());
    }); // end of each
    
    return values;
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 선택된 체크박스 순번과 같은 element 값을 가져오기
 * @param id 엘리먼트 ID
 * @param indexArray index array
 * ---------------------------------------------------------------------------------------------
 */
function getValueArrayStringByIndexArray(id, indexArray) {
	
	var values = [];
	
	$.each(indexArray, function(index, value) { 
		values.push(getValueFromElements(id, index));
	});
	
    return values.toString();
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 특정 ID의 element 가 여러 개인 경우 element value를 가져오기
 * @param id 엘리먼트 ID
 * ---------------------------------------------------------------------------------------------
 */
function getValuesFromElements(id) {
    return getValueArrayFromElements(id).toString();
}


/* 
 * ---------------------------------------------------------------------------------------------
 * 특정 ID의 element 가 여러 개인 경우 index 번째의 element 에 값 셋팅하기
 * @param id 엘리먼트 ID
 * @param idx 인덱스
 * @param idx 값
 * ---------------------------------------------------------------------------------------------
 */
function setValueToElements(id, idx, value) {
	$("#" + id).each(function(index) {
        if(index == idx)  {
        	//alert("index:"+index+",idx:"+idx+",value:"+value);
        	$(this).val(value);
        	$(this).attr('title',value);
        }
        
   }); // end of each
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 특정 ID의 체크박스가 여러 개인 경우 index 번째의 element 에 값 셋팅하기
 * @param id 엘리먼트 ID
 * @param idx 인덱스
 * @param idx 값
 * ---------------------------------------------------------------------------------------------
 */
function setValueToCheckboxes(chkName, idx, value) {
	
	var el = $("input:checkbox[name='"+chkName+"']");
	
	el.each(function(index) {
		if(index == idx) $(this).val(value);
    }); // end of each
	
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 선택된 체크박스 엘리먼트의 value를 array에 담아서 가져오기
 * @param id 엘리먼트 ID
 * ---------------------------------------------------------------------------------------------
 */
function getSelectedCheckboxArray(id) {
	
	var values = [];
	var el = $("input:checkbox[name='"+id+"']:checked");
	
	el.each(
            		function() {
            			//alert($(this).val());
            			values.push($(this).val());
            		}      
			);

	return values;
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 선택된 체크박스 엘리먼트의 value를 구분자(,)로 가져오기
 * @param id 엘리먼트 ID
 * ---------------------------------------------------------------------------------------------
 */
function getSelectedCheckboxArrayValue(id) {
	return getSelectedCheckboxArray(id).toString();
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 선택된 체크박스 엘리먼트의 value를 array로 가져오기
 * @param id 엘리먼트 ID
 * @param delimiter 구분자
 * @param idx 가져올 value의 idx
 * ---------------------------------------------------------------------------------------------
 */
function getSelectedCheckboxDelimiterArray(id, delimiter, idx) {
	
	var values = [];
	var el = $("input:checkbox[name='"+id+"']:checked");
	
	el.each(
            function() {
                //alert($(this).val());
            	var vals = $(this).val();
            	
            	if(vals != "" && vals.indexOf(delimiter) > 0) {
            		var val = vals.split(delimiter);
            		values.push(val[idx]);
            	} 
            }      
   );
	
	return values;
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 선택된 체크박스 엘리먼트의 value를 구분자(,)로 담아서 가져오기
 * @param id 엘리먼트 ID
 * @param delimiter 구분자
 * @param idx 가져올 value의 idx
 * ---------------------------------------------------------------------------------------------
 */
function getSelectedCheckboxDelimiterArrayValue(id, delimiter, idx) {
	return getSelectedCheckboxDelimiterArray(id, delimiter, idx).toString();
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 선택된 체크박스 엘리먼트의 index  가져오기
 * @param id 엘리먼트 ID
 * ---------------------------------------------------------------------------------------------
 */
function getSelectedCheckboxArrayIndex(id) {
	
	var values = [];
	var el = $("input:checkbox[name='"+id+"']");
	
	el.each(function(index) {
       if($(this).is(":checked")) {
    	   values.push(index);
       } 
    }); // end of each
	
	return values;
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 선택된 체크박스 엘리먼트의 index  가져오기
 * @param id 엘리먼트 ID
 * ---------------------------------------------------------------------------------------------
 */
function getSelectedCheckboxArrayIndexValue(id) {
	return getSelectedCheckboxArrayIndex(id).toString();
}

/* 
 * ---------------------------------------------------------------------------------------------
 * 라디오 버튼 엘리먼트의 value 가져오기
 * @param id 엘리먼트 ID
 * ---------------------------------------------------------------------------------------------
 */
function getSelectedRadioValue(id) {
	return $("input:radio[name='"+id+"']:checked").val();
}


/* 
 * ---------------------------------------------------------------------------------------------
 * 첨부파일 다운로드
 * @param id  TABLE_NAME , FILE_GUBUN , TARGET_IDX , SEQ , contextPath
 * ---------------------------------------------------------------------------------------------
 */

function getFileDown(TABLE_NAME , FILE_GUBUN , TARGET_IDX , SEQ , contextPath) {

	
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("target", "hidden_frame");
    form.setAttribute("action", contextPath+"/common/file/fileDown.do");
    
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "TABLE_NAME");
    hiddenField.setAttribute("value", TABLE_NAME);
    form.appendChild(hiddenField);

    
    var hiddenField2 = document.createElement("input");
    hiddenField2.setAttribute("type", "hidden");
    hiddenField2.setAttribute("name", "FILE_GUBUN");
    hiddenField2.setAttribute("value", FILE_GUBUN);
    form.appendChild(hiddenField2);

    
    var hiddenField3 = document.createElement("input");
    hiddenField3.setAttribute("type", "hidden");
    hiddenField3.setAttribute("name", "TARGET_IDX");
    hiddenField3.setAttribute("value", TARGET_IDX);
    form.appendChild(hiddenField3);

    
    var hiddenField4 = document.createElement("input");
    hiddenField4.setAttribute("type", "hidden");
    hiddenField4.setAttribute("name", "SEQ");
    hiddenField4.setAttribute("value", SEQ);
    form.appendChild(hiddenField4);
   
    document.body.appendChild(form);
    form.submit();

	
}





/* 
 * ---------------------------------------------------------------------------------------------
 * 첨부파일 삭제
 * @param id 파일 경로
 * ---------------------------------------------------------------------------------------------
 */


function getFileDelete(TABLE_NAME , FILE_GUBUN , TARGET_IDX , SEQ , contextPath){

	if(confirm("정말 삭제하시겠습니까?")){
		$.ajax(
	            {
	                url: contextPath+"/cmmn/fileDelete.do",
	                type: "post",
	                data: {"TABLE_NAME": TABLE_NAME  , "FILE_GUBUN": FILE_GUBUN  , "TARGET_IDX": TARGET_IDX  , "SEQ": SEQ },
	                dataType: "html",
	                error: function(){
	                	alert( '삭제중 에러가 발생하였습니다.' );
	                },
	
	                beforeSend: function(){
	                  
	                },
	                complete: function(){
	                   
	                },
	                success: function( strData ){
	                	if(strData == "success"){
	                		alert("정상적으로 삭제되었습니다.");
	                		funcFileList(TABLE_NAME , FILE_GUBUN , TARGET_IDX , 'N' , contextPath );
	                	}else{
	                    	alert( '삭제중 에러가 발생하였습니다.' );
	                	}
	                }
	            }                           
	        );
	}


}


/* 
 * ---------------------------------------------------------------------------------------------
 * 첨부파일 조회&등록&다운&삭제
 * ---------------------------------------------------------------------------------------------
 */ 
function funcFileList(TABLE_NAME , FILE_GUBUN , TARGET_IDX , DELETE_YN , contextPath ){
	
	$.ajax(
            {
                url: contextPath+'/cmmn/fileList.do',
                type: "post",
                data: {"TABLE_NAME": TABLE_NAME  , "FILE_GUBUN": FILE_GUBUN  , "TARGET_IDX": TARGET_IDX  , "DELETE_YN": DELETE_YN },
                dataType: "html",
                error: function(){
                	alert( '조회중 에러가 발생하였습니다.' );
                },

                beforeSend: function(){
                  
                },
                complete: function(){
                   
                },
                success: function( strData ){
                	    $('#attFileDiv').html(strData);
                }
            }                           
        );


}


/* 
 * ---------------------------------------------------------------------------------------------
 * 주소검색
 * @param zip, add1, add2
 * ---------------------------------------------------------------------------------------------
 */ 
function execDaumPostcode(zip, add1, add2) {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            
            // 우편번호와 주소 정보를 해당 필드에 넣는다. 
            $('#'+zip).val(data.zonecode); //5자리 새우편번호 사용
            $('#'+add1).val(fullAddr) 

            // 커서를 상세주소 필드로 이동한다.
            $('#'+add2).focus();  
        }
    }).open();
}


/* 
 * ---------------------------------------------------------------------------------------------
 * 숫자만입력 
 * @param exct : 예외 이벤트키코드
 * ---------------------------------------------------------------------------------------------
 */ 
 
function fNumber(exct){   
	e = window.event;     
	if( ( e.keyCode >=  48 && e.keyCode <=  57 ) ||   
		( e.keyCode >=  96 && e.keyCode <= 105 ) ||    
		e.keyCode ==   8 ||    
		e.keyCode ==  46 ||   
		e.keyCode ==  37 ||  
		e.keyCode ==  39 ||  
		e.keyCode ==  35 ||   
		e.keyCode ==  36 ||     
		e.keyCode ==   9       
	) { 
		return; 
	} 
	if(typeof(exct) != "undefined" && e.keyCode == exct){
		return; 
	}
	else{   
		e.returnValue=false; 
	} 
};

/* 
 * ---------------------------------------------------------------------------------------------
 * 콤마(,) 넣기
 * ---------------------------------------------------------------------------------------------
 */ 
function Comma(input) 
{   
	if(input!=null){
		var inputString = new String;  
		var outputString = new String;  
		var counter = 0;  
		var decimalPoint = 0;  
		var end = 0;  
		var modval = 0;   
		
		inputString = input.toString();  
		outputString = '';  
		decimalPoint = inputString.indexOf('.', 1);   
		if(decimalPoint == -1) {     
			if (inputString.indexOf('-') > -1) {
				inputString = inputString.replace('-', '');
				end = inputString.length - (inputString.charAt(0)=='0' ? 1:0);     
				for (counter=1;counter <=inputString.length; counter++)     {        
					var modval =counter - Math.floor(counter/3)*3;   
					outputString = (modval==0 && counter <end ? ',' : '') + inputString.charAt(inputString.length - counter) + outputString;     
				}
				outputString = "-" + outputString;
			}else{
				end = inputString.length - (inputString.charAt(0)=='0' ? 1:0);     
				for (counter=1;counter <=inputString.length; counter++)     
				{        
					var modval =counter - Math.floor(counter/3)*3;   
					outputString = (modval==0 && counter <end ? ',' : '') + inputString.charAt(inputString.length - counter) + outputString;     
				}
			}
		}  else{     
			end = decimalPoint - ( inputString.charAt(0)=='-' ? 1 :0);     
			for (counter=1; counter <= decimalPoint ; counter++)     
			{        
				outputString = (counter==0  && counter <end ? ',' : '') +  inputString.charAt(decimalPoint - counter) + outputString;     
			}     
			for (counter=decimalPoint; counter < decimalPoint+3; counter++)     
			{        
				outputString += inputString.charAt(counter);     
			} 
		}    
		return (outputString);
	}
} 




/* 
 * ---------------------------------------------------------------------------------------------
 * 공통 코드 (콤보박스)
 * ---------------------------------------------------------------------------------------------
 */ 
function func_commonComboCode(categoryId , defalutName , defalutCode , parentCode , childValue , contextPath  ){
	 
	 $('#'+categoryId).children().remove();
	 
	 $.ajax(
	            {
	                url: contextPath+"/common/common/commonCodeList.do",
	                type: "post",
	                data: {"PARENT_CODE": parentCode},
	                dataType: "json",
	                error: function(){
	                	alert( '삭제중 에러가 발생하였습니다.' );
	                },
	
	                beforeSend: function(){
	                  
	                },
	                complete: function(){
	                   
	                },
	                success: function( strData ){
		               	 $('#'+categoryId).append('<option value="'+defalutCode+'">'+defalutName+'</option>');
	                	for(var i = 0 ; i  < strData["commonCodeList"].length ; i ++){
	                		if(childValue == strData["commonCodeList"][i].common_code ){
				               	 $('#'+categoryId).append('<option value="'+strData["commonCodeList"][i].common_code+'" selected>'+strData["commonCodeList"][i].code_name+'</option>');
	                		}else{
				               	 $('#'+categoryId).append('<option value="'+strData["commonCodeList"][i].common_code+'">'+strData["commonCodeList"][i].code_name+'</option>');
	                		}
	                		
		               	 
	                	}
	                }
	            }                           
	        );
}


String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};
/*
* ClassName : stringUtil
* Description : 문자열 관련 Class
*/
var stringUtil = {
    /* 문자열확인 후 문자열 또는 기본값 리턴
    str:체크 문자열 def:기본값 */
    getString: function(str, def){
        if (str != undefined && str && str != "" && str != "null"){
            return $.trim(str);
        } else {
            return $.trim(def);
        }
    },
    /* 정수형 확인 후 정수형 또는 기본값 리턴
    num:체크 정수형 / def:기본값 */
    getInt: function(num, def){
        var val = parseInt(num, 10);

        if (isNaN(val)){
            return def;
        } else {
            return val;
        }
    },
    /* 공백제거
    str: 공백 제거 할 문자열*/
    trim: function(str){
        return $.trim(str);
    },
    /* Date
    */
    getDateView: function(regdt){

        var yyyy = regdt.substring(0, 4);
        var MM = regdt.substring(4, 6)-1;
        var dd = regdt.substring(6, 8);
        var hh = regdt.substring(8, 10);
        var mm = regdt.substring(10, 12);
        var ss = regdt.substring(12, 14);

        var nowDate = new Date();
        var regDate = new Date(yyyy, MM, dd, hh, mm, ss);

        var ss = Math.floor(nowDate.getTime() - regDate.getTime() ) / 1000;
        var mm = Math.floor(ss / 60);
        var hh = Math.floor(mm / 60);
        var day = Math.floor(hh / 24);

        var diff_hour = Math.floor(hh % 24);
        var diff_minute = Math.floor(mm % 60);
        var diff_second = Math.floor(ss % 60);

        //console.log( regdt + ' 계산 시간   : ' + day +  '일 ' + diff_hour  + ' 시간 ' + diff_minute + ' 분 ' + diff_second  + ' 초 ');
        var returnDate = "";
        if (day > 1 || diff_hour > 1){
            returnDate = regDate.format("yyyy.MM.dd HH:mm");
        } else {
            returnDate = diff_minute + "분 전";
        }

        return returnDate;
    },
    /* Format Date
    */
    formatDate: function(regdt, f){
    	if (stringUtil.getString(regdt, "") == ""){
    		return "-";
    	} else {
	        var yyyy = regdt.substring(0, 4);
	        var yy = regdt.substring(2, 4);
	        var MM = regdt.substring(4, 6);
	        var dd = regdt.substring(6, 8);
	        var hh = regdt.substring(8, 10);
	        var mm = regdt.substring(10, 12);
	        var ss = regdt.substring(12, 14);
	
	        return f.replace(/(yyyy|yy|MM|dd|hh|mm|ss)/gi, function($1) {
	            switch ($1) {
	                case "yyyy": return yyyy;
	                case "yy": return yy.zf(2);
	                case "MM": return MM.zf(2);
	                case "dd": return dd.zf(2);
	                case "hh": return hh.zf(2);
	                case "mm": return mm.zf(2);
	                case "ss": return ss.zf(2);
	                default: return $1;
	            }
	        });
    	}
    },
    /* set Comma */
    setComma: function(num){
        var pattern = /(^[+-]?\d+)(\d{3})/;
        num += '';
        while (pattern.test(num)){
            num = num.replace(pattern, '$1' + ',' + '$2');
        }
        return num;
    },
    /* remove Comma */
    removeComma: function(num){
        return num.replace(/,/gi,"");
    },
    /* replaceAll */
    replaceAll : function(str, searchStr, replaceStr) {
        return str.split(searchStr).join(replaceStr);
    }
    ,
    /* Number 체크 */
    isNumber : function(nVal) {
    	var regex = /^[0-9]+$/;
        return regex.test(nVal);
    },
    /* URL 체크 */
    isUrl: function(nVal) {
    	var regex = /^((http(s?))\:\/\/)([0-9a-zA-Z\-]+\.)+[a-zA-Z]{2,6}(\:[0-9]+)?(\/\S*)?$/;
        return regex.test(nVal);
    },
    setPer: function(n1, n2){
    	if (n1 == 0)
    	{
    		return 0;
    	} else {
    		try {
    			return Math.round((n2/n1)*10000)/100;	
    		} catch (e) {	
    			return 0;
    		}
    	}
    },
    setPer2: function(n1, n2){
    	if (n1 == 0)
    	{
    		return 0;
    	} else {
    		try {
    			return Math.round((n2/n1)*100)/100;	
    		} catch (e) {	
    			return 0;
    		}
    	}
    }
};


/* 
 * ---------------------------------------------------------------------------------------------
 * 글자수제한
 * ---------------------------------------------------------------------------------------------
 */ 
function queryOnkeyUp(obj, max){     
	
	var ari_max=max;
	var ls_str = $(obj).val();  
	var li_str_len = ls_str.length;  
	 
	var li_max = ari_max;  
	var i = 0;  
	var li_byte = 0; 
	var li_len = 0;   
	var ls_one_char = ""; 
	var ls_str2 = "";  
	
	for(i=0; i< li_str_len; i++) {  
			ls_one_char = ls_str.charAt(i);  
		if (escape(ls_one_char).length > 4) { 
			li_byte += 3; 
		}else{   
			li_byte++; 
		}  
		if(li_byte <= li_max){ 
			li_len = i + 1; 
		} 
	} 

	if(li_byte > li_max){ 
		alert(ari_max+"byte 글자를 초과 입력할수 없습니다. \n 초과된 내용은 자동으로 삭제 됩니다. "); 
		ls_str2 = ls_str.substr(0, li_len); 
		$(obj).val(ls_str2); 
	} 
	$(obj).focus(); 		
}




/**프로그래시바*/
var lodingCheck = true;
function lodingTimeOut(contextPath){
	
	if(lodingCheck){

		setTimeout( function(){
			
			$.ajax(
		            {
		                url: contextPath+'/common/common/excelSessionCheck.do',
		                type: "post",
		                ype: "post",
		                dataType: "html",
		                error: function(){
		                	alert( "시스템 오류입니다. 관리자에게 문의하세요." );
		                },
		                beforeSend: function(){
		                    
		                },
		                complete: function(){
		                    
		                },
		                success: function( strData ){
		                	if(strData == "start"){
			                	lodingTimeOut();
		                	}else{
		                	    $("#lodingDiv").hide();
		                	}
		                }
		            }                           
		        );
		},1000);
	}

}

/*
* function Name : $.fn.rowspan
* Description : table rowspan 자동합치기
* 예 : $('#아이디').rowspan(1);
*/
$.fn.rowspan = function(colIdx, isStats) {       
	return this.each(function(){      
		var that;     
		$("tr", this).each(function(row) {      
			$("td:eq("+colIdx+")", this).each(function(col) {
				if ($.trim($(this).html()) == $.trim($(that).html())
					&& (!isStats 
							|| isStats && $.trim($(this).prev().html()) == $.trim($(that).prev().html())
							)
					) {            
					rowspan = $(that).attr("rowspan") || 1;
					rowspan = Number(rowspan)+1;

					$(that).attr("rowspan",rowspan);
					
					$(this).empty().hide();
					//$(this).hide();
				} else {            
					that = this;         
				}          
				
				that = (that == null) ? this : that;      
			});     
		});    
	});  
}; 