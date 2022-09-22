function solve(arr) {

    let res = [];

    let curr = {};

    arr.forEach(element => {
        curr.name = element.split(' / ')[0];
        curr.level = Number(element.split(' /')[1]);

        element.split(' / ')[2] === undefined
            ? curr.items = []
            : curr.items = element.split(' / ')[2].split(', ');

        res.push(curr);
        curr = {};
    });
    console.log(JSON.stringify(res));
}

solve(['Jake / 1000']);

solve(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']
);

solve(['Jake / 1000 / Gauss, HolidayGrenade']);