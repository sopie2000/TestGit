package kr.co.www.vo;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.sql.Blob;
import java.sql.Clob;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import kr.co.www.common.db.BlobTransport;
import kr.co.www.common.db.ClobTransport;
import kr.co.www.common.util.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class CommonMap extends java.util.HashMap {

	Logger logger = LoggerFactory.getLogger(CommonMap.class);

	private NumberFormat nf = NumberFormat.getInstance();

	private NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.KOREA);

	
	public static final long UPLOAD_MAX_SIZE = 41943040;	//40M

	/**
	 * Logger for this class
	 */

	private boolean isSet = false;

	/**
	 * 
	 */
	public CommonMap() {
		super();
	}


	private List<MultipartFile> files;

	private List<MultipartFile> files2;

	private List<MultipartFile> files3;

	private List<MultipartFile> files4;

	private List<MultipartFile> files5;

	private List<MultipartFile> Filedata;
	
	private List<MultipartFile> imgs;
	

	
	private String strListagg1;
	
	private String strListagg2;
	
	private String strListagg3;
	
	private String strListagg4;
	
	private String strListagg5;
	
	private ArrayList<String> listagg1;
	
	private ArrayList<String> listagg2;
	
	private ArrayList<String> listagg3;
	
	private ArrayList<String> listagg4;
	
	private ArrayList<String> listagg5;

	/**
	 * @param arg0
	 */
	public CommonMap(int arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CommonMap(int arg0, float arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public CommonMap(Map arg0) {
		super(arg0);
	}

	public void set() {
		this.isSet = true;
	}

	public boolean isSet() {
		return this.isSet;
	}

	public void addAll(Map map) {
		if (map == null) {
			return;
		}
		Iterator i$ = map.entrySet().iterator();
		System.out.println("==== Parameter Set Map Start ====");
		do {
			if (!i$.hasNext()) {
				break;
			}
			java.util.Map.Entry entry = (java.util.Map.Entry) i$.next();
			Object value = entry.getValue();
			if (value != null) {
				Object toadd;
				if (value instanceof String[]) {
					String values[] = (String[]) (String[]) value;
					if (values.length > 1) {
						toadd = new ArrayList(Arrays.asList(values));
					} else if(values.length == 1) {
						toadd = values[0];
					} else {
						toadd = "";
					}
				} else {
					toadd = value;
				}
				
				
				System.out.println("name : " + ((String)entry.getKey()).toLowerCase() + " value : "  + toadd);
				
				super.put(((String)entry.getKey()).toLowerCase(), toadd);
			}
		} while (true);
		System.out.println("==== Parameter Set Map End ====");
	}
	
	public String getEscape4Js(String key)
	{
		return getEscape4Js(key, "");
	}
	
	public String getEscape4Js(String key, String def)
	{
		String str;
		
		if(get(key) == null)
			str = "";
		else
			str = String.valueOf(get(key));
		
		
		str = StringUtils.replace(str, "\\", "\\\\");
		str = StringUtils.replace(str, "\r\n", "\\n");
		str = StringUtils.replace(str, "\r", "\\n");
		str = StringUtils.replace(str, "\n", "\\n");
		str = StringUtils.replace(str, "'", "\\'");
		str = StringUtils.replace(str, "\"", "\\\"");

		if(str.equals(""))
			return def;
		else
			return str;
	}
	
	public String getToHTML(String key)
	{
		String str = String.valueOf(getString(key));
		
		str = StringUtils.replace(str, "&", "&amp;");
		str = StringUtils.replace(str, "<", "&lt;");
		str = StringUtils.replace(str, ">", "&gt;");
		str = StringUtils.replace(str, "\r\n", "<br>");
		str = StringUtils.replace(str, "\"", "&quot;");
		str = StringUtils.replace(str, " ", "&nbsp;");
		
		return str;
	}
	
	
	public String getToINPUT(String key, String def)
	{
		String str = String.valueOf(getString(key));
		
		if(str.length() == 0)
			str = def;
		
		//str = StringUtils.replace(str, "<", "&lt;");
		//str = StringUtils.replace(str, ">", "&gt;");
		//str = StringUtils.replace(str, "\"", "&quot;");
		
		return str;
	}
	
	public String getToINPUT(String key)
	{
		return getToINPUT(key, "");
	}
	
	

	
	

	
	public String getHtmlRemoveString(String key){
		String output =getString(key, "");
		String refined_str = "";
	    if(output!=null&&(output.toString()!=null)){                         
	    	refined_str = output.toString().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");                         
	    }
		return 	refined_str;	
	}
	
    
	
	public String getString(String key){
		return 	getString(key, "");	
	}
	
	public String getString(String key, String def) {
		
		if(this.get(key.toLowerCase()) == null)
			return def;
		else
		{
			String str = String.valueOf(this.get(key.toLowerCase()));
			if (str.equals(""))
				str = def;
			
			return StringUtils.getNull(str);
		}
	}

	public int getInt(String key) {
		Object obj = super.get(key.toLowerCase());
		int ret = 0;
		if (obj instanceof java.lang.Number) {
			ret = ((Number) obj).intValue();
		} else {
			try {
				ret = Integer.parseInt(obj.toString());
			} catch (Exception ex) {
				ret = 0;
			}
		}
		return ret;
	}
	
	public int getInt(String key, int def) {
		Object obj = super.get(key.toLowerCase());
		int ret = 0;
		if (obj instanceof java.lang.Number) {
			ret = ((Number) obj).intValue();
		} else {
			try {
				ret = Integer.parseInt(obj.toString());
			} catch (Exception ex) {
				ret = def;
			}
		}
		return ret;
	}
	
	public int[] getInts(String key) {
		int[] ints = null;
		try{
			String[] obj = (String[])super.get(key.toLowerCase());
			ints = new int[obj.length];
			for(int i=0;i<obj.length;i++){				
				ints[i] = getInt(obj[i]);				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ints;		
	}

	public Integer getInteger(String key) {
		return new Integer(this.getInt(key.toLowerCase()));
	}

	public double getDouble(String key) {
		double ret = 0;
		Object obj = super.get(key.toLowerCase());
		if (obj == null)
			return 0;
		try {
			ret = Double.parseDouble(obj.toString());
		} catch (Exception ex) {
			return 0;
		}
		return ret;
	}

	public double getDouble(String key , double defaultVal) {
		double ret = 0;
		Object obj = super.get(key.toLowerCase());
		if (obj == null)
			return defaultVal;
		try {
			ret = Double.parseDouble(obj.toString());
		} catch (Exception ex) {
			return defaultVal;
		}
		return ret;
	}

	public String getPersent(String key) {
		String str = "";
		NumberFormat format = NumberFormat.getPercentInstance();
		double value = this.getDouble(key);
		str = format.format(value);
		return str;
	}

	public String getDateFormat(String key, String type) {
		String str = "";
		Object o = null;
		SimpleDateFormat in = new SimpleDateFormat("yyyyMMddkkmmss");
		SimpleDateFormat out = new SimpleDateFormat(type);

		o = this.get(key.toLowerCase());
		if (o == null || o.toString().trim().equals(""))
			return "-";
		try {
			str = o instanceof String ? out.format(in.parse((String) o)) : out
					.format((Date) o);
		} catch (ParseException e) {
			return "-";
		}

		return str;
	}

	public String getDateFormat(String key, String fType, String tType) {
		String str = "";
		String s = null;
		SimpleDateFormat in = new SimpleDateFormat(fType);
		SimpleDateFormat out = new SimpleDateFormat(tType);

		// s = this.getString(key.toLowerCase()).trim();
		s = key.toLowerCase();
		if (s.equals(""))
			return "-";
		try {
			str = out.format(in.parse(s));
		} catch (ParseException e) {
			return "-";
		}

		return str;
	}

	public String getNumberFormat(String key) {
		String str = "";
		str = nf.format(this.getDouble(key.toLowerCase()));
		return str;
	}

	public String getCurrencyFormat(String key) {
		String str = "";
		double d = this.getDouble(key.toLowerCase());
		if (d == 0)
			return "-";
		str = cf.format(d);
		return str;
	}

	
	public Object put(Object arg0,Object arg1) {
		arg0 = ((String)arg0).toLowerCase();
		return super.put(arg0, arg1);
	}

	
	public Object putOrg(Object arg0,Object arg1) {
		return super.put(arg0, arg1);
	}
	

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	
	
	
	
	public List<MultipartFile> getFiles2() {
		return files2;
	}

	public void setFiles2(List<MultipartFile> files2) {
		this.files2 = files2;
	}

	public List<MultipartFile> getFiles3() {
		return files3;
	}

	public void setFiles3(List<MultipartFile> files3) {
		this.files3 = files3;
	}

	public List<MultipartFile> getFiles4() {
		return files4;
	}

	public void setFiles4(List<MultipartFile> files4) {
		this.files4 = files4;
	}

	public List<MultipartFile> getFiles5() {
		return files5;
	}

	public void setFiles5(List<MultipartFile> files5) {
		this.files5 = files5;
	}

	public List<MultipartFile> getFiledata() {
		return Filedata;
	}

	public void setFiledata(List<MultipartFile> filedata) {
		Filedata = filedata;
	}

	public List<MultipartFile> getImgs() {
		return imgs;
	}

	public void setImgs(List<MultipartFile> imgs) {
		this.imgs = imgs;
	}
	
	
	

	public String getStrListagg1() {
		return strListagg1;
	}

	public void setStrListagg1(String strListagg1) {
		this.strListagg1 = strListagg1;
	}

	public String getStrListagg2() {
		return strListagg2;
	}

	public void setStrListagg2(String strListagg2) {
		this.strListagg2 = strListagg2;
	}

	public String getStrListagg3() {
		return strListagg3;
	}

	public void setStrListagg3(String strListagg3) {
		this.strListagg3 = strListagg3;
	}

	public String getStrListagg4() {
		return strListagg4;
	}

	public void setStrListagg4(String strListagg4) {
		this.strListagg4 = strListagg4;
	}

	public String getStrListagg5() {
		return strListagg5;
	}

	public void setStrListagg5(String strListagg5) {
		this.strListagg5 = strListagg5;
	}

	public ArrayList<String> getListagg1() {
		ArrayList<String> returnArrayList = new ArrayList<String>();
		String[] tempArray = StringUtils.split(strListagg1, "@/@");
		for(int i = 0 ; i < tempArray.length ; i ++){
			returnArrayList.add(tempArray[i]);
		}
		return returnArrayList;
	}


	public ArrayList<String> getListagg2() {
		ArrayList<String> returnArrayList = new ArrayList<String>();
		String[] tempArray = StringUtils.split(strListagg2, "@/@");
		for(int i = 0 ; i < tempArray.length ; i ++){
			returnArrayList.add(tempArray[i]);
		}
		return returnArrayList;
	}

	public ArrayList<String> getListagg3() {
		ArrayList<String> returnArrayList = new ArrayList<String>();
		String[] tempArray = StringUtils.split(strListagg3, "@/@");
		for(int i = 0 ; i < tempArray.length ; i ++){
			returnArrayList.add(tempArray[i]);
		}
		return returnArrayList;
	}

	public ArrayList<String> getListagg4() {
		ArrayList<String> returnArrayList = new ArrayList<String>();
		String[] tempArray = StringUtils.split(strListagg4, "@/@");
		for(int i = 0 ; i < tempArray.length ; i ++){
			returnArrayList.add(tempArray[i]);
		}
		return returnArrayList;
	}


	public ArrayList<String> getListagg5() {
		ArrayList<String> returnArrayList = new ArrayList<String>();
		String[] tempArray = StringUtils.split(strListagg5, "@/@");
		for(int i = 0 ; i < tempArray.length ; i ++){
			returnArrayList.add(tempArray[i]);
		}
		return returnArrayList;
	}

	
	
	public Boolean onlyFileSizecheck() throws IOException{
		ByteArrayOutputStream ous= null;
		try {
			List<MultipartFile> files = getFiles();
			ous = new ByteArrayOutputStream(1024);
			long filesize = 0;
			if(files!=null){
				for (MultipartFile multipartFile : files) {
					if (multipartFile != null) {
						String fileName = multipartFile.getOriginalFilename();
						if (StringUtils.isNotEmpty(fileName)) {
							filesize = multipartFile.getSize();
							if(filesize > UPLOAD_MAX_SIZE){
								return true;
							}
						} // end of if
					} // end of if
				} // end of for
			}
		
		}finally{
			if(ous!=null)
				try {	ous.close();	} catch (IOException e) {	e.printStackTrace();	}
		}
		
		return false;
	}
	
	

	@Override
	public Object get(Object arg0) {
		arg0 = ((String)arg0).toLowerCase();
		String content = null;
		if (super.get(arg0) instanceof Clob) {			
			try {
				Clob lob_data = ClobTransport.wrap(super.get(arg0));				
				Reader in = lob_data.getCharacterStream();
				java.io.Writer sw = new StringWriter();
				char buffer[] = new char[4096];
				int n;
				while ((n = in.read(buffer)) != -1)
					sw.write(buffer, 0, n);	
				content = sw.toString();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return content;
		} else if (super.get(arg0) instanceof Blob) {	
			
			Blob lob_data =  BlobTransport.wrap(super.get(arg0));
			return lob_data;
		} else if (super.get(arg0) instanceof String) {	
			return StringUtils.getNull(super.get(arg0).toString() , "");
		} else{		
			return super.get(arg0);
		}
	}
	

    
}









