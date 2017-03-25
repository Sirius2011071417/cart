<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator</title>
</head>
<body>
	${pageContext.request.contextPath }  <br/>
	<jsp:useBean id="calc" class="cn.domain.Calculator"></jsp:useBean>
	<jsp:setProperty property="*" name="calc"/>
	<jsp:getProperty property="firstNum" name="calc"/>
	<jsp:getProperty property="operator" name="calc"/>
	<jsp:getProperty property="secondNum" name="calc"/>=
	<%
		try {
			calc.calculate();
		} catch(RuntimeException e) {
			out.write("<font color='red'>" + e.getMessage()+ "</font>");
		}
	%>
	
	${calc.result }
	<form method="post" action="/cart/calculator.jsp">
	<input type="text" name="firstNum"/>
	<select name="operator">
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
	</select>
	<input type="text" name="secondNum"/>
	<input type="submit" value="提交"/>
	</form>

</body>
</html>