package kr.co.www.common.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Class Name : MsiHandler.java
 * @Description : MsiHandler.class
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
public class MsiHandler extends HandlerInterceptorAdapter {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(MsiHandler.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("preHandle executed");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle executed");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("afterCompletion executed");
	}
}