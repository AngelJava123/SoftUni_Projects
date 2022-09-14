function solve(num) {
    let numString = num + "";
    let firstNum = numString[0];
    let sum = 0;
    sum += Number(numString[0]);
    flag = true;

    for (let index = 1; index < numString.length; index++) {
        if (numString[index] !== firstNum) {
            flag = false;
        }
        sum += Number(numString[index]);
    }

    console.log(flag);
    console.log(sum);
}

solve(2222222);
solve(1234);