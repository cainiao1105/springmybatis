Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, // 月
		"d+" : this.getDate(), // 天
		"h+" : this.getHours(), // 时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 刻
		"S" : this.getMilliseconds() //毫秒
	// millisecond
	}
	if (/(y+)/.test(format)){
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for ( var k in o){
		if (new RegExp("(" + k + ")").test(format)){
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]	: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

/**
 * 定义Common类
 */
var CommonUtil = {

    //EasyUI用DataGrid用日期格式化
    timeFormatter: function (value, rec, index) {
    	if (value == undefined || value == null || value == "") {
            return "";
        }
    	var dateValue = new Date(value);
        return dateValue.format("hh:mm:ss")
//        return val.substr(11, 5);
    },
    dateTimeFormatter: function (value, rec, index) {
        if (value == undefined || value == null || value == "") {
            return "";
        }
        var dateValue = new Date(value);
        return dateValue.format("yyyy-MM-dd hh:mm:ss")
    },
    //EasyUI用DataGrid用日期格式化
    dateFormatter: function (value, rec, index) {
    	if (value == undefined || value == null || value == "") {
            return "";
        }
        /*json格式时间转js时间格式*/
    	var dateValue = new Date(value);
        return dateValue.format("yyyy-MM-dd")
    },
    /*
     * formatMoney(s)
     * 功能：金额按千位逗号分割
     * 参数：s，需要格式化的金额数值.
     * 返回：返回格式化后的数值字符串.
     * 例如：-100,011.45
     */
    formatMoney:function(number) {
    	var minusSign = "";//减号位
    	var floatPart = "";//小数位
    	var integerPart = "";//整数位
    	integerPart = number.toString();
        if(integerPart.indexOf(".") >= 0){
        	var arrStr = integerPart.split('.');
        	floatPart = arrStr[1],
        	integerPart = arrStr[0];
        }
        if(integerPart.indexOf("-") >= 0){
        	var arrStr = integerPart.split('-');
        	minusSign = "-",
        	integerPart = arrStr[1];
        }
        var step = 3;
        var len = 0;
        len = integerPart.length;
        if(len > step) {
            var c1 = len%step,
                c2 = parseInt(len/step),
                arr = [],
                first = integerPart.substr(0, c1);
            if(first != '') {
                arr.push(first);
            };
            for(var i=0; i<c2; i++) {
                arr.push(integerPart.substr(c1 + i*step, step));
            };
            integerPart = arr.join(',');
        };
        if(floatPart == ""){
        	return minusSign + integerPart;
        }else{
        	return minusSign + integerPart + '.' + floatPart;
        }
    },
    //刷新grid
    refreshGrid:function (gridId,queryFormId){
    	if(queryFormId != null && queryFormId != ""){
    		var data = $('#' + queryFormId).serialize(); //序列化，默认会调用encodeURIComponent()进行编码
    		data = data.replace(/\+/g," ");// g表示对整个字符串中符合条件的都进行替换
    		data =  decodeURIComponent(data,true);//对serialize后的内容进行解码
//	    	var data=decodeURIComponent(($('#' + queryFormId).serialize()),true);
	    	var params= data.split("&");
	    	var queryParams = $('#' + gridId).datagrid('options').queryParams;
	    	for(i=0;i<params.length;i++){
	    		var param = params[i];
	    		var item = params[i].split("=");
	    		var label = item[0];
	    		var value = item[1];
	    		if (label != undefined && label != null && label != "" && label.trim() != "") {
		    		if(value != undefined && value != null && value != ""){
		    			queryParams[label] = value.trim();
		    		}else{
		    			queryParams[label] = '';
		    		}
	    		}
	    	}
//	    	alert(JSON.stringify(queryParams));
//	    	queryParams["search_userName"] = $("#search_userName").val();
	    	$('#' + gridId).datagrid('options').pageNumber = 1;
	    	var p = $('#' + gridId).datagrid('getPager');
	    	if (p){
	    	    $(p).pagination({
	    	       pageNumber:1
	    	    });
	    	}
	    	$('#' + gridId).datagrid('reload');
    	}else{
    		// 刷新列表数据
    		$('#' + gridId).datagrid('reload');
    	}
    }
};
