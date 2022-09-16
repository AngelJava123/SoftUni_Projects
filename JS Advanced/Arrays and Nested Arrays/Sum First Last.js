function solve(arr) {

    let first = Number(arr[0]);
    let last = Number(arr[arr.length - 1]);

    sum = first + last;
    return sum;

}

console.log(solve(['20', '30', '40']));
console.log(solve(['5', '10']));