package kr.co.www.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value = "/common/common/excelSessionCheck")
	public @ResponseBody String mentExcelSessionCheck(final HttpServletRequest request) throws Exception { 
		HttpSession session = request.getSession();
		return (String)session.getAttribute("excelDownLoad");
	}
}
