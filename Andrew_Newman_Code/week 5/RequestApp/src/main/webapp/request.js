/**
 * 
 */
window.onload = function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#logoutNav').on('click', Logout);
}

function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#RgButton').on('click',loadRegView);
			$('#LIButton').on('click',validateUser);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();	
}

function Logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			loadHomeView();
		}
	}
	xhr.open("GET", "logout", true);
	xhr.send();	
}

function loadRegView(){
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
            //$('#CUButton').on('click',insertUser);
        }
    }
    
    XHR.open('GET', "reg.view"  ,true)
    XHR.send();
}

function validateUser(){
	var XHR = new XMLHttpRequest();
	let userObj = { username : $("input[name=username]").val(),
							 password : $("input[name=password]").val()};

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
        	$('#view').html(XHR.responseText);
        	$('#tryButton').on('click', loadHomeView);
        	$('#ARButton').on('click', addRequestView);
        	$('#VPButton').on('click', userRequestsView);
        	$('#VAButton').on('click', managerRequestsView);
        }
    }
    
    XHR.open('POST', "login" ,true)
    XHR.setRequestHeader("Content-type","application/json")
    XHR.send(JSON.stringify(userObj));
}

function managerRequestsView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			getAllRequests();
		}
	}
	xhr.open("GET", "managerRequests.view", true);
	xhr.send();
}

function userRequestsView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			getAllUserRequests();
		}
	}
	xhr.open("GET", "userRequests.view", true);
	xhr.send();
}

function getAllUserRequests() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState + "loadALL")
        if(XHR.readyState == 4 && XHR.status == 200){
            let requests = JSON.parse(XHR.responseText);
            for(let r of requests){
            	var row = $(`<tr>
                        <th scope="row">${r.rID}</th>
                        <td >${r.amount}</td>
            			<td>${r.desc}</td>
                        <td>${r.typeID}</td>
                        </tr>`);
            	$('#userRequestList').append(row);
            }
            $('#ARButton').on('click', addRequestView);
        }
    }
    XHR.open('GET', "requests" ,true)
    XHR.send();
}

/*function getAllRequests() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState + "loadALL")
        if(XHR.readyState == 4 && XHR.status == 200){
            let requests = JSON.parse(XHR.responseText);
            for(let r of requests){
            	console.log(r);
            	var li = $(`<li>${r.rID}  ${r.desc} ${r.author}  ${r.amount}</li>`);
            	$('#AllRequestList').append(li);
            }
            $('#PendingButton').on('click',loadPendingView);
            $('#ApprovedButton').on('click',loadApprovedView);
            $('#DeniedButton').on('click',loadDeniedView);
        }
    }
    XHR.open('GET', "requests" ,true)
    XHR.send();
}*/

function getAllRequests() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState + "loadALL")
        if(XHR.readyState == 4 && XHR.status == 200){
            let requests = JSON.parse(XHR.responseText);
            for(let r of requests){
            	var row = $(`<tr>
                        <th scope="row">${r.rID}</th>
                        <td >${r.amount}</td>
            			<td>${r.desc}</td>
                        <td>${r.author}</td>
                        <td>${r.typeID}</td>
                        <td>${r.statusID}</td>
                        </tr>`);
            	$('#AllRequestList').append(row);
            }
            $('#PendingButton').on('click',loadPendingView);
            $('#ApprovedButton').on('click',loadApprovedView);
            $('#DeniedButton').on('click',loadDeniedView);
        }
    }
    XHR.open('GET', "requests" ,true)
    XHR.send();
}

function addRequestView() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
            $('#CRButton').on('click', addRequest);
        }
    }
    
    XHR.open('GET', "createReq.view"  ,true)
    XHR.send();
}


function addRequest(){
	var XHR = new XMLHttpRequest();
	let reqObj = { amount : $("input[name=amount]").val(),
			 				 desc : $("input[name=desc]").val(),
			 				typeID : $("#types").val()};
	console.log($("#types").val())
	
    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
        	$('#view').html(XHR.responseText);
        	$('#retButton').on('click', userRequestsView);
        	$('#CRButton').on('click', addRequest);
        }
    }
    
    if(reqObj.amount == "" | reqObj.desc == "" | reqObj.typeID == ""){
    	XHR.open('GET', "createReq.view" ,true)
        XHR.send();
	}else{
		XHR.open('POST', "requests" ,true)
		XHR.setRequestHeader("Content-type","application/json")
	    XHR.send(JSON.stringify(reqObj));
	}
}

function loadPendingView() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
           loadAllPendingRequests()
        }
    }
    
    XHR.open('GET', "pending.view"  ,true)
    XHR.send();
}

function loadAllPendingRequests() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            let requests = JSON.parse(XHR.responseText);
            for(let r of requests){
            	var row = $(`<tr>
                        <th scope="row">${r.rID}</th>
                        <td >${r.amount}</td>
            			<td>${r.desc}</td>
                        <td>${r.author}</td>
                        <td>${r.typeID}</td>
                        <td><button type="button" class="appclass btn btn-default btn-sm" value ="${r.rID}" id="AppButton">Approve</button></td>
                        <td><button type="button" class="denclass btn btn-default btn-sm" value ="${r.rID}" id="DenButton">Denied</button></td>
                        </tr>`);
            	
            	$('#AllPendingRequests').append(row);
            	//$('#AppButton').on('click',ApproveReq);
                //$('#DenButton').on('click',DenyReq);
            }
            $('.appclass').on('click',ApproveReq);
            $('.denclass').on('click',DenyReq);
            $('#ApprovedButton').on('click',loadApprovedView);
            $('#DeniedButton').on('click',loadDeniedView);
        }
    }
   
    XHR.open('GET', "pending" ,true)
    XHR.send();

}

//Approved
function loadApprovedView() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
           loadAllApprovedRequests()
        }
    }
    
    XHR.open('GET', "approved.view"  ,true)
    XHR.send();
}

function loadAllApprovedRequests() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            let requests = JSON.parse(XHR.responseText);
            for(let r of requests){
            	var row = $(`<tr>
                        <th scope="row">${r.rID}</th>
                        <td >${r.amount}</td>
            			<td>${r.desc}</td>
                        <td>${r.author}</td>
                        <td>${r.typeID}</td>
                        </tr>`);
            	$('#AllApprovedRequests').append(row);
            }
            $('#PendingButton').on('click',loadPendingView);
            $('#DeniedButton').on('click',loadDeniedView);
        }
    }
   
    XHR.open('GET', "approved" ,true)
    XHR.send();

}

//DENIED
function loadDeniedView() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
           loadAllDeniedRequests()
        }
    }
    
    XHR.open('GET', "denied.view"  ,true)
    XHR.send();
}

function loadAllDeniedRequests() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            let requests = JSON.parse(XHR.responseText);
            for(let r of requests){
            	var row = $(`<tr>
                        <th scope="row">${r.rID}</th>
                        <td >${r.amount}</td>
            			<td>${r.desc}</td>
                        <td>${r.author}</td>
                        <td>${r.typeID}</td>
                        </tr>`);
            	$('#AllDeniedRequests').append(row);
            }
            $('#PendingButton').on('click',loadPendingView);
            $('#ApprovedButton').on('click',loadApprovedView);
        }
    }
   
    XHR.open('GET', "denied" ,true)
    XHR.send();
}

function ApproveReq() {
	var XHR = new XMLHttpRequest();
	let reqObj = { rID: $(this).val()} 
	console.log(reqObj);
	
    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
        	$('#view').html(XHR.responseText);
        	loadAllApprovedRequests()
        }
    }
    
    XHR.open('POST', "requestApprove" ,true)
    XHR.setRequestHeader("Content-type","application/json")
    XHR.send(JSON.stringify(reqObj));
	
}

function DenyReq() {
	var XHR = new XMLHttpRequest();
	let reqObj = { rID: $(this).val()} 
	console.log(reqObj);
	
    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
        	$('#view').html(XHR.responseText);
        	loadAllDeniedRequests();
        }
    }
    
    XHR.open('POST', "requestDenied" ,true)
    XHR.setRequestHeader("Content-type","application/json")
    XHR.send(JSON.stringify(reqObj));
	
}

function getNameFromId(id) {
	let uObj = { userId: id}
	
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
        	let user = JSON.parse(XHR.responseText);
        	let name = user.firstName + " " + user.lastName;
        	return name  
        }
    }
    
    XHR.open('POST', "info" ,true)
    XHR.setRequestHeader("Content-type","application/json")
    XHR.send(JSON.stringify(uObj));
}