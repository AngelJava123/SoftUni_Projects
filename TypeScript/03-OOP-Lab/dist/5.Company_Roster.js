class Employee {
    constructor(name, salary, position, department, email, age) {
        this._name = name;
        this._salary = salary;
        this._position = position;
        this._department = department;
        this._email = email || 'n/a';
        this._age = age || -1;
    }
    get name() {
        return this._name;
    }
    get salary() {
        return this._salary;
    }
    get position() {
        return this._position;
    }
    get department() {
        return this._department;
    }
    get email() {
        return this._email;
    }
    get age() {
        return this._age;
    }
    // Setters
    set name(name) {
        this._name = name;
    }
    set salary(salary) {
        this._salary = salary;
    }
    set position(position) {
        this._position = position;
    }
    set department(department) {
        this._department = department;
    }
    set email(email) {
        this._email = email;
    }
    set age(age) {
        this._age = age;
    }
}
function addEmployeeToDepartment(employeeInfo, department, employee) {
    if (!employeeInfo.has(department)) {
        employeeInfo.set(department, []);
    }
    employeeInfo.get(department).push(employee);
}
function inputCompany(lines) {
    let employeeInfo = new Map();
    for (let index = 1; index < lines.length; index++) {
        let input = lines[index].split(" ");
        let name = input[0];
        let salary = parseFloat(input[1]);
        let position = input[2];
        let department = input[3];
        if (input.length == 4) {
            let employee = new Employee(name, salary, position, department);
            addEmployeeToDepartment(employeeInfo, department, employee);
        }
        else if (input.length == 5) {
            if (input[4].includes(".")) {
                let email = input[4];
                let employee = new Employee(name, salary, position, department, email);
                addEmployeeToDepartment(employeeInfo, department, employee);
            }
            else {
                let age = parseInt(input[4]);
                let employee = new Employee(name, salary, position, department, 'n/a', age);
                addEmployeeToDepartment(employeeInfo, department, employee);
            }
        }
        else if (input.length == 6) {
            let email = input[4];
            let age = parseInt(input[5]);
            let employee = new Employee(name, salary, position, department, email, age);
            addEmployeeToDepartment(employeeInfo, department, employee);
        }
    }
    let departmentHighest = '';
    let valueSalary = Number.MIN_VALUE;
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
    let result = new Map();
    for (const [department, employees] of employeeInfo.entries()) {
        for (const employee of employees) {
            if (department === departmentHighest) {
                if (!result.has(employee.salary)) {
                    result.set(employee.salary, []);
                }
                result.get(employee.salary).push(`${employee.name} ${employee.salary.toFixed(2)} ${employee.email} ${employee.age}`);
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
//# sourceMappingURL=5.Company_Roster.js.map