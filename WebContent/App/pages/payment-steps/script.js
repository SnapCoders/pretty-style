$(document).ready(function () {
	$('#number-credit-card').mask('0000 0000 0000 0000');
	$('#mounth-shelf-life-credit-card').mask('00');
	$('#year-shelf-life-credit-card').mask('00');
	$('#cvv-credit-card').mask('000');

	$("select#number-parcels").change(function() {
		var selectedParcel = $(this).children("option:selected").val();

		var formatter = new Intl.NumberFormat('pt-BR', {
			style: 'currency',
			currency: 'BRL',
		});
		
		if (selectedParcel == 1) {
			$('#total-price').text('Total: ' + formatter.format($('#total-price-with-discount').val()));
		} else {
			$('#total-price').text('Total: ' + formatter.format($('#total-price-without-discount').val()));
		}
	});
	
	$('div#content hr:last-child').remove();
	
	/* $.validator.addMethod("valueNotEquals", (value, element, arg) => arg !== value);
	   
	$('form[name="add-request-by-credit-card"]').validate({
		rules: {
			cardNumber: 'required',
			cardName: 'required',
			validateMonth: 'required',
			cardParcels: {
				valueNotEquals: '0',
			},
			validateYear: 'required',
			cardCvv: 'required',
		},
		messages: {
			cardNumber: 'O campo numero de cartão é obrigatório',
			cardName: 'O campo nome do titular é obrigatório',
			validateMonth: 'Campo obrigatório',
			cardParcels: {
				valueNotEquals: 'Selecione o nº de parcelas',
			},
			validateYear: 'Campo obrigatório',
			cardCvv: 'Informe o CVV',
		},
		submitHandler: function (form) {
			handleAdd(form);
		},
	}); */
});

$("#update-address").on('show.bs.modal', function(event) {
	let button = $(event.relatedTarget);
	$('#addressUpdate').val($('#addressOlder').val());
	
	$.ajax({
		url: '/PrettyStyle/controller.do?path=address&command=ListAddress&json=true', 
		type: 'GET',
		success: function (data) {
			if (data.success) {
				let tableHtml = '';
				
				$.each(data.data[0].addresses, function (index, value) {
					tableHtml += '<tr>';
					
					if (value.id == $('#addressUpdate').val())
						tableHtml += ` <td><input type="radio" name="addressId" value="${value.id}" checked ></td>`;
					else
						tableHtml += ` <td><input type="radio" name="addressId" value="${value.id}" ></td>`;
					tableHtml += ` <td>${value.recipient}</td>`;
					tableHtml += ` <td>${value.place}, ${value.number} - ${value.neighborhood} / ${value.city}</td>`;
					tableHtml += '<td>';
					tableHtml += ` ${value.zip}`;
					tableHtml += ` <input id="recipientHidden" type="hidden" value="${value.recipient}">`;
					tableHtml += ` <input id="addressHidden" type="hidden" value="${value.place}, ${value.number}"`;
					tableHtml += ` <input id="neighborhoodHidden" type="hidden" value="${value.neighborhood}">`;
					tableHtml += ` <input id="cityHidden" type="hidden" value="${value.city}">`;
					tableHtml += ` <input id="complementHidden" type="hidden" value="${value.complement}">`;
					tableHtml += ` <input id="zipHidden" type="hidden" value="${value.zip}">`;
					tableHtml += '</td>';
					
					tableHtml += '</tr>';
				});
				
				$('#modal-addresses-content').html(tableHtml);
			} else {
				AlertaErro(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
		}
	});
});

function handleUpdateDefaultAddress() {
	$.ajax({
		url: '/PrettyStyle/controller.do?path=address&command=UpdateDefaultAddress&json=true', 
		type: 'POST', 
		data: { addressId: $('input[name="addressId"]:checked').val() },
		success: function (data) {
			if (data.success) {
				AlertaSucesso(data);
				
				let tr = $('input[name="addressId"]:checked').closest('tr');
				
				$('#addressOlder').val($('input[name="addressId"]:checked').val());
				$('#addressUpdate').val($('input[name="addressId"]:checked').val());
				
				$('#addressRecipient').text($(tr).find('#recipientHidden').val());
				$('#addressPlace').text($(tr).find('#addressHidden').val());
				$('#addressNeighborhood').text($(tr).find('#neighborhoodHidden').val());
				$('#addressCity').text($(tr).find('#cityHidden').val());
				$('#addressComplement').text($(tr).find('#complementHidden').val());
				$('#addressZip').text($(tr).find('#zipHidden').val());
				
			} else {
				AlertaErro(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
		}
	});
}

function handleSwitchPaymentMethodToCreditCard() {
	$('#bank-slip').hide();
	$('#credit-card').show();
}

function handleSwitchPaymentMethodToBankSlip() {
	$('#credit-card').hide();
	$('#bank-slip').show();
}

function handleAdd(form) {
	$.ajax({
		url: '/PrettyStyle/requests', 
		type: 'POST', 
		data: $(form).serialize(),
		success: function (data) {
			if (data.success) {
				console.log("Conseguiu");
			} else {
				AlertaErro(data);
			}
		},
		error: function (data) {
			AlertaErro(data);
		}
	});
}

function AlertaErro(data) {
	swal({
		title: 'Erro!',
		text: data.message,
		type: 'error',
	});
};
