/**
 * 
 */

window.onload = function(){
	loadHomeView();
	//$('#booksNav').on('click',loadBooksView);
}
function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET","home.view",true);
	xhr.send();
}