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

<link rel="stylesheet"
	href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet" href="../../styles/index.css">
<link rel="stylesheet" href="../../styles/header.css">

<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="../../styles/responsive.css">
</head>
<body>
	<c:import url="../../components/header.jsp" />
	<div class="container">
		<%
			AddressService as = new AddressService();
			ArrayList<Address> lista = as.listPlusName(1); 
			ArrayList<Address> listAddress1 = new ArrayList<Address>(lista.subList(0, (lista.size()/2)));
			ArrayList<Address> listAddress2 = new ArrayList<Address>(lista.subList(lista.size()/2, lista.size()));
			request.setAttribute("lista1", listAddress1);
			request.setAttribute("lista2", listAddress2);
		%>


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
										<c:forEach var="request" items="${lista1}">
											<div class="jumbotron address active">
												<div class="header">
													<label>Casa</label>
													<div class="icons">
														<button type="button">
															<img src="../../assets/icons/edit.svg" alt="Editar">
														</button>
														<button type="button">
															<img src="../../assets/icons/bin.svg" alt="Lixeira">
														</button>
													</div>
												</div>
												<hr />
												<div class="body">
													<label class="client-name">${request.name} ${request.surname}</label> <label>Endereço:
														<span>${request.place}, ${request.number}</span>
													</label> <label>Bairro: <span>${request.neighborhood}</span></label> <label>Cidade:
														<span>${request.city }</span>
													</label> <label>Complemento: <span>${request.complement }</span></label> <label>CEP:
														<span>${request.zip }</span>
													</label>
												</div>
												<hr />
												<div class="selection-area">
													<input type="radio" /> <label>Selecionar como
														principal</label>
												</div>
											</div>
										</c:forEach>
									</div>
									<div class="col-md-6">
										<c:forEach var="request" items="${lista2}">
											<div class="jumbotron address active">
												<div class="header">
													<label>Casa</label>
													<div class="icons">
														<button type="button">
															<img src="../../assets/icons/edit.svg" alt="Editar">
														</button>
														<button type="button">
															<img src="../../assets/icons/bin.svg" alt="Lixeira">
														</button>
													</div>
												</div>
												<hr />
												<div class="body">
													<label class="client-name">${request.name} ${request.surname}</label> <label>Endereço:
														<span>${request.place}, ${request.number}</span>
													</label> <label>Bairro: <span>${request.neighborhood}</span></label> <label>Cidade:
														<span>${request.city }</span>
													</label> <label>Complemento: <span>${request.complement }</span></label> <label>CEP:
														<span>${request.zip }</span>
													</label>
												</div>
												<hr />
												<div class="selection-area">
													<input type="radio" /> <label>Selecionar como
														principal</label>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							
							
						<div class="row button-area">
							<button type="button">SALVAR</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script src="../../js/general.js"></script>
	<script src="../../js/index.js"></script>
</body>
</html>