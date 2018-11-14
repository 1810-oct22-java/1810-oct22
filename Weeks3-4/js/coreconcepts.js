/**
 * @author Genesis Bonds
 * @name Intro to JS
 * @since 11/6/18
 */

 /*

 JavaScript is a scripting language used for client-side operations; although
 there are frameworks that allow you to write Server-side JS

 - loosely typed - do not declare variable types. simply declare variables 
        with the declarative keywords var, let, const. The types of the 
        variables are then dynamically allocated. (see w typeof() operator)
 - var scopes:
        -> global - accessible throughout the entirety of the script and 
            through the browser. Globally scoped variables are anything 
            declared outside of a block or function OR variables that are
            never declared at all. 
        -> function - declared in function/passed in as parameter. accessible
            only throughout function 
        -> block - new to ES6. Can obly obtain with variables declared with 
            let or const keywords. 
 - some familiar terms - if.. else, return, switch, try.. catch, do..while, 
    for, break, continue, while
 - load and go delivery 
 - Datatypes: 
    - number, string, booleans ("primitive types")
    - objects {}
    - undefined (defult val for vars that were never defined)
    - null
    - NaN (debatable.. typeOf(NaN) = number)
 */

 var a = 5;
 var b = 'this is a string with single quotes';
 var c = "this is a string with double quotes. both work";
 //var no = "this is a string';
 var obj = {
     name : 'Genesis Bonds',
     job : 'Senior Trainer', 
     bio : 'I really like food'
 };

 obj.name;
 obj["name"];
 obj["about me"] = "this is how we can create and access properties " + 
    "of our objects with spaces in their names; not that you should "+ 
    "ever do that..";
obj.age = 100;

// FOR... IN LOOP - iterate through properties of an object
for(var prop in obj){
    //the following includes a few new concepts
    //console.log prints to your client console
    //`` and ${} indicate string interpolation/template literals, which 
    //  allow for the easy displaying of data and evaluation of expressions
    console.log(`${prop}: ${obj[prop]}`);
}

y = `The sum of 5 and 10 = ${5 + 10}`;

//for.. of -- enhanced for 







/*
DATA TYPES OF JS, and TYPE COERCION 
- As a loosely typed language that is interpreted and not compoiled, JS
has to be able to accomodate comparisons between and manipulation on 
otherwise incompatible data types (such as string and number, or boolean and obj)
- Type coercion is the process that JS takes to bring data from one 
type to another to compare actual value as opposed to the datatype 
that the value would be held in 

== - allows type coersion
=== - restricts type coersion
*/

7 == 7; // TRUE 
7 == '7'; //TRUE - forces type conversion (type coersion)
7 === 7; //TRUE
7 === '7' // FALSE

7 + 7 + 7; // 21
7 + 7 + '7'; //147
'7' + 7 + 7; // 777

var exp = (7);
if(exp){
    console.log("this is true");
}
else{
    console.log("this is false");
}

/*TRUTHY AND FALSY
- everything in JS evaluates to a boolean either true or false
- though we only refer to TRUE and FALSE and true and false, respectively, 
other values have been dubbed "truthy" and "falsy" 

Falsy - ''(empty string), undefined, 0, null, false, NaN
Truthy - everything else(including 'false') 
*/
function truthyOrFalsy(exp){
    if(exp) return "this is true";
    else return "this is false";
}


/* STRINGS 
    - 0 or more 16-bit characters
    - " or ', but not for the same string 
    - string.length 
    - other important methods - charAt, concat, indexOf, replace, split, slice, substring 
    - search w regex
    - immutable
*/


//MORE ON FUNCTIONAL AND ARROW NOTATIONS
function test(){
    return 0;
}

function regularWithParams(a, b){
    return a + b;
}

function doesNotHaveToReturnThings(a, b){
    console.log(a);
}

//func(). anonymous 
var func = function(x){
    console.log("doing cool things with js");
    return x;
}

var add = function(a, b){ return a + b};

var addArrow = (a, b)=> {return a + b;}




// scopes, hoising, operators, loops, statements, 

//GUARD AND DEFAULT
<<<<<<< HEAD
/*GUARD &&
- takes two operands
- if the first operand is TRUTHY , it returns the 2nd OPERAND(not true/false, but the operand itself)
otherwise it returns the first operand
*/

var currentSession = null;// 'hasUser';
var userInfo = {username:"gab12", password:'123'}
=======

/* GUARD &&
- takes two operands 
if the first operand is TRUTHY, it returns the 2nd OPERAND(not true/false,
  but the operand itself)
  otherwise it returns the first operand
*/

var currentSession = 'hasUser';
var userInfo = {username: "gab12", password: '123'};

>>>>>>> master
var getUser = currentSession && userInfo;

/*DEFAULT ||
-if the first operand is truthy, return it
if not return the second operand
*/

<<<<<<< HEAD
var leaveEarlyByHours = 1;
var regularLeave = 5;
var timeOut = leaveEarlyByHours || (regularLeave - leaveEarlyByHours);
=======
/*
DEFAULT || 
if the first operand is truthy, return it
if not return the second operand
*/

var leaveEarlyByHours = 1;
var regularLeave = 5;

var timeOut = leaveEarlyByHours || regularLeave;


var timeOut = (leaveEarlyByHours > 0) ? 
            regularLeave - leaveEarlyByHours : regularLeave;


function understandingHoisting(){
    // implicit declarations at top of scope
    //var w, x, y, z;
    console.log(z); //will not give interpreter error. will just print undefined
    var x = 7;
    var y = 10;
    var z = 1;

    if(z == 0){
        //let a, b
        let a = 1;
        let b = 2;
        var w = 'test';
        c = 100; //declaration gets hoisted to top of page bc it was never declared
        //c is global scoped because of this 
    }

}


for (var i = 0; i < 10; i++) {
    (function (j) {
        setTimeout(function() {
         console.log(j);
      }, j*1000);
    })(i);
}
>>>>>>> master

var timeOut = (leaveEarlyByHours > 0) ? regularLeave - leaveEarlyByHours : regularLeave