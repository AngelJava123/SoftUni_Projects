const { expect } = require('chai')
const chooseYourCar = require('../Choose Your Car')

describe("chooseYourCar", () => {
    describe("choosingType", () => {
        it('Test 1', () => {
           expect(() => chooseYourCar.choosingType('hey', 'green', 1800)).to.throw("Invalid Year!")
           expect(() => chooseYourCar.choosingType('hey', 'green', 2023)).to.throw("Invalid Year!")
           expect(() => chooseYourCar.choosingType('Jeep', 'green', 2010)).to.throw(`This type of car is not what you are looking for.`)
           expect(chooseYourCar.choosingType('Sedan', 'green', 2010)).to.equal(`This green Sedan meets the requirements, that you have.`)
           expect(chooseYourCar.choosingType('Sedan', 'green', 2020)).to.equal(`This green Sedan meets the requirements, that you have.`)
           expect(chooseYourCar.choosingType('Sedan', 'green', 2009)).to.equal(`This Sedan is too old for you, especially with that green color.`)
        })
    });
    describe("brandName", () => {
        it('Test 2', () => {
            expect(() => chooseYourCar.brandName(1, 1)).to.throw("Invalid Information!")
            expect(() => chooseYourCar.brandName([], '1')).to.throw("Invalid Information!")
            expect(() => chooseYourCar.brandName([], -1)).to.throw("Invalid Information!")
            expect(() => chooseYourCar.brandName(["BMW", "Toyota", "Peugeot"], 3)).to.throw("Invalid Information!")
            expect(() => chooseYourCar.brandName(["BMW", "Toyota", "Peugeot"], 4)).to.throw("Invalid Information!")
            expect(chooseYourCar.brandName(["BMW", "Toyota", "Peugeot"], 2)).to.equal("BMW, Toyota")
        })
    });
    describe("carFuelConsumption", () => {
        it('Test 3', () => {
            expect(() => chooseYourCar.carFuelConsumption('1', 1)).to.throw("Invalid Information!")
            expect(() => chooseYourCar.carFuelConsumption(-1, 1)).to.throw("Invalid Information!")
            expect(() => chooseYourCar.carFuelConsumption(0, 1)).to.throw("Invalid Information!")
            expect(() => chooseYourCar.carFuelConsumption(1, '1')).to.throw("Invalid Information!")
            expect(() => chooseYourCar.carFuelConsumption(1, -1)).to.throw("Invalid Information!")
            expect(() => chooseYourCar.carFuelConsumption(1, 0)).to.throw("Invalid Information!")
            expect(chooseYourCar.carFuelConsumption(2, 24)).to.equal(`The car burns too much fuel - 1200.00 liters!`)
            expect(chooseYourCar.carFuelConsumption(70, 4)).to.equal(`The car is efficient enough, it burns 5.71 liters/100 km.`)
            expect(chooseYourCar.carFuelConsumption(100, 7)).to.equal(`The car is efficient enough, it burns 7.00 liters/100 km.`)
        })
    });
});