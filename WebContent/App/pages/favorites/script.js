function handleDeleteFavorite(id, idProduct) {

	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este registro?';
	var url = '/PrettyStyle/controller.do?path=favorites&command=DeleteFavorite&json=true&id_favorite&id_cpl=' + id +'&id_product='+idProduct;
	var type = 'warning';
	var method = 'delete';

	AlertaAvisoConfirm(title, question, url, type, method);
}
