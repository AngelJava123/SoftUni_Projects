function solve(arr) {

    let res = [];

    arr.forEach(element => {
        let name = element.split(' : ')[0];
        let price = Number(element.split(' : ')[1]);

        res.push({ name, price });

    });

    let letter = "";

    res.sort((a, b) => a.name.localeCompare(b.name));

    res.forEach(element => {
        let currLetter = element.name[0];

        if (letter === "") {
            letter = currLetter;
            console.log(letter);
        }
        if (letter !== currLetter) {
            letter = currLetter;
            console.log(letter);
        }

        console.log(`  ${element.name}: ${element.price}`);
    });
}

solve(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']
);

console.log('-------------------');

solve(['Banana : 2',
    'Rubic`s Cube : 5',
    'Raspberry P : 4999',
    'Rolex : 100000',
    'Rollon : 10',
    'Rali Car : 2000000',
    'Pesho : 0.000001',
    'Barrel : 10']
);