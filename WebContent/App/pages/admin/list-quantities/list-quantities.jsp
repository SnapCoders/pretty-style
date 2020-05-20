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
			<div class="list-quantities-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Gerenciamento</label>
				  			</div>
				  			<div class="line">
				  				<hr />
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
										<th scope="col" style="text-align: center; min-width: 345px;">Nome</th>
										<th scope="col" style="text-align: center; min-width: 20px;">Quantidade</th>
										<th scope="col" style="text-align: center; min-width: 30px;">Valor total</th>
										<th scope="col" style="text-align: center; min-width: 80px;">Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${products}">
										<tr>
											<th id="product-id" scope="row" class="details-control">
												${product.id}
												<input id="productIdHidden" type="hidden" value="${product.id}"/>
												<input id="productNameHidden" type="hidden" value="${product.name}"/>
												<input id="productQuantityHidden" type="hidden" value="${product.stock.quantity}"/>
											</th>
											<td>${product.name}<!-- <span class="badge badge-pill badge-primary" style="margin-left: 10px;">50% OFF</span> --></td>
											<td style=" text-align: center">${product.stock.quantity}</td>
											<td style=" text-align: center"><fmt:formatNumber value="${product.stock.quantity * product.price}" type="currency" currencySymbol="R$"/></td>
											<td style="text-align: center; display: flex; align-items: center; justify-content: space-around;">
												<button class="btn btn-sm btn-outline-primary" type="button" data-toggle="modal" data-target="#management-quantity" data-product="${product}">Gerenciar</button>	
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
		
		<div class="modal fade" id="management-quantity" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="modalLabel">Gerenciar Lançamento</h4>
						<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class= col-md-12>
								<div class="form-group">
									<strong>ID:</strong>
									<label id="productId"></label>
								</div>
								<div class="form-group">
									<strong>Nome:</strong>
									<label id="productName"></label>
								</div>
								<div class="form-group">
									<strong>Quantidade Atual:</strong>
									<label id="productQuantity"></label>
								</div>
								<div class="form-group">
									<strong>Nova Quantidade Total:</strong>
									<label id="productQuantityTotal"></label>
								</div>
								
							</div>
						</div>
					
					</div>
					<div class="modal-footer">
						<form action="/PrettyStyle/controller.do?path=admin&command=LaunchNewQuantity&json=true" name="update-quantity" method="post" style="width: 100%">
						<div style="display: flex; justify-content: space-between; align-items: center;">
							<div style="display: flex; align-itens: center;">
								<strong>Quantidade Nova:</strong>
								<input class="form-control" id="newQuantity" name="newQuantity" style="padding: 5px; height: 28px; width: 50px; margin-left: 5px;">
							</div>
							<div>
								<input type="hidden" name="idProduct" id="idProduct" value="" />
								<input type="hidden" name="oldQuantity" id="oldQuantity" value="" />
								<button type="submit" class="btn btn-primary">Salvar</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<c:import url="../../../components/footer.jsp" />
		
		<script src="../../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../../lib/jquery-validation/jquery.validate.min.js"></script>
		<script src="../../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../../lib/datatables/datatables.min.js"></script>
		<script src="../../../lib/sweetalert/sweetalert.min.js"></script>
		
		
		<script src="script.js"></script>
	</body>
</html>