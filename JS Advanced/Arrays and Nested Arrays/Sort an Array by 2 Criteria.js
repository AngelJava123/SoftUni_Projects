function solve(arr) {

    arr.sort((a, b) => {

        if (a.length === b.length) {
            return a.localeCompare(b);
        }
        return a.length - b.length;
    });

    console.log(arr.join('\n'))
}

solve(['alpha',
    'beta',
    'gamma']
);

solve(['Isacc',
    'Theodor',
    'Jack',
    'Harrison',
    'George']
);

solve(['test',
    'Deny',
    'omen',
    'Default']
);