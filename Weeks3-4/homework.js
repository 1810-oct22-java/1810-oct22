window.onload = function () {

    document.getElementById('runFib').addEventListener("click", runFib, true);
    document.getElementById('runBub').addEventListener("click", runBub, true);
    document.getElementById('runRev').addEventListener("click", runRev, true);
    document.getElementById('runFac').addEventListener("click", runFac, true);
    document.getElementById('runSub').addEventListener("click", runSub, true);
    document.getElementById('runEven').addEventListener("click", runEven, true);
    document.getElementById('runPal').addEventListener("click", runPal, true);

}

function runFib() {
    var n = document.getElementById('fibInput').value;
    console.log(n);
    document.getElementById("fibOutput").innerHTML = `fib(n) = ${fibR(n)}`;
}

function fibR(n) {
    if (n == 0 | n == 1) return n;
    return fibR(n - 1) + fibR(n - 2);
}

function runBub() {

    var numArr = document.getElementById('bubInput').value;
    var x = numArr.split("");
    console.log(x.toString());
    for (var i = 0; i < x.length; i++) {
        for (var j = 0; j < x.length - 1; j++) {

            if (x[j] > x[j + 1]) {
                console.log("comparing " + x[j] + " to " + x[j + 1]);
                var temp = x[j + 1];
                x[j + 1] = x[j];
                console.log("Temp=" + temp + " numArr[j]=" + x[j]);
                x[j] = temp;
                console.log("numArr[j]=" + x[j]);
            }
        }
        console.log(x);
    }

    document.getElementById("bubOutput").innerHTML = `${x}`;
}

function runRev() {
    var arr = document.getElementById('revInput').value;
    var x = arr.split("");
    console.log(x);
    for (var i = 0; i < x.length / 2; i++) {
        var temp = x[i];
        console.log(x);
        x[i] = x[x.length - i - 1];
        x[x.length - i - 1] = temp;
        console.log(x);
    }
    document.getElementById("revOutput").innerHTML = x;
}

function runFac() {
    var fac = document.getElementById('facInput').value;
    num = 1;
    for (var i = 2; i <= fac; i++) {
        num *= i;
    }
    document.getElementById("facOutput").innerHTML = num;
}

function runSub() {
    var s = document.getElementById('subInput').value;
    var index = document.getElementById('index').value;
    s = s.split("");
    s.splice(0, index - 1);
    document.getElementById("subOutput").innerHTML = s;
}

function runEven() {
    var num = document.getElementById('evenInput').value;
    if (Math.floor(num / 2) * 2 == num) {
        document.getElementById('evenOutput').innerHTML = "true";
        return true;
    } else {
        document.getElementById('evenOutput').innerHTML = "false";
        return false;
    }
}

function runPal() {
    var s = document.getElementById('palInput').value;
    for (let i = 0; i < s.length / 2; i++) {
        if (s[i] != s[s.length - 1 - i]) {
            document.getElementById('palOutput').innerHTML = "false";
            return false;
        }
    }
    document.getElementById('palOutput').innerHTML = "true";
    return true;
}

function runShapes() {
    var shape = document.getElementById('shapesInput').value;
    var height = document.getElementById('heightInput').value;
    var character = document.getElementById('characterInput').value;
    var s = "";
    switch (shape) {
        case ("Square"):
            for (let i = 0; i < height; i++) {
                for (let j = 0; j < height; j++) {
                    s += character;
                }
                s += "\n";
            }
            break;
        case ("Triangle"):
            for (let i = 0; i < height; i++) {
                for (let j = 0; j < i + 1; j++) {
                    s += character;
                }
                s += "\n";
            }
            break;
        case ("Diamond"):
        
        
    }
    console.log(s);
}

function itsLit(obj){
    for(o in obj){
        console.log(o);
    }
}

function deletThis(arr){
    console.log(arr.length);
    delete arr[3];
    console.log(arr.length);
}

function spliceElement(arr){
    console.log(arr.length);
    arr.splice(3,1);
    console.log(arr.length);
}
