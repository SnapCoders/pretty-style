$(document).ready(function () {
	$('form[name="update-address"]').validate({
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
			handleUpdate(form);
		},
	});
});

function handleUpdate(form) {
	var formSerialized = $(form).serialize();
	
	$.ajax({
		type: "POST",
		url: "/PrettyStyle/controller.do?path=address&command=UpdateAddress&json=true",
		data: formSerialized,
		success: function(data){
			if (data.success) {
				AlertaSucessoRedirect(data);
			} else {
				AlertaErro(data);
			}
		},
		error: function(data){
			AlertaErro(data);
		}
	})
}

function AlertaSucessoRedirect(data) {
	swal({
		title: 'Sucesso',
		text: data.message,
		type: 'success',
		confirmButtonText: "OK",
		confirmButtonColor: "#3CB371",
		closeOnConfirm: false,
	}, function (isConfirm) {
		if (!isConfirm) return;
		window.location.href='/PrettyStyle/controller.do?path=address&command=ListAddress';
	});
};

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