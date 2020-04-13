$(document).ready(function () {
	$('#tbProducts').DataTable();
});

function handleDelete(id) {
	var id = parseInt(id);
	
	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este registro?';
	var url = '/PrettyStyle/products?'+id;
	var type = 'warning';
	var method = 'delete';

	AlertaAvisoConfirm(title, question, url, type, method);
}
