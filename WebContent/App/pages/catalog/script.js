
function handleFilterCategory(name) {
	let filter = $('#lblFilter').val();
	
	window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByCategory&filter='+filter+'&categories='+name;
	
};

function handleFilterCategoryAndNumberPage(page) {
	let filter = $('#lblFilter').val();
	
	console.log(page);
	
	window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByCategory&filter='+filter+'&numberPage='+page;      
	
};