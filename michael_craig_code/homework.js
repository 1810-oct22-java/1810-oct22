window.onload = () => {
    document.getElementById('runFib').addEventListener("click", runFib, true)
}

const runFib = () => {
    // take input and call fibonnaci function
    let n = document.getElementById('fibInput').value
    console.log(n)
    console.log(`fib(n) = ${fibR(n)}`);
    const div = document.createElement("DIV")
    var t = document.createTextNode(`${fibR(n)}`)
    div.appendChild(t)
    document.getElementById("fibOutput").appendChild(div)
}

const fibR = (n) => {
    if (n == 0 || n == 1) {
        return n
    }
    else {
        return fibR(n - 1) + fibR(n - 2)
    }
}

const bubbleSort = () => {
    
}
