<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.sprintters.prettystyle.service.RequestService"%>
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
			//RequestService rs = new RequestService();

			//request.setAttribute("lista", rs.listRequestsByIdClient(1));
		%>
		<div class="register-profile-container">
			<div class="container">
				<div class="col-md-12 header">
					<div class="row content">
						<div class="title">
							<label>Minha Conta</label>
						</div>
						<div class="line">
							<hr />
						</div>
					</div>
				</div>
				<div class="jumbotron main">
					<div class="col-md-12 content">
						<div class="row">
							<div class="col-md-6 username-area">
								<label for="username">Username<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="username"
									placeholder="Como você gostaria de ser chamado?" />
							</div>
							<div class="col-md-6 email-area">
								<label for="email">E-mail<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="email"
									placeholder="Ex: seuemail@email.com.br" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 name-area">
								<label for="name">Seu nome<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="name"
									placeholder="Digite seu primeiro nome" />
							</div>
							<div class="col-md-6 email-confirmation-area">
								<label for="email-confirmation">Confirmação de e-mail<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="email-confirmation"
									placeholder="Ex: seuemail@email.com.br" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 surname-area">
								<label for="surname">Seu sobrenome<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="surname"
									placeholder="Digite seu sobrenome" />
							</div>
							<div class="col-md-6 password-area">
								<label for="password">Senha<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="password"
									placeholder="Digite sua senha" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 cpf-area">
								<label for="cpf">CPF<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="cpf" placeholder="Ex: 123.456.789-85" />
							</div>
							<div class="col-md-6 birthday-area">
								<label for="birthday">Data de nascimento<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="birthday" placeholder="Ex: 01/01/2020" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 telephone-area">
								<label for="telephone">Telefone Fixo<span
									style="color: #AAA; margin-left: 5px;">(Opcional)</span></label> <input
									class="form-control" id="telephone"
									placeholder="Ex: (11) 2022-9944" />
							</div>
							<div class="col-md-6 cellphone-area">
								<label for="cellphone">Celular<span
									style="color: #ff0000; margin-left: 5px;">*</span></label> <input
									class="form-control" id="cellphone"
									placeholder="Ex: (11) 9 99885-9944" />
							</div>
						</div>
						<!-- <div class="row sex-area">
  					<label for="sex">Sexo<span style="color: #ff0000; margin-left: 5px;">*</span></label>
  					<div class="sex-inputs">
  						<div>
  							<input type="radio" id="sex" />
	  						<span style="margin-left: 10px;">Masculino</span>
  						</div>
  						<div>
  							<input type="radio" id="sex" />
	  						<span style="margin-left: 10px;">Feminino</span>
  						</div>
	  				</div>
	  			</div> -->
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
	
	<script src="../../js/index.js"></script>
</body>
</html>
