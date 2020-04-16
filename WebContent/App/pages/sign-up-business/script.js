$(document).ready(function () {
	$('#cnpj').mask('00.000.000/0000-00', {reverse: true});
	$('#telephone').mask('(00) 0000-0000');
	$('#cellphone').mask('(00) 0 0000-0000');

	$('form[name="add-user-business"]').validate({
		rules: {
			username: 'required',
			email: {
				required: true,
				email: true,
			},
			fantasyName: 'required',
			emailConfirmation: {
				required: true,
				email: true,
			},
			socialReason: 'required',
			password: {
				required: true,
				minlength: 8,
				maxlength: 32,
			},
			cnpj: 'required',
			contact: {
				required: true,
				email: true,
			},
			cellphone: 'required',
		},
		messages: {
			username: 'O campo username é obrigatório.',
			email: 'O campo e-mail é obrigatório.',
			fantasyName: 'O campo nome fantasia é obrigatório.',
			emailConfirmation: 'O campo de confirmação de e-mail é obrigatório.',
			socialReason: 'O campo razão social é obrigatório.',
			password: {
				required: 'O campo de senha é obrigatório.',
				minlength: 'O tamanho da senha deve conter no mínimo 8 caracteres.',
				maxlength: 'O tamanho da senha deve conter no máximo 32 caracteres.',
			},
			cnpj: 'Informe seu CNPJ.',
			contact: 'Informe seu e-mail principal para contato.',
			cellphone: 'Informe um número de celular.',
		},
		submitHandler: function (form) {
			handleAdd(form);
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

function handleAdd(form) {
	$.ajax({
		url: '/PrettyStyle/users', type: 'POST', data: $(form).serialize(),
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
