function solve(params) {


    let sumOfElements = 0;
    let sumOfInverseValues = 0;
    let concats = "";

    for (let index = 0; index < params.length; index++) {
         sumOfElements += params[index];
         sumOfInverseValues += 1 / params[index]
         concats += "" + params[index];
    }

    console.log(sumOfElements);
    console.log(sumOfInverseValues);
    console.log(concats);
}

solve([1, 2, 3]);

solve([2, 4, 8, 16]);