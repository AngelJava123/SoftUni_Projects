function solve(input) {

    let townsWithPopulation = [];

    let towns = [];

    input.forEach(element => {
        let data = element.split(' <-> ');

        let town = data[0];
        let population = Number(data[1]);

        if (towns.includes(town)) {
            let i = townsWithPopulation.indexOf(town) + 1;
            townsWithPopulation[i][1] += population;
        } else {
            townsWithPopulation.push([
                town,
                population
            ])
        }

        towns.push(town);
    });

    townsWithPopulation.forEach(element => {
    
        let town = element[0];
        let population = Number(element[1]);

        console.log(`${town} : ${population}`);
    });
}

solve(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000'
]
);

solve(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']
);