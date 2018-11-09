window.onload = () => {
    document.getElementById('runFib').addEventListener("click", runFib, true)
    document.getElementById('bubbleSort').addEventListener("click", bubbleSort, true)
    document.getElementById('reverseString').addEventListener("click", reverseString, true)
    document.getElementById('nFactorial').addEventListener("click", nFactorial, true)
    document.getElementById('descending').addEventListener("click", descending, true)
    document.getElementById('palindrome').addEventListener("click", isPalindrome, true)
    document.getElementById('delete').addEventListener("click", deleteIt, true)
    document.getElementById('isEven').addEventListener("click", isEven, true)
    document.getElementById('sub').addEventListener("click", substring, true)
}

$(() => {
    setInterval(function () {
        let d = new Date()
        $('#dateOutput').html(d)
    }, 1000)
})

const runFib = () => {
    let n = document.getElementById('fibInput').value
    console.log(n)
    console.log(`fib(n) = ${fibR(n)}`);
    const div = document.createElement("DIV")
    var t = document.createTextNode(`${fibR(n)}`)
    div.appendChild(t)
    document.getElementById("fibOutput").appendChild(div)
}
const fibR = (n) => {
    if (n == 0 || n == 1) {
        return n
    }
    else {
        return fibR(n - 1) + fibR(n - 2)
    }
}

const bubbleSort = () => {
    const arr = [7, 9, 5, 6, 8, 1, 2]
    const p = document.createElement("p")
    var t = document.createTextNode(arr)
    p.appendChild(t)
    document.getElementById("bubOutput").appendChild(p)
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                let x = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = x;
            }
        }
    }
    const p2 = document.createElement("p")
    var t = document.createTextNode(arr)
    p2.appendChild(t)
    document.getElementById("bubOutput2").appendChild(p2)
}

const reverseString = () => {
    let str = document.getElementById('revInput').value
    let revd = str.split("").reverse().join("")
    const div = document.createElement("DIV")
    var t = document.createTextNode(revd)
    div.appendChild(t)
    document.getElementById("revOutput").appendChild(div)
}

const nFactorial = () => {
    let num = 0
    let x = document.getElementById('nInput').value
    for (let i = 0; i < x; i++) {
        if (num == 0) {
            num = x - i;
        }
        else {
            num *= x - i;
        }
    }
    const div = document.createElement("DIV")
    var t = document.createTextNode(num)
    div.appendChild(t)
    document.getElementById("nOutput").appendChild(div)
    console.log(num);
}

function isPalindrome() {
    let someStr = document.getElementById('palInput').value
    console.log(someStr);
    let isPalin = "false";
    let temp = "";
    for(let i = someStr.length-1; i >= 0; i--) {
        temp += someStr.charAt(i);
    }
    if (someStr === temp) {
        isPalin = "true";
    }
    const p = document.createElement("p")
    var t = document.createTextNode(isPalin)
    p.appendChild(t)
    document.getElementById("palOutput").appendChild(p)
}

const deleteIt = () => {
    let numArr = document.getElementById('deleteInput').value
    newArr = numArr.split('')
    xx = numArr.length
    const p = document.createElement("p")
    var t = document.createTextNode(numArr.length)
    p.appendChild(t)
    document.getElementById("deleteOutput").appendChild(p)
    delete newArr[2]
    console.log(newArr);
    const p2 = document.createElement("p")
    var t = document.createTextNode(numArr.length)
    p2.appendChild(t)
    document.getElementById("deleteOutput2").appendChild(p2)
}

const descending = () => {
    const arr = [7, 9, 5, 6, 8, 1, 2]
    const p = document.createElement("p")
    var t = document.createTextNode(arr)
    p.appendChild(t)
    document.getElementById("descOutput").appendChild(p)
    let arr2 = arr.sort(function (a, b) { return b - a })
    str = ''
    arr2.map(e => {
        str += e
    })
    console.log(str);
    const p2 = document.createElement("p")
    var t = document.createTextNode(str)
    p2.appendChild(t)
    document.getElementById("descOutput2").appendChild(p2)
}

function isEven() {
    let someNum = document.getElementById('evenInput').value
    let temp = "";
    if (Math.round(someNum / 2) * 2 == someNum) {
        temp = "true";
    }
    else {
        temp = "false";
    }
    const p2 = document.createElement("p")
    var t = document.createTextNode(temp)
    p2.appendChild(t)
    document.getElementById("evenOutput").appendChild(p2)
}

function substring() {
    let someStr = document.getElementById('subInput').value
    let length = document.getElementById('subInput2').value
    let offset = document.getElementById('subInput3').value
    let subb = ""
    subb = someStr.substring(offset - 1, offset + length)
    const p2 = document.createElement("p")
    var t = document.createTextNode(subb)
    p2.appendChild(t)
    document.getElementById("subOutput").appendChild(p2)
}