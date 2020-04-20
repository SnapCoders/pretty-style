$(document).ready(function () {
	$('form[name="add-category"]').validate({
		rules: {
			name: 'required',
			color: 'required',
		},
		messages: {
			name: 'Campo obrigatório.',
			color: 'Campo obrigatório.',
		},
		submitHandler: function (form) {
			handleAdd(form);
		},
	});
});

function handleAdd(form) {
	var formSerialized = $(form).serialize();

	let idUser = sessionStorage.getItem('id_user');
	let userToken = sessionStorage.getItem('token');

	$.ajax({
    	type: 'POST', url: '/PrettyStyle/controller.do?path=admin&command=CreateCategory&json=true&id_user=' + idUser + '&token=' + userToken, data: formSerialized,
    	success: function(data) {
        	AlertaSucesso(data);
		},
		error: function (data) {
			AlertaErro(data);
		}
    });
};

function AlertaSucesso(data) {
	swal({
		title: 'Sucesso!',
		text: data.message,
		type: 'success',
	});
}

function AlertaErro(data) {
	swal({
		title: 'Erro!',
		text: data.message,
		type: 'error',
	});
}
