window.onload = function() {
	loadLoginView();
}

function loadLoginView() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){ 
		if((xhr.readyState == 4) && (xhr.status == 200)) {
			$('#view').html(xhr.responseText);
		}
	}

	xhr.open("GET", 'login.view', true);
	xhr.send();
}

function doSummary() {
	$('#welcome').text("Welcome " + $('#name').val());
	loadSummaryView();
}

function loadSummaryView() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){ 
		if((xhr.readyState == 4) && (xhr.status == 200)) {
			$('#view').html(xhr.responseText);
			getPostOfTheDay();
		}
	}

	xhr.open("GET", 'summary.view', true);
	xhr.send();
}

function getPostOfTheDay() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){ 
		if((xhr.readyState == 4) && (xhr.status == 200)) {
			let json = JSON.parse(xhr.responseText);
			
			console.log(json);
			
			if(json.copyright == null) {
			    $("#copyright").text("Image Credits: Public Domain");
			}
			else {
			    $("#copyright").text("Image Credits: " + json.copyright);
			}
			  
			if(json.media_type == "video") {
				$("#nasa_image").css("display", "none"); 
			    $("#nasa_video").attr("src", json.url);
			}
			else {
			    $("#nasa_video").css("display", "none"); 
			    $("#nasa_image").attr("src", json.url);
			}
			
			$("#article").text(json.explanation);
			$("#title").text(json.title);
			
		}
	}

	xhr.open("GET", 'https://api.nasa.gov/planetary/apod?api_key=EiQQczwSYMLOQF0Tkib6HuXNpYPw0xnknERRLll5', true);
	xhr.send();
}