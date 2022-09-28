function solve() {

    let button = document.querySelector('button');
    let result = document.getElementById('result');

    let selectMenuTo = document.getElementById('selectMenuTo');
    let optionBinary = document.createElement('option');
    optionBinary.value = 'binary';
    optionBinary.innerHTML = 'Binary';
    let optionHexadecimal = document.createElement('option');
    optionHexadecimal.value = 'hexadecimal';
    optionHexadecimal.innerHTML = 'Hexadecimal';
    selectMenuTo.appendChild(optionBinary);
    selectMenuTo.appendChild(optionHexadecimal);

    button.addEventListener("click", myFunction);

    function myFunction() {
        let number = Number(document.querySelector('input[type=number]').value);
        let value = document.querySelector('#selectMenuTo').value;
        if (value === 'binary') {
            result.value = number.toString(2);
        } else if (value === 'hexadecimal') {
            result.value = number.toString(16).toUpperCase();
        }
    }
}