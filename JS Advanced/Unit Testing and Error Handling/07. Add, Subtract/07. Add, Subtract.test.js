const { expect } = require('chai')
const { createCalculator } = require('../07. Add, Subtract')

describe('Testing Summing Function', () => {
    let calc;

    beforeEach(function () {
        calc = createCalculator();
    });

    it('test 0', () => {
        let value = calc.get();
        expect(value).to.equal(0);
    });
    it('test 1', () => {
        calc.add(20);
        calc.add(30);
        let value = calc.get();
        expect(value).to.equal(50);
    });
    it('test 2', () => {
        calc.add(30);
        calc.subtract(20);
        let value = calc.get();
        expect(value).to.equal(10);
    });
    it('test 3', () => {
        calc.add(30);
        calc.subtract(50);
        let value = calc.get();
        expect(value).to.equal(-20);
    });
    it("test 4", function () {
        calc.add(5.3);
        calc.subtract(1.1);
        let value = calc.get();
        expect(value).to.be.equal(5.3 - 1.1);
    });
    it("test 5", function () {
        calc.add(10);
        calc.subtract('7');
        calc.add('-2');
        calc.subtract(-1);
        let value = calc.get();
        expect(value).to.be.equal(2);
    });
    it("test 6", function () {
        calc.add('hello');
        let value = calc.get();
        expect(value).to.be.NaN;
    });
    it("test 7", function () {
        calc.subtract('hello');
        let value = calc.get();
        expect(value).to.be.NaN;
    });
});