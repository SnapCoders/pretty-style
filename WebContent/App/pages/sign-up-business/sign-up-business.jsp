<%@ page import="java.util.ArrayList"%>

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
		
		<title>Pretty Style - Criar Conta Business</title>
    	
		<link rel="stylesheet" href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../lib/sweetalert/sweetalert.css">
		
		<link rel="stylesheet" href="../../styles/index.css">
		<link rel="stylesheet" href="../../styles/header.css">
    	
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../components/header.jsp" />
		<div class="container">
			<div class="sign-up-business-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Seja cliente Pretty Style</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="navigation">
			  				<label onclick="window.location.href = '../sign-up-simple/sign-up-simple.jsp'">Simples</label>
			  				<hr style="width: 30px;" />
			  				<label class="active">Business</label>
			  			</div>
			  			<div class="col-md-12 content">
			  				<form action="/PrettyStyle/users" method="POST" name="add-user-business">
				  				<div class="row">
				  					<div class="col-md-6 username-area">
					  					<label for="username">Username<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="username" name="username" placeholder="Como você gostaria de ser chamado?" />
					  				</div>
					  				<div class="col-md-6 email-area">
					  					<label for="email">E-mail<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="email" name="email" placeholder="Ex: seuemail@email.com.br" />
					  				</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-6 name-area">
					  					<label for="fantasyName">Nome fantasia<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="fantasyName" name="fantasyName" placeholder="Digite seu primeiro nome" />
					  				</div>
					  				<div class="col-md-6 email-confirmation-area">
					  					<label for="email-confirmation">Confirmação de e-mail<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="email-confirmation" name="emailConfirmation" placeholder="Ex: seuemail@email.com.br" />
					  				</div>
				  				</div>
				  				<div class="row">
				  					<div class="col-md-6 social-reason-area">
					  					<label for="socialReason">Sua razão social<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="socialReason" name="socialReason" placeholder="Digite sua razão social" />
					  				</div>
					  				<div class="col-md-6 password-area">
					  					<label for="password">Senha<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="password" name="password" placeholder="Digite sua senha" />
					  				</div>
				  				</div>
								<div class="row">
									<div class="col-md-6 cnpj-area">
					  					<label for="cnpj">CNPJ<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="cnpj" name="cnpj" placeholder="Ex: 12.345.678./1234-85" />
					  				</div>
					  				<div class="col-md-6 contact-area">
					  					<label for="contact">Contato<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="contact" name="contact" placeholder="Ex: contato@email.com.br" />
					  				</div>
								</div>
								<div class="row">
									<div class="col-md-6 telephone-area">
					  					<label for="telephone">Telefone Fixo<span style="color: #AAA; margin-left: 5px;">(Opcional)</span></label>
					  					<input class="form-control" id="telephone" name="telephone" placeholder="Ex: (11) 9988-9944" />
				 					</div>
					  				<div class="col-md-6 cellphone-area">
					  					<label for="cellphone">Celular<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="cellphone" name="cellphone" placeholder="Ex: (11) 99885-9944" />
					  				</div>
								</div>
					  			<div class="row button-area">
				  					<button type="submit" >CRIE SEU CADASTRO</button>
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
		<script src="../../lib/mask/jquery.mask.js"></script>
		
		<script src="script.js"></script>
	</body>
</html>
