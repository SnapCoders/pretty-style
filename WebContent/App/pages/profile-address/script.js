function handleDelete(id) {
	var id = parseInt(id);
	var id_user = sessionStorage.getItem("id_user");
	
	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este endereço?';
	var url = '/PrettyStyle/controller.do?path=address&command=DeleteAddress&json=true&id_address='+id;

	var type = 'warning';
	var method = 'delete';
	var redirect = '/PrettyStyle/controller.do?path=address&command=ListAddress';
	AlertaAvisoConfirm(title, question, url, type, method, redirect);
}

 function handleSelectDefault(input) {
	$('.jumbotron .address').removeClass('active');
	$(input).closest('#card-address').addClass('active');
}
