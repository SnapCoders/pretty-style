function handleDeleteFavorite(id) {
	let idUser = sessionStorage.getItem('id_user');
	let userToken = sessionStorage.getItem('token');

	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este registro?';
	var url = '/PrettyStyle/controller.do?path=favorites&command=DeleteFavorite&json=true&id_favorite&id_cpl=' + id + '&id_user=' + idUser + '&token=' + userToken;
	var type = 'warning';
	var method = 'delete';

	AlertaAvisoConfirm(title, question, url, type, method);
}
