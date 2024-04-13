function inputCar(carInfo: string): void {

    const br: string = carInfo.split(" ")[0];
    const mod: string = carInfo.split(" ")[1];
    const hp: number = parseInt(carInfo.split(" ")[2]);

    class Car {
        private _brand: string
        private _model: string
        private _horsepower: number

        constructor(brand: string, model: string, horsepower: number) {
            this._brand = brand;
            this._model = model;
            this._horsepower = horsepower;
        }

        get brand() {
            return this._brand
        }


        set brand(brand: string) {
            this._brand = brand;
        }

        get model() {
            return this._model
        }


        set model(model: string) {
            this._model = model;
        }

        get horsepower() {
            return this._horsepower
        }


        set horsepower(horsepower: number) {
            this._horsepower = horsepower;
        }
    }

    const car = new Car(br, mod, hp);
    console.log(`The car is: ${car.brand} ${car.model} - ${car.horsepower} HP.`)

}

inputCar("Chevrolet Impala 390");
inputCar("Skoda Karoq 150");

