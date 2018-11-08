window.onload = () => {
    document.getElementById('runFib').addEventListener("click", runFib, true)
    document.getElementById('bubbleSort').addEventListener("click", bubbleSort, true)
    document.getElementById('reverseString').addEventListener("click", reverseString, true)
}

const runFib = () => {
    // take input and call fibonnaci function
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
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                let x = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = x;
            }
        }
    }
    const div = document.createElement("DIV")
    var t = document.createTextNode(arr)
    div.appendChild(t)
    document.getElementById("bubOutput").appendChild(div)
}

const reverseString = () => {
    let str = document.getElementById('revInput').value
    let revd = str.split("").reverse().join("")
    const div = document.createElement("DIV")
    var t = document.createTextNode(revd)
    div.appendChild(t)
    document.getElementById("revOutput").appendChild(div)
}

// public static void main(String[] args) {
//     int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
//     bubbleSort(arr);
//     for (int i = 0; i < arr.length; i++) {
//         System.out.print(arr[i] + " ");
//     }
// }

// static void bubbleSort(int arr[]) {

//     int leng = arr.length;

//     for (int i = 0; i < leng - 1; i++) {
//         for (int j = 0; j < leng - i - 1; j++) {
//             if (arr[j] > arr[j + 1]) {
//                 int x = arr[j];
//                 arr[j] = arr[j + 1];
//                 arr[j + 1] = x;
//             }
//         }
//     }
// }
