window.onload = function(){
    document.getElementById('runFib').addEventListener("click", runFib ,true)
    document.getElementById('runBSort').addEventListener("click", runBSort ,true)
    document.getElementById('runRString').addEventLi00000000000000000000000000000stener("click", runRString ,true)
    document.getElementById('runFact').addEventListener("click", runFact ,true)
    document.getElementById('runSubS').addEventListener("click", runSubS ,true)
}

var numArray = [9,4,6,2,9,4,1,3]
var someStr = "Some String"


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

function runSubS(){
    var s = document.getElementById("subSInput").value;
    document.getElementById('subString').innerHTML = substring(someStr,someStr.length,s)
}


function runFact(){
    var x = document.getElementById("FactInput").value;
    document.getElementById('FactInput').value = factorial(x)
}

function fib(n){
    if( n==0 | n==1 ) return n;
    return fib(n-1) + fib(n-2)
}

function reverseStr(str){
    var splitString = str.split("");
    var reverseArray = splitString.reverse();     
    var joinArray = reverseArray.join(""); 
    return joinArray;
}

function substring(someStr, length, offset){
    return someStr.substring(offset,length)
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