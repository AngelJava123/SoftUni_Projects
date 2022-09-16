function solve(arr) {

    let firstSum = 0;
    let secondSum = 0;
    let leftDiagonal = 0;
    let rightDiagonal = arr[0].length - 1;

    arr.forEach(arr => {
        firstSum += arr[leftDiagonal++];
        secondSum += arr[rightDiagonal--];
    });

    console.log(firstSum + ' ' + secondSum);
}

solve([[20, 40],
    [10, 60]]
   );

solve([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
   );