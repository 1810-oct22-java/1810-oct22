/**
 * @author Gerald Roman
 * @name Intro to JS
 * @since 11/6/18
 * 
 */

 /*
 JavaScript is a scripting language used for client-side operations; although there are frameworks that allow you to write  server side JS

 - loosely typed - do not declare variable types. simply declare variable with the declarative keyword var,let,const. the types of the avriables are then dynamically allocated (see w typeof() operator)

 -var scopes:
    -> global - accessible throughout the entirety of the script and through the browser. Gobally scoped variables are anythong daclared outside of a block of function or variables that are never declared at all
    -> functions - declared in function/passed in as parameter. accessible only throughout function
    -> block- new to ES6. can only obtaain with variables declared with let or const keywords.

- some familiar terms - if..else,return,switch,try..catch,do..while,for,break, continue,while
- load and go delivery
 
 */
var a = 5;
var b = 'this is a string stored with single quotes';
var c = "this is a string with double quotes. both work";
var obj = {
    name : 'Gerald Roman',
    job : 'Developer',
    bio : 'I love food',
}
obj.name;
obj["name"];
obj["about me"] = "this is how we can create and access properties"+
"of our objects with spaces in their names; not that you shoud"+
"ever do that...";
obj.age = 100;


//FOR... IN loop - iterate through properties of an object
for(var prop in obj){
    //the following includes a few new concepts
    //console.log prints to your client console //check github for more
    console.log(`${prop}: ${obj[prop]}`)
}

/*
DATA TYPES of JS and TYPE COERCION
- as a loosely typed language that is intepreted and not compoiled, JS has to be able to accomodate comparisons between and manipulation on 
otherwise incompatible data types(such as string)

-Type coercion is the process that JS takes to bring data from one type to another to compared actual value ass opposed to the datatype that the value would be held in

== allows type coersion
=== restricts type coersion

*/

7 == 7;//true
7 == "7";//true
7 === "7"; //false

7 + 7 + 7; //21
7 + 7 + '7';//147
'7' + 7 +7; //777

var exp = (7);
if(exp){
    console.log("this is true")
}
else{
    console.log("this is false")
}
/* TRUTHY and FALSY
- everything in JS evaluates to a boolean either true or false
- though we only refer to TRUE and FALSE and true and false, respectively,
other values have been dubbed "truthy" and "falsy"

FALSY = ''(empty string), undefined, 0, null, false, NaN
TRUTHY = everything else(including 'false'



)

*/
function truthyOfFalsy(exp){
    if(exp) return "this is true";
    else return "this is false";
}

/* STRINGS
    - 0 or more 16-bit characters
    - " or ', but not for the same string
    - string.length 
    - other important methods - charAt, concat, indexOd, replace, split, slice, substring
    - seach w regex
    - Immutable

*/


// MORE ON FUNCITONAL AND ARROW NOTATIONS
function test(){
    return 0;
}
function regularWithParams(a,b){
    return a + b;
}
function doesNotHaveToReturnThings(a,b){
    console.log(a);
}
//func() anonymous
var func = function(x){
    console.log("Doing cool things with js")
    return x;
}
var add = function(a , b){return a + b};

var addArrow = (a,b)=> {return a + b;}