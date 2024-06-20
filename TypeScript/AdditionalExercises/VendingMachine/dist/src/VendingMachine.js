"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.VendingMachine = void 0;
class VendingMachine {
    drinks = [];
    buttonCapacity;
    constructor(buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
    }
    addDrink(drink) {
        if (this.drinks.length < this.buttonCapacity) {
            this.drinks.push(drink);
        }
    }
    removeDrink(name) {
        const index = this.drinks.findIndex(drink => drink.getName() === name);
        if (index !== -1) {
            this.drinks.splice(index, 1);
            return true;
        }
        return false;
    }
    getLongest() {
        let longestDrink = null;
        this.drinks.forEach(drink => {
            if (!longestDrink || drink.getVolume() > longestDrink.getVolume()) {
                longestDrink = drink;
            }
        });
        return longestDrink ? longestDrink.toString() : '';
    }
    getCheapest() {
        let cheapestDrink = null;
        this.drinks.forEach(drink => {
            if (!cheapestDrink || drink.getPrice() < cheapestDrink.getPrice()) {
                cheapestDrink = drink;
            }
        });
        return cheapestDrink ? cheapestDrink.toString() : '';
    }
    buyDrink(name) {
        const index = this.drinks.findIndex(drink => drink.getName() === name);
        if (index !== -1) {
            const boughtDrink = this.drinks[index];
            return boughtDrink.toString();
        }
        return '';
    }
    getCount() {
        const count = this.drinks.length;
        return count;
    }
    report() {
        const drinksInfo = this.drinks.map(drink => drink.toString()).join('\n');
        return `Drinks available:\n${drinksInfo}`;
    }
}
exports.VendingMachine = VendingMachine;
//# sourceMappingURL=VendingMachine.js.map