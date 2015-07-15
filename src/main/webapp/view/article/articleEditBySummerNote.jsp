<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>${title}</title>
	
	<!-- jquery bootstrap font-awesome summernote -->
	<script src="${context}/resources/scripts/bower_components/jquery/jquery.min.js"></script>
	<link  href="${context}/resources/scripts/bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<script src="${context}/resources/scripts/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<link  href="${context}/resources/scripts/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link  href="${context}/resources/scripts/bower_components/summernote/dist/summernote.css" rel="stylesheet">
	<script src="${context}/resources/scripts/bower_components/summernote/dist/summernote.js"></script>
	<script src="${context}/resources/scripts/bower_components/summernote/lang/summernote-ko-KR.js"></script>
	<!-- jquery-validationEngine -->
	<link  href="${context}/resources/scripts/bower_components/validationEngine/css/validationEngine.jquery.css" rel="stylesheet" type="text/css" />
	<script src="${context}/resources/scripts/bower_components/validationEngine/js/jquery.validationEngine.js"></script>
	<script src="${context}/resources/scripts/extras/jquery.validationEngine-ko.js"></script>
	<script>
	$(document).ready(function() {
		$('.summernote').summernote({
			height: 300, 
			lang: 'ko-KR',
		});
		$('form[name=articleyApply]').validationEngine();
		$('form[name=articleyApply]').submit(function( event ) {
			var sHTML = $('.summernote').code();
			$('input[name=content]').val(sHTML);
			//$('form[name=articleyApply]').submit();
			//event.preventDefault();
		});
	});
	</script>
</head>
<body>
<form name="articleyApply" method="post" action="${context}/article/applyAndList">
	<input type="hidden" name="articleId" value="${article.articleId}"/>
	제목<br/>
	<input type="text" name="title" value="${article.title}" class="validate[required] text-input"/>
	<br/>
	내용<br/>
	<input type="hidden" name="content" value="${article.content}"/>
	<div class="summernote">${article.content}</div>
	<br/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="submit" value="저장">
	<input type="reset" value="리셋">
</form>
</body>
</html>
