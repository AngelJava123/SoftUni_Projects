const { expect, assert } = require('chai')
const rentCar = require('../Rent Car (Test)')

describe("rentCar", () => {
    describe("searchCar", () => {
        it('Test 1', () => {
            expect(() => rentCar.searchCar([], 1)).to.throw("Invalid input")
            expect(() => rentCar.searchCar('hey', 'hey')).to.throw("Invalid input")
            expect(() => rentCar.searchCar(1, 1)).to.throw("Invalid input")
            expect(() => rentCar.searchCar(["Volkswagen", "BMW", "Audi"], 'Mercedes')).to.throw(`There are no such models in the catalog!`)
            expect(rentCar.searchCar(["Volkswagen", "BMW", "Audi"], 'BMW')).to.equal(`There is 1 car of model BMW in the catalog!`)
            expect(rentCar.searchCar(["Volkswagen", "BMW", "BMW"], 'BMW')).to.equal(`There is 2 car of model BMW in the catalog!`)
        })
    });
    describe("calculatePriceOfCar", () => {
        it('Test 2', () => {
            expect(() => rentCar.calculatePriceOfCar([], 1)).to.throw("Invalid input")
            expect(() => rentCar.calculatePriceOfCar('hey', 'hey')).to.throw("Invalid input")
            expect(() => rentCar.calculatePriceOfCar(1, 1)).to.throw("Invalid input")
            expect(rentCar.calculatePriceOfCar('BMW', 2)).to.equal(`You choose BMW and it will cost $90!`)
            expect(() => rentCar.calculatePriceOfCar('Tesla', 2)).to.throw('No such model in the catalog!')
        })
    });
    describe("checkBudget", () => {
        it('Test 3', () => {
            expect(() => rentCar.checkBudget([], 1, 1)).to.throw("Invalid input")
            expect(() => rentCar.checkBudget(1, 'hey', 1)).to.throw("Invalid input")
            expect(() => rentCar.checkBudget(1, 1, [])).to.throw("Invalid input")
            expect(rentCar.checkBudget(20, 10, 300)).to.equal(`You rent a car!`)
            expect(rentCar.checkBudget(20, 10, 200)).to.equal(`You rent a car!`)
            expect(rentCar.checkBudget(20, 10, 100)).to.equal('You need a bigger budget!')
        })
    });
});