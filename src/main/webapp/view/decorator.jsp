<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<meta name="viewport" content="width=device-width">
    	<title><sitemesh:write property='title'/></title>
    	<link type="text/css" href="${pageContext.request.contextPath}/view/decorator.css" rel="stylesheet"/>
		<sitemesh:write property='head'/>
	</head>

<body>

<sitemesh:write property='body' encoding="utf-8"><!-- 바디영역 --></sitemesh:write>

<div class='disclaimer'>eazimemo</div>
<div class='navigation'>
<b>메뉴:</b>
[<a href="http://mac.sejong.asia">홈</a>]
[<a href="javascript:history.go(-1);">뒤로</a>]
<%--
[<a href="<c:url value='/view/demo.jsp'/>">동적파일</a>]
--%>
</div>
</body>
</html>