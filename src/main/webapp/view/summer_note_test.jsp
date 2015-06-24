<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML lang="ko">
<HEAD>
	<!-- http://summernote.org/#/getting-started#installation-include -->
	
	<!-- jquery -->
	<script src="<c:url value='/resources/scripts/bower_components/jquery/dist/jquery.min.js'/>"></script>
	
	<!-- bootstrap -->
	<link  href="<c:url value='/resources/scripts/bower_components/bootstrap/dist/css/bootstrap.css'/>" rel="stylesheet">
	<script src="<c:url value='/resources/scripts/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>

	<!-- font-awesome -->
	<link  href="<c:url value='/resources/scripts/bower_components/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet">

	<!-- summernote -->
	<link  href="<c:url value='/resources/scripts/bower_components/summernote/dist/summernote.css'/>" rel="stylesheet">
	<script src="<c:url value='/resources/scripts/bower_components/summernote/dist/summernote.js'/>"></script>
	<script src="<c:url value='/resources/scripts/bower_components/summernote/lang/summernote-ko-KR.js'/>"></script>
</HEAD>
<BODY>

<div class="summernote">summernote 1</div>

<script>
$(document).ready(function() {
	$('.summernote').summernote({
		height: 300,                 // set editor height
		lang: 'ko-KR',
	});
});
</script>
</BODY>
</HTML>