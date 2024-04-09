function inputInventory(array: string[]) {

    interface Person {
        Hero: string,
        level: number,
        items? : string
    }

    const people: Person[] = [];

    for (let index = 0; index < array.length; index++) {
        const element = array[index];
        const splitElement: string[] = element.split('/');

        const newPerson: Person = {
            Hero: splitElement[0],
            level: parseInt(splitElement[1]),
            items: splitElement[2] ? splitElement[2] : undefined
        };

        people.push(newPerson);
    }

    // Sort people array by level in ascending order
    people.sort((a, b) => a.level - b.level);

    // Print each person in the desired format
    for (let index = 0; index < people.length; index++) {
        const person = people[index];
        console.log(`Hero: ${person.Hero}`);
        console.log(`level => ${person.level}`);
        if (person.items) {
            console.log(`items => ${person.items}`);
        }
    }
}

inputInventory([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]);

inputInventory([
    'Batman / 2 / Banana, Gun',
    'Superman / 18 / Sword',
    'Poppy / 28 / Sentinel, Antara'
    ]);