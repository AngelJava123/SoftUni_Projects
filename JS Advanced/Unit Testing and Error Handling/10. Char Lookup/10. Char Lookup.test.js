const { expect } = require('chai')
const { lookupChar } = require('../10. Char Lookup')

describe('Testing lookupChar Function', () => {
    it('pass other than int value should return undefined', () => {
        expect(lookupChar('hello', 'hi')).to.be.undefined;
        expect(lookupChar('hello', [3, 4, 5])).to.be.undefined;
        expect(lookupChar('hello', 3.4)).to.be.undefined;
        expect(lookupChar(4453, 2)).to.be.undefined;
        expect(lookupChar([4, 4, 3], 1)).to.be.undefined;
        expect(lookupChar(4.3, 1)).to.be.undefined;
    });
    it('pass negative index or outside the bounds value should return Incorect Index', () => {
        expect(lookupChar('hello', -1)).to.be.equal("Incorrect index");
        expect(lookupChar('hello', 5)).to.be.equal("Incorrect index");
    });
    it('pass correct value', () => {
        expect(lookupChar('hello', 1)).to.be.equal("e");
    });
});