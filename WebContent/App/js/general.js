$(document).ready(function () {
	let auth = sessionStorage.getItem('token');
	
	if (auth) {
		let idUser = sessionStorage.getItem('id_user');
		let userToken = sessionStorage.getItem('token');

		$('#id-user').val(idUser);

		$('a#id-user').each(function () {
			var oldUrl = $(this).attr('href');
			var newUrl = oldUrl + '&id_user=' + idUser + '&token=' + userToken;
			$(this).attr('href', newUrl);
		});

		$('div#id-user').each(function () {
			var str = $(this).attr('onclick');
			var oldUrl = str.substring(0, str.length-1);
			var newUrl = oldUrl + '&id_user=' + idUser + '&token=' + userToken + "'";
			$(this).attr('onclick', newUrl);
		});

		$('button#id-user').each(function () {
			var str = $(this).attr('onclick');
			var oldUrl = str.substring(0, str.length-1);
			var newUrl = oldUrl + '&id_user=' + idUser + '&token=' + userToken + "'";
			$(this).attr('onclick', newUrl);
		});

		$('form#id-user').each(function () {
			var oldUrl = $(this).attr('action');
			var newUrl = oldUrl + '&id_user=' + idUser + '&token=' + userToken + "";
			$(this).attr('action', newUrl);
		});
	}
});

function handleLogout() {
	swal({
		title: 'Sair ?',
		text: 'Deseja realmente sair ?',
		type: 'info',
		showCancelButton: true,
		confirmButtonText: "Sim",
		confirmButtonColor: "#3CB371",
		cancelButtonText: "N\u00e3o",
		closeOnConfirm: false,
		closeOnCancel: true
	}, function (isConfirm) {
		if (!isConfirm) return;

		let idUser = sessionStorage.getItem('id_user');
		let userToken = sessionStorage.getItem('token');

		$.ajax({
			url: '/PrettyStyle/controller.do?path=signin&command=Logout&id_user=' + idUser + '&token=' + userToken,
			method: 'POST',
			success: function (_json) {
				sessionStorage.removeItem('token');
				sessionStorage.removeItem('id_user');

				document.location.reload(true);

				console.log('passei aqui');
			},
			error: function (json) {
				AlertaErro(json);
			}
		});
	});
};

//document.addEventListener('DOMContentLoaded', function() {
//	let stars = document.querySelectorAll('.star');
//	stars.forEach(function(star) {
//		star.addEventListener('click', setRating);
//	});

//	let rating = parseInt(document.querySelector('.stars').getAttribute('data-rating'));
//	let target = stars[rating - 1];
//	target.dispatchEvent(new MouseEvent('click'));
//});

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

function navigateTo(path, command) {
	$.ajax({
		url: '/PrettyStyle/controller.do?path=' + path + '&command=' + command + '&json=false',
		type: 'POST',
		headers: {
			'id_user': 11,
		},
		success: function (data) {
			if (data.success) {
				window.location.href = data.data;
			} else {
				AlertaErro(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
		}
	});
}

function parseJwt(token) {
	var base64Url = token.split('.')[1];
	var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
	var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
		return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
	}).join(''));

	return JSON.parse(jsonPayload);
};

function setRating(ev) {
	let span = ev.currentTarget;
	let stars = document.querySelectorAll('.star');
	let match = false;
	let num = 0;
	stars.forEach(function(star, index) {
		if (match) {
			star.classList.remove('rated');
		} else {
			star.classList.add('rated');
		}
		
		if (star === span) {
			match = true;
			num = index + 1;
		}
	});
	document.querySelector('.stars').setAttribute('data-rating', num);
}

function AlertaAvisoConfirm(title, question, url, type, method) {
	swal({
		title: title,
		text: question,
		type: type,
		showCancelButton: true,
		confirmButtonText: "Sim",
		confirmButtonColor: "#3CB371",
		cancelButtonText: "N\u00e3o",
		closeOnConfirm: false,
		closeOnCancel: true
	}, function (isConfirm) {
		if (!isConfirm) return;
		$.ajax({
			url: url, type: method,
			success: function (data) {
				if (data.success) {
					swal({
						title: 'Sucesso!', text: data.message, type: "success"
					}, function () {
						//Load();
						document.location.reload(true);
					});
				} else {
					swal({
						title: "Erro", text: "Ocorreu um erro ao deletar o registro!", type: "error"
					});
				}
			},
			error: function (data) {
				swal("Erro", data.message, "error");
			}
		});
	});
}

function handleShowModal() {
	if ($('#login-modal').hasClass('inactive')) {
		$('#login-modal').removeClass('inactive');
		$('#login-modal').addClass('active');
	} else {
		$('#login-modal').removeClass('active');
		$('#login-modal').addClass('inactive');
	}
};
