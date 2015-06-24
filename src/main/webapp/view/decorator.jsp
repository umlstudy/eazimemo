<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>타이틀자리<sitemesh:write property='title'>타이틀자리...</sitemesh:write></title>
    <style type='text/css'>
      body { font-family: arial, sans-serif; background-color: #ffffcc; }
      h1, h2, h3, h4 { text-align: center; background-color: #ccffcc; border-top: 1px solid #66ff66; }
      .disclaimer { text-align: center; border-top: 1px solid #cccccc; margin-top: 40px; color: #666666; font-size: smaller; }
    </style>
	<sitemesh:write property='head'/>
  </head>
  <body>

    <h1 class='title'>타이틀자리<sitemesh:write property='title'>타이틀자리...</sitemesh:write></h1>

    <sitemesh:write property='body' encoding="utf-8">바디자리</sitemesh:write>

    <div class='disclaimer'>사이트메시데모</div>
    <div class='navigation'>
      <b>메뉴:</b>
      [<a href="<c:url value='/view/'/>">정적파일</a>]
      [<a href="<c:url value='/view/demo.jsp'/>">동적파일</a>]
    </div>

  </body>
</html>