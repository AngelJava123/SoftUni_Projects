function largestNumber(number1: number, number2: number, number3: number) {

    let result: number = Number.NEGATIVE_INFINITY;

    let numbers: number[] = [number1, number2, number3];

    for (let index = 0; index < numbers.length; index++) {
        const element = numbers[index];

        if (element > result) {
            result = element;
        }
    }
    return result;
}

console.log('The largest number is ' + largestNumber(5, -3, 16) + '.');
console.log('The largest number is ' + largestNumber(-3, -5, -22.5) + '.');