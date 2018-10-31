<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th><h2>プロ野球<br>セントラル・リーグ一覧</h2></th></tr>
<tr><th>
<!-- for Eachで取得したものを受け取ったリストの中身を回す -->
<c:forEach var="team" items="${teamList}">
	<a href="${pageContext.request.contextPath}/cl/toOutput?id=${team.id}">
	<c:out value="${team.teamName}"/></a><br>
</c:forEach>

</th></tr></table>
</body>
</html>