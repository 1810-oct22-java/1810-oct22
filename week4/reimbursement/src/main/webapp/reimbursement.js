/**
 * 
 */
window.onload = function (){
	$('#loginbtn').on('click', login);
	$('#loadviewbtn').on('click',loadPoolView);
	$('#poolbtn').on('click', getReimbursements);
	
}

function getReimbursements(){
	console.log("in function");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let reimbursements = JSON.parse(xhr.responseText);
			for(let r of reimbursements){
				appendToReimbursementList(r);
			}
		}
	}
	xhr.open("GET", "reimbursements");
	xhr.send();
}
function appendToReimbursementList(r){
	console.log(r.reimbID);
	var td = 
		$(`<tr>
			<td>${r.reimbID}</td>
			<td>${r.reimbAmount}</td>
			<td>${r.reimbSubmitted}</td>
			<td>${r.reimbResolved}</td>
			<td>${r.reimbAuthor}</td>
			<td>${r.reimbStatusID}</td>
			<td>${r.reimbTypeID}</td>
		</tr>`);
	$('#table').append(td);
}
function loadPoolView(){
	console.log("test");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			console.log(xhr.responseText);
			console.log("before view is loaded")
			$('#view').html(xhr.responseText);
			console.log("after view is loaded");
			$('#loadTable').on('click', getReimbursements);
		}
	}
	xhr.open("GET", "reimbursement.view", true);
	xhr.send();	
	
}

function login(){
	var username = $('#username').val();
	var password = $('#password').val();
	
	var obj = {
		uName: username,
		pWord: password
	};
	
	var toSend = JSON.stringify(obj);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function (){
		if(xhr.readyState == 4 && xhr.status == 200){
			
		}
	}
	xhr.open("POST", "login");
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(toSend);
	
}

