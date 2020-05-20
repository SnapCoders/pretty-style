$(document).ready(function () {
	$('#tbProducts').DataTable({
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
	
	$('form[name="update-quantity"]').validate({
		rules: {
			quantity: 'required',
			
		},
		messages: {
			quantity: 'Campo obrigatório.',
		},
		submitHandler: function (form) {
			handleUpdate(form);
		},
	});
});

$("#management-quantity").on('show.bs.modal', function(event) {
	$("#newQuantity").val("");
	$("#productQuantityTotal").text("");
	
	$("#productId").text($('#productIdHidden').val());
	$("#productName").text($('#productNameHidden').val());
	$("#productQuantity").text($('#productQuantityHidden').val());
	
	$("#idProduct").val($('#productIdHidden').val());
	$("#oldQuantity").val($('#productQuantityHidden').val());
	
	$("#newQuantity").on("keyup",function (){
		if($(this).val() != ""){
			let totalQuantity = parseInt($('#productQuantityHidden').val()) + parseInt($(this).val());			
			$("#productQuantityTotal").text(totalQuantity);		
		}
		else{
			$("#productQuantityTotal").text("");	
		}
	});
});

function handleDelete(id) {
	var id = parseInt(id);

	let idUser = sessionStorage.getItem('id_user');
	let userToken = sessionStorage.getItem('token');
	
	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este registro?';
	var url = '/PrettyStyle/controller.do?path=admin&command=DeleteProduct&json=true&id_user=' + idUser + '&token=' + userToken + '&id=' +id;
	var type = 'warning';
	var method = 'delete';

	AlertaAvisoConfirm(title, question, url, type, method);
};

function handleUpdate(form) {
	var formSerialized = $(form).serialize();
	$.ajax({
		type: "POST",
		url: $(form).attr("action"),
		data: formSerialized,
		success: function(data){
			if(data.success){
				let inputs = [];
				inputs.push($("#newQuantity"));
				inputs.push($("#productQuantityTotal"));
				$("#productQuantity").text($("#productQuantityTotal").text());
				AlertaSucessoReset(data, inputs);
			}
			else{
				AlertaErro(data);
			}
		},
		error: function(data){
			AlertaErro(data);
		}
	})
};

function AlertaSucessoReset(data, values) {
	swal({
		title: 'Sucesso!',
		text: data.message,
		type: 'success',
	}, function (){
		for (let value of values){
			$(value).val("");
			$(value).text("");
		}	
	});
};
