package kr.co.www.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.www.common.constant.Constants;
import kr.co.www.vo.CommonMap;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 이미지 뷰어 Controller.
 */
@Controller("imageController")
public class ImageController  {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(ImageController.class);

	/** 파일 업로드 디렉토리. */
	@Value("#{commonProps['file.root.dir']}")
	protected String fileRootDir;

	/**
	 * Image.
	 *
	 * @param response the response
	 * @param tblType the tbl type
	 * @param tblKey the tbl key
	 * @param fileIndex the file index
	 * @param filePath the file path
	 * @return the response entity
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value = "/common/image/image.do", method = RequestMethod.GET)
	public ResponseEntity<byte[]> image(
			final HttpServletResponse response,
			@ModelAttribute("commonMap") CommonMap commonMap,
			@Value("#{commonProps['img.upload.editImg.dir']}") String editImageUploadDir,
			@Value("#{commonProps['file.upload.dir']}") String fileUploadDir,
			 @Value("#{commonProps['img.upload.dir']}") String imgUploadImageDir,
			@ModelAttribute("imgGubun") String imgGubun,
			final HttpServletRequest request
			)
			throws IOException {

			commonMap.addAll(request.getParameterMap());

			String path = null;

			path = URLDecoder.decode(commonMap.getString("filePath"), "UTF-8");
			

			System.out.println(path);
			if(path.indexOf("bg_main.png") >= 0 ){
				System.out.println(path);
			}
			
			if("imgUpload".equals(imgGubun)){
				path = URLDecoder.decode(commonMap.getString("filePath"), "UTF-8");
			}else 	if("fileUpload".equals(imgGubun)){
					path = fileRootDir +"/" + URLDecoder.decode(commonMap.getString("filePath"), "UTF-8");
			}else{
				path = fileRootDir +"/" + editImageUploadDir+  Constants.UNIX_SEPARATOR +  URLDecoder.decode(commonMap.getString("filePath"), "UTF-8");
			}

			logger.error("===========================================2"+path);

		File file = new File(path);
		FileInputStream in = null;

		if (file.exists()) {
					
			
			try{
				in = new FileInputStream(path);
	
				final HttpHeaders headers = new HttpHeaders();
				headers.setContentType(getMimeType(path));
	
				return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,HttpStatus.CREATED);
			}catch(Exception e){
					logger.error("파일 없음");
			}

		} else {
		//	logger.error(messageSource.getMessage("errors.file.not.found",	new String[] { path }, Locale.getDefault()));
		}


		logger.error("===========================================end");

		
		return new ResponseEntity<byte[]>(HttpStatus.OK);

	}

	/**
	 * mime type 가져오기.
	 *
	 * @param fileName the file name
	 * @return the mime type
	 */
	private MediaType getMimeType(String fileName) {

		MediaType mimeType = null;

		String ext = FilenameUtils.getExtension(fileName);

		if ("jpg".equalsIgnoreCase(ext) || "jpeg".equalsIgnoreCase(ext)) {
			mimeType = MediaType.IMAGE_JPEG;
		} else if ("gif".equalsIgnoreCase(ext)) {
			mimeType = MediaType.IMAGE_GIF;
		} else if ("png".equalsIgnoreCase(ext)) {
			mimeType = MediaType.IMAGE_PNG;
		} 
			
		return mimeType;
	}

}
