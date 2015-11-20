<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
<!-- HEAD START -->
<meta name="viewport" content="width=device-width">
<title>BusinessReportDescriptors</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${context}/resources/scripts/extras/jquery/addon/jquery.tmpl.min.js" type="text/javascript"></script>
<!-- HEAD END -->
</head>
<body>
<!-- BODY START -->
<div id="errorMsg">
</div>
<div>
<!-- BusinessReportDescriptor START -->
<table id="BusinessReportDescriptor">
	<thead>
		<tr>
			<td>회사명</td>
			<td>보고서명</td>
		</tr>
	</thead>
	<tbody></tbody>
</table>
<script id="BusinessReportDescriptorTmpl" type="text/x-jquery-tmpl">
	<tr>
		<td style="text-align:right;">{{= crpNm}}</td>
		<td style="text-align:right;">
			<a href="${context}/page/stock/businessReportSectionInfo?rcpNo={{= rcpNo}}">{{= rptNm}}</a>
		</td>
	</tr>
</script>
<!-- BusinessReportDescriptor END -->
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

var showBusinessReportDescriptor = function() {
	var async = false;
	var url = "${context}/stock/businessReportDescriptors";
	var type = "GET";
	var data = "shCode=${param.shCode}";
	ajaxRun(async, url, type, data, function(recvData) {
		var json = JSON.parse(recvData);
		for (var idx in json.list) {
			var brDescriptor = $("#BusinessReportDescriptorTmpl").tmpl(json.list[idx]);
			brDescriptor.appendTo("#BusinessReportDescriptor tbody");
		}
	});
};

showBusinessReportDescriptor();

</script>
</body>
</html>

