class Animal {
    public eat() {
        console.log("eating...");
    }
}

class Dog extends Animal {
    public bark() {
        console.log("barking...")
    }
}

class Cat extends Animal {
    public meow() {
        console.log("meowing...")
    }
}

const dog = new Dog;
const cat = new Cat;

dog.bark();
cat.meow();

dog.eat();
cat.eat();

