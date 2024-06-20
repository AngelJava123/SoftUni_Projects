function calc(first, operator, second) {
    let result = null;
    switch (operator) {
        case "+":
            result = (first + second).toFixed(2);
            break;
        case "-":
            result = (first - second).toFixed(2);
            break;
        case "/":
            result = (first / second).toFixed(2);
            break;
        case "*":
            result = (first * second).toFixed(2);
            break;
        default:
            result = 'Non existing operator';
            break;
    }
    return result;
}
const result = calc(5, "+", 10);
console.log(result);
const result1 = calc(25.5, "-", 3);
console.log(result1);
const result2 = calc(9, "/", 2);
console.log(result2);
const result3 = calc(7, "*", 5);
console.log(result3);
//# sourceMappingURL=index.js.map