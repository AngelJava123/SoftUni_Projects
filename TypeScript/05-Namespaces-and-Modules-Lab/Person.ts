class Person implements Greeter.Greeting {

    private _name: string;
    private _age: number;

    constructor(name: string, age: number) {
        this._name = name;
        this._age = age;
    }


    introduction(): string {
        return `My name is ${this._name} and I am ${this._age} years old.`;
    }

    sayGoodbye<T>(name: T): string {
        return `Dear ${name}, it was a pleasure meeting you!`
    }
}

let p = new Person('Ivan Ivanov', 25);

console.log(p.introduction());
console.log(p.sayGoodbye('Petar Petrov'));
