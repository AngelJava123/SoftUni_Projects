class Garden {
    constructor(spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
        this.plants = [];
        this.storage = [];
    }

    addPlant(plantName, spaceRequired) {
        if (this.spaceAvailable < spaceRequired) {
            throw new Error('Not enough space in the garden.')
        }

        this.plants.push({
            plantName,
            spaceRequired,
            ripe: false,
            quantity: 0
        });

        this.spaceAvailable -= spaceRequired;
        return `The ${plantName} has been successfully planted in the garden.`
    }

    ripenPlant(plantName, quantity) {
        let plant = this.plants.find(plant => plant.plantName === plantName);

        if (!plant) {
            throw new Error(`There is no ${plantName} in the garden.`)
        }

        if (plant.ripe == true) {
            throw new Error(`The ${plantName} is already ripe.`)
        }

        if (quantity <= 0) {
            throw new Error(`The quantity cannot be zero or negative.`)
        }

        plant.ripe = true;
        plant.quantity += quantity;

        if (quantity == 1) {
            return `${quantity} ${plantName} has successfully ripened.`
        } else {
            return `${quantity} ${plantName}s have successfully ripened.`
        }
    }

    harvestPlant(plantName) {
        let plant = this.plants.find(plant => plant.plantName === plantName);

        if (!plant) {
            throw new Error(`There is no ${plantName} in the garden.`)
        }

        if (plant.ripe == false) {
            throw new Error(`The ${plantName} cannot be harvested before it is ripe.`)
        }

        this.plants = this.plants.filter((x) => x.plantName != plantName);
        this.storage.push({
            plantName,
            quantity: plant.quantity
        });

        this.spaceAvailable += plant.spaceRequired;
        return `The ${plantName} has been successfully harvested.`
    }

    generateReport() {
        const plantAsString = this.plants.map(p => p.plantName).sort((a, b) => a.localeCompare(b));
        const plantRow = `Plants in the garden: ${plantAsString.join(', ')}`;
        let storageRow = "Plants in storage: The storage is empty.";

        if (this.storage.length > 0) {
            const storageAsString = this.storage.map(p => `${p.plantName} (${p.quantity})`);
            storageRow = `Plants in storage: ${storageAsString.join(', ')}`
        }
        return [
            `The garden has ${this.spaceAvailable} free space left.`,
            plantRow,
            storageRow
        ].join('\n')
    }
}

const myGarden = new Garden(250)
console.log(myGarden.addPlant('apple', 20));
console.log(myGarden.addPlant('orange', 200));
console.log(myGarden.addPlant('raspberry', 10));
console.log(myGarden.ripenPlant('apple', 10));
console.log(myGarden.ripenPlant('orange', 1));
console.log(myGarden.harvestPlant('orange'));
console.log(myGarden.generateReport());









