function evenPositions(numbers: string[]): string {

    let result: string = '';

    for (let index = 0; index < numbers.length; index++) {
        if (index % 2 == 0) {
            result = result.concat(numbers[index] + ' ');
        }
    }
    return result.trim();
    
}

console.log(evenPositions(['20', '30', '40', '50', '60']));
console.log(evenPositions(['5', '10']));