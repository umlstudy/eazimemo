<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
   	<meta name="viewport" content="width=device-width">
	<title>주식검색</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="${context}/resources/scripts/extras/jquery/addon/jquery.tmpl.min.js" type="text/javascript"></script>
	<script src="${context}/resources/scripts/extras/user/ajaxutil.js" type="text/javascript"></script>
</head>
<body>

<form id="stockSearch" name="stockSearch">
	종목명 <input type="text" name="crpNm"/>
	<input type="submit" value="찾기"/>
</form>

<div id="errorMsg"></div>

<table id="StockSearchTable">
	<thead>
		<tr>
			<td>
			</td>
			<td>
			</td>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

<script id="StockSearchTmpl" type="text/x-jquery-tmpl">
	<tr>
		<td>{{= ifmNm}}</td>
		<td><a href="${context}/page/stock/businessReportDescriptors?shCode={{= cik}}">사업보고서</a></td>
	</tr>
</script>
<!-- StockSearchTmpl END -->

<script>
var handleError = function(msg) {
	$("#errorMsg").empty();
	$("#errorMsg").append(msg);
};

var submitStockSearch = function(event) {
	var async = false;
	var url = "${context}/stock/searchCorpInfo";
	var type = "GET";
	var data = $("#stockSearch").jsonString();
	var successFunc = function(json) {
		for (var idx in json.list) {
			var brDescriptor = $("#StockSearchTmpl").tmpl(json.list[idx]);
			brDescriptor.prependTo("#StockSearchTable tbody");
		}
	};
	var errorFunc = handleError;
	$.ajaxUtil.ajaxRun(async, url, type, data, successFunc, errorFunc);
	
	event.preventDefault();
	event.stopPropagation();
};

// main
$("#stockSearch").submit(submitStockSearch);
</script>

</body>
</html>
