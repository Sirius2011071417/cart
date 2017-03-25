<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{
		text-align: center;
	}
	table {
  		border-collapse: collapse;
    }
	table, td, th {
  		border: 1px solid green;
    }
</style>
<title>书籍列表</title>
</head>
<body>
	<h3>本网站有如下书籍：</h3>
	<table border="1" width="50%" align="center">
		<tr>
			<td>ID</td>
			<td>书名</td>
			<td>作者</td>
			<td>价格</td>
			<td>详情</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${map }" var="entry">
		<tr>
			<td>${entry.value.id }</td>
			<td>${entry.value.name }</td>
			<td>${entry.value.author }</td>
			<td>${entry.value.price }</td>
			<td>${entry.value.description }</td>
			<td><a href="${pageContext.request.contextPath }/buyServlet?id=${entry.value.id }" target="_blank">购买</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>