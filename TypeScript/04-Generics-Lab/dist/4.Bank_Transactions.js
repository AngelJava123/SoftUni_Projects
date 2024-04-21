class CreateAccount {
}
class PersonalAccount extends CreateAccount {
    constructor(bankName, bankID, ownerName) {
        super();
        this.money = 0;
        this.recentTransactions = {};
        this.bankName = bankName;
        this.bankID = bankID;
        this._ownerName = ownerName;
    }
    deposit(amount) {
        this.money += amount;
    }
    expense(amount, expenseType) {
        if (amount >= 0) {
            if (amount <= this.money) {
                this.money -= amount;
                if (this.recentTransactions.hasOwnProperty(expenseType)) {
                    this.recentTransactions[expenseType] += amount;
                }
                else {
                    this.recentTransactions[expenseType] = amount;
                }
            }
            else {
                throw new Error(`You cant make ${expenseType} transaction`);
            }
        }
        else {
            throw new Error(`Amount must be a positive number`);
        }
    }
    showDetails() {
        let details = `Bank name: ${this.bankName}\n`;
        details += `Bank ID: ${this.bankID}\n`;
        details += `Owner name: ${this._ownerName}\n`;
        details += `Money: ${this.money}\n`;
        let totalMoneySpentOnExpenses = 0;
        for (const expenseType in this.recentTransactions) {
            if (this.recentTransactions.hasOwnProperty(expenseType)) {
                totalMoneySpentOnExpenses += this.recentTransactions[expenseType];
            }
        }
        details += `Money spent: ${totalMoneySpentOnExpenses}`;
        return details;
    }
}
let account = new PersonalAccount('DSK', 101240, 'Ivan Ivanov');
account.deposit(1000);
account.deposit(1000);
account.expense(700, 'Buy new phone');
account.expense(400, 'Book a vacation');
account.expense(400, 'Book a vacation');
account.expense(100, 'Buy food');
console.log(account.showDetails());
let account2 = new PersonalAccount('Fibank', 100000, 'Petar Petrol');
account2.deposit(10000);
account2.deposit(7000);
account2.expense(12000, 'Buy a new car');
account2.expense(200, 'Go to a fancy restaurant');
account2.expense(100, 'Go to a bar');
account2.expense(30, 'Go to the movies');
console.log(account2.showDetails());
//# sourceMappingURL=4.Bank_Transactions.js.map