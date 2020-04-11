var slideIndex = 1;
showSlides(slideIndex);

setInterval(function() { currentSlide(slideIndex+1); }, 5000);

function plusSlides(n) {
	showSlides(slideIndex += n);
}

function currentSlide(n) {
	showSlides(slideIndex = n);
}

function showSlides(n) {
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");
	if (n > slides.length) {slideIndex = 1}    
	if (n < 1) {slideIndex = slides.length}
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";  
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active-slide", "");
	}
	slides[slideIndex-1].style.display = "block";  
	dots[slideIndex-1].className += " active-slide";
}

document.addEventListener('DOMContentLoaded', function() {
	let stars = document.querySelectorAll('.star');
	stars.forEach(function(star) {
		star.addEventListener('click', setRating);
	});

	let rating = parseInt(document.querySelector('.stars').getAttribute('data-rating'));
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
		
		if (star === span) {
			match = true;
			num = index + 1;
		}
	});
	document.querySelector('.stars').setAttribute('data-rating', num);
}
