$(document).ready(function () {
	$('form[name="login"]').validate({
		rules: {
			username: 'required',
			password: 'required',
		},
		messages: {
			username: 'Informe seu username ou seu e-mail.',
			password: 'Digite sua senha de acesso.',
		},
		submitHandler: function (form) {
			handleLogin(form);
		},
	});
});

// function handleCreate() {
// 	$.ajax({
// 		url: '/PrettyStyle/products', type: 'GET',
// 		success: function (data) {
// 			console.log('Deu certo');
// 		},
// 		error: function (data) {
// 			console.log('Deu bosta');
// 		}
// 	});
// }

function handleLogin(form) {
	$.ajax({
		url: '/PrettyStyle/sessions', type: 'POST', data: $(form).serialize(),
		success: function (data) {
			if (data.success) {
				sessionStorage.setItem('token', 'Bearer ' + data.token);
				
				AlertaSucesso(data);
			} else {
				sessionStorage.setItem('token', null);
				
				AlertaErro(data);
			}
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
};

function AlertaErro(data) {
	swal({
		title: 'Erro!',
		text: data.message,
		type: 'error',
	});
};
