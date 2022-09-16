function solve(arr) {

    let res = [];
    let num = 1;

    for (const element of arr) {
        if (element === 'add') {
            res.push(num++);
        } else if (element === 'remove') {
            res.splice(-1);
            num++;
        }
    }

    if (res.length === 0) {
        console.log('Empty');
    } else {
        console.log(res.join('\r\n'));
    }
}

solve(['add',
    'add',
    'add',
    'add']
);

solve(['add',
    'add',
    'remove',
    'add',
    'add']
);

solve(['remove',
    'remove',
    'remove']
);

