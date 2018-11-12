window.onload = function() {

    //function will run as soon as page loads fully
    // alert("page has loaded!");
    // console.log("woo we're in the console");

    document.getElementById('runFib').addEventListener("click", runFib, true);
    document.getElementById('runBubSort').addEventListener("click", runBubSort, true);
    document.getElementById('runRevStr').addEventListener("click", runRevStr, true);
    document.getElementById('runFact').addEventListener("click", runFact, true);
    document.getElementById('runSubStr').addEventListener("click", runSubStr, true);
    document.getElementById('runEvenNum').addEventListener("click", runEvenNum, true);
    document.getElementById('runPalin').addEventListener("click", runPalin, true);
    document.getElementById('runDel').addEventListener("click", runDel, true);
    document.getElementById('runDesc').addEventListener("click", runDesc, true);
}

// ----------------- Fibonacci functions -----------------
// 1. Fibonacci 
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function runFib() {

    //take input and call fibonacci function
    let n = document.getElementById('fibInput').value;
    console.log(n);
    console.log(`fib(n) = ${fibR(n)}`)
    document.getElementById('fibOutput').innerHTML = fibR(n);
}

function fibR(n) {

    if(n == 0 | n == 1) return n;
    return fibR(n - 1) + fibR(n - 2);

}

// ----------------- BubbleSort functions -----------------
// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function runBubSort() {

    //take input and call fibonacci function
    let numArray = document.getElementById('bubSortIn').value;
    document.getElementById('bubSortOut').innerHTML = bubbleSort(numArray);

}

function bubbleSort(numArray) {

    var nums = numArray.split(",");
    var arrayNums = nums.map(Number);
		
    for(let i = 0; i < arrayNums.length; i++) {
			
        for(let j = 0; j < arrayNums.length - i - 1; j++) {
            
            if (arrayNums[j] > arrayNums[j+1]) {
                
                let temp = arrayNums[j];
                arrayNums[j] = arrayNums[j+1];
                arrayNums[j+1] = temp;
                
            }
            
        }
    }
     
    return arrayNums;

}

// ----------------- Reverse String functions -----------------
// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function runRevStr() {

    let someStr = document.getElementById('revStrIn').value;
    document.getElementById('revStrOut').innerHTML = reverseStr(someStr);

}

function reverseStr(someStr) {

    var temp = "";
    for (let i = someStr.length - 1; i >= 0; i--) {

        temp += someStr.charAt(i);

    }
    //console.log(temp);
    return temp;

}

// ----------------- Factorial functions -----------------
// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function runFact() {

    let someNum = document.getElementById('factIn').value;
    document.getElementById('factOut').innerHTML = factorial(someNum);

}

function factorial(someNum) {

    let fact = 1;
    for(let i = 1; i <= someNum; i++) {
			
        fact *= i;
        
    }

    return fact;

}

// ----------------- SubString functions -----------------
// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function runSubStr() {

    let someStr = document.getElementById('string').value;
    let length = document.getElementById('length').value;
    let offset = document.getElementById('offset').value;
    if(someStr == ""){

        alert("Your string cannot be empty.");

    }
    else if (someStr.length < length) {

        alert("Please enter a length less than your String length");

    }
    document.getElementById('subStrOut').innerHTML = substring(someStr, length, offset);
    

}

function substring(someStr, length, offset) {

    let temp = "";
    let intOff = parseInt(offset);
    let intlen = parseInt(length);
    let total = intOff + intlen;
    temp = someStr.substring(offset - 1, total);
    return temp;

}

// ----------------- Check Even functions -----------------
// 6. Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function runEvenNum() {

    let someNum = document.getElementById('evenNumIn').value;
    document.getElementById('evenNumOut').innerHTML = isEven(someNum);

}

function isEven(someNum) {

    let temp = "";
    if (Math.round(someNum / 2) * 2 == someNum) {

        temp = "true";

    }
    else {
        
        temp = "false";

    }
    return temp;

}


// ----------------- Palindrome functions -----------------
// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function runPalin() {

    let someStr = document.getElementById('palindromeIn').value;
    document.getElementById('palindromeOut').innerHTML = isPalindrome(someStr);

}

function isPalindrome(someStr) {

    let isPalin = "false";
    let temp = "";

    for(let i = someStr.length-1; i >= 0; i--) {

        temp += someStr.charAt(i);

    }
    if (someStr === temp) {

        isPalin = "true";

    }
    return isPalin;

}


// ----------------- Shape functions -----------------
// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *

function runShapes() {

    let shape = document.getElementById('shapeIn').value;
    let height = document.getElementById('heightIn').value;
    let character = document.getElementById('characterIn').value;
    document.getElementById('shapesOut').innerHTML = printShape(shape, height, character);

}

function printShape(shape, height, character) {


    switch(shape) {

        case "square":
            for(let i = 0; i < height; i++) {

                console.log(character + character + character);

            }
        
        case "triangle":
            for(let x = 0; x < height; x++) {

                for(let y = 0; y < x; y++) {

                    console.log(character)

                }

            }
        
        case "diamond":
            

    }

}

// ----------------- Delete functions -----------------
// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

function runDel() {

    let someArr = document.getElementById('delIn').value;
    document.getElementById('delOut').innerHTML = deleteElement(someArr);

}

function deleteElement(someArr) {
    var arr = someArr.split(",");
    delete arr[2]
    console.log("arr: " + arr);
    console.log(arr.length);

    
    return arr.length;

}

// ----------------- Display Time functions -----------------
// 14. Display the current time on the top right of your HTML page, 
// updating every second
$(() => {
    setInterval(function () {
        let time = new Date();
        $('#dateOutput').html(time.toLocaleTimeString());
    }, 1000)
})


// ----------------- Descending Order functions -----------------
// 15. Your task is to make a function that can take any non-negative 
// integer as a argument and return it with its digits in descending 
// order. Essentially, rearrange the digits to create the highest possible number. -->
function runDesc() {

    let someNum = document.getElementById('descIn').value;
    document.getElementById('descOut').innerHTML = descOrd(someNum);

}

function descOrd(someNum) {
    var digits = someNum.split('');
    digits.sort(function(a, b){return b-a})
    var max = digits.map(Number)
    let temp = "";
    for(var i in max) {

        temp += max[i];

    }
    console.log(temp);
    return temp;

}

