<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.sprintters.prettystyle.model.Mark"%>
<%@ page import="br.com.sprintters.prettystyle.service.MarkService"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon" />

		<title>Pretty Style - Cadastrar Produto</title>
    
		<link rel="stylesheet" href="../../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../../lib/sweetalert/sweetalert.css">
		<link rel="stylesheet" href="../../../assets/fonts/css/all.css">
		<link rel="stylesheet" href="../../../assets/fonts/css/fontawesome.min.css">

		<link rel="stylesheet" href="../../../styles/index.css">
		<link rel="stylesheet" href="../../../styles/header.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<%
  			MarkService ms = new MarkService();
  			
  			request.setAttribute("marks", ms.list());
  		%>
		<c:import url="../../../components/header.jsp" />
		<div class="container">
			<div class="new-product-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Cadastrar novo produto</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  				<a id="id-user" class="btn btn-sm btn-primary" href="/PrettyStyle/controller.do?path=admin&command=ListProducts">Voltar</a>
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
			  				<form id="id-user" action="/PrettyStyle/controller.do?path=admin&command=CreateProduct&json=true" method="post" enctype="multipart/form-data" name="add-product">
				  				<div class="row">
				  					<div class="col-md-6">
					  					<label for="name">Nome do produto<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="name" name="name" placeholder="Nome do produto" />
					  				</div>
					  				<div class="col-md-6">
					  					<label for="description">Descrição<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="description" name="description" placeholder="Breve descrição do produto" />
					  				</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-6">
					  					<label for="mark">Selecione a marca do seu Produto<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<select class="form-control" id="mark" name="idMark">
					  						<option value="0">--Selecione--</option>
					  						<c:forEach var="mark" items="${marks}">
					  							<option value="${mark.id}">${mark.name}</option>
					  						</c:forEach>
					  					</select>
					  				</div>
				  					<div class="col-md-6">
					  					<label for="price">Preço<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="price" name="price" placeholder="Preço do seu produto" />
					  				</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-12">
				  						<label for="photo">Incluir uma imagem</label>
				  						<input class="form-control" type="file" id="photo" name="photo" placeholder="Arraste uma imagem aqui" multiple />
				  						<div class="previews"></div>
				  					</div>
				  				</div>
					  			<div class="row button-area">
				  					<button type="submit">CADASTRAR</button>
				  				</div>
			  				</form>
			  			</div>
					</div>
			  	</div>
			</div>
 		</div>
		
		<script src="../../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../../lib/jquery-validation/jquery.validate.min.js"></script>
		<script src="../../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../../lib/sweetalert/sweetalert.min.js"></script>
		
		<script src="script.js"></script>
	</body>
</html>
