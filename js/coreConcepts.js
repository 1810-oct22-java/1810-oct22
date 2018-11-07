/** 
 * @author Genesis Bonds
 * @name Intro to JS
 * @since 11/6/18
 */

// - loosely typed: do not declare variable types, simple declare variables with 
// the declaritive keywords var, let, const.  The types of the variables are 
// then dynamically allocated.
// - var scopes
//     - global: accessible throughout the entirety of the script through the browser. 
//     Globally Scoped variables are anything declared outside of a blcok or function 
//     or variables that are never declared at all.
//     - function: declared in function/passed in as a parameter. accessible only throughout function
//     - block: new to ES6.  Can only obtain with variables declared with let or const keywords
// Some familiar terms - if.. else, return, switch, try.. catch, do.. while, for, break, continue
// Load and go delivery

var a = 5
var b = 'single quotes'
var c = "doubles"
var obj = {
    name: "mike CHAMPION",
    job: "man in charge",
    bio: 'food'
}
obj.name
obj['name']
obj['about me'] = 'this is a new about me field' + 'so powerful' + 'but why?'
obj.age = 100

// for.. in loop
for (var prop in obj) {
    console.log(`${prop}: ${obj[prop]}`);
}

y = `look at this ${5 + 10}`

// DATA TYPES of JS and type coercion
// - as a loosely typed language that is interpreted and not complied, JS has to be able to 
// accomidate comparisons between and manipulation on otherwise incompatible data TYPES
// (such as string and number)
// - type coercion is the process that JS takes to bring data from one type to another to compare
// actual values as opposed to the datatype that the value would be held in

//  == allows type coercion
//  === doesnt allow type coercion

// Strings
    // - 0 or more 16 bit characters
    // - " or ', but not for the same string
    // - string.length
    // - other inportatnt methods - charAt, concat, indexOf, replace, split, slice, substring
    // - immutable

