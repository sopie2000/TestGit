package kr.co.www.common.bind;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @Class Name : MsiBindingInitializer.java
 * @Description : 파라미터 바인드 초기화
 * @Modification Information
 * @
 * @  수정일         		수정자                   수정내용
 * @ -------------------------------------------------
 * @ 2016. 10. 28.    sopie         
 *
 * @author sopie    
 * @since 2016. 10. 28.
 * @version 1.0
 * @see
 */
public class MsiBindingInitializer implements WebBindingInitializer{
	
	/*
	 * @ModelAttribute를 사용해 파라미터값들을 받을때 Date형의 input값이 비어있으면 오류가 발생한다.
	 * 향후 기능 체크 필요.
	 */
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
}
