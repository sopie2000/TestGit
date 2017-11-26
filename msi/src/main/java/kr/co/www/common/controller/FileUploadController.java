package kr.co.www.common.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.www.common.util.DateUtils;
import kr.co.www.common.util.FileRenamePolicy;
import kr.co.www.vo.CommonMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 공통 Controller.
 */
@Controller
public class FileUploadController {


	/** The logger. */
	Logger logger = LoggerFactory.getLogger(FileUploadController.class);


	/** 파일 업로드 디렉토리. */
	@Value("#{commonProps['file.root.dir']}")
	protected String fileRootDir;


	/**
	 * 에디터 파일 업로드.
	 * @param searchVO the search vo
	 * @param fileUploadImageDir the file upload image dir
	 * @param request the request
	 * @param gnbVO the gnb vo
	 * @param lnbVO the lnb vo
	 * @param model the model
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/common/editImgUpload")
	public String editImgUpload(
			 ModelMap model ,
				@Value("#{commonProps['img.upload.editImg.dir']}") String fileUploadImageDir,
				@Value("#{commonProps['serGubun.host.url']}") String serGubunHostUrl,
			@ModelAttribute("commonMap") CommonMap commonMap ,
			final HttpServletRequest request
			)
			throws Exception {

		commonMap.addAll(request.getParameterMap());
		
		String imgPath = "";
		
		 List<MultipartFile> files = commonMap.getFiledata();

		String fileLocationYyyy     =	DateUtils.getToday(DateUtils.PATTERN_SYSDATE_YYYY);
		String fileLocationMm     =	DateUtils.getToday(DateUtils.PATTERN_SYSDATE_MM);
		String fileLocationDd     =	DateUtils.getToday(DateUtils.PATTERN_SYSDATE_DD);
		
		String YyyyMmDd = fileLocationYyyy+"/"+fileLocationMm+"/"+fileLocationDd;

		String fileLocation     =	fileRootDir + "/" + fileUploadImageDir + "/" + YyyyMmDd;
		FileRenamePolicy.FileMkdir(fileRootDir + "/" +fileUploadImageDir + "/"+fileUploadImageDir);	
		FileRenamePolicy.FileMkdir(fileRootDir + "/" +fileUploadImageDir + "/"+fileUploadImageDir+"/"+fileLocationYyyy);	
		FileRenamePolicy.FileMkdir(fileRootDir + "/" +fileUploadImageDir + "/"+fileUploadImageDir+"/"+fileLocationYyyy+"/"+fileLocationMm);	
		FileRenamePolicy.FileMkdir(fileRootDir + "/" +fileUploadImageDir + "/"+fileUploadImageDir+"/"+YyyyMmDd);
		String uploadPath =fileLocation;

		String filePath;
		String fileName = "";

		// 디렉토리 생성
		String path = FilenameUtils.concat(fileUploadImageDir, uploadPath);

		File uploadDir = new File(path);
		if (!uploadDir.exists())
			uploadDir.mkdirs();

		if (files != null && files.size() > 0) {

			for (MultipartFile multipartFile : files) {

				if (multipartFile != null) {

					fileName = multipartFile.getOriginalFilename();

					if (StringUtils.isNotEmpty(fileName)) {

						// 파일 전송
						filePath = FilenameUtils.concat(path, fileName);

						// 파일 중복 시 파일명 rename
						File newFile = new File(filePath);
						newFile = new FileRenamePolicy().rename(newFile);

						multipartFile.transferTo(newFile);
						imgPath = YyyyMmDd+"/"+newFile.getName();

					} // end of if

				} // end of if

			} // end of for

		} // end of if

		model.addAttribute("imgPath", imgPath);

	    model.addAttribute("serverFileName", imgPath);
	    model.addAttribute("userFileName", fileName);
	    model.addAttribute("success", true);
	    model.addAttribute("result", Integer.valueOf(1));
	    model.addAttribute("responseMessage", "파일 업로드가 완료되었습니다!");
	    model.addAttribute("serGubunHostUrl", serGubunHostUrl);

		return "common/upload/editImgUpload";
	}
}