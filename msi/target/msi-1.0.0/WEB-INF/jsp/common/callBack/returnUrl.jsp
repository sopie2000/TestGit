<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/include/frontHeader.jsp" %>
 
 
<c:if test="${!empty returnUrl}">
<script type="text/javascript">
    $(document).ready(function () {  
       $("#frmExec").submit(); 
    }); 
</script>
<form id="frmExec" name="frmExec" method="post" action="${contextPath }${returnUrl}">
<div style="display: none;">
    <c:forEach items="${commonMap}" var="item">
        <input type="hidden" id="${item.key}" name="${item.key}" value="${item.value}"/>
    </c:forEach>
</div>
</form>
</c:if>