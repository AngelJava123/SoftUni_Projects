function validate() {
    let mail = document.getElementById('email');

    mail.addEventListener('change', checkMail);

    function checkMail(event) {
        if (/^([\w\-.]+)@([a-z]+)(\.[a-z]+)+$/.test(event.target.value)) {
            event.target.removeAttribute('class');
            return;
        }
        event.target.className = 'error';
    }
}