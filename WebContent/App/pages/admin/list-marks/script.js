$(document).ready(function () {
	$('#tbMarks').DataTable({
		"language": {
			"sEmptyTable": "Nenhum registro encontrado",
			"sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
			"sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
			"sInfoFiltered": "(Filtrados de _MAX_ registros)",
			"sInfoPostFix": "",
			"sInfoThousands": ".",
			"sLengthMenu": "_MENU_ resultados por página",
			"sLoadingRecords": "Carregando...",
			"sProcessing": "Processando...",
			"sZeroRecords": "Nenhum registro encontrado",
			"sSearch": "Pesquisar",
			"oPaginate": {
				"sNext": "Próximo",
				"sPrevious": "Anterior",
				"sFirst": "Primeiro",
				"sLast": "Último"
			},
			"oAria": {
				"sSortAscending": ": Ordenar colunas de forma ascendente",
				"sSortDescending": ": Ordenar colunas de forma descendente"
			},
			"select": {
				"rows": {
				"0": "Nenhuma linha selecionada",
				"1": "Selecionado 1 linha",
				"_": "Selecionado %d linhas"
				}
			}
		}
	});
});

function handleDelete(id) {
	var id = parseInt(id);
	
	let idUser = sessionStorage.getItem('id_user');
	let userToken = sessionStorage.getItem('token');
	
	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este registro?';
	var url = '/PrettyStyle/controller.do?path=admin&command=DeleteMark&json=true&id_user=' + idUser + '&token=' + userToken + '&id=' +id;
	var type = 'warning';
	var method = 'delete';
	var redirect = '/PrettyStyle/controller.do?path=admin&command=ListMarks';

	AlertaAvisoConfirm(title, question, url, type, method, redirect);
}


$("#management-mark").on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	var category = button.data('mark');
	var categorytArray = category.split(",");
	let id = categorytArray[0];
	let name = categorytArray[1];
	
	$(".markId").text(id);
	$("#markName").text(name)
	$("#markId").val(id)
	
});

function handleUpdate(){
	$.ajax({
		type: 'POST',
		url: '/PrettyStyle/controller.do?path=admin&command=EditMark&json=true',
		data: {
			idMark: $('#markId').val(),
			name: $('#newMark').val(),
		},
		success: function (json) {
			if(json.success){
				AlertaSucesso(json);
				setTimeout(() => {
					window.location.href='/PrettyStyle/controller.do?path=admin&command=ListMarks';
				}, 2000);
			}
			else{
				AlertaErro(json);
			}
		},
		error: function (json) {
			AlertaErro(json)
		}
	})
}
