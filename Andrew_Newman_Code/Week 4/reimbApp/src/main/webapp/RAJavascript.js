window.onload = function(){
    loadHomeView();
    $('#homeNav').on('click', loadHomeView);
    $('#logoutNav').on('click', logout);
}

function logout(){
	var XHR = new XMLHttpRequest();
	console.log("right there")
    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            loadHomeView();
            $('#LIButton').on('click',validateUser);
            $('#RgButton').on('click',loadRegView);
        }
    }
    
    XHR.open('GET', "logout"  ,true)
    console.log("right after")
    XHR.send();
	
    console.log("qpwr")
}

function loadHomeView(){
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
        	console.log("cmon")
        	$('#view').html(XHR.responseText);
            $('#LIButton').on('click',validateUser);
            $('#RgButton').on('click',loadRegView);
        }
    }
    
    XHR.open('GET', "home.view"  ,true)
    XHR.send();
}

function loadRegView(){
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
            $('#CUButton').on('click',insertUser);
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
        	$('#VPButton').on('click', loadPastRequests);
        	$('#VAButton').on('click', loadPastRequests);
        }
    }
    
    XHR.open('POST', "login.view" ,true)
    XHR.setRequestHeader("Content-type","application/json")
    XHR.send(JSON.stringify(userObj));
}

function insertUser(){
	var XHR = new XMLHttpRequest();
	let userObj = { userName : $("input[name=username]").val(),
			 				 password : $("input[name=password]").val(),
			 			     firstName : $("input[name=fname]").val(),
							 lastName : $("input[name=lname]").val(),
							 email : $("input[name=e-mail]").val(),
							 roleID : $("input[name=role]").val()};

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
        	$('#view').html(XHR.responseText);
        	$('#RgButton').on('click',loadRegView);
        	$('#tryButton').on('click',loadHomeView);
        }
    }
    
    if(userObj.userName == "" | userObj.password == "" | userObj.email == "" | userObj.roleID == ""){
    	XHR.open('GET', "input.view" ,true)
        XHR.send();
	}else{
		XHR.open('POST', "userCreate.view" ,true)
		XHR.setRequestHeader("Content-type","application/json")
	    XHR.send(JSON.stringify(userObj));
	}	
}

function loadPastRequests(){
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
            getPastUserRequests();
            loadAllPastRequests();
        }
    }
    
    XHR.open('GET', "Past.view"  ,true)
    XHR.send();
}

function getPastUserRequests(){
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            let requests = JSON.parse(XHR.responseText);
            for(let r of requests){
            	var li = $(`<li>${r.rID}</li>`);
            	$('#userRequestList').append(li);
            }
        }
    }
   
    XHR.open('GET', "requests" ,true)
    XHR.send();
}

function loadAllPastRequests(){
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            let requests = JSON.parse(XHR.responseText);
            for(let r of requests){
            	var li = $(`<li>${r.rID}</li>`);
            	$('#AllRequestList').append(li);
            }
        }
    }
   
    XHR.open('GET', "requests" ,true)
    XHR.send();
}

function addRequestView(){
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
            $('#CRButton').on('click', addRequest);
        }
    }
    
    XHR.open('GET', "creteReq.view"  ,true)
    XHR.send();
}

function addRequest(){
	var XHR = new XMLHttpRequest();
	let reqObj = { amount : $("input[name=amount]").val(),
			 				 desc : $("input[name=desc]").val(),
			 				typeID : $("input[name=Typeid]").val()};
	


    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
        	$('#view').html(XHR.responseText);
        	$('#retButton').on('click', loadPastRequests);
        }
    }
    
    if(reqObj.amount == "" | reqObj.desc == "" | reqObj.typeID == ""){
    	XHR.open('GET', "creteReq.view" ,true)
        XHR.send();
	}else{
		XHR.open('POST', "requests" ,true)
		XHR.setRequestHeader("Content-type","application/json")
	    XHR.send(JSON.stringify(reqObj));
	}
}