<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    .error {
    	color: red;
    }
</style>
<script type="text/javascript">
	function deleteitem(id) {
		var r = confirm("您确认删除吗？");
		if(r) {
			location.href = "${pageContext.request.contextPath }/deleteItemServlet?id=" + id;
		}
	}
	
	function clearcart() {
		var r = confirm("您确认清空吗？");
		if(r) {
			location.href = "${pageContext.request.contextPath }/clearCartServlet";
		}
	}
	
	function changequartity(input, id, oldValue) {
		var quartity = input.value;

		//if(quartity<0 || quartity!=parseInt(quartity)) {
			//alert("请输入一个正整数！！！");
			//input.value = oldValue;
			//return;
		//}
		var r = confirm("您确定把数量改成"+ quartity +"吗？");
		if(r) {
			location.href = "${pageContext.request.contextPath }/changeQuartity?id="+id+"&quartity="+quartity;
		}
	}
</script>
<title>购物车</title>
</head>
<body>
	<h3>购物车列表</h3>
	<p class="error">${errors.NaN }</p>
	<c:if test="${empty cart.map }">
		购物车为空！！！
	</c:if>
	
	<c:if test="${!empty cart.map }">
		<table border="1" width="50%" align="center">
			<tr>
				<td>书名</td>
				<td>作者</td>
				<td>单价</td>
				<td>数量</td>
				<td>小计</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${cart.map }" var="entry">
				<tr>
					<td>${entry.value.book.name }</td>
					<td>${entry.value.book.author }</td>
					<td>${entry.value.book.price }</td>
					<td>
						<input type="text" id="quantity" value="${entry.value.quartity }" style="width:35px;" onchange="changequartity(this, ${entry.key }, ${entry.value.quartity })"/>
					</td>
					<td>${entry.value.price }</td>
					<td><a href="javascript:void(0);" onclick="deleteitem(${entry.key })">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">总价</td>
				<td colspan="2">${cart.price }元</td>
				<td colspan="1">
					<a href="javascript:void(0);" onclick="clearcart();">清空购物车</a>
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>