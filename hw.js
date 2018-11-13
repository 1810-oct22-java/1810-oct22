window.onload = function(){
    document.getElementById('runFib').addEventListener("click", runFib, true); //1
    document.getElementById('runBubble').addEventListener("click", runBubble, true); //2
    document.getElementById('runReverseString').addEventListener("click", runReverseString, true); //3
    document.getElementById('runFactorial').addEventListener("click", runFactorial, true); //4
    document.getElementById('runIsEven').addEventListener("click", runIsEven, true); //5
    document.getElementById('runIsPalindrome').addEventListener("click", runIsPalindrome, true); //6
    document.getElementById('runDeleteElement').addEventListener("click", runDeleteElement, true); //7
    document.getElementById('runSpliceElement').addEventListener("click", runSpliceElement, true);//8
    document.getElementById('runPerson').addEventListener("click", runPerson, true);//9
    document.getElementById('runDesc').addEventListener("click", runDesc, true);//10
}

function runFib(){
    //take input and call fibonacci function
    console.log("clicking button");
    var n = document.getElementById('fibInput').value;
    console.log(n);
    console.log(`fib(n) = ${fib(n)}`);
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${fib(n)}`);
    elem.appendChild(pojo);
    document.getElementById('fibOutput').appendChild(elem);
}

function runBubble(){
    var arr = document.getElementById('bubbleInput').value;
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${bubble(arr)}`);
    elem.appendChild(pojo);
    document.getElementById('bubbleOutput').appendChild(elem);
    console.log(arr);
}

function bubble(arr){
    console.log(arr);
    var num = arr.split(",");
    var arrnum = num.map(Number);
    var n = arrnum.length;
    for (var i = 0; i < n; i++) {
        for (var j = 0; j < n - i - 1; j++) {
            if (arrnum[j] > arrnum[j + 1]) {
                [arrnum[j], arrnum[j + 1]] = [arrnum[j + 1], arrnum[j]];
            }
        }
        //nm.join(' ');
    }
    return arrnum;
}



function fib(n){
    if(n == 0 | n == 1) return n;
    return fib(n-1) + fib(n-2);
}

function runReverseString(){
    console.log("clicking button");
    var str = document.getElementById('reverseStringInput').value;
    console.log(str);
    console.log(`reverseString(str) = ${reverseString(str)}`);
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${reverseString(str)}`);
    elem.appendChild(pojo);
    document.getElementById('reverseStringOutput').appendChild(elem);
}

function reverseString(str){
    var splitString = str.split("");
    var revStr = splitString.reverse();
    var result = revStr.join("");
    return result;
}

function runFactorial(){
    console.log("clicking button");
    var n = document.getElementById('factorialInput').value;
    console.log(n);
    console.log(`factorial(n) = ${factorial(n)}`);
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${factorial(n)}`);
    elem.appendChild(pojo);
    document.getElementById('factorialOutput').appendChild(elem);
}

function factorial(someNum){
    var f = [];
    if (someNum == 0 || someNum == 1){
        return 1;
    }
    if (f[someNum] > 0){
        return f[someNum];
    }
    return f[someNum] = factorial(someNum-1) * someNum;
}

function runIsEven(){

    var someNum = document.getElementById('isEvenInput').value;
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${isEven(someNum)}`);
    elem.appendChild(pojo);
    document.getElementById('isEvenOutput').appendChild(elem);
}

function isEven(someNum){
    
    return ( someNum & 1 ) ? false : true;
}

function runIsPalindrome(){

    var someStr = document.getElementById('isPalindromeInput').value;
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${isPalindrome(someStr)}`);
    elem.appendChild(pojo);
    document.getElementById('isPalindromeOutput').appendChild(elem);
}

function isPalindrome(someStr){
    string= someStr.split('').reverse().join('');
    if(string === someStr){
        return true;
    } 
    else{
        return false;
    }
}

function runDeleteElement(){

    var someArr = document.getElementById('deleteElementInput').value;
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${deleteElement(someArr)}`);
    elem.appendChild(pojo);
    document.getElementById('deleteElementOutput').appendChild(elem);
}

function deleteElement(someArr){
    var num = someArr.split(",");
    var arrnum = num.map(Number);
    console.log(arrnum);
    console.log(arrnum.length);
    var original = arrnum.length;
    arrnum[2] = null;
    console.log(arrnum.length);
    var result = arrnum.lenth;
    console.log(arrnum);
    return "Original length " + original + ". New length: " + result;
}

function runSpliceElement(){

    var someArr = document.getElementById('spliceElementInput').value;
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${spliceElement(someArr)}`);
    elem.appendChild(pojo);
    document.getElementById('spliceElementOutput').appendChild(elem);
}

function spliceElement(arr){
    var num = arr.split(",");
    var someArr = num.map(Number);
    console.log(someArr.length);
    var original =someArr.length;
    someArr.splice(2, 1);
    console.log(someArr.length);
    var after = someArr.length;
    return "Original length: " + original + ". Splice length: " + after;
}

function runPerson(){

    var input1 = document.getElementById('personInput1').value;
    console.log(input1);
    var input2 = document.getElementById('personInput2').value;
    console.log(input2);
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${Person(input1, input2)}`);
    elem.appendChild(pojo);
    document.getElementById('personOutput').appendChild(elem);
}

function Person(name, age){
    this.name = name;
    this.age = age;
    return this.name + " " + this.age;
}
var john = new Person("John", 30);
console.log(john);


function runDesc(){

    var someNum = document.getElementById('descInput').value;
    const elem = document.createElement("DIV");
    var pojo = document.createTextNode(`${desc(someNum)}`);
    elem.appendChild(pojo);
    document.getElementById('descOutput').appendChild(elem);
}


function desc(n){
    for(var i = n-1; i >= 0; i--){
        n = n + '' + i;
    }
    return n;
}