window.onload = function(){
    //function will run as soon as page loads fully
    //alert("page has loaded!");
    //console.log("woo we're in the console");
    
    document.getElementById('runFib').addEventListener("click", runFib, true);
    document.getElementById('runBS').addEventListener("click", runBS, true);
    document.getElementById('runReverse').addEventListener("click", runReverse, true);
    document.getElementById('runFactorial').addEventListener("click", runFactorial, true);
    document.getElementById('runSubstring').addEventListener("click", runSubstring, true);
    document.getElementById('runIsEven').addEventListener("click", runIsEven, true);
    document.getElementById('runPalindrome').addEventListener("click", runPalindrome, true);
    document.getElementById('runDelete').addEventListener("click", runDelete, true);
    document.getElementById('runSplice').addEventListener("click", runSplice, true);
    document.getElementById('runDO').addEventListener("click", runDO, true);

    
    
}
    //Question 1 - Fibonacci
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

    //Question 2 - Bubble Sort
    function runBS(){
        var bsArray = document.getElementById('bsInput').value;
        console.log(bubbleSort(bsArray));
        document.getElementById("bsOutput").innerHTML = `BubbleSort(bsArray) = ${bubbleSort(bsArray)}`;
    }
   

    function bubbleSort(bsArray) {
       let swapped = false;
       let arr = bsArray.split(",");
       let end = arr.length - 1;
       while(swapped == false) {
           swapped = true;
            for(let i = 0; i < end; i++){
                if(arr[i] > arr[i + 1]){
                    swapped = false;
                    let temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
       end--;

       return arr;
    }
   
    //Question 3 - Reverse String
    function runReverse(){
        var someStr = document.getElementById('revInput').value;
        console.log(reverseStr(someStr));
        document.getElementById("revOutput").innerHTML = `reverseStr(someStr) = ${reverseStr(someStr)}`;
    }

    function reverseStr(someStr){
        return someStr.split("").reverse().join("");
    }

    //Question 4 - Factorial
    function runFactorial(){
        var someNum = document.getElementById('factInput').value;
        console.log(factorial(someNum));
        document.getElementById("factOutput").innerHTML = `factorial(someNum) = ${factorial(someNum)}`;
    }

    function factorial(someNum){
        if (someNum < 0){
            return -1;
        }
        else if(someNum == 0) {
            return 1;
        }
        else{
            return (someNum * factorial(someNum-1));
        }
    }

    //Question 5 - Substring
    function runSubstring(){
        var someString = document.getElementById('strInput').value;
        var stringLength = document.getElementById('lenInput').value;
        var stringOffset = document.getElementById('offsetInput').value;
        document.getElementById("substringOutput").innerHTML = `substring(string, length, offset) =
         ${substring(someString, stringLength, stringOffset)}`;
        if(someString == ''){
            alert("Must enter a string!");
        } 
    }

    function substring(someString, stringlength, stringoffset){
        var t = "";
        var len = parseInt(stringlength);
        var off = parseInt(stringoffset);
        var sub = len + off;
        t = someString.substring(stringoffset - 1, sub);
        return t; 
    }

    //Question 6 - Is Even
    function runIsEven(){
        var evenNum = document.getElementById('evenInput').value;
        console.log(isEven(evenNum));
        document.getElementById("evenOutput").innerHTML = `isEven(evenNum) = ${isEven(evenNum)}`;

    }

    function isEven(evenNum) {
        if(evenNum % 2 == 0){
            return true;
        }
        else{
            return false;
        }

    }

    //Question 7 - Palindrome

    function runPalindrome(){
        var pal = document.getElementById('palInput').value;
        console.log(palindrome(pal));
        document.getElementById("palOutput").innerHTML = `palindrome(pal) = ${palindrome(pal)}`;

    }
    
    function palindrome(pal){
        var re = /[\W_]/g;
        var lowRegStr = pal.toLowerCase().replace(re, '');
        var reverseStr = lowRegStr.split('').reverse().join(''); 
        return reverseStr === lowRegStr;

    }

    //Question 10 - Delete Element
    function runDelete(){
        var del = document.getElementById('delInput').value;
        console.log(deleteArr(del));
        document.getElementById("delOutput").innerHTML = `deleteArr(del) = ${deleteArr(del)}`;

    }


    function deleteArr(del){
    var arr = del.split(",");
    delete arr[2];
    console.log(arr);
    console.log(arr.length);
    return arr.length;

    }

    //Question 11 - Splice
    function runSplice(){
        var spl = document.getElementById('splInput').value;
        console.log(spliceArr(spl));
        document.getElementById("splOutput").innerHTML = `spliceArr(spl) = ${spliceArr(spl)}`;

    }

    function spliceArr(spl){
        var arr = spl.split(",");
        arr.splice(2,1);
        console.log(arr);
        console.log(arr.length);
        return arr.length;


    }

    //Question 15 - Descending Order
    function runDO(){
        var doInt = document.getElementById('intInput').value;
        console.log(descOrder(doInt));
        document.getElementById("intOutput").innerHTML = `descOrder(doInt) = ${descOrder(doInt)}`;
        if(doInt < 0) {
            alert("Must enter a POSITIVE NUMBER!")
        }

    }


    function descOrder(doInt){
        arr = doInt.split("");
        arr.sort(function(a,b){return b-a});
        return arr.join("");


    }