function calculator() {
    let filled1 = null;
    let filled2 = null;
    let result = null;

    return {
        init,
        add,
        subtract
    }

    function init(f1, f2, res) {
        filled1 = document.querySelector(f1);
        filled2 = document.querySelector(f2);
        result = document.querySelector(res);
    }

    function subtract() {
        result.value = Number(filled1.value) - Number(filled2.value)
    }

    function add() {
        result.value = Number(filled1.value) + Number(filled2.value)
    }
}

const calculate = calculator();
calculate.init('#num1', '#num2', '#result');


