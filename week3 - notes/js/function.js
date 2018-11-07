/*
    about js functions
    - functions inherit from objects and may be passed as variables
    or stores just like any other value
    - no function overloading in js -- last function is used missing parameters
    are set to undefined extra parameters are ignored
    - this keyword. "this" represents what the function is bound to and invocation time

*/

function func() {
    console.log('inside of regular function');
}
func()


const functionExpression = function () {
    console.log('inside of regular function expression');
}
functionExpression()


    (function () {
        console.log('this is an immediately invoked function expresssion');
    })()

const person = (() => {
    let name = 'Genesis'
    return name
})
person


const counter = (() => {
    const privateCounter = 0

    changeBy = (val) => {
        privateCounter += val
    }

    return {
        increment: function () { changeBy(1) },
        decrement: function () { changeBy(-1) },
        value: function () {
            return privateCounter
        }
    }
})()

counter.privateCounter() //will return undefined. do NOT have access to counter
counter.value() // return 0
counter.increment()
counter.increment()
counter.increment()
counter.value() // return 3

const makeCounter = () => {
    
}