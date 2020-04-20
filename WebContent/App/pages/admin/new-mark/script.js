$(document).ready(function () {
	$('form[name="add-mark"]').validate({
		rules: {
			name: 'required',
		},
		messages: {
			name: 'Campo obrigatório.',
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
    	type: 'POST', url: '/PrettyStyle/controller.do?path=admin&command=CreateMark&json=true&id_user=' + idUser + '&token=' + userToken, data: formSerialized,
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
