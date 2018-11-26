
window.onload = function() {
    //function will run as soon as page loads fully
    

    document.getElementById('runFib').addEventListener("click", runFib, true);
    document.getElementById('runBubble').addEventListener('click', runBubble, true);
    document.getElementById('runRevString').addEventListener('click', runRevString, true);

    document.getElementById('runFac').addEventListener('click', runFac, true);

    document.getElementById('runSub').addEventListener('click', runSubstring, true);

    document.getElementById('runEvenNumber').addEventListener('click', runEvenNumber);

    document.getElementById('runPalindrome').addEventListener('click', runPalindrome);

    document.getElementById('runArray').addEventListener('click', runDeleteElement);

    document.getElementById('runConstructor').addEventListener('click', runPerson);
}

function runFib() {
    var n = document.getElementById('fibInput').value;

    document.getElementById("fibOutput").innerHTML = fibR(n);
    
}


function fibR(n) {
    if(n==0 | n==1) return n;
    return fibR(n-1) + fibR(n-2);
}

function fib(n){

}


function reverseString(str) {

    var result ="";
    var index = str.length -1;
    for(index; index >= 0; index--) {
        result += str.charAt(index);
    }
    return result;
}

//Run function reverseString
function runRevString() {

    var str = document.getElementById('stringInput').value;
    document.getElementById("revStringOutput").innerHTML = reverseString(str);
}

function fac(num) {
    if(num==0) return 1;
    return num*fac(num-1);
}

function runFac() {

    var num = document.getElementById('facInput').value;
    document.getElementById('facOutput').innerHTML = fac(num);
}

function mySubstring(str, le, off) {

    let result = "";

    le = parseInt(le);
    off = parseInt(off);

    for(let i = off; i <= le+1; i++ ) {
        result += str.charAt(i);
    }
    return result;
}

function runSubstring() {

    let str = document.getElementById('subInput').value;
    let num = document.getElementById('length').value;
    let off = document.getElementById('offset').value;
    document.getElementById('subOutput').innerHTML = mySubstring(str, num, off);
    
}


function bubblesort(arr) {

    let len = arr.length;

    for(let i = 0; i < len - 1; i++) {
        for(let j = i+1; j < len; j++) {
            if(arr[i] > arr[j]) {
                let temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    return arr;
}

function runBubble() {
    var str = document.getElementById('bubbleInput').value;
    let arr = extractStringArray(str);
    document.getElementById('bubbleOutput').innerHTML = bubblesort(arr);
}

function printShape(row, character) {

    for(let i = 0; i < row; i++) {
        for(let j = 0; j < row; j++) {
            console.log(character);
        }
    }
}

function palindrome(str) {
    
    if(str.toLowerCase()===reverseString(str).toLowerCase()) return `${str} is palindrome`;
    else return `No,  ${str} is not palindrome`;
    
}

function runPalindrome() {
    let str = document.getElementById('palindromeInput').value;
    document.getElementById('palindromeOutput').innerHTML = palindrome(str);
}

function evenNumber(number) {
    let quotient = number/2;
    quotient = Math.round(quotient);
    if(number == quotient * 2) return number + " is even number."
    else return number + " is odd number";
}


function runEvenNumber() {
     let num = document.getElementById('evenNumberInput').value;
    document.getElementById('evenNumberOutput').innerHTML = evenNumber(num);
}


var myVar = setInterval(function(){
    var d = new Date();
    $('#timeOutput').html(d.toLocaleTimeString());
}, 1000);

function deleteElement(arr) {
    arr[2] = null;
    
    return arr;
}

function extractStringArray(arr) {
    let strArr = arr.split(',');
    let numArr = new Array(strArr.length);
    for(let i = 0; i< strArr.length; i++) {
        numArr[i] = Number(strArr[i]);
    }
    return numArr;
}

function runDeleteElement() {
    let arr = extractStringArray(document.getElementById('arrayInput').value);
    let arr2 = deleteElement(arr);
    document.getElementById('beforeLength').innerHTML = arr.length;
    document.getElementById('arrayOutput').innerHTML = arr2.toString();
    document.getElementById('afterLength').innerHTML = arr2.length;
}

function Person(name, age) {
    this.name = name;
    this.age = age;
}

function runPerson() {
    let name = document.getElementById('name').value;
    let age = document.getElementById('age').value;
    var john = new Person(name, age);
    document.getElementById('objectOutput').innerHTML = `${john.name} ${john.age}`;
}



