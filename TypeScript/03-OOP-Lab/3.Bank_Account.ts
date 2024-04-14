function processLines(lines: string[]) {

    class BankAccount {
        private _id: number;
        private _balance: number = 0; // Initialize balance to zero
        private _interestRate: number = 0.02; // Initialize interest rate to 2%

        constructor(id: number, initialBalance: number = 0) { // Accept initialBalance as an optional argument
            this._id = id;
            this._balance = initialBalance; // Set initial balance if provided
        }

        public setInterestRate(interest: number) {
            this._interestRate = interest;
        }

        public getInterest(years: number) {
            const interest = this._balance * this._interestRate * years;
            return interest.toFixed(2); // Format the interest to two decimal places
        }

        public setDeposit(balance: number) {
            this._balance += balance;
        }

        public getId() {
            return this._id;
        }
    }

    class TestClient {
        private accounts: Map<number, BankAccount>;
        private nextAccountId: number;

        constructor() {
            this.accounts = new Map<number, BankAccount>();
            this.nextAccountId = 1;
        }

        public createAccount() {
            const account = new BankAccount(this.nextAccountId++);
            this.accounts.set(account.getId(), account);
            console.log(`Account ID${account.getId()} created`);
        }

        public deposit(accountId: number, amount: number) {
            const accountToDeposit = this.accounts.get(accountId);
            if (accountToDeposit) {
                accountToDeposit.setDeposit(amount);
                console.log(`Deposited ${amount} to ID${accountId}`);
            } else {
                console.log(`Account does not exist`);
            }
        }

        public setInterest(interestRate: number) {
            this.accounts.forEach(account => {
                account.setInterestRate(interestRate);
            });
        }

        public getInterest(accountId: number, years: number) {
            const accountToGetInterest = this.accounts.get(accountId);
            if (accountToGetInterest) {
                console.log(`${accountToGetInterest.getInterest(years)}`);
            } else {
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
                const accountId: number = parseInt(tokens[1]);
                const amount: number = parseInt(tokens[2]);
                testClient.deposit(accountId, amount);
                break;
            case 'SetInterest':
                const interestRate = parseFloat(tokens[1]);
                testClient.setInterest(interestRate);
                break;
            case 'GetInterest':
                const accountIdToGetInterest: number = parseInt(tokens[1]);
                const years: number = parseInt(tokens[2]);
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
