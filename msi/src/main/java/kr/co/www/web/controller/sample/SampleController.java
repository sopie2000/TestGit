package kr.co.www.web.controller.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.www.common.constant.Constants;
import kr.co.www.common.controller.MsiController;
import kr.co.www.common.page.Pagination;
import kr.co.www.common.util.MakeExcel;
import kr.co.www.common.util.StringUtils;
import kr.co.www.vo.CommonMap;
import kr.co.www.web.service.sample.SampleService;

/**
 * @Class Name : SampleController.java
 * @Description : SampleController.class
 * @Modification Information
 * 
 * @  수정일         		수정자                   수정내용
 * @ -------------------------------------------------
 * @ 2016. 10. 27.    sopie         
 *
 * @author sopie    
 * @since 2016. 10. 27.
 * @version 1.0
 * @see
 */
@Controller
public class SampleController extends MsiController {
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	/** The mainService. */
	@Resource(name = "sampleService")
	protected SampleService sampleService;
	
	/**
	 * SampleMain
	 * @param model ModelMap
	 * @param request HttpServletRequest
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/sample/sampleMain")
	public String main(ModelMap model
			 ,HttpServletRequest request) throws Exception {
		return "msiMain/msi/sample/sampleMain";
	}
	
	/**
	 * SampleList 목록
	 * @param model ModelMap
	 * @param commonMap CommonMap
	 * @param request HttpServletRequest
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/sample/list/sampleList")
	public String sampleList(ModelMap model
			 ,@ModelAttribute("commonMap") CommonMap commonMap, HttpServletRequest request) throws Exception {
		
		commonMap.addAll(request.getParameterMap());
		commonMap.put("deleteYn", "N");
		commonMap.put("rowSize", "10");

		//현재페이지 초기화
		if(StringUtils.isEmpty(commonMap.getString("curPageNo"))){
			commonMap.put("curPageNo","1");
		}
		
		//BoardType 초기화
		if(StringUtils.isEmpty(commonMap.getString("TYPE"))){
			commonMap.put("TYPE","1001");
		}
		
		//BoardType Info
		Map<String, Object> typeInfoMap = getTypeInfo(commonMap.getString("TYPE"));
		model.put("typeInfoMap", typeInfoMap);
	 	
		//SampleList 목록
		List<CommonMap> sampleList = sampleService.selectSampleList(commonMap);
		model.put("sampleList", sampleList);
		
		//SampleList 카운트
		int totalCount = sampleService.selectSampleCount(commonMap);
		model.put("totalCount", totalCount);
		
		//페이징처리
		Pagination pagination = new Pagination();
		pagination.setCurPageNo(commonMap.getInt("curPageNo"));
		pagination.setListRowCnt(10);
		pagination.setPageSize(Constants.PAGE_SIZE);
		pagination.setTotalCnt(totalCount);
		model.addAttribute("pagination", pagination);
		
		return "msiMain/msi/sample/list/sampleList"+typeInfoMap.get("type");
	}	
	
	/**
	 * SampleList 상세
	 * @param model ModelMap
	 * @param commonMap CommonMap
	 * @param request HttpServletRequest
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/sample/list/sampleForm")
	public String sampleForm(ModelMap model
			 ,@ModelAttribute("commonMap") CommonMap commonMap, HttpServletRequest request) throws Exception {
		
		commonMap.addAll(request.getParameterMap());
		
		//BoardType Info
		Map<String, Object> typeInfoMap = getTypeInfo(commonMap.getString("type"));
		model.put("typeInfoMap", typeInfoMap);
		
		//상세보기
		if ("update".equals(commonMap.getString("method"))){
			commonMap.put("TERMS_TYPE", typeInfoMap.get("type"));
			CommonMap sampleDetail = sampleService.selectSampleDetail(commonMap);
			model.addAttribute("sampleDetail", sampleDetail);
		}
		
		return "msiMain/msi/sample/list/sampleForm"+typeInfoMap.get("type");
	}	
	
	@RequestMapping(value = "/sample/list/sampleSave")
	public String sampleSave(ModelMap model, @ModelAttribute("commonMap") CommonMap commonMap
			 ,HttpServletRequest request ) throws Exception {

		request.setAttribute("callbackCode", "success");
		
		/**게시글 등록 관련*/
		commonMap.addAll(request.getParameterMap());
		commonMap.put("TERMS_TYPE", getTypeInfo(commonMap.getString("type")));
		commonMap.put("REG_ID", "system");
		commonMap.put("MODIFY_ID", "system");

		try{
			sampleService.insertSample(commonMap);
		}catch(Exception e){
			request.setAttribute("callbackCode", "fail");
		}
		
		return "noLayout/common/callBack/hiddenFrame";
	}	
	
	/**
	 * Sample 엑셀다운로드
	 * @param model ModelMap
	 * @param commonMap CommonMap
	 * @param response HttpServletResponse
	 * @param request HttpServletRequest
	 * @throws Exception
	 */
	@RequestMapping(value = "/sample/list/sampleExcelDown")
	public void sampleExcelDown( ModelMap model
			 ,@ModelAttribute("commonMap") CommonMap commonMap 
			 ,HttpServletResponse response 
			 ,HttpServletRequest request) throws Exception{	
	
		commonMap.addAll(request.getParameterMap());
		
		try {
			HttpSession session = request.getSession();
			session.setAttribute("excelDownLoad", "start");
			List<CommonMap> sampleList = sampleService.selectSampleList(commonMap);
			model.addAttribute("dataList", sampleList);
		} catch(Exception ex) {
			logger.debug(ex.toString());
		}

        MakeExcel me = new MakeExcel();
        me.download(request, response, model, "Sample", "sample.xls");
	}
	
	/**
	 * 리스트타입 INFO
	 * @param type String
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getTypeInfo(String type){
	
		Map<String, Object> typeInfoMap =  new HashMap<String, Object>();
		
		if (type.equals(Constants.SAMPLE_LIST_TYPE1)){
			typeInfoMap.put("type", Constants.SAMPLE_LIST_TYPE1);
			typeInfoMap.put("title", "SAMPLE1");
		} else if (type.equals(Constants.SAMPLE_LIST_TYPE2)){
			typeInfoMap.put("type", Constants.SAMPLE_LIST_TYPE2);
			typeInfoMap.put("title", "SAMPLE2");
		} else if (type.equals(Constants.SAMPLE_LIST_TYPE3)){
			typeInfoMap.put("type", Constants.SAMPLE_LIST_TYPE3);
			typeInfoMap.put("title", "SAMPLE3");
		}
		return typeInfoMap;
	}	
}