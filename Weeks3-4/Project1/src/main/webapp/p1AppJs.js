/**
 * 
 */

window.onload = function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#loginNav').on('click', loadLoginView);
	$('#signUpNav').on('click', loadSignUpView);
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
			$('#gg').on('click', loadLoggedInView);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();	
}

function loadLoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#submitLogin').on('click', loadLoggedInView);
		}
	}
	xhr.open("GET", "login.view", true);
	xhr.send();	
}

function loadSignUpView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#submitLogin').on('click', loadLoggedInView);
		}
	}
	xhr.open("GET", "signUp.view", true);
	xhr.send();	
}

function loadLoggedInView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			console.log('hello stranger');
		}
	}
	xhr.open("GET", "loggedIn.view", true);
	xhr.send();	
}


//function getUser(){
//	//send request to /genres
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			console.log(xhr.responseText);
//			let user = JSON.parse(xhr.responseText);
//			for(let g of genres){
//				appendToGenreList(g);
//			}
//		}
//	}
//	xhr.open("GET", "genres");
//	xhr.send();
//}
//
//function appendToGenreList(g){
//	var li = $(`<li>${g.name}</li>`);
//	$('#genreList').append(li);
//}
//
//
//function addGenre(){
//	
//	var genre = $('#newGenre').val();
//	var obj = {
//			name: genre
//	};
//	var toSend = JSON.stringify(obj);
//	
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4){
//			console.log(xhr.status);
//			console.log(xhr.responseText);
//			console.log(xhr.responseType);
//			appendToGenreList(obj);
//		}
//	}
//	xhr.open("POST", "genres");
//	xhr.setRequestHeader("Content-Type", "application/json");
//	xhr.send(toSend);
//
//}
//
//function loadAuthorView(){
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			//do things w response
//			$('#view').html(xhr.responseText);
//		}
//	}
//	xhr.open("GET", "author.view", true);
//	xhr.send();	
//}