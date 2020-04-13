$(document).ready(function () {
	$.validator.addMethod("valueNotEquals", (value, element, arg) => arg !== value);
	
	$('form[name="add-product"]').validate({
		rules: {
			name: 'required',
			description: 'required',
			idMark: {
				valueNotEquals: '0',
			},
			price: 'required',
		},
		messages: {
			name: 'Campo obrigatório.',
			description: 'Campo obrigatório.',
			idMark: {
				valueNotEquals: 'Selecione uma marca',
			},
			price: 'Campo obrigatório.',
		},
		submitHandler: function (form) {
			//form.submit();
			handleAdd(form);
		},
	});
});

function handleAdd(form) {
	var formSerialized = $(form).serialize();

	$.ajax({
    	type: 'POST', url: '/PrettyStyle/products', data: formSerialized,
    	success: function(data) {
        	AlertaSucesso(data);
		},
		error: function (data) {
			AlertaErro(data);
		}
    });
};

function AlertaSucesso() {
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
