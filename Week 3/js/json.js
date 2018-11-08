/*
JSON - JavaScript Object Notation is a minimal, readable format for
structuring data. It is used primarily to transmit data between server
and data. 
*/
let person = {
    name: 'TA',
    workplace: 'Revature',
    skills: ['coding','talking to people','eating']
}

let personStr = JSON.stringify(person);

/////////////

let respString = ""; //filled with some text
let resp = JSON.parse(respString);

resp.field1;
resp.feild2;

//"{"name":"TA","workplace":"Revature","skills":["coding","talking to people","eating"]}"