<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
		<link rel="stylesheet" href="../../../lib/select2/select2.min.css">

		<link rel="stylesheet" href="../../../styles/index.css">
		<link rel="stylesheet" href="../../../styles/header.css">
		<link rel="stylesheet" href="../../../styles/footer.css">
		<link rel="stylesheet" href="../../../styles/responsive.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../../components/header.jsp" />
		<div id="main-content" class="container">
			<div class="edit-product-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Editar produto</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  				<a id="id-user" class="btn btn-sm btn-primary" href="/PrettyStyle/controller.do?path=admin&command=ListProducts">Voltar</a>
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
			  				<form id="id-user" action="/PrettyStyle/controller.do?path=admin&command=UpdateProduct&json=true" method="post" enctype="multipart/form-data" name="update-product">
				  				<div class="row">
				  					<input type="hidden" value="${product.id}" name="idProduct">
				  					<div class="col-md-12">
					  					<label for="name">Nome do produto<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="name" name="name" placeholder="Nome do produto" value="${product.name}" />
					  				</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-12">
					  					<label for="description">Descrição<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<textarea style="min-height: 120px; max-height: 280px;" class="form-control" id="description" name="description" placeholder="Breve descrição do produto">${product.description}</textarea>
					  				</div>
				  				</div>
				  				<div class="row">
				  					<input type="hidden" value="${mark.id}" id="markId">
				  					<input type="hidden" value="${mark.name}" id="markName">
				  					<div class="col-md-4">
					  					<label for="mark">Selecione a marca<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<select class="form-control" id="mark" name="idMark" >
					  						
					  						<option value="0">--Selecione--</option>
					  						<c:forEach var="mark" items="${marks}">
					  							<option value="${mark.id}">${mark.name}</option>
					  						</c:forEach>
					  					</select>
					  				</div>
				  					<div class="col-md-3">
					  					<label for="price">Preço<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="price" name="price" placeholder="Preço do seu produto" value="${product.price}" />
					  				</div>
					  				<div class="col-md-5">
					  					<input type="hidden" value="${idsCategoriesByUser}" id="idsCategoriesByUser" >
						  				<label for="category">Selecione a categoria<span style="color: #ff0000; margin-left: 5px;">*</span></label>
						  				<select class="form-control" id="category" name="idCategory" multiple="multiple">
						  					<option value="0">--Selecione--</option>
						  					<c:forEach var="category" items="${categories}">
						  						<option value="${category.id}">${category.name}</option>
						  					</c:forEach>
						  				</select>
						  	
						  			</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-12">
				  						<label for="photo">Incluir uma imagem</label>
				  						<input class="form-control" type="file" id="photo" name="photo" placeholder="Arraste uma imagem aqui" multiple style="margin-bottom: 20px;" />
				  						<div class="previews">
				  						<c:if test="${not empty productPhoto}">
				  									<input name="idsDelete" type="hidden" value="" id="idPhotosDelete">
				  							<c:forEach var="photos" items="${productPhoto}">				  								
				  								<div id="imagePreview" class="image-preview">
				  									<i class="fas fa-times remove-image" onclick="handleDeleteImg(${photos.id})"></i>
				  									<img class="image-preview__image" src="${photos.url}" alt="Preview" style="display: inline;">
				  									<span class="image-preview__default-text" style="display: none;">Preview</span>
				  								</div>
				  							</c:forEach>
				  						</c:if>
				  						</div>
				  					</div>
				  				</div>
					  			<div class="row button-area">
				  					<button type="submit">SALVAR</button>
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
