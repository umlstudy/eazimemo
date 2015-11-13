<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>할로</title>
	
	<style>
#content {
	background-color:#9977dd;
	width: 800px;
}

#contentTop {
	background-color:#cc7799;
	clear: both;
	height: 100px;
}

#contentMain {
	background-color:#aa77cc;
	clear: both;
}
	</style>
</head>
<body>
<div id="content">
<div id="contentTop">
</div>
<table id="contentMain">
	<thead>
		<tr>
			<td>
				주소
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
</div>

</body>
</html>
