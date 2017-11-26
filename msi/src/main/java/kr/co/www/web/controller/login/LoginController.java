package kr.co.www.web.controller.login;

import javax.servlet.http.HttpSession;

import kr.co.www.common.security.CustomUserDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 로그인
	 * @param session
	 */
    @RequestMapping(value = "/login")
    public String login(HttpSession session) {
        logger.info("Welcome login! {}", session.getId());
        return "msiLogin/msi/login";
    }

    /**
     * 로그아웃
     * @param session
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpSession session) {
        CustomUserDetails userDetails = (CustomUserDetails)session.getAttribute("userLoginInfo");
        logger.info("Welcome logout! {}, {}", session.getId(), userDetails.getUsername());
        session.invalidate();
    }
    
    /**
     * @param session
     */
    @RequestMapping(value = "/loginProcess")
    public void loginProcess(HttpSession session) {
    	logger.info("ㅇㄴㄹㅇㄴㄹㄴㄹㄴㅇㄹㅇㄴ");
    }
    
    /**
     * 로그인성공
     * @param session
     */
    @RequestMapping(value = "/login_success", method = RequestMethod.GET)
    public void login_success(HttpSession session) {
        CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
         
        logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
        session.setAttribute("userLoginInfo", userDetails);
    }
     
    @RequestMapping(value = "page1", method = RequestMethod.GET)
    public void page1() {       
    }
    
    @RequestMapping(value = "/login_duplicate", method = RequestMethod.GET)
    public void login_duplicate() {     
        logger.info("Welcome login_duplicate!");
    }
}