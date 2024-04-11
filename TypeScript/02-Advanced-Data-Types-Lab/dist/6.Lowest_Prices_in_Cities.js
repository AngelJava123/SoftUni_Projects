function inputLowest(array) {
    ;
    const result = [];
    for (let index = 0; index < array.length; index++) {
        const element = array[index].split(' | ');
        const townName = element[0];
        const productName = element[1];
        const productPrice = parseFloat(element[2]);
        let exist = false;
        for (let i = 0; i < result.length; i++) {
            const obj = result[i];
            if (obj.productName === productName) {
                if (obj.productPrice > productPrice) {
                    obj.productPrice = productPrice;
                }
                exist = true; // product exists in result array
                break;
            }
        }
        if (!exist) {
            const lowest = {
                townName: townName,
                productName: productName,
                productPrice: productPrice
            };
            result.push(lowest);
        }
        ;
    }
    for (let j = 0; j < result.length; j++) {
        const town = result[j];
        console.log(`${town.productName} -> ${town.productPrice} (${town.townName})`);
    }
    ;
}
inputLowest([
    'Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10'
]);
