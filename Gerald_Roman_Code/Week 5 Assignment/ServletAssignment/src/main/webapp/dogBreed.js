window.onload = function() {
	$('#go').on('click', function() {
		dogFunction();
		doAjaxWithjQuery();
	});

}
function dogFunction() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log(xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			globalperson = JSON.parse(xhr.responseText);
			$('#output').html(JSON.parse(xhr.responseText).name);
			console.log(globalperson.message);

			var image = document.createElement("img");
			image.src = globalperson.message;
			var dogImg = document.getElementById('pic');
			dogImg.appendChild(image);

		}
	}

	var id = $('#dogID').val();
	var url = `https://dog.ceo/api/breed/${id}/images/random`;
	xhr.open('GET', url, true);
	xhr.send();

	console.log("SENT REQUEST " + xhr.responseText);

}
function doAjaxWithjQuery() {
	console.log('TESTING OUR jQUERY AJAX method')
	globalSW = null;
	$.ajax({
		type : 'GET',
		url : `https://dog.ceo/api/breed/${$('#dogID').val()}`,
		success : function(response, status) {
			console.log(response);
			console.log(status);
		},
		error : function(status, statusText) {
			console.log(`ERROR: ${status}: ${statusText}`);
		}
	})
}