var confirmDownloadTag = false;
var reportTable;
var tableName = "plparkingcar";

$(document).ready(function() {
	// Init tables.
	document.getElementById("plblacklist").innerHTML = "plblacklist";
	document.getElementById("pldealrecord").innerHTML = "pldealrecord";
	document.getElementById("plmalfunctionrecord").innerHTML = "plmalfunctionrecord";
	document.getElementById("plparkingsensor").innerHTML = "plparkingsensor";
	document.getElementById("plparkingspace").innerHTML = "plparkingspace";
	document.getElementById("plparkingcar").innerHTML = "plparkingcar";
	document.getElementById("plparkingrecord").innerHTML = "plparkingrecord";
	document.getElementById("plrunrecord").innerHTML = "plrunrecord";
	
	// Init columns
	document.getElementById("DataTable.tId").innerHTML = "车辆编号";
	document.getElementById("DataTable.carLicence").innerHTML = "车牌号码";
	document.getElementById("DataTable.carType").innerHTML = "车辆类型";
	document.getElementById("DataTable.carColor").innerHTML = "车辆颜色";
	document.getElementById("DataTable.iTime").innerHTML = "入场时间";
	document.getElementById("DataTable.code").innerHTML = "编码";
	document.getElementById("DataTable.pickCount").innerHTML = "pickCount";
	
	// Init table and show records.   
	reportTable = $('#DataTable').DataTable( {
    	//支持下载
    	dom: 'lBrtip',
    	buttons: [
    	          {
    	              extend: 'excel',
    	              text: '下载表格',
    	          }
    	      ],
        "processing": true,
        "serverSide": true,
        "ordering": false,
		"ajax" : {
			"url" : "showTableServerSide.do",
			"dataSrc" : function (json) {
				console.log(json);
				return json.data;  // Only need to return data field. 
			},
		    "contentType": "application/json",
		    "type": "POST",
			"data" : function(data) {
				// 添加其他参数
				planify(data);
				return JSON.stringify(data);
			}
		}
    });
});

function planify(data) {
    //下载报告
	data.tableName = tableName;
    data.confirmDownloadTag = confirmDownloadTag;
    // Delete unnecessary parameters.
    delete(data.columns);
    delete(data.search);
    delete(data.order);
    // Complex query
    data.conditions = {
    	    "carLicence" : ["AND", "LIKE", $("#carLicenseQ").val()],
    	    "carType" : ["AND", "EQUALS", $("#carTypeQ").val()],
    	    "carColor" : ["AND", "EQUALS", $("#carColorQ").val()],
    	    "iTimeStart" : ["AND", "GREATER_OR_EQUAL", $("#iTimeStartQ").val()],
    	    "iTimeEnd" : ["AND", "LESS_OR_EQUAL", $("#iTimeEndQ").val()],
    	    "code" : ["AND", "LIKE", $("#codeQ").val()],
    }
}

//任何下载动作之前都应该先确认导出
function confirmDownload(){
	confirmDownloadTag = true;
	reportTable.ajax.reload(function () {
		confirmDownloadTag = false;
		alert("现在可下载表格或者报告！");
	});
}

function searchReports(){
	reportTable.ajax.reload(function () {
		confirmDownloadTag = false;
		console.log("报告已刷新！");
	});}