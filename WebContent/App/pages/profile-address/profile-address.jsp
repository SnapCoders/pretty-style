<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
		
		<title>Pretty Style - Meus Endereços</title>
		
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
						<div class="navigation">
			  				<label class="" onclick="window.location.href='/PrettyStyle/controller.do?path=profile&command=EditProfile'">Minha conta</label>
			  				<hr style="width: 20px;" />
			  				<label class="active">Meus endereços</label>
			  				<hr style="width: 20px;" />
			  				<label class="" onclick="window.location.href='/PrettyStyle/controller.do?path=address&command=NavigateToCreateAddress'">Cadastrar endereço</label>
			  			</div>
			  			<c:if test="${empty lista}">
							<div class="empty-cart">
								<strong>Você não tem endereços cadastrados no momento.</strong>
							</div>
						</c:if>
						<div class="col-md-12 content">
							<div class="row">
								<c:forEach var="address" items="${lista}">
									<div class="col-md-6">
										<div id="card-address" class="jumbotron address ${not empty address.userAddress ? 'active' : ''}">
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
												<label class="client-name">${address.recipient}</label>
												<label>Endereço: <span>${address.place}, ${address.number}</span></label>
												<label>Bairro: <span>${address.neighborhood}</span></label>
												<label>Cidade: <span>${address.city}</span></label>
												<label>Complemento: <span>${address.complement}</span></label>
												<label>CEP: <span>${address.zip}</span></label>
											</div>
											<hr />
											<div class="selection-area">
												<c:if test="${empty address.userAddress}">
													<input name="defaultAddress" type="radio" onclick="handleSelectDefault(this)" />
												</c:if>
												<c:if test="${not empty address.userAddress}">
													<input name="defaultAddress" type="radio" onclick="handleSelectDefault(this)" checked />
												</c:if>
												<label>Selecionar como principal</label>
											</div>
										</div>
									</div>
								</c:forEach>
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
		
		<script src="script.js"></script>
	</body>

</html>