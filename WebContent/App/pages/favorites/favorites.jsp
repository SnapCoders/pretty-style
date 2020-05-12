<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
		
		<title>Pretty Style - Favoritos</title>
		
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
			<div class="favorites-container">
				<div class="container">
					<div class="col-md-12 header">
						<div class="row content">
							<div class="title">
								<label>Favoritos</label>
							</div>
							<div class="line">
								<hr />
							</div>
						</div>
					</div>
					<div class="jumbotron main">
						<div class="col-md-12 content">
							<c:if test="${empty productsLiked}">
								<div class="empty-favorites">
									<strong>Sua lista de favoritos está vazia.</strong>
								</div>
							</c:if>
							<c:forEach var="productLiked" items="${productsLiked}">
								<div class="row">
									<div class="col-md-11">
										<div class="product-details-area">
											<div class="product-photo-area">
												<img src="../../assets/img/jbl.png" alt="${productLiked.product.name}">
											</div>
											<div class="product-info">
												<label>${productLiked.product.name}</label>
												<span>${productLiked.product.description}</span>
												<div class="stars">
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star gray-star">&nbsp;</span>
												</div>
												<div class="content">
													<span>Preço: </span>
													<label>
														<fmt:formatNumber value="${productLiked.product.price}" type="currency" currencySymbol="R$" />
													</label>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-1 like">
										<div class="like-product">
											<div class="favorite">
												<div class="favorite-icon" onclick="handleDeleteFavorite(${productLiked.id}, ${productLiked.product.id});">
													<img src="../../assets/icons/white-heart.svg">
												</div>
											</div>
										</div>
									</div>
								</div>
								<hr id="linha" />
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url="../../components/footer.jsp" />
		
		<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../lib/sweetalert/sweetalert.min.js"></script>
	
		<script src="script.js"></script>
	</body>
</html>
