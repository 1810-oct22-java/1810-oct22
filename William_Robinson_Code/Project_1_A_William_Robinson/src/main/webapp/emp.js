/**
 *  Meant to enable single page functionality for Employee view of reimbursement
 *  requests.
 */

window.onload = function(){
	$('#e1submit').on('click', loade1submit);
	$('#e1view').on('click', loade1view);
	$('#subrequest').on('click', postsub);

}

function loade1submit(){

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('s5').html(xhr.responseText);
		}
	}
	xhr.open("GET", "s5", true);
	xhr.send();	
}

function postsub(){

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('s5').html(xhr.responseText);
		}
	}
	xhr.open("POST", "s5", true);
	xhr.send();	
}


function loade1view(){

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('s6').html(xhr.responseText);
		}
	}
	xhr.open("GET", "s6", true);
	xhr.send();	
}