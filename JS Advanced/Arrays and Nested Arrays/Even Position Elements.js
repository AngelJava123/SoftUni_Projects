function solve(arr) {

    let result = [];

    for (let i = 0; i < arr.length; i++) {
        let curr = arr[i];

        if (i % 2 === 0) {
            result.push(curr);
        }
        
    }

    console.log(result.join(' '));
}

solve(['20', '30', '40', '50', '60']);
solve(['5', '10']);