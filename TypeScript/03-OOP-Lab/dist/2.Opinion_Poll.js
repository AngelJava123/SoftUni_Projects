function inputOpinion(PollInfo) {
    const name = PollInfo.split(" ")[0];
    const age = PollInfo.split(" ")[1];
    class Person {
        constructor(name, age) {
            this._name = name;
            this._age = age;
        }
        get name() {
            return this._name;
        }
        set name(name) {
            this._name = name;
        }
        get age() {
            return this._age;
        }
        set age(age) {
            this._age = age;
        }
    }
    const person = new Person(name, age);
    console.log(`${person.name} is ${person.age} years old.`);
}
inputOpinion("Peter 12");
inputOpinion("Sofia 33");
//# sourceMappingURL=2.Opinion_Poll.js.map