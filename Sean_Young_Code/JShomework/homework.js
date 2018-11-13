window.onload = function(){
    //function will run as soon as page loads fully
alert("page has loaded!");
console.log("woo we're in the console");

document.getElementById('runFib').addEventListener("click", runFib, true);
document.getElementById('runStr').addEventListener("click", runStr, true);
document.getElementById('runFactorial').addEventListener("click", runFactorial, true);
document.getElementById('runSubString').addEventListener("click", runSubString, true);
document.getElementById('runEven').addEventListener("click", runEven, true);
document.getElementById('runPalindrome').addEventListener("click", runPalindrome, true);
document.getElementById('runDescending').addEventListener("click", runDescending, true);
document.getElementById('runDelete').addEventListener("click", runDelete, true);
document.getElementById('runBubble').addEventListener("click", runBubble, true);
document.getElementById('runSplice').addEventListener("click", runSplice, true);
}

function runFib(){
    //take input and call fibonacci function
    console.log("clicking button");
    var n = document.getElementById('fibInput').value;
    console.log(n);
    document.getElementById("fibOutput").innerHTML = `fib(n) = ${fibR(n)}`;
}

function fibR(n){
    if(n == 0 | n == 1) return n
    return fibR(n-1) + fibR(n-2);

}

function fibNoRecursion(n){

}

var thisIsGlobal = "look at me!"

function runStr(){
    console.log("clicking button");
    var n = document.getElementById('string').value;
    console.log(n);
    document.getElementById("stringOutput").innerHTML = `reverseS(Str) = ${reverseStr(n)}`;
}
function reverseStr(someStr){
    var reversedString = "";

    for(i= someStr.length-1; i >=0; i--){
        reversedString += someStr[i];
    }
    return reversedString;
}

function runFactorial(){
    console.log("clicking button");
    var bn = document.getElementById('factorial').value;
    console.log(bn);
    document.getElementById("factOutput").innerHTML = `factorial(n) = ${factorial(bn)}`;
}

function factorial(someNum){
    var num = someNum;
    for(let i = someNum -1; i > 1; i--){
        num = num * i; 
    }
    return num;
}


function runSubString(){
    console.log("clicking button");
    var ss = document.getElementById('subString').value;
    console.log(ss);
    var l = document.getElementById('length').value;
    console.log(l);
    var o = document.getElementById('offset').value;
    console.log(o);
    document.getElementById("sstring").innerHTML = `substring = ${subString(ss, l, o)}`;
}

function subString(someStr, length, offset){
    var v = someStr.substring(length, offset);
    return v;
    
}

function runEven(){
    console.log("clicking button");
    var ox = document.getElementById('evenNumber').value;
    console.log(ox);
    document.getElementById("evenOutput").innerHTML = `even Number = ${isEven(ox)}`;
}

function isEven(someNum){
    var number = 1&someNum;
    if(number == 1){
        return false;
    }
    else{
        return true;
    }
    
    
    
   


}

function runPalindrome(){
    console.log("clicking button");
    var r = document.getElementById('palindrome').value;
    console.log(r);
    document.getElementById("palindromeOutput").innerHTML = `palindrome = ${isPalindrome(r)}`;

}
function isPalindrome(someStr){
    reversedStr = "";
    for(i= someStr.length-1; i >=0; i--){
        reversedStr += someStr[i];
    }
    if(reversedStr === someStr){
        return true;
    }
    else{
        return false;
    }
    
}

function runDescending(){
    console.log("clicking button");
    var a = document.getElementById('order').value;
    console.log(a);
    document.getElementById("orderOutput").innerHTML = `descending order = ${descOrder(a)}`;
}

function descOrder(number){
    var anArray = [];
    var a = number;
    for(i = 0; i < a; i++){
        anArray[i] = number;
        number--;
    }
    return anArray;
}


function runDelete(){
    console.log("clicking button");
    var del = document.getElementById('deleteNum').value;
    console.log(del);
    document.getElementById("deleteOutput").innerHTML = `deleted length = ${deleteElement(del)}`;
}


function deleteElement(someArr){
    var thisArray = someArr.split(",")
    delete thisArray[2]
    return thisArray.length;

}

function runBubble(){
    console.log("clicking button");
    var aLog = document.getElementById('bubInput').value;
    console.log(aLog);
    document.getElementById("bubbleOutput").innerHTML = `bubble sort = ${bubbleSort(aLog)}`;
}

function bubbleSort(numArray){
    var length = numArray.length;
    var aNum = numArray.split(",");
    var newArray = aNum.map(Number);

    for(var i = 0; i < length; i++){
        for(var x = 0; x < (length - i - 1); x++){
            if(newArray[x]>newArray[x+1]){
                var temp = newArray[x];
                newArray[x] = newArray[x+1];
                newArray[x+1] = temp;
            }
        }
    }
    return newArray;
}
function runSplice(){
    console.log("clicking button");
    var spl = document.getElementById('splice').value;
    console.log(spl);
    document.getElementById("spliceOutput").innerHTML = `spliceElement length = ${spliceElement(spl)}`;
}

function spliceElement(someArr){
    console.log(someArr);
    var thisArray = someArr.split(",")
    thisArray.splice(3);
    console.log(thisArray.length);
    return thisArray.length;
}





