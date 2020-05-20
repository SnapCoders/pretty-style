<%@page import="br.com.sprintters.prettystyle.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="referrer" content="strict-origin" />
		
		<link rel="shortcut icon" href="/PrettyStyle/favicon.ico" type="image/x-icon" />

		<title>Pretty Style - Gerenciar Marcas</title>
    
		<link rel="stylesheet" href="../../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../../lib/datatables/datatables.min.css">
		<link rel="stylesheet" href="../../../lib/sweetalert/sweetalert.css">
		<link rel="stylesheet" href="../../../assets/fonts/css/all.css">
		<link rel="stylesheet" href="../../../assets/fonts/css/fontawesome.min.css">

		<link rel="stylesheet" href="../../../styles/index.css">
		<link rel="stylesheet" href="../../../styles/header.css">
		<link rel="stylesheet" href="../../../styles/footer.css">
		<link rel="stylesheet" href="../../../styles/responsive.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../../components/header.jsp" />
		<div id="main-content" class="container">
			<div class="list-marks-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Gerenciamento</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  				<a class="btn btn-sm btn-primary" href="/PrettyStyle/controller.do?path=admin&command=NavigateToNewMark">Cadastrar</a>
				  				<a class="btn btn-sm btn-outline-primary" href="/PrettyStyle/controller.do?path=admin&command=NavigateToAdmin">Voltar</a>
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
							<table id="tbMarks" class="table table-bordered table-hover">
								<thead class="thead-dark">
									<tr>
										<th scope="col" style="text-align: center; min-width: 15px;" class="details-control">Id</th>
										<th scope="col" style="text-align: center; min-width: 605px;">Nome</th>
										<th scope="col" style="text-align: center; min-width: 100px;">Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="mark" items="${marks}">
										<tr>
											<th id="product-id" scope="row" class="details-control">${mark.id}</th>
											<td>${mark.name}<!-- <span class="badge badge-pill badge-primary" style="margin-left: 10px;">50% OFF</span> --></td>
											<td style="text-align: center;">
												<button class="btn btn-sm btn-outline-primary" type="button" data-toggle="modal" data-target="#management-mark" data-mark="${mark}">
													<i class="far fa-edit"></i>
												</button>
												<button id="btn-remove" type="button" class="btn btn-sm btn-outline-danger" onclick="handleDelete(${mark.id});">
													<i class="fas fa-trash"></i>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
			  			</div>
			  		</div>
			  	</div>
			</div>
		</div>
		
		<div class="modal fade" id="management-mark" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="modalLabel">Gerenciar Marca</h4>
						<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class= col-md-12>
								<div class="form-group">
									<strong>ID:</strong>
									<label class="markId"></label>
								</div>
								<div class="form-group">
									<strong>Nome antigo:</strong>
									<label id="markName"></label>
								</div>							
							</div>
						</div>
					
					</div>
					<div class="modal-footer">
						<div style="display: flex; justify-content: space-between; align-items: center;width: 100%">
							<div style="display: flex; align-itens: center;">
								<strong>Novo nome:</strong>
								<input id="newMark" style="padding: 5px; height: 30px; width: 150px; margin-left: 5px; background-color: white; border-radius: 6px; border: 1px solid #6c757d75;">
								<input type="hidden" id="markId">
								</div>
							<div>
								<button type="button" onclick="handleUpdate();" class="btn btn-primary">Salvar</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<c:import url="../../../components/footer.jsp" />
		
		<script src="../../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../../lib/datatables/datatables.min.js"></script>
		<script src="../../../lib/sweetalert/sweetalert.min.js"></script>
		
		<script src="script.js"></script>
	</body>
</html>