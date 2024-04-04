function sumOfNumbers(number1: string, number2: string): number {

    let num1: number = parseInt(number1);
    let num2: number = parseInt(number2);

    let result: number = 0;

    for (let index = num1; index < num2; index++) {
        result += index;
    }
    return result + num2;
}

console.log(sumOfNumbers('1', '5'));
console.log(sumOfNumbers('-8', '20'));