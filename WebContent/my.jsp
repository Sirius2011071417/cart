<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://www.huangjunjun.com" prefix="jun"%>


<jun:sdemo2/>
<jun:demo2/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
	<%@ include file="/font.jsp" %>
	正文
	<%@ include file="/head.jsp" %>
	
	<%!
		public void run() {}
	%>
	
	<%
		String user = "huangjun";
		request.setAttribute("user", user);
	%>
	您的IP是：<jun:viewip/>
	
	<jun:demo1>
		aaaaaa
	</jun:demo1>
	
	<jun:demo3>
		bbbbbb
	</jun:demo3>
	
	<jun:demo4>
		cccccc
	</jun:demo4>
	
	<hr/>
	<jun:sdemo1>
		ssssss
	</jun:sdemo1>
	
	<jun:sdemo3>
		zzzzzz
	</jun:sdemo3>
	
	<jun:sdemo4>
		yyyyyy
	</jun:sdemo4>
	
	<jun:sademo1 count="15">
		xxxxxx
	</jun:sademo1>
	
	<jun:sademo2 date="<%=new Date() %>">
		xxxxxx
	</jun:sademo2>
	
	<jun:if test="${user!=null }">
		用户名不为空
	</jun:if>
	
	<jun:choose>
		<jun:switch test="${user==null }">
			空空空空空
		</jun:switch>
		<jun:otherwise test="${user!=null }">
			非空空空空空
		</jun:otherwise>
	</jun:choose>
	<hr/>
	<%
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		request.setAttribute("list", list);
	%>
	<jun:foreach var="item" items="${list }">
		${item }
	</jun:foreach>
	<hr/>
	<%
		Set set = new HashSet();
		set.add("aaaa");
		set.add("bbbb");
		set.add("cccc");
		request.setAttribute("set", set);
	%>
	<jun:foreach var="item" items="${set }">
		${item }
	</jun:foreach>
	<hr/>
	<%
		Map map = new HashMap();
		map.put("aa", 11);
		map.put("bb", 22);
		map.put("cc", 33);
		request.setAttribute("map", map);
	%>
	<jun:foreach var="item" items="${map }">
		${item.key }: ${item.value }
	</jun:foreach>
	
	<hr/>
	<%
		boolean[] arr = {true, false, true};
		request.setAttribute("arr", arr);
	%>
	<jun:foreach var="item" items="${arr }">
		${item }
	</jun:foreach>
	
	<jun:htmlFilter>
		<a href="http://www.baidu.com/">百度一下</a>
	</jun:htmlFilter>
</body>
</html>