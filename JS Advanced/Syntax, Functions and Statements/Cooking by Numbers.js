function solve(num, ...operators) {

    let numRes = 0;

    for (let index = 0; index < operators.length; index++) {

        let currentOp = operators[index];

       if (currentOp === 'chop') {
           numRes = num / 2;
           num = numRes;
           console.log(numRes);
        } else if (currentOp === 'dice') {
            numRes = Math.sqrt(num);
            num = numRes;
            console.log(numRes);
        } else if (currentOp === 'spice') {
            numRes = num + 1;
            num = numRes;
            console.log(numRes);
        } else if (currentOp === 'bake') {
            numRes = num * 3;
            num = numRes;
            console.log(numRes);
        } else if (currentOp === 'fillet') {
            let percent = num * 0.2;
            numRes = num - percent;
            num = numRes;
            console.log(numRes);
        }
    }
}

solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');

console.log('-------------------------------------')

solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');