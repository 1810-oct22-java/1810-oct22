window.onload = function() {

	$('#jedis').on('click', loadSWViews);
	
	
	
}

function loadSWViews() {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			$('#view').html(xhr.responseText);
			$('#info').on('click', function() {
				
				getInfo();
				loadInfoViews();
				
			});
			
		}
		
	}
	
	xhr.open("GET", "starwars.view", true);
	xhr.send();
	
}

function getInfo() {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {

			let starwars = JSON.parse(xhr.responseText);
			console.log(starwars.name);
			$('#output').html(starwars.name);

       }
   }

	var swtype = $('#dataType').val();
	var typeid = $('#typeID').val();
	var url = `https://swapi.co/api/`+ swtype + `/` + typeid;
	console.log(url);
	xhr.open('GET', url, true);

	xhr.send(); 

}

function loadInfoViews() {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			$('#view').html(xhr.responseText);
			
		}
		
	}
	
	xhr.open("GET", "info.view", true);
	xhr.send();
	
	
}
