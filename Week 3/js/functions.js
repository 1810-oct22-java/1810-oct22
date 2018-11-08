/*

About JS Functions:

- functions inherit from objects and may be passed as variables
or stored just like any other value

- no function overloading in JS -- the last function created is used
there is loose typing. Missing parameters are set to undefined extra 
parameters are ignored

- this keyword. "this" represents what the function is bound to at
invocation time

*/

function func(){
    console.log("inside of regular function");
}

func();

/*
A function expression is very similar to and has almost the same syntaz as a funciton
declaration, however the main difference is that a function declaration has a name,
which can be ommitted in function expressions to create anonymous functions and function
expression can be used to create IIFE's which run as soon as they're defined. 
*/

var functionExpression = function () {
    console.log("inside of regular function expression");
}
functionExpression();

//IIFE's are a design pattern, also known as a self-executing anonymous functions

(function() {
    consoe.log ("this is an immediately invoked fucntion expression");
})();//parentheses at the end to invoke function

var person = (function () {
    var name = "Ted";
    return name;
})();

person;
//immediately returned Ted


/*
CLOSURES
Because JS does not have access modifiers or support encapsulation natively,
we used closures(nested functions) to emulate encapsulation

*/

var counter = (function(){
    var privateCounter = 0;
    
    function changeBy(val) {
        privateCounter += val;
    }

    // with brackets, talking about an object
    return {
        increment: function(){changeBy(1);},
        decrement: function(){changeBy(-1);},
        value: function(){return privateCounter;}
    }

})();

counter.privateCounter; //will return undefined. do NOT have access to counter
counter.value(); //return 0
counter.increment();
counter.increment();
counter.increment();
counter.value(); //returns 3

var makeCounter = function(){
    var privateCounter = 0;
    
    function changeBy(val) {
        privateCounter += val;
    }

    // with brackets, talking about an object
    return {
        increment: function(){changeBy(1);},
        decrement: function(){changeBy(-1);},
        value: function(){return privateCounter;}
    }

};

makeCounter.increment();
var counter1 = makeCounter();
counter1.increment();
var counter2 = makeCounter();
counter2.decrement();

//JSON - JavaScript Object Notation
