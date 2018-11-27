window.onload = function() {
	// loadHomeView();
	loadLoginView();
	$('#loginNav').on('click', loadLoginView);
	$('#homeNav').on('click', loadHomeView);
	$('#SubmitNav').on('click', loadStatusView);
	$('#StatusNav').on('click', loadSubmitionView);
}
/** ***************************************************************************** */
function loadLoginView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			$('#view').html(xhr.responseText);
			$('#btnLogin').on('click', validateUser);

		}
	}
	xhr.open("GET", "login.view", true);
	xhr.send();
}
function validateUser() {
	var obj = {
		username : $('input[name=username]').val(),
		password : $('input[name=password]').val()
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/json");
	var toSend = JSON.stringify(obj);
	console.log(toSend);
	xhr.send(toSend);
}
/** ***************************************************************************** */

function loadHomeView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#btnReimb').on('click', addReimbursement)
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
}
function addReimbursement() {

	var obj = {
		amount : $('input[name=amount]').val(),
		typeId : $('input[name=subType').val(),
		description : $('input[name=reimbDescription]').val()
	};

	console.log(obj);
	var toSend = JSON.stringify(obj);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			console.log(xhr.status);
			console.log(xhr.responseText);
			console.log(xhr.responseType);
			//appendToReimbursementsList(obj);
		}
	}
	xhr.open("POST", "reimbursement");
	xhr.setRequestHeader("Content-Type", "application/json");
	console.log(toSend);
	xhr.send(toSend);
}

/** ***************************************************************************** */
function loadStatusView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			// $('#CurrentStatus').on('click',findStatus);
			// findStatus();
		}
	}
	xhr.open("GET", "status.view", true);
	xhr.send();
}
function loadSubmitionView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "status.view", true);
	xhr.send();

}
/*
function appendToReimbursementList() {
	var li = $(`<li>${reimb.amount}</li>`);
	$('#reimbursementList').append(li);

}
/** ***************************************************************************** */
function loadManagerView() {
	var xr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.ready == 4) {
			console.log(xhr.status)
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "manager.view", true);
	xhr.send();
}
function getReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let genres = JSON.parse(xhr.responseText);
			for(let r of reimbursements){
				appendToReimbursementsList(r);
			}
		}
	}
	xhr.open("GET", "manager");
	xhr.send();
}

function appendToReimbursementsList(r){
	var li = $(`<li>${g.name}</li>`);
	$('#genreList').append(li);
}
/** ***************************************************************************** */
