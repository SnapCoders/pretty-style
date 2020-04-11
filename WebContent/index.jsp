<%@page import="br.com.sprintters.prettystyle.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.sprintters.prettystyle.service.ProductService"  %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

    <title>Pretty Style</title>
    
    <link rel="stylesheet" href="App/lib/bootstrap/4.4.1/css/bootstrap.min.css">

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
  			
  			request.setAttribute("bestSellers", ps.list());
  			request.setAttribute("testList", ps.listMore());
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
							<img src="App/assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
							<div class="col-md-12">
								<div class="row">
									<c:forEach var="product" items="${bestSellers}">
										<div class="col-md-3">
											<div class="jumbotron product" onclick="navigateToProductDetails()">
												<div class="photo-product">
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
													R$ <fmt:formatNumber value="${product.price}" type="currency" currencySymbol=""/>
												</label>
											</div>
										</div>
									</c:forEach>
									<!-- <div class="col-md-3">
										<div class="jumbotron product" onclick="navigateToProductDetails()">
											<div class="photo-product">
												<img src="App/assets/img/jbl.png" alt="JBL Flip 3 Portable">
											</div>
											<label class="title-product">JBL Flip 3 Portable</label>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<label class="price-product">R$ 250,00</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="jumbotron product">
											<div class="photo-product">
												<img src="App/assets/img/jbl.png" alt="JBL Flip 3 Portable">
											</div>
											<label class="title-product">JBL Flip 3 Portable</label>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<label class="price-product">R$ 250,00</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="jumbotron product">
											<div class="photo-product">
												<img src="App/assets/img/jbl.png" alt="JBL Flip 3 Portable">
											</div>
											<label class="title-product">JBL Flip 3 Portable</label>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<label class="price-product">R$ 250,00</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="jumbotron product">
											<div class="photo-product">
												<img src="App/assets/img/jbl.png" alt="JBL Flip 3 Portable">
											</div>
											<label class="title-product">JBL Flip 3 Portable</label>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<label class="price-product">R$ 250,00</label>
										</div>
									</div> -->
								</div>
							</div>
							<img src="App/assets/icons/arrow-right.svg" alt="Arrow right" class="arrow-right">
						</div>
						<div class="col-md-12 content">
							<img src="App/assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
							<div class="col-md-12">
								<div class="row">
									<c:forEach var="product" items="${testList}">
										<div class="col-md-3">
											<div class="jumbotron product" onclick="navigateToProductDetails()">
												<div class="photo-product">
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
													R$ <fmt:formatNumber value="${product.price}" type="currency" currencySymbol=""/>
												</label>
											</div>
										</div>
									</c:forEach>
									<!-- <div class="col-md-3">
										<div class="jumbotron product">
											<div class="photo-product">
												<img src="App/assets/img/jbl.png" alt="JBL Flip 3 Portable">
											</div>
											<label class="title-product">JBL Flip 3 Portable</label>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<label class="price-product">R$ 250,00</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="jumbotron product">
											<div class="photo-product">
												<img src="App/assets/img/jbl.png" alt="JBL Flip 3 Portable">
											</div>
											<label class="title-product">JBL Flip 3 Portable</label>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<label class="price-product">R$ 250,00</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="jumbotron product">
											<div class="photo-product">
												<img src="App/assets/img/jbl.png" alt="JBL Flip 3 Portable">
											</div>
											<label class="title-product">JBL Flip 3 Portable</label>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<label class="price-product">R$ 250,00</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="jumbotron product">
											<div class="photo-product">
												<img src="App/assets/img/jbl.png" alt="JBL Flip 3 Portable">
											</div>
											<label class="title-product">JBL Flip 3 Portable</label>
											<div class="stars">
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star yellow-star">&nbsp;</span>
												<span class="star gray-star">&nbsp;</span>
											</div>
											<label class="price-product">R$ 250,00</label>
										</div>
									</div> -->
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
  </body>
</html>
