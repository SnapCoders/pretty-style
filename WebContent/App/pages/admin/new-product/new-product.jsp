<%@ page import="br.com.sprintters.prettystyle.service.CategoryService"%>
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
		<link rel="stylesheet" href="../../../lib/select2/select2.min.css">
		<link rel="stylesheet" href="../../../assets/fonts/css/all.css">
		<link rel="stylesheet" href="../../../assets/fonts/css/fontawesome.min.css">

		<link rel="stylesheet" href="../../../styles/index.css">
		<link rel="stylesheet" href="../../../styles/header.css">
		<link rel="stylesheet" href="../../../styles/footer.css">
		<link rel="stylesheet" href="../../../styles/responsive.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../../components/header.jsp" />
		<%
			MarkService ms = new MarkService();
			CategoryService cs = new CategoryService();
			
			request.setAttribute("marks", ms.list());
			request.setAttribute("categories", cs.list());
		%>
		<div id="main-content" class="container">
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
				  					<div class="col-md-12">
					  					<label for="name">Nome do produto<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="name" name="name" placeholder="Nome do produto" />
					  				</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-12">
					  					<label for="description">Descrição<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<textarea style="min-height: 120px; max-height: 280px;" class="form-control" id="description" name="description" placeholder="Breve descrição do produto"></textarea>
					  				</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-4">
					  					<label for="mark">Selecione ou </label><span class="span-modify" onclick="handleModifyMarkInput();"> cadastre uma nova marca</span><span style="color: #ff0000; margin-left: 5px;">*</span>
					  					<select class="form-control active" id="mark" name="idMark">
					  						<option value="0">--Selecione--</option>
					  						<c:forEach var="mark" items="${marks}">
					  							<option value="${mark.id}">${mark.name}</option>
					  						</c:forEach>
					  					</select>
					  					<input style="display: none;" class="form-control" id="newMark" name="newMark" />
					  				</div>
					  				<div class="col-md-4">
					  					<label for="quantity">Informe a quantidade<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="quantity" name="quantity" placeholder="Digite a quantidade" />
					  				</div>
				  					<div class="col-md-4">
					  					<label for="price">Preço<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="price" name="price" placeholder="Selecione o preço" />
					  				</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-12">
					  					<label for="category">Selecione ou </label><span class="span-modify" onclick="handleModifyCategoryInput();"> cadastre uma nova categoria</span><span style="color: #ff0000; margin-left: 5px;">*</span>
					  					<select class="form-control active" id="category" name="idCategory" multiple="multiple">
					  						<option value="0">--Selecione--</option>
					  						<c:forEach var="category" items="${categories}">
					  							<option value="${category.id}">${category.name}</option>
					  						</c:forEach>
					  					</select>
					  					<input style="display: none;" class="form-control" id="newCategory" name="newCategory" placeholder="Separe as categorias por vírgula e elas serão cadastradas automaticamente" />
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
 		<c:import url="../../../components/footer.jsp" />
		
		<script src="../../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../../lib/jquery-validation/jquery.validate.min.js"></script>
		<script src="../../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../../lib/sweetalert/sweetalert.min.js"></script>
		<script src="../../../lib/select2/select2.min.js"></script>
		
		<script src="script.js"></script>
	</body>
</html>
