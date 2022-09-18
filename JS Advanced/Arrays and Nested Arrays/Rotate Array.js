function solve(arr, rotations) {

    let lastElement = '';

    for (let i = 0; i < rotations; i++) {
        lastElement = arr[arr.length - 1];
        arr.pop();
        arr.unshift(lastElement);
    }

    console.log(arr.join(' '));

}

solve(['1',
    '2',
    '3',
    '4'],
    2
);

solve(['Banana',
    'Orange',
    'Coconut',
    'Apple'],
    15
);