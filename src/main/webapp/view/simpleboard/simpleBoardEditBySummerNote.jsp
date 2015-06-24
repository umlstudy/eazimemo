<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>${title}</title>
	
	<!-- jquery bootstrap font-awesome summernote -->
	<script src="<c:url value='/resources/scripts/bower_components/jquery/jquery.min.js'/>"></script>
	<link  href="<c:url value='/resources/scripts/bower_components/bootstrap/dist/css/bootstrap.css'/>" rel="stylesheet">
	<script src="<c:url value='/resources/scripts/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
	<link  href="<c:url value='/resources/scripts/bower_components/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet">
	<link  href="<c:url value='/resources/scripts/bower_components/summernote/dist/summernote.css'/>" rel="stylesheet">
	<script src="<c:url value='/resources/scripts/bower_components/summernote/dist/summernote.js'/>"></script>
	<script src="<c:url value='/resources/scripts/bower_components/summernote/lang/summernote-ko-KR.js'/>"></script>
	<!-- jquery-validationEngine -->
	<link  href="<c:url value='/resources/scripts/bower_components/validationEngine/css/validationEngine.jquery.css'/>" rel="stylesheet" type="text/css" />
	<script src="<c:url value='/resources/scripts/bower_components/validationEngine/js/jquery.validationEngine.js'/>"></script>
	<script src="<c:url value='/resources/scripts/extras/jquery.validationEngine-ko.js'/>"></script>
	<script>
	$(document).ready(function() {
		$('.summernote').summernote({
			height: 300, 
			lang: 'ko-KR',
		});
		$('form[name=simpleBoardyApply]').validationEngine();
		$('form[name=simpleBoardyApply]').submit(function( event ) {
			var sHTML = $('.summernote').code();
			alert(sHTML);
			$('input[name=body]').val(sHTML);
			//$('form[name=simpleBoardyApply]').submit();
			//event.preventDefault();
		});
	});
	</script>
</head>
<!--바디-->
<body>
<form name="simpleBoardyApply" method="post" action="<c:url value='/simpleBoard/applyAndList'/>">
	<input type="hidden" name="idx" value="${simpleBoard.idx}"/>
	제목<br/>
	<input type="text" name="title" value="${simpleBoard.title}" class="validate[required] text-input"/>
	<br/>
	내용<br/>
	<input type="hidden" name="body" value="${simpleBoard.body}"/>
	<div class="summernote">${simpleBoard.body}</div>
	<br/>
	<input type="submit" value="저장">
	<input type="reset" value="리셋">
</form>
</body>
</html>
