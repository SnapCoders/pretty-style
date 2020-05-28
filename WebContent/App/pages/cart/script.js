function handleUpdateQuantity(itemId, productId, oldQuantity, input) {
	$.ajax({
		type: "POST",
		url: "/PrettyStyle/controller.do?path=paymentsteps&command=UpdateQuantity&json=true",
		data: { itemId, productId, oldQuantity, newQuantity: parseInt($(input).val()) },
		success: function (json) {
			/*let quantityTotal = 0;
			let newTotalValue = 0.0;
			
			$.each($('.product-info'), function (i, e) {
				let unitValue = parseFloat($(e).find('.unitValue').text().split(' ')[1].replace(',','.')).toFixed(2);
				let quantity = parseInt($(e).find('.quantityInput').val());
				// let bankSlip = parseFloat();
				
				quantityTotal += quantity;
				newTotalValue += unitValue * quantity;
				
				console.log('Product '+(i+1)+' value: ', unitValue, ' - Quantity: ', quantity);
			});*/
			
			/*$.each($('.quantityInput'), function (i, v) {
				quantityTotal += parseInt($(v).val());
			});
			
			$.each($('.unitValue'), function (i, v) {
				newTotalValue += parseFloat($(v).text().split(' ')[1]) * ;
			});*/
			
			/*$('#lblQuantity').text(quantityTotal+' produtos');
			$('#lblTotalValues').text('R$ '+newTotalValue.toFixed(2).replace('.', ','));*/
			window.location.href='/PrettyStyle/controller.do?path=cart&command=ListCart'
		}
	});
};
