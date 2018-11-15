window.onload = function() {
	// start by seeing if the user has logged in
//	checkLogin();
	
	loadUser();
	$('#logoutBtn').on('click', clickLogout);

}

function checkLogin() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			//do things w response
////				$('#view').html(xhr.responseText);
//		}
	}
	xhr.open("POST", "login", true);
	xhr.send();	
}

function clickLogout() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	}
	xhr.open("GET", "logout", true);
	xhr.send();	
}

var user_id = null;
var role_name = null;
function loadUser() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let json = JSON.parse(xhr.responseText);
			user_id = json.employee_id;
			role_name = json.role_name;
			
			if(json.role_name == "Administrator") {
				buildHeader(json.first_name, json.last_name);
				$('#adminNav').show();
				$('#managerNav').show();
				$('#employeeNav').show();
		    	buildAdmin();
		    }
			else if(json.role_name == "Manager") {
				buildHeader(json.first_name, json.last_name);
				$('#adminNav').hide();
				$('#managerNav').show();
				$('#employeeNav').show();
			}
			else if(json.role_name == "Employee") {
				buildHeader(json.first_name, json.last_name);
				$('#adminNav').hide();
				$('#managerNav').hide();
				$('#employeeNav').show();
		    }
			
		}
	}
	xhr.open("GET", "employee");
	xhr.send();	
}

function buildHeader(first_name, last_name) {
	$('#WelcomeText').html(`Welcome, ${first_name} ${last_name}` );	
	$('#logoutBtn').show();
}

function buildAdmin() {
	
}

