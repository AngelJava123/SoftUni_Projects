function main(arr) {

    let rows = 0;
    let cols = 0;
    let sumRow = 0;
    let sumCol = 0;

    let result = [];

    //Calculates number of rows and columns present in given matrix  
    rows = arr.length;
    cols = arr[0].length;

    //Calculates sum of each row of given matrix  
    for (let i = 0; i < rows; i++) {
        sumRow = 0;
        for (let j = 0; j < cols; j++) {
            sumRow = sumRow + arr[i][j];
        }
        result.push(sumRow);
    }

    //Calculates sum of each column of given matrix  
    for (let i = 0; i < cols; i++) {
        sumCol = 0;
        for (let j = 0; j < rows; j++) {
            sumCol = sumCol + arr[j][i];
        }
        result.push(sumCol);
    }

    
    let firstSum = result[0];

    for (let i = 1; i < result.length; i++) {
        if (result[i] !== firstSum) {
            return false;
        }
    }
    return true;
}  


console.log(main([[4, 5, 6],
[6, 5, 4],
[5, 5, 5]]
));

console.log(main([[11, 32, 45],
[21, 0, 1],
[21, 1, 1]]
));

console.log(main([[1, 0, 0],
[0, 0, 1],
[0, 1, 0]]
));