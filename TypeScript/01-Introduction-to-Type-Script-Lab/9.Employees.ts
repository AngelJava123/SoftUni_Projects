function inputString(arr: string[]): void {

    let result: string[] = [];

    for (let index = 0; index < arr.length; index++) {
        const element = arr[index];

    const count: number = element.length;

    result.push(`Name: ${element} -- Personal Number: ${count}`)
}

for (let i = 0; i < result.length; i++) {
        console.log(result[i]);
    }
}

inputString([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]);

inputString([
    'Samuel Jackson',
    'Will Smith',
    'Bruce Willis',
    'Tom Holland'
    ]);