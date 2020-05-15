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

		<title>Pretty Style - Gerenciar Produtos</title>
    
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
			<div class="list-products-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Gerenciamento</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  				<a class="btn btn-sm btn-primary" href="/PrettyStyle/controller.do?path=admin&command=NavigateToNewProduct">Cadastrar</a>
				  				<a class="btn btn-sm btn-outline-primary" href="/PrettyStyle/controller.do?path=admin&command=NavigateToAdmin">Voltar</a>
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
							<table id="tbProducts" class="table table-bordered table-hover">
								<thead class="thead-dark">
									<tr>
										<th scope="col" style="text-align: center; min-width: 15px;" class="details-control">Id</th>
										<th scope="col" style="text-align: center; min-width: 350px;">Nome</th>
										<th scope="col" style="text-align: center; max-width: 10px;">Preço</th>
										<th scope="col" style="text-align: center; max-width: 60px;">Quantidade</th>
										<th scope="col" style="text-align: center; min-width: 10px; max-width: 20px;">Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${products}">
										<tr>
											<td id="product-id" scope="row" class="details-control">
												${product.id}
												<input id="product-id-hidden-${product.id}" type="hidden" value="${product.id}">
												<input id="product-name-hidden-${product.id}" type="hidden" value="${product.name}">
												<input id="product-description-hidden-${product.id}" type="hidden" value="${product.description}">
												<input id="product-price-hidden-${product.id}" type="hidden" value="${product.price}">
												<input id="product-quantity-hidden-${product.id}" type="hidden" value="${product.stock.quantity}">
												<c:forEach var="photo" items="${product.photos}">
													<input class="product-photo-hidden-${product.id}" type="hidden" value="${photo.url}">
												</c:forEach>
											</td>
											<td>${product.name}<!-- <span class="badge badge-pill badge-primary" style="margin-left: 10px;">50% OFF</span> --></td>
											<td><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/></td>
											<td style=" text-align: center">${product.stock.quantity}</td>
											<td style="text-align: center; display: flex; align-items: center; justify-content: space-around;">
												<button class="btn btn-sm btn-outline-success" data-toggle="modal" data-target="#view-product" data-product="${product.id}">
													<i class="far fa-eye"></i>
												</button>
												<button id="btn-edit" type="submit" class="btn btn-sm btn-outline-primary">
													<i class="far fa-edit" onclick="window.location.href='/PrettyStyle/controller.do?path=admin&command=EditProduct&id_product=${product.id}'"></i>
												</button>
												<button id="btn-remove" type="button" class="btn btn-sm btn-outline-danger" onclick="handleDelete(${product.id});">
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
		<div class="modal fade" id="view-product" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="modalLabel">Produto: <label class="lblProductName"></label></h4>
						<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class= col-md-6>
								<div class="form-group">
									<strong>Id:</strong>
									<label id="lblProductId"></label>
								</div>
								<div class="form-group">
									<strong>Nome:</strong>
									<label class="lblProductName"></label>
								</div>
								<div class="form-group">
									<strong>Descrição:</strong>
									<p id="lblProductDescription" style="white-space: break-spaces;"></p>
								</div>
								<div class="form-group">
									<strong>Preço:</strong>
									<label id="lblProductPrice"></label>
								</div>
								<div class="form-group">
									<strong>Quantidade Atual:</strong>
									<label id="lblProductQuantity"></label>
								</div>
							</div>
							<div class="col-md-6">
								<div id="dProductPhotos" class="product-photos-slideshow-container"></div>
								<div id="dProductPhotosDots" style="text-align:center"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div style="display: flex; justify-content: space-between; align-items: center;">
							<div>
								<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
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