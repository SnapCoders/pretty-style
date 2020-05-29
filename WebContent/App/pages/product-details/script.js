document.addEventListener('DOMContentLoaded', function() {
	let stars = document.querySelectorAll('.star');
	stars.forEach(function(star) {
		star.addEventListener('click', setRating);
	});
	let rating = parseInt(document.querySelector('.stars').getAttribute('data-rating'));
	let target = stars[rating - 1];
	target.dispatchEvent(new MouseEvent('click'));
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

function handleLikeDislike(div, id) {
	if ($(div).hasClass('like')) {
		
		$.ajax({
			url: '/PrettyStyle/controller.do?path=favorites&command=CreateFavorite&json=true'+'&id_product=' + id, type: 'POST',
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
			url: '/PrettyStyle/controller.do?path=favorites&command=DeleteFavorite&json=true&id_product=' + id, type: 'POST',
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
	