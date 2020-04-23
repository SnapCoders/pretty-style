<%@page import="br.com.sprintters.prettystyle.model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.sprintters.prettystyle.model.Address"%>
<%@ page import="br.com.sprintters.prettystyle.service.AddressService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
		<div class="container">

			<div class="profile-address-container">
				<div class="container">
					<div class="col-md-12 header">
						<div class="row content">
							<div class="title">
								<label>Meus Endereços</label>
							</div>
							<div class="line">
								<hr />
							</div>
						</div>
					</div>
					<div class="jumbotron main">
						<div class="col-md-12 content">
							<div class="row">
								<div class="col-md-6">
									<c:forEach var="address" items="${lista1}">
										<div id="card-address" class="jumbotron address">
											<div class="header">
												<label>Casa</label>
												<div class="icons">
													<button type="button" id="id-user" onclick="window.location.href='/PrettyStyle/controller.do?path=address&command=FindAddress&id_address=${address.id}'"> 
														<img src="../../assets/icons/edit.svg" alt="Editar">
													</button>
													<button type="button" onclick="handleDelete(${address.id})">
														<img src="../../assets/icons/bin.svg" alt="Lixeira">
													</button>
												</div>
											</div>
											<hr />
											<div class="body">
												<label class="client-name">${user.client.name} ${user.client.surname}</label>
												<label>Endereço: <span>${address.place}, ${address.number}</span></label>
												<label>Bairro: <span>${address.neighborhood}</span></label>
												<label>Cidade: <span>${address.city }</span></label>
												<label>Complemento: <span>${address.complement }</span></label>
												<label>CEP: <span>${address.zip }</span></label>
											</div>
											<hr />
											<div class="selection-area">
												<input type="radio" onclick="handleSelectDefault(this)" /> <label>Selecionar como principal</label>
											</div>
										</div>
									</c:forEach>
								</div>
								<div class="col-md-6">
									<c:forEach var="address" items="${lista2}">
										<div class="jumbotron address">
											<div class="header">
												<label>Casa</label>
												<div class="icons">
													<button type="button" id="id-user" onclick="window.location.href='/PrettyStyle/controller.do?path=address&command=FindAddress&id_address=${address.id}'">
														<img src="../../assets/icons/edit.svg" alt="Editar">
													</button>
													<button type="button" name="acao" onclick="handleDelete(${address.id})">
														<img src="../../assets/icons/bin.svg" alt="Lixeira">
													</button>
												</div>
											</div>
											<hr />
											<div class="body">
												<label class="client-name">${user.client.name} ${user.client.surname}</label>
												<label>Endereço: <span>${address.place}, ${address.number}</span></label>
												<label>Bairro: <span>${address.neighborhood}</span></label>
												<label>Cidade: <span>${address.city}</span></label>
												<label>Complemento: <span>${address.complement}</span></label>
												<label>CEP: <span>${address.zip}</span></label>
											</div>
											<hr />
											<div class="selection-area">
												<input type="radio" onclick="handleSelectDefault(this)" /><label>Selecionar como principal</label>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../lib/sweetalert/sweetalert.min.js"></script>
		<script src="../../js/general.js"></script>
		
		<script src="script.js"></script>
	</body>

</html>