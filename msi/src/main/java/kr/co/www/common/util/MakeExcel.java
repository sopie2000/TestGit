package kr.co.www.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Class Name : MakeExcel.java
 * @Description : 엑셀다운로드
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
public class MakeExcel {
	
    static final Logger LOGGER = LoggerFactory.getLogger(MakeExcel.class);
	private static final String EXCEL_PATH = "excel";

    public MakeExcel() {}

    public String get_Filename() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddmmmm");
        return ft.format(new Date());
    }

    public String get_Filename(String pre) {
        return pre + get_Filename();
    }
    
    /**
     * Make Excel & Download. 
     * @throws IOException 
     */
    
    public void download(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model, String filename, String templateFile) throws Exception {
    	
		InputStream is = new ClassPathResource(EXCEL_PATH + "/" + templateFile).getInputStream();

		XLSTransformer transformer = new XLSTransformer();
		Workbook resultWorkbook = transformer.transformXLS(is, model);
		
		StringBuffer contentDisposition = new StringBuffer();
		contentDisposition.append("attachment;fileName=\"");
		contentDisposition.append(encodeFileName(filename) + ".xls");
		contentDisposition.append("\";");
		response.setHeader("Content-Disposition", contentDisposition.toString());
		response.setContentType("application/x-msexcel");
		
		if(model.get("sheetNameList") != null){
			List<String> sheetNameList = (List<String>)model.get("sheetNameList");
			for(int i = 0; i < sheetNameList.size() ; i++){
				resultWorkbook.setSheetName(i,sheetNameList.get(i));
			}
		}
		
		resultWorkbook.write(response.getOutputStream());

		HttpSession session = request.getSession();
		session.setAttribute("excelDownLoad", "end");
    }
    
	private String encodeFileName(String filename) throws UnsupportedEncodingException {
		return URLEncoder.encode(filename, "UTF-8");
	}
}