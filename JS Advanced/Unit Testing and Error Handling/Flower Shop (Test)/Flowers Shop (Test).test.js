const { expect } = require('chai')
const flowerShop = require('../Flowers Shop (Test)')

describe("flowerShop", () => {
    describe("calcPriceOfFlowers", () => {
        it('Test 1', () => {
            expect(() => flowerShop.calcPriceOfFlowers(1, 1, 1)).to.throw("Invalid input")
            expect(() => flowerShop.calcPriceOfFlowers('hey', 'hey', 1)).to.throw("Invalid input")
            expect(() => flowerShop.calcPriceOfFlowers('hey', 1, 'hey')).to.throw("Invalid input")
            expect(flowerShop.calcPriceOfFlowers('Rose', 7, 10)).to.equal(`You need $70.00 to buy Rose!`)
        })
    });
    describe("checkFlowersAvailable", () => {
        it('Test 2', () => {
            expect(flowerShop.checkFlowersAvailable('Rose', ["Rose", "Lily", "Orchid"])).to.equal(`The Rose are available!`)
            expect(flowerShop.checkFlowersAvailable('Vili', ["Rose", "Lily", "Orchid"])).to.equal(`The Vili are sold! You need to purchase more!`)
        })
    });
    describe("sellFlowers", () => {
        it('Test 3', () => {
            //if (!Array.isArray(gardenArr) || !Number.isInteger(space) || space < 0 || space >= gardenArr.length) {
            expect(() => flowerShop.sellFlowers(1, 1)).to.throw("Invalid input")
            expect(() => flowerShop.sellFlowers([], 'hey')).to.throw("Invalid input")
            expect(() => flowerShop.sellFlowers([], -1)).to.throw("Invalid input")
            expect(() => flowerShop.sellFlowers(['Rose', 'Lily', 'Orchird'], 3)).to.throw("Invalid input")
            expect(() => flowerShop.sellFlowers(['Rose', 'Lily', 'Orchird'], 4)).to.throw("Invalid input")
            expect(flowerShop.sellFlowers(['Rose', 'Lily', 'Orchird'], 2)).to.equal('Rose / Lily')



        })
    });
});