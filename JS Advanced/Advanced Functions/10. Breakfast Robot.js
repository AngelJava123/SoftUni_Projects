function solution() {

    let storage = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }

    // Recipes:
    // apple: { carbohydrate: 1, flavour: 2 },
    // lemonade: { carbohydrate: 10, flavour: 20 },
    // burger: { carbohydrate: 5, fat: 7, flavour: 3 },
    // eggs: { protein: 5, fat: 1, flavour: 1 },
    // turkey: { protein: 10, carbohydrate: 10, fat: 10, flavour: 10 }


    return function manager(input) {
        let [command, microelement, quantity] = input.split(' ');

        let qntNum = Number(quantity);
        switch (command) {
            case 'restock':
                let currQnt = storage[microelement] + qntNum;
                storage[microelement] = currQnt;
                return 'Success';
            case 'prepare':
                if (microelement === 'lemonade') {
                    if (10 * qntNum > storage['carbohydrate']) {
                        return `Error: not enough carbohydrate in stock`;
                    } else if (20 * qntNum > storage['flavour']) {
                        return `Error: not enough flavour in stock`;
                    } else {
                        storage['carbohydrate'] = storage['carbohydrate'] - (10 * qntNum);
                        storage['flavour'] = storage['flavour'] - (20 * qntNum);
                        return 'Success';
                    }
                } else if (microelement === 'apple') {
                    if (1 * qntNum > storage['carbohydrate']) {
                        return `Error: not enough carbohydrate in stock`;
                    } else if (2 * qntNum > storage['flavour']) {
                        return `Error: not enough flavour in stock`;
                    } else {
                        storage['carbohydrate'] = storage['carbohydrate'] - (1 * qntNum);
                        storage['flavour'] = storage['flavour'] - (2 * qntNum);
                        return 'Success';
                    }
                } else if (microelement === 'burger') {
                    if (5 * qntNum > storage['carbohydrate']) {
                        return `Error: not enough carbohydrate in stock`;
                    } else if (7 * qntNum > storage['fat']) {
                        return `Error: not enough fat in stock`;
                    } else if (3 * qntNum > storage['flavour']) {
                        return `Error: not enough flavour in stock`;
                    } else {
                        storage['carbohydrate'] = storage['carbohydrate'] - (5 * qntNum);
                        storage['fat'] = storage['fat'] - (7 * qntNum);
                        storage['flavour'] = storage['flavour'] - (3 * qntNum);
                        return 'Success';
                    }
                } else if (microelement === 'eggs') {
                    if (5 * qntNum > storage['protein']) {
                        return `Error: not enough protein in stock`;
                    } else if (1 * qntNum > storage['fat']) {
                        return `Error: not enough fat in stock`;
                    } else if (1 * qntNum > storage['flavour']) {
                        return `Error: not enough flavour in stock`;
                    } else {
                        storage['protein'] = storage['protein'] - (5 * qntNum);
                        storage['fat'] = storage['fat'] - (1 * qntNum);
                        storage['flavour'] = storage['flavour'] - (1 * qntNum);
                        return 'Success';
                    }
                } else if (microelement === 'turkey') {
                    if (10 * qntNum > storage['protein']) {
                        return `Error: not enough protein in stock`;
                    } else if (10 * qntNum > storage['carbohydrate']) {
                        return `Error: not enough carbohydrate in stock`;
                    } else if (10 * qntNum > storage['fat']) {
                        return `Error: not enough fat in stock`;
                    } else if (10 * qntNum > storage['flavour']) {
                        return `Error: not enough flavour in stock`;
                    } else {
                        storage['protein'] = storage['protein'] - (10 * qntNum);
                        storage['carbohydrate'] = storage['carbohydrate'] - (10 * qntNum);
                        storage['fat'] = storage['fat'] - (10 * qntNum);
                        storage['flavour'] = storage['flavour'] - (10 * qntNum);
                        return 'Success';
                    }
                }
            case 'report':
                return `protein=${storage.protein} carbohydrate=${storage.carbohydrate} fat=${storage.fat} flavour=${storage.flavour}`;

        }
    }
}
//let manager = solution();
//console.log(manager("restock flavour 50"));
//console.log(manager("prepare lemonade 4"));
//console.log(manager("restock carbohydrate 10"));
//console.log(manager("restock flavour 10"));
//console.log(manager("prepare apple 1"));
//console.log(manager("restock fat 10"));
//console.log(manager("prepare burger 1"));
//console.log(manager("report"));

let manager = solution();
console.log(manager("prepare turkey 1"));
console.log(manager("restock protein 10"));
console.log(manager("prepare turkey 1"));
console.log(manager("restock carbohydrate 10"));
console.log(manager("prepare turkey 1"));
console.log(manager("restock fat 10"));
console.log(manager("prepare turkey 1"));
console.log(manager("restock flavour 10"));
console.log(manager("prepare turkey 1"));
console.log(manager("report"));









