function mathOperation(number1, number2, operator) {
    if (operator === '+') {
        return number1 + number2;
    }
    else if (operator === '-') {
        return number1 - number2;
    }
    else if (operator === '*') {
        return number1 * number2;
    }
    else if (operator === '/') {
        return number1 / number2;
    }
    else if (operator === '**') {
        return number1 ** number2;
    }
    else if (operator === '%') {
        return number1 % number2;
    }
    else {
        return 'Invalid Operation';
    }
}
console.log(mathOperation(5, 6, '+'));
console.log(mathOperation(3, 5.5, '*'));
