function solve(year, month, day) {
    let date = new Date(year, month - 1, day -1);

    const result = date.getFullYear() + "-" + Number(date.getMonth() + 1) + "-" + date.getDate();

    console.log(result)

}

solve(2016, 9, 30);
solve(2016, 10, 1)