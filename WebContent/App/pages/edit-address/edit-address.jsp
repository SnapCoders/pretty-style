<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.sprintters.prettystyle.model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.sprintters.prettystyle.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

<title>Pretty Style</title>

<link rel="stylesheet" href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../../lib/sweetalert/sweetalert.css">

<link rel="stylesheet" href="../../styles/index.css">
<link rel="stylesheet" href="../../styles/header.css">

<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="../../styles/responsive.css">
</head>
<body>
	<c:import url="../../components/header.jsp" />
	<div id="main-content" class="container">
		<div class="edit-address-container">
			<div class="container">
				<div class="col-md-12 header">
					<div class="row content">
						<div class="title">
							<label>Editar endereço</label>
						</div>
						<div class="line">
							<hr />
						</div>
					</div>
				</div>
				<div class="jumbotron main">
					<div class="col-md-12 content">
						<form action="/PrettyStyle/controller.do?path=address&command=UpdateAddress&json=true" method="POST" name="add-address">
							<div style="display: none;"><input name="id_address" value="${address.id}"></div>
							<div class="row">
								<div class="col-md-6 destination-area">
									<label for="name">Nome do destinatário<span
										style="color: #ff0000; margin-left: 5px;">*</span></label> <input
										class="form-control" id="name" name="name"
										placeholder="Como você gostaria de ser chamado?" value="${user.username}"/>
								</div>
								<div class="col-md-6 cep-area">
									<label for="cep"  >Cep<span
										style="color: #ff0000; margin-left: 5px;">*</span></label> <input
										class="form-control" id="cep" name="zip" placeholder="digite o cep" value="${address.zip}" />
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 name-area">
									<label for="place">Logradouro<span
										style="color: #ff0000; margin-left: 5px;">*</span></label> <input
										class="form-control" id="place" name="place" placeholder="Ex.: Rua ..." value="${address.place}" />
								</div>
								<div class="col-md-2">
									<label for="number">Número<span
										style="color: #ff0000; margin-left: 5px;">*</span></label> <input
										class="form-control" id="number" name="number" placeholder="Seu numero" value="${address.number}"/>
								</div>
								<div class="col-md-6 neighborhood-area">
									<label for="neighborhood">Bairro<span
										style="color: #ff0000; margin-left: 5px;">*</span></label> <input
										class="form-control" id="neighborhood" name="neighborhood"
										placeholder="Seu bairro" value="${address.neighborhood}" />
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 city-area">
									<label for="city">Cidade<span
										style="color: #ff0000; margin-left: 5px;">*</span></label> <input
										class="form-control" id="city" name="city" placeholder="Sua cidade" value="${address.city}"/>
								</div>
								<div class="col-md-6 state-area">
									<label for="state">Estado<span
										style="color: #ff0000; margin-left: 5px;">*</span></label> <input
										class="form-control" id="state" name="state" placeholder="Seu estado" value="${address.city}"/>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 country-area">
									<label for="country">País<span
										style="color: #ff0000; margin-left: 5px;">*</span></label> <input
										class="form-control" id="country" name="country" placeholder="Seu país" value="${address.country}" />
								</div>
								<div class="col-md-6 complement-area">
									<label for="complement">Complemento</label> <input
										class="form-control" id="complement" name="complement"
										placeholder="Digite o complemento para facilitar a localização" value="${address.complement}" />
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
	<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="../../lib/jquery-validation/jquery.validate.min.js"></script>
	<script src="../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script src="../../lib/sweetalert/sweetalert.min.js"></script>
	<script src="../../js/general.js"></script>
	
	<script src="searchCep.js"></script>
	<script src="script.js"></script>
</body>
</html>