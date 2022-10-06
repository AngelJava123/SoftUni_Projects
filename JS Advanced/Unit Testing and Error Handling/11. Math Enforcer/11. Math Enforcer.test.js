const { expect } = require('chai')
const { mathEnforcer } = require('../11. Math Enforcer')

describe('Testing mathEnforcer Function', () => {
    describe('addFive', () => {
        it ('test pass return undefined value', () => {
            expect(mathEnforcer.addFive('hello')).to.be.undefined;
        });
        it ('test pass return correct value', () => {
            expect(mathEnforcer.addFive(4)).to.be.equal(9);
            expect(mathEnforcer.addFive(-4)).to.be.equal(1);
            expect(mathEnforcer.addFive(2.555)).to.be.equal(7.555);
        });
    });
    describe('subtractTen', () => {
        it ('test pass return undefined value', () => {
            expect(mathEnforcer.subtractTen('hello')).to.be.undefined;
        });
        it ('test pass return correct value', () => {
            expect(mathEnforcer.subtractTen(4)).to.be.equal(-6);
            expect(mathEnforcer.subtractTen(-4)).to.be.equal(-14);
            expect(mathEnforcer.subtractTen(2.555)).to.be.equal(-7.445);
        });
    });
    describe('sum', () => {
        it ('test pass return undefined value', () => {
            expect(mathEnforcer.sum('hello', 5)).to.be.undefined;
            expect(mathEnforcer.sum(5, 'hello')).to.be.undefined;
        });
        it ('test pass return correct value', () => {
            expect(mathEnforcer.sum(4, 9)).to.be.equal(13);
            expect(mathEnforcer.sum(-4, -9)).to.be.equal(-13);
            expect(mathEnforcer.sum(2.555, 2.555)).to.be.equal(5.11);
        });
    });
});