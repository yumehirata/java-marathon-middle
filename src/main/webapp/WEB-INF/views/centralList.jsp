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
<tr><th><h3>プロ野球<br>セントラル・リーグ一覧</h3></th></tr>
<tr><th>
<c:forEach var="team" items="${teamList}">
	<a href="${pageContext.request.contextPath}/cl/toOutput?id=${team.id}">
	<c:out value="${team.teamName}"/></a><br>
</c:forEach>
</th></tr></table>
</body>
</html>