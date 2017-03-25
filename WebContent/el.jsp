<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.ArrayList,cn.domain.Calculator,java.util.Map,java.util.LinkedHashMap"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl</title>
</head>
<body>
	<%
		List<Calculator> list = new ArrayList<Calculator>();
		list.add(new Calculator("12", "34", '+'));
		list.add(new Calculator("1", "234", '-'));
		list.add(new Calculator("123", "4", '*'));
		request.setAttribute("list", list);
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		request.setAttribute("map", map);
	%>
	
	<c:forEach items="${list }" var="item" varStatus="vs">
		${vs.index } ${vs.first } ${vs.last }
		${item.firstNum } ${item.operator } ${item.secondNum } <br/>
	</c:forEach>
	
	<c:forEach items="${map }" var="entry">
		${entry.key } : ${entry.value }<br/>
	</c:forEach>
	
	<a href="/cart/my.jsp">浏览</a>
</body>
</html>