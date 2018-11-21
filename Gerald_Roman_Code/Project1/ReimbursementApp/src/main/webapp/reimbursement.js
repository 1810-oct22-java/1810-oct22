/**
 * 
 */

window.onload = function() {
	loadLogInView();
	//loadHomeView();
	//loadEmployeeView();
	//loadManagerView();
	
	
	$('#loginNav').on('click', loadLogInView);
	$('#homeNav').on('click', loadHomeView);
}
function loadLogInView() {
	var obj = {
		Username: $('usename').val(),
		Password: $('pasword').val()
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#btnLogin').on('click',loadHomeView);
		}
	}
	xhr.open("POST", "UserServlet", true);
	xhr.setRequestHeader("Content-type","application/json")
	xhr.send(JSON.stringify(obj));
}

function loadHomeView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			//$('#btnLogin').on('click',loadLogInView);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
}
function addSub(){
	var submittion = $('#newReimbursement').val();
	var obj = {
			name: submittion
	};
	var toSend = JSON.stringify(obj);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log(xhr.status);
			console.log(xhr.responseText);
			console.log(xhr.responseType);
			appendToSubmitionList(obj);
		}
	}
	xhr.open("POST", "submittion");
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(toSend);

}
function loadEmployeeView(){
	
}
function loadManagerView(){
	
}