function solve(num = 5) {

    let pattern = "";

    for (let i = 0; i < num; i++) {
        for (let j = 0; j < num; j++) {
          pattern += "* ";
        }
        pattern += '\n';
    }

    console.log(pattern);

}
solve(1);

solve(2);

solve(5);

solve(7);

solve();
