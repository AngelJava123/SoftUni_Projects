function solve(arr) {

    let townPrice = [];

    let flag = false;
    let indicator = true;

    arr.forEach(element => {
        let town = element.split(' | ')[0];
        let product = element.split(' | ')[1];
        let price = Number(element.split(' | ')[2]);

        indicator = true;

        for (let i = 0; i < townPrice.length; i++) {
            let curr = townPrice[i];
            let currTown = curr['town']
            let currProduct = curr['product']
            let currPrice = Number(curr['price']);

            if (product === currProduct) {
                if (price < currPrice) {
                    curr['town'] = town
                    curr['price'] = price
                    curr['product'] = product
                    flag = false;
                    indicator = false;
                } else if (price === currPrice && town === currTown) {
                    flag = false;
                    indicator = false;
                } else {
                    indicator = false;
                }
            } else {
                flag = true;
            }
        }
        if (flag && indicator) {
            townPrice.push({ town, product, price })
            flag = false;
        }
        if (townPrice.length === 0) {
            townPrice.push({ town, product, price })
        }
    });

    for (let i = 0; i < townPrice.length; i++) {
        let curr = townPrice[i];
        let currTown = curr['town']
        let currProduct = curr['product']
        let currPrice = curr['price'];

        console.log(`${currProduct} -> ${currPrice} (${currTown})`)
    }
}

solve(['Sofia City | Audi | 100000',
    'Sofia City | BMW | 100000',
    'Sofia City | Mitsubishi | 10000',
    'Sofia City | Mercedes | 10000',
    'Sofia City | NoOffenseToCarLovers | 0',
    'Mexico City | Audi | 1000',
    'Mexico City | BMW | 99999',
    'Mexico City | Mitsubishi | 10000',
    'New York City | Mitsubishi | 1000',
    'Washington City | Mercedes | 1000']);

solve(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']
);