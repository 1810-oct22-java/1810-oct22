window.onload = function(){
    document.getElementById('runFib').addEventListener("click", runFib ,true)
    document.getElementById('runBSort').addEventListener("click", runBSort ,true)
    document.getElementById('runRString').addEventListener("click", runRString ,true)
    document.getElementById('runFact').addEventListener("click", runFact ,true)
    document.getElementById('runSubS').addEventListener("click", runSubS ,true)
    document.getElementById('runEven').addEventListener("click", runEven ,true)
    document.getElementById('runPal').addEventListener("click", runPal ,true)
    document.getElementById('runObj').addEventListener("click", runObj ,true)
    document.getElementById('runDel').addEventListener("click", runDel ,true)
}


var numArray = [9,4,6,2,9,4,1,3]
var delArray = [1,2,3,4,5,6]
var someStr = "Some String"
var someObject = {
    "name":"Bob Smith",
    "age":"18",
    "location":"Virginia"
}


function runDel(){
    document.getElementById('lengthout').innerHTML = ` length : ${delElement(delArray)}`
}
function delElement(delArray){
    console.log(delArray)
    delArray.splice(2,1)
    console.log(delArray)

    return delArray.length
}

$(document).ready(function () {
    setInterval(function () {
       // Seconds hand
       let dateTime = new Date()
       document.getElementById('time').innerHTML = dateTime 
    }, 1000)
})

function runObj(){
    traverseObject(someObject);
}

function traverseObject(someObject){
    Object.keys(someObject).forEach(function(key) {
        var newp = document.createElement("p");
        newp.innerHTML = `${key} : ${someObject[key]}`
        document.getElementById('objoutput').appendChild(newp)     
    });
}


function runFib(){
    var n = document.getElementById("fibInput").value;
    console.log(n)
    document.getElementById('fibInput').value = fib(n);
}

function runBSort(){
    document.getElementById('sortedArray').innerHTML = bubbleSort(numArray)
}

function runRString(){
    var s = document.getElementById("RSInput").value;
    document.getElementById('RSInput').value = reverseStr(s)
}

function runEven(){
    var e = document.getElementById("Numinput").value;
    document.getElementById('isEven').innerHTML = isEven(e)
}

function runPal(){
    var p = document.getElementById("palinput").value;
    document.getElementById('paloutput').innerHTML = isPalindrome(p)
}

function isPalindrome(p){
    return p == reverseStr(p)
}
function runSubS(){
    var o = document.getElementById("subOinput").value;
    var l = document.getElementById("subLinput").value;
    document.getElementById('newString').innerHTML = substring(someStr,o,l)
}

function runFact(){
    var x = document.getElementById("FactInput").value;
    document.getElementById('FactInput').value = factorial(x)
}

function fib(n){
    if( n==0 | n==1 ) return n;
    return fib(n-1) + fib(n-2)
}

function isEven(e){
    if((e*2)/2 == e) return true;
    else return false
}

function reverseStr(str){
    var splitString = str.split("");
    var reverseArray = splitString.reverse();     
    var joinArray = reverseArray.join(""); 
    return joinArray;
}

function substring(someStr, length, offset){
    return someStr.substr(length,offset)
}

function factorial(n){
    if(n==1) return 1;
    return (n * factorial(n-1))
}

function swap(array, i, j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

function bubbleSort(array) {
    var countOuter = 0;
    var countInner = 0;
    var countSwap = 0;
  
    var swapped;
    do {
      countOuter++;
      swapped = false;
      for(var i = 0; i < array.length; i++) {
        countInner++;
        if(array[i] && array[i + 1] && array[i] > array[i + 1]) {
          countSwap++;
          swap(array, i, i + 1);
          swapped = true;
        }
      }
    } while(swapped);
  
    console.log('outer:', countOuter, 'inner:', countInner, 'swap:', countSwap);
    return array;
  }  