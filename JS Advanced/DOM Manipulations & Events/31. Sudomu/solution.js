function solve() {

    let btn = document.querySelectorAll('button')[0];
    let bt2 = document.querySelectorAll('button')[1];

    btn.addEventListener('click', myFunc);
    bt2.addEventListener('click', myFunc2);

    function myFunc(event) {
        let val1 = document.querySelectorAll('input[type=number]')[0].value;
        let val2 = document.querySelectorAll('input[type=number]')[1].value;
        let val3 = document.querySelectorAll('input[type=number]')[2].value;
        let val4 = document.querySelectorAll('input[type=number]')[3].value;
        let val5 = document.querySelectorAll('input[type=number]')[4].value;
        let val6 = document.querySelectorAll('input[type=number]')[5].value;
        let val7 = document.querySelectorAll('input[type=number]')[6].value;
        let val8 = document.querySelectorAll('input[type=number]')[7].value;
        let val9 = document.querySelectorAll('input[type=number]')[8].value;

        let row1 = false;
        let row2 = false;
        let row3 = false;
        let col1 = false;
        let col2 = false;
        let col3 = false;

        if (val1 !== val2 && val2 !== val3 && val1 !== val3) {
            row1 = true;
        }
        if (val4 !== val5 && val5 !== val6 && val4 !== val6) {
            row2 = true;
        }
        if (val7 !== val8 && val8 !== val9 && val7 !== val9) {
            row3 = true;
        }
        if (val1 !== val4 && val4 !== val7 && val1 !== val7) {
            col1 = true;
        }
        if (val2 !== val5 && val5 !== val8 && val2 !== val8) {
            col2 = true;
        }
        if (val3 !== val6 && val6 !== val9 && val3 !== val9) {
            col3 = true;
        }
        if (row1 && row2 && row3 && col1 && col2 && col3) {
            document.getElementsByTagName('table')[0].style.border = "2px solid green";
            document.querySelectorAll('#check p')[0].style.color = "green";
            document.querySelectorAll('#check p')[0].textContent = "You solve it! Congratulations!";
        } else {
            document.getElementsByTagName('table')[0].style.border = "2px solid red";
            document.querySelectorAll('#check p')[0].style.color = "red";
            document.querySelectorAll('#check p')[0].textContent = "NOP! You are not done yet...";
        }
    }

    function myFunc2(event) {
        document.querySelectorAll('input[type=number]')[0].value = "";
        document.querySelectorAll('input[type=number]')[1].value = "";
        document.querySelectorAll('input[type=number]')[2].value = "";
        document.querySelectorAll('input[type=number]')[3].value = "";
        document.querySelectorAll('input[type=number]')[4].value = "";
        document.querySelectorAll('input[type=number]')[5].value = "";
        document.querySelectorAll('input[type=number]')[6].value = "";
        document.querySelectorAll('input[type=number]')[7].value = "";
        document.querySelectorAll('input[type=number]')[8].value = "";

        document.getElementsByTagName('table')[0].style.border = "none";
        document.querySelectorAll('#check p')[0].style.color = "none";
        document.querySelectorAll('#check p')[0].textContent = "";
    }
}