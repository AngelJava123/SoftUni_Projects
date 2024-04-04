function sumOfNumbers(number1, number2) {
    let num1 = parseInt(number1);
    let num2 = parseInt(number2);
    let result = 0;
    for (let index = num1; index < num2; index++) {
        result += index;
    }
    return result + num2;
}
console.log(sumOfNumbers('1', '5'));
console.log(sumOfNumbers('-8', '20'));
