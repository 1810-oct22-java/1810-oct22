/**
 * 
 */

window.onload = function(){
	loadHomeView();
	$('#booksNav').on('click', loadBooksView);
}

function loadHomeView(){
	/*
	 * AJAX functions can be used to retrieve all types 
	 * of data from a server. Including HTML!
	 * We will send a request to a servlet which will 
	 * forward our desired HTML page as a response, 
	 * then, in the onreadystatechange function, we will 
	 * designate what we would like to do with the response 
	 * as usual -- but in this case, we will apply event listeners
	 * to the new DOM elements
	 */
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();	
}

function loadBooksView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "books.view", true);
	xhr.send();	
}