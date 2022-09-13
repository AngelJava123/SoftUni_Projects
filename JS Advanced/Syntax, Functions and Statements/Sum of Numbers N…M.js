function solve(str1, str2) {

    let result = 0;

    let num1 = Number(str1);
    let num2 = Number(str2);

    for (let index = num1; index <= num2; index++) {
        result += index;
    }

    console.log(result);
}

solve('1', '5');

solve('-8', '20');