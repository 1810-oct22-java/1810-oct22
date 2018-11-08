window.onload = function(){
//function will run as soon as page loads fully
//alert("page has loaded!");
//console.log("woo we're in the console");

document.getElementById('runFib').addEventListener("click", runFib, true);


}

function runFib(){
    //take input and call fibonacci function
    var n = document.getElementById('fibInput').value;
    console.log(n);
    document.getElementById("fibOutput").innerHTML = `fib(n) = ${fibR(n)}`;
}

function fibR(n){
    if(n == 0 | n == 1) return n;
    return fibR(n-1) + fibR(n-2);
}

function fib(n){

}

var thisIsGlobal = "look at me!";