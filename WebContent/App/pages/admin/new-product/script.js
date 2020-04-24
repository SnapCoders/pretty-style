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

	$('#photo').on('change', function () {
		const element = 
			'<div id="imagePreview" class="image-preview">'+
				'<input name="index" type="hidden" value="" />' +
				//'<i class="fas fa-times remove-image"></i>' +
				'<img class="image-preview__image" src="" alt="Preview">' +
				'<span class="image-preview__default-text">Preview</span>' +
			'</div>';

		const fileList = $(this)[0].files;

		if (fileList.length > 0) {
			for (i = 0; i < fileList.length; i++) {
				const file = $(this)[0].files[i];
				let imagePreview = $(element).clone();

				$(imagePreview).find('input[name="index"]').val(i);
		
				if (file) {
					const reader = new FileReader();
					
					$(reader).on('load', function () {
						$(imagePreview).find('.image-preview__image').attr('src', this.result);
						$('.previews').append(imagePreview);
					});
		
					reader.readAsDataURL(file);
				}
			}

			setTimeout(function () {
				$('.image-preview__default-text').hide();
				$('.image-preview__image').show();

				// $('.remove-image').on('click', function () {
				// 	let index = $(this).closest('#imagePreview').find('input[name="index"]').val();
				// 	$(this).closest('#imagePreview').remove();
				// 	console.log($('#photo')[0].files);
				// });
			}, 1000);
		} else {
			$('.previews').children().remove();

			$('.previews').append(defaultPreview);
		}
	});
});

function handleAdd(form) {
	let idUser = sessionStorage.getItem('id_user');
	let userToken = sessionStorage.getItem('token');
	let data = new FormData(form);

	$.each($('input[name="photo"]')[0].files, function(i, file) {
		data.append('file-'+i, file);
	});

	$.ajax({
		type: 'POST',
		url: '/PrettyStyle/controller.do?path=admin&command=CreateProduct&json=true&id_user=' + idUser + '&token=' + userToken,
		data: data,
		contentType: false,
		processData: false,
		cache: false,
    	success: function(data) {
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
};

function AlertaSucesso(data) {
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
