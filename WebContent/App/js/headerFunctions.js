function handleListCart() {
	let idUser = sessionStorage.getItem('id_user');
	
	$.ajax({
		url: '/PrettyStyle/controller.do?path=cart&command=ListCart',
		headers: {
			'id_user': idUser
		},
		method: 'GET',
		success: function (json) {
			console.log(json);
		},
		error: function (json) {
			console.log(json);
		}
	});
}
