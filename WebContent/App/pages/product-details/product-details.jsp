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
											<div class="jumbotron product-photo">
												<div id="dProductPhotos" class="product-photos-slideshow-container">
													<c:forEach var="photo" items="${product.photos}">
														<div class="productSlides fade-product-photo-slide">
															<img src="${photo.url}" alt="" style="width: 100%;">
														</div>
													</c:forEach>
													<a class="prev-product-photo" onclick="productPhotoSlides(-1)">
														<img src="../../assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
													</a>
													<a class="next-product-photo" onclick="productPhotoSlides(1)">
														<img src="../../assets/icons/arrow-right.svg" alt="Arrow right" class="arrow-right">
													</a>
												</div>
												<div id="dProductPhotosDots" style="text-align:center">
													<span class="dot" onclick="currentProductPhotoSlide(1)"></span>
													<span class="dot" onclick="currentProductPhotoSlide(2)"></span>
													<span class="dot" onclick="currentProductPhotoSlide(3)"></span>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-7">
										<div class="product-details-area">
											<div class="row product-title">
												<div class="product-info">
													<c:if test="${not empty productDetails}">
														<input type="hidden" name="id_product" id="productId" value="${productDetails.product.id}" />
														<input type="hidden" name="name" value="${productDetails.product.name}" />
														<input type="hidden" name="description" value="${productDetails.product.description}" />
														<label>${productDetails.product.name}</label>
														<span class="product-description">${productDetails.product.description}</span>
													</c:if>
													<c:if test="${empty productDetails}">
														<input type="hidden" name="id_product" id="productId" value="${product.id}" />
														<input type="hidden" name="name" value="${product.name}" />
														<input type="hidden" name="description" value="${product.description}" />
														<label>${product.name}</label>
														<span class="product-description">${product.description}</span>
													</c:if>
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
														<c:if test="${empty productDetails}">
															<div id="like" class="favorite-icon like" onclick="handleLikeDislike(this, ${product.id});">
																<img src="../../assets/icons/heart.svg"/>
															</div>
														</c:if>
														<c:if test="${productDetails.action == 0}">
															<div id="like" class="favorite-icon like" onclick="handleLikeDislike(this, ${product.id});">
																<img src="../../assets/icons/heart.svg"/>
															</div>
														</c:if>
														<c:if test="${productDetails.action == 1}">
															<div id="dislike" class="favorite-icon dislike" onclick="handleLikeDislike(this, ${product.id});">
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
														<c:if test="${not empty productDetails}">
															<fmt:formatNumber value="${productDetails.product.price}" type="currency" currencySymbol="R$"/>
															<input type="hidden" name="price" value="${productDetails.product.price}" />
														</c:if>
														<c:if test="${empty productDetails}">
															<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/>
															<input type="hidden" name="price" value="${product.price}" />
														</c:if>
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
												<span>Este produto é vendido e entregue por
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
