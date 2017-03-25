<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.huangjunjun.com" prefix="tt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tt:if test="${user==null }">
		用户名为空
	</tt:if>
	<%
		String gender = "female";
		request.setAttribute("gender", gender);
		
		String[] likes = {"eat", "play"};
		request.setAttribute("likes", likes);
	%>
	${requestScope }
	${header }
	<hr/>
	${header["user-agent"] }
	<hr/>
	${cookie.JSESSIONID.name }
	${cookie.JSESSIONID.value }
	<hr/>
	<input type="radio" name="gender" value="male" ${gender=="male" ?"checked":""} />男
	<input type="radio" name="gender" value="female" ${gender=="female"?"checked":"" }/>女
	<hr/>
	${fn:join(likes, ",") }
	${fn:contains(fn:join(likes, ","), "eat") }
	<input type="checkbox" name="likes" value="eat" ${fn:contains(fn:join(likes, ","), "eat") ?"checked":""}/>吃
	<input type="checkbox" name="likes" value="drink" ${fn:contains(fn:join(likes, ","), "drink") ?"checked":""}/>喝
	<input type="checkbox" name="likes" value="play" ${fn:contains(fn:join(likes, ","), "play") ?"checked":""}/>玩
	<hr/>
	
	
	<c:out value="${data }" default="没有性别"/>
	<hr/>
	<c:out value="<a href=''>点点</a>" escapeXml="true"/>
	<c:set scope="request" var="data" value="request域设置属性data"></c:set>
	${requestScope.data }
	<hr/>
	
	<%
		Map map = new HashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("c", "ccc");
		session.setAttribute("map", map);
	%>
	<c:set target="${map }" property="d" value="333"/>
	${map }
	<%-- 
	<c:remove scope="session" var="map"/>
	<c:out value="${map }" default="map属性已经被删除"/>
	--%>
	<hr/>
	
	<c:catch var="exp">
		<%
			int i = 1/0;
		%>
	</c:catch>
	${exp.message }
	<hr/>
	<c:if test="${user==null }" var="res" scope="page">
		结果是:${res }
	</c:if>
	
	<hr/>
	<c:forEach var="item" items="${map }" begin="1" end="3" step="1" varStatus="status">
		${status.count }
	</c:forEach>
</body>
</html>