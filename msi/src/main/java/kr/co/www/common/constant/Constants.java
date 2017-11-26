package kr.co.www.common.constant;

import java.util.Map;

import org.springframework.http.MediaType;

public class Constants extends MediaType {
	
	public Constants(MediaType other, Map<String, String> parameters) {
		super(other, parameters);
		// TODO Auto-generated constructor stub
	}
	
	/** 문자 타입 */
	public static final String CHARACTER_SET_UTF_8 = "UTF-8"; // 사용

	/** 서버 구분자 */
	public static final String UNIX_SEPARATOR = "/"; // 사용

	/** 서버 구분자 */
	public static final int BUFFER_SIZE = 8192; // 사용

	/** 페이지 사이즈 */
	public static  int PAGE_SIZE = 10; // 사용
	
	/** Sample Board 구분 */
	public static  String SAMPLE_LIST_TYPE1 = "1001";	//SampleList1 
	public static  String SAMPLE_LIST_TYPE2 = "1002"; 	//SampleList2
	public static  String SAMPLE_LIST_TYPE3 = "1003";	//SampleList3
	
	public static void setPAGE_SIZE(int pAGE_SIZE) {
		PAGE_SIZE = pAGE_SIZE;
	}
}