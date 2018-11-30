window.onload = function() {
	// loadHomeView();
	loadLoginView();
	$('#loginNav').on('click', loadLoginView);
	$('#homeNav').on('click', loadHomeView);
	$('#StatusNav').on('click', loadAuthorView);
	$('#SubmitNav').on('click', loadSubmitionView);
	
	/*
	 * $('#loginNav').on('click', loadLoginView); $('#homeNav').on('click',
	 * loadHomeView); $('#SubmitNav').on('click', loadAuthorView)
	 * $('#StatusNav').on('click', loadStatusView);
	 * //$('#ManagerNav').on('click', loadSubmitionView);
	 * $('#ManagerNav').on('click',loadManagerView);
	 */
}
/** ***************************************************************************** */
function loadLoginView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			$('#view').html(xhr.responseText);
			// $('#login').html(xhr.responseText);
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
	// xhr.open("GET", "home.view", true);
	xhr.open("GET", "employee.view", true);
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
			// appendToReimbursementsList(obj);
		}
	}
	xhr.open("POST", "reimbursement",true);
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
 * *****************************************************************************
 */
function loadManagerView() {
	console.log("before xhr");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.status)
			console.log("inside manager")
			$('#view').html(xhr.responseText);
			// $('#loadAllReimbursements').on('click',getReimbursements)
			getReimbursements();
		}
	}
	xhr.open("GET", "manager.view", true);
	xhr.send();
}
function getReimbursements(){
	console.log("inside getReimb");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let reimbursements = JSON.parse(xhr.responseText);
			for(let r of reimbursements){
				appendToReimbursementsList(r);
			}
		}
	}
	xhr.open("GET", "manager");
	// xhr.open("GET", "reimbursement");
	xhr.send();
}

function appendToReimbursementsList(r){
	var table = $(`<tr>
				<th scope="col">Id</th>
							
				<td>${r.amount}</th>
				<td>${r.submitted}</th>
				<td>${r.resolved}</th>
				<td>${r.description}</th>
				<td>${r.author}</th>
				<td>${r.resolver}</th>
				<td>${r.statusId}</th>
				<td>${r.type}</th>
				<td>Approve/Deny</th>
				</tr>
				`)
	$('#managerReimbursementList').append(table);
}
/** ***************************************************************************** */

function loadAuthorView() {
	console.log("before xhr in status");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.status)
			console.log("inside status")
			$('#view').html(xhr.responseText);
			getAuthorReimbursements();
		}
	}
	xhr.open("GET", "status.view", true);
	xhr.send();
}
function getAuthorReimbursements(){
	console.log("inside getAuthor");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let reimb = JSON.parse(xhr.responseText);
			for(let r of reimb){
				appendAuthorReimbursementsList(r);
			}
		}
	}
	xhr.open("GET", "manager");
	xhr.send();
}

function appendAuthorReimbursementsList(r){
	var table = $(`<tr>
				<th scope="col">id</th>
							
				<td>${r.amount}</td>
				<td>${r.submitted}</td>
				<td>${r.resolved}</td>
				<td>${r.description}</td>
				<td>${r.author}</td>
				<td>${r.resolver}</td>
				<td id = "statusId${r.id}">${r.statusId}</td>
				<td>${r.type}</td>
				<td>
				<button class="btn btn-primary" onclick="updateStatus(${r.id},0)">Denied</button>
				<button class="btn btn-primary" onclick="updateStatus(${r.id},2)">Aproved</button>
				</td>
				</tr>
				`)
	$('#reimbursementsList').append(table);
}
/** ***************************************************************************** */
function updateStatus(id, statusId){
	var obj = {
			id,	statusId
		};

		console.log(obj);
		var toSend = JSON.stringify(obj);

		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				$(`statusID${id}`).html(status)
			}
		}
		xhr.open("PUT", "manager",true);
		xhr.setRequestHeader("Content-Type", "application/json");
		console.log(toSend);
		xhr.send(toSend);
	
}
/** ***************************************************************************** */
