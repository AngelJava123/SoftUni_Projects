function biggerHalf(numbers) {
    let sortedArray = numbers.sort((n1, n2) => n1 - n2);
    const middle = Math.floor(sortedArray.length / 2);
    const right = sortedArray.slice(middle);
    return right;
}
console.log(biggerHalf([4, 7, 2, 5]));
console.log(biggerHalf([3, 19, 14, 7, 2, 19, 6]));
