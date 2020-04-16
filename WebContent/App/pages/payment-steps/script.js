$(document).ready(function () {
	$('#number-credit-card').mask('0000 0000 0000 0000');

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
	
	$('#mounth-shelf-life-credit-card').mask('00');
	$('#year-shelf-life-credit-card').mask('00');
	$('#cvv-credit-card').mask('000');
	
	$.validator.addMethod("valueNotEquals", (value, element, arg) => arg !== value);
	   
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
	});
});






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