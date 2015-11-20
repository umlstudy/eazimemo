<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
   	<meta name="viewport" content="width=device-width">
	<title>주식목록</title>
</head>
<body>

<a href="${context}/stock/stockChart">차트보기</a>
<table id="contentMain">
	
	<thead>
		<tr>
			<td></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${myStocks}" varStatus="status">
		<tr>
			<td>
				<a href="${context}/page/stock/businessReportDescriptors?shCode=${item.shcode2}&type=B">${item.hname}</a>
				<a href="${context}/page/stock/businessReportDescriptors?shCode=${item.shcode2}&type=N">공시</a>
			<td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>
