$(document).ready(function() {
	var table = $('#dataTable').DataTable({
		"paginate" : true,
		"pageLength" : 6,
		"ordering" : false,
		"info" : false,
		"pagingType" : "simple",
		"language" : {
			"search" : "",
			"paginate": {
				"previous": "⇐            ",
				"next": "⇒"
			}
		},
		"lengthChange" : false,
		columnDefs: [
			{ targets: 2, render: $.fn.dataTable.render.ellipsis( 20 ) },
		]
	});

	var info = table.page.info();
	$('#tableInfo').html('Page ' + (info.page + 1) + ' / ' + info.pages);

	var oTable = $('#dataTable').dataTable();
	var input = $('#dataTable_filter input').unbind();
	$('#goButton').click(function(e){
		if ($("div.dataTables_filter input").val().length > 2) {
			oTable.fnFilter($("div.dataTables_filter input").val());
		} else if ($("div.dataTables_filter input").val().length == 0) {
			oTable.fnFilterClear();
		}
    });
	$('#dataTable_filter input').bind('keyup', function searching(e) {
		if (e.keyCode == 13) {
			if (this.value.length > 2) {
				oTable.fnFilter(this.value);
			} else if (this.value.length == 0) {
				oTable.fnFilterClear();
			}
		}
	});
	$("div.dataTables_filter").append($('#goButton'));
	
});