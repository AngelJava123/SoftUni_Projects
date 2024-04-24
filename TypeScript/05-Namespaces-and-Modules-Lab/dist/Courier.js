class Courier {
    constructor(placesToVisit) {
        this._placesToVisit = placesToVisit;
    }
    newCustomer(customerName, visited = false) {
        const customer = this._placesToVisit.find(place => place.customerName === customerName);
        if (customer) {
            throw new Error(`${customerName} is already a customer of yours!`);
        }
        else {
            this._placesToVisit.push({ customerName: customerName, visited: false });
            return `${customerName} just became your client.`;
        }
    }
    visitCustomer(customerName) {
        const customer = this._placesToVisit.find(place => place.customerName === customerName);
        if (!customer) {
            throw new Error(`${customerName} is not your customer.`);
        }
        else {
            customer.visited = true;
        }
    }
    showCustomers() {
        return this._placesToVisit.map(place => `${place.customerName} -> ${place.visited}`).join('\n');
    }
}
let courier = new Courier([{ customerName: 'DHL', visited: false }]);
courier.newCustomer('Speedy');
courier.newCustomer('MTM');
courier.newCustomer('TipTop');
courier.visitCustomer('DHL');
courier.visitCustomer('MTM');
courier.visitCustomer('MTM');
console.log(courier.showCustomers());
//# sourceMappingURL=Courier.js.map