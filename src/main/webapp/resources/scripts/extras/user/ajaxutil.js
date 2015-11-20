/**
 * serializeObject
 */
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

/**
 * jsonString
 */
$.fn.jsonString = function() {
	var json = this.serializeObject();
	return $.param(json);
};


/**
 * ajaxUtil
 */
$.ajaxUtil = { };

/**
 * ajaxUtil.ajaxRun
 */
$.ajaxUtil.ajaxRun = function(async, url, type, data, successFunc, errorFunc) {
	$.ajax({
		async: async,
		url  : url,
		type : type,
		data : data,
		success: function(data, textStatus, jqXHR) {
			if ( data.error ) {
	    		// 실패시
				console.log(data.errorMessage);
				errorFunc(data.errorMessage);
			} else {
				// 성공시
				try {
					successFunc(data);
				} catch (e) {
					console.log(e);
					errorFunc(e.message);
				}
			}
	   	},	
	    error: function (jqXHR, textStatus, errorThrown) {
	    	console.log(errorThrown);
			errorFunc(jqXHR.responseText);
	    }
	});
};