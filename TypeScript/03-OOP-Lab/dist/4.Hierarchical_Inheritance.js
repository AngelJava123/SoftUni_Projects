class Animal {
    eat() {
        console.log("eating...");
    }
}
class Dog extends Animal {
    bark() {
        console.log("barking...");
    }
}
class Cat extends Animal {
    meow() {
        console.log("meowing...");
    }
}
const dog = new Dog;
const cat = new Cat;
dog.bark();
cat.meow();
dog.eat();
cat.eat();
//# sourceMappingURL=4.Hierarchical_Inheritance.js.map