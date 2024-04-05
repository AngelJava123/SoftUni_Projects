function input(arr: string[]): void {

    for (let index = 0; index < arr.length; index++) {
        const element = arr[index];
        const parts: string[] = element.split(" ");

        let catName = parts[0];
        let catAge = parts[1];

        class Cat {
            name: string;
            age: string;

            constructor(name: string, age: string) {
                this.name = name;
                this.age = age;
            }

            meow() {
                console.log(`${this.name}, age ${this.age} says Meow`)
            }
        }

        const cat = new Cat(catName, catAge);
        cat.meow();
    }
}

input(['Mellow 2', 'Tom 5']);
input(['Candy 1', 'Poppy 3', 'Nyx 2']);
