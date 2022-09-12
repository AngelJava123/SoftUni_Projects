function solve(string1, string2, string3) {
    let sumLength = 0;
    let averageLength = 0;

    sumLength = string1.length + string2.length + string3.length;
    averageLength = Math.floor(sumLength / 3);

    return console.log(sumLength), console.log(averageLength);
}

solve('chocolate', 'ice cream', 'cake');

solve('pasta', '5', '22.3');