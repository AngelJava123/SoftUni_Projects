class CompareElements {
    constructor(array) {
        this._array = array;
    }
    compare(input) {
        let result = 0;
        for (let index = 0; index < this._array.length; index++) {
            const element = this._array[index];
            if (element === input) {
                result++;
            }
        }
        return result;
    }
}
let c = new CompareElements(['a', 'b', 'ab', 'abc', 'cba', 'b']);
console.log(c.compare('b'));
let c1 = new CompareElements([1, 2, 3, 4, 5, 1, 1]);
console.log(c1.compare(1));
//# sourceMappingURL=2.Generic_Compare_Elements.js.map