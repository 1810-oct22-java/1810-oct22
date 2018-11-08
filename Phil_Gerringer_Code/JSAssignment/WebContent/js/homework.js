/**
 * 
 */
window.onload = function() {
document.getElementById('runFib').addEventListener("click", fib, true);
document.getElementById('runBub').addEventListener("click", runBubble, true);
document.getElementById('facRev').addEventListener("click", factorial, true);
document.getElementById('runRev').addEventListener("click", runRev, true);
document.getElementById('evenRev').addEventListener("click", runEven, true);
document.getElementById('palRev').addEventListener("click", runPalindrome, true);
document.getElementById('conRev').addEventListener("click", runConstruction, true);
document.getElementById('litRev').addEventListener("click", runLiteral, true);
document.getElementById('descRev').addEventListener("click", runDesc, true);

currentTime();
}

/**
 * 1. Fibonacci 
 * Define function: fib(n) 
 * Return the nth number in the fibonacci sequence.
 * @returns
 */
function fib(){
    //take input and call fibonacci function
    var n = document.getElementById('fibInput').value;
    console.log(`fib(${n}) = ${fibR(n)}`);
    document.getElementById("fibOutput").innerHTML = "  Problem 1: The " + n + "(th) number in the fibonacci sequence is " + fibR(n);
}

/**
 * recursive function that computes the Nth fibonacci number
 * @param n
 * @returns
 */
function fibR(n){
    if(n == 0 | n == 1) { return n; }
    return fibR(n-1) + fibR(n-2);
}

/**
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 */
function runBubble() {
	let inputStr = $('#bubInput').val();

	$('#bubOutput').html(inputStr + " sorted is " + bubbleSort(inputStr.split(",")).join(","), false);
}


function bubbleSort(numArray,isDESC) {
	let idx = 0;
	let len = numArray.length;
	let i = 0;
	let j = 0;
	let stop = 0;

	for (i = 0; i < len; i++) {
        for (j = 0, stop = len - i; j < stop; j++) {
			if (isDESC) {
            	if (numArray[j] < numArray[j+1]) {
					// do the swap
					numArray = swapElement(numArray, j);
				}
			}
			else {
				if (numArray[j] > numArray[j+1]) {
                	// do the swap
					numArray = swapElement(numArray, j);
				}
			}
        }
    }

	return numArray;
}

function swapElement(arr, j) {
	let tmp = arr[j];
	arr[j] = arr[j+1];
	arr[j+1] = tmp;

	return arr;
}

/**
 * 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum.
 * @returns
 */
function factorial() {
	var n = document.getElementById('facInput').value;
	var someNum = 1;
	
	for (var i = n; i > 0; i--) {
		 someNum = someNum * i;
	 }
	 document.getElementById("facOutput").innerHTML = "  Problem 4: " + n + "! is " + someNum;
}

/**
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 * @returns
 */
function runRev() {
	 var n = document.getElementById('revInput').value;
	 
	 document.getElementById("revOutput").innerHTML = "  Problem 3: " + n + " reversed is " + reverseStr(n);
}

function reverseStr(someStr) {
	var revString = "";
	 
	for (var i = someStr.length - 1; i >= 0; i--) {
		revString += someStr[i];
	}
	return revString;
}

/**
 * 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator.
 * @returns
 */
function runEven() {
	var n = document.getElementById('evenInput').value;
	var ans = " IS NOT ";
	
	if(isEven(n)) {
		ans = " IS ";
	}
	
	document.getElementById("evenOutput").innerHTML = "  Problem 6: " + n + ans + "even.";
	
}

function isEven(someNum) {
	var b = true;
	
	// count through the int, each time switching whether its true or not
	for (var i=1; i<=someNum; i++) {		
	    b = !b; 
	} 
	
	return b;
}

/**
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 * @returns
 */
function runPalindrome() {
	var n = document.getElementById('palInput').value;
	var ans = " IS NOT ";
	
	if(isPalindrome(n)) { 
		ans = " IS ";
	}
	
	var outStr = n + ans + " a palindrome.";
	document.getElementById("palOutput").innerHTML = n + ans + " a palindrome.";
}

function isPalindrome(someStr) {
	var revStr = reverseStr(someStr);
	
	if(revStr === someStr) {
		return true;
	}
	return false;
}

/**
 * 12. Defining an object using a constructor
 * Define a function Person(name, age)
 * The following line should set a Person object to the variable john:
 *	var john = new Person("John", 30);
 * @returns
 */
function runConstruction () {
	var name = document.getElementById('conNameInput').value;
	var age = document.getElementById('conAgeInput').value;

	var aPerson = new Person(name,age);
	
	document.getElementById("conOutput").innerHTML = aPerson.toString();
}

function Person(name, age) {
    this.personName = name;
    this.personAge = age;
	
	this.toString = function() {
		return "[personName:" + this.personName + " , personAge:" + this.personAge + "]";
	}
}

/**
 * 13. Defining an object using an object literal
 * Define function getPerson(name, age)
 * The following line should set a Person object to the variable john:
 *	var john = getPerson("John", 30);
 * @returns
 */
function runLiteral() {
	let name = document.getElementById('litNameInput').value;
	let age = document.getElementById('litAgeInput').value;

	let aPerson = getPerson(name,age);

	document.getElementById("litOutput").innerHTML = aPerson.toString();
}

function getPerson(name, age) {
	return {personName: name, personAge: age, toString: function() {return "[personName:" + this.personName + " , personAge:" + this.personAge + "]";}}
}

/**
 * 14. Display the current time on the top right of your HTML page, 
 * updating every second
 */
function currentTime() {
	var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    
    var timeStr = "Problem 14: Time   " + padTime(h) + ":" + padTime(m) + ":" + padTime(s);
    document.getElementById('timeTxt').innerHTML = timeStr;
    setTimeout(currentTime, 1000);
}

function padTime(i) {
    if (i < 10) {
    	// add a zero at the front of the number to pad it
    	i = "0" + i;
    }
	return i;
}

/**
 * 15.  Descending order
 * Your task is to make a function that can take any non-negative 
 * integer as a argument and return it with its digits in descending 
 * order. Essentially, rearrange the digits to create the highest possible number.
 * 
 * Note:  Uses BubbleSort
 */
function runDesc() {
	let splat = $('#descInput').val()
	
	$('#descOutput').html(splat + " in Descending order is " + bubbleSort(splat.split(""), true).join(""));
}
