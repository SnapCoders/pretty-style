<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>
<html lang="pt-br">
	<head>
	  <meta charset="utf-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	
	  <title>Pretty Style</title>
	</head>
	<body>
		<div class="cadastro-simples-container">
		  	<div class="container">
		  		<div class="col-md-12">
		  			<div class="row">
			  			<div class="col-md-3">
			  				<label>Seja cliente PrettyStyle</label>
			  			</div>
			  			<div class="col-md-9">
			  				<hr>
			  			</div>
		  			</div>
		  		</div>
		  		<div class="jumbotron main">
		  			<div class="col-md-12 content">
		  				<div class="row">
		  					<div class="col-md-6 username-area">
			  					<label for="username">Username<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="username" placeholder="Como você gostaria de ser chamado?" />
			  				</div>
			  				<div class="col-md-6 email-area">
			  					<label for="email">E-mail<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="email" placeholder="Ex: seuemail@email.com.br" />
			  				</div>
		  				</div>
		  				<div class="row">
		  					<div class="col-md-6 name-area">
			  					<label for="name">Seu nome<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="name" placeholder="Digite seu primeiro nome" />
			  				</div>
			  				<div class="col-md-6 email-confirmation-area">
			  					<label for="email-confirmation">Confirmação de e-mail<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="email-confirmation" placeholder="Ex: seuemail@email.com.br" />
			  				</div>
		  				</div>
		  				<div class="row">
		  					<div class="col-md-6 surname-area">
			  					<label for="surname">Seu sobrenome<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="surname" placeholder="Digite seu sobrenome" />
			  				</div>
			  				<div class="col-md-6 password-area">
			  					<label for="password">Senha<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="password" placeholder="Digite sua senha" />
			  				</div>
		  				</div>
	  					<div class="row">
	  						<div class="col-md-6 cpf-area">
			  					<label for="cpf">CPF<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="cpf" placeholder="Ex: 123.456.789-85" />
			  				</div>
			  				<div class="col-md-6 birthday-area">
			  					<label for="birthday">Data de nascimento<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="birthday" placeholder="Ex: 01/01/2020" />
			  				</div>
	  					</div>
	  					<div class="row">
	  						<div class="col-md-6 telephone-area">
			  					<label for="telephone">Telefone Fixo<label style="color: #444;">(Opcional)</label></label>
			  					<input class="form-control" id="telephone" placeholder="Ex: (11) 9988-9944" />
			  				</div>
			  				<div class="col-md-6 cellphone-area">
			  					<label for="cellphone">Celular<label style="color: #ff0000;">*</label></label>
			  					<input class="form-control" id="cellphone" placeholder="Ex: (11) 99885-9944" />
			  				</div>
	  					</div>
		  				<div class="row sex-area">
		  					<label for="sex">Sexo<label style="color: #ff0000;">*</label></label>
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
			  			</div>
			  			<div class="row button-area">
		  					<button type="button">CRIE SEU CADASTRO</button>
		  				</div>
		  			</div>
	  			</div>
		  	</div>
		</div> 
	</body>
</html>		 	