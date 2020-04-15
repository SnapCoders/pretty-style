$(document).ready(function () {
	$('form[name="update-profile"]').validate({
		rules: {
			username: 'required',
			email: {
				required: true,
				email: true,
			},
			name: 'required',
			emailConfirmation: {
				required: true,
				email: true,
			},
			surname: 'required',
			password: {
				required: true,
				minlength: 8,
				maxlength: 32,
			},
			cpf: 'required',
			birthday: 'required',
			cellphone: 'required',
			sex: 'required',
		},
		messages: {
			username: 'O campo username é obrigatório.',
			email: 'O campo e-mail é obrigatório.',
			name: 'O campo nome é obrigatório.',
			emailConfirmation: 'O campo de confirmação de e-mail é obrigatório.',
			surname: 'O campo sobrenome é obrigatório.',
			password: {
				required: 'O campo de senha é obrigatório.',
				minlength: 'O tamanho da senha deve conter no mínimo 8 caracteres.',
				maxlength: 'O tamanho da senha deve conter no máximo 32 caracteres.',
			},
			cpf: 'Informe seu CPF.',
			birthday: 'Informe sua data de nascimento.',
			cellphone: 'Informe um número de celular.',
			sex: 'Selecione o gênero',
		},
		submitHandler: function (form) {
			handleProfileEdition(form);
		},
	});
});

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

function handleProfileEdition(form) {
	$.ajax({
		url: '/PrettyStyle/users', type: 'PUT', data: $(form).serialize(),
		success: function (data) {
			if (data.success) {
				AlertaSucesso(data);
			} else {
				AlertaErro(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
		}
	});
}
