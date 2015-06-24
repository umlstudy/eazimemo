<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<title>${title}</title>
</head>

<!--바디-->
<body>
	제목 : ${simpleBoard.title}
	<br/>
	내용<br/>
	${simpleBoardBody}
	<br/>
	<a href="javascript:history.back();">뒤로</a>
</body>
</html>
