<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.sprintters.prettystyle.model.Product"%>
<%@ page import="br.com.sprintters.prettystyle.service.ProductService"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="shortcut icon" href="/PrettyStyle/favicon.ico" type="image/x-icon" />

    <title>Pretty Style</title>
    
    <link rel="stylesheet" href="App/lib/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="App/lib/sweetalert/sweetalert.css">

    <link rel="stylesheet" href="App/styles/index.css">
    <link rel="stylesheet" href="App/styles/header.css">
    
    <link rel="stylesheet" href="App/styles/styles.css">
    <link rel="stylesheet" href="App/styles/responsive.css">
  </head>
  <body>
  	<c:import url="App/components/header.jsp" />
  	<div class="container">
  		<%
  			ProductService ps = new ProductService();
  		
  			ArrayList<Product> lista = ps.listBestSellers();
  		
  			ArrayList<Product> bestSellers1 = new ArrayList<Product>(lista.subList(0, (lista.size()/2)));
  			ArrayList<Product> bestSellers2 = new ArrayList<Product>(lista.subList(lista.size()/2, lista.size()));
  			
  			request.setAttribute("bestSellersOne", bestSellers1);
  			request.setAttribute("bestSellersTwo", bestSellers2);
  		%>
		
	    <div class="home-container">
		  	<div class="container">
				<section class="banner-section">
					<div class="slideshow-container">
						<div class="mySlides fade-slide">
							<div class="numbertext">1 / 3</div>
							<img src="App/assets/img/moda-1.jpg" style="width:100%">
							<div class="text">PROMOÇÃO % OFF</div>
						</div>
						<div class="mySlides fade-slide">
							<div class="numbertext">2 / 3</div>
							<img src="App/assets/img/moda-2.jpg" style="width:100%">
							<div class="text">PRETTY STYLE</div>
						</div>
						<div class="mySlides fade-slide">
							<div class="numbertext">3 / 3</div>
							<img src="App/assets/img/moda-3.jpg" style="width:100%">
							<div class="text">COLEÇÃO OUTONO INVERNO 2020</div>
						</div>
						<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
						<a class="next" onclick="plusSlides(1)">&#10095;</a>
					</div>
					<br>
					<div style="text-align:center">
						<span class="dot" onclick="currentSlide(1)"></span>
						<span class="dot" onclick="currentSlide(2)"></span>
						<span class="dot" onclick="currentSlide(3)"></span>
					</div>
				</section>
				<div class="col-md-12 header">
		  			<div class="row content">
			  			<div class="title">
			  				<label>Mais vendidos</label>
			  			</div>
			  			<div class="line">
			  				<hr />
			  			</div>
		  			</div>
		  		</div>
				<section class="best-sellers">
					<div class="jumbotron">
						<div class="col-md-12 content">
							<div class="col-md-12" style="padding: 0;">
								<div class="row">
									<div id="myCarousel" class="carousel slide" data-ride="carousel">
										<div class="carousel-inner">
											<div class="carousel-item active">
												<div class="row">
													<c:forEach var="product" items="${bestSellersOne}">
														<div class="col-md-3">
															<div class="jumbotron product">
																<div id="id-user" class="photo-product" onclick="window.location.href='/PrettyStyle/controller.do?path=productdetails&command=ViewProduct&id_product=${product.id}'">
																	<img src="App/assets/img/jbl.png" alt="${product.name}">
																</div>
																<label class="title-product">${product.name}</label>
																<div class="stars">
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star gray-star">&nbsp;</span>
																</div>
																<label class="price-product">
																	<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/>
																</label>
															</div>
														</div>
													</c:forEach>
												</div>
											</div>
											<div class="carousel-item">
												<div class="row">
													<c:forEach var="product" items="${bestSellersTwo}">
														<div class="col-md-3">
															<div class="jumbotron product">
																<div class="photo-product" onclick="window.location.href='/PrettyStyle/controller.do?path=productdetails&command=ViewProduct&id_product=${product.id}'">
																	<img src="App/assets/img/jbl.png" alt="${product.name}">
																</div>
																<label class="title-product">${product.name}</label>
																<div class="stars">
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star gray-star">&nbsp;</span>
																</div>
																<label class="price-product">
																	<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/>
																</label>
															</div>
														</div>
													</c:forEach>
												</div>
											</div>
											<a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
												<img src="App/assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
											</a>
											<a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
												<img src="App/assets/icons/arrow-right.svg" alt="Arrow right" class="arrow-right">
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div style="display: none;" class="col-md-12 content">
							<img src="App/assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
							<div class="col-md-12">
								<div class="row">
									<c:forEach var="product" items="${testList}">
										<div class="col-md-3">
											<div class="jumbotron product">
												<div class="photo-product" onclick="window.location.href='App/pages/product-details/product-details.jsp'">
													<img src="App/assets/img/jbl.png" alt="${product.name}">
												</div>
												<label class="title-product">${product.name}</label>
												<div class="stars">
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star gray-star">&nbsp;</span>
												</div>
												<label class="price-product">
													<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/>
												</label>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
							<img src="App/assets/icons/arrow-right.svg" alt="Arrow right" class="arrow-right">
						</div>
					</div>
				</section>
				<div class="col-md-12 header">
		  			<div class="row content">
			  			<div class="title">
			  				<label>Mais vendidos</label>
			  			</div>
			  			<div class="line">
			  				<hr />
			  			</div>
		  			</div>
		  		</div>
				<section class="best-sellers">
					<div class="jumbotron">
						<div class="col-md-12 content">
							<div class="col-md-12" style="padding: 0;">
								<div class="row">
									<div id="myCarousel" class="carousel slide" data-ride="carousel">
										<div class="carousel-inner">
											<div class="carousel-item active">
												<div class="row">
													<c:forEach var="product" items="${bestSellersOne}">
														<div class="col-md-3">
															<div class="jumbotron product">
																<div id="id-user" class="photo-product" onclick="window.location.href='/PrettyStyle/controller.do?path=productdetails&command=ViewProduct&id_product=${product.id}'">
																	<img src="App/assets/img/jbl.png" alt="${product.name}">
																</div>
																<label class="title-product">${product.name}</label>
																<div class="stars">
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star gray-star">&nbsp;</span>
																</div>
																<label class="price-product">
																	<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/>
																</label>
															</div>
														</div>
													</c:forEach>
												</div>
											</div>
											<div class="carousel-item">
												<div class="row">
													<c:forEach var="product" items="${bestSellersTwo}">
														<div class="col-md-3">
															<div class="jumbotron product">
																<div class="photo-product" onclick="window.location.href='/PrettyStyle/controller.do?path=productdetails&command=ViewProduct&id_product=${product.id}'">
																	<img src="App/assets/img/jbl.png" alt="${product.name}">
																</div>
																<label class="title-product">${product.name}</label>
																<div class="stars">
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star yellow-star">&nbsp;</span>
																	<span class="star gray-star">&nbsp;</span>
																</div>
																<label class="price-product">
																	<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/>
																</label>
															</div>
														</div>
													</c:forEach>
												</div>
											</div>
											<a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
												<img src="App/assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
											</a>
											<a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
												<img src="App/assets/icons/arrow-right.svg" alt="Arrow right" class="arrow-right">
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div style="display: none;" class="col-md-12 content">
							<img src="App/assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
							<div class="col-md-12">
								<div class="row">
									<c:forEach var="product" items="${testList}">
										<div class="col-md-3">
											<div class="jumbotron product">
												<div class="photo-product" onclick="window.location.href='App/pages/product-details/product-details.jsp'">
													<img src="App/assets/img/jbl.png" alt="${product.name}">
												</div>
												<label class="title-product">${product.name}</label>
												<div class="stars">
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star yellow-star">&nbsp;</span>
													<span class="star gray-star">&nbsp;</span>
												</div>
												<label class="price-product">
													<fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/>
												</label>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
							<img src="App/assets/icons/arrow-right.svg" alt="Arrow right" class="arrow-right">
						</div>
					</div>
				</section>
			</div>
		</div>
  	</div>
    <script src="App/lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="App/lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="App/js/general.js"></script>
    <script src="App/js/index.js"></script>
  </body>
</html>
