function solve(name, population, treasury) {

    return {
        name,
        population,
        treasury,
        taxRate: 10,
        collectTaxes() {
            return this.treasury += this.population * this.taxRate;
        },
        applyGrowth(percentage) {
            return this.population += Math.floor(this.population * percentage / 100);
        },
        applyRecession(percentage) {
            return this.treasury -= Math.floor(this.treasury * percentage / 100);
        }
    }
}





const city =
solve('Tortuga',
  7000,
  15000);

city.collectTaxes();
console.log(city.treasury);
city.applyGrowth(5);
console.log(city.population);
