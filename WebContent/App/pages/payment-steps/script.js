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
});

function handleSwitchPaymentMethodToCreditCard() {
	$('#bank-slip').hide();
	$('#credit-card').show();
}

function handleSwitchPaymentMethodToBankSlip() {
	$('#credit-card').hide();
	$('#bank-slip').show();
}
