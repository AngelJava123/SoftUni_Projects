class Box<T> {

    private _value: T;

    constructor(value: T) {
        this._value = value
    }

    public toString() {
        return `${this._value.toString()} is of type ${typeof (this._value)}`;
    }
}

let box1 = new Box(['test']);
let box2 = new Box(20);
let box3 = new Box('Hello');

console.log(box1.toString());
console.log(box2.toString());
console.log(box3.toString());