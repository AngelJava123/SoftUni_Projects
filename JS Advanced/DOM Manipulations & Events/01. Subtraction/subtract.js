function subtract() {

    let num1 = document.getElementById('firstNumber').value;
    let num2 = document.getElementById('secondNumber').value;

    let res = Number(num1) - Number(num2);

    document.getElementById('result').innerText = res;
    console.log(res);
}