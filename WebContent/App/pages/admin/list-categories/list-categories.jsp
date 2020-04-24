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

		<title>Pretty Style - Gerenciar Categorias</title>
    
		<link rel="stylesheet" href="/PrettyStyle/App/lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="/PrettyStyle/App/lib/datatables/datatables.min.css">
		<link rel="stylesheet" href="/PrettyStyle/App/lib/sweetalert/sweetalert.css">
		<link rel="stylesheet" href="/PrettyStyle/App/assets/fonts/css/all.css">
		<link rel="stylesheet" href="/PrettyStyle/App/assets/fonts/css/fontawesome.min.css">

		<link rel="stylesheet" href="/PrettyStyle/App/styles/index.css">
		<link rel="stylesheet" href="/PrettyStyle/App/styles/header.css">
    
		<link rel="stylesheet" href="/PrettyStyle/App/pages/admin/list-categories/styles.css">
	</head>
	<body>
		<c:import url="../../../components/header.jsp" />
		<div class="container">
			<div class="list-categories-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Gerenciamento</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  				<a class="btn btn-sm btn-primary" href="../new-category/new-category.jsp">Cadastrar</a>
				  				<a class="btn btn-sm btn-outline-primary" href="../admin.jsp">Voltar</a>
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
							<table id="tbCategories" class="table table-bordered table-hover">
								<thead class="thead-dark">
									<tr>
										<th scope="col" style="text-align: center; min-width: 15px;" class="details-control">Id</th>
										<th scope="col" style="text-align: center; min-width: 205px;">Nome</th>
										<th scope="col" style="text-align: center; min-width: 360px;">Cor</th>
										<th scope="col" style="text-align: center; min-width: 100px;">Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="category" items="${categories}">
										<tr>
											<th id="product-id" scope="row" class="details-control">${category.id}</th>
											<td>${category.name}<!-- <span class="badge badge-pill badge-primary" style="margin-left: 10px;">50% OFF</span> --></td>
											<td>${category.color}</td>
											<td style="text-align: center;">
												<button class="btn btn-sm btn-outline-success">
													<i class="far fa-eye"></i>
												</button>
												<button class="btn btn-sm btn-outline-primary">
													<i class="far fa-edit"></i>
												</button>
												<button id="btn-remove" type="button" class="btn btn-sm btn-outline-danger" onclick="handleDelete(${category.id});">
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
		
		<script src="/PrettyStyle/App/lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="/PrettyStyle/App/lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="/PrettyStyle/App/lib/datatables/datatables.min.js"></script>
		<script src="/PrettyStyle/App/lib/sweetalert/sweetalert.min.js"></script>
		
		<script src="/PrettyStyle/App/pages/admin/list-categories/script.js"></script>
	</body>
</html>