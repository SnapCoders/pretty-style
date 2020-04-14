<%@ page import="br.com.sprintters.prettystyle.service.ItemService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

    <title>Pretty Style - Carrinho</title>
    
    <link rel="stylesheet" href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="../../styles/index.css">
    <link rel="stylesheet" href="../../styles/header.css">
    
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="../../styles/responsive.css">
  </head>
  <body>
  	<c:import url="../../components/header.jsp" />
		<%
		ItemService rs = new ItemService();
		request.setAttribute("lista", rs.listPlusItem(1));
		
		%>
  	<div class="container">
		<div class="cart-container">
			<div class="container">
				<div class="col-md-12 header">
					<div class="row content">
						<div class="title">
							<label>Produtos no Carrinho</label>
						</div>
						<div class="line">
							<hr />
						</div>
					</div>
				</div>
				<div class="jumbotron main">
					<div class="row">
						<div class="col-md-7 content">
						<c:forEach var="request" items="${lista}">
							<div class="row">
								<div class="col-md-12">
									<div class="product-details-area">
										<div class="product-photo-area">
											<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
										</div>
										<div class="product-info">
											<label>${request.product.name}</label>
											<span>${request.product.description}</span>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<div class="content">
												<span>Preço: </span>
												<label>R$ ${request.product.price}</label>
											</div>
											<div class="quantity">
												<span>Quantidade: </span>
												<select class="form-control">
													<option value="0">-</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-1 like">
									<div class="like-product">
										<div class="favorite">
									        <div class="favorite-icon">
									        	<img src="../../assets/icons/white-heart.svg">
								        	</div>
										</div>
									</div>
								</div>
							</div>
							<hr />
							</c:forEach>
						</div>
						<div class="col-md-5">
							<div class="jumbotron resume">
								<div class="resume-header">Resumo do Pedido</div>
								<div class="resume-body">
									<div class="resume-items">
										<div class="labels">
											<label>6 produtos</label>
											<label>Frete</label>
										</div>
										<div class="values">
											<label>R$ 1.320,00</label>
											<label>R$ 32,15</label>
										</div>
									</div>
									<hr />
									<div class="resume-total">
										<div class="labels">
											<label class="total-of-request">Total:</label>
										</div>
										<div class="values">
											<label class="total-value-of-request">R$ 1.352,15</label>
											<span class="total-installment">em até 12x sem juros</span>
											<span class="total-with-discount">R$ 1.284,55 no boleto</span>
										</div>
									</div>
									<hr />
									<div class="resume-deadline">
										<div class="labels">
											<label class="total-of-deadline">Prazo para entrega:</label>
										</div>
										<div class="values">
											<label>15 Dias</label>
											<span>úteis</span>
										</div>
									</div>
									<div class="resume-button">
										<button type="button">CONTINUAR</button>
									</div>
									<hr />
									<div class="resume-freight">
										<label class="total-of-deadline">Calcular frete e prazo:</label>
										<input class="form-control" maxlength="8" placeholder="digite o cep" />
										<button type="button">OK</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<!-- <script src="../../pages/cart/utils.js"></script> -->
	</body>
</html>
