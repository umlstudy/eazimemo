<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>${title}</title>
	
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
	<a href="${context}/article/edit">새글쓰기</a>
</div>
<table id="contentMain">
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
		<c:forEach var="item" items="${articles}" varStatus="status">
		<tr>
			<td>
				${item.title}
			</td>
			<td>
				${item.updateTime }
			</td>
			<td>
				<a href="${context}/article/show?articleId=${item.articleId}">보기</a>
			</td>
			<td>
				<a href="${context}/article/edit?articleId=${item.articleId}">수정</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>

</body>
</html>
