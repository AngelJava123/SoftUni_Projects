function solve(number1, number2, number3) {

    let number = 0;

    number = Math.max(number1, number2, number3);

    console.log(`The largest number is ${number}.`);
}

solve(5, -3, 16);

solve(-3, -5, -22.5);