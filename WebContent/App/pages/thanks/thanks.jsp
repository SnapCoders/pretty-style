<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="/PrettyStyle/favicon.ico" type="image/x-icon" />

		<title>Pretty Style - Obrigado!</title>
    
		<link rel="stylesheet" href="../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../lib/sweetalert/sweetalert.css">

		<link rel="stylesheet" href="../../styles/index.css">
		<link rel="stylesheet" href="../../styles/header.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../components/header.jsp" />
		<div class="container">
			<div class="thanks-container">
				<div class="container">
					<div class="col-sm-12 header">
			  			<div class="row">
							<div class="col-md-3 cartDiv">
								<div class="myCart active">
									Meu carrinho
									<img src="../../assets/icons/check.svg" alt="Check">
								</div>
							</div>
							<div class="col-md-3 identityDiv">
								<div class="identity active">
									Identificação
									<img src="../../assets/icons/check.svg" alt="Check">
								</div>
							</div>
							<div class="col-md-3 paymentDiv">
								<div class="payment active">
									Pagamento
									<img src="../../assets/icons/check.svg" alt="Check">
								</div>
							</div>
							<div class="col-md-3 thankyouDiv">
								<div class="thankyou active">
									Obrigado!
									<img src="../../assets/icons/check.svg" alt="Check">
								</div>
							</div>
						</div>
						<hr />
			  		</div>
					<div class="jumbotron main">
						<div class="col-md-12 content">
							<div class="row thanks-msg">
								<h3>Obrigado por efetuar sua compra na PrettyStyle!</h3>
							</div>
							<div class="row thanks-received">
								<img src="../../assets/icons/large-check.svg" alt="Check">
								<label>Recebemos seu pedido.</label>
							</div>
							<div class="row thanks-client">
								<label>Olá, ${clientName} ${clientSurname}.</label>
							</div>
							<div class="row thanks-paragraph">
								<p>Agradecemos sua preferência pelo PrettyStyle!</p>
								<br />
								<p>A partir de agora, você será informado(a) por e-mail sobre o andamento do seu pedido até a chegada no endereço escolhido.</p>
							</div>
							<div class="row thanks-number-request">
								<span>Número do seu pedido</span>
								<label>${numberRequest}</label>
							</div>
							<div class="row thanks-steps">
								<div class="row steps">
									<div class=" col-md-12 request-steps">
										<div class="step checked">
											<label>Pedido Realizado</label>
											<span>1</span>
											<img src="../../assets/icons/large-check.svg" alt="Check">
										</div>
										<div class="step">
											<label>Aprovação de pagamento</label>
											<span>2</span>
											<img src="../../assets/icons/large-check.svg" alt="Check">
										</div>
										<div class="step">
											<label>Produto(s) em transporte</label>
											<span>3</span>
											<img src="../../assets/icons/large-check.svg" alt="Check">
										</div>
										<div class="step">
											<label>Produto(s) Entregue(s)</label>
											<span>4</span>
											<img src="../../assets/icons/large-check.svg" alt="Check">
										</div>
									</div>
									<hr />
								</div>
							</div>
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
	</body>
</html>
