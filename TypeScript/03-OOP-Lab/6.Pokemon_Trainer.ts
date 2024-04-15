class Pokemon {
    private _name: string;
    private _element: string;
    private _health: number;

    constructor(name: string, element: string, health: number) {
        this._name = name;
        this._element = element;
        this._health = health;
    }

    get name(): string {
        return this._name;
    }

    get element(): string {
        return this._element;
    }

    get health(): number {
        return this._health;
    }

    set name(name: string) {
        this._name = name;
    }

    set element(element: string) {
        this._element = element;
    }

    set health(health: number) {
        this._health = health;
    }
}

class Trainer {

    private _name: string;
    private _numberOfBadges: number = 0;
    private _pokemons: Array<Pokemon> = [];

    get name(): string {
        return this._name;
    }

    get numberOfBadges(): number {
        return this._numberOfBadges;
    }

    get pokemon(): Array<Pokemon> {
        return this._pokemons;
    }

    set name(name: string) {
        this._name = name;
    }

    set numberOfBadges(numberOfBadges: number) {
        this._numberOfBadges = numberOfBadges;
    }

    public addPokemon(pokemon: Pokemon) {
        this._pokemons.push(pokemon);
    }

    public removePokemon(pokemonToRemove: Pokemon) {
        const index = this._pokemons.indexOf(pokemonToRemove);
        if (index !== -1) {
            this._pokemons.splice(index, 1);
        }
    }
}

function inputPokemons(lines: string[]) {

    let allTrainersAndPokemons: Array<Trainer> = [];

    let endValue: number = 0;

    for (let index = 0; index < lines.length; index++) {
        const element = lines[index].split(" ");

        let endWord = element[0];

        endValue++;

        if (endWord === 'Tournament') {
            break;
        }

        let trainerName: string = element[0];
        let pokemonName: string = element[1];
        let pokemonElement: string = element[2];
        let pokemonHealth: number = parseInt(element[3]);

        let trainer = new Trainer();
        trainer.name = trainerName;

        let pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

        function findTrainerByName(name: string): Trainer | undefined {
            return allTrainersAndPokemons.find(trainer => trainer.name === name);
        }

        const existingTrainer = findTrainerByName(trainerName);

        if (existingTrainer) {
            existingTrainer.addPokemon(pokemon);
        } else {
            trainer.addPokemon(pokemon);
            allTrainersAndPokemons.push(trainer);
        }
    }

    for (let index = endValue; index < lines.length; index++) {
        const element = lines[index];

        if (element === 'End') {
            break;
        }

        for (let index = 0; index < allTrainersAndPokemons.length; index++) {
            const trainer = allTrainersAndPokemons[index];

            let pokemonExist: boolean = false;

            for (const pokemon of trainer.pokemon) {
                if (pokemon.element === element) {
                    trainer.numberOfBadges += 1;
                    pokemonExist = true;
                }
            }

            if (!pokemonExist) {
                for (const pokemon of trainer.pokemon) {
                    if (pokemon.health - 10 <= 0) {
                        trainer.removePokemon(pokemon);
                    } else {
                        pokemon.health -= 10;
                    }
                }
            }
        }
    }

    function printTrainersInfo(trainers: Trainer[]) {
        // Step 1: Sort the trainers array based on the number of badges in descending order
        trainers.sort((a, b) => {
            // Sort by number of badges
            if (b.numberOfBadges !== a.numberOfBadges) {
                return b.numberOfBadges - a.numberOfBadges;
            }
            // If two trainers have the same number of badges, maintain their original order
            return trainers.indexOf(a) - trainers.indexOf(b);
        });

        // Step 2: Print each trainer's information
        trainers.forEach(trainer => {
            console.log(`${trainer.name} ${trainer.numberOfBadges} ${trainer.pokemon.length}`);
        });
    }

    printTrainersInfo(allTrainersAndPokemons);
}

const input: string[] = [
    'Peter Charizard Fire 100',
    'George Squirtle Water 38',
    'Peter Pikachu Electricity 10',
    'Tournament',
    'Fire',
    'Electricity',
    'End'
];

inputPokemons(input);

const input1: string[] = [
    'Sam Blastoise Water 18',
    'Narry Pikachu Electricity 22',
    'John Kadabra Psychic 90',
    'Tournament',
    'Fire',
    'Electricity',
    'Fire',
    'End'
];

inputPokemons(input1);