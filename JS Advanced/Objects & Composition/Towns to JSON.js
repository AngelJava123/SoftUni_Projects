function solve(arr) {

    let res = [];

    for (let i = 1; i < arr.length; i++) {
        let Town = arr[i].split(' | ')[0].replace('|', "").trim();
        let Latitude = parseFloat(Number(arr[i].split(' | ')[1]).toFixed(2));
        let Longitude = parseFloat(Number(arr[i].split(' |')[2]).toFixed(2));

        res.push({ Town, Latitude, Longitude })
    }

    console.log(JSON.stringify(res));
}

solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
);

solve(['| Town | Latitude | Longitude |',
    '| Veliko Turnovo | 43.0757 | 25.6172 |',
    '| Monatevideo | 34.50 | 56.11 |']
);