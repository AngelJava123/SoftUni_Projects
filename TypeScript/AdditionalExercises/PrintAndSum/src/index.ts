function printAndSum(start: number, end: number): void {
    let sum: number = 0;
    let numbers: string = '';

    for (let i = start; i <= end; i++) {
        numbers += i + ' ';
        sum += i;
    }
    console.log(numbers.trim());
    console.log(`Sum: ${sum}`);
}

printAndSum(5, 10);
printAndSum(0, 26);
printAndSum(50, 60);