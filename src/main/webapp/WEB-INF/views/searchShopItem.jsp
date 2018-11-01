<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>洋服.shop</h2><br>

<form:form modelAttribute="shopForm" action="${pageContext.request.contextPath}/shopItem/searchedItem">
好きな色を選択してください<br>
	<form:radiobuttons path="gender" items="${genderMap}" delimiter="<br>"/>
	<form:select path="color">
	<form:options items="${colorList}"/>
	</form:select>
	<input type="submit" value="検索">
</form:form>
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
			<td><fmt:formatNumber value="${shop.price}" pattern="###,###"/></td>
		</tr>
	</table>
</c:forEach>
</body>
</html>