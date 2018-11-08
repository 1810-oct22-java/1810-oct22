/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

window.onload = function(){

document.getElementById('facRev').addEventListener("click", factorial, true);

}

function factorial() {
	var n = document.getElementById('facInput').value;
	var someNum = 1;
	
	for (var i = n; i > 0; i--) {
		 someNum = someNum * i;
	 }
	 document.getElementById("facOutput").innerHTML = "  Problem 4: " + n + "! is " + someNum;
}