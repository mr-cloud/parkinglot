/* Custom filtering function which will search data in column x between two values */
$.fn.dataTable.ext.search.push(
    function( settings, data, dataIndex ) {
    	var x = 1;
        var min = Date.parse( $('#min').val());
        var max = Date.parse( $('#max').val());
        var time = Date.parse( data[x] ); // use data for the time column
 
        if ( ( isNaN( min ) && isNaN( max ) ) ||
             ( isNaN( min ) && time <= max ) ||
             ( min <= time   && isNaN( max ) ) ||
             ( min <= time   && time <= max ) )
        {
            return true;
        }
        return false;
    }
);
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
	document.getElementById("DataTable.id").innerHTML = "id";
	document.getElementById("DataTable.time").innerHTML = "time";
	document.getElementById("DataTable.type").innerHTML = "type";
	document.getElementById("DataTable.description").innerHTML = "description";
	document.getElementById("DataTable.opName").innerHTML = "opName";

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
			"url" : "showTableClientSide.do?name=pldealrecord",
			// 从数组获取数据
			"dataSrc" : function (json) {
//				console.log(json);
				console.log(json.fields);
//				console.log(json.records);
				 return json.records;
//				return json;
			},
			"data" : function(data) {
				// 添加其他参数
				planify(data)
			}
		},
		// Key-val map.
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