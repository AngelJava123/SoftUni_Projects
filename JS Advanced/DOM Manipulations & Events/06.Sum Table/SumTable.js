function sumTable() {
    let products = document.querySelectorAll('table tr');

    let sum = 0;

    for (let i = 1; i < products.length - 1; i++) {
        let cols = products[i].children;

        sum += Number(cols[1].textContent);
    }

    document.getElementById('sum').innerText = sum;
}