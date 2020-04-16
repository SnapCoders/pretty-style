<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.sprintters.prettystyle.model.Category"%>
<%@ page import="br.com.sprintters.prettystyle.service.CategoryService"%>
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

    <title>Pretty Style - Catálogo</title>
    
    <link rel="stylesheet" href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="../../styles/index.css">
    <link rel="stylesheet" href="../../styles/header.css">
    
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="../../styles/responsive.css">
  </head>
  <body>
  	<c:import url="../../components/header.jsp" />
  	<div class="container">
  	<%
			CategoryService cs = new CategoryService();
			ArrayList<Category> lista = cs.list(); 
			request.setAttribute("lista", lista);
		%>
  	
		<div class="catalog-container">
			<div class="container">
				<div class="col-md-12 header">
					<div class="row content">
						<div class="title">
							<label>Catálogo</label>
						</div>
						<div class="line">
							<hr />
						</div>
					</div>
				</div>
				<div class="col-md-12 body">
					<div class="row">
						<div class="col-md-2 body-filters">
							<div class="jumbotron filters">
								<label>Categorias</label>
								<hr />
								<c:forEach var="request" items="${lista}">
									<div class="filters-inputs">
									
										<div class="male-filter">
											<label class="container-check">${request.name}
											  <input type="checkbox">
											  <span class="checkmark"></span>
											</label>
										</div>
									</div>
								</c:forEach>
								<div class="divisor"></div>
								<label>Preço</label>
								<hr />
							</div>
						</div>
						<div class="col-md-10 body-main">
							<div class="jumbotron main">
								<div class="row">
									<div class="col-md-12">
										<div class="row">
											<div class="col-md-3 col-product">
												<div class="jumbotron product">
													<div class="photo-product">
														<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
													</div>
													<label class="title-product">JBL Flip 3 Portable</label>
													<p>Caixinha de som portátil da JBL.</p>
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
											<div class="col-md-3 col-product">
												<div class="jumbotron product">
													<div class="photo-product">
														<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
													</div>
													<label class="title-product">JBL Flip 3 Portable</label>
													<p>Caixinha de som portátil da JBL.</p>
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
											<div class="col-md-3 col-product">
												<div class="jumbotron product">
													<div class="photo-product">
														<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
													</div>
													<label class="title-product">JBL Flip 3 Portable</label>
													<p>Caixinha de som portátil da JBL.</p>
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
											<div class="col-md-3 col-product">
												<div class="jumbotron product">
													<div class="photo-product">
														<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
													</div>
													<label class="title-product">JBL Flip 3 Portable</label>
													<p>Caixinha de som portátil da JBL.</p>
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
										</div>
										<div class="row">
											<div class="col-md-3 col-product">
												<div class="jumbotron product">
													<div class="photo-product">
														<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
													</div>
													<label class="title-product">JBL Flip 3 Portable</label>
													<p>Caixinha de som portátil da JBL.</p>
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
											<div class="col-md-3 col-product">
												<div class="jumbotron product">
													<div class="photo-product">
														<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
													</div>
													<label class="title-product">JBL Flip 3 Portable</label>
													<p>Caixinha de som portátil da JBL.</p>
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
											<div class="col-md-3 col-product">
												<div class="jumbotron product">
													<div class="photo-product">
														<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
													</div>
													<label class="title-product">JBL Flip 3 Portable</label>
													<p>Caixinha de som portátil da JBL.</p>
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
											<div class="col-md-3 col-product">
												<div class="jumbotron product">
													<div class="photo-product">
														<img src="../../assets/img/jbl.png" alt="JBL Flip 3 Portable">
													</div>
													<label class="title-product">JBL Flip 3 Portable</label>
													<p>Caixinha de som portátil da JBL.</p>
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
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="row button-area">
											<button type="button">ANTERIOR</button>
											<div class="pagination active">1</div>
											<div class="pagination">2</div>
											<button type="button">PRÓXIMA</button>
										</div>
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
	<script src="../../js/general.js"></script>
	<!-- <script src="../../pages/catalog/utils.js"></script> -->
	</body>
</html>
