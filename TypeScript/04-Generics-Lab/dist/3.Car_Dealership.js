class CarDealership {
    constructor(dealershipName) {
        this.modelsSold = {};
        this._soldCars = 0;
        this._dealershipName = dealershipName;
    }
    get dealershipName() {
        return this._dealershipName;
    }
    get soldCars() {
        return this._soldCars;
    }
    sellCar(dealerID, model) {
        this._soldCars++;
        this.modelsSold[dealerID.toString()] = model;
    }
    showDetails() {
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
//# sourceMappingURL=3.Car_Dealership.js.map