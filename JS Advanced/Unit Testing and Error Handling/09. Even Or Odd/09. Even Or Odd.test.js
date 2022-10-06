const { expect } = require('chai')
const { isOddOrEven } = require('../09. Even Or Odd')

describe('Testing isOddOrEven Function', () => {
    it('return undefined when passing not string param', () => {
        expect(isOddOrEven(34)).to.be.undefined;
        expect(isOddOrEven([3, '0', 0])).to.be.undefined;
    });
    it('pass string with even lenght return even', () => {
        expect(isOddOrEven('helloo')).to.be.equal("even");
    });
    it('pass string with odd lenght return odd', () => {
        expect(isOddOrEven('hello')).to.be.equal("odd");
    });
    it('pass string with even lenght return even', () => {
        expect(isOddOrEven('hello433$$^&*!@#$^')).to.be.equal("even");
        expect(isOddOrEven('hello][{}<>?? ')).to.be.equal("even");
        expect(isOddOrEven('    ')).to.be.equal("even");
    });
});