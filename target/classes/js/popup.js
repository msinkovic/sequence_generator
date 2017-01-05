$(document).ready(function() {
	var table = $('#dataTable').DataTable();
	$('#dataTable').on('click', 'tr', function() {
		var name = $('td', this).eq().text();
		console.log(table.row(this).data()[0]);
		$("#sequence").val(table.row(this).data()[0]);
		$("#user").val(table.row(this).data()[1]);
		$("#date").val(table.row(this).data()[3]);
		$("#purpose").val(table.row(this).data()[2]);
		$('#DescModal').modal("show");
	});
});