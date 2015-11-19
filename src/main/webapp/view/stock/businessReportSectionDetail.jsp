<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
<!-- HEAD START -->
<title>BusinessReportSectionInfo</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${context}/resources/scripts/extras/jquery/addon/jquery.tmpl.min.js" type="text/javascript"></script>
<!-- HEAD END -->
</head>
<body>
<!-- BODY START -->
<div id="errorMsg">
</div>

<div>
<!-- BusinessReportSectionDetail START -->
<table id="BusinessReportSectionDetail">
	<thead>
		<tr>
			<td>내용</td>
		</tr>
	</thead>
	<tbody><td id="sectionDetail"></td></tbody>
</table>
<!-- BusinessReportSectionDetail END -->
</div>

<!-- BODY END -->
<script>
var ajaxRun = function(async, url, type, data, successFunc) {
	$.ajax({
		async: async,
		url  : url,
		type : type,
		data : data,
		success: function(data, textStatus, jqXHR) {
			if ( data.error ) {
	    		// 실패시
	    		$("#errorMsg").empty();
	    		$("#errorMsg").append(data.errorMessage);
	    		return;
			} else {
				// 성공시
				try {
					successFunc(data);
				} catch (e) {
					console.log(e);
					$("#errorMsg").empty();
					$("#errorMsg").append(e.message);
		    		return;
				}
			}
	   	},	
	    error: function (jqXHR, textStatus, errorThrown) {
	    	$("#errorMsg").append(jqXHR.responseText);
	    }
	});	
};

var showBusinessReportSectionDetail = function(rcpNo, dcmNo, eleId) {
	var async = false;
	var url = "${context}/stock/businessReportSectionDetail";
	var type = "GET";
	var data = "rcpNo="+rcpNo + "&dcmNo=" + dcmNo + "&eleId=" + eleId;
	ajaxRun(async, url, type, data, function(recvData) {
		$("#sectionDetail").html(recvData);
	});
};

showBusinessReportSectionDetail(${param.rcpNo},${param.dcmNo},${param.eleId});

</script>
</body>
</html>

