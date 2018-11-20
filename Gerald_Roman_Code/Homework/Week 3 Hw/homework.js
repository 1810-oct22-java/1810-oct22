window.onload = function () {

    //Problem 1
    document.getElementById('runFib').addEventListener("click", runFib, true);
    //Problem 2
    document.getElementById('runBubble').addEventListener("click",runBubble,true)
    //Problem 3
    document.getElementById('runRevStr').addEventListener("click",runRevStr,true)
    //Problem 4
    document.getElementById('runFac').addEventListener("click", runFac, true)
    //Problem 5
    document.getElementById('runSubstring').addEventListener("click",runSubstring,true)
    //Problem 6
    document.getElementById('runEven').addEventListener("click", runEven, true)
    //Problem 7
    document.getElementById('runPalidrome').addEventListener("click", runPalidrome, true)
    //Problem 8
    document.getElementById('runShapes').addEventListener("click",runShapes,true)
    //Problem 14
    document.getElementById('runTime').addEventListener("click",runTime,true)

}
//Problem 1
function runFib() {
    var n = document.getElementById('fibInput').value;
    console.log(n);
    console.log(`fib(n) = ${fibR(n)}`);
    const out = document.createElement("DIV");
    var x = document.createTextNode(`${fibR(n)}`);
    out.appendChild(x);
    document.getElementById('fibOutput').appendChild(out);

}

function fibR(n) {
    if (n == 0 | n == 1) return n;
    return fibR(n - 1) + fibR(n - 2);
}
//Problem 2
function runBubble(){
    var n = document.getElementById('bubbleInput').innerHTML
    console.log(n)
    console.log(`BubbleSort(n) = ${bubbleSort(n)}`)
    const out = document.createElement("DIV")
    var x = document.createTextNode(`${bubbleSort(n)}`)
    out.appendChild(x)
    document.getElementById('bubbleOut').appendChild(out)
}
function bubbleSort(n){
    var temp = []
    for(var i = 0; i < n.length;i++){
        for(var j = 0; j <(n.length-i-1);j++){
            if(n[j] > n[j+1]){
                var temp = n[j]
                n[j] = n[j+1]
                n[j+1] = temp
            }
        }
    }
  //  return temp
    return temp
}
/*
function bubbleSort(n){
    for(let i = 0; i < (n.length-1);i++){
        for(let j = 0; j < (n.length-i-1);j++){
            swap = arr[j]
            arr[j] = arr[j + 1]
            Array[j+1] = swap
        }
    }
}
*/
//Problem 3
function runRevStr() {
    let word = document.getElementById("revInput").value
    console.log(word)
    console.log(`ReverseString(word) = ${revStr(word)}`)
    const out = document.createElement("DIV")
    var x = document.createTextNode(`${revStr(word)}`)
    out.appendChild(x)
    document.getElementById('revOut').appendChild(out)

}
function revStr(word) {
    let rStr = ""
    for (let i = word.length - 1; i >= 0; i--) {
        rStr += word.charAt(i);
    }
    return rStr
}


//Problem 4
function runFac() {
    var n = document.getElementById("facInput").value
    console.log(n)
    console.log(`Fact(n) = ${facNum(n)}`)
    const out 
    = document.createElement("DIV")
    var x = document.createTextNode(`${facNum(n)}`)
    out.appendChild(x)
    document.getElementById('facOutput').appendChild(out)
}

function facNum(n) {
    if (n == 0 || n == 1) {
        return 1
    } else {
        return n * facNum(n - 1)
    }
}
//Problem 5
function runSubstring(){
    var someStr = document.getElementById('string').value
    var length = document.getElementById('length').value
    var offset = document.getElementById('offset').value
    document.getElementById('subOut').innerHTML = substring(someStr,length,offset)
}

function substring(someStr, length, offset){
    var temp =""
    temp = someStr.substring(offset-1,offset + length)
    return temp
}

//Problem 6
function runEven() {
    var a = document.getElementById('evenInput').value;
    console.log(a)
    console.log(`even(a) = ${evenNum(a)}`)
    const out = document.createElement("DIV");
    var x = document.createTextNode(`${evenNum(a)}`)
    //document.getElementById('${evenNum(x)}')//
    out.appendChild(x)
    document.getElementById('evenOut').appendChild(out)
}

function evenNum(a) {
    //console.log(a);
    //if ((Math.floor((a/2)*2) == 0)){
    if (Math.floor(a / 2) * 2 == a) {
        return true;
    } else {
        return false;
    }
}

//problem 7
function runPalidrome() {
    var word = document.getElementById('paliInput').value
    console.log(word)
    console.log(`palindrone(word) = ${palindrome(word)}`)
    const out = document.createElement("DIV")
    var x = document.createTextNode(`${palindrome(word)}`)
    out.appendChild(x)
    document.getElementById('paliOut').appendChild(out)
}

function palindrome(word) {
    let revStr = "";
    for (let i = word.length - 1; i >= 0; i--) {
        revStr += word.charAt(i);
    }
    if (word == revStr) {
        return true;
    } else {
        return false;
    }
}

//Problem 8
function runShapes(shape, height, character) {
    var n = document.getElementById('shapeInput').value;
    var temp = n.split(",");
    console.log(temp)
    var sh = temp[0]
    var he = parseInt(temp[1])
    var chr = temp[2]
    
    console.log(sh)
    console.log(he)
    console.log(chr)

    switch (sh) {
        case "square":
            for (i = 0; i < he; i++) {
                console.log(print(chr));
            }
            console.log(document.write('<br />'));
            break
        case "triangle":
            var line = "";
            for (var i = i; i <= he; i++) {
                for (var j = 1; j <= 1; j++) {
                    line += chr
            }
            console.log(line + "\n");
            break;
        }

        case "diamond":
            for (var i = 1; i <= he; i++) {
                for (var j = 1; j <= i; j++) {
                    console.log(chr);
                }
                console.log(('<br />'));
            }
            //console.log()
            break;
    }
}

//problem 9

//problem 10

//problem 11

//problem 12

//problem 13

//problem 14
function runTime(){
    let time = new Date()
    document.getElementById("timeOut").innerHTML = time;
}

//problem 15
function runDec(){
    var word = document.getElementById('descInput').value
    console.log(word)
    console.log(`descending(order) = ${descending(word)}`)
    const out = document.createElement("DIV")
    var x = document.createTextNode(`${descending(word)}`)
    out.appendChild(x)
    document.getElementById('descOut').appendChild(out)

}
function descending(order){
    var n = document.createTextNode
}