function handleShowItems(e) {
	let items = $(e).closest('.request-grid').find('.o-items');
	
	if (items.hasClass('active')) {
		$(items).removeClass('active');
		$(e).text('Mostrar itens');
	} else {
		$(items).addClass('active');
		$(e).text('Esconder itens');
	}
};
