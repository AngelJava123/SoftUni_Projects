function solve(obj) {

    let res = {};

    res.model = obj.model;

    let engineEnum = {
        smallEngine: { power: 90, volume: 1800 },
        normalEngine: { power: 120, volume: 2400 },
        monsterEngine: { power: 200, volume: 3500 }
    };

    if (obj.power <= 90) {
        res.engine = engineEnum.smallEngine;
    } else if (obj.power > 90 && obj.power <= 120) {
        res.engine = engineEnum.normalEngine;
    } else if (obj.power > 120 && obj.power <= 200) {
        res.engine = engineEnum.monsterEngine;
    }

    res.carriage = { type: `${obj.carriage}`, color: `${obj.color}` };
    let wheelz = obj.wheelsize;
    if (wheelz % 2 == 0) {
        wheelz--;
    }
    res.wheels = [wheelz, wheelz, wheelz, wheelz];

    return res;
}


console.table(solve({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}
));

console.table(solve({
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17
}
));