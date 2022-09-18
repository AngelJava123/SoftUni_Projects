function solve(arr) {

    let smallest = arr.slice();
    let biggest = arr.slice();
    let result = [];

    smallest.sort((a, b) => a - b);

    biggest.sort((a, b) => b - a);

    for (let i = 0; i < arr.length / 2; i++) {
        result.push(smallest[i]);
        result.push(biggest[i]);
        
    }

    if (result.length > arr.length) {
        result.pop();
    }

    return result;
}

console.log(solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));

console.log(solve([1, 10, 9, 15, 2, 3, 4]));

console.log(solve([54, 12, 23, 96, 10]));