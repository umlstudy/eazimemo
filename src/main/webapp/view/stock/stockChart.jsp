<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>주식차트</title>
</head>
<body>

<table id="contentMain">
	<thead>
		<tr>
			<td>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${myStocks}" varStatus="status">
		<tr>
			<td>
				${item.hname}<br/>
				<img src="${item.chartUrl}"/>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>
