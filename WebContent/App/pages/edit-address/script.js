$(document).ready(function () {
	$('form[name="add-address"]').validate({
		rules: {
			name: 'required',
			zip: 'required',
			place: 'required',
			number: 'required',
			neighborhood: 'required',
			city: 'required',
			state: 'required',
			country: 'required',
		},
		messages: {
			name: 'Campo obrigatório.',
			zip: 'Campo obrigatório.',
			place: 'Campo obrigatório.',
			number: 'Campo obrigatório.',
			neighborhood: 'Campo obrigatório.',
			city: 'Campo obrigatório.',
			state: 'Campo obrigatório.',
			country: 'Campo obrigatório.',
		},
		submitHandler: function (form) {
			// form.submit();
			handleAdd(form);
		},
	});
});

function handleAdd(form) {
	var formSerialized = $(form).serialize();
	let idUser = sessionStorage.getItem('id_user');
	console.log(formSerialized);
	$.ajax({
		type: "POST",
		url: "/PrettyStyle/controller.do?path=address&command=UpdateAddress&json=true&id_user="+idUser,
		data: formSerialized,
		success: function(data){
			AlertaSucesso(data);	
		},
		error: function(data){
			AlertaErro(data);
		}
	})
}

// QUANDO TIVER VALIDAÇÃO DE UM SELECT COM OPTIONS
// $.validator.addMethod("valueNotEquals", (value, element, arg) => arg !== value);

function AlertaSucesso(data){
	swal({
		title: "Sucesso!",
		text: data.message,
		type: "success",	
	});
}

function AlertaErro(data){
	swal({
		title: "Erro!",
		text: data.message,
		type: "error",	
	});
}