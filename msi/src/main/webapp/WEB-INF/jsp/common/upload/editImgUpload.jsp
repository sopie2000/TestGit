<%@page import="org.springframework.util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<%
    String funcNum = request.getParameter("CKEditorFuncNum");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>:: KGC2013 - FileUpload Result ::</title>
    <script type="text/javascript" language="javascript">
	    var contextImgPath = "<c:url value='/common/image/image.do?filePath='/>";
	    var imgPath = "${imgPath}";
	    var serGubunHostUrl = "${serGubunHostUrl}";
	    var fullurl = contextImgPath+imgPath;
	    
        window.onload = function(){ 
			window.parent.CKEDITOR.tools.callFunction(<%=funcNum%>, fullurl, '${responseMessage}')


        };

    </script>
</head>
<body>
{ success:${success }, file_url:"${serverFileName }", message:"${responseMessage }" }
</body>
</html>


