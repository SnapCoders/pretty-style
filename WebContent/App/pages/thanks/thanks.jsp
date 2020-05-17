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
		<link rel="stylesheet" href="../../styles/footer.css">
		<link rel="stylesheet" href="../../styles/responsive.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../components/header.jsp" />
		<div id="main-content" class="container">
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
								<div>
									<img src="../../assets/icons/large-check.svg" alt="Check">
									<label>Recebemos seu pedido.</label>
								</div>
								<c:if test="${not empty boletoPDF}">
									<button class="btn btn-sm btn-outline-primary" type="button" data-toggle="modal" data-target="#bank-slip">Visualizar boleto</button>
								</c:if>
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
 		<div class="modal fade" id="bank-slip" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="modalLabel">Visualização do Boleto<label class="lblProductName"></label></h4>
						<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class= col-md-12>
								<img style="width: 100%;" src="${boletoPNG}" alt="Imagem de Boleto">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div style="display: flex; justify-content: space-between; align-items: center;">
							<div>
								<a class="btn btn-primary" target="_blank" data-content-type="application/pdf" data-type="downloadTenPointDocument" href="${boletoPDF}">Imprimir</a>
								<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
 		<c:import url="../../components/footer.jsp" />
		
		<script src="../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../lib/jquery-validation/jquery.validate.min.js"></script>
		<script src="../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../lib/sweetalert/sweetalert.min.js"></script>
		<script src="../../lib/mask/jquery.mask.js"></script>
		
		<script src="scripts.js"></script>
	</body>
</html>
