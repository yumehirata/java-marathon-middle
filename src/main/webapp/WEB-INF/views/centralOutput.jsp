<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>球団名</h3>
<c:out value="${baseballTeam.teamName}"/>
<h3>本拠地</h3>
<c:out value="${baseballTeam.headquarters}"/>
<h3>発足</h3>
<c:out value="${baseballTeam.inauguration}"/>
<h3>歴史</h3>
<c:out value="${baseballTeam.history}"/>
<a href="${pageContext.request.contextPath}/cl/">戻る</a>
</body>
</html>