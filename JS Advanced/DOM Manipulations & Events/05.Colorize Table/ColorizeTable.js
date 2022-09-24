function colorize() {
    let rowsTable = document.querySelectorAll('table tr');

    for (let i = 1; i < rowsTable.length; i++) {
        if (i % 2 !== 0) {
            rowsTable[i].style.backgroundColor = 'teal'
        }
    }
}