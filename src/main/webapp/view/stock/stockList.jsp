<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>주식목록</title>
</head>
<body>

<a href="${context}/stock/stockChart">차트보기</a>
<table id="contentMain">
	
	<thead>
		<tr>
			<td>
			</td>
			<td>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${myStocks}" varStatus="status">
		<tr>
			<td>${item.hname}</td>
			<td><a href="${context}/stock/businessReport?shCode=${item.shcode2}">사업보고서</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>
