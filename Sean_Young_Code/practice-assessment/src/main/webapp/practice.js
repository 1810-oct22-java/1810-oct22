
window.onload = function(){
	loadNext();
	$('#features').on('click', loadFeatures);
	$('#home').on('click', loadNext);
	$('#pricing').on('click', loadPricing);
	$('#submit').on('click', forceBe);
}
function loadPricing(){
	var xhr = new XMLHttpRequest()
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "pricing.view", true);
	xhr.send();
}
function loadNext(){
	var xhr = new XMLHttpRequest()
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#submit').on('click', forceBe);
		}
	}
	xhr.open("GET", "next.view", true);
	xhr.send();
}

function forceBe(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			globalperson = JSON.parse(xhr.responseText);
			$('#output').html(JSON.parse(xhr.responseText).name);
		}
		
	}
	var id = $('#apiId').val();
	var url = `https://swapi.co/api/starships/${id}/`;
	xhr.open('GET', url, true);
	xhr.send();
}


function loadFeatures(){
	var xhr = new XMLHttpRequest()
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "features.view", true);
	xhr.send();
}