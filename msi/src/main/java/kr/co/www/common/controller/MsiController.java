package kr.co.www.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class MsiController {
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(MsiController.class);
	
	/** 파일 업로드 디렉토리. */
	@Value("#{commonProps['file.upload.dir']}")
	protected String fileUploadDir;
	
}
