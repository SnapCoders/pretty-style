<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="/PrettyStyle/favicon.ico" type="image/x-icon" />

		<title>Pretty Style - Gerenciar</title>
    
		<link rel="stylesheet" href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../lib/sweetalert/sweetalert.css">
		<link href="../../../fonts/Allura-Regular.TTF" rel="stylesheet">

		<link rel="stylesheet" href="../../styles/index.css">
		<link rel="stylesheet" href="../../styles/header.css">
		<link rel="stylesheet" href="../../styles/footer.css">
		<link rel="stylesheet" href="../../styles/responsive.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../components/header.jsp" />
		<div id="main-content" class="container">
			<div class="admin-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Gerenciamento</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  				<a class="btn btn-sm btn-primary" href="../../../index.jsp">Voltar</a>
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
			  				<div class="row">
						    	<div class="col-sm-6">
						    		<div class="card">
						      			<div class="card-body">
						        			<h5 class="card-title">Gerenciar produtos cadastrados</h5>
						        			<p class="card-text">Gerencie seus produtos.</p>
						                	<a id="id-user" href="/PrettyStyle/controller.do?path=admin&command=ListProducts" class="btn btn-primary">Gerenciar meus produtos</a>
						            	</div>
						        	</div>
						      	</div>
						      	<div class="col-sm-6">
						    		<div class="card">
						      			<div class="card-body">
						        			<h5 class="card-title">Gerenciar marcas cadastrados</h5>
						        			<p class="card-text">Cadastre e gerencie as marcas de seus produtos.</p>
						                	<a id="id-user" href="/PrettyStyle/controller.do?path=admin&command=ListMarks" class="btn btn-primary">Gerenciar minhas marcas</a>
						            	</div>
						        	</div>
						      	</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
						    		<div class="card">
						      			<div class="card-body">
						        			<h5 class="card-title">Gerenciar categorias cadastradas</h5>
						        			<p class="card-text">Cadastre e gerencie as categorias de seus produtos.</p>
						                	<a id="id-user" href="/PrettyStyle/controller.do?path=admin&command=ListCategories" class="btn btn-primary">Gerenciar categorias</a>
						            	</div>
						        	</div>
						      	</div>
						      	<div class="col-sm-6">
						    		<div class="card">
						      			<div class="card-body">
						        			<h5 class="card-title">Gerenciar quantidade de produtos</h5>
						        			<p class="card-text">gerencie a quantidade dos produtos cadastrados.</p>
						                	<a id="id-user" href="/PrettyStyle/controller.do?path=admin&command=EditProductQuantity" class="btn btn-primary">Gerenciar quantidade em estoque</a>
						            	</div>
						        	</div>
						      	</div>
							</div>
			  			</div>
			  		</div>
			  	</div>
			</div>
		</div>
		<c:import url="../../components/footer.jsp" />
		
		<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../lib/sweetalert/sweetalert.min.js"></script>
	</body>
</html>
