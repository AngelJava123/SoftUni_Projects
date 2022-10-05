const { expect } = require('chai')
const { rgbToHexColor } = require('../06. RGB to Hex')

describe('Testing Summing Function', () => {
    it('test undefined', () => {
        expect(rgbToHexColor(300, 0, 0)).to.be.undefined;
        expect(rgbToHexColor(0, 300, 0)).to.be.undefined;
        expect(rgbToHexColor(0, 0, 300)).to.be.undefined;
    });
    it('test 000', () => {
        expect(rgbToHexColor(0, 0, 0)).to.equal('#000000');
    });
    it('test 255255255', () => {
        expect(rgbToHexColor(255, 255, 255)).to.equal('#FFFFFF');
    });
    it('test return true', () => {
        expect(rgbToHexColor(34, 56, 12)).to.be.equal('#22380C');
    });
    it('test return not integer', () => {
        expect(rgbToHexColor('1', 34, 12)).to.be.undefined;
        expect(rgbToHexColor(34, '1', 12)).to.be.undefined;
        expect(rgbToHexColor(34, 45, '1')).to.be.undefined;
    });
    it('test less 1 params', () => {
        expect(rgbToHexColor(34, 12)).to.be.undefined;
        expect(rgbToHexColor(12)).to.be.undefined;
        expect(rgbToHexColor()).to.be.undefined;
    });
    it('test less -1 param', () => {
        expect(rgbToHexColor(-1, 0, 0)).to.be.undefined;
        expect(rgbToHexColor(0, -1, 0)).to.be.undefined;
        expect(rgbToHexColor(0, 0, -1)).to.be.undefined;
    });
    it('test floats', () => {
        expect(rgbToHexColor(1.1, 0, 0)).to.be.undefined;
        expect(rgbToHexColor(0, 1.1, 0)).to.be.undefined;
        expect(rgbToHexColor(0, 0, 1.1)).to.be.undefined;
    });
});