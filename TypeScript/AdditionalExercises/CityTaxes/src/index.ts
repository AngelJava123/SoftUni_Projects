type City = {
    name: string;
    population: number;
    treasury: number;
    taxRate: number;
    collectTaxes: () => void;
    applyGrowth: (percentage: number) => void;
    applyRecession: (percentage: number) => void;
};

type CityTaxesFunction = (name: string, population: number, treasury: number) => City;

const cityTaxes: CityTaxesFunction = (name, population, treasury) => {
    const taxRate: number = 10;

    return {
        name,
        population,
        treasury,
        taxRate,
        collectTaxes: function () {
            const taxAmount: number = Math.floor(this.population * this.taxRate);
            this.treasury += taxAmount;
        },
        applyGrowth: function (percentage) {
            const growthAmount: number = Math.floor(this.population * (percentage / 100));
            this.population += growthAmount;
        },
        applyRecession: function (percentage) {
            const recessionAmount: number = Math.floor(this.treasury * (percentage / 100));
            this.treasury -= recessionAmount;
        }
    };
};

const city = cityTaxes('Tortuga', 7000, 15000);
console.log(city);

const city2 =
    cityTaxes('Tortuga',
        7000,
        15000);
city2.collectTaxes();
console.log(city2.treasury);
city2.applyGrowth(5);
console.log(city2.population);