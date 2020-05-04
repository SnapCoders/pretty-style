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
								<div class="row">
									<div class="col-md-3 product-photo">
										<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
									</div>
									<div class="col-md-9 product-info">
										<div class="col-md-12 product-details-area">
											<div class="row">
												<div class="col-md-6 product-details">
													<label>${request.product.name}</label>
													<span>${request.product.description}</span>
												</div>
												<div class="col-md-3 product-stars">
													<div class="stars">
														<span class="star yellow-star">&nbsp;</span>
														<span class="star yellow-star">&nbsp;</span>
														<span class="star yellow-star">&nbsp;</span>
														<span class="star yellow-star">&nbsp;</span>
														<span class="star gray-star">&nbsp;</span>
													</div>
												</div>
												<div class="col-md-3 product-price">
													<span>Preço: </span>
													<label>
														<fmt:formatNumber currencySymbol="R$" value="${request.product.price}" type="currency" />
													</label>
												</div>
											</div>
											<div class="row steps">
												<div class=" col-md-12 request-steps">
													<div class="step checked">
														<label>Pedido Realizado</label>
														<span>1</span>
														<img src="../../assets/icons/large-check.svg" alt="Check">
													</div>
													<div class="step">
														<label>Aprovação de pagamento</label>
														<span>2</span>
														<img src="../../assets/icons/large-check.svg" alt="Check">
													</div>
													<div class="step">
														<label>Produto(s) em transporte</label>
														<span>3</span>
														<img src="../../assets/icons/large-check.svg" alt="Check">
													</div>
													<div class="step">
														<label>Produto(s) Entregue(s)</label>
														<span>4</span>
														<img src="../../assets/icons/large-check.svg" alt="Check">
													</div>
												</div>
												<hr />
											</div>
										</div>
									</div>
								</div>
								<hr />
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url="../../components/footer.jsp" />
		
		<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</body>
</html>
