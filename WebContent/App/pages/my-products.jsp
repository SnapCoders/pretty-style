<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<script src="js/bootstrap.min.js"></script>
	<title>PrettyStyle</title>
</head>
<body>
	<main>
		<section id="meusPedidos" class="">
			<div id="titleLine">
				<h3>Meus Pedidos</h3>
				<hr class="my-4">
			</div>
			<div class="jumbotron bg-white pd-2rem">
				<div>
					<div class="card mb-3 bd-none">
						<div class="no-gutters row">
							<div class="" id="img-produtos">
								<div id="square-img">
									<img src="jbl.jpg" class="img-fluid" alt="...">
								</div>
							</div>
							<div class="wd-82">
								<div class="row pd-2">
									<div class="col-5 hg-35">
										<h5 class="card-title title-h5">JBL Flip 3 Portable</h5>
									</div>
									<div class="col-4 hg-35 mtop-1">
										<div class="estrelas">
											<input type="radio" id="cm_star-empty" name="fb" value=""
												checked /> <label for="cm_star-1"><i class="fa"></i></label>
											<input type="radio" id="cm_star-1" name="fb" value="1" /> <label
												for="cm_star-2"><i class="fa"></i></label> <input
												type="radio" id="cm_star-2" name="fb" value="2" /> <label
												for="cm_star-3"><i class="fa"></i></label> <input
												type="radio" id="cm_star-3" name="fb" value="3" /> <label
												for="cm_star-4"><i class="fa"></i></label> <input
												type="radio" id="cm_star-4" name="fb" value="4" /> <label
												for="cm_star-5"><i class="fa"></i></label> <input
												type="radio" id="cm_star-5" name="fb" value="5" />
										</div>
									</div>
									<div class="col-3 hg-35 mtop-1">
										<p class="fsize-1-2em p-color">
											Preço: <strong>R$: 250,00</strong>
										</p>
									</div>
									<div class="col-5 p-color">
										<p>Uma caixa de som com 30 watts de potência.</p>
									</div>
									<div class="col-12">
										<div id="img-status-2">
											<div class="corpo">
												<div class="step-all" style="margin-left: 0;">
													<p class="step-name">
														Pedido <br>Realizado
													</p>
													<div class="step">
														<p class="step-number">1</p>
													</div>
												</div>
												<div class="step-all">
													<p class="step-name">
														Aprovação<br>de pagamento
													</p>
													<div class="step">
														<p class="step-number">2</p>
													</div>
												</div>
												<div class="step-all">
													<p class="step-name">
														Produto(s) em<br>transporte
													</p>
													<div class="step">
														<p class="step-number">3</p>
													</div>
												</div>
												<div class="step-all">
													<p class="step-name">
														Produto(s)<br>entregue(s)
													</p>
													<div class="step">
														<p class="step-number">4</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<hr class="my-4">
					<div class="card mb-3 bd-none">
						<div class="no-gutters row">
							<div class="" id="img-produtos">
								<div id="square-img">
									<img src="jbl.jpg" class="img-fluid" alt="...">
								</div>
							</div>
							<div class="wd-82">
								<div class="row pd-2">
									<div class="col-5 hg-35">
										<h5 class="card-title title-h5">JBL Flip 3 Portable</h5>
									</div>
									<div class="col-4 hg-35 mtop-1">
										<div class="estrelas">
											<input type="radio" id="cm_star-empty" name="fb" value=""
												checked /> <label for="cm_star-1"><i class="fa"></i></label>
											<input type="radio" id="cm_star-1" name="fb" value="1" /> <label
												for="cm_star-2"><i class="fa"></i></label> <input
												type="radio" id="cm_star-2" name="fb" value="2" /> <label
												for="cm_star-3"><i class="fa"></i></label> <input
												type="radio" id="cm_star-3" name="fb" value="3" /> <label
												for="cm_star-4"><i class="fa"></i></label> <input
												type="radio" id="cm_star-4" name="fb" value="4" /> <label
												for="cm_star-5"><i class="fa"></i></label> <input
												type="radio" id="cm_star-5" name="fb" value="5" />
										</div>
									</div>
									<div class="col-3 hg-35 mtop-1">
										<p class="fsize-1-2em p-color">
											Preço: <strong>R$: 250,00</strong>
										</p>
									</div>
									<div class="col-5 p-color">
										<p>Uma caixa de som com 30 watts de potência.</p>
									</div>
									<div class="col-12">
										<div id="img-status-2">
											<div class="corpo">
												<div class="step-all" style="margin-left: 0;">
													<p class="step-name">
														Pedido <br>Realizado
													</p>
													<div class="step">
														<p class="step-number">1</p>
													</div>
												</div>
												<div class="step-all">
													<p class="step-name">
														Aprovação<br>de pagamento
													</p>
													<div class="step">
														<p class="step-number">2</p>
													</div>
												</div>
												<div class="step-all">
													<p class="step-name">
														Produto(s) em<br>transporte
													</p>
													<div class="step">
														<p class="step-number">3</p>
													</div>
												</div>
												<div class="step-all">
													<p class="step-name">
														Produto(s)<br>entregue(s)
													</p>
													<div class="step">
														<p class="step-number">4</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
</body>
</html>