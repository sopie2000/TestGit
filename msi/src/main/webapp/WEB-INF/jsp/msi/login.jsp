<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<script type="text/javascript">

$(document).ready(function(){
	
	//로그인 버튼 클릭
	$("#loginbtn").click(function(){
		
		if ($("#user_id").val() == "") {
			alert("로그인 아이디를 입력해주세요.");
			$("#user_id").focus();
			return;
		} else if ($("#user_pw").val() == "") {
			alert("로그인 비밀번호를 입력해주세요.");
			$("#user_pw").focus();
			return;
		} else{
			$("#form").attr("action","<c:url value='/j_spring_security_check.do' />");
			$("#form").submit();
		}
	});
});

</script>
<div id="wrap">
	<form name="form" id="form" method="post" action="<c:url value='/j_spring_security_check.do' />">
		<div class="login_wrap">
			<div class="inner">
				<table>
				    <tr height="40px">
				        <td>아이디</td>
				        <td><input type="text" name="user_id" id="user_id" style="width: 150px;height: 20px; border: 1px solid; "></td>
				        <td rowspan="2">
				        	<input type="button" id="loginbtn" value="로그인" class="hgbtn grey02 btn_sh" style="height: 60px;">	
				        </td>
				    </tr>
				    <tr height="40px">
				        <td>비밀번호</td>
				        <td><input type="password" name="user_pw" id="user_pw" style="width: 150px;height: 20px;border: 1px solid;"></td>
				    </tr>
				    
				    <c:if test="${not empty param.fail}">
				    <tr colspan="2">
				    	<font color="red">
				    		<p>로그인 실패하였습니다. 다시시도해주세요.</p>
				    		<p>Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }</p>
				    	</font>
				    	<c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>
				    </tr>
				    </c:if>
				</table>
			</div>
		</div>
	</form>
</div>