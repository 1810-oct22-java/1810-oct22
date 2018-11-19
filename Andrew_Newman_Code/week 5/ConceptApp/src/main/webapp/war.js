/**
 * 
 */

window.onload = function() {
	loadStartView();
}

function loadStartView(){
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
            $('#LUButton').on('click', loadCatview);
        }
    }
    
    XHR.open('GET', "serve"  ,true)
    XHR.send();
}

function loadCatview(){
	var XHR = new XMLHttpRequest();
	let fact = $("input[name=catid]").val();

	
    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            $('#view').html(XHR.responseText);
            getCatFact();
        }
    }
    
    XHR.open('GET', "catview" ,true)
    XHR.send();
}

function getCatFact() {
	var XHR = new XMLHttpRequest();

    XHR.onreadystatechange = function(){
        console.log(XHR.readyState)
        if(XHR.readyState == 4 && XHR.status == 200){
            var fact = JSON.parse(XHR.responseText);
            $('#catfact').html(fact.value);
            $('#AFButton').on('click', loadCatview);
        }
    }
    
    XHR.open('GET', "https://api.chucknorris.io/jokes/random" ,true)
    XHR.send();	
}
//https://cat-fact.herokuapp.com/facts/1