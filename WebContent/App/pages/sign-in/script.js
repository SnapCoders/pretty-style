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

function handleLogin(form) {
	$.ajax({
		url: '/PrettyStyle/sessions', type: 'POST', data: $(form).serialize(),
		success: function (data) {
			if (data.success) {
				console.log(parseJwt(data.token));
				sessionStorage.setItem('id_user', parseInt(parseJwt(data.token).jti));
				sessionStorage.setItem('token', 'Bearer ' + data.token);
				
				AlertaSucesso(data);
			} else {
				sessionStorage.setItem('id_user', null);
				sessionStorage.setItem('token', null);
				
				AlertaErro(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
		}
	});
};
