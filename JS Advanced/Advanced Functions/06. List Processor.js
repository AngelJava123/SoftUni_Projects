function solve(arr) {

    let result = [];

    for (const item of arr) {
        let [command, str] = item.split(' ');

        if (command === 'add') {
            result.push(str)
        } else if (command === 'remove') {
            for (let i = result.length - 1; i >= 0; i--) {
                if (result[i] === str) {
                    result.splice(i, 1);
                }
            }
        } else if (command === 'print') {
            console.log(result.join(','))
        }
    }
}



solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);
solve(['add pesho', 'add george', 'add peter', 'remove peter', 'print']);