package kr.co.www.common.util;
import java.security.MessageDigest;

public class StringUtils extends org.apache.commons.lang.StringUtils  {
   
	/**
	 * 문자열 자르기 
	 * @param str the 문자
	 * @param len the 제한길이
	 * @param isAddDot the is '...'추가여부
	 * @return the string
	 */
	public static String cutString(String str, int len , boolean isAddDot  ) { 

		  byte[] by = str.getBytes();
		  int count = 0;
		  try  {
		   for(int i = 0; i < len; i++) {
		    if((by[i] & 0x80) == 0x80) count++;
		   }
		   if((by[len - 1] & 0x80) == 0x80 && (count % 2) == 1) len--;
		   
		   String returnValue = new String(by, 0, len) ;
		   if(isAddDot){
			   returnValue = returnValue + "...";
		   }
		   
		   return returnValue;   
		  }
		  catch(java.lang.ArrayIndexOutOfBoundsException e)
		  {
		   ////	System.out.println(e);
		   return str;
		  }
		 }


	/**
	 * String => double 형변환
	 *
	 * @param inputString the input 변환할 문자
	 * @param nullValue the null 값이 없을경우 리턴값
	 * @return the double null
	 */
	public static double getDoubleNull( String inputString, double nullValue )
	{
		try
		{
			if(inputString == null || inputString.equals("")) return nullValue;
			return Double.parseDouble(inputString);
		} catch(Exception e) {
			return nullValue;
		}
	}	

	/**
	 * String => int 형변환
	 *
	 * @param inputString the input 변환할 문자
	 * @param nullValue the null 값이 없을경우 리턴값
	 * @return the double null
	 */
	public static int getIntNull(String stText){
		try{
	  		if(stText == null || stText.equals("")) return 0;
	  		return Integer.parseInt(stText.trim());
		}
		catch(Exception e){
  		return 0;
		}

	}

	public static int getIntNull(String stText , int defaultVal){
		try{
	  		if(stText == null || stText.equals("")) return defaultVal;
	  		return Integer.parseInt(stText.trim());
		}
		catch(Exception e){
  		return defaultVal;
		}

	}
	public static String substring(String str, int end) { 
	  try  {

			str = getNull(str);
			if(str.length() > end){
				str = str.substring(end);
			}
			return str;
		
	  }
	  catch(java.lang.ArrayIndexOutOfBoundsException e)
	  {
	   //System.out.println(e);
	   return str;
	  }
	 }
	public static String substring(String str, int start, int end) { 
	  try  {
			str = getNull(str);
			if(str.length() > end){
				str = str.substring(start,end);
			}
			return str;
	  }
	  catch(java.lang.ArrayIndexOutOfBoundsException e)
	  {
	   //System.out.println(e);
	   return str;
	  }
	 }
	


	/**
	 *
	 * @param inputString the input 변환할 문자
	 * @return the String
	 */
  public static String getNull(String stText){
	    try{
	      if(stText == null || "null".equals(stText)) return "";
/*
		      stText = replace(stText,"<" , "&lt;");
		      stText = replace(stText,">" , "&gt;");
		      stText = replace(stText,"\"" , "&quot;");
*/		      
	      
	      return stText.trim();
	    }
	    catch(Exception e){
	      ////	System.out.println(e.toString());		
	      //e.printStackTrace();
	      return "";
	    }

	  }

	/**
	 *
	 * @param inputString the input 변환할 문자
	 * @return the String
	 */
public static String getNull(String stText , String defaultVal){
	    try{
	      if(stText == null || "null".equals(stText)) return defaultVal;
/*
		      stText = replace(stText,"<" , "&lt;");
		      stText = replace(stText,">" , "&gt;");
		      stText = replace(stText,"\"" , "&quot;");
	*/      
	      return stText.trim();
	    }
	    catch(Exception e){
	      ////	System.out.println(e.toString());		
	      //e.printStackTrace();
	      return defaultVal;
	    }

	  }



public static String iso8859(String strStr)
throws java.io.UnsupportedEncodingException
{
        if (strStr == null)
        {
                return  null;
        }
        else
        {
                return new String(strStr.getBytes("KSC5601"), "8859_1");
        }
}


public static String filter( String str) throws Exception{
	
	String returnStr 	= str;
	String[] _etcValue 	= {"SCRIPT"};
	String str1 = "";
	
	try{				
		/*
			for( int i = 0 ; i < _etcValue.length ; i++){
				if(str1.toUpperCase().indexOf(_etcValue[i]) > -1 ) {
					returnStr = replace(str1,_etcValue[i] , "");
				}else{
					returnStr = str1;
				}
			}
			*/

		      returnStr = replace(returnStr,"<" , "&lt;");
		      returnStr = replace(returnStr,">" , "&gt;");
		      returnStr = replace(returnStr,"\"" , "&quot;");
		
	}catch(Exception e1){
		//System.out.println(e1.toString());
	}
	return returnStr;	
}


/**
 * 문자열 자르기 
 *
 * @param text 문자
 * @return the string
 */
public static String strHashFormat(String text) throws Exception {

    MessageDigest md = MessageDigest.getInstance("SHA-512");
    md.update(text.getBytes());

    byte byteData[] = md.digest();

    //convert the byte to hex format method 2
    StringBuffer hexString = new StringBuffer();
    for (int i=0;i<byteData.length;i++) {
        String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
    }

    return hexString.toString();
}



/**
 * 1. MethodName	: getInt
 * 2. ClassName		: StringUtil
 * 3. Commnet		: 숫자형으로 변환, Null이거나 0이면 기본값 세팅
 * 4. 작성자			: LeeMyungSu
 * 5. 작성일			: 2011. 3. 8. 오전 10:26:17
 * @return int
 * @param str
 * @return
 */
public static int getInt(Object obj, int defNum){
    if(obj == null || obj.toString().equals("")) {
        return defNum;
    } else {
        if(obj.toString().indexOf(".") != -1){
            int temp = obj.toString().indexOf(".");
            String tempObj = getString(obj);
            obj = tempObj.substring(0, temp);
        }
        try {
            if (Integer.parseInt(obj.toString()) <= 0){
                return defNum;
            } else {
                return Integer.parseInt(obj.toString());
            }
        } catch (Exception e){
            return 0;
        }
    }
}

/**
 * 1. MethodName	: getString
 * 2. ClassName		: StringUtil
 * 3. Commnet		: 문자열으로 변환
 * 4. 작성자			: LeeMyungSu
 * 5. 작성일			: 2011. 3. 8. 오전 10:34:09
 * @return String
 * @param obj
 * @param defStr
 * @return
 */
public static String getString(Object obj){
    if(obj == null || obj.toString().equals("")) {
        return "0";
    } else {
        if ("".equals(obj.toString())){
            return "0";
        } else {
            return obj.toString();
        }
    }
}
/**
 * 1. MethodName	: getString
 * 2. ClassName		: StringUtil
 * 3. Commnet		: 문자열으로 변환, Null이거나 ""이면 기본값 세팅
 * 4. 작성자			: LeeMyungSu
 * 5. 작성일			: 2011. 3. 8. 오전 10:34:09
 * @return String
 * @param obj
 * @param defStr
 * @return
 */
public static String getString(Object obj, String defStr){
    if(obj == null || obj.toString().equals("")) {
        return defStr;
    } else {
        if ("".equals(obj.toString())){
            return defStr.trim();
        } else {
            return obj.toString().trim();
        }
    }
}
}