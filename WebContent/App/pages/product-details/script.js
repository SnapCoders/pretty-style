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

function handleLikeDislike(div, id) {
	let idUser = sessionStorage.getItem('id_user');
	let userToken = sessionStorage.getItem('token');

	if ($(div).hasClass('like')) {
		$.ajax({
			url: '/PrettyStyle/controller.do?path=favorites&command=CreateFavorite&json=true&id_user=' + idUser + '&token=' + userToken + '&id_product=' + id, type: 'POST',
			success: function (data) {
				if (data.success) {
					AlertaSucesso(data);
	
					setTimeout(function () {
						$(div).find('img').attr('src', '../../assets/icons/white-heart.svg');
						$(div).removeClass('like');
						$(div).removeClass('dislike');
					}, 3000);
				} else {
					AlertaErro(data);
				}
			},
			error: function (data) {
				AlertaErro(data);
			}
		});
	} else {
		$.ajax({
			url: '/PrettyStyle/controller.do?path=favorites&command=DeleteFavorite&json=true&id_user=' + idUser + '&token=' + userToken + '&id_product=' + id, type: 'POST',
			success: function (data) {
				if (data.success) {
					AlertaSucesso(data);
	
					setTimeout(function () {
						$(div).find('img').attr('src', '../../assets/icons/heart.svg');
						$(div).removeClass('like');
						$(div).removeClass('dislike');
					}, 3000);
				} else {
					AlertaErro(data);
				}
			},
			error: function (data) {
				AlertaErro(data);
			}
		});
	}
};
	