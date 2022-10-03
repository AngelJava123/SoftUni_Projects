function solve(...params) {

    for (const item of params) {
        console.log(`${typeof (item)}: ${item}`)
    }

    let countDtypes = (params) => {
        return params.reduce((acc, curr) => {

            // Check if the acc contains the type or not
            if (acc[typeof curr]) {

                // Increase the type with one
                acc[typeof curr]++;
            } else {

                /* If acc not contains the type
                then initialize the type with one */
                acc[typeof curr] = 1
            }
            return acc
        }, {}); // Initialize with an empty array
    }

    let buff = "";
    let countObj = countDtypes(params);
    for (const [key, val] of Object.entries(countObj)) {
        buff += `${key} = ${val}\n`
    }
    console.log(buff)
}

solve('cat', 42, function () { console.log('Hello world!'); });
