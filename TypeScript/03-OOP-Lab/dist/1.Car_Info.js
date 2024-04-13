function inputCar(carInfo) {
    const br = carInfo.split(" ")[0];
    const mod = carInfo.split(" ")[1];
    const hp = parseInt(carInfo.split(" ")[2]);
    class Car {
        constructor(brand, model, horsepower) {
            this._brand = brand;
            this._model = model;
            this._horsepower = horsepower;
        }
        get brand() {
            return this._brand;
        }
        set brand(brand) {
            this._brand = brand;
        }
        get model() {
            return this._model;
        }
        set model(model) {
            this._model = model;
        }
        get horsepower() {
            return this._horsepower;
        }
        set horsepower(horsepower) {
            this._horsepower = horsepower;
        }
    }
    const car = new Car(br, mod, hp);
    console.log(`The car is: ${car.brand} ${car.model} - ${car.horsepower} HP.`);
}
inputCar("Chevrolet Impala 390");
inputCar("Skoda Karoq 150");
//# sourceMappingURL=1.Car_Info.js.map