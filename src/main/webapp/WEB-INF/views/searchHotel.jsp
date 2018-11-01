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
	<h2>ホテル検索</h2>
	<form action="${pageContext.request.contextPath}/hotel/result"
		method="post">
		一泊料金 <input type="text" name="price"> 円以下<br>
		<input type="submit" value="検索">
	</form>

	<hr>

	<c:forEach var="hotel" items="${hotelList}">

		<table border="1">
			<tr>
				<td>ホテル名</td>
				<td><c:out value="${hotel.hotelName}" /></td>
			</tr>
			<tr>
				<td>最寄り駅</td>
				<td><c:out value="${hotel.nearestStation}" /></td>
			</tr>
			<tr>
				<td>価格</td>
				<td><fmt:formatNumber value="${hotel.price}" pattern="###,###" /></td>
			</tr>
		</table>

	</c:forEach>

</body>
</html>