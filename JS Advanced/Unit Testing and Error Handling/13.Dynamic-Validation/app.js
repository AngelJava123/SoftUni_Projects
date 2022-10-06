function validate() {

    let input = document.getElementById('email');
    input.addEventListener('change', myFunc);

    function myFunc(event) {
        let valid = /[A-Za-z0_9]+@[A-Za-z0-9]+\.[A-Za-z]+/g
        let email = event.target.value;
        if (valid.test(email)) {
            event.target.classList.remove('error')
        } else {
            event.target.classList.add('error')
        }
    }
}