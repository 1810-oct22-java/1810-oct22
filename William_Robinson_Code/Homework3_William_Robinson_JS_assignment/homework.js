
    //function will run as soon as page loads fully
    //alert("page has loaded!");
    //console.log("woo we're in the console");
    
/*



8. Shapes

Define function: printShape(shape, height, character)

shape is a String and is either "Square", "Triangle", "Diamond".

height is a Number and is the height of the shape. Assume the number is odd.

character is a String that represents the contents of the shape. Assume this String contains just one character.

Use a switch statement to determine which shape was passed in.

Use the console.log function to print the desired shape.


Example for printShape("Square", 3, "%");

%%%

%%%

%%%

Example for printShape("Triangle", 3, "$");

$

$$

$$$

Example for printShape("Diamond", 5, "*");

*

***

*****

***

*



9. Object literal

Define function traverseObject(someObj)

Print every property and it's value.










14. Display the current time on the top right of your HTML page, 

updating every second



15. Descending order

Your task is to make a function that can take any non-negative 

integer as a argument and return it with its digits in descending 

order. Essentially, rearrange the digits to create the highest possible number.
*/




window.onload = function(){

    document.getElementById('runFib').addEventListener("click", runFib, true);
    document.getElementById('runFib1').addEventListener("click", runFib1, true);
    document.getElementById('runFib2').addEventListener("click", runFib2, true);
    document.getElementById('runFib3').addEventListener("click", runFib3, true);
    document.getElementById('runFib4').addEventListener("click", runFib4, true);
    document.getElementById('runFib5').addEventListener("click", runFib5, true);
    document.getElementById('runFib6').addEventListener("click", runFib6, true);
    document.getElementById('runFib7').addEventListener("click", runFib7, true);
    document.getElementById('runFib8').addEventListener("click", runFib8, true);
    document.getElementById('runFib9').addEventListener("click", runFib9, true);
    document.getElementById('runFib10').addEventListener("click", runFib10, true);
    document.getElementById('runFib11').addEventListener("click", runFib11, true);
    document.getElementById('runFib12').addEventListener("click", runFib12, true);
   // document.getElementById('runFib13').addEventListener("", runFib13, true);
    document.getElementById('runFib14').addEventListener("click", runFib14, true);
   // document.getElementById('runFib15').addEventListener("click", runFib15, true);
    }
 /*   1. Fibonacci 

Define function: fib(n) 

Return the nth number in the fibonacci sequence.*/
    
    function runFib(){
        var n = document.getElementById('fibInput').value;
        console.log(n);
        document.getElementById("fibOutput").innerHTML = `fib(n) = ${fibR(n)}`;}
    function fibR(n){
        if(n == 0 | n == 1) return n;
        return fibR(n-1) + fibR(n-2);}
    function fib(n){ }
    
  //  var thisIsGlobal = "look at me!";

//function runFib1(){
   // var test = [9,8,7,6,5,4,3,3,2,1,0];
    function runFib1(){
     
        
        
        //take input and call runFib1 function
  document.getElementById('fibInput1').value;
     // console.log();
     document.getElementById("fibOutput1").innerHTML = `fib1n() = ${fib1()}`;
    // Document.Write(y + " ");
    }
    

/*
2. Bubble Sort

Define function: runFib1(numArray)

Use the bubble sort algorithm to sort the array.

Return the sorted array.
*/



    function runFib1(){
      
        needNextPass = true;
     let   test = [9,8,7,6,5,4,3,3,2,1,0];
         for (k = 1; k < test.length && needNextPass; k++) {
           // Array may be sorted and next pass not needed
           needNextPass = false;
           for (i = 0; i < test.length - k; i++) {
             if (test[i] > test[i + 1]) {
               // Swap list[i] with list[i + 1]
               temp = test[i];
               test[i] = test[i + 1];
               test[i + 1] = temp;
               
               needNextPass = true; // Next pass still needed
             }
           }
         }
                  return test;
        }
    function fib1n(){
        
    var t = runFib1();
return t;
       // for (i = 0; i < test.length; i++){
        //test = test.split("");
    }
      //  return test;
    //}
       function fib1(){  }




//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

function runFib2(){
  
    var s = document.getElementById('fibInput2').value;
    console.log(s);
  //  document.Write(s);
document.getElementById("fibOutput2").innerHTML = `rs(s) = ${fib2(s)}`;
//document.getElementById("fibInput2").innerHTML = "This is  String";
 //Document.Write(y + " ");
}


function fib2(s){
  var s = new String(s);
 var ch = s.split("");
    var v = new String();
    var h = new String();
      for (i = ch.length; i> 0; i--){
   h += v.concat(ch[i-1]);
      }
     return h;
}

function rs(s){

}

/*
4. Factorial

Define function: factorial(someNum)

Use recursion to compute and return the factorial of someNum.
*/


function runFib3(){
    var n = document.getElementById('fibInput3').value;
    console.log(n);
    document.getElementById("fibOutput3").innerHTML = `fib3(n) = ${fibR3(n)}`;}
function fibR3(n){
    if (n == 0) // Base case
          return 1;
        else
          return n * fibR3(n - 1); // Recursive call
      }
function fib3(n){}


/*

5. Substring

Define function substring(someStr, length, offset)

Return the substring contained between offset and (offset + length) inclusively.

If incorrect input is entered, use the alert function and describe why the input was incorrect.

*/


function runFib4(n,i){
    var n = document.getElementById('fibInput4').value;
    var i = document.getElementById('fibInput15').value;
    console.log(n);
  //  console.log(i);
    document.getElementById("fibOutput4").innerHTML = `fib4(n,i) = ${fibR4(n,i)}`;}
function fibR4(n, i){
    alert("Please enter a string in first box and enter number of characters to return in second box")
    var s = new String(n);
    var ch = s.split("");
       var v = new String();
       var h = new String();

    for(j = 0; j < i; j++) {
        h += v.concat(ch[j]);
    }
    return h;
}

function fib4(n){ }

/*
6. Even Number

Define function: isEven(someNum)

Return true if even, false if odd.

Do not use % operator.
*/


function runFib5(){
    var n = document.getElementById('fibInput5').value;
    console.log(n);
    document.getElementById("fibOutput5").innerHTML = `fib5(n) = ${fibR5(n)}`;}
function fibR5(n){
  var a =  Number(n).toString(2);
  var h = a.split("");
 


  if (h.pop() == "1") 
  return "Number is odd" + " " + a; 
  else {
      return "Number is even" + " " + a; 
}
}
function fib5(n){ }

/*

7. Palindrome

Define function isPalindrome(someStr)

Return true if someStr is a palindrome, otherwise return false

*/
function runFib6(){
    var n = document.getElementById('fibInput6').value;
    console.log(n);
    document.getElementById("fibOutput6").innerHTML = `fib6(n) = ${fibR6(n)}`;}
function fibR6(n){
    // palindrom method implementation
        // Create a Scanner
       var s = new String();
       s = new String(n);
         n = fib2(n);
         

         if (n == s){
             return "The string " + n + " is a Palindrome";
         } else{
            return "The string " + n + " is not a Palindrome";
         }
    /*

  */
}
function fib6(n){ }

function runFib7(){
    var n = document.getElementById('fibInput7').value;
    console.log(n);
    document.getElementById("fibOutput7").innerHTML = `fib7(n) = ${fibR7(n)}`;}
function fibR7(n){

}
function fib7(n){ }

function runFib8(){
    var n = document.getElementById('fibInput8').value;
    console.log(n);
    document.getElementById("fibOutput8").innerHTML = `fib8(n) = ${fibR8(n)}`;}
function fibR8(n){
    if(n == 0 | n == 1) return n;
    return fibR8(n-1) + fibR8(n-2);}
function fib8(n){ }

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/


function runFib9(){
    
    document.getElementById('fibInput9').value;
    document.getElementById("fibOutput9").innerHTML = `fib9(n) = ${fibR9()}`;}
function fibR9(){
    var fruits = ["Banana", "Orange", "Apple", "Mango", "Grapes", "Watermelon", "Cantaloupe", "Blueberries","Strawberries"];
    var fruits2 =["Banana", "Orange", "Apple", "Mango", "Grapes", "Watermelon", "Cantaloupe", "Blueberries","Strawberries"];
    delete fruits2[0];
    return "The length of first array is: " +fruits.length +" The first array is: " + fruits + " "+ "Array after deleting first element: " +fruits2 +" The length of the second array: " + fruits2.length ;   
    }
function fib9(){ }


/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
function runFib10(){
    document.getElementById('fibInput10').value;
  //  console.log(n);
    document.getElementById("fibOutput10").innerHTML = `fib10(n) = ${fibR10()}`;}
function fibR10(){
    var fruits = ["Banana", "Orange", "Apple", "Mango", "Grapes", "Watermelon", "Cantaloupe", "Blueberries","Strawberries"];
return "The length of first array is: " +fruits.length +" The first array is: " + fruits + " "+ "Array after removing third element: " +fruits.slice(fruits.splice(2, 1)) +" The length of the second array: " + fruits.length ;      
            }
function fib10(){ }


/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
var john = new Person("John", 30);
*/

function runFib11(){
    document.getElementById('fibInput11').value;
    console.log();
    document.getElementById("fibOutput11").innerHTML = `fib11() = ${fibR11()}`;}
function fibR11(){
    function Person(name, age) {
        this.name = name;
       this.age = age;
    }
    var john = new Person("John", 30);
    return "Person name is: " +john.name + " " + "age is: " + john.age;
  
}
function fib11(){ }

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
var john = getPerson("John", 30);
*/

function runFib12(){
    document.getElementById('fibInput12').value;
    console.log();
    document.getElementById("fibOutput12").innerHTML = `fib12() = ${fibR12()}`;}
function fibR12(){
    var person = {
        name: "John",
        age : 30,
        getPerson : function() {
            return this.name + " " + this.age;
        }
    };
    return person.getPerson("John", 30);
    }
function fib12(){ }

function runFib13(){
    var n = document.getElementById('fibInput13').value;
    console.log(n);
    document.getElementById("toprightcorner").innerHTML = `fib13(n) = ${fibR13(n)}`;}
function fibR13(n){

}
function fib13(n){ }

function runFib14(){
    var n = document.getElementById('fibInput14').value;
    console.log(n);
    document.getElementById("fibOutput14").innerHTML = `fib14(n) = ${fibR14(n)}`;}
function fibR14(n){
    if(n == 0 | n == 1) return n;
    return fibR14(n-1) + fibR14(n-2);}
function fib14(n){ }

/*window.onload = function(){
    // function will run as soon as page loads fully
    alert("page has loaded")
    console.log("woo we're in the console");


document.getElementById('runFib').addEventListener("click", runFib, true);

}

function runFib(){

    // take input and call fibonacci function
   // console.log("clicking button");
    var n = document.getElementById('fibInput').addEventListener("click", runFib, true);*/
    
 /*   var n = document.getElementById('fibInput').addEventListener("click",function(){
        var n = runFib
    }, true);*/
  /*  console.log(n);
    console.log(`fib(n) = ${fib(n)}`);
    document.getElementById(`fibOutput`).innerHTML = fib(n);

 //   document.getElementById("fibOutput").innerHTML = `fib(n)`
}



function fibR(n){
    if(n == 0 | n == 1) return n;
    return fibR(n-1) + fibR(n-2);
}

function fib(n){

}

var thisIsGlobal = "look at me!";*/

/**
 * <!DOCTYPE html>
<html>
<body>

<h2>What Can JavaScript Do?</h2>

<p id="demo">JavaScript can change HTML content.</p>

<button type="button" onclick='document.getElementById("demo").innerHTML = "Hello JavaScript!"'>Click Me!</button>


<h2>My First JavaScript</h2>

<button type="button"
onclick="document.getElementById('demo').innerHTML = Date()">
Click me to display Date and Time.</button>

<p id="demo"></p>

<p>JavaScript can change HTML attribute values.</p>

<p>In this case JavaScript changes the value of the src (source) attribute of an image.</p>

<button onclick="document.getElementById('myImage').src='pic_bulbon.gif'">Turn on the light</button>

<img id="myImage" src="pic_bulboff.gif" style="width:100px">

<button onclick="document.getElementById('myImage').src='pic_bulboff.gif'">Turn off the light</button>

<p id="demo">JavaScript can change the style of an HTML element.</p>

<button type="button" onclick="document.getElementById('demo').style.fontSize='35px'">Click Me!</button>

<p id="demo">JavaScript can hide HTML elements.</p>

<button type="button" onclick="document.getElementById('demo').style.display='none'">Click Me!</button>

<p>JavaScript can show hidden HTML elements.</p>

<p id="demo" style="display:none">Hello JavaScript!</p>

<button type="button" onclick="document.getElementById('demo').style.display='block'">Click Me!</button>








</body>
</html>
 * 
 */