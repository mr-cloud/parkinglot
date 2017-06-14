var confirmDownloadTag = false;
var reportTable;
var tableName = "plparkingrecord";
var myChart;

function getSelectedText(elementId) {
    var elt = document.getElementById(elementId);

    if (elt.selectedIndex == -1)
        return null;

    return elt.options[elt.selectedIndex].text;
}

function stats(){
	if ($("#statsX").val() === "") {
		alert("Stats conditions is incomplete!");
		return;
	}
	var xAttr = JSON.parse($("#statsX").val());
	colName = xAttr[0];
	metric = $("#statsY").val();
	groupBy = xAttr[1];
	timeCol = $("#timeCol").val();
	period = $("#period").val();
	var xAxisData;
	var seriesData;

	$.ajax({
		//解析从后台返回的json数据  
		data : "tableName=" + tableName +  "&colName=" + colName
					+ "&metric=" + metric + "&groupBy=" + groupBy
					+ "&timeCol=" + timeCol + "&period=" + period,
		url : "showReport.do",
		type : "get",
		success : function(data) {
			console.log("Stats data:\n " + data);
			xAxisData = data.xAxis;
			seriesData = data.series;
			
			var subtext = '统计项: [' + getSelectedText("statsX") + ']'
							+ ', 统计指标: [' + getSelectedText("statsY") + ']'
							+ ', 时间列: [' + getSelectedText("timeCol") + ']'
							+ ', 周期: [' + getSelectedText("period") + ']';
			var seriesName = metric;
			
			
			// 基于准备好的dom，初始化echarts实例
		    myChart = echarts.init(document.getElementById('statsReport'));

		    // 指定图表的配置项和数据
		    var option = {
		        title: {
		            text: '',
		            subtext: subtext
		        },
		        tooltip: {
		        	show:true
		        },
		        // 多种展示方式
		        toolbox: {
		            show: true,
		            feature: {
		                dataZoom: {
		                    yAxisIndex: 'none'
		                },
		                magicType: {type: ['line', 'bar']},
		                saveAsImage: {}
		            }
		        },
		        xAxis: {
		            data: xAxisData
		        },
		        yAxis: {},
		        series: [{
		            name: seriesName,
		            type: 'bar',
		            data: seriesData
		        }]
		    };
		  //Random color.
		    option.series[0].itemStyle={
		    		normal: {
		    			color: function(params) {
		    				var index = params.dataIndex;//表示当前的数据条的索引
		    				var color="";//表示最终显示的颜色
		    				var colorList = ['#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
		    				                 '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
		    				                 '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
		    				                 ];
		    				color = colorList[index % colorList.length]; 
		    				return color;
		    			},
		    			label:{
		    				show: true,
		    				position: 'top'
		    			}
		    		}
		    };
		    // 使用刚指定的配置项和数据显示图表。
		    myChart.setOption(option);
		}
	});
}

function removeOptions(selectbox) {
	var i;
	for (i = selectbox.options.length - 1; i >= 0; i--) {
		selectbox.remove(i);
	}
}

function xAxisChose(){
	yAxisSel = document.getElementById("statsY");
	removeOptions(yAxisSel);
	var xAttr = JSON.parse($("#statsX").val());
	arr = xAttr[2];
	var opt = document.createElement("option");
	for (var i = 0; i < arr.length; i++) {
		var opt = document.createElement("option");
		opt.value = arr[i];
		opt.innerHTML = arr[i];
		yAxisSel.appendChild(opt);
	}
}


function getcarType() {
	getColumnCategories("carType");
}

function getcarColor(){
	getColumnCategories("carColor");
}

function getpayWay(){
	getColumnCategories("payWay");
}

function getColumnCategories(colName){
	$.ajax({
		//解析从后台返回的json数据  
		data : "tableName=" + tableName +  "&colName=" + colName,
		url : "showColumnCategories.do",
		type : "get",
		success : function(data) {
			console.log("column categoties: " + data.records);
			var arr = eval(data.records);
			colQ = document.getElementById(colName + "Q");
			var opt = document.createElement("option");
			for (var i = 0; i < arr.length; i++) {
				var opt = document.createElement("option");
				opt.value = arr[i];
				opt.innerHTML = arr[i];
				colQ.appendChild(opt);
			}
		}
	});
}
$(document).ready(function() {
	initTables();
	// Init columns
	document.getElementById("DataTable.id").innerHTML = "记录号";
	document.getElementById("DataTable.carLicense").innerHTML = "车牌号";
	document.getElementById("DataTable.carType").innerHTML = "车辆类型";
	document.getElementById("DataTable.carColor").innerHTML = "车辆颜色";
	document.getElementById("DataTable.iTime").innerHTML = "入场时间";
	document.getElementById("DataTable.oTime").innerHTML = "出场时间";
	document.getElementById("DataTable.code").innerHTML = "条码";
	document.getElementById("DataTable.cost").innerHTML = "费用";
	document.getElementById("DataTable.payWay").innerHTML = "收费方式";

	// Init search tags. Should take it from static tables. 
//	getcarType();
//	getcarColor();
//	getpayWay();
	
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
    	    "carLicense" : ["AND", "LIKE", $("#carLicenseQ").val()],
    	    "carType" : ["AND", "EQUALS", $("#carTypeQ").val()],
    	    "carColor" : ["AND", "EQUALS", $("#carColorQ").val()],
    	    "iTimeStart" : ["AND", "GREATER_OR_EQUAL", $("#iTimeStartQ").val()],
    	    "iTimeEnd" : ["AND", "LESS_OR_EQUAL", $("#iTimeEndQ").val()],
    	    "oTimeStart" : ["AND", "GREATER_OR_EQUAL", $("#oTimeStartQ").val()],
    	    "oTimeEnd" : ["AND","LESS_OR_EQUAL", $("#oTimeEndQ").val()],
    	    "code" : ["AND", "LIKE", $("#codeQ").val()],
    	    "payWay" : ["AND", "EQUALS", $("#payWayQ").val()]		
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