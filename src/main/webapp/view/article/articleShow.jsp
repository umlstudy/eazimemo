<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>${title}</title>
</head>
<body>
	제목 : ${article.title}
	<br/>
	내용<br/>
	${article.content}
	<br/>
	<a href="javascript:history.back();">뒤로</a>
</body>
</html>
