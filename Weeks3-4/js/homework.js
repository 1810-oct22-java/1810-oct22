window.onload = function(){
    // //function will run as soon as page has loaded
    // alert("page has loaded!");
    // console.log("woo we're in the console")

document.getElementById('runFib').addEventListener("click", runFib,true);
}

function runFib(){
    //take input and call fibonacci function
    //console.log("clicking button");
    var n = document.getElementById('fibInput').value;
    console.log(n);
    console.log(`fib(n) = ${fibR(n)}`);
    const out = document.createElement("DIV");
    var x = document.createTextNode(`${fibR(n)}`);
    out.appendChild(x);
    document.getElementById('fibOutput').appendChild(out);

}

function fibR(n){//fibonacci with recursion
    if(n==0|n==1) return n;
    return fibR(n-1) + fibR(n-2);
}

function fib(n){
    
}
var thisIsGlobal = "look at me!";