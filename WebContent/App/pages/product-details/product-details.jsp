<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.sprintters.prettystyle.model.Mark"%>
<%@ page import="br.com.sprintters.prettystyle.service.MarkService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon" />
		
		<title>Pretty Style - Detalhes do Produto</title>
		
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
			<div class="product-details-container">
				<div class="container">
					<div class="col-md-12 header">
						<div class="row content">
							<div class="title">
								<label>Detalhes do produto</label>
							</div>
							<div class="line">
								<hr />
								<a class="btn btn-sm btn-primary" href="../../../index.jsp">Voltar</a>
							</div>
						</div>
					</div>
					<div class="jumbotron main">
						<div class="col-md-12 content">
							<form id="id-user" action="/PrettyStyle/controller.do?path=paymentsteps&command=CreatePayStep" method="POST" name="client-likes">
								<div class="row">
									<div class="col-md-5">
										<div class="product-photo-area">
											<img src="../../assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
											<div class="jumbotron product-photo">
												<img src="../../assets/img/jbl.png" alt="${productDetails.product.name}">
												<div class="next-circles">
													<div class="circle-next active"></div>
													<div class="circle-next"></div>
													<div class="circle-next"></div>
												</div>
											</div>
											<img src="../../assets/icons/arrow-right.svg" alt="Arrow right" class="arrow-right">
										</div>
									</div>
									<div class="col-md-7">
										<div class="product-details-area">
											<div class="row product-title">
												<div class="product-info">
													<input type="hidden" name="id_product" value="${productDetails.product.id}" />
													<input type="hidden" name="name" value="${productDetails.product.name}" />
													<input type="hidden" name="description" value="${productDetails.product.description}" />
													<label>${productDetails.product.name}</label>
													<span class="product-description">${productDetails.product.description}</span>
													<div class="stars">
														<span class="star yellow-star">&nbsp;</span>
														<span class="star yellow-star">&nbsp;</span>
														<span class="star yellow-star">&nbsp;</span>
														<span class="star yellow-star">&nbsp;</span>
														<span class="star gray-star">&nbsp;</span>
													</div>
												</div>
												<div class="like-product">
													<div class="favorite">
														<c:if test="${productDetails.action == 0}">
															<div id="like" class="favorite-icon like" onclick="handleLikeDislike(this, ${productDetails.product.id});">
																<img src="../../assets/icons/heart.svg"/>
															</div>
														</c:if>
														<c:if test="${productDetails.action == 1}">
															<div id="dislike" class="favorite-icon dislike" onclick="handleLikeDislike(this, ${productDetails.product.id});">
																<img src="../../assets/icons/white-heart.svg"/>
															</div>
														</c:if>
													</div>
												</div>
											</div>
											<div class="row product-price">
												<div class="price">
													<span>Preço: </span>
													<label>
														<fmt:formatNumber value="${productDetails.product.price}" type="currency" currencySymbol="R$"/>
														<input type="hidden" name="price" value="${productDetails.product.price}" />
													</label>
													<div class="quantity">
														<span>Quantidade: </span>
														<input class="form-control" name="quantity" style="margin-left: 5px; width: 60px; height: 22px;" maxlength="3" value="1" />
													</div>
												</div>
												<div class="freight">
													<span>Calcular frete e prazo</span>
													<div class="freight-and-deadline">
														<input class="form-control" placeholder="digite o cep" />
														<button type="button">OK</button>
													</div>
												</div>
											</div>
											<hr style="margin-top: 25px; margin-bottom: 25px;" />
											<div class="row product-info-more">
												<span>Mais informações</span>
												<span>Este produto é svendido e entregue por
													<a href="../../../index.jsp" style="color: #0E9AEF; font-weight: bold;">Pretty Style</a>
												</span>
											</div>
											<div class="row button-area">
												<button type="submit">COMPRAR</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url="../../components/footer.jsp" />

		<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../lib/jquery-validation/jquery.validate.min.js"></script>
		<script src="../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../lib/sweetalert/sweetalert.min.js"></script>
		
		<script src="script.js"></script>
	</body>
</html>
