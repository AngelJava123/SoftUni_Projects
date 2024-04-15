class Employee {

    private _name: string;
    private _salary: number;
    private _position: string
    private _department: string
    private _email: string
    private _age: number;

    constructor(name: string, salary: number, position: string, department: string, email?: string, age?: number) {
        this._name = name;
        this._salary = salary;
        this._position = position;
        this._department = department;
        this._email = email || 'n/a';
        this._age = age || -1;
    }

    get name(): string {
        return this._name;
    }

    get salary(): number {
        return this._salary;
    }

    get position(): string {
        return this._position;
    }

    get department(): string {
        return this._department;
    }

    get email(): string {
        return this._email;
    }

    get age(): number {
        return this._age;
    }

    // Setters
    set name(name: string) {
        this._name = name;
    }

    set salary(salary: number) {
        this._salary = salary;
    }

    set position(position: string) {
        this._position = position;
    }

    set department(department: string) {
        this._department = department;
    }

    set email(email: string) {
        this._email = email;
    }

    set age(age: number) {
        this._age = age;
    }
}

function addEmployeeToDepartment(employeeInfo: Map<string, Employee[]>, department: string, employee: Employee): void {
    if (!employeeInfo.has(department)) {
        employeeInfo.set(department, []);
    }
    employeeInfo.get(department)!.push(employee);
}

function inputCompany(lines: string[]) {

    let employeeInfo: Map<string, Employee[]> = new Map<string, Employee[]>();

    for (let index = 1; index < lines.length; index++) {
        let input = lines[index].split(" ");

        let name = input[0];
        let salary: number = parseFloat(input[1]);
        let position = input[2];
        let department = input[3];

        if (input.length == 4) {
            let employee = new Employee(name, salary, position, department);
            addEmployeeToDepartment(employeeInfo, department, employee);
        } else if (input.length == 5) {
            if (input[4].includes(".")) {
                let email: string = input[4];
                let employee = new Employee(name, salary, position, department, email);
                addEmployeeToDepartment(employeeInfo, department, employee);
            } else {
                let age: number = parseInt(input[4]);
                let employee = new Employee(name, salary, position, department, 'n/a', age);
                addEmployeeToDepartment(employeeInfo, department, employee);
            }
        } else if (input.length == 6) {
            let email: string = input[4];
            let age: number = parseInt(input[5]);
            let employee = new Employee(name, salary, position, department, email, age);
            addEmployeeToDepartment(employeeInfo, department, employee);
        }
    }
    let departmentHighest: string = '';
    let valueSalary: number = Number.MIN_VALUE;

    for (const [department, employees] of employeeInfo.entries()) {
        let totalSalary = 0;

        for (const employee of employees) {
            totalSalary += employee.salary;
        }
        if (totalSalary > valueSalary) {
            valueSalary = totalSalary;
            departmentHighest = department;
        }
    }
    console.log(`Highest Average Salary: ${departmentHighest}`);

    let result: Map<number, string[]> = new Map<number, string[]>();

    for (const [department, employees] of employeeInfo.entries()) {
        for (const employee of employees) {
            if (department === departmentHighest) {
                if (!result.has(employee.salary)) {
                    result.set(employee.salary, []);
                }
                result.get(employee.salary)!.push(`${employee.name} ${employee.salary.toFixed(2)} ${employee.email} ${employee.age}`);
            }
        }
    }

    let descMapKeys = new Map([...result.entries()].reverse());

    for (const [salary, employees] of descMapKeys.entries()) {
        console.log(employees.toString());
    }
}

const line = [
    '4',
    'Peter 120.00 Dev Development peter@abv.bg 28',
    'Tina 333.33 Manager Marketing 33',
    'Sam 840.20 ProjectLeader Development sam@sam.com',
    'George 0.20 Freeloader Nowhere 18'
];

inputCompany(line);

const line1 = [
    '6',
    'Silver 496.37 Temp Coding silver@yahoo.com',
    'Sam 610.13 Manager Sales',
    'John 609.99 Manager Sales john@abv.bg 44',
    'Venci 0.02 Director BeerDrinking beer@beer.br 23',
    'Andre 700.00 Director Coding',
    'Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey'
];

inputCompany(line1);