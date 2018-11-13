window.onload = function() {
    //function will run as soon as page loads fully
    //alert("page has loaded!");
    //console.log("woo we're in the console");

    document.getElementById('runFib').addEventListener("click",runFib,true);
    document.getElementById('runBub').addEventListener("click",runBub,true);
    document.getElementById('runRev').addEventListener("click",runRev,true);
    document.getElementById('runFact').addEventListener("click",runFact,true);
    document.getElementById('runSub').addEventListener("click",runSub,true);
    document.getElementById('runEven').addEventListener("click",runEven,true);
    document.getElementById('runPal').addEventListener("click",runPal,true);
    document.getElementById('runShape').addEventListener("click",runShape,true);
    document.getElementById('runShape').addEventListener("click",runShape,true);
    document.getElementById('runDesc').addEventListener("click",runDesc,true);

}

//Q1
function runFib() {
    //take input and call fibonacci function
    console.log("clicking button");
    //grabs opening tag, content, closing tag without .value
    let n = document.getElementById('fibInput').value;
    console.log(n);
    console.log(`fib(n) = ${fib(n)}`);
    document.getElementById('fibOutput').innerHTML = `fib(n) = ${fib(n)}`;
}

function fib(n) {
    if (n == 0 | n == 1) return n;
    return fib(n-1) + fib(n-2);
}

//Q2
function runBub() {
    let str = document.getElementById('bubInput').value;
    document.getElementById('bubOutput').innerHTML = `Sorted Array = ${bub(str)}`;
}

function bub(str) {
    let arr = str.split(",");
    let t = false;
    while (t == false) {
        t = true;
        for (let i = 0; i<arr.length-1; i++) {
            let tmp;
            if (arr[i]>arr[i+1]) {
                tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
                t = false;
            }
        }
    }
    return arr;
}

//Q3
function runRev() {
    let n = document.getElementById('revInput').value;
    document.getElementById('revOutput').innerHTML = `Reversed String = ${rev(n)}`;
}

function rev(n) {
    let str = n.split("");
    str = str.reverse().join("");
    return str;
}

//Q4
function runFact() {
    let n = document.getElementById('factInput').value;
    document.getElementById('factOutput').innerHTML = `${n}! = ${fact(n)}`;
}

function fact(n) {
    if (n==1) {
        return 1;
    }
    else {
        return n*fact(n-1);
    }
}

//Q5
function runSub() {
    let str = document.getElementById('subInput').value;
    let i1 = document.getElementById('index1').value;
    let i2 = document.getElementById('index2').value;
    document.getElementById('subOutput').innerHTML = `Substring = ${sub(str,i1,i2)}`;
}

function sub(str,offset,length) {
    let i2 = parseInt(offset)+parseInt(length);
    console.log(i2);
    let subs = str.substring(offset,i2);
    return subs;
}

//Q6
function runEven() {
    let x = document.getElementById('evenInput').value;
    document.getElementById('evenOutput').innerHTML = `${even(x)}`;
}

function even(x) {
    if (Math.floor(x/2)*2 == x) {
        return true;
    }
    else {
        return false;
    }
}

//Q7
function runPal() {
    let string = document.getElementById('palInput').value;
    document.getElementById('palOutput').innerHTML = `${pal(string)}`;
}

function pal(str) {
    let string = str.split("");
    let revs = string.reverse().join("");
    console.log(str);
    console.log(revs);
    return str==revs;
}

//Q8
function runShape() {
    let string = document.getElementById('shapeInput').value;
    let len = document.getElementById('shapeNum').value;
    let char = document.getElementById('shapeChar').value;
    shape(string,len,char);
}

function shape(string,len,char) {
    switch (string) {
        case "square" : 
            for (let row = 0; row<len; row++) {
                for (let i = 0; i<len; i++) {
                    console.log(char);
                }
                console.log("\n");
            }
            break;
        case "triangle":
            for (let row = 0; row<len; row++) {
                for (let i = 0; i<len; i++) {
                    if (i <= row) {
                        console.log(char);
                    }
                    else {
                        console.log(" ");
                    }
                }
                console.log("\n");
            }
            break;
        case "diamond":
            let space = len - 1; 
            for (let i = 0; i < len/2; i=i+2) { 
                for (let j = 0; j < space; j++) {
                    console.log(" "); 
                }
                for (let j = 0; j <= i; j++) {
                    console.log(char); 
                }
                console.log("\n");
                space--; 
            } 
            for(let i = 0; i < 5; i++) {
                console.log(char);
            }
            console.log("\n");
            space = 0;  
            for (let i = len/2; i > 0; i=i-2) { 
                for (let j = 0; j < space; j++){
                    console.log(" "); 
                }
                for (let j = 0;j < i; j++) { 
                    console.log(char); 
                }
                console.log("\n"); 
                space++;
            }
            break;
        default:
            console.log("ERROR! Enter valid Shape");
    }
}

//Q9
function runObj() {
    let object = document.getElementById('objInput').value;
    document.getElementById('objOutput').innerHTML = `${obj(string)}`;
}

function obj(object) {
    let string = str.split("");
    let revs = string.reverse().join("");
    console.log(str);
    console.log(revs);
    return str==revs;
}

//Q14
$(() => {
    setInterval(function() {
        let time = new Date();
        $('#timeOutput').html(time.toLocaleTimeString());
    },1000)
})

//Q15
function runDesc() {
    let num = document.getElementById('descInput').value;
    document.getElementById('descOutput').innerHTML =  `${desc(num)}`;
}

function desc(num) {
    let arr = num.split("");
    let t = false;
    while (t == false) {
        t = true;
        for (let i = 0; i<arr.length-1; i++) {
            let tmp;
            if (arr[i]<arr[i+1]) {
                tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
                t = false;
            }
        }
    }
    arr = arr.join("");
    return arr;
}