package kr.co.www.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Class Name : CommonErrorController.java
 * @Description : CommonErrorController.class
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
@Controller
@RequestMapping("/common/error")
public class CommonErrorController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value = "/throwable")
	public String throwable( HttpServletRequest request
							,ModelMap model){
		logger.info("throwable");
		pageErrorLog(request);
		model.put("msg", "예외가 발생하였습니다.");
		return "common/error/error";
	}
	
	/**
	 * exception
	 * @param request HttpServletRequest
	 * @param model ModelMap
	 * @return String
	 */
	@RequestMapping(value = "/exception")
	public String exception( HttpServletRequest request
							,ModelMap model){
		logger.info("exception");
		pageErrorLog(request);
		model.put("msg", "예외가 발생하였습니다.");
		return "common/error/error";
	}
	
	/**
	 * pageError400
	 * @param request HttpServletRequest
	 * @param model ModelMap
	 * @return String
	 */
	@RequestMapping(value = "/400")
	public String pageError400( HttpServletRequest request
							   ,ModelMap model){
		logger.info("page Error Code 400");
		pageErrorLog(request);
		model.put("msg", "잘못된 요청입니다.");
		return "common/error/error";
	}

	/**
	 * pageError403
	 * @param request HttpServletRequest
	 * @param model ModelMap
	 * @return String
	 */
	@RequestMapping(value = "/403")
	public String pageError403( HttpServletRequest request
							   ,ModelMap model){
		logger.info("page Error Code 403");
		pageErrorLog(request);
		model.put("msg", "접근이 금지되었습니다.");
		return "common/error/error";
	}

	/**
	 * pageError404
	 * @param request HttpServletRequest
	 * @param model ModelMap
	 * @return String
	 */
	@RequestMapping(value = "/404")
	public String pageError404( HttpServletRequest request
							   ,ModelMap model){
		logger.info("page Error Code 404");
		pageErrorLog(request);
		model.put("msg", "요청하신 페이지는 존재하지 않습니다.");
		return "common/error/error";
	}
	
	/**
	 * pageError405
	 * @param request HttpServletRequest
	 * @param model ModelMap
	 * @return String
	 */
	@RequestMapping(value = "/405")
	public String pageError405( HttpServletRequest request
							   ,ModelMap model){
		logger.info("page Error Code 405");
		pageErrorLog(request);
		model.put("msg", "요청된 메소드가 허용되지 않습니다.");
		return "common/error/error";
	}

	/**
	 * pageError500
	 * @param request HttpServletRequest
	 * @param model ModelMap
	 * @return String
	 */
	@RequestMapping(value = "/500")
	public String pageError500( HttpServletRequest request
							   ,ModelMap model){
		logger.info("page Error Code 500");
		pageErrorLog(request);
		model.put("msg", "서버에 오류가 발생하였습니다.");
		return "common/error/error";
	}
	
	/**
	 * pageError503
	 * @param request HttpServletRequest
	 * @param model ModelMap
	 * @return String
	 */
	@RequestMapping(value = "/503")
	public String pageError503( HttpServletRequest request
							   ,ModelMap model){
		logger.info("page Error Code 503");
		pageErrorLog(request);
		model.put("msg", "서비스를 사용할 수 없습니다.");
		return "common/error/error";
	}
	
	/**
	 * pageErrorLog
	 * @param request HttpServletRequest
	 */
	private void pageErrorLog(HttpServletRequest request) {
		logger.info("============================ error Log ============================");
		logger.info("status_code : " + request.getAttribute("javax.servlet.error.status_code"));
		logger.info("message : " + request.getAttribute("javax.servlet.error.message"));
		logger.info("request_uri : " + request.getAttribute("javax.servlet.error.request_uri"));
		logger.info("exception : " + request.getAttribute("javax.servlet.error.exception"));
		logger.info("servlet_name : " + request.getAttribute("javax.servlet.error.servlet_name"));
		logger.info("===================================================================");
	}
}