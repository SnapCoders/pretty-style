<div class="payments-steps-container">
  	<div class="container">
  		<div class="col-sm-12 header">
  			<div class="row">
				<div class="col-md-3 cartDiv">
					<div class="myCart active">
						Meu carrinho
						<img src="App/assets/icons/check.svg" alt="Check">
					</div>
				</div>
				<div class="col-md-3 identityDiv">
					<div class="identity active">
						Identificação
						<img src="App/assets/icons/check.svg" alt="Check">
					</div>
				</div>
				<div class="col-md-3 paymentDiv">
					<div class="payment active">
						Pagamento
						<img src="App/assets/icons/check.svg" alt="Check">
					</div>
				</div>
				<div class="col-md-3 thankyouDiv">
					<div class="thankyou">
						Obrigado!
						<img src="App/assets/icons/check.svg" alt="Check">
					</div>
				</div>
			</div>
			<hr />
  		</div>
  		<div class="jumbotron main">
  			<div class="col-md-12">
  				<div class="row">
  					<div class="col-md-7 column-location">
  						<div class="jumbotron location">
  							<div class="location-header">Endereço de Entrega</div>
  							<div class="location-body">
  								<div class="location-body-content">
  									<label class="location-name">Bruno Amaral Futema</label>
  									<div>
  										<label>Endereço: </label><span>Rua: José Romano, 28</span>
  									</div>
  									<div>
  										<label>Bairro: </label><span>Vila Gomes Cardim</span>
  									</div>
  									<div>
  										<label>Cidade: </label><span>São Paulo</span>
  									</div>
  									<div>
  										<label>Complemento: </label><span>Casa</span>
  									</div>
  									<div>
  										<label>CEP: </label><span>03322-040</span>
  									</div>
  								</div>
  								<div class="location-body-actions">
  									<button type="button">Alterar endereço de entrega</button>
  								</div>
  							</div>
  							<hr />
 								<label>Opções de entrega: </label>
  						</div>
  					</div>
  					<div class="col-md-5 column-resume">
  						<div class="jumbotron resume">
  							<div class="resume-header">Resumo do Pedido</div>
  							<div class="resume-body">
  								<div class="resume-items">
  									<div class="labels">
  										<label>6 produtos</label>
  										<label>Frete</label>
  									</div>
  									<div class="values">
  										<label>R$ 1.320,00</label>
  										<label>R$ 32,15</label>
  									</div>
  								</div>
  								<hr />
  								<div class="resume-total">
  									<div class="labels">
  										<label class="total-of-request">Total:</label>
  									</div>
  									<div class="values">
  										<label class="total-value-of-request">R$ 1.352,15</label>
  										<span class="total-installment">em até 12x sem juros</span>
  										<span class="total-with-discount">R$ 1.284,55 no boleto</span>
  									</div>
  								</div>
  								<hr />
  								<div class="resume-deadline">
  									<div class="labels">
  										<label class="total-of-deadline">Prazo para entrega:</label>
  									</div>
  									<div class="values">
  										<label>15 Dias</label>
  										<span>úteis</span>
  									</div>
  								</div>
  							</div>
  						</div>
  					</div>
  				</div>
  				<hr />
  				<div class="row">
  					<div class="col-md-12">
  						<div class="jumbotron payments-methods">
  							<div class="row header">
  								<label>Formas de pagamento</label>
  							</div>
  							<div class="row methods">
  								<div class="col-md-6 credit-card-div">
  									<div class="credit-card">
	  									<img src="App/assets/icons/credit-card.svg" alt="Cartão de crédito">
	  									<label>Cartão de crédito</label>
	  									<button type="button">Selecione</button>
	  								</div>
  								</div>
  								<div class="col-md-6 bank-slip-div">
  									<div class="bank-slip">
	  									<img src="App/assets/icons/bank-slip.svg" alt="Boleto bancário">
	  									<label>Boleto bancário</label>
	  									<button type="button">Selecione</button>
	  								</div>
  								</div>
  							</div>
  							<hr />
  							<div class="credit-or-bank">
  								<div class="jumbotron credit-card-method">
  									<div class="inputs">
  										<div class="row">
  											<div class="col-md-4">
  												<label for="number-credit-card">Número do cartão</label>
  											</div>
  											<div class="col-md-8">
  												<input class="form-control" id="number-credit-card" />
  											</div>
  										</div>
  										<div class="row">
  											<div class="col-md-4">
  												<label for="printed-name-credit-card">Nome impresso no cartão</label>
  											</div>
  											<div class="col-md-8">
  												<input class="form-control" id="printed-name-credit-card" />
  											</div>
  										</div>
  										<div class="row">
  											<div class="col-md-4">
  												<label for="mounth-shelf-life-credit-card">Validade</label>
  											</div>
  											<div class="col-md-4">
  												<input class="form-control" id="mounth-shelf-life-credit-card" />
  											</div>
  											<div class="col-md-4">
  												<input class="form-control" id="year-shelf-life-credit-card" />
  											</div>
  										</div>
  										<div class="row">
  											<div class="col-md-4">
  												<label for="number-parcels">Parcelar em</label>
  											</div>
  											<div class="col-md-4">
  												<input class="form-control" id="number-parcels" />
  											</div>
  											<div class="col-md-1">
  												<label for="cvv-credit-card">CVV</label>
  											</div>
  											<div class="col-md-3">
  												<input class="form-control" id="cvv-credit-card" />
  											</div>
  										</div>
  									</div>
  									<div class="pay-and-total">
  										<label style="color: #ffffff;">Total: R$ 1.352,15</label>
  										<button type="button">Pagar</button>
  										<label>Total: R$ 1.352,15</label>
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
