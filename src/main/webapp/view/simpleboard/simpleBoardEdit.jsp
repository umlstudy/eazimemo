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
	<form name="simpleBoardyApply" method="post" action="simpleBoard/applyAndList">
		<input type="hidden" name="idx" value="${simpleBoard.idx}"/>
		제목<br/>
		<input type="text" name="title" value="${simpleBoard.title}"/>
		<br/>
		내용<br/>
		<textarea name="body" rows="20" cols="40">${simpleBoard.body}</textarea>
		<br/>
		<input type="submit" value="저장">
		<input type="reset" value="리셋">
	</form>
</div>
</body>
</html>
