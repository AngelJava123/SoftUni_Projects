function aggregate(arr: number[]): void {

    let sumation = 0;
    let inverseSum = 0;
    let concatenation = '';

    for (let index = 0; index < arr.length; index++) {
        const element = arr[index];
        
        sumation += element;
        inverseSum += 1 / element;
        concatenation += element.toString();
    }

    console.log(sumation);
    console.log(inverseSum);
    console.log(concatenation);

}

aggregate([1, 2, 3]);
aggregate([2, 4, 8, 16]);