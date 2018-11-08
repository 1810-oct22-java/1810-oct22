window.onload = function() {
    //function will run as soon as page loads fully
    //alert("page has loaded!");
    //console.log("woo we're in the console");

    document.getElementById('runFib').addEventListener("click", runFib, true);

}

function runFib() {
    //take input and call fibonacci function
    console.log("clicking button");
    //grabs opening tag, content, closing tag without .value
    var n = document.getElementById('fibInput').value;
    console.log(n);
    console.log(`fib(n) = ${fib(n)}`);

    document.getElementById('fibOutput').innerHTML = `fib(n) = ${fib(n)}`;
}

function fib(n) {
    if (n == 0 | n == 1) return n;
    return fib(n-1) + fib(n-2);
}

function fibNoR(n) {

}

var thisIsGloabl = "look at me!";