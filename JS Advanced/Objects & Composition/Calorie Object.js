function solve(arr) {

    let res = {};

    for (let i = 0; i < arr.length; i++) {
        let key = arr[i];
        let value = Number(arr[i + 1]);

        res[key] = value;

        i++;
    }

    console.log(res);

}


solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);
solve(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);