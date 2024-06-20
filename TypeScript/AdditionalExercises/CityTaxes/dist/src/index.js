const cityTaxes = (name, population, treasury) => {
    const taxRate = 10;
    return {
        name,
        population,
        treasury,
        taxRate,
        collectTaxes: function () {
            const taxAmount = Math.floor(this.population * this.taxRate);
            this.treasury += taxAmount;
        },
        applyGrowth: function (percentage) {
            const growthAmount = Math.floor(this.population * (percentage / 100));
            this.population += growthAmount;
        },
        applyRecession: function (percentage) {
            const recessionAmount = Math.floor(this.treasury * (percentage / 100));
            this.treasury -= recessionAmount;
        }
    };
};
const city = cityTaxes('Tortuga', 7000, 15000);
console.log(city);
const city2 = cityTaxes('Tortuga', 7000, 15000);
city2.collectTaxes();
console.log(city2.treasury);
city2.applyGrowth(5);
console.log(city2.population);
//# sourceMappingURL=index.js.map