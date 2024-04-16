class Box {
    constructor(value) {
        this._value = value;
    }
    toString() {
        return `${this._value.toString()} is of type ${typeof (this._value)}`;
    }
}
let box1 = new Box(['test']);
let box2 = new Box(20);
let box3 = new Box('Hello');
console.log(box1.toString());
console.log(box2.toString());
console.log(box3.toString());
//# sourceMappingURL=1.Generic_Box_of_String.js.map