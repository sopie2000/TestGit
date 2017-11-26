/********************************************************************
 *
 * Form 관련 스크립트 함수 모음
 *
 *******************************************************************/


function checkID(obj) {
 var v = obj.value;
 if(v.length == 0) return false;
   if (/^[a-zA-Z0-9]{5,15}$/.test(v)) {
    if (!/[a-zA-Z]/.test(v)) {
     alert("아이디에 영문자가 반드시 한자 이상 포함되어야 합니다.");
     obj.select();
     return false;
    }
    return true;
   }
   if (v.length < 6 || v.length > 12)
    alert("아이디는 6자 에서 15자 까지만 허용합니다.");
   else
    alert("아이디에 숫자나 영문자가 아닌 문자가 포함되어 있습니다.");
 obj.select();
   return false;
}

//이미지 업로드 파일 체크
function fileCheck (){
	var str = $("#files").val();
	var dot = str.lastIndexOf(".");
	var ext = str.substring(dot).toLowerCase();
	if(ext != ".jpg" && ext != ".jpeg" && ext != ".gif" && ext != ".bmp"){
		return false;
	}else{
		return true;
	}
}


//숫자만 입력받는 폼 체크
	function isNum(field, name) { 
	 var valid = '0123456789-.';
	 var temp; 
	
	 for (var i=0; i<field.value.length; i++) { 
	  temp = '' + field.value.substring(i, i+1); 
	  if (valid.indexOf(temp) == "-1") {
	   field.value='';
	   field.focus(); 
	   return false; 
	  }
	 } 
	 return true; 
	}

 
 
	var initFormName = null; // initForm에 사용될 폼 이름 (추후 content페이지에서 재정의됨)

	// 검색 검증 함수
	function checkFormSearch(f , checkNum ) {
		var fLen = f.elements.length;
		var fObj;	// 폼 요소
		var fTyp;	// 폼 요소 Type
		var fVal;	// 폼 요소 Value
		var fMsg;	// 경고 메시지 속성
		var funnMsg = "";	// 경고 메시지 전체 속성
		var fMin;	// 최소 길이 지정
		var fMinMsg;	// 최소 길이 지정 메세지
		
		
		var checkCount = 0;
		
		for (i=0;i<fLen;i++) {
			fObj = f.elements[i];
			fTyp = toUpperCase(fObj.getAttribute("type"));
			fId = fObj.getAttribute("id");
			fVal = $('#'+fId).val();
			fMsg = fObj.getAttribute("msg");		// 경고 메시지
			fMin = fObj.getAttribute("minlen");		// 최소 입력글자수 제한
			fMinMsg = fObj.getAttribute("minlenMsg");		// 최소 길이 지정 메세지

				if (fMsg != null && (fTyp == "TEXT" || fTyp == "HIDDEN" || fTyp == "TEXTAREA" || fTyp == "PASSWORD")   ) 
				{
					if(( fVal == "" || fVal == null   )){
						funnMsg = funnMsg + "["+ fMsg + " 입력해 주세요]\n";
					}else{
						checkCount++;
					}
				}
				if (fMin != null){
					if (fMin > getLen(fVal)) {
						funnMsg = funnMsg + "["+fMinMsg+ " 입력된 글자수가 "+fMin+"자보다 커야합니다" + "]\n";
					}else{
						checkCount++;
					}
					
				}
				
		}
		if(checkCount < checkNum){
			alert(funnMsg  + "경고 메세지중 [" + checkNum + "] 개의 데이터는 필수 입력 사항입니다.");
			return false;
		}
		return true;
	}
	


	//폼 검증 함수
	function checkForm(f, level) {
		 var fLen = f.elements.length;
		 var fObj;   // 폼 요소
		 var fTyp;   // 폼 요소 Type
		 var fVal;   // 폼 요소 Value
		 var fMsg;   // 경고 메시지 속성
		 var fNum;   // 숫자만 입력 속성
		 var fNumRep;   // 숫자만 입력 속성 다른값은 삭제
		 var fMax;   // 최대 길이 지정
		 var fMin;   // 최소 길이 지정
		 var fMxN;   // 최대값 지정
		 var fMnN;   // 최소값 지정
		 var fMal;   // 메일 FORMAT
		 var keyCheck;   // 메일 FORMAT
		 var fChN;   // 글자수많큼 쓰기
		 var dateChk; 
	
		 for (i=0;i<fLen;i++) {
		     fObj = f.elements[i];
		     
		     if(level == "undefined" || $(fObj).attr("level") == level){
			     fTyp = toUpperCase($(fObj).attr("type"));
			     fId = fObj.getAttribute("id");
			     fVal = $.trim($(fObj).val());
			     fMsg = $(fObj).attr("msg");//fObj.getAttribute("msg");        // 경고 메시지
			     fNum = $(fObj).attr("chknum");// fObj.getAttribute("chknum");     // 숫자만 기입 가능하도록
			     fNumRep = $(fObj).attr("chknumRep");// fObj.getAttribute("chknum");     // 숫자만 기입 가능하도록 , 가능
			     fMax =  $(fObj).attr("maxlen");//fObj.getAttribute("maxlen");     // 최대 입력글자수 제한
			     fMin =  $(fObj).attr("minlen");//fObj.getAttribute("minlen");     // 최소 입력글자수 제한
			     fMin2 =  $(fObj).attr("minlen2");//fObj.getAttribute("minlen");     // 최소 입력글자수 제한 ( 값이 있을경우만 체크)
			     fMxN =  $(fObj).attr("maxnum");//fObj.getAttribute("maxnum");     // 최대 숫자 제한
			     fMnN =  $(fObj).attr("minnum");//fObj.getAttribute("minnum");     // 최소 숫자 제한
			     fChN =  $(fObj).attr("checklen");//fObj.getAttribute("checklen");     // 글자수많큼
			     fMal =  $(fObj).attr("chkmail");//fObj.getAttribute("chkmail");    // 이메일 체크
			     keyCheck = $(fObj).attr("keyCheck");//fObj.getAttribute("keyCheck");   // 문자 제한
			     dateChk = $(fObj).attr("dateChk");//fObj.getAttribute("keyCheck");   // 날짜 형태 체크 
			     fLeng =  $(fObj).attr("chleng");//fObj.getAttribute("chleng");     // 글자수만큼
		 
			     
			    // $(fObj).attr("class","");
			     
			     if (dateChk == "true" && chkDate(fVal) == false ) {
			         alert("날짜 형태가 올바르지 않습니다.");
			          //$(fObj).attr("class","error");
			         fObj.focus(); return false;
			     }

		         if (fMsg != null && (fTyp == "TEXT" || fTyp == "HIDDEN" || fObj.tagName  == "TEXTAREA" || fTyp == "PASSWORD"  || fTyp == "FILE" )  && ( fVal == "" || fVal == null ) ) {
		             alert(fMsg + " 입력해 주세요");
		             //$(fObj).attr("class","error");
		             if (fTyp != "HIDDEN") {fObj.focus();}
		             return false;
		         }
		         if (fMsg != null && (fTyp == "SELECT-ONE" || fTyp == "SELECT-MULTIPLE") && fVal =="") {
		             alert(fMsg + " 선택해 주세요");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }
		         if (fMsg != null && (fTyp == "RADIO" || fTyp == "CHECKBOX") && checkChecked(fObj , f ) == false) {
		             alert(fMsg + " 선택해 주세요");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }
		         if (fNumRep == "true" && isNaN(fVal.replace(/[^\d\.\-\ ]/g, ''))) {
		             alert("숫자로만 입력해 주세요");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }else{
		             if (fNumRep == "true" ){
		                 $(fObj).val(fVal.replace(/[^\d\.\-\ ]/g, ''));
		             }
		         }
		        if (fNum != null && isNaN(fVal)) {
		            alert("숫자로만 입력해 주세요");
		             //$(fObj).attr("class","error");
		            fObj.focus(); return false;
		        }
		         if (fMax != null && fMax < getLen(fVal)) {
		             alert("입력된 글자수가 "+fMax+"자보다 작아야합니다.\n(영문 "+fMax+"자, 한글 "+Math.floor(fMax/2)+"자 까지 가능합니다.)");
		             //$(fObj).attr//$(fObj).attr("class","error");            fObj.focus(); return false;
		         }
		         if (fChN != null && fChN != getLen(fVal)) {
		             alert("입력된 글자수가 "+fChN+"자여야 합니다.");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }
		         if (fMin != null && fMin > getLen(fVal)) {
		             alert("입력된 글자수가 "+fMin+"자보다 커야합니다.");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }

		         if (fMin2 != null && 0 < getLen(fVal)) {
		        	 if(fMin2 > getLen(fVal)){
		                 alert("입력된 글자수가 "+fMin2+"자보다 커야합니다.");
		                 //$(fObj).attr("class","error");
		                 fObj.focus(); return false;
		         	}
		         }
		         
		         if (fMxN != null && parseInt(fMxN) < parseInt(fVal)) {
		             alert("입력된 숫자는 "+fMxN+"보다 작아야합니다.");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }
		         if (fMnN != null && parseInt(fMnN) > parseInt(fVal)) {
		             alert("입력된 숫자는 "+fMnN+"보다 커야합니다.");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }
		         if (fMal == "true" && checkEmail(fObj) == false && fVal != "") {
		             alert("이메일 주소가 올바르지 않습니다");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }
		         
		         if (fMsg != null && (fObj.tagName  == "SELECT" )  && ( fVal == "" || fVal == null ) ) {
		             alert(fMsg + " 선택해 주세요");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		         }

		         if (keyCheck != null ) {
		             if( fVal.indexOf(keyCheck) >= 0){
		             alert(keyCheck + "는 입력 불가능한 문자입니다.");
		             //$(fObj).attr("class","error");
		             fObj.focus(); return false;
		             }
		         }
		         
		         if (fLeng != null && 0 < getLen(fVal)) { 
		        	 if(fLeng != getLen(fVal)){
		                 alert("입력된 글자수가 "+fLeng+"자여야합니다.");
		                 //$(fObj).attr("class","error");
		                 fObj.focus(); return false;
		         	}
		         }
		     } 
		 } 
		 return true;
	}


	
	//날짜 체크
	function chkDate(value) {
	    var re = /^\d{4}\/\d{1,2}\/\d{1,2}$/;
	    if( re.test(value)){
	     var temp = value.split('/');
	           var yyyy = parseInt(temp[0],10); 
	           var mm = parseInt(temp[1],10); 
	           var dd = parseInt(temp[2],10); 
	               
	           var xdata = new Date(yyyy,mm-1,dd);
	           if ( ( xdata.getFullYear() == yyyy ) && 
	             ( xdata.getMonth () == mm - 1 ) && 
	             ( xdata.getDate() == dd ) ) {
	               return true;
	           }else{
	        	   return false;
	           } 
	    }else{
	    	return false;
	    }
	}


	//배열 요소일 경우 checked 된것이 있는지 확인
	function checkChecked(obj , f ) {
	var objnm = obj.name;
	var obfnm = f.name;
	var oElem = eval("document."+obfnm +"."+objnm);
	var ret = false;

	if (typeof(oElem.length) == "undefined") {
	  if (oElem.checked) {
	      ret = true;
	  }
	} else {
	  for (var i=0;i<oElem.length;i++) {
	      if (oElem[i].checked) {
	          ret = true;
	      }
	  }
	}
	return ret;
	}

	// 폼에 해당하는 컨트롤들의 기본값 쉽게 셋팅해 주기
	function initForm(f)	{
		var nLen;	// form 요소의 갯수
		var ival;	// 각 요소의 default value 값 즉! 초기화하고자 하는값
		var fTyp;	// form 요소의 타입(select, radio, checkbox...)

		for (var i = 0; i < f.elements.length; i++) {
			fTyp = toUpperCase(f.elements[i].type);
			ival = f.elements[i].ival;

			if (ival && fTyp == "SELECT-ONE") {
				nLen = f.elements[i].options.length;
				for (var j = 0; j < nLen; j++) {
					if (f.elements[i].options[j].value == ival)
						f.elements[i].options[j].selected = true;
				}
			}
			if (fTyp == "SELECT-MULTIPLE") {
				nLen = f.elements[i].options.length;
				for (var j = 0; j < nLen; j++) {
					if (f.elements[i].options[j].value == f.elements[i].options[j].ival)
						f.elements[i].options[j].selected = true;
				}
			}
			if (ival && (fTyp == "RADIO" || fTyp == "CHECKBOX")) {
				if (f.elements[i].value == ival)
					f.elements[i].checked = true;
			}
		}
		return true;
	}

	

	function checkEmail(obj) {
	 if(obj.value.length > 0) {
	  var regExp = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/i;
	  if(!regExp.test(obj.value)){
	   //alert("잘못된 e-mail 형식입니다.");
	   obj.value = "";
	   obj.focus();
	   return false;
	  }
	 }
	}
	// 문자 길이 반환 (영문 1byte, 한글 2byte 계산)
	function getLen(str) {
		var len;
	    var temp;

	    len = str.length;
	    var tot_cnt = 0;

	    for(k=0;k < len;k++){
	    	temp = str.charAt(k);
	    	if(escape(temp).length > 4)
	    		tot_cnt += 2;
	    	else
	    		tot_cnt++;
	    }
	    return tot_cnt;
	}
	// 대문자 변환 ex) toUpperCase(문자)
	function toUpperCase(str) {
		var ret;
		str != null ? ret = str.toUpperCase() : ret = "";
		return ret;
	}	
	
	
	

	//비밀번호 체크

	function CheckPassword(fObj)
	{
		
		var passTypeCount = 0;
		
		 var upw =$(fObj).val();
		 
		 if(upw.length < 8 || upw.length > 20)
		 {
		  alert('비밀번호는 8~20자리를 사용해야 합니다.');
		 return false;
		 }
		 var chk_num = upw.search(/[0-9]/ig);
		 var chk_eng = upw.search(/[a-z]/ig);
		 var chk_special = upw.search(/[^a-zA-Z0-9_]/);

		 
		 if( chk_num >= 0  ){
			 passTypeCount++;
		 }
		 if( chk_eng >= 0  ){
			 passTypeCount++;
		 }
		 if( chk_special >= 0  ){
			 passTypeCount++;
		 }
		 
		 if(passTypeCount == 2 && upw.length < 10 ){
			 alert("두가지 문자 조합시 비밀번호는 10자리 이상 입력해야 합니다.");
		     return false;
		 }
		 
		 if(passTypeCount < 2  ){
			 alert("최소 두가지 이상의 문자열을 입력해야합니다.");
		     return false;
		 }
		 
		 
		 if(/(\w)\1\1\1/.test(upw))
		 {
		     alert('비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.');
			fObj.focus();
		     return false;
		 }
		 
		 
		 
	 return true;
	}