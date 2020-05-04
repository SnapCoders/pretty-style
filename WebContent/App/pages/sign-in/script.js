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
			//form.submit();
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
		url: '/PrettyStyle/controller.do?path=signin&command=Login&json=true', type: 'POST', data: $(form).serialize(),
		success: function (data) {
			if (data.success) {
				AlertaSucesso(data);

				setTimeout(function () { window.location.reload(true); }, 2000);
			} else {
				AlertaErro(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
		}
	});
};
