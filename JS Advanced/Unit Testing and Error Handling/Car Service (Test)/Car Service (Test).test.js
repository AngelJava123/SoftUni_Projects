const { expect, assert } = require('chai')
const carService = require('../Car Service (Test)')

describe("carService", () => {
    describe("isItExpensive", () => {
        it('Test 1', () => {
            expect(carService.isItExpensive("Engine")).to.equal(`The issue with the car is more severe and it will cost more money`)
            expect(carService.isItExpensive("Transmission")).to.equal(`The issue with the car is more severe and it will cost more money`)
            expect(carService.isItExpensive("Tire")).to.equal(`The overall price will be a bit cheaper`)
        })
    });
    describe("discount", () => {
        it('Test 2', () => {
            expect(() => carService.discount('hey', 1)).to.throw("Invalid input")
            expect(() => carService.discount(1, 'hey')).to.throw("Invalid input")
            expect(() => carService.discount('hey', 'hey')).to.throw("Invalid input")
            expect(() => carService.discount({}, 1)).to.throw("Invalid input")
            expect(() => carService.discount(1, [])).to.throw("Invalid input")

            expect(carService.discount(-1, 1)).to.equal(`You cannot apply a discount`)
            expect(carService.discount(0, 1)).to.equal(`You cannot apply a discount`)
            expect(carService.discount(1, 1)).to.equal(`You cannot apply a discount`)
            expect(carService.discount(2, 1)).to.equal(`You cannot apply a discount`)

            expect(carService.discount(3, 5)).to.equal(`Discount applied! You saved 0.75$`)
            expect(carService.discount(8, 5)).to.equal(`Discount applied! You saved 1.5$`)
        })
    });
    describe("partsToBuy", () => {
        it('Test 3', () => {
            expect(() => carService.partsToBuy(1, [])).to.throw("Invalid input")
            expect(() => carService.partsToBuy([], 1)).to.throw("Invalid input")
            expect(() => carService.partsToBuy(1, 1)).to.throw("Invalid input")

            expect(carService.partsToBuy([{ part: "blowoff valve", price: 145 }, { part: "coil springs", price: 230 }], ["blowoff valve", "injectors"])).to.equal(145)
            expect(carService.partsToBuy([], ["blowoff valve", "injectors"])).to.equal(0)
        })
    });
});