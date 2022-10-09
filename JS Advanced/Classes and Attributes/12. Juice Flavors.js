function solve(arr) {
    let juices = new Map();
    let bottles = new Map();

    for (const juice of arr) {
        const [type, qnt] = juice.split(' => ');

        if (!juices.has(type)) {
            juices.set(type, Number(qnt));

            if (juices.get(type) >= 1000) {
                let bottle = Math.trunc(juices.get(type) / 1000);
                let remaining = juices.get(type) % 1000;
                juices.set(type, remaining);
                bottles.set(type, bottle);
            }
        } else {
            let totalQnt = juices.get(type) + Number(qnt);
            juices.set(type, totalQnt);

            if (juices.get(type) >= 1000) {
                let bottle = Math.trunc(juices.get(type) / 1000);
                let remaining = juices.get(type) % 1000;
                juices.set(type, remaining);

                if (!bottles.get(type)) {
                    bottles.set(type, bottle);
                } else {
                    let curr = bottles.get(type) + bottle;
                    bottles.set(type, curr);
                }
            }
        }
    }

    for (const item of bottles) {
        console.log(item[0] + ' => ' + item[1])
    }
}


solve(['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']
);

solve(['Orange => 2000',
    'Peach => 1432',
    'Banana => 450',
    'Peach => 600',
    'Strawberry => 549']
);