import { Drink } from "./Drink";

export class VendingMachine {
    private drinks: Drink[] = [];
    private buttonCapacity: number;

    constructor(buttonCapacity: number) {
        this.buttonCapacity = buttonCapacity;
    }

    addDrink(drink: Drink): void {
        if (this.drinks.length < this.buttonCapacity) {
            this.drinks.push(drink);
        }
    }

    removeDrink(name: string): boolean {
        const index = this.drinks.findIndex(drink => drink.getName() === name);
        if (index !== -1) {
            this.drinks.splice(index, 1);
            return true;
        }
        return false;
    }

    getLongest(): string {
        let longestDrink: Drink | null = null;
        this.drinks.forEach(drink => {
            if (!longestDrink || drink.getVolume() > longestDrink.getVolume()) {
                longestDrink = drink;
            }
        });
        return longestDrink ? longestDrink.toString() : '';
    }

    getCheapest(): string {
        let cheapestDrink: Drink | null = null;
        this.drinks.forEach(drink => {
            if (!cheapestDrink || drink.getPrice() < cheapestDrink.getPrice()) {
                cheapestDrink = drink;
            }
        });
        return cheapestDrink ? cheapestDrink.toString() : '';
    }

    buyDrink(name: string): string {
        const index = this.drinks.findIndex(drink => drink.getName() === name);
        if (index !== -1) {
            const boughtDrink = this.drinks[index];
            return boughtDrink.toString();
        }
        return '';
    }

    getCount(): number {
        const count = this.drinks.length;
        return count;
    }

    report(): string {
        const drinksInfo = this.drinks.map(drink => drink.toString()).join('\n');
        return `Drinks available:\n${drinksInfo}`;
    }
}
