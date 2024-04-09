function inputTowns(array) {
    const result = [];
    for (let index = 0; index < array.length; index++) {
        const element = array[index];
        const splitElement = element.split('|');
        const newTown = {
            town: splitElement[0],
            latitude: parseFloat(splitElement[1]).toFixed(2),
            longitude: parseFloat(splitElement[2]).toFixed(2)
        };
        result.push(newTown);
    }
    for (const town of result) {
        console.log(town);
    }
}
inputTowns(['Sofia | 42.696552 | 23.32601', 'Beijing | 39.913818 | 116.363625']);
inputTowns(['Plovdiv | 136.45 | 812.575']);
