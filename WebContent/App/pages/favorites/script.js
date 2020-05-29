document.addEventListener('DOMContentLoaded', function() {
	let products = document.querySelectorAll('.product-info');
	
	products.forEach(function (product) {
		let stars = product.querySelectorAll('.star');
		
		stars.forEach(function(star) {
			star.addEventListener('click', function (ev) {
				let span = ev.currentTarget;
				
				let stars = this.parentElement.querySelectorAll('.star');
				let match = false;
				let num = 0;
				
				stars.forEach(function(star, index) {
					if (match) star.classList.remove('rated');
					else star.classList.add('rated');
					
					if (star === span) {
						match = true;
						num = index + 1;
					}
				});
				
				this.parentElement.setAttribute('data-rating', num);
			});
		});
		
		let rating = parseInt(product.querySelector('.stars').getAttribute('data-rating'));
		let target = stars[rating - 1];
	});
});

function handleDeleteFavorite(id, idProduct) {

	var title = 'Atenção!';
	var question = 'Deseja realmente excluir este registro?';
	var url = '/PrettyStyle/controller.do?path=favorites&command=DeleteFavorite&json=true&id_favorite&id_cpl=' + id +'&id_product='+idProduct;
	var type = 'warning';
	var method = 'delete';

	AlertaAvisoConfirm(title, question, url, type, method);
};
