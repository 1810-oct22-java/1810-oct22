/**
 * 
 */
window.onload = function(){

document.getElementById('runFib').addEventListener("click", runFib, true);

}

function runFib(){
    //take input and call fibonacci function
    var n = document.getElementById('fibInput').value;
    console.log(`fib(${n}) = ${fibR(n)}`);
    document.getElementById("fibOutput").innerHTML = "  Problem 1: The " + n + "(th) number in the fibonacci sequence is " + fibR(n);

}

function fibR(n){
    if(n == 0 | n == 1) { return n; }
    return fibR(n-1) + fibR(n-2);
}

function fib(n){

}