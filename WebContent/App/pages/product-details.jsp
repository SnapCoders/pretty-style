<div class="product-details-container">
	<div class="container">
		<div class="col-md-12 header">
			<div class="row content">
				<div class="title">
					<label>Detalhes do produto</label>
				</div>
				<div class="line">
					<hr />
				</div>
			</div>
		</div>
		<div class="jumbotron main">
			<div class="col-md-12 content">
				<div class="row">
					<div class="col-md-5">
						<div class="product-photo-area">
							<img src="App/assets/icons/arrow-left.svg" alt="Arrow left" class="arrow-left">
							<div class="jumbotron product-photo">
								<img src="App/assets/img/jbl.png" alt="JBL Flip 3">
								<div class="next-circles">
									<div class="circle-next active"></div>
									<div class="circle-next"></div>
									<div class="circle-next"></div>
								</div>
							</div>
							<img src="App/assets/icons/arrow-right.svg" alt="Arrow right" class="arrow-right">
						</div>
					</div>
					<div class="col-md-7">
						<div class="product-details-area">
							<div class="row product-title">
								<div class="product-info">
									<label>JBL Flip 3 Portable</label>
									<span class="product-description">Uma caixa de som com 30 watts de potência.</span>
									<div class="stars">
										<span class="star yellow-star">&nbsp;</span>
										<span class="star yellow-star">&nbsp;</span>
										<span class="star yellow-star">&nbsp;</span>
										<span class="star yellow-star">&nbsp;</span>
										<span class="star gray-star">&nbsp;</span>
									</div>
								</div>
								<div class="like-product">
									<div class="favorite">
								        <div class="favorite-icon">
								        	<img src="App/assets/icons/heart.svg">
							        	</div>
									</div>
								</div>
							</div>
							<div class="row product-price">
								<div class="price">
									<span>Preço: </span>
									<label>R$ 250,00</label>
									<div class="quantity">
										<span>Quantidade: </span>
										<select class="form-control">
											<option value="0">--</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
										</select>
									</div>
								</div>
								<div class="freight">
									<span>Calcular frete e prazo</span>
									<div class="freight-and-deadline">
										<input class="form-control" placeholder="digite o cep" />
										<button type="button">OK</button>
									</div>
								</div>
							</div>
							<hr style="margin-top: 25px; margin-bottom: 25px;" />
							<div class="row product-info-more">
								<span>Mais informações</span>
								<span>Este produto é vendido e entregue por <a href="#" style="color: #0E9AEF; font-weight: bold;">Pretty Style</a></span>
							</div>
							<div class="row button-area">
								<button type="button">COMPRAR</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	//initial setup
	document.addEventListener('DOMContentLoaded', function() {
		let stars = document.querySelectorAll('.star');
		stars.forEach(function(star) {
			star.addEventListener('click', setRating);
		});

		let rating = parseInt(document.querySelector('.stars').getAttribute(
				'data-rating'));
		let target = stars[rating - 1];
		target.dispatchEvent(new MouseEvent('click'));
	});

	function setRating(ev) {
		let span = ev.currentTarget;
		let stars = document.querySelectorAll('.star');
		let match = false;
		let num = 0;
		stars.forEach(function(star, index) {
			if (match) {
				star.classList.remove('rated');
			} else {
				star.classList.add('rated');
			}
			//are we currently looking at the span that was clicked
			if (star === span) {
				match = true;
				num = index + 1;
			}
		});
		document.querySelector('.stars').setAttribute('data-rating', num);
	}
</script>
