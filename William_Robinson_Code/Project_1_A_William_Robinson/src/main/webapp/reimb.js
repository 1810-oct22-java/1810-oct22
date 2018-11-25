/**
 * Meant to allow for single page views for Finance manager functionality.
 */

window.onload = function(){
	$('#viewapproved').on('click', loadapproved);
	$('#viewdenied').on('click', loaddenied);
	$('#viewapproveddenied').on('click', loadapproveddenied);
}



function loadapproved(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
            $('s3').html(xhr.responseText);
		}
    }
	xhr.open("GET", "s3", true);
	xhr.send();	
}

function loaddenied(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('s4').html(xhr.responseText);

		}
	}
	xhr.open("GET", "s4", true);
	xhr.send();	
}

function loadapproveddenied(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('s2').html(xhr.responseText);

		}
	}
	xhr.open("GET", "s2", true);
	xhr.send();	
}




