<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
<!-- HEAD START -->
<meta name="viewport" content="width=device-width">
<title>주식목록</title>
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
		<td style="text-align:right;"><a href="#" onClick="showBusinessReportSectionInfo({{= rcpNo}});return false;">{{= rptNm}}</a></td>
	</tr>
</script>
<!-- BusinessReportDescriptor END -->
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
		<td style="text-align:left;"><a href="#" onClick="showBusinessReportSectionDetail({{= rcpNo}}, {{= dcmNo}}, {{= eleId}});return false;">{{= tocText}}</a></td>
		<td style="text-align:right;">{{= offset}}</td>
	</tr>
</script>
<!-- BusinessReportSectionInfo END -->
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

var showBusinessReportSectionDetail = function(rcpNo, dcmNo, eleId) {
	var async = false;
	var url = "${context}/stock/businessReportSectionDetail";
	var type = "GET";
	var data = "rcpNo="+rcpNo + "&dcmNo=" + dcmNo + "&eleId=" + eleId;
	ajaxRun(async, url, type, data, function(recvData) {
		$("#sectionDetail").html(recvData);
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
			brDescriptor.prependTo("#BusinessReportDescriptor tbody");
		}
	});
};

showBusinessReportDescriptor();

</script>
</body>
</html>

