function solve(arr) {

    let result = [];

    for (let i = 0; i < arr.length; i++) {
        let curr = arr[i];

        if (curr < 0) {
            result.unshift(curr);
        } else if (curr >= 0) {
            result.push(curr);
        }
    }

    console.log(result.join('\r\n'));
}

solve([7, -2, 8, 9]);
solve([3, -2, 0, -1]);