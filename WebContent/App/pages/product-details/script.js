//function likeEvent(event){
//	if (event){
//		var r = document.getElementById("like");
//		console.log(r.value);
//		handleLogin(r.value);
//	}
//}


$(document).ready(function () {
	$('form[name="client-likes"]').validate({
		submitHandler: function (form) {
			handleLogin(form);
		},
	});
});

//function AlertaSucesso(data) {
//	swal({
//		title: 'Sucesso!',
//		text: data.message,
//		type: 'success',
//	});
//};
//
//function AlertaErro(data) {
//	swal({
//		title: 'Erro!',
//		text: data.message,
//		type: 'error',
//	});
//};

function handleLogin(form) {
	
	$.ajax({
		url: '/PrettyStyle/likes', type: 'POST', data: $(form).serialize(),
		success: function (data) {
			if (data.success) {
				sessionStorage.setItem('token', 'Bearer ' + data.token);
				
//				AlertaSucesso(data);
				console.log(data);
			} else {
				sessionStorage.setItem('token', null);
				
//				AlertaErro(data);
				console.log(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
			console.log(data);
		}
	});
}
	