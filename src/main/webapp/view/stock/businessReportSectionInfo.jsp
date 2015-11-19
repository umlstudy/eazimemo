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
<!-- BusinessReportSectionInfo START -->
<table id="BusinessReportSectionInfo">
	<thead>
		<tr>
			<td>목차</td>
			<td>깊이</td>
		</tr>
	</thead>
	<tbody></tbody>
</table>
<script id="BusinessReportSectionInfoTmpl" type="text/x-jquery-tmpl">
	<tr>
		<td style="text-align:left;">
			<a href="${context}/page/stock/businessReportSectionDetail?rcpNo={{= rcpNo}}&dcmNo={{= dcmNo}}&eleId={{= eleId}}">{{= tocText}}</a>
		</td>
		<td style="text-align:right;">{{= offset}}</td>
	</tr>
</script>
<!-- BusinessReportSectionInfo END -->
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

var showBusinessReportSectionInfo = function(rcpNo) {
	var async = false;
	var url = "${context}/stock/businessReportSectionInfo";
	var type = "GET";
	var data = "rcpNo="+rcpNo;
	ajaxRun(async, url, type, data, function(recvData) {
		$("#BusinessReportSectionInfo tbody").empty();
		var json = JSON.parse(recvData);
		for (var idx in json.toc) {
			json.toc[idx].rcpNo = rcpNo;
			var brDescriptor = $("#BusinessReportSectionInfoTmpl").tmpl(json.toc[idx]);
			brDescriptor.prependTo("#BusinessReportSectionInfo tbody");
		}
	});
};

showBusinessReportSectionInfo(${param.rcpNo});

</script>
</body>
</html>

