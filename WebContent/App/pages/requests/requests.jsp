<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
		
		<title>Pretty Style - Meus Pedidos</title>
		
		<link rel="stylesheet" href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../lib/sweetalert/sweetalert.css">
		<link rel="stylesheet" href="../../assets/fonts/css/all.css">
		<link rel="stylesheet" href="../../assets/fonts/css/fontawesome.min.css">
		
		<link rel="stylesheet" href="../../styles/index.css">
		<link rel="stylesheet" href="../../styles/header.css">
		<link rel="stylesheet" href="../../styles/footer.css">
		<link rel="stylesheet" href="../../styles/responsive.css">
		
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../components/header.jsp" />
		<div id="main-content" class="container">
			<div class="requests-container">
				<div class="container">
					<div class="col-md-12 header">
						<div class="row content">
							<div class="title">
								<label>Meus Pedidos</label>
							</div>
							<div class="line">
								<hr />
							</div>
						</div>
					</div>
					<div class="jumbotron main">
						<div class="col-md-12 content">
							<c:if test="${empty lista}">
								<div class="empty-request">
									<strong>Sua lista de pedidos está vazia.</strong>
								</div>
							</c:if>
							<c:forEach var="request" items="${lista}">
								<div class="request-grid">
									<strong class="o-title">
										Número do pedido: <span>${request.numberRequest}</span>
										<label onclick="handleShowItems(this);">Mostrar itens</label>
									</strong>
									<strong class="o-price">
										Total: <fmt:formatNumber currencySymbol="R$" value="${request.totalPrice}" type="currency"></fmt:formatNumber>
									</strong>
									<div class="o-items">
										<table>
											<thead>
												<tr>
													<th>Foto</th>
													<th>Nome do produto</th>
													<th>Preço</th>
													<th>Quantidade</th>
													<th>Ações</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${request.items}">
													<tr>
														<td><span style="background-image: url(http://localhost:8080${item.product.photos[0].url});"></span></td>
														<td>${item.product.name}</td>
														<td>
															<fmt:formatNumber currencySymbol="R$" value="${item.product.price}" type="currency"></fmt:formatNumber>
														</td>
														<td>${item.quantity}</td>
														<td>
															<a href="/PrettyStyle/controller.do?path=productdetails&command=ViewProduct&id_product=${item.product.id}">
																<i class="far fa-eye" style="color: #fff;"></i>
															</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="o-steps">
										<div class="steps">
											<div class="step checked">
												<span class="msg">Pedido realizado</span>
												<span class="number">1</span>
												<img src="../../assets/icons/large-check.svg" alt="Check">
											</div>
											<div class="step">
												<span class="msg">Aprovação de pagamento</span>
												<span class="number">2</span>
											</div>
											<div class="step">
												<span class="msg">Em transporte</span>
												<span class="number">3</span>
											</div>
											<div class="step">
												<span class="msg">Pedido entregue</span>
												<span class="number">4</span>
											</div>
											<div class="line-divisor"></div>
										</div>
									</div>
								</div>
								<hr id="linha" style="margin: 10px 0 60px 0;" />
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url="../../components/footer.jsp" />
		
		<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="script.js"></script>
	</body>
</html>
