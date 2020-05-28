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

 function handleSelectDefault(input, id) {
	$('.jumbotron .address').removeClass('active');
	$(input).closest('#card-address').addClass('active');
	
	handleUpdateDefaultAddress(id);
}

 function handleUpdateDefaultAddress(id) {
	$.ajax({
		url: '/PrettyStyle/controller.do?path=address&command=UpdateDefaultAddress&json=true', 
		type: 'POST', 
		data: { addressId: id },
		success: function (data) {
			if (data.success) {
				//AlertaSucesso(data);
			} else {
				AlertaErro(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
		}
	});
}
 