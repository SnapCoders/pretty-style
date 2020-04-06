<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="../styles/catalog-myproducts-thanks.css" rel="stylesheet">
	<link rel="stylesheet"
		href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <script src="../lib/bootstrap/js/bootstrap.min.js"></script>
	<title>PrettyStyle</title>
</head>
<body>
	<main>
		<section>
			<div id="titleLine">
				<p id="bt-p">notebook odyssey 2</p>
			</div>
			<div style="display: flex" class='row'>
				<div class="jumbotron bg-white col-2" id="mg-catalogo"
					style="border: 1px solid #707070">
					<p>Categorias</p>
					<hr>
					<div style="display: flex">
						<label class="chk"> <input type="checkbox" name="exemplo" />
							<span id="span-check"> <span id="span-color"></span>
						</span>
						</label>
						<p class="item-category">Masculino</p>
					</div>
					<div style="display: flex">
						<label class="chk"> <input type="checkbox" name="exemplo" />
							<span id="span-check"> <span id="span-color"></span>
						</span>
						</label>
						<p class="item-category">Feminino</p>
					</div>
					<div style="display: flex">
						<label class="chk"> <input type="checkbox" name="exemplo" />
							<span id="span-check"> <span id="span-color"></span>
						</span>
						</label>
						<p class="item-category">Acessórios</p>
					</div>
					<div style="display: flex">
						<label class="chk"> <input type="checkbox" name="exemplo" />
							<span id="span-check"> <span id="span-color"></span>
						</span>
						</label>
						<p class="item-category">Pets</p>
					</div>

				</div>
				<div class="jumbotron bg-white col-9 border-jumbo">
					<div class="row row-cols-4 row-cols-md-4">
						<div class="col mb-4">
							<div class="card card-style">
								<div class="div-img">
									<img src="/jbl.jpg" class="img-fluid" alt="..."
										style="height: 100%;">
								</div>
								<div class="card-body pb-0">
									<h5 class="fsize-1-1em p-color">JBL Flip 3 Portable</h5>
									<p class="card-text" id="bt-p">Caixinha de som portátil da
										JBL.</p>
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
									<p>
										<strong>R$ 250,00</strong>
									</p>
								</div>
							</div>
						</div>
						<div class="col mb-4">
							<div class="card card-style">
								<div class="div-img">
									<img src="/jbl.jpg" class="img-fluid" alt="..."
										style="height: 100%;">
								</div>
								<div class="card-body pb-0">
									<h5 class="fsize-1-1em p-color">JBL Flip 3 Portable</h5>
									<p class="card-text" id="bt-p">Caixinha de som portátil da
										JBL.</p>
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
									<p>
										<strong>R$ 250,00</strong>
									</p>
								</div>
							</div>
						</div>
						<div class="col mb-4">
							<div class="card card-style">
								<div class="div-img">
									<img src="/jbl.jpg" class="img-fluid" alt="..."
										style="height: 100%;">
								</div>
								<div class="card-body pb-0">
									<h5 class="fsize-1-1em p-color">JBL Flip 3 Portable</h5>
									<p class="card-text" id="bt-p">Caixinha de som portátil da
										JBL.</p>
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
									<p>
										<strong>R$ 250,00</strong>
									</p>
								</div>
							</div>
						</div>
						<div class="col mb-4">
							<div class="card card-style">
								<div class="div-img">
									<img src="/jbl.jpg" class="img-fluid" alt="..."
										style="height: 100%;">
								</div>
								<div class="card-body pb-0">
									<h5 class="fsize-1-1em p-color">JBL Flip 3 Portable</h5>
									<p class="card-text" id="bt-p">Caixinha de som portátil da
										JBL.</p>
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
									<p>
										<strong>R$ 250,00</strong>
									</p>
								</div>
							</div>
						</div>
						<div class="col mb-4">
							<div class="card card-style">
								<div class="div-img">
									<img src="/jbl.jpg" class="img-fluid" alt="..."
										style="height: 100%;">
								</div>
								<div class="card-body pb-0">
									<h5 class="fsize-1-1em p-color">JBL Flip 3 Portable</h5>
									<p class="card-text" id="bt-p">Caixinha de som portátil da
										JBL.</p>
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
									<p>
										<strong>R$ 250,00</strong>
									</p>
								</div>
							</div>
						</div>
						<div class="col mb-4">
							<div class="card card-style">
								<div class="div-img">
									<img src="/jbl.jpg" class="img-fluid" alt="..."
										style="height: 100%;">
								</div>
								<div class="card-body pb-0">
									<h5 class="fsize-1-1em p-color">JBL Flip 3 Portable</h5>
									<p class="card-text" id="bt-p">Caixinha de som portátil da
										JBL.</p>
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
									<p>
										<strong>R$ 250,00</strong>
									</p>
								</div>
							</div>
						</div>
						<div class="col mb-4">
							<div class="card card-style">
								<div class="div-img">
									<img src="/jbl.jpg" class="img-fluid" alt="..."
										style="height: 100%;">
								</div>
								<div class="card-body pb-0">
									<h5 class="fsize-1-1em p-color">JBL Flip 3 Portable</h5>
									<p class="card-text" id="bt-p">Caixinha de som portátil da
										JBL.</p>
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
									<p>
										<strong>R$ 250,00</strong>
									</p>
								</div>
							</div>
						</div>
						<div class="col mb-4">
							<div class="card card-style">
								<div class="div-img">
									<img src="/jbl.jpg" class="img-fluid" alt="..."
										style="height: 100%;">
								</div>
								<div class="card-body pb-0">
									<h5 class="fsize-1-1em p-color">JBL Flip 3 Portable</h5>
									<p class="card-text" id="bt-p">Caixinha de som portátil da
										JBL.</p>
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
									<p>
										<strong>R$ 250,00</strong>
									</p>
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