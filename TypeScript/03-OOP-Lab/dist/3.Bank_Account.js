function processLines(lines) {
    class BankAccount {
        constructor(id, initialBalance = 0) {
            this._balance = 0; // Initialize balance to zero
            this._interestRate = 0.02; // Initialize interest rate to 2%
            this._id = id;
            this._balance = initialBalance; // Set initial balance if provided
        }
        setInterestRate(interest) {
            this._interestRate = interest;
        }
        getInterest(years) {
            const interest = this._balance * this._interestRate * years;
            return interest.toFixed(2); // Format the interest to two decimal places
        }
        setDeposit(balance) {
            this._balance += balance;
        }
        getId() {
            return this._id;
        }
    }
    class TestClient {
        constructor() {
            this.accounts = new Map();
            this.nextAccountId = 1;
        }
        createAccount() {
            const account = new BankAccount(this.nextAccountId++);
            this.accounts.set(account.getId(), account);
            console.log(`Account ID${account.getId()} created`);
        }
        deposit(accountId, amount) {
            const accountToDeposit = this.accounts.get(accountId);
            if (accountToDeposit) {
                accountToDeposit.setDeposit(amount);
                console.log(`Deposited ${amount} to ID${accountId}`);
            }
            else {
                console.log(`Account does not exist`);
            }
        }
        setInterest(interestRate) {
            this.accounts.forEach(account => {
                account.setInterestRate(interestRate);
            });
        }
        getInterest(accountId, years) {
            const accountToGetInterest = this.accounts.get(accountId);
            if (accountToGetInterest) {
                console.log(`${accountToGetInterest.getInterest(years)}`);
            }
            else {
                console.log(`Account does not exist`);
            }
        }
    }
    const testClient = new TestClient();
    for (const line of lines) {
        const tokens = line.trim().split(' ');
        const command = tokens[0];
        switch (command) {
            case 'Create':
                testClient.createAccount();
                break;
            case 'Deposit':
                const accountId = parseInt(tokens[1]);
                const amount = parseInt(tokens[2]);
                testClient.deposit(accountId, amount);
                break;
            case 'SetInterest':
                const interestRate = parseFloat(tokens[1]);
                testClient.setInterest(interestRate);
                break;
            case 'GetInterest':
                const accountIdToGetInterest = parseInt(tokens[1]);
                const years = parseInt(tokens[2]);
                testClient.getInterest(accountIdToGetInterest, years);
                break;
            case 'End':
                break;
            default:
                console.log('Invalid command');
        }
    }
}
const lines = [
    'Create',
    'Deposit 1 20',
    'GetInterest 1 10',
    'End'
];
processLines(lines);
const lines2 = [
    'Create',
    'Create',
    'Deposit 1 20',
    'Deposit 3 20',
    'Deposit 2 10',
    'SetInterest 1.5',
    'GetInterest 1 1',
    'GetInterest 2 1',
    'GetInterest 3 1',
    'End'
];
processLines(lines2);
//# sourceMappingURL=3.Bank_Account.js.map