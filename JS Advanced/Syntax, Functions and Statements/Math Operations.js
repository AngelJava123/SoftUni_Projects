function solve(num1, num2, str) {

    let result = 0;

    if (str === '+') {
        result = num1 + num2;
    } else if (str === '*') {
        result = num1 * num2;
    } else if (str === '-') {
        result = num1 - num2;
    } else if (str === '/') {
        result = num1 / num2;
    } else if (str === '%') {
        result = num1 % num2;
    } else if (str === '**') {
        result = num1 ** num2;
    };

    console.log(result);
}

solve(5, 6, '+');

solve(3, 5.5, '*');