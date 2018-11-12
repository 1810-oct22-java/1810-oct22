/**
 * @author Ted Airey
 * @name Intro to JS
 * @since 11/6/18
 */

 /* 
 
 JavaScript is a scripting language used for client-side operations; although there are 
 frameworks that allow you to write Server-side JS

 - loosely typed - do not declare variable types. Simply declare variables
    with the declarative keywords var, let, const. The types of the variables
    are then dynamically allocated. (see w typeof() operator)
 - var scopes:
    -> global - accessible throughout the entirety of the script and
        through the browser. Globally scoped variables are anything
        declared outside of a block or function OR variables that are
        never declared at all.
    -> function - declared in function/passed in as parameter. Accessible
        only throughout function
    -> block - new to ES6. Can only obtain with variables declared with
        let or const keywords.

 - Some familiar keywords/terms - if.. else, return, switch, try.. catch, do..while
    for, break, continue, while
 - load and go delivery
 - Datatypes:
    - number, string, booleans ("primitive types")
    - objects {}
    - undefined (default val of vars that were never defined)
    - null
    - NaN (debatable .. type of NaN = number)


A callback function is a function that is executed after another function has finished executing

var whatever = function -> function expression

IIFE- immediately invoked function expression

 */

 var a = 5;
 var b = 'this is a string with single quotes';
 var c = "this is a string with double quotes. both work";

 var obj = {
     name: 'Ted Airey',
     job: 'Trainee',
     bio: 'I really like food'
 };

 obj.name;
 obj["name"];
 obj["about me"] = "this is how we can create and access properties " +
    "of our objects with spaces in their names; not that you should " +
    "ever do that..";

 obj.age = 100;


// FOR ... IN LOOP - iterate through properties in an object
for (var prop in obj) {
    //the following includes a few new concepts
    //console.log prints to your client console
    //`` and ${} indicate string interpolation/template literals,
    // which allow for the easy displaying of data and evaluation
    // of expressions
    console.log (`${prop}: ${obj[prop]}`);
}

y = `The sum of 5 and 10 = ${5+10}`;

/*
DATA TYPES OF JS, and TYPE COERCION (coercion means force)

- as a loosely typed language that is interpreted and not compile, JS
has to be able to accomodate comparisons between and manipulation on
otherwise incompatible data types (such as string and number, or boolean and obj)
- Type coercion is the process that JS takes to bring data from one
type to another to compare actual value as opposed to the datatype
that the value would be held in

== - allows type coersion
=== - restricts type coersion
*/

7 == 7; // TRUE
7 == '7'; //TRUE - forces type conversion (type coercion)
7 === 7; //TRUE
7 === '7'; //FALSE

7 + 7 + 7; //21
7 + 7 + '7'; //'147'
'7' + 7 + 7; //'777'

var exp = (7==7);
if (exp) {
    console.log("this is true");
}
else {
    console.log("this is false");
}

/*TRUTHY AND FALSY
- everything in JS evaluates to a boolean either true or false
- though we only refer to TRUE and FALSE and true and false, repesctively,
other values have been dubbed "truthy" and "falsy"

Falsy = ''(empty string), undefined, 0, null, false, NaN
Truthy = everything else, including ('false')  

*/
function truthyOrFalsy(exp) {
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

//MORE ON FUNCTIONAL AND ARROWS NOTATIONS

function test(){
    return 0;
}

function regularWithParams(a,b) {
    return a+b;
}

function doesNotHaveToReturnThings(a,b) {
    console.log(a);
}

//func(). anonymous function
var func = function(x){
    console.log("doing cool things with js");
    return x;
}

//following two do the same thing
var add = function(a,b) { return a+b};

var addArrow = (a,b)=> {return a+b; }


//scopes, hoising, operators, loops, statements

//var will never give block scope unless "let" is included

//var y
window.onload = function() {
    var count = 0;
    doThings(count);
}

//declaring function
// could be 
// var f = function() {
//      return "test";
// }
// IIFE - Immediately invoked function expression
//


function doThings(count) {
    //implicit x,z
    var x = 5;
    console.log(z);
    y = 6;
    var z = 10;
}

function test() {

}

/*GUARD &&
-takes two operands
if the first operand is TRUTHY, it returns the 2nd operand(not true/false,
    the operand itself)
    otherwise it returns the first operand
*/
var currentSession = null;
var userInfo = {username: "gab12", password: '123'};

var getUser = currentSession && userInfo; //guards info behind the && signs

/* 
DEFAULT || 
if the first operand is truthy, return it
if not return the second operand
*/

var leaveEarlyByHours = 1;
var regularLeave = 5;

var timeOut = leaveEarlyByHours || regularLeave;

var timeOut = (leaveEarlyByHours > 0) ? regularLeave - leaveEarlyByHours : regularLeave;