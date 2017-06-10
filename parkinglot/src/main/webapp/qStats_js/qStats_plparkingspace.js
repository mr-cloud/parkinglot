var tableName = "plparkingspace";
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
	document.getElementById("DataTable.pSpaceId").innerHTML = "pSpaceId";
	document.getElementById("DataTable.resStatus").innerHTML = "resStatus";
	document.getElementById("DataTable.carType").innerHTML = "carType";
	document.getElementById("DataTable.ps_sId").innerHTML = "ps_sId";
	document.getElementById("DataTable.pc_tId").innerHTML = "pc_tId";

	// Init table and show records.
    // Setup - add a text input to each footer cell
    $('#DataTable tfoot th').each( function (i) {
        var title = $('#DataTable thead th').eq( $(this).index() ).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" data-index="'+i+'" />' );
    } );
    
	var table = $('#DataTable').DataTable( {
    	//支持下载
    	dom: 'lBfrtip',
    	buttons: [
    	          {
    	              extend: 'excel',
    	              text: '下载表格',
    	          }
    	      ],
        "processing": true,
        "order": [[0, 'asc']],
		"ajax" : {
			"url" : "showTableClientSide.do?name=plparkingspace",
			// 从数组获取数据
			"dataSrc" : function (json) {
				console.log(json.fields);
				 return json.records;
			},
			"data" : function(data) {
				// 添加其他参数
				planify(data)
			}
		},
		// Key-val map. Here we use pure data by array in array.
		/*columns : [
					{
						data : "id"
					},
					{
						data : "time",
					}, {
						data : "type"
					},{
						data : "description"
					},{
						data : "opName"
					}]*/
    });
	
    // Filter event handler
    $( table.table().container() ).on( 'keyup', 'tfoot input', function () {
        table
            .column( $(this).data('index') )
            .search( this.value )
            .draw();
    } );
    
    // Event listener to the two range filtering inputs to redraw on input
    $('#min, #max').keyup( function() {
        table.draw();
    } )
});

function planify(data) {
    // TODO
}
