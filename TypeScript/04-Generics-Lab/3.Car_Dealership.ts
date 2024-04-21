interface Dealership<T> {
    dealershipName: T;
    soldCars: number;
}

interface Actions<T, U> {
    sellCar(dealerID: T, model: U): void;
}

class CarDealership<T, U> implements Dealership<T>, Actions<T, U> {

    private modelsSold: { [key: string]: U } = {};
    private _dealershipName: T;
    private _soldCars: number = 0;

    constructor(dealershipName: T) {
        this._dealershipName = dealershipName;
    }

    get dealershipName(): T {
        return this._dealershipName;
    }

    get soldCars(): number {
        return this._soldCars;
    }

    sellCar(dealerID: T, model: U): void {
        this._soldCars++;
        this.modelsSold[dealerID.toString()] = model;
    }

    showDetails(): string {
        let details = `${this.dealershipName}:\n`;
        const dealerIDs = Object.keys(this.modelsSold);
        dealerIDs.forEach((dealerID, index) => {
            details += `${dealerID} sold ${this.modelsSold[dealerID]}`;

            if (index !== dealerIDs.length - 1) {
                details += '\n';
            }
        });
        return details;
    }
}

let dealership = new CarDealership('SilverStar');

dealership.sellCar('BG01', 'C Class');
dealership.sellCar('BG02', 'S Class');
dealership.sellCar('BG03', 'ML Class');
dealership.sellCar('BG04', 'CLK Class');
console.log(dealership.showDetails());
