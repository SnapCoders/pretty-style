function handleDelete(id) {
	var id = parseInt(id);
	var id_user = sessionStorage.getItem("id_user");
	
	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este endereço?';
	var url = '/PrettyStyle/controller.do?path=address&command=DeleteAddress&json=true&id_user='+id_user+'&id_address='+id;
	///PrettyStyle/addresses?
	var type = 'warning';
	var method = 'delete';
	AlertaAvisoConfirm(title, question, url, type, method);
}

 function handleSelectDefault(input) {
	$('.jumbotron .address').removeClass('active');
	$(input).closest('#card-address').addClass('active');
}
