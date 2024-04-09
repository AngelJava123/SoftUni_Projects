function inputProduct(arr) {
    const products = {};
    for (let index = 0; index < arr.length; index += 2) {
        const element = arr[index];
        const calories = arr[index + 1];
        products[element] = calories;
    }
    console.log(products);
}
inputProduct(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);
inputProduct(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);
