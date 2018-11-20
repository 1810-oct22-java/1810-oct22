window.onload = function() {
	
	loadHomeView();
	
	$('#weatherNav').on('click', loadWeatherView);
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

//function loadInfo() {
//	
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//	console.log('Here at loadInfo');
//		if(xhr.readyState == 4 && xhr.status == 200){
//		
//			
//			$('#info').html(xhr.responseText);
//			//getInfo();
//			
//		}
//	}
//	
//
//	
//	var key = '2fb46f89e3b26d0ce703ab2cbf0f72f7';
//	var url = "http://api.openweathermap.org/data/2.5/weather?q=New York&APPID=2fb46f89e3b26d0ce703ab2cbf0f72f7";
//	//var url = `http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID={APIKEY}`;
//    xhr.open("GET", url, true);
//
//	xhr.send();	
//	
//}



function loadWeatherView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
			
			
			$('#showInfo').on('click', addInfo);
		}
	}
	xhr.open("GET", "weather.view", true);
	xhr.send();	
}

function addInfo() {
	
	var city = $('#city').val();
	
	getInfo(city);
	
}

function getInfo(city) {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		
			
		let info = JSON.parse(xhr.responseText);
		let temp = 1.8 * (info.main.temp - 273) + 32;
		$('#cityName').html(`${city}'s current weather`);
		$('#info').html(`Temperature:  ${temp} F degrees <br> Condition: ${info.weather[0].description}`);
		}
	}
	
	var url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&APPID=2fb46f89e3b26d0ce703ab2cbf0f72f7`;
	
	xhr.open("GET", url);
	xhr.send();
}

