<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>洋服.shop</h2>
	<br>
	<form action="${pageContext.request.contextPath}/shop/toResult" method="post">
		好きな色を選択してください<br> 
		<input type="radio" name="gender" value="0" checked>男
		<input type="radio" name="gender" value="1">女
		<select name="color">
			<option value="赤">赤</option>
			<option value="青">青</option>
			<option value="黄">黄</option>
			<option value="白">白</option>
		</select> <input type="submit" value="検索">
	</form>
	
<hr>	

<c:forEach var="shop" items="${shopList}">
	<table border="1">
		<tr>
			<th>ジャンル</th>
			<td><c:out value="${shop.genre}"/></td>
		</tr>
		<tr>
			<th>サイズ</th>
			<td><c:out value="${shop.size}"/></td>
		</tr>
		<tr>
			<th>価格</th>
			<td><fmt:formatNumber value="${shop.price}" pattern="###,####"/></td>
		</tr>
	</table>
</c:forEach>
</body>
</html>