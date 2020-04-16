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
    
		<link rel="stylesheet" href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../lib/sweetalert/sweetalert.css">

		<link rel="stylesheet" href="../../styles/index.css">
		<link rel="stylesheet" href="../../styles/header.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<%
  			MarkService ms = new MarkService();
  			
  			request.setAttribute("marks", ms.list());
  		%>
		<c:import url="../../components/header.jsp" />
		<div class="container">
			<div class="login-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Acessar área do cliente</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
			  				<form action="/PrettyStyle/sessions" method="POST" name="login">
				  				<div class="row username-area">
				  					<label for="username">Username ou E-mail<span style="color: #ff0000; margin-left: 5px;">*</span></label>
				  					<input class="form-control" id="username" name="username" placeholder="Seu usuário de acesso ou e-mail" />
				  				</div>
				  				<div class="row password-area">
				  					<label for="password">Senha<span style="color: #ff0000; margin-left: 5px;">*</span></label>
				  					<a href="#" class="forgot-your-password">Esqueceu sua senha?</a>
				  					<input type="password" class="form-control" id="password" name="password" placeholder="Sua senha secreta" />
				  				</div>
				  				<div class="row button-area">
				  					<button type="submit">ENTRAR</button>
				  				</div>
				 					<hr>
				  				<div class="row new-client-area">
				  					<span style="margin-right: 10px;">Não é cliente?</span>
				  					<a href="#">Torne-se um cliente</a>
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
	
		<script src="script.js"></script>
	</body>
</html>
