/**
 * 
 */

window.onload = function() {
	$('#showBtn').on('click', showCard)
	$('#toMain').on('click', toMain)
}

showCard = function() {
	const xhr = new XMLHttpRequest()
	xhr.onreadystatechange = function () {
	    if (xhr.readyState == 4 && xhr.status >= 200) {
	        console.log(xhr.responseText);
	        const x = JSON.parse(xhr.responseText)
	        const q = x.cards.map(card => {
	        	var src = document.getElementById("output")
	        	var img = document.createElement("img")
	        	img.src = `${card.imageUrl}`
	        	src.appendChild(img)
	        	var rarity = document.createElement("h3")
	        	var t = document.createTextNode(`${card.rarity}`)
	        	rarity.appendChild(t)
	        	src.appendChild(rarity)
	        })
	    }
	}
	name = $('#cardId').val()
	console.log(name)
	const url = `https://api.pokemontcg.io/v1/cards?name=${name}`
	xhr.open('get', url, true)
	xhr.send()
}

toMain = function() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#other').html('click', toOther)
		}
	}
	xhr.open("GET", "main.view", true);
	xhr.send();	
}

toOther = function() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "other.view", true);
	xhr.send();	
}