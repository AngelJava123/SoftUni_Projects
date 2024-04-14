function inputOpinion(PollInfo: string): void {

    const name: string = PollInfo.split(" ")[0];
    const age: string = PollInfo.split(" ")[1];

    class Person {
        private _name: string
        private _age: string

        constructor(name: string, age: string) {
            this._name = name;
            this._age = age;
          }
        
        get name() { 
            return this._name 
        }
    
    
        set name(name: string) {
             this._name = name;
        }
    
        get age() { 
            return this._age
        }
    
    
        set age(age: string) {
             this._age = age;
        }
    }

    const person = new Person(name, age);
    console.log(`${person.name} is ${person.age} years old.`)

}

inputOpinion("Peter 12");
inputOpinion("Sofia 33");

