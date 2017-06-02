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
