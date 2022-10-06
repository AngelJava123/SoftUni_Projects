function validate() {

    let button = document.getElementById('submit');
    document.getElementById("company").addEventListener("change", (e) => {
        if (document.getElementById("company").checked) {
            document.getElementById("companyInfo").style.display = "block";
        } else {
            document.getElementById("companyInfo").style.display = "none";
        }
    });
    button.addEventListener('click', (e) => {
        e.preventDefault();

        let valid = [];

        let checkNamePattern = /^[A-Za-z0-9]{3,20}$/;
        let userName = document.getElementById('username');
        let password = document.getElementById('password');
        let passPatern = /^[\w]{5,15}$/;
        let confirmPassword = document.getElementById('confirm-password');
        let email = document.getElementById('email');
        let emailPatern = /^[^@.]+@[^@]*\.[^@]*$/;
        let company = document.getElementById('company');

        if (!checkNamePattern.test(userName.value)) {
            userName.style.borderColor = "red";
            valid.push(false)
        } else {
            userName.style.borderColor = "none";
            valid.push(true)
        }

        if (!passPatern.test(password.value) || !passPatern.test(confirmPassword.value) || password.value !== confirmPassword.value) {
            password.style.borderColor = "red";
            confirmPassword.style.borderColor = "red";
            valid.push(false)
        } else {
            password.style.borderColor = "none";
            confirmPassword.style.borderColor = "none";
            valid.push(true)
        }

        if (!emailPatern.test(email.value)) {
            email.style.borderColor = "red";
            valid.push(false)
        } else {
            email.style.borderColor = "none";
            valid.push(true)
        }

        if (company.checked) {
            let companyNum = document.getElementById('companyNumber');
            if (Number(companyNum.value) < 1000 || Number(companyNum.value) > 9999) {
                companyNum.style.borderColor = "red";
                valid.push(false)
            } else {
                companyNum.style.borderColor = "none";
                valid.push(true)
            }
        }

        if (!valid.includes(false)) {
            document.querySelector('#valid').style.display = 'block';
        } else {
            document.querySelector('#valid').style.display = 'none';
        }
    });
}
