window.onload = function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#getStarWarsPeopleNav').on('click', loadStarWars);

}

function loadHomeView(){
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

function loadStarWars(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
			loadStarWarsTable();
		}
	}
	xhr.open("GET", "star_wars.view", true);
	xhr.send();	
}

function loadStarWarsTable(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var data  = JSON.parse(xhr.responseText);
			
			for(var i = 0; i < 10; i++){
				$('#star_wars_table').append(`<tr><td>${data['results'][i]['name']}</td></tr>`);
			}
		}
	}
	xhr.open("GET", "https://swapi.co/api/people");
	xhr.send();
}