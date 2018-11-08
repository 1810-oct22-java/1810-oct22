window.onload = function(){

document.getElementById('runRev').addEventListener("click", reverseStr, true);

}

function reverseStr() {
	 var n = document.getElementById('revInput').value;
	 var revString = "";
	 
	 for (var i = n.length - 1; i >= 0; i--) {
		 revString += n[i];
	 }
	 document.getElementById("revOutput").innerHTML = "  Problem 3: " + n + " reversed is " + revString;
}