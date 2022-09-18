function solve(arr) {

    let result = [];
    let firstNum = arr[0];
    result.push(firstNum);

    for (let i = 1; i < arr.length; i++) {

        let curr = arr[i];

        if (curr >= result[result.length - 1]) {
            result.push(curr);
        }
    }

    return result;
}

console.log(solve([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24]
));

console.log(solve([1,
    2,
    3,
    4]
));

console.log(solve([20,
    3,
    2,
    15,
    6,
    1]
));