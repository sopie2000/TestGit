package kr.co.www.web.controller.sample;

import javax.servlet.http.HttpServletRequest;

import kr.co.www.common.controller.MsiController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleMapController extends MsiController {

	Logger logger = LoggerFactory.getLogger(SampleMapController.class);
	
	/**
	 * mainMap
	 * @param model ModelMap
	 * @param request HttpServletRequest
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/sample/map/mainMap")
	public String mainMap(ModelMap model
			 ,HttpServletRequest request) throws Exception {
		return "msiMain/msi/sample/map/mainMap";
	}	
	
	/**
	 * googleMap
	 * @param model ModelMap
	 * @param request HttpServletRequest
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/sample/map/googleMap")
	public String googleMap(ModelMap model
			 ,HttpServletRequest request) throws Exception {
		return "msiMain/msi/sample/map/googleMap";
	}
	
	/**
	 * SampleMap
	 * @param model ModelMap
	 * @param request HttpServletRequest
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/sample/map/naverMap")
	public String naverMap(ModelMap model
			 ,HttpServletRequest request) throws Exception {
		return "msiMain/msi/sample/map/naverMap";
	}	
	
	@RequestMapping(value = "/sample/map/sampleMapJson")
	@ResponseBody
	public JSONArray mapJson(ModelMap model
			 ,HttpServletRequest request) throws Exception {
		JSONObject jsonInfo = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		jsonInfo = new JSONObject();
		jsonInfo.put("idx", "1");
		jsonInfo.put("title", "테스트1");
		jsonInfo.put("lat", 37.500039);
		jsonInfo.put("lng", 127.147156); 
		jsonArray.add(jsonInfo);
		
		jsonInfo = new JSONObject();
		jsonInfo.put("idx", "2");
		jsonInfo.put("title", "테스트2");
		jsonInfo.put("lat", 37.498344);
		jsonInfo.put("lng", 127.146971); 
		jsonArray.add(jsonInfo);
		
		jsonInfo = new JSONObject();
		jsonInfo.put("idx", "3");
		jsonInfo.put("title", "테스트3");
		jsonInfo.put("lat", 37.499260);
		jsonInfo.put("lng", 127.153642); 
		jsonArray.add(jsonInfo);
		return jsonArray;
	}
}