/**
 * comments
 */

var a = 5;
var b = "String";
var c = 'Single Quote';
var obj = {
    name: "Me",
    job: "something",
    variably: "thing"
}

obj.job = "nothing"
obj["about me"] = "stuff";

for(var prop in obj){
    console.log(`${prop}: ${obj[prop]}`);
};

var exp = (7 == 7)
if(exp ){
    console.log("true");
}else{
    console.log("false");
}

function torf(exp){
    if(exp ){
        console.log("true");
    }else{
        console.log("false");
    }   
}

function test(){
    return 0;
}

function regfumc(a,b){
    return a+b;
}

var varx = function(x){console.log(x); return x;}

var add = function(a,b){return a+b}

var addarrow = (a,b) => {return a+b}

function fib(n){
    if( n==0 | n==1 ) return n;
    return fib(n-1) + fib(n-2)
}