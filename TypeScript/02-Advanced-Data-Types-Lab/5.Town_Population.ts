function inputTownPopulation(array: string[]) {

    interface TownPopulation {
        townName: string,
        townPopulation: number
    };

    const result: TownPopulation[] = [];

    for (let index = 0; index < array.length; index++) {
        const element = array[index];
        
        const splitElement = element.split(' <-> ');
        const townName = splitElement[0];
        const townPopulation = parseInt(splitElement[1]);

        let found: boolean = false;
        for (let i = 0; i < result.length; i++) {
            const obj = result[i];
        
            if (obj.townName === townName) {
                obj.townPopulation += townPopulation;
                found = true;
                break;
            };
        };

        if (!found) {
        const townPpl: TownPopulation = {
            townName: townName,
            townPopulation: townPopulation
        };

        result.push(townPpl);
       };
    };

    for (let index = 0; index < result.length; index++) {
        const town = result[index];
        console.log(`${town.townName} : ${town.townPopulation}`);
    };
};


inputTownPopulation([
'Sofia <-> 1200000',
'Montana <-> 20000',
'New York <-> 10000000',
'Washington <-> 2345000',
'Las Vegas <-> 1000000'
]);

inputTownPopulation([
'Istanbul <-> 100000',
'Honk Kong <-> 2100004',
'Jerusalem <-> 2352344',
'Mexico City <-> 23401925',
'Istanbul <-> 1000',
]);