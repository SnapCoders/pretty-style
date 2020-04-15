function handleDelete(id) {
	var id = parseInt(id);
	console.log("oi");
	
	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este endereço?';
	var url = '/PrettyStyle/addresses?'+id;
	var type = 'warning';
	var method = 'delete';

	AlertaAvisoConfirm(title, question, url, type, method);
}

 function handleSelectDefault(input) {
	$('.jumbotron .address').removeClass('active');
	$(input).closest('#card-address').addClass('active');
}
