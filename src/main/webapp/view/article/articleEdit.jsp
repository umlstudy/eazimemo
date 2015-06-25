<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>${title}</title>
</head>
<body>
<div>
	<form name="articleyApply" method="post" action="article/applyAndList">
		<input type="hidden" name="articleId" value="${article.articleId}"/>
		제목<br/>
		<input type="text" name="title" value="${article.title}"/>
		<br/>
		내용<br/>
		<textarea name="content" rows="20" cols="40">${article.content}</textarea>
		<br/>
		<input type="submit" value="저장">
		<input type="reset" value="리셋">
	</form>
</div>
</body>
</html>
