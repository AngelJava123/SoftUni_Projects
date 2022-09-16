function solve(arr) {

    let totalMatches = 0;

    let matchingPairsInArr = 0;

    for (let row = 0; row < arr.length; row++) {
        for (let col = 0; col < arr[row].length; col++) {
            if (arr[row][col] == arr[row][col + 1]) {
                matchingPairsInArr++;
            }
        }
    }

    totalMatches += matchingPairsInArr;

    for (let i = 0; i < arr.length - 1; i++) {

        let arr1 = arr[i];
        let arr2 = arr[i + 1];

        let checkSelectedAnswer = (arr1, arr2) => arr1.filter((eachChoice,index) => eachChoice === arr2[index]).length;
        const numberOfCorrectAnswers = checkSelectedAnswer(arr1, arr2);

        totalMatches += numberOfCorrectAnswers;
    
    }

    console.log(totalMatches);
}

solve([['2', '2', '5', '7', '4'],
    ['4', '0', '5', '3', '4'],
    ['2', '5', '5', '4', '2']]);

solve([['2', '3', '4', '7', '0'],
['4', '0', '5', '3', '4'],
['2', '3', '5', '4', '2'],
['9', '8', '7', '5', '4']]
);

solve([['test', 'yes', 'yo', 'ho'],
['well', 'done', 'yo', '6'],
['not', 'done', 'yet', '5']]
);