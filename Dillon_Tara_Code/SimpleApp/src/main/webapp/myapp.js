window.onload = function() {
	loadHomeView();
	$('#runFilm').on('click', loadFilms);
	$('#runPlanet').on('click', loadPlanets);
	
}

function loadHomeView(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){

			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();	
}
		


function loadFilms(){
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200 ){
            console.log(xhr.responseText);
             film = JSON.parse(xhr.responseText);
            $('#filmOutput').html(JSON.parse(xhr.responseText).name);
        }
    }
    var id = $('#filmInput').val();
    var url = `https://swapi.co/api/films/${id}/`;
    xhr.open('GET', url, true);
    xhr.send(); 
    console.log("SENT REQUEST " + xhr.responseText); 
}

function loadPlanets(){
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200 ){
            console.log(xhr.responseText);
             planet = JSON.parse(xhr.responseText);
            $('#planetOutput').html(JSON.parse(xhr.responseText).name);
        }
    }
    var id = $('#planetInput').val();
    var url = `https://swapi.co/api/planets/${id}/`;
    xhr.open('GET', url, true);
    xhr.send(); 
    console.log("SENT REQUEST " + xhr.responseText); 
}
	