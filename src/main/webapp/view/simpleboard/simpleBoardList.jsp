<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html style="margin: 0px; broder: 0px; background:#f4f4f4;">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>${title}</title>
	
	<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>	
   	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js" type="text/javascript"></script>
</head>

<!--바디-->
<body style="margin: 0px; broder: 0px; background:#f4f4f4;">
<div align="center" id="wrapper" style="margin: 8px;">

<table style="border:0; cellpadding:0; cellpadding:0;">
	<thead>
		<tr>
			<td>
				제목
			</td>
			<td>
				수정일
			</td>
			<td>
				보기
			</td>
			<td>
				수정
			</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${simpleBoards}" varStatus="status">
		<tr>
			<td>
				${item.title}
			</td>
			<td>
				${item.updateTime }
			</td>
			<td>
				<a href="simpleBoard/show?idx=${item.idx}">보기</a>
			</td>
			<td>
				<a href="simpleBoard/edit?idx=${item.idx}">수정</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>
