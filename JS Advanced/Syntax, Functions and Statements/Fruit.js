function solve(type, weight, price) {

    let kilos = weight / 1000;
    let totalPrice = Number(kilos) * Number(price);

    console.log(`I need $${totalPrice.toFixed(2)} to buy ${kilos.toFixed(2)} kilograms ${type}.`)
}

solve('orange', 2500, 1.80);

solve('apple', 1563, 2.35);