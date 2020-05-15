window.onscroll = function () {
	if (window.pageYOffset > 108) {
		$('#bottom-header').addClass('sticky');
		$('#main-content').addClass('sticky-content');
	} else {
		$('#bottom-header').removeClass('sticky');
		$('#main-content').removeClass('sticky-content');
	}
};

var slideIndex = 1;

function productPhotoSlides(n) {
  showSlides(slideIndex += n);
};

function currentProductPhotoSlide(n) {
  showSlides(slideIndex = n);
};

function showSlides(n) {
	var i;
	var slides = document.getElementsByClassName("productSlides");
	var dots = document.getElementsByClassName("dot");
	
	if (n > slides.length) {
		slideIndex = 1
	}
	
	if (n < 1) {
		slideIndex = slides.length
	}
	
	for (i = 0; i < slides.length; i++) {
	    slides[i].style.display = "none";
	}
	
	for (i = 0; i < dots.length; i++) {
	    dots[i].className = dots[i].className.replace(" active", "");
	}
	
	slides[slideIndex-1].style.display = "block";
	dots[slideIndex-1].className += " active";
};

function handleDeleteImg(id){
	let idSelecteds = $('#idPhotosDelete').val().split(',');
	if(idSelecteds[0] == "") idSelecteds = [];
	if(!idSelecteds.includes(id.toString())) idSelecteds.push(id);			
	$('#idPhotosDelete').val(idSelecteds);
};

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
		$.ajax({
			url: '/PrettyStyle/controller.do?path=signin&command=Logout',
			method: 'POST',
			success: function (_json) {
				sessionStorage.removeItem('token');
				sessionStorage.removeItem('id_user');

				window.location.href='/PrettyStyle/index.jsp';
			},
			error: function (json) {
				AlertaErro(json);
			}
		});
	});
};

function handleSelectMenu(element) {
	window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByCategory&filter='+$(element).text();
	
	$.each($('#bottom-header').find('ul').find('li'), (i, e) => $(e).removeClass('active'));
	
	$('#bottom-header').find('ul').find('li:contains('+$(element).text()+')').addClass('active');
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

function AlertaAviso(data) {
	swal({
		title: 'Atenção!',
		text: data.message,
		type: 'info',
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
};

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
};

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
};

function handleShowModal() {
	$('#login-modal').removeClass('inactive');
	$('#login-modal').addClass('active');
};

function handleHideModalTimeOut() {
	setTimeout(function () {
		if (!$('#login-modal').hasClass('focus') && $('#login-modal').hasClass('active')) {
			setTimeout(function () {
				$('#login-modal').addClass('inactive');
				$('#login-modal').removeClass('active');
			}, 800);
		}
	}, 1200);
};

function handleFocusModal() {
	$('#login-modal').addClass('focus');
};

function handleHideModal() {
	$('#login-modal').removeClass('focus');
	$('#login-modal').removeClass('active');
	$('#login-modal').addClass('inactive');
};

function handleSearchProduct() {
	window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByProductName&search='+$('#searchId').val();
};
