function solve(arr) {

    let result = arr.filter((element, index) => index % 2 !== 0)
                 .map(v => v * 2).reverse();

    return result;
}

console.log(solve([10, 15, 20, 25]));
console.log(solve([3, 0, 10, 4, 7, 3]));
