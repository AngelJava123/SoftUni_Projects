class Person {
    constructor(name, age) {
        this._name = name;
        this._age = age;
    }
    introduction() {
        return `My name is ${this._name} and I am ${this._age} years old.`;
    }
    sayGoodbye(name) {
        return `Dear ${name}, it was a pleasure meeting you!`;
    }
}
let p = new Person('Ivan Ivanov', 25);
console.log(p.introduction());
console.log(p.sayGoodbye('Petar Petrov'));
//# sourceMappingURL=Person.js.map